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

SELECT dep.department_name, man.first_name, man.last_name
FROM departments dep
 JOIN employees man ON (dep.manager_id = man.employee_id)
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

--Muestra el nombre y apellido de los empleados en mayusculas, el numero de caracteres del apellido y el
--salario. Solo deben aparecer los empleados cuyo salario sea superior a 6000 y que trabajen en 
--departamentos distintos de 'IT'. Ordena el resultado por salario de mayor a menor.
SELECT UPPER(emp.first_name),UPPER (emp.last_name), LENGTH(emp.last_name), emp.salary
FROM employees emp
 JOIN departments dep ON (emp.department_id = dep_employee_id)
 WHERE emp.salary > 6000 AND dep.department_name = 'Shipping';
 
--Obten el nombre del departamento y el numero total de empleados que tiene cada uno. Deben aparecer
--tambien los departamentos que no tengan empleados asiganados. Muestra solo aquellos departamentos con
--mas de 3 empleados y ordenalos por numero de empleados de forma descendente

SELECT dep.department_name, COUNT(emp.employee_id)
FROM departments dep 
LEFT JOIN employees emp ON (emp.department_id = dep.department_id)
GROUP BY dep.department_name
HAVING COUNT(emp.employee_id) > 3
ORDER BY 2 DESC;

--Muestra el nombre completo de los empleados(nombre y apellido en una sola columna), el nombre del 
--departamteno y la ciudad donde se encuentra.Incluye unicamente a os empleados que trabajen en 
--ciudades que empieces por "S" o "T". Ordena el resulatado alfabeticamente por ciudad y luego por apellido
 
 SELECT  emp.first_name ||' '|| emp.last_name,
 CONCAT(CONCAT(emp.first_name,' '),emp.last_name) AS nomycognom, dep.department_name, loc.city
 FROM employees emp JOIN departments dep ON (emp.department_id = dep.department_id)
 JOIN locations loc ON (dep.location_id = loc.location_id)
 WHERE loc.city LIKE 'S%'
   OR loc.city LIKE 'T%'
ORDER BY loc.city, emp.last_name;

--Para cada puesto de trabajo, muestra el salario maximo, minimo y medio de los empleados que lo desempeñan.
--Solo deben aparecer los puestos cuyo salario sea superior a 5000. Ordena el resulatado por salario medio de mayor a menor

SELECT job_id, MAX(salary), MIN(salary), AVG(salary)
FROM employees 
GROUP BY job_id
HAVING AVG(salary)>5000
ORDER BY 4 DESC;

--Messtra el apellido de los empleados ajustados a una longitud fija de 15 caracteres, el nmobre del jefe y el salario del empleado.
--Incluye tambien a los empleados que no tenggan jefe asignado. Solo deben mostrarse los empleados con salario entre 3000 y 9000 y ordena el resultado por apellido.
 
SELECT  RPAD(emp.last_name,15,'#'), man.first_name AS jefe, emp.salary
FROM employees emp
 LEFT JOIN employees man ON (emp.manager_id = man.employee_id)
WHERE emp.salary BETWEEN 3000 AND 9000
ORDER BY emp.last_name;

--Para cada departamento, el nombre del departamento, el numero total de empleados, el slario total que se paga en el y el salario del empleado mejor pagado.
--Deben incluirse tambien los departamentos sin empleados. Solodeben mostrarse los departamentos cuyo salario total super los 20.000
--o que no tenga ningun empleado asignado.El nombre del departamento debe mostrarse en mayusculas y el resultado debe ordenarse por salario
--total de mayor a menor, dejando los departamentos sin empleados al final

SELECT UPPER(dep.department_name),
 COUNT(emp.employee_id) AS total_emps,
NVL(SUM(emp.salary),0) AS suma_salarios,
MIN(emp.salary) AS salario_Maximo
FROM departments dep
LEFT JOIN employees emp ON (emp.department_id = dep.department_id)
 GROUP BY dep.department_name
 HAVING SUM(emp.salary) > 20000
 OR COUNT(emp.employee_id) = 0
 ORDER BY 3 DESC;
 
 
 --ppt 7 SUBQUERIES
 
 --meter un select, en un select.. se puede..
 
 
 -- muestra lo que quieras de los empleados que cobran mas que Jason Mallin

SELECT *
FROM employees
WHERE salary > 3300;

