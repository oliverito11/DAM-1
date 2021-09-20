package Ejercicios;

import java.util.Scanner;

public class Ejer9 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame una cadena de texto: \n>");
		String txt = teclado.nextLine();
		teclado.close();
		
		System.out.println("\n");
		mostrarCaracteres(txt);
	}
	
	static void mostrarCaracteres(String txt){
		for (int i = 0; i < txt.length(); i++) {
			System.out.print(txt.charAt(i) + " ");
		}
	}
}
