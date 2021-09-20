-- EJERCICIO 1 --
-- NOMBRE DE LOS CONDUCTORES DE CATEGORIA 15 --
SELECT C.NOMBRE
    FROM CONDUCTORES C
    WHERE C.CATEG = 15;

-- EJERCICIO 2 --
-- DESCRIPCION DE PROYECTOS EN LOS QUE SE HAYAN REALIZADO TRABAJOS DURANTE LOS DIAS 11 AL 15
SELECT P.DESCRIP
    FROM PROYECTOS P, TRABAJOS T
    WHERE P.CODP = T.CODP AND T.FECHA BETWEEN '2002-09-11' AND '2002-09-15';

-- EJERCICIO 3 --
-- NOMBRE DE CONDUCTORES QUE HAYAN TRABAJADO CON UNA HORMIGONERA, ORDENADOS DESC
SELECT C.NOMBRE
    FROM CONDUCTORES C, TRABAJOS T
    WHERE T.CODC = C.CODC AND T.CODM = (SELECT M.CODM
                                            FROM MAQUINAS M
                                            WHERE M.NOMBRE LIKE 'HORMIGONERA')
    ORDER BY C.NOMBRE DESC;

-- EJERCICIO 4 --
-- NOMBRE DE LOS CONDUCTORES QUE HAYAN TRABAJADO CON UNA HORMIGONERA EN ARGANDA --
SELECT C.NOMBRE
    FROM CONDUCTORES C, TRABAJOS T
    WHERE T.CODC = C.CODC AND T.CODM = (SELECT M.CODM
                                            FROM MAQUINAS M
                                            WHERE M.NOMBRE LIKE 'HORMIGONERA') AND T.CODP = ANY(SELECT P.CODP
                                                                                                    FROM PROYECTOS P
                                                                                                    WHERE P.LOCALIDAD LIKE 'ARGANDA');

-- EJERCICIO 5 --
-- NOMBRE DE LOS CONDUCTORES Y DESCRIPCION DEL PROYECTO DONDE LOS CONDUCTORES HAYAN TRABAJADO CON UNA HORMIGONERA EN PROYECTOS DE ARGANDA ENTRE EL 12 Y 17 DE SEP --
SELECT C.NOMBRE, 
    FROM CONDUCTORES C, TRABAJOS T, PROYECTOS P
    WHERE T.CODC = C.CODC AND T.CODP = P.CODP AND T.CODM = (SELECT M.CODM
                                                                FROM MAQUINAS M
                                                                WHERE M.NOMBRE LIKE 'HORMIGONERA') AND T.CODP = ANY(SELECT P.CODP
                                                                                                                        FROM PROYECTOS P
                                                                                                                        WHERE P.LOCALIDAD LIKE 'ARGANDA') AND T.FECHA BETWEEN '2002-09-12' AND '2002-09-17';

-- EJERCICIO 6 --
-- CONDUCTORES QUE TRABAJAN EN LOS PROYECTOS DE JOSE PEREZ --
SELECT C.NOMBRE
    FROM TRABAJOS T, PROYECTOS P, CONDUCTORES C
    WHERE T.CODP = P.CODP AND T.CODC = C.CODC AND P.CLIENTE LIKE 'JOSÉ PÉREZ';

-- EJERCICIO 7 --
-- NOMBRE Y LOCALIDAD DE LOS CONDUCTORES QUE NO TRABAJAN EN LOS PROYECTOS DE JOSE PEREZ --
SELECT DISTINCT C.CODC, C.LOCALIDAD
    FROM CONDUCTORES C
    WHERE C.CODC NOT IN (SELECT T.CODC
                            FROM TRABAJOS
                            WHERE T.CODP IN (SELECT P.CODP
                                                FROM PROYECTOS
                                                WHERE P.CLIENTE LIKE 'JOS% P%REZ'));

-- EJERCICIO 8 --
-- DATOS DE LOS PROYECTOS REALIZADOS EN RIVAS O DE UN CLIENTE LLAMADO JOSE --
SELECT *
    FROM PROYECTOS P
    WHERE P.LOCALIDAD LIKE 'RIVAS' OR P.CLIENTE LIKE 'JOS%';

