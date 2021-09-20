package Ejercicios;

import java.util.Scanner;
import java.util.Vector;
public class Ejer28 {
	static Scanner teclado = new Scanner(System.in);
	
	static final int F_TABLERO = 8;
	static final int C_TABLERO = 8;
	
	static final int CANTIDAD_BARCOS = 2;
	
	static final int HORIZONTAL = 1;
	static final int VERTICAL = 2;
	
	static final int INTENTOS = 15;
	
	static final char ESTILO_TABLERO_IZQ = '[';
	static final char ESTILO_TABLERO_DRCH = ']';	
	static final char BARCO = 'B';
	static final char TOCADO = 'X';
	static final char AGUA = '~';
	
	//TABLERO
	static char[][] tablero = new char[F_TABLERO][C_TABLERO];
	
	//Este tablero se usará con el jugador 2
	static char[][] tablero2 = new char[F_TABLERO][C_TABLERO];
	
	//Vector para almacenar las posiciones de los barcos
	static Vector<int[][]> posBarcos = new Vector<int[][]>();
	public static void main(String[] args) {
		System.out.println("\t\t\tJUGADOR UNO");
		mostrarTablero(tablero);
		colocarBarcos();
		limpiarPantalla();
		
		System.out.println("\t\tJUGADOR DOS");
		if(!juego())
			System.out.println("Has perdido");
		else
			System.out.println("Has ganado!");
		teclado.close();
	}
	
	static boolean juego() {
		int intentos = INTENTOS;
		int hundidos = 0;
		do {
			mostrarTablero(tablero2);
			int fila = pedirFila();
			int columna = obtenerColumna(pedirColumna());
			if(tablero[fila][columna] == BARCO) {
				tablero2[fila][columna] = TOCADO;
				if(comprobarHundido(fila, columna)) {
					System.out.println("Tocado y hundido!");
					hundidos++;
				}
				else
					System.out.println("Tocado!");
			}
			else {
				System.out.println("Agua...");
				tablero2[fila][columna] = AGUA;
				intentos--;
			}
			
			System.out.println("Llevas " + hundidos + " barcos hundidos.");
			System.out.println("Pulse ENTER para continuar...");
			teclado.nextLine();
		}while(intentos > 0 && hundidos < CANTIDAD_BARCOS);
		
		mostrarTablero(tablero2);
		if(intentos <= 0)
			return false;

		return true;
	}
	
	static boolean comprobarHundido(int fila, int columna) {

		//Compruebo dentro de la lista de barcos, si aquel que acabo de tocar, se hunde o no
		for(int i = 0; i < posBarcos.size(); i++) {

			//Se comprueba qué barco se ha tocado
			for(int j = 0; j < posBarcos.elementAt(i).length; j++) {

				//En caso de que haya alguno, se mira si todas las posiciones del barco en el tablero2 están tocadas
				if(posBarcos.elementAt(i)[j][0] == fila && posBarcos.elementAt(i)[j][1] == columna) {
					for(int k = 0; k < posBarcos.elementAt(i).length; k++) {

						//¿Existe alguna posición en el tablero2 que no se haya tocado?
						if(tablero2[posBarcos.elementAt(i)[k][0]][posBarcos.elementAt(i)[k][1]] != TOCADO)
							return false;
					}
				}
			}
		}
		return true;
	}
	
	/** Se colocarán tantos barcos como indique la constante CANTIDAD_BARCOS */
	static void colocarBarcos() {
		for(int i = 0; i < CANTIDAD_BARCOS; i++) {
			System.out.println("\n\tCOORDENADA INFERIOR IZQUIERDA DEL BARCO DE " + (i + 1) + " CASILLAS\n");
			colocarBarco(i);
			mostrarTablero(tablero);
		}
	}
	
	/** Se pedirá una fila ,columna y sentido para un extremo del barco y se colocarán en el tablero, habiendo comprobado antes que son datos posibles*/
	static void colocarBarco(int longBarco) {
		int sentido = pedirSentido();
		int fila, columna;
		boolean noPosible = false;
		do{
			fila = pedirFila();
			columna = obtenerColumna(pedirColumna());
			noPosible = hayObstaculo(fila, columna, sentido, longBarco);
			if(noPosible)
				System.err.println("\nHay un obstáculo en medio o se sale de los límites.\n");
		}while(noPosible);

		//Los barcos se colocarán de abajo a arriba o de izquierda a derecha
		//Además, se guardarán en un array las posiciones de cada uno que luego irán a un vector
		//El array contendrá una columna donde se almacenarán las filas del nuevo barco y otra donde irán las columnas de este también
		//El número de filas de dicho array será la longitud del barco + 1
		int[][] posiciones = new int[longBarco + 1][2];
		for(int i = 0; i <= longBarco; i++) {
			if(sentido == HORIZONTAL) {
				tablero[fila][columna + i] = BARCO;
				posiciones[i][0] = fila;
				posiciones[i][1] = columna + i;
			}
			else {
				tablero[fila - i][columna] = BARCO;
				posiciones[i][0] = fila - i;
				posiciones[i][1] = columna;
			}
		}
		
		posBarcos.add(posiciones);
	}
	
