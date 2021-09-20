Algoritmo E19_2_SumImpar0yValor
	suma <- 0
	numImpar <- 1
	Mostrar "Mostrar la suma de los impares entre 0 y ..."
	Leer limit
	Hacer
		suma <- suma + numImpar
		numImpar <- numImpar + 2
	Hasta Que numImpar >= limit
	Mostrar suma
FinAlgoritmo
