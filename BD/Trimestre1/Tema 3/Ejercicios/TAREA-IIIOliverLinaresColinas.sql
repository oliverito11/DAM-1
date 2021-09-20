			--	PRACTICAS INICIALES

DROP DATABASE IF EXISTS PRACTICA4;
CREATE DATABASE PRACTICA4;
USE PRACTICA4;

	-- PRACTICA 1
CREATE TABLE PROFE
(
	DNIP INT(9),
	NombreP VARCHAR(20),
	TF CHAR(9)
);

CREATE TABLE ALUMNO
(
	DNIA INT(9),
	NombreA VARCHAR(20),
	Edad INT
);

	-- PRACTICA 2
DROP TABLE ALUMNO, PROFE;

CREATE TABLE PROFE
(
	DNIP INT(9) PRIMARY KEY,
	NombreP VARCHAR(20) NOT NULL,
	TF CHAR(9) UNIQUE
);

CREATE TABLE ALUMNO
(
	DNIA INT(9) PRIMARY KEY,
	NombreA VARCHAR(20) DEFAULT "Jose",
	Edad INT,
	CHECK (Edad > 18)
);

	-- PRACTICA 3
DROP TABLE ALUMNO, PROFE;

CREATE TABLE PROFE
(
	DNIP INT(9),
	NombreP VARCHAR(20) NOT NULL,
	TF CHAR(9),
	CONSTRAINT PK_DNIP PRIMARY KEY(DNIP),
	CONSTRAINT UQ_TF UNIQUE(TF)
);

CREATE TABLE ALUMNO
(
	DNIA INT(9),
	NombreA VARCHAR(20) DEFAULT "Jose",
	Edad INT,
	CONSTRAINT PK_DNIA PRIMARY KEY(DNIA),
	CONSTRAINT CK_EDAD CHECK (Edad > 18)
);

	-- PRACTICA 4
DROP TABLE ALUMNO, PROFE;

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
	CONSTRAINT CK_ALUMNO_EDAD CHECK (Edad > 18),
	CONSTRAINT FK_ALUMNO_PROFE FOREIGN KEY(DNIP) 
		REFERENCES PROFE(DNIP)
);

	-- PRACTICA 5
DROP TABLE ALUMNO, PROFE;

CREATE TABLE PROFE
(
	DNIP CHAR(9),
	NombreP VARCHAR(20),
	TF CHAR(9)
);

CREATE TABLE ALUMNO
(
	DNIA CHAR(9),
	NombreA VARCHAR(20),
	Edad INT,
	DNIP CHAR(9)
);

--RESTRICCIONES:
ALTER TABLE PROFE
	ADD CONSTRAINT PK_PROFE_DNIP PRIMARY KEY(DNIP),
	MODIFY NombreP VARCHAR(20) NOT NULL,
	ADD CONSTRAINT UQ_PROFE_TF UNIQUE(TF);

ALTER TABLE ALUMNO
	ADD CONSTRAINT PK_ALUMNO_DNIA PRIMARY KEY(DNIA),
	MODIFY NombreA VARCHAR(20) DEFAULT 'Jose',
	ADD CONSTRAINT CK_ALUMNO_EDAD CHECK(Edad > 18),
	ADD CONSTRAINT FK_ALUMNO_PROFE FOREIGN KEY(DNIP)
		REFERENCES PROFE(DNIP);
		
	-- PRACTICA 6
ALTER TABLE ALUMNO
	ADD (Correo INT(20));

ALTER TABLE ALUMNO
	MODIFY Correo VARCHAR(30);

ALTER TABLE ALUMNO
	CHANGE Correo CorreoA VARCHAR(30);

ALTER TABLE ALUMNO
	DROP FOREIGN KEY FK_ALUMNO_PROFE,
	DROP INDEX FK_ALUMNO_PROFE;

ALTER TABLE ALUMNO
	ADD CONSTRAINT FK_ALUMNO_PROFE FOREIGN KEY(DNIP)
		REFERENCES PROFE(DNIP) 
		ON UPDATE CASCADE;
		
	-- PRPACTICA 7
ALTER TABLE ALUMNO
	DROP PRIMARY KEY,
	ADD CONSTRAINT PK_Alumno PRIMARY KEY(NombreA);
	
	-- PRACTICA 8
