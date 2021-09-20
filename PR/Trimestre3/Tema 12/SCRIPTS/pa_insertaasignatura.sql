USE instituto;
CREATE PROCEDURE PA_INSERTAASIGNATURA
(IN nomasig VARCHAR(100),
	IN horasasig INT)

	INSERT INTO Asignaturas (nombre,horas) VALUES (nomasig, horasasig)

