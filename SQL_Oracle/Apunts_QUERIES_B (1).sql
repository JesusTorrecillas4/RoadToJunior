/*APUNTES SELECTS PPT 1-8 */

-- CONSULTA BÁSICA - Seleccionar todo de una tabla
SELECT * 
FROM employees;

-- CONSULTA BÁSICA - Seleccionar algunas columnas
        -- NOMBRE, APELLIDO, SALARIO de los EMPLEADOS.
SELECT first_name, last_name, salary
FROM employees;

-- OPERACIONES ARITMÉTICAS
SELECT employee_id, first_name, last_name, salary, 
        salary*14, manager_id 
FROM employees;

-- RENOMBRAR COLUMNAS DE CONSULTAS (SOLO PARA LA QUERY)
SELECT employee_id AS id_empleado, 
        first_name AS "NoMBre", 
        last_name apellido, 
        salary "salario", 
        salary*14 "salario anual", 
        manager_id AS id_jefe 
FROM employees;

-- LITERALES (valores fijos) DENTRO DE LA QUERY
SELECT first_name, last_name, 'cobra: ' AS "🐍", 
        salary, '$' AS moneda
FROM employees;

    -- EXPLICACIón: MUESTRAS la columa con texto fijo para 
    -- todos los registros de la tabla seleccionado con FROM.
    SELECT 'Hola' FROM employees;

    -- EXTRA!! Tabla para hacer pruebas:
    SELECT SYSDATE+50, 8*7 FROM dual;
    
    DESC dual;
    SELECT * FROM dual;


-- CONCATENAR (unir) Columnas
SELECT first_name 
    || ' ' || last_name 
    || ' coBra: ' 
    || salary || '$' AS frase
FROM employees;









--PPT2
-- FILTRAR REGISTROS (FILAS) - WHERE
-- Ejemplo: Empleados que cobran un SALARYo de más de 12000
SELECT *
FROM employees
WHERE salary > 12000;

-- Ejemplo: Quien cobra 12000?
SELECT first_name FROM employees WHERE salary = 12000;

/* LISTA DE CONDICIONES POSIBLES:
    ___ > ___   Mayor que...
    ___ < ___   Menor que...
    ___ = ___   Igual que...
    ___ >= ___   Mayor o igual que...
    ___ <= ___   Menor o igual que...
    ___ <> ___   Diferente que...
    ___ != ___   Diferente que...
    ___ IN (___ , ___ , ...)   Igual a alguno del IN
    ___ BETWEEN _min_ AND _max_ Valor entre los valores min y max
    ___ LIKE _mascara_  EL texto coincide con el patron de mascara
    ___ IS NULL     Igual a NULL
    NOT     invierte el IN, BETWEEN y IS
        NOT IN
        NOT BETWEEN
        IS NOT NULL
*/

--Ejemplo: Apellido y salario de los empleados que se llaman David
SELECT last_name, salary
FROM employees 
WHERE first_name = 'David';

--Ejemplo: Empleados que trabajen en los departamentos 50, 80 o 100.
SELECT * FROM employees WHERE department_id IN (50,80,100);

--Ejemplo: Nombre, apellido y fecha de contratación de los empleados
-- contratados entre ENERO y ABRIL de 2007
SELECT first_name, last_name, hire_date
 FROM employees
 WHERE hire_date BETWEEN '01/01/2007' AND '30/04/2007';
 
-- Ejemplo: DIRECCIONES que no estén en Estados UNIDOS (US)
SELECT * 
FROM locations
WHERE country_id <> 'US';

-- Ejemplo: Calle, código Postal y ciudad. De todas las
-- direcciones excepto las ciudades de Tokyo, Seattle y London.
-- Renombra las columnas.

SELECT street_address AS calle, 
    postal_code AS codigo_postal, 
    city AS ciudad
FROM locations
WHERE city NOT IN ('Tokyo', 'London', 'Seattle');

--Ejemplo: Nombre y Apellido (en la misma columna y renombrado)
-- de los empleados que no cobran comisión.
SELECT first_name || ' ' || last_name AS empleado
FROM employees
WHERE commission_pct IS NULL;

/*CONECTORES DE CONDICIONES:

    AND -- Obliga a que TODAS las condiciones se cumplan
    OR -- Solo necesita que ALGUNA (mínimo UNA) se cumpla
*/

-- Ejemplo: Muestra los empleado que cobren más de 5500 Y tengan el job_id 'IT_PROG'
SELECT *
FROM employees
WHERE salary > 5500 
  AND job_id = 'IT_PROG';

-- Ejemplo: Muestra los empleados que tengan como manager al empleado 101 o que no tengan
-- manager.

SELECT *
FROM employees
WHERE manager_id = 101 OR manager_id IS NULL;

-- ORDEN DE OPERACIONES: NOT -> AND -> OR

