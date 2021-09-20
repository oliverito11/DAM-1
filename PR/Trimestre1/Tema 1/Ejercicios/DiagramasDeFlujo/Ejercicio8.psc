Algoritmo Ejercicio8
	Escribir "Cuantos numeros pares quieres sumar: "
	Leer cantidadPares
	num <- 0
	Para i<-cantidadPares Hasta 1 Con Paso -1 Hacer
		suma <- suma + num
		num <- num + 2
	FinPara
	Escribir suma
FinAlgoritmo
