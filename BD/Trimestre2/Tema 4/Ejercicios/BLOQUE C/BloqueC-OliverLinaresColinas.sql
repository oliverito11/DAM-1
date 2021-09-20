-- EJERCICIO A --
-- PAREJAS QUE SON SIMPÁTICOS PARA AMBOS --
SELECT H.NOMH'HOMBRE', H.NOMM'MUJER'
    FROM HSIM H, MSIH M
    WHERE H.NOMH = M.NOMH AND H.NOMM = M.NOMM;

-- EJERCICIO B --
-- MISMO QUE EL ANTERIOR PERO ENTRE 20 Y 30 ANYOS Y QUE NO ESTÉN CASADOS ENTRE SÍ --
SELECT H.NOMH'HOMBRE', H.NOMM'MUJER'
    FROM HSIM H, MSIH M
    WHERE H.NOMH = M.NOMH AND H.NOMM = M.NOMM
    AND H.NOMM IN (SELECT M.NOMM
                    FROM MUJERES M
                    WHERE M.EDAD BETWEEN 20 AND 30)
    AND H.NOMH IN(SELECT H.NOMH
                    FROM HOMBRES H
                    WHERE H.EDAD BETWEEN 20 AND 30)
    AND (H.NOMH, H.NOMM) NOT IN (SELECT M.NOMH, M.NOMM
                                    FROM MATRIMONIOS M);

-- EJERCICIO C --
-- MATRIMONIOS QUE SE CAEN MUTUAMENTE SIMPÁTICOS --
SELECT *
    FROM MATRIMONIOS M
    WHERE M.NOMH IN (SELECT M.NOMH
                        FROM MSIH M
                        WHERE M.NOMM IN (SELECT M.NOMM
                                            FROM HSIM M));

-- EJERCICIO D --
-- MUJERES CASADAS QUE NO LES CAEN SIMPÁTICOS SUS MARIDOS --
SELECT M.NOMM
    FROM MATRIMONIOS M
    WHERE M.NOMH NOT IN (SELECT M.NOMH
                            FROM MSIH M
                            WHERE M.NOMM IN (SELECT M.NOMM
                                                FROM HSIM M));

-- EJERCICIO E --
-- HOMBRES A LOS QUE NO LES CAE SIMPÁTICA NINGUNA MUJER --
SELECT H.NOMH
    FROM HOMBRES H
    WHERE H.NOMH NOT IN (SELECT M.NOMH
                            FROM MSIH M);

-- EJERCICIO F --
-- HOMBRES Y MUJERES A LOS QUE NO LES CAE SIMPÁTICOS NADIE --
SELECT H.NOMH'HOMBRES Y MUJERES'
    FROM HOMBRES H
    WHERE H.NOMH NOT IN(SELECT M.NOMH
                            FROM MSIH M)
UNION
SELECT M.NOMM
    FROM MUJERES M
    WHERE M.NOMM NOT IN(SELECT H.NOMM
                          FROM HSIM H);

-- EJERCICIO G --
-- MUJERES CASADAS QUE LES CAEN SIMPÁTICA A ALGÚN HOMBRE --
SELECT M.NOMM
    FROM MATRIMONIOS M
    WHERE M.NOMM IN (SELECT M.NOMM
                        FROM MSIH M);

-- EJERCICIO H --
-- HOMBRES Y MUJERES QUE NO CAEN BIEN A NADIE --
SELECT H.NOMH'HOMBRES Y MUJERES'
    FROM HOMBRES H
    WHERE H.NOMH NOT IN(SELECT H.NOMH
                            FROM HSIM H)
UNION
SELECT M.NOMM
    FROM MUJERES M
    WHERE M.NOMM NOT IN(SELECT M.NOMM
                          FROM MSIH M);

-- EJERCICIO I --
-- HOMBRES A QUIENES SOLO LES CAEN SIMPÁTICAS MUJERES CASADAS --
SELECT H.NOMH
    FROM HOMBRES H
    WHERE H.NOMH NOT IN (SELECT M.NOMH
                            FROM MSIH M
                            WHERE M.NOMM IN (SELECT M.NOMM
                                                FROM MATRIMONIOS M));