ALTER TABLE ALUMNO
	DROP FOREIGN KEY FK_ALUMNO_PROFE,
	DROP INDEX FK_ALUMNO_PROFE;

ALTER TABLE PROFE
	ADD (COD_Pro INT),
	DROP PRIMARY KEY,
	ADD CONSTRAINT PK_PROFE PRIMARY KEY(COD_Pro);
	
ALTER TABLE ALUMNO
	DROP DNIP,
	ADD COD_Pro INT,
	ADD CONSTRAINT FK_ALUMNO_PROFE FOREIGN KEY(COD_Pro)
		REFERENCES PROFE(COD_Pro);
		
	-- PRACTICA 9
ALTER TABLE ALUMNO
	DROP PRIMARY KEY,
	DROP FOREIGN KEY FK_ALUMNO_PROFE,
	DROP INDEX FK_ALUMNO_PROFE;

ALTER TABLE PROFE
	DROP PRIMARY KEY,
	DROP INDEX UQ_PROFE_TF;
	
	
			--	PRACTICA A
			
DROP DATABASE IF EXISTS PRACTICA_A;
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
	Nacion VARCHAR(10) NOT NULL DEFAULT 'Espanya',
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
		
		
					-- PRACTICA B

DROP DATABASE IF EXISTS FACTURAS;
CREATE DATABASE FACTURAS;
USE FACTURAS;

CREATE TABLE COMPRADORES
(
	CIF_Comprador VARCHAR(11),
	Nombre_Social VARCHAR(30),
	Domicilio_Social VARCHAR(30),
	Localidad VARCHAR(30),
	C_Postal VARCHAR(5),
	Telefono VARCHAR(9) NOT NULL,
	CONSTRAINT PK_COMPRADORES_CIF PRIMARY KEY(CIF_Comprador),
	CONSTRAINT UQ_COMPRADORES_NOMBRE_SOCIAL UNIQUE(Nombre_Social)
);

CREATE TABLE ARTICULOS
(
	Referencia_Articulo  VARCHAR(12),
	Descripcion_Articulo VARCHAR(30),
	Precio_Unidad FLOAT(6),
	IVA INT(2),
	Existencias_Actuales INT(5) DEFAULT 0,
	CONSTRAINT PK_ARTICULOS PRIMARY KEY(Referencia_Articulo),
	CHECK (IVA > 5 AND IVA < 25)
);

CREATE TABLE FACTURAS
(
	Factura_NO INT(6),
	Fecha_Factura DATE DEFAULT '2005/1/1',
	CIF_Cliente VARCHAR(11),
	CONSTRAINT PK_FACTURAS PRIMARY KEY(Factura_NO)
);

CREATE TABLE LINEAS_FACTURA
(
	Factura_NO INT(6),
	Referencia_Articulo VARCHAR(12),
	Unidades INT(3),
	CONSTRAINT PK_LINEAS_FACTURA PRIMARY KEY(Factura_NO, Referencia_Articulo),
	CONSTRAINT FK_LINEAS_FACTURAS FOREIGN KEY(Factura_NO)
		REFERENCES FACTURAS(Factura_NO) ON DELETE CASCADE,
	CONSTRAINT FK_LINEAS_ARTICULOS FOREIGN KEY(Referencia_Articulo)
		REFERENCES ARTICULOS(Referencia_Articulo)
);

	-- PRACTICA B EJERCICIOS 2, 3, 4 Y 5
	
ALTER TABLE FACTURAS
	ADD (COD_Oficina INT(4)),
	ADD CHECK (COD_Oficina > 1 AND COD_Oficina < 1000),
	ADD CONSTRAINT FK_FACTURA_COMPRADORES FOREIGN KEY(CIF_Cliente)
		REFERENCES COMPRADORES(CIF_Comprador);
		
ALTER TABLE COMPRADORES
	CHANGE C_Postal Codigo_Postal VARCHAR(5);
	

			-- PRACTICA C
			
DROP DATABASE IF EXISTS TIENDA;
CREATE DATABASE TIENDA;
USE TIENDA;

CREATE TABLE FABRICANTES
(
	COD_FABRICANTE INT(3) PRIMARY KEY,
	NOMBRE VARCHAR(15),
	PAIS VARCHAR(15)
);

