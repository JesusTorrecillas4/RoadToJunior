-- Comentario de texto de una linea

/*
    Comentario milti-linea

*/

/*
    Apuntes PW.10 - DDL -CREACION DE TABLAS

*/

CREATE TABLE orca(
    id_orca NUMBER,
    nombre VARCHAR2(50),
    peso NUMBER,
    fecha_nacimiento DATE
);

CREATE TABLE cueva(

    id_cueva NUMBER,
    codigo VARCHAR2(10),
    dimensiones NUMBER,
    capacidad NUMBER,
    zona VARCHAR2(50)
);


/* CONSTRAINTS - RESTRICCIONES SOBRE LAS COLUMNAS P.17

    TIPOS:
        -PRIMARY KEY - Clave unica de la tabla
        -FOREIGN KEY - Clave externa (referencia a otra tabla)
        -UNIQUE - Restriccion para valores unicos sin ser PK
        -CHECK - Condiciones en los valores validos
            -NOT NULL -Restriccion de campo obligatorio
       
*/
--Ejemplo bueno de CONSTRAINT--
CREATE TABLE orca(
    id_orca NUMBER,
    nombre VARCHAR2(50),
    peso NUMBER,
    fecha_nacimiento DATE,
    CONSTRAINT pk_orca PRIMARY KEY (id_orca)
);

--Ejemplo malo de CONSTRAINT--
CREATE TABLE cueva(

    id_cueva NUMBER PRIMARY KEY,
    codigo VARCHAR2(10) UNIQUE,
    dimensiones NUMBER,
    capacidad NUMBER NOT NULL,
    zona VARCHAR2(50)
   
);

--Ejemplo completo de CONSTRAINTS--
CREATE TABLE pinguino(
    id_pinguino NUMBER,
    nombre VARCHAR(100),
    peso NUMBER,
    altura NUMBER,
    fecha_nacimiento DATE,
    sexo VARCHAR2(1),
    rip_date DATE,
    id_orca NUMBER,
    id_cueva NUMBER,
    id_madre NUMBER,
    CONSTRAINT pk_pinguino PRIMARY KEY (id_pinguino),
    CONSTRAINT uk_pinguino_nombre UNIQUE (nombre),
    CONSTRAINT fk_pinguino_orca FOREIGN KEY (id_orca) REFERENCES orca(id_orca),
    CONSTRAINT fk_pinguino_cueva FOREIGN KEY (id_cueva) REFERENCES cueva(id_cueva),
    CONSTRAINT ck_pinguino_sexo CHECK (sexo = 'M' OR sexo = 'F'),
    --CONSTRAINT ck_pinguino_sexo CHECK (sexo IN ('M','F'))-- Tambien puedes hacerlo de esta forma
    CONSTRAINT ck_pingu_peso CHECK (peso >= 0),
    --Condicion de valor obligatorio
    CONSTRAINT ck_pinguino_altura CHECK (altura IS NOT NULL),
    CONSTRAINT fk_pinguino_madre FOREIGN KEY (id_madre) REFERENCES pinguino(id_pinguino)

    );
   
   
    /*
        MODIFICACION DE TABLAS - ALTER
    */

    ALTER TABLE pinguino ADD id_padre NUMBER;
    ALTER TABLE pinguino ADD CONSTRAINT fk_pinguino FOREIGN KEY (id_padre) REFERENCES pinguino(id_pinguino);
   







/* aPUNTES ELIMINAR TABLAS - DEFINITIVAMENTE Y EN CASCADA P.39   */

/*
DROP TABLE cueva CASCADE CONSTRAINTS PURGE;
DROP TABLE orca CASCADE CONSTRAINTS PURGE;
DROP TABLE pinguino CASCADE CONSTRAINT PURGE;
*/

/*
    DML - Lenguaje de manipulacion de datos
*/
-- Inserción de datos -PG-6,7
-- Insteratar informando de todas las columnas. Orden importa!

INSERT INTO cueva VALUES (1,'C0001',32,8,'Playa01');
INSERT INTO cueva VALUES (2,'C0002',null,10,null);
INSERT INTO cueva VALUES (3,'C0003',null,7,'Playa01');


DESC cueva;

--Insertar indormando de ALGUNOS CAMPOS. Orden NO importa, le cambo el orden para ver que no immporta en este momento

INSERT INTO cueva(id_cueva,capacidad,codigo) VALUES (4,12,'C0004');
INSERT INTO cueva(zona,id_cueva,dimensiones,codigo,capacidad) VALUES ('Montaña01',5,6,'C0005',3);

DESC pinguino;

INSERT INTO pinguino VALUES (1,'Paco',15,1.2,'01/01/2017','M',null,null,3,null,null);
INSERT INTO pinguino VALUES (2,'Paca',13,1,'02/03/2022','F','26/10/2025',10,1,null,null);


INSERT INTO orca VALUES (10,'Willy',1000,'30/12/2010');
INSERT INTO orca VALUES (20,'Sally',1500,'11/05/2022');
INSERT INTO orca VALUES (30,'Rocky',180,SYSDATE);

DESC orca;



INSERT INTO pinguino VALUES (3,'egfas',1,1000,'27,10,2020','F',null,null,null,null,null);

-- DESHACER ACCIONES DML

ROLLBACK;

SELECT * FROM orca;
SELECT * FROM pinguino;
SELECT * FROM cueva;


-- GUARDAR CAMBIOS DML

COMMIT;

-- ELIMINAR REGISTROS
--ELIMINO EL ORCA 30
DELETE FROM orca WHERE id_orca = 30;

--INTENTO ELIMINAR LA CUEVA 4 (no se puede porque esta en uso)
DELETE FROM pinguino WHERE id_cueva = 4;
-- ME OLVIDOE EL WHERE
DELETE FROM pinguino;

SELECT * FROM pinguino;
ROLLBACK;

--UPDATE - Actualización de registros

SELECT * FROM pinguino;

--Actualizamos ref a la orca que se lo come
UPDATE pinguino SET id_orca = 20 WHERE id_pinguino = 2;

UPDATE pinguino SET nombre = 'Federico',peso = 12, altura= 0.9,id_padre=1 WHERE id_pinguino = 3;

--Cambio de sexo del poinguino 3

UPDATE pinguino SET sexo = 'M' WHERE id_pinguino = 3;

SELECT * FROM cueva;
-- Actualizar varios registros

UPDATE cueva SET zona = 'Playa02' WHERE id_cueva IN (2,3);