
--EXERCICI 1 
--a) Consulta el llistat de TOTS els usuaris de la BBDD.
SELECT * FROM dba_users;
--b) Mostra un llistat de TOTS els roles de la BBDD.
SELECT * FROM dba_roles;
--c) Mostra els privilegis que tenen els rols ‘CONNECT’ i ‘SCHEDULER_ADMIN’.
SELECT * FROM dba_sys_privs WHERE GRANTEE IN('CONNECT', 'SCHEDULER_ADMIN');
--d) Mostra un llistat de tots els usuaris i rols que contenen el privilegi ‘unlimited tablespace’.
SELECT * FROM dba_sys_privs WHERE PRIVILEGE = 'UNLIMITED TABLESPACE';
--Es tracta d’un privilegi d’objecte o de sistema? Es un privilegi de sistema
--e) Què significa donar privilegis a PUBLIC? Dar un privilegio PUBLIC hace que todo los usuarios de la base de datos 
--reciban automaticamente este privilegio
--f) Quin privilegi de sistema fa possible la creació d’usuaris? I la connexió a la base de dades? 
--CREATE USER / CREATE SESSION
--g) Mostra el llistat de rols que contenen els privilegis del punt anterior. 
SELECT * FROM dba_sys_privs WHERE PRIVILEGE IN ('CREATE USER', 'CREATE SESSION');

--EXERCICI 2

--a) Crea un rol anomenat “devop”. 
CREATE ROLE devop;
--b) Assigna al rol “devop”, permisos per crear “qualsevol” objecte a la BBDD, modificar-los, 
--connectar-se a la BBDD. IMPORTANT! El “devop” no ha de poder consultar dades.
GRANTEE devop TO PUBLIC;
--c) Crea un usuari amb el teu nom i assigna-li el rol “devop”.

--d) Crea l’usuari “webaplic”. S’ha de poder connectar a la base de dades. 

--e) Sobre el seu esquema executa l’arxiu 1.1_ACTEXTRA01.sql. Aquest script SQL crearà els 
--següents objectes dins l’esquema de “webaplic”. 




SET SERVEROUTPUT ON;
  
  
/*  
EJERCICIO 1
*/
-- Conecto con SYS
CONNECT SYS/1234 AS SYSDBA;

-- A
SELECT username FROM dba_users;

-- B
SELECT role FROM dba_roles;

-- C
SELECT grantee, privilege
FROM dba_sys_privs
WHERE UPPER(grantee) IN ('CONNECT', 'SCHEDULER_ADMIN');

-- D
SELECT grantee
FROM dba_sys_privs
WHERE privilege = 'UNLIMITED TABLESPACE';

-- E
/*
    Que das a todos los usuarios de la base de datos
*/

-- F
/*
    CREATE USER ...
    
    CREATE SESSION ...
*/

-- G
SELECT grantee, privilege
FROM dba_sys_privs
WHERE privilege IN ('CREATE USER', 'CREATE SESSION');




/*
EJERCICIO 2
*/

-- A
CREATE ROLE devop;

-- B
GRANT CREATE ANY TABLE TO devop;
GRANT CREATE ANY VIEW TO devop;
GRANT CREATE ANY PROCEDURE TO devop;
GRANT CREATE ANY SEQUENCE TO devop;
GRANT CREATE SESSION TO devop;

-- C
CREATE USER izan IDENTIFIED BY 1234;
GRANT devop TO izan;
GRANT CREATE SESSION TO izan;

-- D
CREATE USER webaplic IDENTIFIED BY 1234;
GRANT CREATE SESSION TO webaplic;
GRANT CREATE TABLE TO webaplic;
GRANT CREATE SEQUENCE TO webaplic;
GRANT CREATE PROCEDURE TO webaplic;

-- Con esto quito un error que salia en el apartado E
ALTER USER webaplic QUOTA UNLIMITED ON SYSTEM;

-- E
CONNECT webaplic/1234;

CREATE TABLE webaplic.users (
  user_id NUMBER,
  user_name VARCHAR2(50),
  user_pass VARCHAR2 (50),
  creation_date DATE,
  enabled VARCHAR2(3),
  constraint pk_users primary key (user_id)
);