CREATE TABLE ARTICULOS
(
	ARTICULO VARCHAR(20) NOT NULL,
	COD_FABRICANTE INT(3) NOT NULL,
	PESO INT(3) NOT NULL,
	CATEGORIA VARCHAR(10) NOT NULL,
	PRECIO_VENTA INT(4),
	PRECIO_COSTO INT(4),
	EXISTENCIAS INT (5),
	CONSTRAINT CK_CATEGORIA CHECK(CATEGORIA = 'PRIMERA' OR CATEGORIA = 'SEGUNDA' OR CATEGORIA = 'TERCERA'),
	CONSTRAINT PK_ARTICULOS PRIMARY KEY(ARTICULO, COD_FABRICANTE, PESO, CATEGORIA),
	CONSTRAINT FK_ARTICULOS_FABRICANTES FOREIGN KEY(COD_FABRICANTE)
		REFERENCES FABRICANTES(COD_FABRICANTE),
	CONSTRAINT CK_PRECIO_VENTA CHECK(PRECIO_VENTA > 0),
	CONSTRAINT CK_PRECIO_COSTO CHECK(PRECIO_COSTO > 0),
	CONSTRAINT CK_PESO CHECK(PESO > 0)
	
);

CREATE TABLE TIENDAS
(
	NIF VARCHAR(10) PRIMARY KEY,
	NOMBRE VARCHAR(20),
	DIRECCION VARCHAR(20),
	POBLACION VARCHAR(20),
	PROVINCIA VARCHAR(20),
	COD_POSTAL INT(5)
);

CREATE TABLE PEDIDOS
(
	NIF VARCHAR(10),
	ARTICULO VARCHAR(20),
	COD_FABRICANTE INT(3),
	PESO INT(3),
	CATEGORIA VARCHAR(10),
	FECHA_PEDIDO DATE,
	UNIDADES_PEDIDAS INT(4),
	CONSTRAINT CK_CATEGORIA CHECK(CATEGORIA = 'PRIMERA' OR CATEGORIA = 'SEGUNDA' OR CATEGORIA = 'TERCERA'),
	CONSTRAINT PK_PEDIDOS PRIMARY KEY(NIF, ARTICULO, COD_FABRICANTE, PESO, CATEGORIA, FECHA_PEDIDO),
	CONSTRAINT FK_PEDIDOS_ARTICULOS FOREIGN KEY(ARTICULO, COD_FABRICANTE, PESO, CATEGORIA)
		REFERENCES ARTICULOS(ARTICULO, COD_FABRICANTE, PESO, CATEGORIA),
	CONSTRAINT FK_PEDIDOS_TIENDAS FOREIGN KEY(NIF)
		REFERENCES TIENDAS(NIF)
);

CREATE TABLE VENTAS
(
	NIF VARCHAR(10),
	ARTICULO VARCHAR(20),
	COD_FABRICANTE INT(3),
	PESO INT(3),
	CATEGORIA VARCHAR(10),
	FECHA_VENTA DATE,
	UNIDADES_VENDIDAS INT(4),
	CONSTRAINT CK_CATEGORIA CHECK(CATEGORIA = 'PRIMERA' OR CATEGORIA = 'SEGUNDA' OR CATEGORIA = 'TERCERA'),
	CONSTRAINT PK_VENTAS PRIMARY KEY(NIF, ARTICULO, COD_FABRICANTE, PESO, CATEGORIA, FECHA_VENTA),
	CONSTRAINT CK_UNIDADES_VENDIDAS CHECK(UNIDADES_VENDIDAS > 0),
	CONSTRAINT FK_VENTAS_ARTICULOS FOREIGN KEY(ARTICULO, COD_FABRICANTE, PESO, CATEGORIA)
		REFERENCES ARTICULOS(ARTICULO, COD_FABRICANTE, PESO, CATEGORIA)
		ON DELETE CASCADE,
	CONSTRAINT FK_VENTAS_TIENDAS FOREIGN KEY(NIF)
		REFERENCES TIENDAS(NIF)
);

	-- PRACTICA C, EJERCICIO 3 Y 4
	
ALTER TABLE PEDIDOS
	MODIFY UNIDADES_PEDIDAS INT(6);
	
ALTER TABLE VENTAS
	MODIFY UNIDADES_VENDIDAS INT(6);