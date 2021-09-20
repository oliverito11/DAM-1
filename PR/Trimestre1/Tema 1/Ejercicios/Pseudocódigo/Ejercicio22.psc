Algoritmo E22_DosSumasExcepciones
	//Declaraciones
	Definir primeraParte Como Logico
	Definir cont, suma1, suma2, num Como Entero
	
	//Pseudocódigo
	primeraParte <- Verdadero
	cont <- 0
	suma1 <- 0
	suma2 <- 0
	
	Hacer
		Mostrar "Dame un valor"
		Leer num
		Si num <> 0
			Si primeraParte = Verdadero
				Si num <= 200
					suma1 <- suma1 + num
					cont <- cont + 1
				SiNo
					primeraParte <- Falso
				FinSi
			SiNo
				suma2 <- suma2 + num
				cont <- cont + 1
			FinSi
		FinSi
	Hasta Que num = 0
	
	Mostrar "Primera suma: " ,suma1
	Mostrar "Segunda suma: " ,suma2
	Mostrar "Valores introducidos: " ,cont
FinAlgoritmo
