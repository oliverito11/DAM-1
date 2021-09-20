USE PRACTICA4;
DROP TABLE IF EXISTS ALUMNO, PROFE;
CREATE TABLE PROFE
(
	DNIP CHAR(9),
	NombreP VARCHAR(20) NOT NULL,
	TF CHAR(9),
	CONSTRAINT PK_DNIP PRIMARY KEY(DNIP),
	CONSTRAINT UQ_TF UNIQUE(TF)
);

CREATE TABLE ALUMNO
(
	DNIA CHAR(9),
	NombreA VARCHAR(20) DEFAULT "Jose",
	Edad INT,
	DNIP CHAR(9),
	CONSTRAINT PK_DNIA PRIMARY KEY(DNIA),
	CONSTRAINT CK_Edad CHECK (Edad > 18),
	CONSTRAINT FK_ALUMNO_PROFE FOREIGN KEY(DNIP) 
		REFERENCES PROFE(DNIP)
);