-- Empleados que sean SA_REP o empleados que sean AD_PRES y cobren más de 15000
SELECT first_name, last_name, salary, job_id
FROM employees
WHERE job_id = 'SA_REP' 
  OR (job_id = 'AD_PRES'
  AND salary > 15000);

--Empleados que sean SA_REP o AD_PRES, y que cobren más de 15000
SELECT first_name, last_name, salary, job_id
FROM employees
WHERE (job_id = 'SA_REP' 
  OR job_id = 'AD_PRES')
  AND salary > 15000;
  
    --Alternativa:
    SELECT first_name, last_name, salary, job_id
     FROM employees
     WHERE job_id IN ('SA_REP','AD_PRES')
       AND salary > 15000;
       
--Empleados que empiecen por la letra 'A' y terminen en 'a'
    --TIP % Cualquier combinacion de caracteres (vacio tb vale)
    --  _ Un solo caracter (obligatorio)
--Solo que empiecen por 'A' y acaben en 'a'
SELECT first_name FROM employees
WHERE first_name LIKE 'A%a';
--Todos los empleados
SELECT first_name FROM employees
WHERE first_name LIKE '%';
--Con nombres de 4 letras
SELECT first_name FROM employees
WHERE LENGTH(first_name) = 4;
SELECT first_name FROM employees
WHERE first_name LIKE '____';
       
/*ORDENACIÓN DE REGISTROS (FILAS)
    
    SELECT ____
     FROM ____
     WHERE ____
     ORDER BY columna1, columna2, ...
*/

-- Ejemplo: Muestra el nombre, apellido y salario de todos los empleados. 
--      Ordena la salida por nombre y salario (en ese orden).

SELECT first_name, last_name, salary
 FROM employees
 ORDER BY first_name, salary;

-- DIRECCIÓN DE LA ORDENACIÓN:
--      A-Z o 0-9 ASC
--      Z-A o 9-0 DESC

-- Ejemplo: Sobre la consulta anterior selecciona solo los 'Alexander','Steven','David', 
--   ordena por nombre y luego por salario de MAYOR a MENOR.

SELECT first_name, last_name, salary
 FROM employees
  WHERE first_name IN ('Alexander','Steven','David')
 ORDER BY first_name, salary DESC;

-- Se pueden ordenar los registros marcando solo el número de columna.
SELECT employee_id, 
    first_name || ' ' || last_name AS nombre,
    salary*14, 
    job_id,
    department_id
FROM employees
ORDER BY 3 desc, 2 desc;


/*
Ejercicio: Mostrar nombre, apellido, fecha de contratacion y salario de los empleados
contratados en 2007 que cobren mas de 6000, o los contratados en 2006 y trabajen en el departamento 50.
Ordenalos por fecha de contratacion de menos a mas, y salario de mayor a menor
*/

SELECT * FROM employees;

SELECT first_name AS nombre, last_name AS apellido, hire_date, salary AS salario
FROM employees
WHERE (hire_date BETWEEN '01/01/2007' AND '31/12/2007' AND salary > 6000)
    OR
    (hire_date BETWEEN '01/01/2006' AND '31/12/2006' AND department_id = 50)
ORDER BY hire_date, salary DESC;

/*
Ejercicio: Muestra la direccion completa (calle, codigo postal, ciudad) renombra a "direccion", la provincia y el pais
De todas las direcciones en los paises US y UK (excepto la ciudad de Londres)
Ordena la salida por codigo postal de mayor a menor
*/

SELECT * FROM locations;

SELECT street_address || ' ' || postal_code || ' ' || city AS direccion, state_province, country_id
FROM locations
WHERE country_id IN ('US', 'UK') AND city != 'London'
ORDER BY postal_code DESC;









/*PPT3 - Funciones de fila*/

-- LOWER, UPPER, INITCAP
-- Pasa el texto a minusculas, mayusculas o iniciales de palabras

-- Mostrar todo en minusculas
SELECT LOWER('En el fondo yo tenia razon...')
FROM dual;

-- Mostrar todo en mayusculas
SELECT UPPER ('En el fondo yo tenia razon...')
FROM dual;

-- Primera letra en mayusculas
SELECT INITCAP ('En el fondo yo tenia razon...')
FROM dual;

SELECT first_name, 
LOWER (first_name) AS minusculas, 
UPPER (first_name) AS mayusculas, 
INITCAP ('once upon a time') AS iniciales
FROM employees;

-- Convierte internamente en minusculas y despues puedes buscar lo que quieras en minusculas
SELECT * FROM employees 
WHERE LOWER (first_name) = 'david';

-- Convierte internamente en mayusculas y despues puedes buscar como quieras porque el buscador tambien esta en mayusculas
SELECT * FROM employees 
WHERE UPPER(first_name) = UPPER('david');

