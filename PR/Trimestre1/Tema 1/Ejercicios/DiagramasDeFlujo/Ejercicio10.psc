Algoritmo Ejercicio10
	cantidadNum <- 0
	Repetir
		Escribir "Dame valores sucesivamente y te daré sus cuadrados:"
		Leer num
		Si num = 0 Entonces
			Escribir "0 detectado. Has introducido " ,cantidadNum, " valores."
		SiNo
			Escribir num ^ 2
			cantidadNum <- cantidadNum + 1
		FinSi
	Hasta Que num = 0
	Escribir "Fin del programa."
FinAlgoritmo
