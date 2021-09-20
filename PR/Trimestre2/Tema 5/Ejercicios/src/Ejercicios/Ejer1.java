package Ejercicios;

import java.util.Scanner;

class Ejer1{
	static final int FEBRERO = 1;
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args){
		int[] meses = new int[12];
		int[] dias = new int[12];
		rellenarMeses(meses);
		rellenarDias(dias);
		teclado.close();

		System.out.println("\t\tMESES");
		System.out.println("\t\t=====");
		mostrarMeses(meses);
		
		System.out.println("\n\t\tDIAS");
		System.out.println("\t\t====");
		mostrarDias(dias);
	}

	static void rellenarMeses(int[] mes){
		for (int i = 0; i < mes.length; i++)
			mes[i] = i + 1;
	}
	
	static void rellenarDias(int[] dias){
		for (int i = 0; i < dias.length; i++)
		{
			System.out.println("Dias del mes" + (i + 1));
			dias[i] = teclado.nextInt();
		}
		
	}
	
	static void mostrarMeses(int[] meses){
		for (int i = 0; i < meses.length; i++)
			System.out.print(meses[i] + " ");
	}
	
	static void mostrarDias(int[] dias){
		for (int i = 0; i < dias.length; i++)
			System.out.print(dias[i] + " ");
	}
}
