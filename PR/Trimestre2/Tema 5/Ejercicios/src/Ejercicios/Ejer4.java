package Ejercicios;

import java.util.Scanner;
class Ejer4{
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args){
		int[] numeros;
		System.out.print("Dime cuantos numeros quieres introducir:\n>");
		numeros = new int[teclado.nextInt()];
		
		rellenarNumeros(numeros);
		mayorNum(numeros);
	}
	
	static void rellenarNumeros(int[] nums){
		for (int i = 0; i < nums.length; i++)
		{
			System.out.print("Valor del numero " + (i + 1) + "\n>");
			nums[i] = teclado.nextInt();
		}
		teclado.close();
	}
	
	static void mayorNum(int[] nums){
		int mayor = 0;
		for (int i = 1; i < nums.length; i++)
		{
			if (nums[i] >= nums[mayor]){
				mayor = i;
			}
		}
		System.out.println("El mayor numero es " + nums[mayor] + " en la posicion " + mayor);
	}
}
