Algoritmo Ejercicio13_2
	Escribir '�Cu�ntos libros quieres?'
	Leer libros
	Escribir '�Y de qu� tipo, 1 o 2?'
	Leer tipo
	Segun tipo Hacer
		1:
			precioLibro <- 80
			Escribir "Precio total: " libros * precioLibro
		2:
			precioLibro <- 100
			Escribir "Precio total: " libros * precioLibro
		De Otro Modo:
			Escribir "Tipo incorrecto"
	FinSegun
FinAlgoritmo
