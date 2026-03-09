SET SERVEROUTPUT ON;

--Truco para crear una copia de la tabla. (employees)

CREATE TABLE copy_employees AS 
    SELECT * FROM employees;
    
    
/* TIPO: Procedimiento
NOMBRE: proc_increase_salary
INPUT: p_incr NUMBER, p_max_salary NUMBER
DESC: El procedimiento recibe un % de incremento (p_incr) y un salario maximo.
Al ejecutarse, se tendra que actualizar todos los sueldo de los empleados 
que no superen el limite maximo. El incremetno corresponde al p_incr
Retornar un mensaje con el numero de empleados actualizados
IMPORTANTE!! Hacer el procedure sobre la tabla copy_empoyees
*/
/
CREATE OR REPLACE PROCEDURE proc_increase_salary(p_incr NUMBER, p_max_salary NUMBER) 
IS
   v_count NUMBER; 
BEGIN
    SELECT COUNT(*)
    INTO v_count
    FROM copy_employees
    WHERE salary <= p_max_salary;
    
    UPDATE copy_employees SET salary = salary+(salary*p_incr) WHERE salary <= p_max_salary;
    
    
    
    DBMS_OUTPUT.PUT_LINE('Se han actualizado: ' ||v_count|| ' salarios');
    
    COMMIT;
END;

/
EXEC proc_increase_salary(0.1,10000);
/
SELECT emp.first_name, emp.last_name, emp.salary, copy.salary
FROM employees emp
JOIN copy_employees copy ON (emp.employee_id = copy.employee_id);
/

--Copia la tabla de job_history
CREATE TABLE copy_job_history AS
 SELECT * FROM job_history;

/*

TIPO: Procedimiento
NOMBRE: proc_Update_emp
INPUT: p_empid NUMEBR, p_depid NUMBER, p_jobid VARCHAR2
DESC: El procediemineto actualizara el departametno y/o el job del empleado que
corresponde a los ids de entrada

CONTROLES:
    -Si p_depid es NULL - No lo actualices
    -Si p_jobid es NULL - No lo actualices
    -Si el nuevo dep o job no existe, lanza el mesnaje de error y no actualices
    -Si el emp_id no existe, lanza mesanje de error
    -Si puedes actualizar el dep y/o el job, inserta en la tabla
    copy_job_history los datos antiguos
    RECUERDA!!! Actualiza tambien el nuevo hire_date de employees
*/
/
CREATE OR REPLACE PROCEDURE proc_update_emp( p_empid NUMBER, p_depid NUMBER, p_jobid VARCHAR2)
IS
    v_hire_date DATE;
    v_depid NUMBER;
    v_jobid VARCHAR2(200);
    
BEGIN
    --Busco job y dep para ver si existe
    /*
    -Si el nuevo dep o job no existe, lanza el mesnaje de error y no actualices
    -Si el emp_id no existe, lanza mesanje de error
    -Si puedes actualizar el dep y/o el job, inserta en la tabla
    */
    SELECT job_id INTO v_jobid FROM jobs WHERE job_id = p_jobid;
    SELECT department_id INTO v_depid FROM departments WHERE department_sid = p_depid;
    --Busco info del empleado
        SELECT hire_date, department_id, job_id
        INTO v_hire_date,v_depid, v_jobid
        FROM copy_employees
        WHERE employee_id = p_empid;
    
    --Actualizo empleado
    UPDATE copy_employees SET department_id = p_depid, job_id= p_jobid, hire_Date = SYSDATE WHERE employee_id = p_empid;
    
    
    --Inserto el job_history
    INSERT INTO copy_job_history VALUES(p_empid,v_hire_date,SYSDATE,,v_jobid,v_depid);
END;
/
--Ahora lo mismo pero con controles de errores
/
CREATE OR REPLACE PROCEDURE proc_update_emp( p_empid NUMBER, p_depid NUMBER, p_jobid VARCHAR2)
IS
    v_hire_date DATE;
    v_depid NUMBER;
    v_jobid VARCHAR2(200);
    
