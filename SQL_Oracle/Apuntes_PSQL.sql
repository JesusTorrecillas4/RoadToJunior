
--Tutorial PLSQL

-- Activar salida de mesnajes por terminal (hay que hacerlo en cada session)
SET SERVEROUTPUT ON;
-- Ejemplo de bloque anonimo
-- Busca el salario del empleado 150 y muestralo por terminal
--Sintaxis
DECLARE
--Variables
    v_salario NUMBER;
BEGIN
--Codigo
    -- hago la select
    SELECT salary
    INTO v_salario
    FROM employees
    WHERE employee_id = 150;
    
    -- Mensaje por terminal
    DBMS_OUTPUT.PUT_LINE('El salario del 150 es ' || v_salario);
    
END;
/

-- Muestra el nombre y apellido del empleado 100
DECLARE
    v_fn VARCHAR2(200);
    v_ln VARCHAR2(200);
    
BEGIN

    --Busco
    SELECT first_name, last_name 
    INTO v_fn, v_ln
    FROM employees
    WHERE employee_id IN (100);
    
    --MUESTRO
    DBMS_OUTPUT.PUT_LINE('El nombre y apellido del 100 son'||' ' || v_fn||' '||v_ln);
END;
/
--Preocedimiento para simplificar la impersion de textos
CREATE OR REPLACE PROCEDURE p_print (texto VARCHAR2)
IS
    --Variables. Pero no necesito poner ahora.
BEGIN
    DBMS_OUTPUT.PUT_LINE(texto);
END;
/

-- Bloque anónimo de "hola mundo"

DECLARE
    v_texto VARCHAR2(200);
BEGIN
    v_texto := 'Hola Mundo';
    p_print(v_texto);
    --O te ahorras el declare y la variable y simplemente pones esto
   -- p_print('Hola Mundo');
END;
/

--ejemplo bloque anonimo
--Declarar una variable numerica v_loc_id con valor 1700
--Muestra el nombre de la ciudad y el CP
--Muestra en otro mensaje el numero de empleados de esa localizacion

DECLARE
 v_loc_id NUMBER := 1700;
 v_salida VARCHAR2(200);
 v_count NUMBER;
 BEGIN
 SELECT loc.city || '-' || loc.postal_code, COUNT(*) 
 INTO v_salida, v_count
  FROM locations loc 
  LEFT JOIN departments dep ON (dep.location_id = loc.location_id)
  LEFT JOIN employees emp ON (dep.department_id = emp.department_id)
  WHERE loc.location_id = v_loc_id
  GROUP BY loc.city || '-' || loc.postal_code;
  
  DBMS_OUTPUT.PUT_LINE(v_salida);
   DBMS_OUTPUT.PUT_LINE('Numero de empleados: ' ||v_count);
/*--Nueva select
SELECT COUNT(*) INTO v_count
FROM employees emp
RIGHT JOIN departments dep ON (dep.department_id = emp.department_id)
RIGHT JOIN locations loc ON (loc.location_id = dep.location_id)
WHERE loc.location_id = v_loc_id;*/
   
   /*DBMS_OUTPUT.PUT_LINE(v_salida);
   DBMS_OUTPUT.PUT_LINE(v_count);*/
  END;
 /
/*
    TIPO: PROCEDURE
    NOMBRE: proc_emp_info
    P_ENTRADA: p_emp_id NUMBER
    DESC: Crea un proc al que le pasen un id empleado y muestre por
    mensaje de texto su nombre, apellido y antiguedad (en años) dentor de 
    la empresa

*/
/
CREATE OR REPLACE PROCEDURE proc_emp_info(p_emp_id NUMBER)
IS
    v_fn VARCHAR2(200);
    v_ln VARCHAR2(200);
    v_ant NUMBER;
BEGIN
--Buscar info del empleado
 SELECT first_name, last_name, ROUND((SYSDATE-hire_date)/365)
    INTO v_fn, v_ln, v_ant
FROM employees 
WHERE employee_id = p_emp_id;

    DBMS_OUTPUT.PUT_LINE(v_fn);
    DBMS_OUTPUT.PUT_LINE(v_ln);
    DBMS_OUTPUT.PUT_LINE(v_ant);
END;
/

EXEC proc_emp_info(100);
--Funcion
--Estructura que almacena codigo y se puede ejecutar al llamarlo
--y RETORNA UN VALOR
--Sintaxis
CREATE OR REPLACE FUNCTION <nombre_funcion> [(param1 tipo, param2 tipo ...)]
RETURN <tipo_dato>
IS
 --Variables
BEGIN
  --codigo