SELECT *
FROM employees
WHERE salary > (SELECT salary FROM employees WHERE first_name ='Jason' AND last_name='Mallin');

--Muestra los empleados que tienen el mismo jefe que Neena Kochhar
SELECT *
FROM employees
WHERE manager_id =(SELECT manager_id FROM employees WHERE first_name ='Neena' AND last_name='Kochhar');

--Muestra una lista de TODOS los departamentos. De cad uno quiero:
--el nombre del departameno, el salario Maximo del departamneto,
--el Minimo, el salario medio, y la suma del salario, del departameto, la suma total de slaarios de la empresa y un 67

SELECT dep.department_name,
 NVL(MAX(salary),0),
 NVL(MIN(salary),0), 
 NVL(SUM(salary),0),
 NVL(ROUND(AVG(salary),2),0),
 (SELECT AVG(salary) FROM employees),
 67
FROM departments dep
 LEFT JOIN employees emp ON (dep.department_id = emp.department_id)
GROUP BY dep.department_name;

SELECT AVG(salary) FROM employees;

--Muestra el apellido y el salairo de los empleados que trabajan en el departamento 50 y cyo salario sea superior a 3.000

SELECT first_name , salary
 FROM employees 
 WHERE department_id = 50
 AND salary > 3000
 ORDER BY salary, last_name;
 
 -- Muestra el nombre del departamento y el salario medio de sus empleados. Solo deben aparecer los departamentos cuyo salrio medio sea superior a 
 --4.000 y que tengan al menos 2 empleados
 --Ordena el resultado por salario medio de mayor a menor.
 
 
 SELECT dep.department_name, AVG(salary)
 FROM departments dep
  JOIN employees emp ON (dep.department_id = emp.department_id)
  GROUP BY dep.department_name
  HAVING AVG(salary) > 4000
  AND COUNT(emp.employee_id) >= 2
  ORDER BY 2 DESC;
 
 
 --Encuentra los nombres y apellidos y su salario de los empleados que trabajen en zambia
 
 SELECT first_name, last_name, salary
 FROM employees emp RIGHT JOIN
 departments dep ON (emp.department_id = dep.department_id)
<<<<<<< HEAD
 JOIN locations loc ON (dep.location_id = loc.location_id)
 JOIN countries con ON (loc.country_id = con.country_id)
 WHERE con.country_name = 'zambia';
 
 /*
    Muestra los job_id y el salario medio de cada job,
    pero solo los jobs que tengan más de 2 empleados
    y cuyo salario medio sea mayor de 4500.
    Ordénalos por salario medio de mayor a menor.
 */
 
 SELECT job_id, AVG(salary)
 FROM employees
 GROUP BY job_id
 HAVING COUNT(*) > 2
 AND AVG(salary) > 4500
 ORDER BY 2 DESC;
 
 
 /*
 Muestra los department_id y el número de empleados de cada departamento,
 pero solo los departamentos que tengan entre 3 y 6 empleados
 y que ningún empleado cobre menos de 2000.
 */
 
 SELECT department_id, COUNT(*) AS num_empleados
 FROM departments
 WHERE salary >= 2000
    GROUP BY department_id
    HAVING COUNT(*) BETWEEN 3 AND 6     
 /*
 Muestra el department_id y el salario máximo de cada departamento,
 pero solo de los departamentos que tengan al menos 3 empleados
 y cuyo salario medio sea mayor de 5000.
 Ordena el resultado por salario máximo de mayor a menor.
*/ 

SELECT department_id, MAX(salary)
FROM employees
GROUP BY department_id
HAVING COUNT(*) >= 3
AND AVG(salary) > 5000
ORDER BY 2 DESC;
    
 /*
 Muestra el job_id y el número de empleados de cada job,
 contando solo los empleados que cobren más de 3000,
 y muestra solo los jobs que tengan entre 2 y 5 empleados.
 Ordénalos por número de empleados de mayor a menor.
 */   

SELECT job_id, COUNT(*)
FROM employees
WHERE salary >3000
GROUP BY job_id
HAVING COUNT(*) BETWEEN 2 AND 5
ORDER BY 2 DESC;



/*
  Muestra el department_id, el salario medio y el número de empleados de cada departamento.
 Solo deben aparecer los departamentos que tengan más de 4 empleados y cuyo salario medio sea inferior a 6000.
 Ordena el resultado por salario medio de menor a mayor.
*/

