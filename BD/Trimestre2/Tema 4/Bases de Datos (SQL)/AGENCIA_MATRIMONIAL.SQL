DROP DATABASE AgenciaMatri;
CREATE DATABASE AgenciaMatri;
USE AgenciaMatri;

CREATE TABLE Hombres
  (nomh VARCHAR(15) PRIMARY KEY,
   edad INT(2));

CREATE TABLE Mujeres
  (nomm VARCHAR(15) PRIMARY KEY,
   edad INT(2));

CREATE TABLE HSIM
  (nomh VARCHAR(15),
   nomm VARCHAR(15),
   PRIMARY KEY (nomh,nomm));

CREATE TABLE MSIH
  (nomh VARCHAR(15),
   nomm VARCHAR(15),
   PRIMARY KEY (nomh,nomm));

CREATE TABLE Matrimonios
  (nomh VARCHAR(15),
   nomm VARCHAR(15),
   PRIMARY KEY (nomh,nomm));

INSERT INTO Hombres
  VALUES('Lucio',50);
INSERT INTO Hombres
  VALUES('Macario',22);
INSERT INTO Hombres
  VALUES('Tiburcio',23);
INSERT INTO Hombres
  VALUES('Rodolfo',25);
INSERT INTO Hombres
  VALUES('Segismundo',27);
INSERT INTO Hombres
  VALUES('Sigiloso',50);
INSERT INTO Hombres
  VALUES('Ambrosio',53);
INSERT INTO Hombres
  VALUES('Gumersindo',60);

INSERT INTO Mujeres
  VALUES('Andrea',24);
INSERT INTO Mujeres
  VALUES('Salustia',28);
INSERT INTO Mujeres
  VALUES('Fulgencia',21);
INSERT INTO Mujeres
  VALUES('Pepita',34);
INSERT INTO Mujeres
  VALUES('Cipriana',35);
INSERT INTO Mujeres
  VALUES('Lucrecia',48);
INSERT INTO Mujeres
  VALUES('Clodomira',45);

INSERT INTO HSIM
  VALUES('Lucio','Andrea');
INSERT INTO HSIM
  VALUES('Macario','Salustia');
INSERT INTO HSIM
  VALUES('Tiburcio','Fulgencia');
INSERT INTO HSIM
  VALUES('Rodolfo','Andrea');
INSERT INTO HSIM
  VALUES('Sigiloso','Salustia');
INSERT INTO HSIM
  VALUES('Tiburcio','Andrea');
INSERT INTO HSIM
  VALUES('Segismundo','Andrea');
INSERT INTO HSIM
  VALUES('Macario','Andrea');
INSERT INTO HSIM
  VALUES('Tiburcio','Salustia');
INSERT INTO HSIM
  VALUES('Lucio','Salustia');
INSERT INTO HSIM
  VALUES('Ambrosio','Fulgencia');

INSERT INTO MSIH
  VALUES('Lucio','Andrea');
INSERT INTO MSIH
  VALUES('Macario','Salustia');
INSERT INTO MSIH
  VALUES('Tiburcio','Fulgencia');
INSERT INTO MSIH
  VALUES('Rodolfo','Andrea');
INSERT INTO MSIH
  VALUES('Macario','Andrea');
INSERT INTO MSIH
  VALUES('Lucio','Salustia');
INSERT INTO MSIH
  VALUES('Lucio','Fulgencia');
INSERT INTO MSIH
  VALUES('Lucio','Cipriana');
INSERT INTO MSIH
  VALUES('Gumersindo','Fulgencia');
INSERT INTO MSIH
  VALUES('Macario','Fulgencia');
INSERT INTO MSIH
  VALUES('Segismundo','Cipriana');
INSERT INTO MSIH
  VALUES('Tiburcio','Lucrecia');

INSERT INTO Matrimonios
  VALUES('Tiburcio','Fulgencia');
INSERT INTO Matrimonios
  VALUES('Rodolfo','Andrea');
INSERT INTO Matrimonios
  VALUES('Segismundo','Cipriana');

SELECT * FROM Hombres;

SELECT * FROM Mujeres;

SELECT * FROM HSIM;

SELECT * FROM MSIH;

SELECT * FROM Matrimonios;


COMMIT;


