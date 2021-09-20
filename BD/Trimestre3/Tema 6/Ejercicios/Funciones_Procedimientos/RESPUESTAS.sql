-- EJER 1 --
DROP FUNCTION SUMA;
DELIMITER $
CREATE FUNCTION SUMA(N1 INT, N2 INT, N3 INT) RETURNS INT
    BEGIN
		CASE
			WHEN N1 IS NULL AND N2 IS NOT NULL AND N3 IS NOT NULL THEN
				RETURN N2 + N3;
			WHEN N1 IS NOT NULL AND N2 IS NULL AND N3 IS NOT NULL THEN
				RETURN N1 + N3;
			WHEN N1 IS NOT NULL AND N2 IS NOT NULL AND N3 IS NULL THEN
				RETURN N1 + N2;
			WHEN N1 IS NULL AND N2 IS NULL AND N3 IS NOT NULL THEN
				RETURN N3;
			WHEN N1 IS NULL AND N2 IS NOT NULL AND N3 IS NULL THEN
				RETURN N2;
			WHEN N1 IS NOT NULL AND N2 IS NULL AND N3 IS NULL THEN
				RETURN N1;
			ELSE
				RETURN N1 + N2 + N3;
		END CASE;
    END $
DELIMITER ;
SELECT SUMA(NULL,NULL,NULL);
SELECT SUMA(NULL,NULL,3);
SELECT SUMA(NULL,2,NULL);
SELECT SUMA(1,NULL,NULL);
SELECT SUMA(1,NULL,3);
SELECT SUMA(1,2,NULL);
SELECT SUMA(1,2,3);

-- EJER 2 --
DROP FUNCTION NOTA;
DELIMITER $
CREATE FUNCTION NOTA(N FLOAT) RETURNS VARCHAR(20)
	BEGIN
		CASE
			WHEN N >= 1 AND N < 5 THEN
				RETURN 'SUSPENSO';
			WHEN N >= 5 AND N < 6 THEN
				RETURN 'SUFICIENTE';
			WHEN N >= 6 AND N < 7 THEN
				RETURN 'BIEN';
			WHEN N >= 7 AND N < 9 THEN
				RETURN 'NOTABLE';
			WHEN N >= 9 AND N <= 10 THEN
				RETURN 'SOBRESALIENTE';
			ELSE
				RETURN 'ERROR';
        END CASE;
    END$
DELIMITER ;
SELECT NOTA(0);
SELECT NOTA(1);
SELECT NOTA(5);
SELECT NOTA(6);
SELECT NOTA(7);
SELECT NOTA(9);

-- EJER 3 --
DROP PROCEDURE REVES;
DELIMITER $
CREATE PROCEDURE REVES(IN PALABRA VARCHAR(20), OUT PALABRA_REVES VARCHAR(20))
	BEGIN
		DECLARE I INT DEFAULT 0;
		SET PALABRA_REVES = '';
		WHILE I <= LENGTH(PALABRA) DO
			SET PALABRA_REVES = CONCAT(SUBSTRING(PALABRA, I, 1), PALABRA_REVES);
			SET I = I + 1;
		END WHILE;
	END $
DELIMITER ;
CALL REVES('HOLA', @X);
SELECT @X;

						-- OBRAS --
-- EJER 4 --
DROP PROCEDURE AUMENTAR;
DELIMITER $
CREATE PROCEDURE AUMENTAR(IN PORCENTAJE INT)
	BEGIN
		UPDATE MAQUINAS
			SET PRECIOHORA = PRECIOHORA + (PRECIOHORA * (PORCENTAJE / 100));
	END $
DELIMITER ;
CALL AUMENTAR(10);

-- EJER 5 --
DROP PROCEDURE CAMBIAR_CAT;
DELIMITER $
CREATE PROCEDURE CAMBIAR_CAT(IN SUB_BAJ INT, IN VALOR INT)
	BEGIN
		IF SUB_BAJ = 1 THEN
			UPDATE CONDUCTORES
				SET CATEG = CATEG + VALOR;
		ELSEIF SUB_BAJ = 2 THEN
			UPDATE CONDUCTORES
				SET CATEG = CATEG - VALOR;
		END IF;
	END $
DELIMITER ;
CALL CAMBIAR_CAT(1, 10);

-- EJER 6 POR TRABAJO --
DROP PROCEDURE ASIGNAR_TRABAJO;
DELIMITER $
CREATE PROCEDURE ASIGNAR_TRABAJO(IN MAQUINA CHAR(3), IN PROYECTO CHAR(3))
	BEGIN
		DECLARE COD CHAR(3) DEFAULT (SELECT CODC
										FROM TRABAJOS
										WHERE TIEMPO = (SELECT SUM(TIEMPO)
															FROM TRABAJOS
															GROUP BY CODC
															ORDER BY SUM(TIEMPO) ASC
															LIMIT 1));
		DECLARE MAX_TIEMPO INT DEFAULT (SELECT MAX(TIEMPO) FROM TRABAJOS);
		INSERT INTO TRABAJOS
			VALUES (COD, MAQUINA, PROYECTO, CURRENT_DATE, MAX_TIEMPO + 1);
	END $
DELIMITER ;
CALL ASIGNAR_TRABAJO('M02', 'P03');

