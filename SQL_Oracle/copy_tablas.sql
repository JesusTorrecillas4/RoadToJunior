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






DROP TABLE copy_employees CASCADE CONSTRAINT PURGE;