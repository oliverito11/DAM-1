package Ejercicios;

import java.util.Scanner;
public class Ejer10 {
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dime una cadena de texto: \n>");
		String txt = teclado.nextLine();
		teclado.close();
		
		System.out.println("\n");
		invertirString(txt);
	}
	
	static void invertirString(String txt){
		String txt2 = txt;
		for (int i = 0; i < txt.length(); i++)
			txt += txt2.charAt(i);
	}
}