-- EJER 6 EN TOTAL --
DROP PROCEDURE ASIGNAR_TRABAJO_TOT;
DELIMITER $
CREATE PROCEDURE ASIGNAR_TRABAJO_TOT(IN MAQUINA CHAR(3), IN PROYECTO CHAR(3))
	BEGIN
		DECLARE COD CHAR(3) DEFAULT (SELECT CODC
										FROM TRABAJOS
										WHERE TIEMPO = (SELECT SUM(TIEMPO)
															FROM TRABAJOS
															GROUP BY CODC
															ORDER BY SUM(TIEMPO) ASC
															LIMIT 1));
		DECLARE MAX_TIEMPO INT DEFAULT (SELECT SUM(TIEMPO)
											FROM TRABAJOS
											GROUP BY CODC
											ORDER BY SUM(TIEMPO) DESC
											LIMIT 1);
		DECLARE TIEMPO_COD INT DEFAULT (SELECT SUM(TIEMPO)
											FROM TRABAJOS
											WHERE CODC LIKE COD
											GROUP BY CODC);
		INSERT INTO TRABAJOS
			VALUES (COD, MAQUINA, PROYECTO, CURRENT_DATE, (MAX_TIEMPO - TIEMPO_COD) + 1);
	END $
DELIMITER ;
CALL ASIGNAR_TRABAJO_TOT('M02', 'P03');

						-- HOSPITALES --
-- EJER 7 --
DROP PROCEDURE INSERTAR_EMPLEADO;
DELIMITER $
CREATE PROCEDURE INSERTAR_EMPLEADO()
	BEGIN
		DECLARE NUM_EMP INT DEFAULT ((SELECT MAX(EMP_NO) FROM EMP) + 1);
		DECLARE DEPT INT DEFAULT 0;
		
		WHILE DEPT NOT IN (SELECT DEPT_NO FROM DEPT) DO
			SET DEPT = DEPT + 1;
		END WHILE;

		INSERT INTO EMP(EMP_NO, FECHA_ALT, DEPT_NO)
			VALUES(NUM_EMP, CURRENT_DATE, DEPT);
	END $
DELIMITER ;
CALL INSERTAR_EMPLEADO();

-- EJER 7 CON RAND --
DROP PROCEDURE INSERTAR_EMPLEADO2;
DELIMITER $
CREATE PROCEDURE INSERTAR_EMPLEADO2()
	BEGIN
		DECLARE NUM_EMP INT DEFAULT ((SELECT MAX(EMP_NO) FROM EMP) + 1);
		DECLARE DEPT INT DEFAULT 0;

		WHILE DEPT NOT IN (SELECT DEPT_NO FROM DEPT) DO
			SET DEPT = (RAND() * 100);
		END WHILE;

		INSERT INTO EMP(EMP_NO, FECHA_ALT, DEPT_NO)
			VALUES(NUM_EMP, CURRENT_DATE, DEPT);
	END $
DELIMITER ;
CALL INSERTAR_EMPLEADO2();

-- EJER 8 --
DROP PROCEDURE INSERTAR_VENDEDOR;
DELIMITER $
CREATE PROCEDURE INSERTAR_VENDEDOR(IN APE VARCHAR(16), IN SAL INT)
	BEGIN
		DECLARE NUM_EMP INT DEFAULT ((SELECT MAX(EMP_NO) FROM EMP) + 1);
		DECLARE DEPARTAMENTO INT DEFAULT (SELECT DEPT_NO
											FROM EMP
											WHERE APELLIDO LIKE 'SALA');
		INSERT INTO EMP
			VALUES(NUM_EMP, APE, 'VENDEDOR', NULL, CURRENT_DATE, SAL, NULL, DEPARTAMENTO);
	END $
DELIMITER ;
CALL INSERTAR_VENDEDOR('LINARES', 123456);

-- EJER 8 CON JEFE DESCONOCIDO --
DROP PROCEDURE INSERTAR_VENDEDOR2;
DELIMITER $
CREATE PROCEDURE INSERTAR_VENDEDOR2(IN APE VARCHAR(16), IN SAL INT)
	BEGIN
		DECLARE NUM_EMP INT DEFAULT ((SELECT MAX(EMP_NO) FROM EMP) + 1);
		DECLARE DEPARTAMENTO INT DEFAULT 0;
		WHILE DEPARTAMENTO NOT IN (SELECT DEPT_NO FROM DEPT) DO
			SET DEPARTAMENTO = RAND() * ((SELECT MAX(EMP_NO) FROM EMP) - (SELECT MIN(EMP_NO) FROM EMP)) + (SELECT MIN(EMP_NO) FROM EMP);
			SELECT DEPARTAMENTO;
		END WHILE;
		INSERT INTO EMP
			VALUES(NUM_EMP, APE, 'VENDEDOR', NULL, CURRENT_DATE, SAL, NULL, DEPARTAMENTO);
	END $
DELIMITER ;
CALL INSERTAR_VENDEDOR2('LINARES', 123456);
-- EJER 9 --
DROP PROCEDURE MODIFICAR;
DELIMITER $
CREATE PROCEDURE MODIFICAR()
	BEGIN
		DECLARE NUM_EMP INT DEFAULT ((SELECT MAX(EMP_NO) FROM EMP) + 1);
		DECLARE DEPARTAMENTO INT DEFAULT (SELECT DEPT_NO
											FROM EMP
											WHERE OFICIO LIKE 'VENDEDOR'
											GROUP BY DEPT_NO
											ORDER BY COUNT(DEPT_NO) DESC
											LIMIT 1);
		UPDATE EMP
			SET DEPT_NO = DEPARTAMENTO
			WHERE APELLIDO LIKE 'REY';
	END $
DELIMITER ;
CALL MODIFICAR();