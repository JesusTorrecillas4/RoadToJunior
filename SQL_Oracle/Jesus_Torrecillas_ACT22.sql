
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
