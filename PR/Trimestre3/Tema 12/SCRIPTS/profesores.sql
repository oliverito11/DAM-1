USE INSTITUTO;
CREATE TABLE  PROFESORES
   (IDPROFESORES INT AUTO_INCREMENT NOT NULL, 
	NOMBRE VARCHAR(4000) NOT NULL, 
	APE1 VARCHAR(4000), 
	APE2 VARCHAR(4000), 
	TFNO VARCHAR(4000), 
	IDDEPARTAMENTOS INT NOT NULL, 
	CONSTRAINT PROF_DEPTO_FK FOREIGN KEY (IDDEPARTAMENTOS)
	  REFERENCES  DEPARTAMENTOS(IDDEPARTAMENTOS)
		ON DELETE CASCADE
        ON UPDATE CASCADE,
	PRIMARY KEY (IDPROFESORES)
   )