SELECT department_id, AVG(salary), COUNT(*) AS empleadospdep
FROM employees
GROUP BY department_id
HAVING COUNT(*) > 4 
AND AVG(salary) < 6000
ORDER BY 2 ASC;

/*
 Muestra el job_id y el salario mínimo de cada job,
 contando solo los empleados que tengan manager_id asignado.
 Solo deben aparecer los jobs que tengan al menos 3 empleados.
 Ordena el resultado por salario mínimo de mayor a menor.
*/

SELECT job_id, MIN(salary)
FROM employees
WHERE manager_id IS NOT NULL
GROUP BY job_id
HAVING COUNT(*) > 3
ORDER BY 2 ASC; 

/*
 Muestra el department_id, el salario mínimo y el número de empleados de cada departamento.
 Solo deben aparecer los departamentos que tengan entre 2 y 5 empleados
 y cuyo salario mínimo sea mayor o igual que 3000.
 Ordena el resultado por número de empleados de mayor a menor.
*/

/*
ESTE EESTA MAL
SELECT department_id, MIN(salary), COUNT(*) AS num_empleados
FROM employees
WHERE MIN(salary) >= 3000
GROUP BY department_id
HAVING COUNT(*) BETWEEN 2 AND 5
ORDER BY 3 DESC;
*/

SELECT department_id,MIN(salary) , COUNT(*) AS num_empleados
FROM employees
GROUP BY department_id
HAVING COUNT(*) BETWEEN 2 AND 5
   AND MIN(salary) >= 3000
ORDER BY 2 DESC;

/*
 Muestra el job_id y el salario medio de cada job,
 contando solo los empleados que NO tengan comisión.
 Solo deben aparecer los jobs que tengan más de 3 empleados
 y cuyo salario medio sea mayor que 4000.
 Ordena el resultado por salario medio de mayor a menor.
*/

SELECT job_id, AVG(salary)
FROM employees
WHERE  commission_pct IS NULL 
GROUP BY job_id
HAVING AVG(salary) > 4000
ORDER BY 2 DESC;

/*
 Muestra el department_id y el salario medio de cada departamento,
 contando solo los empleados que tengan manager_id asignado.
 Solo deben aparecer los departamentos que tengan al menos 2 empleados
 y cuyo salario medio sea mayor que 4500.
 Ordena el resultado por salario medio de mayor a menor.
*/

SELECT department_id, AVG(salary)
FROM employees
WHERE manager_id IS NOT NULL
GROUP BY department_id
HAVING COUNT(*) >= 2 AND
AVG(salary) > 4500
ORDER BY 2 DESC;

/*
 Muestra el nombre y apellido de cada empleado junto con el nombre del departamento en el que trabaja.
 Ordena el resultado por department_name (A–Z) y luego por last_name (A–Z).
*/


SELECT emp.first_name, emp.last_name, dep.department_name
FROM employees emp
JOIN departments dep ON (emp.department_id = dep.department_id)
ORDER BY 3, 2 DESC;

/*
 Muestra department_name, city y el número de empleados que trabajan en cada departamento.
 Deben aparecer también los departamentos sin empleados.
 Ordena por número de empleados de mayor a menor.
*/

SELECT dep.department_name, loc.city , COUNT(*) AS empleados
FROM departments dep
JOIN locations loc ON (dep.location_id = loc.location_id)
LEFT JOIN employees emp ON (emp.department_id = dep.department_id)
GROUP BY dep.department_name, loc.city
ORDER BY 3 DESC;
/*
 Muestra, para cada país, el country_name, el número total de empleados que trabajan en ese país y el salario medio (redondeado) de esos empleados.
 Requisitos:
 Deben aparecer también los países sin empleados (si existen en tus datos).
 Solo deben mostrarse los países con al menos 2 departamentos (aunque tengan 0 empleados).
 Excluye del recuento de empleados a los que no tengan manager (manager_id IS NULL).
 Ordena por número de empleados de mayor a menor y, en caso de empate, por country_name A–Z.
*/
SELECT con.country_name, COUNT(*), AVG(salary)
FROM employees emp
LEFT JOIN departments dep ON (emp.department_id = dep.department_id)
JOIN RIGHT locations loc ON (dep.location_id = loc.location_id)
JOIN countries con ON (loc.country_id = con.country_id)
WHERE manager_id IS NULL
GROUP BY country_id 
HAVING department_id >= 2
ORDER BY 2 DESC;





