package Ejercicios;

import java.util.Scanner;

class Ejer6{
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args){
		System.out.print("Dime las filas de la matriz\n>");
		int num_filas = teclado.nextInt();
		
		System.out.print("Dime las columnas de la matriz\n>");
		int num_cols = teclado.nextInt();
		teclado.close();
		
		int[][] tabla = new int[num_filas][num_cols];
		
		limpiarPantalla();
		
		rellenarTabla(tabla);
		System.out.println("La suma de todos los valores de la tabla es: " + sumarTabla(tabla));
	}
	
	static void rellenarTabla(int[][] tabla){
		for (int i = 0; i < tabla.length; i++)
		{
			for (int j = 0; j < tabla[i].length; j++)
			{
				System.out.print("Valor en posicion " + i + " | " + j + "\n>");
				tabla[i][j] = teclado.nextInt();
			}
		}
	}
	
	static int sumarTabla(int[][] tabla){
		int suma = 0;
		for (int i = 0; i < tabla.length; i++)
		{
			for (int j = 0; j < tabla[i].length; j++)
			{
				suma += tabla[i][j];
			}
		}
		return suma;
	}
	
	static void limpiarPantalla(){
		for (int i = 0; i < 30; i++)
		{
			System.out.println();
		}
		
	}
}
