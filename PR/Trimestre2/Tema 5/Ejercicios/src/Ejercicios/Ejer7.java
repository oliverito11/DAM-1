package Ejercicios;

import java.util.Scanner;

class Ejer7{
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args){
		System.out.print("Dime las filas de la primera matriz\n>");
		int n = teclado.nextInt();
		
		System.out.print("\nDime las columnas de la primera matriz\n>");
		int m = teclado.nextInt();
		
		System.out.print("\nDime las filas de la segunda matriz\n>");
		int o = teclado.nextInt();
		
		System.out.print("\nDime las columnas de la segunda matriz\n>");
		int p = teclado.nextInt();
		
		teclado.close();
		
		limpiarPantalla();
		
		int[][] nm = new int[n][m];
		int[][] op = new int[o][p];
		
		if (comprobarMatrices(nm, op)) {
			rellenarMatriz(nm);
			limpiarPantalla();
			rellenarMatriz(op);
			limpiarPantalla();
			productoMatrices(nm, op);
		}
		else
			System.out.println("No se puede realizar el producto de dichas matrices");
	}
	
	/** Se comprobará que las columnas de la primera matriz equivalen a las filas de la segunda para poder realizar el producto de estas */
	static boolean comprobarMatrices(int[][] a, int[][] b){
		if(a[0].length == b.length)
			return true;
		
		return false;
	}
	
	/** Se irá pidiendo al usuario que introduzca valores para cada posición de la matriz */
	static void rellenarMatriz(int[][] matriz){
		for (int i = 0; i < matriz.length; i++){
			for (int j = 0; j < matriz[i].length; j++){
				System.out.print("Valor para la posicion " + i + " | " + j + "\n>");
				matriz[i][j] = teclado.nextInt();
			}
			
			//Paso al siguiente nivel
			System.out.println();
		}
		
	}
	
	/** Método que irá rellenando los valores de cada posición de la matriz de resultado */
	static void productoMatrices(int[][] a, int[][] b){
		int[][] resultado = new int[a.length][b[0].length];
		
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[0].length; j++) {
				resultado[i][j] = sumaMatriz(i, j, a, b);
			}
		}
		
		System.out.println("La matriz resultante es:");
		mostrarResultado(resultado);
	}
	
	/** Se realiza el producto de ambas matrices */
	static int sumaMatriz(int fila, int col, int[][] a, int[][] b){
		int suma = 0;
		for (int i = 0; i < a[0].length; i++)
			suma += a[fila][i] * b[i][col];
		
		return suma;
	}
	
	/** Se mostrará la matriz en forma de tabla */
	static void mostrarResultado(int[][] r) {
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r[0].length; j++) {
				System.out.print(r[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/** Espacios para hacer efecto de limpiar pantalla */
	static void limpiarPantalla(){
		for (int i = 0; i < 40; i++)
			System.out.println();
	}
}