=======
 RIGHT JOIN locations loc ON (dep.location_id = loc.location_id)
 RIGHT JOIN countries con ON (loc.country_id = con.country_id)
 WHERE LOWER(con.country_name) = 'zambia';
 
 --Muestra el apellido del empleado en mayusculas, el nombre del empleado en minusculas y su salrio formateado como texxto añadiedno la cadena €
 --al final. Incluye tambine una columna que indique el numero de caracteres del apellido
 --Solo deben aparecer los empleados:
 --Cuyo apellido tenga mas de 5 caracteres
 --y cuyo salario, redondeado a centenas , sea superior a 4000
 --Todas las columnas mostradas deben tener un nombre personalizado
 --Ordena el resultado por numero de caracteres del apellido de mayor a menorn en caso de empate, por salario
 
 SELECT UPPER (last_name) AS apellido, LOWER (first_name) AS nombre, salary || '€' AS salario
FROM employees
WHERE LENGTH(last_name) > 5 
AND (first_name LIKE 'A%' OR first_name LIKE 'S%')
AND ROUND(salary,2) > 4000
ORDER BY LENGTH(last_name) DESC, salary;


--Muestra el apellido del empleado y el nombre del departamento en el que tranaja
--Incluye tambien salario del empleado
--Solo deben aparecer empleados:
--Que trabajen en departamentos con identificador mayor que 50
--y cuyo salario sea superior a 3.500
--Todas las columnas mostradas deben tener un nombre personalizado
--Ordena el resultado por nombre de departamento de forma ascendente y, dentro de cada departamento,
--por salario de mayor a meno

SELECT emp.last_name AS apellido, dep.department_name, salary AS salario
FROM employees emp 
JOIN departments dep ON (emp.department_id = dep.department_id)
WHERE dep.department_id > 50
AND emp.salary > 3500
ORDER BY 2 ASC, 3 DESC;
 
--Muestra el nombre del departamento y el numero de empleados qeu trabajan en el
--Deben aparecer todos los departamentso, incluidos los que no tengan empleados
--Solo deben contar los empleados cuyo salario sea superior a 4000
--Todas las columnas mostradas deben tener un nombre personalizado
--Ordena el resultado por numero de empleados de mayor a menor

SELECT dep.department_name, COUNT (*)
FROM employees emp 
RIGHT JOIN departments dep ON (emp.department_id = dep.department_id)
WHERE emp.salary > 4000 
GROUP BY dep.department_name
ORDER BY 2 DESC;

--Muestra el apellido del empleado, el apellido de su jefe directo, y el apellido del jefe de su jefe
--Deben aparecer todos los empleados, incluidos los que no tengan jefe o cuyo jefe no tenga jefe
--Solod eben mostrarse los empleados cuyo salrio sea superior a 4000
--y que trabahen en un departamento del 90
--Todas las columnas mostradas deben tener un nombre personalizado
--Ordena el resulatado por apellido del empleado

