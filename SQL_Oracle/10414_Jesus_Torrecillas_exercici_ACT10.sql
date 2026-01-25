--Exercici_ACT10

--Exercici 1: DISSENY DE LA BBDD

CREATE TABLE taula(

    id_taula NUMBER,
    codi VARCHAR2(50),
    nom VARCHAR2(50),
    dimensions NUMBER,
    tipus VARCHAR2(50),
    categoria VARCHAR2(50),
    CONSTRAINT pk_taula PRIMARY KEY (id_taula),
    CONSTRAINT uk_codi UNIQUE (codi),
    CONSTRAINT ck_categoria_taula CHECK (categoria IN ('A','B','C','D'))
    
);

CREATE TABLE plantilla(

    id_elf NUMBER,
    nom VARCHAR2(50),
    alçada NUMBER,
    pes NUMBER,
    color_preferit VARCHAR2(50),
    categoria VARCHAR2(50),
    id_taula NUMBER,
    CONSTRAINT pk_elf PRIMARY KEY (id_elf),
    CONSTRAINT ck_nom CHECK (nom IS NOT NULL),
    CONSTRAINT ck_categoria_elf CHECK (categoria IN ('A','B','C','D')),
    CONSTRAINT fk_elf_taula FOREIGN KEY (id_taula) REFERENCES taula(id_taula)
    
    
);


CREATE TABLE jougina(

    id_jougina NUMBER,
    nom VARCHAR2(50),
    pes NUMBER,
    temps_fabricacio NUMBER,
    descripcion VARCHAR2(100),
    id_taula NUMBER,
    CONSTRAINT fk_jougina_taula FOREIGN KEY (id_taula) REFERENCES taula(id_taula)

);

INSERT INTO cueva(id_cueva,capacidad,codigo) VALUES (4,12,'C0004');
--Exercici 3: INSERCIÓ DE DADES

INSERT INTO taula VALUES (1,'taula1','InfoTaula',10,'Info','A');
INSERT INTO taula VALUES (2,'taula2','La Taula',20,'Fusta','A');
INSERT INTO taula VALUES (3,'taula3','MecaTaula',15,'Mecànic','B');
INSERT INTO taula VALUES (4,'taula4','WonkaTab',10,'Dolç','B');
INSERT INTO taula VALUES (5,'taula5','MiniMeca',10,'Mecànic','C');
INSERT INTO taula VALUES (6,'taula6','La mini taula',5,'Fusta','C');
INSERT INTO taula VALUES (7,'taula7','SatnaTex',25,'Textil','C');

INSERT INTO plantilla (id_elf,nom,alçada,pes,color_preferit,categoria,id_taula)VALUES(1,'Gelbin',0.6,10,'Verd','A',1);
INSERT INTO plantilla VALUES(2,'Sicco',0.7,8,'Groc','A',2);
INSERT INTO plantilla VALUES(3,'Erbag',0.65,12,'Vermell','A',2);
INSERT INTO plantilla VALUES(4,'Indus',0.8,10,'Vermell','A',3);
INSERT INTO plantilla VALUES(5,'Silas',0.7,9,'Blau','B',3);
INSERT INTO plantilla VALUES(6,'Wilfred',0.6,8,'Blanc','B',5);
INSERT INTO plantilla VALUES(7,'Linken',0.45,9,'Taronja','C',7);
INSERT INTO plantilla VALUES(8,'Narain',0.78,10,'Blau','B',7);
INSERT INTO plantilla VALUES(9,'Toshley',0.69,11,'Vermell','A',7);

