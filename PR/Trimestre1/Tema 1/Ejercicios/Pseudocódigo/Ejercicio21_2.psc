Algoritmo E21_2_Factorial
	//Declaraciones
	Definir fact Como Entero
	Definir num Como Entero
	
	//Pseudocódigo
	fact <- 1
	Mostrar "Dame un número y te daré su factorial"
	leer num
	Mientras num > 0
		fact <- fact * num
		num <- num - 1
	FinMientras
	Mostrar "El factorial es: " ,fact
FinAlgoritmo
