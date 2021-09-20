DROP DATABASE Obras;
CREATE DATABASE Obras;
USE Obras;

/* Tabla CONDUCTORES */
CREATE TABLE CONDUCTORES
       (CODC CHAR(3) NOT NULL,
        NOMBRE CHAR(25) NOT NULL,
        LOCALIDAD CHAR(20),
        CATEG INT,
PRIMARY KEY (CODC));

/* Tabla MAQUINAS */
CREATE TABLE MAQUINAS
       (CODM CHAR(3) NOT NULL,
        NOMBRE CHAR(20) NOT NULL,
        PRECIOHORA INT,
PRIMARY KEY (CODM));

/* Tabla PROYECTOS */
CREATE TABLE PROYECTOS
       (CODP CHAR(3) NOT NULL,
        DESCRIP CHAR(25) NOT NULL,
        LOCALIDAD CHAR(20),
        CLIENTE CHAR(25),
        TELEFONO CHAR(9),
PRIMARY KEY (CODP));

/* Tabla TRABAJOS */
CREATE TABLE TRABAJOS
       (CODC CHAR(3) NOT NULL,
        CODM CHAR(3) NOT NULL,
        CODP CHAR(3) NOT NULL,
        FECHA DATE NOT NULL,
        TIEMPO INT,
PRIMARY KEY (CODC, CODM, CODP, FECHA));



/* Datos de la tabla Proyectos */

INSERT INTO Proyectos
VALUES ('P01','Garaje','Arganda','Felipe Sol','600111111');
INSERT INTO Proyectos
VALUES ('P02','Solado','Rivas','Jos� P�rez','912222222');
INSERT INTO Proyectos
VALUES ('P03','Garaje','Arganda','Rosa L�pez','666999666');
INSERT INTO Proyectos
VALUES ('P04','Techado','Loeches','Jos� P�rez','913333333');
INSERT INTO Proyectos
VALUES ('P05','Buhardilla','Rivas','Ana Botijo',null);


/* Datos de la tabla Conductores */

INSERT INTO Conductores
VALUES ('C01','Jos� S�nchez','Arganda',18);
INSERT INTO Conductores
VALUES ('C02','Manuel D�az','Arganda',15);
INSERT INTO Conductores
VALUES ('C03','Juan P�rez','Rivas',20);
INSERT INTO Conductores
VALUES ('C04','Luis Ortiz','Arganda',18);
INSERT INTO Conductores
VALUES ('C05','Javier Mart�n','Loeches',12);
INSERT INTO Conductores
VALUES ('C06','Carmen L�pez','Rivas',15);

/* Datos de la tabla Maquinas */

INSERT INTO Maquinas
VALUES ('M01','Excavadora',15000);
INSERT INTO Maquinas
VALUES ('M02','Hormigonera',10000);
INSERT INTO Maquinas
VALUES ('M03','Volquete',11000);
INSERT INTO Maquinas
VALUES ('M04','Apisonadora',18000);

/* Datos de la tabla Trabajos */

INSERT INTO Trabajos
VALUES ('C01','M03','P02','02-09-14',120);
INSERT INTO Trabajos
VALUES ('C01','M02','P04','02-09-20',null);
INSERT INTO Trabajos
VALUES ('C01','M03','P04','02-09-18',180);
INSERT INTO Trabajos
VALUES ('C02','M03','P03','02-09-15',30);
INSERT INTO Trabajos
VALUES ('C02','M03','P02','02-09-17',null);
INSERT INTO Trabajos
VALUES ('C02','M03','P01','02-09-21',null);
INSERT INTO Trabajos
VALUES ('C02','M01','P01','02-09-10',100);
INSERT INTO Trabajos
VALUES ('C03','M01','P02','02-09-11',200);
INSERT INTO Trabajos
VALUES ('C03','M02','P02','02-09-11',200);
INSERT INTO Trabajos
VALUES ('C03','M01','P04','02-09-16',300);
INSERT INTO Trabajos
VALUES ('C04','M02','P04','02-09-18',190);
INSERT INTO Trabajos
VALUES ('C04','M03','P02','02-09-13',null);
INSERT INTO Trabajos
VALUES ('C05','M03','P02','02-09-12',150);
INSERT INTO Trabajos
VALUES ('C05','M03','P04','02-09-19',90);
INSERT INTO Trabajos
VALUES ('C05','M02','P02','02-09-21',290);

/* otra soluci�n para introducir fechas es ponerlo en el siguiente formato 18-sep-2002 */

