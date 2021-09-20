Algoritmo E22_DosSumasExcepciones_Completo
	//Declaraciones
	Definir primeraParte Como Logico
	Definir cont, suma1, suma2, num Como Entero
	
	//Pseudocódigo
	primeraParte <- Verdadero
	cont <- 0
	suma1 <- 0
	suma2 <- 0
	
	Hacer
		Mostrar "Dame un valor y te daré una suma (0 para salir, > 200 para otra suma)"
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
	
	Si suma1 = 0
		Si suma2 = 0
			Mostrar "No has introducido ningún valor"
		SiNo //suma2 <> 0
			Mostrar "No hay primera suma"
			Mostrar "Segunda suma: " ,suma2
			Mostrar "Valores introducidos: " ,cont
		FinSi
	SiNo //suma1 <> 0
		Si suma2 = 0
			Mostrar "Primera suma: " ,suma1
			Mostrar "No hay segunda suma"
			Mostrar "Valores introducidos: " ,cont
		SiNo //suma2 <> 0
			Mostrar "Primera suma: " ,suma1
			Mostrar "Segunda suma: " ,suma2
			Mostrar "Valores introducidos: " ,cont
		FinSi
	FinSi
FinAlgoritmo
