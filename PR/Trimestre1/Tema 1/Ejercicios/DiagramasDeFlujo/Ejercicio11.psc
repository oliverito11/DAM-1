Algoritmo Ejercicio11
	Repetir
		Escribir "Dame un valor:"
		Leer num
		Si num % 2 = 0 Entonces
			numPares <- numPares + num
		SiNo
			numImpares <- numImpares + num
		FinSi
	Hasta Que num = 0
	Escribir "La suma de todos los pares es: " ,numPares, " y la de los impares es: " ,numImpares
FinAlgoritmo
