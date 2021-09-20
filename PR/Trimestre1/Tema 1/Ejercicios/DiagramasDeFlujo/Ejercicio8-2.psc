Algoritmo Ejercicio8
	Escribir "Cuantos numeros pares quieres sumar: "
	Leer cantidadPares
	num <- 0
	Mientras cantidadPares > 0 Hacer
		suma <- suma + num
		num <- num + 2
		cantidadPares <- cantidadPares - 1
	FinMientras
	Escribir suma
FinAlgoritmo