-- EJERCICIO 9 --
-- CONDUCTORES QUE, AUN HABIENDO TRABADO EN ALGUN PROYECTO, FIGUREN SIN HORAS --
SELECT T.CODC
    FROM TRABAJOS T
    WHERE T.TIEMPO IS NULL;

-- EJERCICIO 10 --
-- EMPLEADOS QUE TENGA COMO APELLIDO PEREZ Y HAYAN TRABAJADO EN PROYECTOS DE LOCALIDADES DIFERENTES A LAS SUYAS --
SELECT C.CODC, C.NOMBRE
    FROM CONDUCTORES C
    WHERE C.NOMBRE LIKE '%P%REZ' AND C.LOCALIDAD <> P.LOCALIDAD;

-- EJERCICIO 11 --
-- NOMBRE DE LOS CONDUCTORES Y LA LOCALIDAD DEL PROYECTO PARA AQUELLOS QUE HAYAN TRABAJADO CON MAQUINAS CON UN PRECIO ENTRE 10000 Y 15000 --
SELECT C.NOMBRE, P.LOCALIDAD
    FROM CONDUCTORES C, PROYECTOS P, MAQUINAS M, TRABAJOS T
    WHERE T.CODC = C.CODC AND T.CODM = M.CODM AND T.CODP = P.CODP AND M.PRECIOHORA BETWEEN 10000 AND 15000;

-- EJERCICIO 12 --
-- NOMBRE Y LOCALIDAD DE LOS CONDUCTORES, Y LA LOCALIDAD DE LOS PROYECTOS QUE SEAN DE RIVAS Y NO SE HAYAN USADO HORMIGONERAS O EXCAVADORAS --
SELECT C.NOMBRE, C.LOCALIDAD, P.LOCALIDAD
    FROM CONDUCTORES C, PROYECTOS P, MAQUINAS M, TRABAJOS T
    WHERE T.CODC = C.CODC AND T.CODM = M.CODM AND T.CODP = P.CODP AND P.LOCALIDAD LIKE 'RIVAS' AND M.NOMBRE NOT IN (SELECT M.NOMBRE
                                                                                                                        FROM MAQUINAS M
                                                                                                                        WHERE M.NOMBRE LIKE 'HORMIGONERAS' OR M.NOMBRE LIKE 'EXCAVADORAS');

-- EJERCICIO 13 --
-- TODOS LOS DATOS DE LOS PROYECTOS QUE SE HAYAN REALIZADO EL 15/9, INCLUYENDO EL NOMBRE Y LOCALIDAD DE LOS CONDUCTORES QUE HAYAN TRABAJADO EN DICHOS PROYECTOS --
SELECT P.*, C.NOMBRE, C.LOCALIDAD
    FROM PROYECTOS P, CONDUCTORES C, TRABAJOS T
    WHERE T.CODP = P.CODP AND T.CODC = C.CODC AND P.CODP IN (SELECT T.CODP
                                                                FROM TRABAJOS T
                                                                WHERE T.FECHA LIKE '2002-09-15');

-- EJERCICIO 14 --
-- NOMBRE DE LOS CONDUCTORES Y EL NOMBRE Y LOCALIDAD DE LOS CLIENTES EN LOS QUE SE HAYA UTILIZADO LA MAQUINA CON EL PRECIO MAS ELEVADO --
SELECT C.NOMBRE, P.CLIENTE, P.LOCALIDAD
    FROM CONDUCTORES C, PROYECTOS P, TRABAJOS T
    WHERE T.CODC = C.CODC AND T.CODP = P.CODP AND T.CODM IN (SELECT M.CODM
                                                                FROM MAQUINAS M                                                                
                                                                WHERE M.PRECIOHORA IN (SELECT MIN(M.PRECIOHORA)
                                                                                            FROM MAQUINAS M));