RETURN <algo>;
  [EXCEPTION]
    --excepcion
END;
/
--ejemplo: Crea una funcion que devuelva(retorne) tu nombre. Llamala f_owner
CREATE OR REPLACE FUNCTION f_owner RETURN VARCHAR2
IS
BEGIN
    RETURN 'JesusT';
END;
/

--ejercicio 3: Funcion que reciba un nombre y apellido, y retorne
-- sus iniciales separadas por un punto. Nombre: f_iniciales
CREATE OR REPLACE FUNCTION f_iniciales (p_fn VARCHAR2, p_ln VARCHAR2)
RETURN VARCHAR2
IS
 /* v_fn VARCHAR2(1);
  v_ln VARCHAR2(1);
  v_resultado VARCHAR2(3);*/
BEGIN
    /*v_fn := SUBSTR(p_fn,1,1);
    v_ln := SUBSTR(p_ln,1,1);
    v_resultado := v_fn||'-'||v_ln;*/
    RETURN SUBSTR(p_fn,1,1)||'-'||(p_ln,1,1);
END;
/

SELECT f_iniciales(first_name, last_name), first_name, last_name
FROM employees;

/*
    Crea una funcion a la que se le pasen in location_id
    y nos retorne el numero de trabajadores que hay en esa 
    location. Nombre: f_count_locemps


*/

-- Control de flujo - IF - ELSIF - ELSE
/*
    [0-4)
    [4-5)
    [5-10]
*/
CREATE OR REPLACE PROCEDURE proc_resultado(p_nota NUMBER)
IS
BEGIN
    IF (p_nota >= 0 AND p_nota < 4) THEN
        DBMS_OUTPUT.PUT_LINE('Suspende');
    ELSIF (p_nota < 5) THEN
        DBMS_OUTPUT.PUT_LINE('Hace media');
    ELSIF (p_nota <= 10) THEN
        DBMS_OUTPUT.PUT_LINE('FELICIDADES');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Nota fuera de rango');
    END IF;
END;
/

EXEC proc_resultado(10);

/*
Tipo: funcion
Nombre: func_check_salary
INPUT: p_employee_id NUMBER
OUTPUT: boolean
DESC: Comprueba si el salario del empleado esta dentro de los limites de los
salarios Minimo y Maximo de su JOB. Si el empleado no tiene job, retorna TRUE
*/
-- Busca salario y job del empleado
-- Busca salario minimo y maximo del job
-- Comparamos salario empleado con el minimo y el maximo
-- Retornamos TRUE o FALSE
CREATE OR REPLACE FUNCTION func_check_salary (p_employee_id NUMBER)
RETURN BOOLEAN
IS
    v_sal NUMBER;
    v_job_id NUMBER;
    v_min NUMBER;
    v_max NUMBER;
BEGIN
    SELECT emp.salary, j.job_id, j.min_salary, j.max_salary
    INTO v_sal, v_job_id, v_min, v_max
    FROM employees emp LEFT JOIN jobs j ON (emp.job_id = j.job_id)
    WHERE employee_id = p_employee_id;
   
    IF v_job_id IS NULL THEN
        RETURN TRUE;
    ELSIF v_sal BETWEEN v_min AND v_max THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END;
/

--TIPO: Procedure
--NOMBRE: proc_emp_sumary
--INPUTS: p_emp_id NUMBER
--DESC: el procedicimpietno recive un empleado y se insertara su informacion
--el tabla de EMP_SUMARY

CREATE TABLE emp_sumary(

    employee_id NUMBER PRIMARY KEY,
    first_name VARCHAR2(200),
    last_name VARCHAR(200),
    salary NUMBER,
    department_name VARCHAR2(200),
    city VARCHAR2(200)

);
/
CREATE OR REPLACE PROCEDURE proc_emp_summary (p_empid NUMBER)
IS
    v_fn VARCHAR2(200);
    v_ln VARCHAR2(200);
    v_salary NUMBER;
    v_depname VARCHAR2(200);
    v_city VARCHAR2(200);
BEGIN

    

--Cargar info del empleado

    SELECT first_name, last_name, salary, dep.department_name, loc.city
    INTO v_fn, v_ln, v_salary, v_depname, v_city
    FROM employees emp
    LEFT JOIN departments dep ON (emp.department_id = dep.department_id)
    LEFT JOIN locations loc ON (dep.location_id = loc.location_id)
    WHERE emp.employee_id = p_empid;

-- Insertar info en emp_summary

 INSERT INTO emp_summary 
    VALUES(p_empid, v_fn, v_ln, v_salary, v_depname, v_city); 
    DBMS_OUTPUT.PUT_LINE('Empleado insertado');
    COMMIT;
