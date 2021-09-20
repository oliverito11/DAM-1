Algoritmo E19_3_SumImpar0yValor
	suma <- 0
	numImpar <- 1
	Mostrar "Mostrar la suma de los impares entre 0 y ..."
	Leer limit
	Mientras numImpar < limit
		suma <- suma + numImpar
		numImpar <- numImpar + 2
	FinMientras
	Mostrar suma
FinAlgoritmo
