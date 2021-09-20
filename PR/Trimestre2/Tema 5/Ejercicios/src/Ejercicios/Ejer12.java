package Ejercicios;

import java.util.Scanner;
public class Ejer12 {
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dime una cadena de texto: \n>");
		StringBuffer txt = new StringBuffer(teclado.nextLine());
		teclado.close();
		
		invierte(txt);
		System.out.println("La frase resultante es: \n->" + txt);
	}
	
	static void invierte(StringBuffer txt){
		for (int i = 0; i < txt.length(); i++) {
			char c = txt.charAt(i);
			if(c >= '0' && c <= '9')
				txt.setCharAt(i, '.');
			else if(Character.isUpperCase(c))
				txt.setCharAt(i, Character.toLowerCase(c));
			else if(Character.isLowerCase(c))
				txt.setCharAt(i, Character.toUpperCase(c));
		}
	}
}
