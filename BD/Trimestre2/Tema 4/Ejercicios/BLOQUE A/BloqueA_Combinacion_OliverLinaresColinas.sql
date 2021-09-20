USE COMERCIAL;

-- EJERCICIO 4 --
-- NOMBRES DE LAS FABRICAS A LAS QUE SUMINISTRA P1 --

SELECT F.NOMF
	FROM PED P, FAB F
	WHERE F.NF = P.NF AND P.NP = 'P1';
	
-- EJERCICIO 5 --
-- COLORES DE LOS ARTICULOS SUMINISTRADOS POR P1 --

SELECT A.COLOR
	FROM ART A, PED P
	WHERE P.NA = A.NA AND P.NP = 'P1';
	
-- EJERCICIO 6 --
-- PROVEEDORES QUE SUMINISTRAN ARTICULOS AZULES A LA F1 --

SELECT P.NP
	FROM PED P, ART A
	WHERE P.NA = A.NA AND A.COLOR LIKE 'AZUL' AND P.NF LIKE 'F1';

-- EJERCICIO 7 --
-- ARTICULOS SUMINISTRADOS A LAS FABRICAS DE MADRID --

SELECT P.NA
	FROM FAB F, PED P
	WHERE P.NF = F.NF AND F.CIUDADF LIKE 'MADRID';

-- EJERCICIO 8 --
-- PROVEEDORES QUE SUMINISTRAN ALGUN ARTICULO AZUL A LAS FABRICAS DE MADRID(F2) O LISBOA(F3)

SELECT P.NP
	FROM PED P, FAB F, ART A
	WHERE P.NA = A.NA AND P.NF = F.NF AND A.COLOR LIKE 'AZUL' AND (F.CIUDADF LIKE 'MADRID' OR F.CIUDADF LIKE 'LISBOA');
	
-- EJERCICIO 9 --
-- ARTICULOS SUMINISTRADOS POR PROVEEDORES DE ZAMORA A LAS FABRICAS DE MADRID --

SELECT P.NA
	FROM PED P, PRO PR, FAB F
	WHERE P.NP = PR.NP AND P.NF = F.NF AND PR.CIUDADP = 'ZAMORA' AND F.CIUDADF LIKE 'MADRID';
	
-- EJERCICIO 10 --
-- FABRICAS ABASTECIDAS POR UN PROVEEDOR DE DISTINTA CIUDAD --

SELECT DISTINCT P.NF
	FROM PED P, FAB F, PRO PR
	WHERE P.NF = F.NF AND P.NP = PR.NP AND PR.CIUDADP NOT LIKE F.CIUDADF;
	
-- EJERCICIO 11 --
-- PAREJAS DE CIUDADES TALES QUE UN PROVEEDOR DE LA 1a ABASTECE A UNA FABRICA DE LA 2a --

SELECT PR.CIUDADP, F.CIUDADF
	FROM PED P, FAB F, PRO PR
	WHERE P.NF = F.NF AND P.NP = PR.NP;

-- EJERCICIO 12 --
-- TRIPLETAS DE VALORES <CIUDAD, NA, CIUDAD> TALES QUE UN PROVEEDOR DE LA 1a CIUDAD ABASTECE EL ARTICULO NA A UNA FABRICA DE LA 2a CIUDAD --

SELECT PR.CIUDADP, P.NA, F.CIUDADF
	FROM PED P, FAB F, PRO PR
	WHERE P.NF = F.NF AND P.NP = PR.NP;

-- EJERCICIO 13 --
-- IDEM, PERO SIN OBTENER LAS TRIPLETAS EN LAS QUE COINCIDEN AMBAS CIUDADES

SELECT PR.CIUDADP, P.NA, F.CIUDADF
	FROM PED P, FAB F, PRO PR
	WHERE P.NF = F.NF AND P.NP = PR.NP AND PR.CIUDADP NOT LIKE F.CIUDADF;