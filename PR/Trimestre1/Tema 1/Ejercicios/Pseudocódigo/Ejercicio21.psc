Algoritmo E21_Factorial
	fact <- 1
	Mostrar "Dame un n�mero y te dar� su factorial"
	leer num
	Para i <- 1 Hasta num Con Paso 1 Hacer
		fact <- fact * i
	FinPara
	Mostrar "El factorial de " ,num, " es: " ,fact
FinAlgoritmo
