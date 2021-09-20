DROP DATABASE AlquiCar;
CREATE DATABASE AlquiCar;
USE AlquiCar;

CREATE TABLE CLIENTE
  (CODC CHAR(3),
  NombreC VARCHAR(15),
  Poblacion VARCHAR(10));

CREATE TABLE RESERVA
  (CODC CHAR(3),
  CODV CHAR(3),
  CODA CHAR(3),
  NCOCHES INT);

CREATE TABLE COCHE
  (CODV CHAR(3),
  MARCA VARCHAR(12),
  MODELO VARCHAR (15),
  Precio INT,
  codg char(3));

CREATE TABLE GARAJE
  (CODG CHAR(3),
  DirG VARCHAR(25),
  Plazas INT);

CREATE TABLE AGENCIA
  (CODA CHAR(3),
  NOMBREA VARCHAR(15),
  DIRA VARCHAR(25));

INSERT INTO Cliente VALUES
  ('C01','Lucas Vazquez','Lugo'),
  ('C02','Jese Rodriguez','Orense'),
  ('C03','Sergio Ramos','Sevilla'),
  ('C04','Kiko Casilla','Barcelona'),
  ('C10','Real Madrid','Madrid');

INSERT INTO Coche VALUES
  ('V01','Audi','Q7',100,'G02'),
  ('V02','Ferrari','408',200,'G03'),
  ('V03','Mercedes','SLS AMG',150,'G01'),
  ('V05','Aston Martin','Rapide',300,'G03'),
  ('V10','Ferrari','FF',250,'G02'),
  ('V15','Porsche','911',120,'G03');

INSERT INTO Agencia VALUES
  ('A01','La Veloz','Calle Mayor 3'),
  ('A02','La Perfecta','Plaza Grande 5'),
  ('A03','La Ideal','Avd. Llegada 7');


INSERT INTO Garaje VALUES
  ('G01','Plaza Azul 2',5),
  ('G02','Calle Fresca 4',3),
  ('G03','Avd. Buena 6',3),
  ('G04','Plaza Roja 8',2);

INSERT INTO Reserva VALUES
  ('C01','V01','A01',1),
  ('C02','V02','A02',2),
  ('C02','V03','A01',3),
  ('C03','V02','A03',1),
  ('C03','V05','A02',1),
  ('C03','V10','A01',2),
  ('C04','V03','A01',2),
  ('C04','V03','A02',1),
  ('C04','V02','A03',2),
  ('C04','V02','A01',2),
  ('C05','V01','A02',3),
  ('C05','V03','A03',3);

SELECT * 
  FROM Cliente;
SELECT *
  FROM Coche;
SELECT * 
  FROM Agencia;
SELECT *
  FROM Reserva;
SELECT *
  FROM Garaje;