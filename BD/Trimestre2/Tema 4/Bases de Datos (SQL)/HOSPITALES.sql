DROP DATABASE HOSPITALES;
CREATE DATABASE HOSPITALES;
USE HOSPITALES;

CREATE TABLE Dept
  (dept_no INT(2),
  dnombre VARCHAR(14),
  loc VARCHAR(13),
  CONSTRAINT PK_DTONO PRIMARY KEY (dept_no));

CREATE TABLE Emp
  (emp_no INT(4),
  apellido VARCHAR(16),
  oficio VARCHAR(10),
  dir INT(4),
  fecha_alt DATE,
  salario INT(9),
  comision INT(9),
  dept_no INT(2) NOT NULL,
  CONSTRAINT PK_EMPNO PRIMARY KEY (emp_no),
  CONSTRAINT FK_DEPOTNO FOREIGN KEY (dept_no)
  REFERENCES Dept(dept_no));

CREATE TABLE Enfermo
  (inscripcion INT(5),
   apellido    VARCHAR(12),
   direccion   VARCHAR(20),
   fecha_nac   DATE,
   s           CHAR(1),
   nss         INT(9) PRIMARY KEY);

CREATE TABLE Hospital
  (hospital_cod INT(2) PRIMARY KEY,
   nombre       VARCHAR(12),
   direccion    VARCHAR(20),
   telefono     VARCHAR(8),
   num_cama     INT(4));

CREATE TABLE Sala
  (hospital_cod INT(2),
   sala_cod     INT(2),
   nombre       VARCHAR(20),
   num_cama     INT(4),
   CONSTRAINT PK_COMB1 PRIMARY KEY (hospital_cod,sala_cod),
   CONSTRAINT FK_HOSPINO FOREIGN KEY (hospital_cod)
   REFERENCES Hospital(hospital_cod));

CREATE TABLE Plantilla
  (hospital_cod INT(2),
   sala_cod     INT(2),
   empleado_no  INT(4),
   apellido     VARCHAR(16),
   funcion      VARCHAR(10),
   turno        CHAR(1),
   salario      INT(10),
   CONSTRAINT PK_COMB2 PRIMARY KEY (hospital_cod,sala_cod,empleado_no),
   CONSTRAINT FK_HOSPINO2 FOREIGN KEY (hospital_cod)
   REFERENCES Hospital(hospital_cod), 
   CONSTRAINT FK_COMB2 FOREIGN KEY (hospital_cod,sala_cod)
   REFERENCES Sala (hospital_cod,sala_cod));

CREATE TABLE Doctor
  (hospital_cod INT(2),
   doctor_no    INT(3),
   apellido     VARCHAR(16),
   especialidad VARCHAR(16),
   CONSTRAINT PK_COMB3 PRIMARY KEY (hospital_cod,doctor_no),
   CONSTRAINT FK_HOSPINO4 FOREIGN KEY (hospital_cod)
   REFERENCES Hospital(hospital_cod));    

INSERT INTO Dept
  VALUES (10,'CONTABILIDAD','SEVILLA'),
		(20,'INVESTIGACIN','MADRID'),
		(30,'VENTAS','BARCELONA'),
		(40,'PRODUCCION','BILBAO');

 INSERT INTO Emp (emp_no,apellido,oficio,dir,fecha_alt,salario,comision,dept_no)
  VALUES (7369,'SANCHEZ','EMPLEADO',7902,'1980-12-10',104000,NULL,20),
		(7499,'ARROYO','VENDEDOR',7698,'1922-02-01',208000,39000,30),
		(7521,'SALA','VENDEDOR',7698,'1922-02-11',162500,65000,30),
		(7566,'JIMENEZ','DIRECTOR',7839,'1902-04-18',386750,NULL,20),
		(7654,'MARTIN','VENDEDOR',7698,'1928-09-18',182000,182000,30),
		(7698,'NEGRO','DIRECTOR',7839,'1901-05-11',370500,NULL,30),
		(7782,'CEREZO','DIRECTOR',7839,'1909-06-08',318500,NULL,10),
		(7788,'GIL','ANALISTA',7566,'1930-03-17',390000,NULL,20),
		(7839,'REY','PRESIDENTE',7788,'1917-11-11',650000,NULL,10),
		(7844,'TOBAR','VENDEDOR',7698,'1908-09-11',195000,NULL,30),
		(7876,'ALONSO','EMPLEADO',7788,'1903-05-17',143000,NULL,20),
		(7900,'JIMENO','EMPLEADO',7698,'1903-12-28',123500,NULL,30),
		(7902,'FERNANDEZ','ANALISTA',7566,'1903-12-21',390000,NULL,20),
		(7934,'MUOZ','EMPLEADO',7782,'1923-06-23',169000,NULL,10);

