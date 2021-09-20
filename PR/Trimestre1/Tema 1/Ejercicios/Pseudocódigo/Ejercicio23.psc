Algoritmo E23_CantidadSecuenciaRepeticiones
	//Declaraciones
	Definir cont, lastNum, repet, repetMayor, numMasRepet, num Como Entero
	
	//Pseudocódigo
	cont <- 0
	lastNum <- 0
	repet <- 1
	repetMayor <- 0
	numMasRepet <- 0
	
	Hacer
		Mostrar "Dame un número (0 para salir)"
		Leer num
		Si num <> 0
			cont <- cont + 1
			Si num = lastNum
				repet <- repet + 1
				Si repet > repetMayor
					repetMayor <- repet
					numMasRepet <- num
				FinSi
			SiNo
				repet <- 1
			FinSi
			lastNum <- num
		FinSi
	Hasta Que num = 0
	
	Si cont = 0
		Mostrar "No has introducido ningún valor."
	SiNo
		Mostrar "Has introducido " ,cont, " valores y se ha repetido el valor " ,numMasRepet, " estas veces: " ,repetMayor
	FinSi
FinAlgoritmo
