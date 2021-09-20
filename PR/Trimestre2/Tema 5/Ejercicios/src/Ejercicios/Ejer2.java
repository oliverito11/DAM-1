package Ejercicios;

import java.util.Scanner;

class Ejer2{
	static final int FEBRERO = 1;
	public static void main(String[] args){
		int[][] anyo = new int[12][2];
		rellenarAnyo(anyo);
		mostrarAnyo(anyo);
	}
	
	static void rellenarAnyo(int[][] anyo){
		Scanner teclado = new Scanner(System.in);
		for (int i = 0; i < anyo.length; i++)
		{
			anyo[i][0] = i + 1;
			System.out.println("Dias del mes " + anyo[i][0]);
			anyo[i][1] = teclado.nextInt();
		}
		teclado.close();
	}
	
	static void mostrarAnyo(int[][] anyo){
		for (int i = 0; i < anyo.length; i++)
			System.out.println("Mes " + anyo[i][0] + " tiene " + anyo[i][1] + " dias");		
	}
}
