-- MAYOR --
SELECT *
    FROM PED P
    WHERE P.CANTIDAD = (SELECT MAX(P.CANTIDAD)
                        FROM PED P);

SELECT *
    FROM PED P
    WHERE P.CANTIDAD = ANY(SELECT MAX(P.CANTIDAD)
                            FROM PED P);

SELECT DISTINCT *
    FROM PED P
    WHERE P.CANTIDAD >= ALL(SELECT P.CANTIDAD
                            FROM PED P);

-- DISTINTO DEL MAYOR --
SELECT DISTINCT *
    FROM PED P
    WHERE P.CANTIDAD < ANY(SELECT P.CANTIDAD
                            FROM PED P);
                            
SELECT *
    FROM PED P
    WHERE P.CANTIDAD NOT IN (SELECT MAX(P.CANTIDAD)
                                FROM PED P);

-- MENOR DE TODOS --
SELECT DISTINCT *
    FROM PED P
    WHERE P.CANTIDAD <= ALL(SELECT P.CANTIDAD
                            FROM PED P);