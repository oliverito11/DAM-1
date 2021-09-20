package Ejercicios;

import java.util.Scanner;

class Ejer5{
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args){
		int[] numeros;
		System.out.print("Dime cuantos numeros quieres introducir:\n>");
		numeros = new int[teclado.nextInt()];
		
		rellenarNumeros(numeros);
		mediaNumeros(numeros);
	}
	
	static void rellenarNumeros(int[] nums){
		for (int i = 0; i < nums.length; i++)
		{
			System.out.print("Valor del numero " + (i + 1) + "\n>");
			nums[i] = teclado.nextInt();
		}
		teclado.close();
	}
	
	static void mediaNumeros(int[] nums){
		int suma = 0;
		for (int i = 1; i < nums.length; i += 2)
				suma += nums[i];
		
		System.out.println("La media de todos las posiciones pares es " + ((float)suma / nums.length));
	}
}
