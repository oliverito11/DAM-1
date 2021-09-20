-- EJERCICIO B --
SELECT DISTINCT NOMBREA
    FROM AGENCIA A, RESERVA R
    WHERE R.CODA = A.CODA AND CODC IN (SELECT CODC
                                        FROM CLIENTE
                                        WHERE NOMBREC LIKE 'SERGIO RAMOS');

-- EJERCICIO C --
SELECT DISTINCT DIRG
    FROM GARAJE G
    WHERE CODG IN (SELECT CODG
                    FROM COCHE
                    WHERE CODV IN (SELECT CODV
                                    FROM RESERVA
                                    WHERE CODA IN (SELECT CODA
                                                    FROM AGENCIA
                                                    WHERE NOMBREA LIKE 'LA VELOZ')));

-- EJERCICIO D --
SELECT MARCA, MODELO
    FROM COCHE
    WHERE CODV NOT IN (SELECT CODV
                        FROM RESERVA);

-- EJERCICIO E --
SELECT CODC
    FROM RESERVA
    WHERE CODC IN (SELECT CODC
                    FROM RESERVA
                    GROUP BY CODC
                    HAVING COUNT(CODA) = 1);

-- EJERCICIO F --
SELECT DISTINCT CODC
    FROM RESERVA
    WHERE NCOCHES >= (SELECT MAX(NCOCHES)
                        FROM RESERVA);