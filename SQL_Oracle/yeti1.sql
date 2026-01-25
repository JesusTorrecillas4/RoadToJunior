-- ACT 08

CREATE TABLE camionero(

    id_camionero NUMBER,
    dni NUMBER,
    telefon NUMBER,
    salari NUMBER,
    nom VARCHAR2(50),
    cognom VARCHAR2(50),
    poblacio VARCHAR2(50)
);

CREATE TABLE camion(

    id_camion NUMBER,
    matricula NUMBER,
    model VARCHAR2(50),
    tipus VARCHAR2(50),
    potencia VARCHAR2(50)
);

CREATE TABLE paquet(

    id_paquet NUMBER,
    codi NUMBER,
    descripcio VARCHAR2(50),
    carrer VARCHAR2(50),
    destinatari VARCHAR2(50)
);

CREATE TABLE provincia(

    id_provincia NUMBER,
    codi NUMBER,
    nom VARCHAR2(50)
);


DROP TABLE camionero CASCADE CONSTRAINTS PURGE;