EXCEPTION 
    WHEN no_data_found THEN
        DBMS_OUTPUT.PUT_LINE('Error - Empleado no existe');
    WHEN others THEN
        DBMS_OUTPUT.PUT_LINE('Error. - '||sqlerrm);
        ROLLBACK;
        
END;
/
ALTER TABLE emp_sumary RENAME TO emp_summary;
/
--Esto es para ejecutar el proceso y añadir un usuario a la tabla
EXEC proc_emp_summary(100);
EXEC proc_emp_summary(101);
EXEC proc_emp_summary(102);
EXEC proc_emp_summary(103);
EXEC proc_emp_summary(104);
EXEC proc_emp_summary(109);
EXEC proc_emp_summary(1062);
/

/*
Tipo: Funcion
INPUT: emp_id NUMBER
OUTPUT: date
DESC: El programa recibe un id de empleado y retoran la primera 
fecha en la que fue contratado
TIP: Ten en cuenta las tablas EMPLOYEES y JOB_HISTORY
*/
/
CREATE OR REPLACE FUNCTION f_first_hire_date(p_empid NUMBER) RETURN DATE
IS
    v_count NUMBER;
    v_date DATE;

BEGIN
     SELECT COUNT(*) INTO v_count
     FROM job_history WHERE employee_id = p_empid;
     
     IF v_count > 0 THEN
         SELECT MIN(start_date) INTO v_date
         FROM job_history WHERE employee_id = p_empid;
         RETURN v_date;
    ELSE
        SELECT hire_date INTO v_date
        FROM employees WHERE employee_id = p_empid;
        RETURN v_date;
    END IF;
EXCEPTION
    WHEN no_data_found THEN RETURN NULL;
END;
/
CREATE OR REPLACE VIEW v_hire_dates AS
SELECT employee_id, hire_date
FROM employees
UNION
SELECT  employee_id, start_date AS hire_date
FROM job_history;
/

SELECT * FROM v_hire_dates;


/
CREATE OR REPLACE PROCEDURE resum_departament_managers(p_dept_id NUMBER)
IS
    CURSOR c_c IS
        SELECT first_name, salary
        FROM employees
        WHERE department_id = p_dept_id;

    v_count    NUMBER := 0;
    v_sal4     NUMBER := 0;
    v_tot_sala NUMBER := 0;
    v_dep      NUMBER;