SELECT EMP.LAST_NAME AS empleado, man.last_name AS boss, superman.last_name AS bossss
FROM employees emp
LEFT JOIN employees man ON (emp.manager_id = man.employee_id)
LEFT JOIN employees superman ON (man.manager_id = superman.employee_id)
WHERE emp.salary > 4000
 AND emp.department_id <> 90
 ORDER BY 1;
 
 
 /*
  Muestra el department_name y el nombre y apellido de los empleados que trabajan en cada departamento.
 Deben aparecer también los departamentos que no tengan empleados.
 Ordena el resultado por department_name (A–Z).
 */
 SELECT dep.department_name, emp.first_name, emp.last_name
 FROM departments dep
 LEFT JOIN employees emp ON (emp.department_id = dep.department_id)
 ORDER BY 1 DESC;
 /*
 Muestra el nombre y apellido de todos los empleados y el nombre del departamento en el que trabajan.
 Deben aparecer también los empleados que no tengan departamento asignado.
 Ordena el resultado por last_name (A–Z).
 */
 
 SELECT emp.first_name, emp.last_name, dep.department_name
 FROM employees emp
 LEFT JOIN departments dep ON (emp.department_id = dep.department_id)
 ORDER BY 2 DESC;
 
 /*
 Muestra el department_name, el número de empleados y el salario medio de cada departamento.
 Requisitos:
 Deben aparecer también los departamentos sin empleados.
 Solo se contarán los empleados que tengan manager_id asignado.
 Solo deben aparecer los departamentos que tengan al menos 2 empleados.
 Ordena el resultado por salario medio de mayor a menor.
 */
 
 SELECT dep.department_name, COUNT(emp.employee_id), ROUND(AVG(salary))
 FROM departments dep
 LEFT JOIN employees emp ON (emp.department_id = dep.department_id)
 WHERE emp.manager_id IS NOT NULL
 GROUP BY dep.department_name
 HAVING COUNT(emp.employee_id) >= 2 
 ORDER BY 3 DESC;
 /*
 Muestra el job_id, el salario mínimo y el salario máximo de cada job.
 Requisitos:
 Solo se tendrán en cuenta los empleados con salary mayor que 3000.
 Solo deben aparecer los jobs que tengan más de 3 empleados.
 Ordena el resultado por salario máximo de mayor a menor.
 */
 SELECT job_id, MIN(salary), MAX(salary)
 FROM employees
 WHERE salary > 3000
 GROUP BY job_id
 HAVING COUNT(*) > 3
 ORDER BY 3 DESC;
 
 /*
 Muestra el nombre y apellido de los empleados y el nombre del departamento en el que trabajan.
Deben aparecer también los empleados que no tengan departamento.
Ordena por apellido de la A a la Z.
 */
 SELECT emp.first_name, emp.last_name, dep.department_name
 FROM employees emp
 LEFT JOIN departments dep ON (emp.department_id = dep.department_id)
 ORDER BY 2 DESC;
 /*
 Muestra el department_name y el número de empleados que tiene cada departamento.
 Condiciones:
 Deben aparecer también los departamentos sin empleados.
 Solo cuenta empleados que tengan manager_id asignado.
 Muestra solo los departamentos que tengan al menos 2 empleados.
 Ordena por número de empleados de mayor a menor.
 */
 SELECT dep.department_name, COUNT(emp.employee_id)
 FROM departments dep
 LEFT JOIN employees emp ON (emp.department_id = dep.department_id)
 WHERE emp.manager_id IS NOT NULL 
 GROUP BY dep.department_name
 HAVING COUNT(emp.employee_id) >= 2
 ORDER BY 2 DESC;
 /*
 Muestra el job_id y el salario medio de cada job.
 Condiciones:
 Solo se tienen en cuenta empleados con salario mayor que 3000.
 Solo deben aparecer los jobs que tengan más de 3 empleados.
 Ordena por salario medio de mayor a menor.
 */
 
 SELECT job_id, AVG(salary)
 FROM employees 
 WHERE salary > 3000
 GROUP BY job_id
 HAVING COUNT(*) > 3
 ORDER BY 2 DESC;
 
 /*
 Muestra el nombre y apellido de los empleados y el nombre del job que tienen.
 Deben aparecer también los empleados que no tengan job asignado.
 Ordena el resultado por apellido de la A a la Z.
 */
 SELECT emp.first_name, emp.last_name, job.job_title
 FROM employees emp
 LEFT JOIN jobs job ON (emp.job_id = job.job_id)
 ORDER BY 2 DESC;
 /*
 Muestra el department_name y el salario medio de cada departamento.
 Condiciones:
 Solo se tendrán en cuenta los empleados que cobren más de 4000.
 Deben aparecer solo los departamentos que tengan al menos 3 empleados.
 Ordena el resultado por salario medio de mayor a menor.
 */
 
 SELECT dep.department_name, AVG(salary)
 FROM employees emp
 JOIN departments dep ON (emp.department_id = dep.department_id)
 WHERE salary > 4000
 GROUP BY dep.department_name
 HAVING COUNT(*) >= 3
 ORDER BY 2 DESC;
 
 /*
 Muestra el job_id, el número de empleados y el salario máximo de cada job.
 Condiciones:
 Solo se contarán los empleados que tengan manager asignado.
 Solo deben aparecer los jobs que tengan entre 2 y 5 empleados.
 Ordena el resultado por salario máximo de mayor a menor.
 */
 SELECT job.job_id, COUNT(*), MAX(salary)
 FROM employees emp
 JOIN jobs job ON (emp.job_id = job.job_id)
 WHERE emp.manager_id IS NOT NULL
 GROUP BY job.job_id
 HAVING COUNT(*) BETWEEN 2 AND 5
 ORDER BY 3 DESC;
 
 /*
 Muestra el nombre y apellido de los empleados y el nombre del departamento en el que trabajan.
 Deben aparecer también los empleados que no tengan departamento asignado.
 Ordena el resultado por apellido de la A a la Z.
 */
 SELECT emp.first_name, emp.last_name, dep.department_name
 FROM employees emp
 LEFT JOIN departments dep ON (emp.department_id = dep.department_id)
 ORDER BY 2 desc;
 /*
 Muestra el department_name y el número de empleados de cada departamento.
 Condiciones:
 Solo se contarán los empleados que tengan manager asignado.
 Deben aparecer solo los departamentos que tengan al menos 3 empleados.
 Ordena el resultado por número de empleados de mayor a menor.
 */
 SELECT dep.department_name, COUNT(*)
 FROM employees emp
 JOIN departments dep ON (emp.department_id = dep.department_id)
 WHERE emp.manager_id IS NOT NULL
 GROUP BY dep.department_name
 HAVING COUNT(*) >= 3
 ORDER BY 2 DESC;
 /*
 Muestra el job_id, el salario medio y el salario máximo de cada job.
 Condiciones:
 Solo se tendrán en cuenta los empleados con salario mayor que 3500.
 Solo deben aparecer los jobs que tengan entre 2 y 6 empleados.
 Ordena el resultado por salario medio de mayor a menor.
 */
 
 SELECT job_id, AVG(salary), MAX(salary)
 FROM employees 
 WHERE salary > 3500
 GROUP BY job_id
 HAVING COUNT(*) BETWEEN 2 AND 6
 ORDER BY 2 DESC;
 
 /*nombre, apellido y salario con 8 cifras,
 */
 SELECT  emp.first_name, emp.last_name, RPAD(salary,8,'#')
 FROM employees emp
 JOIN departments dep ON (emp.department_id = dep.department_id)
 WHERE emp.last_name = (SELECT last_name FROM employees WHERE employee_id = 199)
 OR emp.last_name = (SELECT last_name FROM employees WHERE employee_id = 154);
 
 /*
  Para TODOS los empleados, muestra la suma de salario + (comision * 100) + numero de letras de su ciudad
  + suma de los 2 primeros digitos de su telefono
 */
 
 SELECT emp.first_name, emp.last_name, employee_id, salary + NVL(commission_pct * 100,0) + LENGTH(loc.city) + SUBSTR(phone_number,1,1) +SUBSTR(phone_number,2,1)
 FROM employees emp
 LEFT JOIN departments dep ON (emp.department_id = dep.department_id)
 LEFT JOIN locations loc ON (dep.location_id = loc.location_id);
 
 /*
 Muestra la lisda de departamentos(nombre), el nombre, apellido del manager de cada departametno
 y el salario del manager de cada manager de departamento
 */
 
 SELECT dep.department_name, dep.manager_id, depman.first_name, depman.last_name, depman.manager_id, depman.salary
 FROM departments dep
  JOIN employees depman ON (dep.manager_id = depman.employee_id)
 JOIN employees man ON (depman.manager_id = man.employee_id);
 
 /*
   MUESTRA EL NOMBRE DEL DEPARTAMENTO EL NOMBRE Y EL APELLIDO DEL MANAGER Y EL SALARIO DEL MANAFER DEL MANAGER DE LA TABLA EMPLOYEES
 */
 SELECT dep.department_name, depman.first_name, depman.last_name, superman.salary
 FROM departments dep
 JOIN employees depman ON (dep.manager_id = depman.employee_id)
 JOIN employees superman ON (depman.manager_id = superman.employee_id);
 /*
 
 Muestra first_name, last_name y department_name de todos los empleados.
 Ordena por department_name A–Z y luego por last_name A–Z.
 */
 SELECT emp.first_name, emp.last_name, dep.department_name
 FROM employees emp
 JOIN departments dep ON (emp.department_id = dep.department_id)
 ORDER BY 3, 2 ASC;
 /*
 Muestra el department_name y cuántos empleados hay en cada departamento.
 Deben aparecer también los departamentos sin empleados.
 Ordena por número de empleados de mayor a menor.
 */
 SELECT dep.department_name, COUNT(emp.employee_id)
 FROM departments dep
 LEFT JOIN employees emp ON (emp.department_id = dep.department_id)
 GROUP BY dep.department_name
 ORDER BY 2 DESC;
 /*
 Para cada empleado, muestra employee_id y una columna llamada puntuacion que sea:
 salary + NVL(commission_pct*100,0) + LENGTH(last_name) + SUBSTR(phone_number,1,2)
 Ordena por puntuacion de mayor a menor.
 */
 SELECT employee_id, salary + NVL(commission_pct*100,0) + LENGTH(last_name) + SUBSTR(phone_number,1,2) AS puntuacion
 FROM employees
 ORDER BY puntuacion DESC;
 /*
 Muestra el nombre completo del empleado (first_name || ' ' || last_name) y el nombre completo de su manager.
 Deben aparecer también los empleados que no tengan manager (el manager saldrá NULL).
 Ordena por apellido del empleado A–Z.
 */
 SELECT emp.first_name || ' ' || emp.last_name AS empleadoNOMAPELLIDO, man.first_name || ' ' || man.last_name AS  MANAGERNOMAPELLIDO
 FROM employees emp
 LEFT JOIN employees man ON (emp.manager_id = man.employee_id)
 ORDER BY  emp.last_name ASC;
 /*
 Muestra city, el número de empleados y el salario medio (redondeado) de cada ciudad.
 Solo cuenta empleados con manager_id asignado.
 Solo muestra ciudades con al menos 3 empleados.
 Ordena por salario medio de mayor a menor.
 */
 SELECT loc.city, COUNT(*), ROUND(AVG(emp.salary))
 FROM employees emp
 JOIN departments dep ON (emp.department_id = dep.department_id)
 JOIN locations loc ON (dep.location_id = loc.location_id)
 WHERE emp.manager_id IS NOT NULL
 GROUP BY loc.city
 HAVING COUNT(*) >= 3
 ORDER BY 3 DESC;
 