-- EJERCICIO 15 --
-- PROYECTOS QUE SIEMPRE HAN UTILIZADO LA MAQUINA CON EL PRECIO MAS BAJO --
SELECT P.*
    FROM TRABAJOS T, PROYECTOS P
    WHERE T.CODP = P.CODP AND 
            T.CODP NOT IN (SELECT T.CODP
                            FROM TRABAJOS T
                            WHERE T.CODM NOT IN (SELECT M.CODM
                                                FROM MAQUINAS M
                                                WHERE M.PRECIOHORA IN (SELECT MIN(M.PRECIOHORA)
                                                                        FROM MAQUINAS M)));

--PRUEBAS--
SET AUTOCOMMIT = 0;
UPDATE TRABAJOS
    SET CODM = 'M02'
    WHERE CODP = 'P03';
...
ROLLBACK;
-- EJERCICIO 16 --
-- PROYECTOS EN LOS QUE HAYA TRABAJADO EL CONDUCTOR DE CATEGORIA MAS ALTA - 2, USANDO LA MAQUINA DE MENOR PRECIO --
SELECT DISTINCT T.CODP
    FROM TRABAJOS T
    WHERE T.CODC IN (SELECT C.CODC
                        FROM CONDUCTORES C
                        WHERE C.CATEG IN (SELECT MAX(C.CATEG) - 2
                                            FROM CONDUCTORES C)) AND T.CODM IN (SELECT M.CODM
                                                                                    FROM MAQUINAS M
                                                                                    WHERE M.PRECIOHORA IN (SELECT MIN(M.PRECIOHORA)
                                                                                                                FROM MAQUINAS M));

-- EJERCICIO 17 --
-- POR CADA UNO DE LOS CLIENTES, OBTENER EL TIEMPO TOTAL EMPLEADO EN SUS PROYECTOS --
SELECT P.CLIENTE, SUM(T.TIEMPO)'TIEMPO TOTAL'
    FROM TRABAJOS T, PROYECTOS P
    WHERE T.CODP = P.CODP
    GROUP BY P.CLIENTE;

-- EJERCICIO 18 --
-- POR CADA UNO DE LOS PROYECTOS, SU DESCRIPCION, EL CLIENTE Y EL TOTAL A FACTURAR. ORDENAR POR EL TOTAL Y POR CLIENTES --
SELECT P.CLIENTE, P.DESCRIP, SUM(T.TIEMPO * M.PRECIOHORA), SUM(T.TIEMPO * PRECIOHORA) / 166,366
    FROM TRABAJOS T, PROYECTOS P, MAQUINAS M
    WHERE T.CODP = P.CODP AND T.CODM = M.CODM
    GROUP BY P.CODP
    ORDER BY 3,1;

-- EJERCICIO 19 --
-- OBTENER LA DESCRIPCION, EL CLIENTE Y EL TOTAL A FACTURAR DEL PROYECTO DEL CUAL SE VAYA A FACTURAR MAS --
SELECT P.DESCRIP, P.CLIENTE, TABLA4.TOTAL
    FROM PROYECTOS P, TRABAJOS T, (SELECT TABLA3.CODP, TABLA3.TOTAL
                                    FROM (SELECT TABLA2.CODP, (TABLA2.TOTAL * M.PRECIOHORA)'TOTAL'
                                            FROM MAQUINAS M, (SELECT TABLA.CODP, TABLA.TOTAL/60'TOTAL'
                                                                FROM (SELECT T.CODP, SUM(T.TIEMPO)'TOTAL'
                                                                        FROM TRABAJOS T
                                                                        GROUP BY T.CODP) AS TABLA
                                                                GROUP BY TABLA.CODP) AS TABLA2
                                            GROUP BY TABLA2.CODP) AS TABLA3
                                    WHERE TABLA3.TOTAL IN (SELECT MAX(TABLA3.TOTAL)
                                                            FROM (SELECT TABLA2.CODP, (TABLA2.TOTAL * M.PRECIOHORA)'TOTAL'
                                                                    FROM MAQUINAS M, (SELECT TABLA.CODP, TABLA.TOTAL/60'TOTAL'
                                                                                        FROM (SELECT T.CODP, SUM(T.TIEMPO)'TOTAL'
                                                                                                FROM TRABAJOS T
                                                                                                GROUP BY T.CODP) AS TABLA
                                                                                        GROUP BY TABLA.CODP) AS TABLA2
                                                                    GROUP BY TABLA2.CODP) AS TABLA3)) AS TABLA4
    WHERE T.CODP = P.CODP
    GROUP BY TABLA4.TOTAL;
    


