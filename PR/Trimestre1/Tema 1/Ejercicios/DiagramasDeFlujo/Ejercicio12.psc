Algoritmo Ejercicio12
	Escribir 'Hola! ¿Cuánto quieres comprar hoy?'
	Leer cantidad
	Si cantidad>10 Entonces
		precioProducto <- 15
	SiNo
		precioProducto <- 20
	FinSi
	totalCompra <- precioProducto*cantidad
	Escribir 'Muy bien, pues por ',cantidad,' productos debes pagar $',precioProducto,' por cada uno, lo que hace un total de $',totalCompra
FinAlgoritmo