/*
 Muestra el department_name, la city y el salario medio de los empleados de cada departamento.
 Deben aparecer también los departamentos sin empleados.
 Solo deben aparecer los departamentos cuyo salario medio sea mayor que 5000 o que no tengan empleados.
 Ordena por city A–Z y luego por salario medio de mayor a menor.
*/
 SELECT dep.department_name, loc.city, AVG(salary)
 FROM departments dep
 LEFT JOIN employees emp ON (emp.department_id = dep.department_id)
 JOIN locations loc ON (dep.location_id = loc.location_id)
 GROUP BY dep.department_name, loc.city
 HAVING AVG(salary) > 5000 OR COUNT(emp.employee_id) = 0
 ORDER BY 2 ASC, 3 DESC;
 
 
/*
 Muestra el job_id, el número de empleados y el salario total de cada job.
 Solo cuenta empleados cuyo apellido empiece por A o S y que tengan manager_id asignado.
 Solo deben aparecer los jobs con entre 2 y 6 empleados.
 Ordena por salario total de mayor a menor.
*/
 
 SELECT job_id, COUNT(*), SUM(salary)
 FROM employees
WHERE last_name LIKE 'A%' OR last_name LIKE 'S%'
AND manager_id IS NOT NULL
GROUP BY job_id
HAVING COUNT(*) BETWEEN 2 AND 6
ORDER BY 3 DESC;


