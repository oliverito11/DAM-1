CREATE DATABASE PRACTICA_A;
USE PRACTICA_A;

CREATE TABLE EQUIPO
(
	COD_Equipo INT PRIMARY KEY,
	Nombre VARCHAR(6) NOT NULL,
	Presidente VARCHAR(10) NOT NULL,
	Direccion VARCHAR(10) NOT NULL
);

CREATE TABLE PARTIDO
(
	COD_Equipo INT NOT NULL,
	COD_Campo INT NOT NULL,
	Fecha DATE NOT NULL
);

CREATE TABLE CAMPO
(
	COD_Campo INT PRIMARY KEY,
	Capacidad INT NOT NULL,
	Tamanyo INT DEFAULT 20000 NOT NULL,
	Situacion VARCHAR(10) NULL,
	Puntuacion INT NOT NULL
);

CREATE TABLE JUGADOR
(
	DNI INT PRIMARY KEY,
	Nombre VARCHAR(10) NOT NULL,
	Direccion VARCHAR(10) NULL,
	Telefono VARCHAR(10) NOT NULL,
	COD_Equipo INT NOT NULL
);

CREATE TABLE CIUDAD
(
	COD_Ciudad INT PRIMARY KEY,
	Nacion VARCHAR(10) NOT NULL,
	Provincia VARCHAR(10) NOT NULL,
	COD_Campo INT NOT NULL
);

ALTER TABLE PARTIDO
ADD CONSTRAINT FK_EQUIPO_PARTIDO FOREIGN KEY(COD_Equipo)
		REFERENCES EQUIPO(COD_Equipo),
ADD CONSTRAINT FK_CAMPO_PARTIDO FOREIGN KEY(COD_Campo)
		REFERENCES CAMPO(COD_Campo);
		
ALTER TABLE JUGADOR
ADD CONSTRAINT FK_EQUIPO_JUGADOR FOREIGN KEY(COD_Equipo)
		REFERENCES EQUIPO(COD_Equipo);
		
ALTER TABLE CIUDAD
ADD CONSTRAINT FK_CAMPO_CIUDAD FOREIGN KEY(COD_Campo)
		REFERENCES CAMPO(COD_Campo);
		
/*
	FALLOS QUE HE TENIDO:
	CUANDO SON SENTENCIAS QUE LLEVAN POR DEBAJO MÁS INSTRUCCIONES,
	NO TENGO QUE PONER , SI ES UNA SENTENCIA QUE ABRE OTRAS