INSERT INTO Enfermo
  VALUES (10995,'Lagua M.','Goya 20','1916-05-26','M',280862482),
		(18004,'Serrano V.','Alcala 12','1921-05-01','F',280991452),
		(14024,'Fernndez M.','Recoletos 50','1923-06-27','F',321790059),
		(36658,'Domin S.','Mayor 71','2001-06-12','M',160654471),
		(38702,'Neal R','Orense 11','1918-06-10','F',380010217),
		(39217,'Cervantes M.','Pern 38','1929-02-22','M',440294390),
		(59076,'Miller B.','Lpez de Hoyos 2','1916-09-05','F',311969044),
		(63827,'Ruiz P.','Esquerdo 103','1926-12-01','M',100973253),
		(64823,'Fraser A.','Soto 3','1910-07-20','F',285201776),
		(74835,'Benitez E.','Argentina 5','1905-10-27','M',154811767);

INSERT INTO Hospital
  VALUES (13,'Provincial','O Donell 50','964-4264',502),
		(18,'General','Atocha s/n','595-3111',987),
		(22,'La Paz','Castellana 1000','923-5411',412),
		(45,'San Carlos','Ciudad Universitaria','597-1500',845);

INSERT INTO Sala
  VALUES (13,3,'Cuidados intensivos',21),
		(13,6,'Psiquitrico',67),
		(18,3,'Cuidados intensivos',10),
		(18,4,'Cardiologa',53),
		(22,1,'Recuperacin',10),
		(22,6,'Psiquitrico',118),
		(22,2,'Maternidad',34),
		(45,4,'Cardiologa',55),
		(45,1,'Recuperacin',13),
		(45,2,'Maternidad',24);

INSERT INTO Plantilla
  VALUES (13,6,2754,'Daz B.','Enfermera','T',226200),
		(13,6,3106,'Hernndez J.','Enfermero','T',275000),
		(18,4,6357,'Karplus W.','Interno','T',337900),
		(22,6,1009,'Higuera D.','Enfermera','T',200500),
		(22,6,8422,'Bocina G.','Enfermero','M',183800),
		(22,2,9901,'Nez C.','Interno','M',221000),
		(22,1,6065,'Rivera G.','Enfermera','N',162600),
		(22,1,7379,'Carlos R.','Enfermera','T',211900),
		(45,4,1280,'Amigo R.','Interno','N',221000),
		(45,1,8526,'Frank H.','Enfermera','T',252200);

INSERT INTO Doctor
  VALUES (13,435,'Lpez A.','Cardiologa'),
		(18,585,'Miller G.','Ginecologa'),
		(18,982,'Cajal R.','Cardiologa'),
		(22,453,'Galo D.','Pediatra'),
		(22,398,'Best D.','Urologa'),
		(22,386,'Cabeza D.','Psiquiatra'),
		(45,607,'Nino P.','Pediatra'),
		(45,522,'Adams C.','Neurologa');

ALTER TABLE Emp
  ADD CONSTRAINT FK_DIR1 FOREIGN KEY (dir)
       REFERENCES Emp (emp_no); 

SELECT * 
  FROM Emp;
SELECT *
  FROM Dept;
SELECT * 
  FROM Enfermo;
SELECT * 
  FROM Hospital;
SELECT * 
  FROM Sala;
SELECT * 
  FROM Plantilla;
SELECT * 
  FROM Doctor;

COMMIT;