BEGIN
    --Busco info del empleado
        SELECT hire_date, department_id, job_id
        INTO v_hire_date,v_depid, v_jobid
        FROM copy_employees
        WHERE employee_id = p_empid;
    
    --Actualizo empleado
    --Con NVL hacemos estos dos
    --Si p_depid es NULL - No lo actualices
    --Si p_jobid es NULL - No lo actualices
    UPDATE copy_employees SET department_id = NVL(p_depid,departemnt_id),
    job_id= NVL(p_jobid,job_id), 
    hire_Date = SYSDATE
    WHERE employee_id = p_empid;
    
    
    --Inserto el job_history
    INSERT INTO copy_job_history VALUES(p_empid,v_hire_date,SYSDATE,,v_jobid,v_depid);
    DBMS_OUTPUT.PUT_LINE('OK - Empleado actualizado');
EXCEPTION
    WHEN no_data_found THEN
        DBMS_OUTPUT.PUT_LINE('Error - registro no encontrado');
END;
/
/*
TIPO: PROCEDIMIENTO
NOMBRE: p_incr_salary
INPUT: p_empid NUMBER, p_amount NUMBER
DESC:
    El procedimiento actualizara el salario del empleado incrementandolo
    en la cantidad de p_amount. Al finalizar el proceso se mostrara el
    nombre y apellido del empleado, el salario anterior y el nuevo salario
    
CONTROLES:
    - Si el empleado no existe, se muestra un error
    - Si se le pasa al procedimineto un p_amount negativo, se muestra un error
    - Si p_amount es NULL, el salario no se modifica
*/
/
CREATE OR REPLACE PROCEDURE p_incr_salary(p_empid NUMBER, p_amount NUMBER)
IS
    v_fn VARCHAR2(200);
    v_ln VARCHAR2(200);
    v_salary NUMBER;
    v_nuevo NUMBER;
    --Csutom EXCEPTION
    e_negativo EXCEPTION;
BEGIN
        IF p_amount < 0 THEN RAISE e_negativo; END IF;
        
        SELECT first_name, last_name, salary
        INTO v_fn, v_ln, v_salary
        FROM copy_employees
        WHERE employee_id = p_empid;
    

        UPDATE copy_employees SET salary = salary + NVL(p_amount,0)
        WHERE employee_id = p_empid;
        
        v_nuevo := v_salary + NVL(p_amount,0);
        
        DBMS_OUTPUT.PUT_LINE('Empleados'||v_fn||v_ln);
        DBMS_OUTPUT.PUT_LINE('Salario original:'||v_salary);
        DBMS_OUTPUT.PUT_LINE('Salario modificad:'||v_nuevo);

EXCEPTION
    WHEN e_negativo THEN
        DBMS_OUTPUT.PUT_LINE('Error - Incremento en negativo');
    WHEN no_data_found THEN
        DBMS_OUTPUT.PUT_LINE('Error - No data found');
END;
/
EXEC p_incr_salary(100,500);
/
/*
Tipo: funcion
Nombre: funcion_check_salary
INPUT: p_employee_id NUMBER
OUTPUT: boolean
DESC: Comprueba si el salario del empleado esta dentnro 
de los limites de los salarios Minimos y Maximo de su Job
Si el empleado no tiene job, retorna TRUE*
*/
/
CREATE OR REPLACE FUNCTION funcion_check_salary(p_employee_id NUMBER)
RETURN BOOLEAN
IS

     v_sal NUMBER;
     v_job_id NUMBER;
     v_min NUMBER;
     v_max NUMBER;
     
BEGIN
    
    SELECT salary, job_id
    INTO v_sal, v_job_id
    FROM employees WHERE employee_id = p_employee_id;
    
    IF v_job_id IS NULL THEN RETURN TRUE;
    END IF;
    
    SELECT min_salary, max_salary 
    INTO v_min, v_max
    FROM jobs WHERE job_id = v_job_id;
    
    IF v_sal BETWEEN v_min AND v_max THEN RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
    
END;
/