CREATE TABLE webaplic.user_hist(
  hist_id NUMBER,
  description VARCHAR2(250),
  creation_date DATE,
  user_id NUMBER,
  CONSTRAINT pk_user_hist PRIMARY KEY (hist_id),
  CONSTRAINT fk_users_hist FOREIGN KEY (user_id)
    REFERENCES webaplic.users(user_id)
);

--mdf by Alex M 24/04/24
CREATE SEQUENCE webaplic.seq_users INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE webaplic.seq_hist_write INCREMENT BY 1 START WITH 1;
--end mdf.

INSERT INTO webaplic.users VALUES(
  webaplic.seq_users.NEXTVAL, 'Pepe','1234',SYSDATE,'yes');
INSERT INTO webaplic.users VALUES(
  webaplic.seq_users.NEXTVAL, 'Juan','1234',SYSDATE,'yes');
  
CREATE OR REPLACE PROCEDURE webaplic.hist_write(p_user_name IN VARCHAR2, 
                                          p_description IN VARCHAR2) AS
  v_user_id webaplic.users.user_id%TYPE; --NUMBER;
  BEGIN
    SELECT u.user_id INTO v_user_id
      FROM webaplic.users u
      WHERE u.user_name = p_user_name;
  
    INSERT INTO webaplic.user_hist VALUES(
      webaplic.seq_hist_write.NEXTVAL,
      p_description,
      SYSDATE,
      v_user_id);
      DBMS_OUTPUT.put_line('Mensaje insertado:');
     COMMIT;
  EXCEPTION
    WHEN OTHERS THEN
      raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
      ROLLBACK;
  END hist_write;
 
 / 
 
  EXECUTE webaplic.hist_write('Pepe','Borrado de tablas');
  EXECUTE webaplic.hist_write('Pepe','Borrado de registros');
  EXECUTE webaplic.hist_write('Juan','Creaci�n de tablas');
  EXECUTE webaplic.hist_write('Juan','Creaci�n de usuarios');
  EXECUTE webaplic.hist_write('Juan','Backup de la base de datos');

-- F
CONNECT SYS/1234 AS SYSDBA;

CREATE USER webuser IDENTIFIED BY 1234;

-- G
GRANT CREATE SESSION TO webuser;
GRANT EXECUTE ON webaplic.hist_write TO webuser;




/*
EJERCICIO 3
*/
CONNECT webuser/1234;

-- A
SELECT * FROM webaplic.users;

-- B
INSERT INTO webaplic.user_hist VALUES (1,'test',SYSDATE,1);

-- C
EXEC webaplic.hist_write('Pepe','Prueba desde webuser');

-- D
CONNECT izan/1234;

SELECT * FROM webaplic.user_hist;

-- E
CONNECT webaplic/1234;

SELECT * FROM user_hist;

-- F
GRANT SELECT ON webaplic.users TO izan;
GRANT SELECT ON webaplic.user_hist TO izan;

CONNECT izan/1234;

CREATE VIEW vista_historial AS
    SELECT u.user_name, h.description FROM webaplic.users u
    JOIN webaplic.user_hist h ON (u.user_id = h.user_id);

-- G
CONNECT SYS/1234 AS SYSDBA;

GRANT SELECT ON izan.vista_historial TO webuser;

-- H
SELECT * FROM dba_sys_privs
WHERE grantee IN ('WEBUSER','WEBAPLIC','IZAN');

SELECT * FROM dba_tab_privs
WHERE grantee IN ('WEBUSER','WEBAPLIC','IZAN');

SELECT * FROM dba_role_privs
WHERE grantee IN ('WEBUSER','WEBAPLIC','IZAN');




/*
EJERCICIO 4
*/

-- A
REVOKE devop FROM izan;
REVOKE CREATE SESSION FROM webuser;
REVOKE EXECUTE ON webaplic.hist_write FROM webuser;

-- B
DROP USER izan CASCADE;
DROP USER webuser CASCADE;
DROP USER webaplic CASCADE;