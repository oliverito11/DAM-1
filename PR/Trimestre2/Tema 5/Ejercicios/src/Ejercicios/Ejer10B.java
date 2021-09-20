package Ejercicios;

import java.util.Scanner;
public class Ejer10B {
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dime una cadena de texto: \n>");
		StringBuffer sb = new StringBuffer(teclado.nextLine());
		teclado.close();
		
		System.out.println("\nLa frase invertida es " + sb.reverse());
	}
}