BEGIN
    IF funcion_check_salary(203) THEN
        DBMS_OUTPUT.PUT_LINE('Dentro de rango');
    ELSIF NOT funcion_check_salary(203) THEN
        DBMS_OUTPUT.PUT_LINE('Fuera del rango');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Error');
    END IF;

END;
/
BEGIN
    IF false THEN
        DBMS_OUTPUT.PUT_LINE('es ciert!');
    ELSIF NOT(false) THEN
        DBMS_OUTPUT.PUT_LINE('era falso!');
    END IF;

END;
/


/
/*
TIPO:Funcion
Nombre: proc_debug_emp_salary
INPUT: p_employee_id NUMBER
DESCR: Revisa si el salario del empleado esta en los limites de
    su maximo y minimo por job
    - Si el salario del empleado esta pir debajo del minimo,
    lo actualizara al salario minimo
    - Si el salario esta por enima del maximo, lo actualizara al salario maximo
    -Si esta enre los limites, no hace nada
    
Muestra mensajes de cada accion del procedimiento, y guarda los cambios en una linea
de la tabla de logs (si ha habido algun cambio en el salario)
*/

CREATE TABLE daw_logs(

    id_law_log NUMBER,
    table_name VARCHAR2(100),
    creation_date DATE,
    action VARCHAR2(200),
    descrition VARCHAR2(600)
);

CREATE SEQUENCE seq_daw_logs2 START WITH 1 INCREMENT BY 1;

SELECT seq_daw_logs2.currval FROM dual;

/
/*
Tipo: Funcion
nombre: calculadora_diferencia_salarial
parametro: p_employee_id NUMBER
DESC:  La funcion deve recibir el ID de un empleado y calcular la diferencia entre 
su salario actual y el salario maximo permitido para su puesto(max_salary d la tabla jobs)
-Debe devolver un valor positivo si el empleado aun puede subir de sueldo
debe devolver 0 si ya esta en el maximo por encima
Control de errores: Si el p_employee_id no existe, debe capturar la exprsion no_data_found y devolver un -1
Cualquier otro error inesperado debe devolver -99
*/
/
CREATE OR REPLACE FUNCTION calcu_difa_salarial(p_emp_id NUMBER)
RETURN NUMBER
IS
    /*
    v_fn VARCHAR2(200);
    v_salary NUMBER;
    v_max_salary NUMBER;*/
    v_resto NUMBER;

BEGIN

    SELECT NVL(jo.max_salary - emp.salary,0) INTO v_resto
            FROM employees emp LEFT JOIN jobs jo ON (emp.job_id = jo.job_id)
        WHERE emp.employee_id = p_emp_id;
    
            RETURN v_resto;
   /* 
    SELECT emp.first_name, emp.salary, job.max_salary
    INTO v_fn, v_salary, v_max_salary
    FROM employees emp JOIN jobs job ON (emp.job_id = job.job_id)
    WHERE emp.employee_id = p_employee_id;*/
    
   /* IF emp.salary > job.max_salary THEN
    RETURN 0 
    ELSIF emp.salary <= job.max_salary THEN 
    RETURN (v_max_salary-v_salary)
    ELSIF */
    
EXCEPTION

    WHEN no_data_found THEN
    RETURN -1;
    WHEN OTHERS THEN
    RETURN -99;

END;
/

SELECT calcu_difa_salarial (100) FROM dual;

/

/*
Tipo: procedure
Nombre act_ubi_dep
parametros: p_department_id NUMBER, P_new_location_id NUMBER
DESCR: El procedimiento deve cambiar la localizacion de un departamento 
especifico en la tabla DEPARTMENTS. Antes de realizar el UPDATE, el codigo debe
verificar:
que el departamento existe
- Que la nueva localizacion existe en la tabla LOCATIONS
Si ambas condiciones se cumple, se aplica el cambio y se imprime por
consola (DBMS_OUTPUT) un mensaje de escito indicando el nombre del departamento afectado

CONTROL DE ERORES:
- Sila localizacion no existe, debe lanzar un error personalizado
- Si el departamento no existe, debe mostrar un mensaje informativo y no realiza
nunguna accion
*/

CREATE TABLE copy_departments AS
SELECT * FROM departments;