-- EJERCICIO 20 --
-- CONDUCTORES QUE HAYAN TRABAJADO EN TODOS LOS PROYECTOS DE ARGANDA --
SELECT C.CODC
    FROM CONDUCTORES C
    WHERE C.CODC NOT IN (SELECT T.CODC
                            FROM TRABAJOS T
                            WHERE T.CODP IN (SELECT P.CODP
                                                FROM PROYECTOS P
                                                WHERE P.LOCALIDAD NOT LIKE 'ARGANDA'));

-- EJERCICIO 21 --
-- TIEMPO MAXIMO DEDICADO A CADA PROYECTO PARA AQUELLOS EN LOS QUE HAYA PARTICIPADO MAS DE UN CONDUCTOR DIFERENTE --
SELECT T.CODP, MAX(T.TIEMPO)
    FROM TRABAJOS T
    GROUP BY T.CODP
    HAVING COUNT(DISTINCT T.CODC) > 1;

-- EJERCICIO 22 --
-- NUMERO DE PARTES DE TRABAJO, CODP, DESCRIPCION Y CLIENTE PARA AQUEL PROYECTO QUE FIGURE CON MAS PARTES DE TRABAJO --
SELECT TABLA.NUM_PARTES, TABLA.CODP, TABLA.DESCRIP, TABLA.CLIENTE
    FROM (SELECT COUNT(T.CODP)'NUM_PARTES', T.CODP, P.DESCRIP, P.CLIENTE
            FROM TRABAJOS T, PROYECTOS P
            WHERE T.CODP = P.CODP
            GROUP BY T.CODP) AS TABLA
    WHERE TABLA.NUM_PARTES IN (SELECT MAX(T2.NUM_PARTES)
                                FROM (SELECT COUNT(T.CODP)'NUM_PARTES', T.CODP, P.DESCRIP, P.CLIENTE
                                        FROM TRABAJOS T, PROYECTOS P
                                        WHERE T.CODP = P.CODP
                                        GROUP BY T.CODP) AS T2);

----
SELECT P.CODP, P.DESCRIP, P.CLIENTE, COUNT(*) 'NUMERO DE TRABAJOS'
    FROM PROYECTOS P, TRABAJOS T
    WHERE P.CODP = T.CODP
    GROUP BY P.CODP, P.DESCRIP, P.CLIENTE
    HAVING COUNT(*) >= ALL(SELECT COUNT(*)
                            FROM TRABAJOS T
                            GROUP BY T.CODP);

-- EJERCICIO 23 --
-- LOCALIDAD DE LOS CONDUCTORES QUE HAYAN PARTICIPADO EN MAS DE DOS PROYECTOS DIFERENTES --
SELECT C.LOCALIDAD
    FROM CONDUCTORES C
    WHERE C.CODC IN (SELECT T.CODC
                        FROM TRABAJOS T
                        GROUP BY T.CODC
                        HAVING COUNT(DISTINCT T.CODP) > 2);

-- EJERCICIO 24 --
-- ELIMINAR LAS TABLAS DE LA BD --
DROP TABLE TRABAJOS, CONDUCTORES, MAQUINAS, PROYECTOS;





















-- EJERCICIO 14 --
SELECT C.NOMBRE, P.CLIENTE, P.LOCALIDAD
    FROM CONDUCTORES C, PROYECTOS P, TRABAJOS T
    WHERE T.CODC = C.CODC AND T.CODP = P.CODP AND T.CODM NOT IN(SELECT M.CODM
                                                                FROM MAQUINAS M
                                                                WHERE M.PRECIOHORA <> (SELECT MAX(M.PRECIOHORA)
                                                                                        FROM MAQUINAS M));