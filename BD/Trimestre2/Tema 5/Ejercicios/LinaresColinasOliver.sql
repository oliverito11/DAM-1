        -- EJERCICIO A --
USE EJERCICIOS;
DROP TABLE IF EXISTS RESTRIC;
CREATE TABLE RESTRIC(
    COD INT UNIQUE,
    NOM VARCHAR(10) NOT NULL,
    LET CHAR(2) DEFAULT 'A',
    CANT INT,
    CONSTRAINT CK_CANT CHECK(CANT > 0 AND CANT < 10)
);

    -- INSERCCIÓN DE VALORES --
-- CANT NO PUEDE SER MAYOR DE 10 --
INSERT INTO RESTRIC
    VALUES('1', 'PABLO', 'P', 11);

INSERT INTO RESTRIC
    VALUES(NULL, 'PABLO', 'P', 5);

INSERT INTO RESTRIC(CANT)
    VALUES(8);

INSERT INTO RESTRIC(LET)
    VALUES(NULL);

-- VALORES POR DEFECTO --
INSERT INTO RESTRIC
    VALUES(DEFAULT, DEFAULT, DEFAULT, DEFAULT);

-- NOM NO PUEDE SER NULL --
INSERT INTO RESTRIC
    VALUES(2, NULL, NULL, NULL);

INSERT INTO RESTRIC
    VALUES(2, DEFAULT, NULL, NULL);

-- COD NO PUEDE SER DUPLICADO --
INSERT INTO RESTRIC
    VALUES(3, DEFAULT, NULL, NULL);

INSERT INTO RESTRIC
    VALUES(3, DEFAULT, NULL, NULL);

        -- EJERCICIO B --

-- CREACIÓN DE LA TABLA --
USE COMERCIAL;
DROP TABLE IF EXISTS CONSULT;
CREATE TABLE CONSULT
    SELECT *
        FROM PED
        WHERE NP = 'P4';

-- INSERCCIÓN DE VALORES --
INSERT INTO CONSULT
    SELECT *
        FROM PED
        WHERE CANTIDAD > (SELECT AVG(CANTIDAD)
                            FROM PED) AND NP <> 'P4';

        -- EJERCICIO C --

USE COMERCIAL;
ALTER TABLE CONSULT
    ADD CONSTRAINT PK_NP_NA_NF PRIMARY KEY(NP, NA, NF),
    ADD CONSTRAINT UQ_CANT UNIQUE(CANTIDAD),
    MODIFY CANTIDAD INT(3) NOT NULL;

        -- EJERCICIO D --

USE EJERCICIOS;
DROP TABLE IF EXISTS AUTO_INC;
CREATE TABLE AUTO_INC
(
    COD INT(5) UNIQUE AUTO_INCREMENT,
    VAL VARCHAR(5)
);

-- INSERCCIÓN NORMAL --
INSERT INTO AUTO_INC(VAL) VALUES('A'), ('B');
SELECT * FROM AUTO_INC;

-- SE IGNORARÁN LOS VALORES ERRÓNEOS Y SE PONDRÁ EL CORRESPONDIENTE --
INSERT INTO AUTO_INC VALUES('CAD', '_');
INSERT INTO AUTO_INC VALUES(NULL, '__');
SELECT * FROM AUTO_INC;

-- BORRADO NORMAL --
DELETE FROM AUTO_INC
    ORDER BY COD ASC
    LIMIT 1;
SELECT * FROM AUTO_INC;

-- EL BORRADO DEL ÚLTIMO VALOR HACE QUE AL AÑADIR OTRO MÁS A CONTINUACIÓN, SIGA CON EL VALOR POSTERIOR AL DEL BORRADO --
INSERT INTO AUTO_INC(VAL) VALUES('C');
SELECT * FROM AUTO_INC;
DELETE FROM AUTO_INC
    WHERE COD = (SELECT MAX(COD)
                    FROM AUTO_INC);
SELECT * FROM AUTO_INC;
INSERT INTO AUTO_INC(VAL) VALUES('H');
SELECT * FROM AUTO_INC;

            -- EJERCICIO E --

-- CREACIÓN DE TABLAS --
DROP TABLE IF EXISTS ALUMNO;
CREATE TABLE ALUMNO
(
    NUM_EXP INT(10) PRIMARY KEY,
    NOMBRE VARCHAR(15) NOT NULL,
    DNI_PROFESOR INT(10)
);

