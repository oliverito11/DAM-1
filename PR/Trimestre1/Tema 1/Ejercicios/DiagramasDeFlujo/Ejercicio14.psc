Algoritmo Ejercicio14
	primeraParte <- Verdadero
	suma <- 0
	suma2 <- 0
	contador <- 0
	Repetir
		Escribir 'Introduce un valor (0 para terminar, número mayor de 200 para otra suma)'
		Leer num
		Si num=0 Entonces
			Escribir '0 detectado. Mostransdo resultados...'
		SiNo
			Si primeraParte=Verdadero Entonces
				Si num<=200 Entonces
					suma <- suma+num
					contador <- contador+1
				SiNo
					primeraParte <- Falso
				FinSi
			SiNo
				suma2 <- suma2+num
				contador <- contador+1
			FinSi
		FinSi
	Hasta Que num=0
	Si suma=0 Entonces
		Si suma2=0 Entonces
			Escribir 'No has introducido ningún valor'
		SiNo
			Escribir 'No hay primera suma'
			Escribir 'La segunda suma es: ',suma2
			Escribir 'Has introducido ',contador,' valores'
		FinSi
	SiNo
		Si suma2=0 Entonces
			Escribir 'La primera suma es: ',suma
			Escribir 'No hay segunda suma'
			Escribir 'Has introducido ',contador,' valores'
		SiNo
			Escribir 'La primera suma es: ',suma
			Escribir 'La segunda suma es: ',suma2
			Escribir 'Has introducido ',contador,' valores'
		FinSi
	FinSi
	Escribir 'Fin del programa'
FinAlgoritmo
