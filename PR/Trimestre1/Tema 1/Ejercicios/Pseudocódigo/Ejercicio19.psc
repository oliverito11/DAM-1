Algoritmo E19_SumImpar0yValor
	suma <- 0
	Mostrar "Mostrar la suma de los impares entre 0 y ..."
	Leer limit
	Para i <- 1 Hasta limit - 1 Con Paso 2 Hacer
		suma <- suma + i
	FinPara
	Mostrar "El resultado es: " ,suma
FinAlgoritmo
