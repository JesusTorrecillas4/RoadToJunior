-- 1
CREATE USER ASIX
IDENTIFIED BY 1234
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP
QUOTA 700K ON USERS;

--2
CREATE ROLE BASIC_PRIVS;

GRANT CREATE SESSION TO BASIC_PRIVS;
GRANT CREATE TABLE TO BASIC_PRIVS;
GRANT CREATE VIEW TO BASIC_PRIVS;
GRANT CREATE SEQUENCE TO BASIC_PRIVS;
GRANT CREATE SYNONYM TO BASIC_PRIVS;

GRANT BASIC_PRIVS TO ASIX;

-- 4
CONNECT ASIX/1234;

CREATE TABLE DEPARTAMENTS (
    ID_DEPARTAMENT NUMBER PRIMARY KEY,
    NOM_DEPARTAMENT VARCHAR2(50) NOT NULL
);

CREATE TABLE ALUMNES (
    ID_ALUMNE NUMBER PRIMARY KEY,
    NOM_ALUMNE VARCHAR2(50) NOT NULL,
    EDAT NUMBER,
    ID_DEPARTAMENT NUMBER,
    CONSTRAINT FK_ALUMNES_DEPARTAMENTS
        FOREIGN KEY (ID_DEPARTAMENT)
        REFERENCES DEPARTAMENTS(ID_DEPARTAMENT)
);

-- 5
INSERT INTO DEPARTAMENTS VALUES (1, 'Informàtica');
INSERT INTO DEPARTAMENTS VALUES (2, 'Administració');

INSERT INTO ALUMNES VALUES (1, 'Joan', 20, 1);
INSERT INTO ALUMNES VALUES (2, 'Maria', 21, 1);

INSERT INTO ALUMNES VALUES (3, 'Pau', 19, 2);
INSERT INTO ALUMNES VALUES (4, 'Laura', 22, 2);

-- 6

CREATE USER SMX
IDENTIFIED BY 1234
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP
QUOTA 700K ON USERS;

-- 7
GRANT CREATE SESSION TO SMX;
CONNECT ASIX/1234;
GRANT SELECT ON DEPARTAMENTS TO SMX;
GRANT SELECT ON ALUMNES TO SMX;
GRANT UPDATE (EDAT) ON ALUMNES TO SMX;


/*8. Des de l’usuari SMX crea una vista a l’esquema ASIX que mostri totes les dades de les 
dues taules. 
• Per exemple, sobre la BBDD HR seria  
→ Vista que mostri tota la informació dels empleats amb tota la informació del 
seu departament.*/


-- 9. Intenta seleccionar tota la informació de la nova vista amb l’usuari HR. 

-- 10. Intenta seleccionar tota la informació de la nova vista amb l’usuari ASIX. 

-- 11. Intenta seleccionar tota la informació de la nova vista amb l’usuari SMX. 

/*12. Amb l’usuari SMX, comprova que pots modificar dades de la columna d’ASIX on té 
permisos. I comprova que no pots modificar la resta de columnes.*/ 

/*
13. Treu-li a SMX el permís per modificar la columna anterior, i comprova que ja no pots fer 
modificacions. */

/*14. Mostra les vistes de diccionari on es mostrin: 
• Els usuaris creats. 
• Els rols creats. 
• Els privilegis del/s rol/s creats. 
• Els privilegis dels usuaris creats. 
• Els rols otorgats als usuaris creats.*/