INSERT INTO jougina VALUES(1,'PCToy',2,60,'Pc molón',1);
INSERT INTO jougina VALUES(2,'GamePad',0.9,50,'Tablet per no estudiar',1);
INSERT INTO jougina VALUES(3,'Soldat',0.2,5,'Soldadet de fusta',2);
INSERT INTO jougina VALUES(4,'Ironman',0.3,3,'Joguina d’acció',3);
INSERT INTO jougina VALUES(5,'Piruleta',0.07,1,'Sabor cirera',4);
INSERT INTO jougina VALUES(6,'Carbó',0.05,1,'De sucre',4);
INSERT INTO jougina VALUES(7,'Emanems',0.01,1,'De tots colors',4);
INSERT INTO jougina VALUES(8,'Rayo mcqueen',0.2,6,'Cachao!',5);
INSERT INTO jougina VALUES(9,'Jenga',0.9,8,'50 peces',6);
INSERT INTO jougina VALUES(10,'LegoWood',0.8,6,'Inflamable',6);
INSERT INTO jougina VALUES(11,'Samarreta',0.1,4,'Suuuper molona',7);
INSERT INTO jougina VALUES(12,'Mitjons',0.08,2,'Vermells, molt vermells',7);

SELECT * FROM taula
;

--Exercici 4: MODIFICACIÓ DE TAULES i DADES 

ALTER TABLE plantilla ADD responsable VARCHAR2(50);
 
UPDATE plantilla SET responsable = NULL WHERE  id_elf = 1;
UPDATE plantilla SET responsable = 'Gelbin' WHERE  id_elf = 2;
UPDATE plantilla SET responsable = 'Gelbin' WHERE  id_elf = 3;
UPDATE plantilla SET responsable = 'Sicco' WHERE  id_elf = 4;
UPDATE plantilla SET responsable = 'Sicco' WHERE  id_elf = 5;
UPDATE plantilla SET responsable = 'Erbag' WHERE  id_elf = 6;
UPDATE plantilla SET responsable = 'Erbag' WHERE  id_elf = 7;
UPDATE plantilla SET responsable = 'Silas' WHERE  id_elf = 8;
UPDATE plantilla SET responsable = 'Silas' WHERE  id_elf = 9;

--Exercici 5: MÉS MODIFICACIONS I ELIMINACIONS 

    --Canvia la categoria de les taules 3,5 i 7 perquè siguin de categoria D
    
UPDATE taula SET categoria = 'D' WHERE id_taula = 3;
UPDATE taula SET categoria = 'D' WHERE id_taula = 5;
UPDATE taula SET categoria = 'D' WHERE id_taula = 7;

 -- Canvia el pes de l’elf “Silas” a 11. 
 
 UPDATE plantilla SET pes = 11 WHERE id_elf =5;
 
 -- Modifica la joguina d’Ironman perquè es fabriqui a la taula5. 
 
 UPDATE jougina SET id_taula = 5 WHERE id_jougina = 4;
 
 --Modifica la joguina LegoWood perquè pesi 1.2, el temps de fabricació sigui de 4 i 
 --la descripció sigui “De fusta i inflamable”. 
 
 UPDATE jougina SET pes = 1.2 WHERE id_jougina = 10;
 UPDATE jougina SET temps_fabricacio = 4 WHERE id_jougina = 10;
 UPDATE jougina SET descripcion = 'De fusta i inflamable' WHERE id_jougina = 10;

--Elimina la joguina “mitjons”. 

DELETE FROM jougina WHERE id_jougina = 12;

-- Elimina a l’elf “Narain”. 

DELETE FROM plantilla WHERE id_elf = 8;

-- Elimina a l’elf “Gelbin”

DELETE FROM plantilla WHERE id_elf = 1;

UPDATE plantilla SET responsable = NULL WHERE responsable = 'Gelbin';

COMMIT;



--Elimina la taula 7 de fabricació.

DELETE FROM taula WHERE id_taula = 7;

ALTER TABLE jougina DROP CONSTRAINT fk_jougina_taula;
ALTER TABLE jougina ADD CONSTRAINT fk_jougina_taula FOREIGN KEY (id_taula) REFERENCES taula(id_taula) ON DELETE CASCADE;


ALTER TABLE plantilla DROP CONSTRAINT fk_elf_taula;
ALTER TABLE plantilla ADD CONSTRAINT fk_elf_taula FOREIGN KEY (id_taula) REFERENCES taula(id_taula) ON DELETE CASCADE;
