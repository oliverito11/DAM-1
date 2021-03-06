DROP TABLE IF EXISTS TEMP;
CREATE TABLE TEMP(
    NOMBRE_FABRICA VARCHAR(25)
);

DROP PROCEDURE CURSORES;
DELIMITER $

CREATE PROCEDURE CURSORES()
    BEGIN
        DECLARE FAB_NOM VARCHAR(15) DEFAULT "";
        DECLARE DONE BOOLEAN DEFAULT FALSE;
        DECLARE CURSOR_1 CURSOR FOR SELECT NOMF FROM FAB;
        DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET DONE = TRUE;

        OPEN CURSOR_1;
            FETCH CURSOR_1 INTO FAB_NOM;
            INSERT INTO TEMP VALUES('FÁBRICAS');
            INSERT INTO TEMP VALUES('--------');
            WHILE NOT DONE DO 
                INSERT INTO TEMP VALUES(CONCAT('|', FAB_NOM, '|'));
                INSERT INTO TEMP VALUES('--------');
                FETCH CURSOR_1 INTO FAB_NOM;
            END WHILE;        
        CLOSE CURSOR_1;
        SELECT * FROM TEMP;
        DROP TABLE IF EXISTS TEMP;
    END $

DELIMITER ;

CALL CURSORES();

-- EJER 2 --
DROP TABLE IF EXISTS LISTADO;
CREATE TABLE LISTADO(
    LISTADO_PROV VARCHAR(25)
);

DROP PROCEDURE PROV_CURSORES;
DELIMITER $

CREATE PROCEDURE PROV_CURSORES()
    BEGIN
        DECLARE NOMBRE VARCHAR(15) DEFAULT '';
        DECLARE CIUDAD VARCHAR(15) DEFAULT '';
        DECLARE CIUDAD_ANT VARCHAR(15) DEFAULT '';
        
        DECLARE DONE BOOLEAN DEFAULT FALSE;
        DECLARE CURSOR_1 CURSOR FOR SELECT NOMP, CIUDADP FROM PRO ORDER BY CIUDADP, NOMP;
        DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET DONE = TRUE;

        OPEN CURSOR_1;
            FETCH CURSOR_1 INTO NOMBRE, CIUDAD;

            WHILE NOT DONE DO
                IF(CIUDAD NOT LIKE CIUDAD_ANT) THEN
                    SET CIUDAD_ANT = CIUDAD;
                    INSERT INTO LISTADO VALUES(CONCAT('PROVEEDORES DE ', CIUDAD));
                END IF;

                INSERT INTO LISTADO VALUES(CONCAT('---', NOMBRE));
                FETCH CURSOR_1 INTO NOMBRE, CIUDAD;
            END WHILE;
        
        CLOSE CURSOR_1;
        
        SELECT * FROM LISTADO;
        DROP TABLE IF EXISTS LISTADO;
    END $

DELIMITER ;

CALL PROV_CURSORES();