DROP TABLE IF EXISTS PROFESOR;
CREATE TABLE PROFESOR
(
    DNI INT(10) PRIMARY KEY,
    NOMBRE VARCHAR(15) NOT NULL
);

    -- SIN CASCADA  --
ALTER TABLE ALUMNO
    ADD CONSTRAINT FK_ALUMNO_PROFESOR FOREIGN KEY(DNI_PROFESOR)
        REFERENCES PROFESOR(DNI);

INSERT INTO PROFESOR
    VALUES(79979797, 'Alberto'),
    (797979, 'Juan');

INSERT INTO ALUMNO(NUM_EXP, NOMBRE)
    VALUES(54278, 'Lola');

INSERT INTO ALUMNO
    VALUES(56565, 'Miguel', 797979);

    -- BORRADO --
-- NO SE PUEDE BORRAR UN PROFESOR CON UN ALUMNO --
DELETE FROM PROFESOR
    WHERE NOMBRE LIKE 'Juan';

-- PERO SÍ UN PROFESOR SIN ALUMNO ASIGNADO --
DELETE FROM PROFESOR
    WHERE NOMBRE LIKE 'Alberto';

    -- MODIFICACIÓN --

INSERT INTO PROFESOR
    VALUES(79979797, 'Alberto');

    -- NO SE PUEDE MODIFICAR UN PROFESOR CON ALUMNO --
REPLACE PROFESOR
    VALUES(797979, 'NUEVO');

    -- PERO SÍ AQUEL QUE NO TENGA NINGUNO --
REPLACE PROFESOR
    VALUES(79979797, 'NUEVO');

-- CON CASCADA  --
DROP TABLE IF EXISTS ALUMNO;
CREATE TABLE ALUMNO
(
    NUM_EXP INT(10) PRIMARY KEY,
    NOMBRE VARCHAR(15) NOT NULL,
    DNI_PROFESOR INT(10)
);

DROP TABLE IF EXISTS PROFESOR;
CREATE TABLE PROFESOR
(
    DNI INT(10) PRIMARY KEY,
    NOMBRE VARCHAR(15) NOT NULL
);
ALTER TABLE ALUMNO
    ADD CONSTRAINT FK_ALUMNO_PROFESOR FOREIGN KEY(DNI_PROFESOR)
        REFERENCES PROFESOR(DNI) ON UPDATE CASCADE ON DELETE CASCADE;

    -- INSERTAR --
INSERT INTO PROFESOR
    VALUES(79979797, 'Alberto'),
    (797979, 'Juan');

INSERT INTO ALUMNO(NUM_EXP, NOMBRE)
    VALUES(54278, 'Lola');

INSERT INTO ALUMNO
    VALUES(56565, 'Miguel', 797979);

    -- BORRADO --
    -- EN AMBOS CASOS SE BORRARÁN LOS ALUMNOS ASOCIADOS A ESOS PROFESORES --
DELETE FROM PROFESOR
    WHERE NOMBRE LIKE 'Juan';

DELETE FROM PROFESOR
    WHERE NOMBRE LIKE 'Alberto';

    -- MODIFICACIÓN --
INSERT INTO PROFESOR
    VALUES(79979797, 'Alberto'),
    (797979, 'Juan');

INSERT INTO ALUMNO
    VALUES(56565, 'Miguel', 797979);

    -- EN AMBOS CASOS SE PUEDEN MODIFICAR LOS VALORES DE LOS PROFESORES SIN PROBLEMAS --
REPLACE PROFESOR
    VALUES(797979, 'NUEVO');

REPLACE PROFESOR
    VALUES(79979797, 'NUEVO');

        -- EJERCICIO F --

USE HOSPITALES;
SET AUTOCOMMIT = 0;
    -- EJERCICIO F.1 --
SELECT * FROM EMP;

UPDATE EMP
    SET SALARIO = SALARIO + (SALARIO * 0.1)
    WHERE COMISION > (SALARIO * 0.05);

SELECT * FROM EMP;

    -- EJERCICIO F.2 --
SET @LIMITE = 2000;
UPDATE EMP
    SET SALARIO = SALARIO + COMISION
    WHERE COMISION > 0 AND (SALARIO + COMISION) > @LIMITE;

SELECT * FROM EMP;
ROLLBACK;