BEGIN
    SELECT department_id
    INTO v_dep
    FROM departments
    WHERE department_id = p_dept_id;

    FOR c_l IN c_c LOOP
        v_count := v_count + 1;
        v_tot_sala := v_tot_sala + c_l.salary;

        IF c_l.salary > 4000 THEN
            v_sal4 := v_sal4 + 1;
            DBMS_OUTPUT.PUT_LINE(
                'Empleat: ' || c_l.first_name ||
                ' | Salari: ' || c_l.salary ||
                ' | Estat: ALT'
            );
        ELSE
            DBMS_OUTPUT.PUT_LINE(
                'Empleat: ' || c_l.first_name ||
                ' | Salari: ' || c_l.salary ||
                ' | Estat: NORMAL'
            );
        END IF;
    END LOOP;

    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('El departament existeix però no té empleats.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('El total d''empleats és: ' || v_count);
        DBMS_OUTPUT.PUT_LINE('Els empleats que cobren més de 4000 són: ' || v_sal4);
        DBMS_OUTPUT.PUT_LINE('La suma total de tots els salaris és: ' || v_tot_sala);
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('El departament no existeix.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

/*
TIPUS: Procediment (PROCEDURE).
NOM: CONTROL_SALARIS_DEPARTAMENT.
PARÀMETRES D'ENTRADA: p_department_id (NUMBER).

DESCRIPCIÓ: El procediment ha de recórrer, mitjançant un cursor, tots els empleats que
pertanyen a un departament concret. Per a cada empleat, s'ha de mostrar:

El seu nom
El seu salari
Un missatge segons el salari:
Si el salari és superior a 5000, mostrar: "SALARI ALT"
Si el salari és inferior o igual a 5000, mostrar: "SALARI NORMAL"

En finalitzar el recorregut, el procediment ha de mostrar:

El nombre total d’empleats revisats
El nombre d’empleats amb salari superior a 5000
La suma total de tots els salaris del departament

CONTROL D'ERRORS:
Cal gestionar el cas en què el departament indicat no existeixi a la taula DEPARTMENTS.
Si el departament existeix però no té empleats associats, s'ha d'indicar amb un missatge informatiu.

*/
CREATE OR REPLACE PROCEDURE CONTROL_SALARIS_DEPARTAMENT(p_department_id NUMBER)IS

    CURSOR c_c IS
    SELECT first_name,salary
    FROM employees
    WHERE department_id = p_department_id;
    
    v_count NUMBER := 0;
    v_emp5 NUMBER := 0;
    v_tot_sal NUMBER := 0;
    
    v_dep NUMBER;
BEGIN

    SELECT department_id
    INTO v_dep
    FROM employees
    WHERE department_id = p_department_id;

    FOR c_l IN c_c
    LOOP
        
        v_count := v_count +1;
        
        IF c_l.salary > 5000 THEN
             DBMS_OUTPUT.PUT_LINE('L empleat: '||c_l.first_name||' cobra mes de 5k');
             v_emp5 := v_emp5 +1;
        ELSIF c_l.salary <= 5000 THEN 
            DBMS_OUTPUT.PUT_LINE('L empleat: '||c_l.first_name||' te un salri normal');
        END IF;
    
        v_tot_sal := v_tot_sal + c_l.salary;
    END LOOP;

    IF v_count = 0 THEN
         DBMS_OUTPUT.PUT_LINE('El dep existe pro no tiene empleados');
    ELSE
        DBMS_OUTPUT.PUT_LINE('El total de emps revisat es '||v_count);
        DBMS_OUTPUT.PUT_LINE('El nombre de empleats amb salari superior a 5000 es '||v_emp5);
        DBMS_OUTPUT.PUT_LINE('La suma total de tots els salaris del departament es: '||v_tot_sal);
        
   END IF;
        
EXCEPTION

    WHEN no_data_found THEN
        DBMS_OUTPUT.PUT_LINE('El departametno no existe');
    WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('ERROR '||SQLERRM);


END;



/*
TIPUS: Procediment (PROCEDURE).
NOM: RESUM_FEINES_EMPLEAT.
PARÀMETRES D'ENTRADA: p_employee_id (NUMBER).

DESCRIPCIÓ: El procediment ha d'utilitzar un cursor per recórrer tots els registres de la
taula JOB_HISTORY associats a un empleat concret. Per a cada registre, s'ha de mostrar:

La data d'inici
La data de finalització
El JOB_ID
El nom del departament on va treballar

A més, per a cada registre s'ha de calcular la durada en dies de cada etapa laboral.
En finalitzar el recorregut, el procediment ha de mostrar:

El nombre total de registres històrics trobats
La suma total de dies treballats en l’històric

CONTROL D'ERRORS:
Cal gestionar el cas en què l’empleat indicat no existeixi a la taula EMPLOYEES.
Si l’empleat existeix però no té registres a la taula JOB_HISTORY, s'ha d'indicar amb un missatge informatiu
*/
/
CREATE OR REPLACE PROCEDURE RESUM_FEINES_EMPLEAT(p_employee_id NUMBER)IS

    CURSOR c_c IS
    SELECT job.start_date AS data_inici,job.end_date AS data_fi,job.job_id, dep.department_name AS dep_name
    FROM job_history job 
    JOIN departments dep ON (job.department_id = dep.department_id)
    WHERE employee_id = p_employee_id;

    v_count NUMBER := 0;
    v_dies NUMBER := 0;
    v_emp NUMBER;
BEGIN

    SELECT employee_id
    INTO v_emp
    FROM employees
    WHERE job.employee_id = p_employee_id;

    FOR c_l IN c_c
    LOOP

    v_count := v_count +1;
    v_dies := v_dies + (c_l.data_fi - c_l.data_inici);
    
    DBMS_OUTPUT.PUT_LINE('Inicio'||c_l.data_inici||' y la data de fi es: '|| c_l.data_fi);
    DBMS_OUTPUT.PUT_LINE('Job: ' || c_l.job_id ||' | Departament: ' || c_l.dep_name ||' | Durada: ' ||(c_l.data_fi - c_l.data_inici) || ' dies');

    END LOOP;
    
    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE(' l empleat existeix però no té registres a la taula JOB_HISTORY');
    ELSE
     DBMS_OUTPUT.PUT_LINE('Total registres històrics: ' || v_count);
        DBMS_OUTPUT.PUT_LINE('Suma total de dies treballats: ' || v_dies);
    
    
    END IF;
EXCEPTION

    WHEN no_data_found THEN
         DBMS_OUTPUT.PUT_LINE('l empleat indicat no existeixi a la taula EMPLOYEES');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR ' ||SQLERRM);
END;
/
