Algoritmo E21_3_Factorial
	//Declaraciones
	Definir fact Como Entero
	Definir num Como Entero
	
	//Pseudocódigo
	fact <- 1
	Mostrar "Dame un número y te daré su factorial"
	leer num
	Hacer
		fact <- fact * num
		num <- num - 1
	Hasta Que num <= 0
	Mostrar "El factorial es: " ,fact
FinAlgoritmo
