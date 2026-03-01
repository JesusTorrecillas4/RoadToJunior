--Aqui pondre todo lo aprendido en SQL
--Todo estara resumido

--Crear Tablas
CREATE TABLE tablaejemplo(

    id_ejemplo NUMBER,
    nombre VARCHAR2(200),
    sexo VARCHAR2(1),
    altura NUMBER,
    CONSTRAINT pk_tablaejemplo  PRIMARY KEY (id_ejemplo),
    CONSTRAINT uk_tablaejemplo_nombre UNIQUE (nombre),
    CONSTRAINT ck_tablaejemplo CHECK (sexo = 'M' OR 'F')
     --CONSTRAINT ck_pinguino_sexo CHECK (sexo IN ('M','F'))-- Tambien puedes hacerlo de esta forma
     CONSTRAINT ck_altura CHECK (altura IS NOT NULL)
);

CREATE TABLE ejemploforeign(

    id_foreign NUMBER,
    nombre VARCHAR2(100),
    id_ejemplo NUMBER,
    CONSTRAINT pk_foreign PRIMARY KEY (id_foreign),
    CONSTRAINT fk_foreign_tablaejemplo FOREIGN KEY (id_ejemplo) REFERENCES tablaejemplo(id_ejemplo)
);

--Modificar tabla 

ALTER TABLE tablaejemplo ADD id_foreign NUMBER;
ALTER TABLE tablaejemplo ADD CONSTRAINT fk_tablaejemplo_foreign FOREIGN KEY (id_foreign) REFERENCES ejemploforeign(id_foreign);



--Añadir datos a las tablas
INSERT INTO tablaejemplo VALUES (1,'Jesus',M,163,2);
INSERT INTO ejemploforeing VALUES (2,'Pedro',1);

--Eliminar tabla definitivamente y en cascada

DROP TABLE tablaejemplo CASCADE CONSTRAINT PURGE;
DROP TABLE ejmploforeign CASCADE CONSTRAINT PURGE;

--Ver info de la tabla
DESC tablaejemplo;

--Eliminar algo exacto
DELETE FROM tablaejemplo WHERE id_ejemplo = 1;

--Actualizar datos

UPDATE tablaejemplo SET nombre='Juan' WHERE id_ejemplo   = 1;


--Ahora con las Queris , esto solo enseña informacion lo que hagas no modificara la tabla
--Aqui pondre ejemplos de las tablas que proporciona hr ya que quiero poner salarios y JOINS

SELECT id_ejemplo AS id_del_ejemplo
FROM tablaejemplo
WHERE id_ejemplo = 1;

SELECT emp.first_name, dep.department_name, AVG(salary)
FROM employees emp
JOIN departments dep ON (emp.department_id = dep.department_id)
GROUP BY emp.first_name, dep.department_name
HAVING AVG(salary) > 1000;



--Ahora PLSQL es la programacion de bases de datos

--Esta funcion se teine que activar cada vez que inciamos despues de cerrar el archivo
SET SERVEROUTPUT ON;

--Bloque Anonimo
/
DECLARE
    --Variables
    v_fn VARCHAR2(200);
    v_salary NUMBER;
BEGIN
    SELECT first_name, salary
    INTO v_fn, v_salary
    FROM employees
    WHERE employee_id = 100;
    
    --Lo printamos en la terminal
    DBMS_OUTPUT.PUT_LINE('El nombre del empleado con id 100 es '|| v_fn || ' y su salario es '|| v_salary);
END;
/
/
--Funcion
--Esta es la sintaxis de una funcion
CREATE OR REPLACE FUNCTION nobre_funcion (paramatro_1, paramentro_2)
RETURN tipo_dato
IS
 --VARIABLES
BEGIN
 --Codigo
 RETUNR algo;
END;
/

--Funcioin















