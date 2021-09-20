package Ejercicios;

import java.util.Scanner;
public class Ejer13 {
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dime una cadena de texto:\n>");
		String txt = teclado.nextLine();
		teclado.close();
		
		if(comprobarPalin(txt))
			System.out.println("El texto es palindromo");
		else
			System.out.println("El texto NO es palindromo");
	}
	
	static boolean comprobarPalin(String txt){
		String limpia = "";
		
		for(int i = 0; i < txt.length(); i++)
			if((txt.charAt(i) >= 'A' && txt.charAt(i) <= 'Z') || (txt.charAt(i) >= 'a' && txt.charAt(i) <= 'z'))
				limpia += txt.charAt(i);
		
		limpia = limpia.toUpperCase();
		for(int i = 0, j = limpia.length() - 1; i <= j; i++, j--)
			if(limpia.charAt(i) != limpia.charAt(j))
				return false;
		
		return true;
	}
}
