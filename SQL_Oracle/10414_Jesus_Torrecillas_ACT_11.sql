
--  ACT11


--Exercici 1: DISSENY DE LA BBDD


--Línia de Producció i Historial Producció: 1 - N

--Producte i Historial Producció: 1 - N

--Estoc Unicorn i Comanda d’Unicorn: 1 - N

--Exercici 2: CREACIÓ DE LES TAULES

CREATE TABLE linea_produccion(

    id_linea NUMBER,
    codi VARCHAR2(50),
    capacitat_diaria NUMBER,
    estat VARCHAR2(50),
    CONSTRAINT pk_linea PRIMARY KEY (id_linea),
    CONSTRAINT uk_linea_codi UNIQUE (codi)
);

CREATE TABLE producte(

    id_producte NUMBER,
    codi_producte VARCHAR2(50),
    nom VARCHAR2(50),
    categoria VARCHAR2(50),
    preu_unitari NUMBER,
    CONSTRAINT pk_producte PRIMARY KEY (id_producte),
    CONSTRAINT uk_producte_codi UNIQUE (codi_producte)
);

CREATE TABLE estoc(

    id_estoc NUMBER,
    tipus VARCHAR2(50),
    quantitat NUMBER,
    descripcion VARCHAR2(100),
    CONSTRAINT pk_estoc PRIMARY KEY (id_estoc)
);

CREATE TABLE historial(

    id_historial NUMBER,
    data_produccion DATE,
    quantitat_generada NUMBER,
    id_linea NUMBER,
    id_producte NUMBER,
    CONSTRAINT pk_historial PRIMARY KEY (id_historial),
    CONSTRAINT fk_historial_linea FOREIGN KEY (id_linea) REFERENCES linea_produccion(id_linea)  ON DELETE SET NULL,
    CONSTRAINT fk_historial_producte FOREIGN KEY (id_producte) REFERENCES producte(id_producte)  ON DELETE SET NULL

);

CREATE TABLE comanda(

    id_comanda NUMBER,
    data_comanda DATE,
    quantitat_solicitada NUMBER,
    id_estoc NUMBER,
    CONSTRAINT pk_comanda PRIMARY KEY (id_comanda),
    CONSTRAINT fk_comanda_estoc FOREIGN KEY (id_estoc) REFERENCES estoc(id_estoc)  ON DELETE SET NULL

);


--Exercici 3: INSERCIÓ DE DADES

INSERT INTO linea_produccion VALUES(1,'LP-001',50,'Operativa');
INSERT INTO linea_produccion VALUES(2,'LP-002',30,'En manteniment');
INSERT INTO linea_produccion VALUES(3,'LP-003',40,'En espera');

INSERT INTO estoc VALUES(1,'Unicorn Arc de Sant Martí',15,'Unicorns amb banyes brillants i poder de curació.');
INSERT INTO estoc VALUES(2,'Unicorn Negre',8,'Unicorns de carn tendre i poder màgic ocult.');
INSERT INTO estoc VALUES(3,'Unicorn Celestial',10,'Unicorns amb ales que es poden usar en rituals..');
INSERT INTO estoc VALUES(4,'Unicorn Daurat',5,'Unicorns amb banyes d’or, ideals per a ornamentació.');

INSERT INTO producte VALUES(1,'P-001','Filets d Unicorn','Carn',NULL);
INSERT INTO producte VALUES(2,'P-002','Banya Polida d Unicorn','Adorn',NULL);
INSERT INTO producte VALUES(3,'P-003','Sopa Màgica d Unicorn','Alimentació',NULL);
INSERT INTO producte VALUES(4,'P-004','Pols d Unicorn','Ingredient Màgic',NULL);


--Exercici 3: INSERCIÓ DE DADES AMB REFERÉNCIES

INSERT INTO historial VALUES(1, TO_DATE('15/01/2024', 'DD/MM/YYYY'), 25, 1, 1);
INSERT INTO historial VALUES(2, TO_DATE('20/01/2024', 'DD/MM/YYYY'), 30, 3, 1);
INSERT INTO historial VALUES(3, TO_DATE('18/01/2024', 'DD/MM/YYYY'), 5, 2, 4);

INSERT INTO comanda VALUES(1,TO_DATE('10/08/2003', 'DD/MM/YYYY'),9,3);
INSERT INTO comanda VALUES(2,TO_DATE('17/07/2025', 'DD/MM/YYYY'),14,4);
INSERT INTO comanda VALUES(3,TO_DATE('23/12/2019', 'DD/MM/YYYY'),7,2);

--Exercici 4: MODIFICACIÓ DE DADES


UPDATE linea_produccion SET capacitat_diaria = 70 WHERE id_linea = 1;
UPDATE linea_produccion SET capacitat_diaria = 50 WHERE id_linea = 2;
UPDATE linea_produccion SET capacitat_diaria = 60 WHERE id_linea = 3;

UPDATE estoc SET quantitat = 51 WHERE id_estoc = 3;

UPDATE producte SET codi_producte = 'P-016' WHERE id_producte = 4;

UPDATE producte SET preu_unitari = 500 WHERE id_producte = 1;
UPDATE producte SET preu_unitari = 200 WHERE id_producte = 2;
UPDATE producte SET preu_unitari = 450 WHERE id_producte = 3;
UPDATE producte SET preu_unitari = 650 WHERE id_producte = 4;

--Exercici 5: MODIFICACIÓ DE TAULES

ALTER TABLE linea_produccion ADD descripcion VARCHAR2(150);
ALTER TABLE linea_produccion MODIFY codi VARCHAR2(150);
ALTER TABLE historial ADD id_estoc NUMBER;
ALTER TABLE historial 
ADD CONSTRAINT fk_historial_estoc FOREIGN KEY (id_estoc) REFERENCES estoc(id_estoc) ON DELETE SET NULL;

ALTER TABLE estoc ADD CONSTRAINT ck_estoc_quantitat_positiva CHECK (quantitat >= 0);
ALTER TABLE producte DROP COLUMN categoria;
ALTER TABLE producte RENAME COLUMN preu_unitari TO preu;
ALTER TABLE comanda ADD data_creacio DATE DEFAULT SYSDATE;
ALTER TABLE linea_produccion MODIFY codi VARCHAR2(50) NOT NULL;
ALTER TABLE producte ADD CONSTRAINT ck_producte_preu_rango CHECK (preu BETWEEN 0 AND 50000);
ALTER TABLE linea_produccion ADD CONSTRAINT ck_linea_estat_valido CHECK (estat IN ('Operativa', 'En manteniment', 'En espera'));


--Exercici 6: FREEDOM FOR THE UNICORNS.

DROP TABLE linea_produccion CASCADE CONSTRAINTS PURGE;
DROP TABLE producte CASCADE CONSTRAINTS PURGE;
DROP TABLE estoc CASCADE CONSTRAINTS PURGE;
DROP TABLE historial CASCADE CONSTRAINTS PURGE;
DROP TABLE comanda CASCADE CONSTRAINTS PURGE;

commit;

