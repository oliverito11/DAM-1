Algoritmo E20_Ordenar
	temp <- 0
	Mostrar "Dame un número"
	Leer num1
	Mostrar "Dame un segundo número"
	Leer num2
	Mostrar "Dame un tercer número"
	Leer num3
	
	Si num1 < num2
		temp <- num2
		num2 <- num1
		num1 <- temp
	FinSi
	Si num1 < num3
		temp <- num3
		num3 <- num1
		num1 <- temp
	FinSi
	Si num2 < num3
		temp <- num3
		num3 <- num2
		num2 <- temp
	FinSi
	
	Si num1 > num2 Y num2 > num3
		Mostrar num1, " > " ,num2, " > " ,num3
	SiNo
		Si num1 = num2 Y num2 <> num3
			Mostrar num1, " = " ,num2, " > " ,num3
		SiNo
			Si num1 <> num2 Y num2 = num3
				Mostrar num1, " > " ,num2, " = " ,num3
			SiNo
				Si num1 = num2 Y num2 = num3
					Mostrar "Todos los números son iguales: " ,num1, " = " ,num2, " = " ,num3
				FinSi
			FinSi
		FinSi
	FinSi
FinAlgoritmo