--CONCAT - Concatena dos strings
    --Ejemplo de anidamiento de funciones
SELECT CONCAT(CONCAT('Once', ' '), 'Upon')
FROM dual;

SELECT CONCAT(CONCAT(CONCAT(CONCAT('Once', ' '), 'Upon'), ' '), INITCAP('a time'))
FROM dual;

--SUBSTR - Recorta un texto, desde una posicion y cogiendo n caracteres
    --SINTAXIS: SUBSTR(texto, posicion_inicial, numero_caracteres)
    --Ejemplo1: Seleccionar las primeras 3 letras de cada nombre de empleado
SELECT SUBSTR(first_name, 1 , 3), first_name
FROM employees;

    --Ejemplo2: Sleecionar la segunda y tercera letra de cada nombre de empleado
SELECT SUBSTR(first_name, 2 , 2), first_name
FROM employees;

--LENGTH - Retorna el numero de caracteres del string
    --Ejemplo: Longitud de cada nombre de empleado
SELECT LENGTH(first_name), first_name
FROM employees;

--INSTR - Retorna la primera posicion donde encuentra un caracter
    --Ejemplo: Busca la posicion de la primera 'a' de cada nombre de empleado
SELECT INSTR(first_name, 'a'), first_name
FROM employees;
--Solucion bug de 'Amit' (no encuentra la 'A' mayuscula)
SELECT INSTR(LOWER(first_name), 'a'), first_name
FROM employees;

--RPAD/LPAD competa a derecha (R) o izquierda (L) con el texto que le digamos y hasta cubrir el tamaño de string
    --SINTAXIS: RPAD/LPAD(texto, longitud, relleno)
SELECT salary, LPAD(salary, 10, '#'), RPAD(salary, 10, '#')
FROM employees;
--OJO QUE RECORTA
SELECT salary, LPAD(salary, 3, '#'), RPAD(salary, 3, '#')
FROM employees;

--REPLACE: remplaza unos caracteres por otros dentro de un string
    --SINTAXIS: REPLACE(string, char_a_remplazar, chers_de_remplazo)
    --Ejemplo: cambia todas las 'a' por 'i' en los nombres de empleados
SELECT first_name, REPLACE(first_name, 'a', 'i')
FROM employees;
--Correccion de iniciales
SELECT first_name, INITCAP(REPLACE(LOWER(first_name), 'a', 'i'))
FROM employees;

--TRIM: Quita los caracteres iniciales y/o finales de un string
    --SINTAXIS: TRIM(caracteres_a_eliminar FROM string)
    --Ejemplo: 
SELECT first_name, TRIM('a' FROM first_name), TRIM('a' FROM LOWER(first_name))
FROM employees
WHERE first_name LIKE '%a';


/*FUNCIONES NUMERICAS:
    ROUND -- Redondea un numero
    TRUNC -- Trunca un numero
    MOD -- Residuo de una division
*/

SELECT 3.1416, ROUND(3.1416, 3), TRUNC(3.1416, 3),
    ROUND(5.5) AS Alumno_OK, TRUNC(4.999999999999) AS Alumno_KO
FROM dual;

--Par o Impar
SELECT MOD(345, 2) FROM dual; --Da 1 es impar
SELECT MOD(346, 2) FROM dual; --Da 0 es par
SELECT MOD(345, 2) AS Impar, MOD(346, 2) AS Par FROM dual;

--TESTING funciones de fecha
SELECT ROUND(TO_DATE('04/04/2022'), 'MONTH'), ROUND(TO_DATE('22/04/2022'), 'MONTH')
FROM dual;






/*PPT 4 - CONVERSIONES DE TIPO y NVL*/

--Ejemplo conversion de fechas
SELECT TO_DATE('2023-25-07', 'YYYY-DD-MM'), 
    TO_CHAR(SYSDATE, 'DD "de" MONTH "del" YY')
FROM dual;

--FUNCION NVL: Remplaza un valor NULL por lo que le digamos
SELECT salary, commission_pct,
    salary + (salary * NVL(commission_pct, 0)) AS salario_completo,
    salary + NVL((salary * commission_pct), 0) AS salario_completo
FROM employees;


SELECT department_id, SUM(salary) FROM employees GROUP BY department_id;


-- Dame una lista de todos los jobs de los empleados 
--y cauntos empleados hay en cada uno
 
SELECT job_id , COUNT(*) FROM employees GROUP BY job_id;

-- Haz una lista de todos los apellidos de los empleados y cuantas
-- veces se repiten

SELECT last_name, COUNT(*) FROM employees GROUP BY last_name ORDER BY 2 DESC;

--Haz una lista del salario medio de cada departamento

SELECT department_id, AVG(salary), MIN(salary), MAX(salary), COUNT(*) FROM employees GROUP BY department_id ;

-- Muestra cuanots empleados tienen un nombre que empieza por cada letra del abecedario

