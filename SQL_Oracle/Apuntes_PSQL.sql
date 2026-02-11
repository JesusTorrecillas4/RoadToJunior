
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
 SELECT loc.city || '-' || loc.postal_code, COUNT(*) INTO v_salida, v_count
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
    SELECT emp.salary, j.job_id, j.min_salary, j.max_salary INTO v_sal, v_job_id, v_min, v_max
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
