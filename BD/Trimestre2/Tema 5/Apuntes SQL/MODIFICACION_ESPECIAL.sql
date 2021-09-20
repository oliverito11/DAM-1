SELECT * FROM PRO;
UPDATE PRO
    SET CIUDADP = (SELECT CIUDADP
                    FROM PRO
                    WHERE NP = 'P1')
    WHERE NP = 'P5';
SELECT * FROM PRO;

-- P7 MISMO NOMBRE Y CIUDAD QUE P8 --
-- No funciona para MySQL --
SELECT * FROM PRO;
UPDATE PRO 
    SET (NOMP, CIUDADP) = (SELECT NOMP, CIUDADP
                            FROM PRO
                            WHERE NP = 'P5')
    WHERE NP = 'P7';
SELECT * FROM PRO;