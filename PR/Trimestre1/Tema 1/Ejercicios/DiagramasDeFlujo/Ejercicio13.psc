Algoritmo Ejercicio13
	Escribir "�Cu�ntos libros quieres?"
	Leer libros
	Repetir
		Escribir "�Y de qu� tipo, 1 o 2?"
		Leer tipo
	Hasta Que tipo > 0 Y tipo < 3
	Si tipo = 1 Entonces
		precioLibro <- 80
	SiNo
		precioLibro <- 100
	FinSi
	precioTotal <- libros * precioLibro
	Escribir libros, " libros de ese tipo ser�n $" ,precioLibro, " por cada uno, por lo que el total es de: $" ,precioTotal
FinAlgoritmo