	/** Se comprueba de dos maneras:
	 *  -Horizontal-> En caso de que el barco supere la longitud horizontal del tablero o haya un barco en alguna de sus posiciones, no se podrá hacer el posicionamiento
	 *  -Vertical-> Parecido al anterior, pero en este caso se comprueba la longitud vertical
	 *  */
	static boolean hayObstaculo(int fila, int columna, int direccion, int barco) {
		switch (direccion) {
			case HORIZONTAL:
				if(columna + barco >= tablero[0].length)
					return true;
				else
					for (int i = 0; i <= barco; i++)
						if(tablero[fila][columna + i] == BARCO)		
							return true;
				break;
			case VERTICAL:
				if(fila - barco < 0)
					return true;
				else
					for (int i = 0; i <= barco; i++)
						if(tablero[fila - i][columna] == BARCO)
							return true;
				break;
			default:
				break;
		}
		return false;
	}
	
	static int pedirSentido() {
		int sent;
		do {
			System.out.println("En qué sentido quieres colocar el barco?\n[" + HORIZONTAL + "]-Horizontal\t[" + VERTICAL + "]-Vertical");
			sent = teclado.nextInt();
		}while(sent != HORIZONTAL && sent != VERTICAL);
		return sent;
	}
	
	/** Paso de la letra de la columna a número para su manejo */
	static int obtenerColumna(char col) {
		int colum = 0;
		switch(Character.toUpperCase(col)) {
		case 'A':
			break;
		case 'B':
			colum = 1;
			break;
		case 'C':
			colum = 2;
			break;
		case 'D':
			colum = 3;
			break;
		case 'E':
			colum = 4;
			break;
		case 'F':
			colum = 5;
			break;
		case 'G':
			colum = 6;
			break;
		case 'H':
			colum = 7;
			break;
		}
		return colum;
	}
	
	/** Se muestra el tablero de una manera amigable para el usuario */
	static void mostrarTablero(char[][] tab) {
		limpiarPantalla();
		System.out.println("\t\t\tTABLERO");
		System.out.println("\t\t\t-------");
		
		//Identificador para las columnas
		System.out.print("\t\t  ");
		char primeraLetra = 'A';
		for (int i = 0; i < tab[0].length; i++)
			System.out.print((char)(primeraLetra + i) + "  ");
		System.out.println();
		
		for (int i = 0; i < tab.length; i++) {
			//Identificador para las filas
			System.out.print("\t\t" + (i + 1));
			for (int j = 0; j < tab[i].length; j++) {
				System.out.print(ESTILO_TABLERO_IZQ + "" + tab[i][j] + "" + ESTILO_TABLERO_DRCH);
			}
			System.out.println();
		}
	}
	
	/** Columna comprendida entre A y H que luego se usará como número */
	static char pedirColumna() {
		char col;
		do {
			System.out.print("Dime una columna (A-H):\n>");
			col = teclado.next().charAt(0);			
		}while(Character.toUpperCase(col) < 'A' && Character.toUpperCase(col) > 'H');
		return col;
	}
	
	/** Fila comprendida entre 1 y 8 */
	static int pedirFila() {
		String filaStr;
		int fila = 1;
		boolean correcto = true;
		do {
			correcto = true;
			System.out.print("Dime una fila (1-8):\n>");
			filaStr = teclado.next();
			for(int i = 0; i < filaStr.length() && correcto; i++) {
				if(!Character.isDigit(filaStr.charAt(i)))
					correcto = false;
			}
			
			if(correcto)
				fila = Integer.parseInt(filaStr);
		}while(!correcto || (fila < 1 || fila > 8));
		return fila - 1;
	}
	
	/** Limpieza de pantalla */
	static void limpiarPantalla() {
		System.out.println("Pulse ENTER para continuar...");
		teclado.nextLine();
		for (int i = 0; i < 25; i++)
			System.out.println();
	}
}
