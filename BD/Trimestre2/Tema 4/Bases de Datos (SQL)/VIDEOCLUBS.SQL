DROP DATABASE Videoclubs;
CREATE DATABASE Videoclubs;
USE Videoclubs;

CREATE TABLE Socio
  (aficionado VARCHAR(20),
    videoclub CHAR(2),
   PRIMARY KEY (aficionado,videoclub));

CREATE TABLE Gusta
  (aficionado VARCHAR(20),
     pelicula VARCHAR(20),
   PRIMARY KEY (aficionado,pelicula)); 

CREATE TABLE Videoclub
  (videoclub CHAR(2),
    pelicula VARCHAR(20),
   PRIMARY KEY (videoclub,pelicula)); 

INSERT INTO Socio
  VALUES('José Pérez','V3');
INSERT INTO Socio
  VALUES('Raúl González','V1');
INSERT INTO Socio
  VALUES('Roberto Carlos','V2');
INSERT INTO Socio
  VALUES('José Pérez','V2');
INSERT INTO Socio
  VALUES('Roberto Carlos','V1');
INSERT INTO Socio
  VALUES('Hierro','V2');
INSERT INTO Socio
  VALUES('César','V1');

INSERT INTO Gusta
  VALUES('José Pérez','EL ESCANDALO');
INSERT INTO Gusta
  VALUES('Raúl González','EL FOLLON');
INSERT INTO Gusta
  VALUES('Roberto Carlos','VAYA LIO');
INSERT INTO Gusta
  VALUES('Hierro','PELI5');
INSERT INTO Gusta
  VALUES('José Pérez','LA PILLE');
INSERT INTO Gusta
  VALUES('Roberto Carlos','Y AHORA QUE');
INSERT INTO Gusta
  VALUES('César','LA PILLE');

INSERT INTO Videoclub
  VALUES('V1','EL ESCANDALO');
INSERT INTO Videoclub
  VALUES('V3','LA PILLE');
INSERT INTO Videoclub
  VALUES('V1','EL FOLLON');
INSERT INTO Videoclub
  VALUES('V3','VAYA LIO');
INSERT INTO Videoclub
  VALUES('V5','Y AHORA QUE');
INSERT INTO Videoclub
  VALUES('V2','PELI5');

SELECT * FROM Socio;

SELECT * FROM Gusta;

SELECT * FROM Videoclub;

COMMIT;