/*
 Muestra el first_name, last_name y salary de los empleados que cobran más que el salario medio de su propio departamento.
 Ordena el resultado por department_id A–Z y luego por salary de mayor a menor.
*/ 
 

 
 SELECT emp.first_name, emp.last_name, emp.department_id, emp.salary
FROM employees emp
WHERE emp.salary > (SELECT AVG(e2.salary)FROM employees e2 WHERE e2.department_id = emp.department_id)
ORDER BY emp.department_id ASC, emp.salary DESC;

/*
 Muestra el department_name y el número de empleados de cada departamento.
 Deben aparecer también los departamentos sin empleados.
 Ordena el resultado por número de empleados de mayor a menor.
*/ 

SELECT dep.department_name, COUNT(*)
FROM employees emp
RIGHT JOIN departments dep ON (emp.department_id = dep.department_id)
GROUP BY dep.department_name
ORDER BY 2 DESC;

/*
 Muestra el job_id, el salario medio y el salario total de cada job.
 Condiciones:
 Solo cuenta empleados con salario mayor que 3000
 Solo deben aparecer los jobs que tengan al menos 2 empleados
 Ordena el resultado por salario total de mayor a menor.
*/
 
 SELECT job_id, AVG(salary), SUM(salary)
 FROM employees
 WHERE salary > 3000
 GROUP BY job_id
 HAVING COUNT(*) >= 2
 ORDER BY 3 DESC;
 
 /*
 Muestra la city, el número de empleados y el salario medio de cada ciudad.
 Condiciones:
 Deben aparecer también las ciudades sin empleados
 Solo muestra ciudades con al menos 2 empleados
 Ordena por salario medio de mayor a menor.
 */
 SELECT loc.city, COUNT(emp.employee_id), AVG(salary)
 FROM locations loc
 LEFT JOIN departments dep ON (loc.location_id = dep.location_id)
 LEFT JOIN employees emp ON (emp.department_id = dep.department_id)
 GROUP BY loc.city
 HAVING COUNT(emp.employee_id) >= 2
 ORDER BY 3 DESC;
 
