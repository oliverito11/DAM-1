Algoritmo Ejercicio7
	Escribir "Dime cuantos numeros impares quieres ver:"
	Leer maxImpar
	num <- 1
	Mientras maxImpar > 0 Hacer
		suma <- suma + num
		num <- num + 2
		maxImpar <- maxImpar - 1
	FinMientras
	Escribir "La suma de todos los impares usados es: " ,suma
FinAlgoritmo