SELECT SUBSTR(first_name,1,1), COUNT(employee_id) FROM employees GROUP BY SUBSTR(first_name,1,1) ORDER BY 1 DESC;

-- Muestra la cantidad de nombres de empleados con 4, 5 y 6 letras (por separado)

SELECT LENGTH(first_name)FROM employees WHERE LENGTH(first_name) IN (4,5,6) GROUP BY LENGTH(first_name);

-- Muestra los departamento que tengan mas de 6 empleados

SELECT department_id, COUNT (*) FROM employees HAVING COUNT(*) > 6  GROUP BY department_id;


/*
    Muestra los departamentos que tengan entre 3 y 6 empleados, con un salario medio de departamaento de mas de 5000, y excluye del recuento
    los empleados con un nombre que empiece por L o J, y los empleados que no tengan manager; 
    y lo ordenas oir departamento de la Z a la A; y renombras las columnas.
*/

SELECT department_id AS departametbi, COUNT (employee_id) AS empleados, 
ROUND(AVG(salary)) AS salario_medio FROM employees WHERE manager_id IS NOT NULL AND (first_name NOT LIKE 'L%' AND first_name NOT LIKE 'J%') GROUP BY department_id HAVING COUNT(*) BETWEEN 3 AND 6 AND AVG(salary) > 5000 ORDER BY 1 DESC;

/*
    Funciones
    
    MAX
    MIN
    AVG
    SUM
    COUNT
    
    +GROUP BY



*/


-- PPT 6 - Uniones entre tablas
/*
    JOINs
    
    INNER JOIN*, NATURAL JOIN, FULL JOIN, CROSS JOIN, LEFT JOIN*, RIGHT JOIN*



*/




-- Muestra el nombre, apellido y nombre de departamento, del empleado 100.

SELECT emp.first_name, emp.last_name, dep.department_name
FROM employees emp JOIN departments dep ON (emp.department_id = dep.department_id)
WHERE emp.employee_id = 100;


-- Muestra en que ciudad trabaja la empleada 101.

SELECT first_name, last_name, loc.city
FROM employees emp
 JOIN departments dep ON (emp.department_id = dep.department_id)
 JOIN locations loc ON (dep.location_id = loc.location_id)
WHERE employee_id = 101;

-- En que pais esta la ciudad de 'Geneva'


SELECT co.country_name
FROM locations loc
 JOIN countries co ON (loc.country_id = co.country_id)
WHERE loc.city = 'Geneva';

-- Cuantos empleados trabajan en cada ciudad

SELECT loc.city, COUNT(emp.employee_id)
FROM locations loc
 JOIN departments dep ON (dep.location_id = loc.location_id)
 JOIN employees emp ON (emp.department_id = dep.department_id)
GROUP BY loc.city;

-- Muestra el nombre de departamento y el nombre del job, de los empleados
-- que cobren entre 5000 y 30000, y tengan manager. Ordena por nombre de empleado de Z-A

SELECT dep.department_name, jo.job_title, emp.first_name, emp.last_name
FROM employees emp 
 JOIN departments dep ON(dep.department_id = emp.department_id)
 JOIN jobs jo ON (emp.job_id = jo.job_id)
WHERE emp.salary BETWEEN 5000 AND 30000 
 AND emp.manager_id IS NOT NULL
ORDER BY 3 DESC, 4 DESC;

-- Muestra el nombre de cada departamento , y como se llama
--su manager. Ordena por nombre de departmanetno de la A-Z

SELECT dep.department_name, miau.first_name, miau.last_name
FROM departments dep
 JOIN employees miau ON (dep.manager_id = miau.employee_id)
ORDER BY dep.department_name;

-- Dame una lista de nombres y apellidos de los empleados y
-- el nombre y apellidos de sus managers
-- renombra las columnas.


SELECT emp.first_name AS nombre_emp, emp.last_name AS apellido_emp, man.first_name AS nombre_man, man.last_name AS apellido_man
FROM employees emp 
 JOIN employees man ON (emp.manager_id = man.employee_id)
ORDER BY 1,2;


-- Nombre, apellido y nombre del job de los empleados y nombre, apellido
-- de sus jefes. Solo de los jefes que trabajan en
-- Seattle o South Sant Frnacisco


-- Haz una lista de TODOS los departamentos (nombre) y el nombre y apellido de su manager

SELECT dep.department_name, dep.manager_id
FROM departments dep
LEFT JOIN employees emp  ON (dep.manager_id = emp.employee_id);

-- Haz una lista de todos los departamentos y cuanto se gastan en 
-- salarios de empleado

SELECT dep.department_id, dep.department_name,SUM (emp.salary)
FROM employees emp RIGHT
 JOIN departments dep ON (emp.department_id = dep.department_id)
 GROUP BY dep.department_id, dep.department_name;










