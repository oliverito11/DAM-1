DROP DATABASE Comercial;
CREATE DATABASE Comercial;
USE Comercial;

CREATE TABLE Art
  (   na CHAR(2) PRIMARY KEY,
    desa VARCHAR(20),
   color VARCHAR(10),
   talla INT(2),
   stock INT);

SELECT * FROM ART;
UPDATE ART 
  SET STOCK=100
  WHERE STOCK IS NULL;

CREATE TABLE Pro
  (     np CHAR(2) PRIMARY KEY,
      nomp VARCHAR(15),
   ciudadp VARCHAR(15));

CREATE TABLE Fab
  (     nf CHAR(2) PRIMARY KEY,
      nomf VARCHAR(15),
   ciudadf VARCHAR(15));

CREATE TABLE Ped
  (      np CHAR(2), 
         na CHAR(2),
         nf CHAR(2),
   cantidad INT(3),
   PRIMARY KEY (np,na,nf)
 );

INSERT INTO Art
  VALUES('A1','retales','rojo',10,100);
INSERT INTO Art
  VALUES('A2','paños','azul',10,110);
INSERT INTO Art
  VALUES('A3','botones','negro',120);

INSERT INTO Pro
  VALUES('P1','Macario','Palencia');
INSERT INTO Pro
  VALUES('P2','Salustio','León');
INSERT INTO Pro
  VALUES('P3','Fauriciano','Madrid');
INSERT INTO Pro
  VALUES('P4','Endelecio','Zamora');
INSERT INTO Pro
  VALUES('P5','Constancio','León');

INSERT INTO Fab
  VALUES('F1','RETASA','León');
INSERT INTO Fab
  VALUES('F2','PAÑASA','Madrid');
INSERT INTO Fab
  VALUES('F3','TEXTASA','Lisboa');

INSERT INTO Ped
  VALUES('P2','A1','F1',200);
INSERT INTO Ped
  VALUES('P4','A3','F2',349);
INSERT INTO Ped
  VALUES('P1','A2','F1',580);
INSERT INTO Ped
  VALUES('P4','A1','F1',236);
INSERT INTO Ped
  VALUES('P4','A2','F1',467);
INSERT INTO Ped
  VALUES('P5','A2','F2',123);
INSERT INTO Ped
  VALUES('P4','A2','F2',456);
INSERT INTO Ped
  VALUES('P2','A2','F3',908);
INSERT INTO Ped
  VALUES('P5','A2','F1',567);

SELECT * FROM Pro;

SELECT * FROM Art;

SELECT * FROM Fab;

SELECT * FROM Ped;


COMMIT;