/*
Muestra el department_name y el salario medio de cada departamento.
Condiciones:
Solo cuenta empleados con salario mayor que 2500
Deben aparecer también los departamentos sin empleados
Ordena el resultado por salario medio de mayor a menor
*/
SELECT dep.department_name, AVG(salary)
FROM departments dep
LEFT JOIN employees emp ON (emp.department_id = dep.department_id)
 AND emp.salary > 2500
GROUP BY dep.department_name
ORDER BY 2 DESC;

/*
Muestra la city y el número de empleados que trabajan en cada ciudad.
Condiciones:
Solo cuenta empleados cuyo apellido empiece por M o S
Deben aparecer también las ciudades sin empleados
Ordena por número de empleados de mayor a menor
*/
SELECT loc.city, COUNT(emp.employee_id)
FROM locations loc
LEFT JOIN departments dep ON (loc.location_id = dep.location_id)
LEFT JOIN employees emp ON (emp.department_id = dep.department_id)
 AND emp.last_name LIKE 'M%' OR  emp.last_name LIKE 'S%'
GROUP BY loc.city
ORDER BY 2 DESC;


/*
Muestra el job_id, el salario mínimo y el salario máximo de cada job.
Condiciones:
Solo cuenta empleados con salario entre 3000 y 9000
Solo deben aparecer los jobs que tengan al menos 3 empleados
Ordena el resultado por salario máximo de mayor a menor
*/
 
 SELECT job_id, MIN(salary), MAX(salary)
 FROM employees
 WHERE salary BETWEEN 3000 AND 9000
 GROUP BY job_id
 HAVING COUNT(*) >= 3
 ORDER BY 3 DESC;
 
 /*
Muestra el department_name y el salario máximo de cada departamento.
Condiciones:
– Solo cuenta empleados cuyo salario sea mayor que 4000
– Deben aparecer también los departamentos sin empleados
– Ordena el resultado por salario máximo de mayor a menor
*/
SELECT dep.department_name, MAX(salary)
FROM departments dep
LEFT JOIN employees emp ON (emp.department_id = dep.department_id)
WHERE salary > 4000
GROUP BY dep.department_name
ORDER BY 2 DESC;


/*
Muestra la city y el número de empleados que trabajan en cada ciudad.
Condiciones:
– Solo cuenta empleados cuyo job_id sea 'SA_REP'
– Deben aparecer también las ciudades sin empleados
– Solo muestra ciudades con al menos 3 empleados
– Ordena por número de empleados de mayor a menor
*/
SELECT loc.city, COUNT(emp.employee_id)
FROM locations loc
LEFT JOIN departments dep ON (loc.department_id = loc.location_id)
LEFT JOIN employees emp ON (dep.department_id = emp.department_id)
GROUP BY loc.city
HAVING COUNT(emp.employee_id) >= 3 AND emp.job_id = 'SA_REP'
ORDER BY 2 DESC;

/*
Muestra el job_id, el salario medio y el salario mínimo de cada job.
Condiciones:
– Solo cuenta empleados con salario mayor que 3000
– Solo deben aparecer los jobs cuyo salario medio sea mayor que 5000
– Ordena el resultado por salario medio de mayor a menor
*/

