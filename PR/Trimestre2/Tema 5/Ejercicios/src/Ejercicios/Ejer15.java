package Ejercicios;

import java.util.Scanner;
public class Ejer15 {
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dime una cadena de texto:\n>");
		String txt = teclado.nextLine();
		teclado.close();
		
		separarString(txt);
	}
	
	/** Se hace uso de split para separar cada palabra con cada espacio */
	static void separarString(String s){
		String[] palabras = s.split("[ ]");
		for(int i = 0; i < palabras.length; i++){
			palabras[i] = limpia(palabras[i]);
			System.out.println(palabras[i]);
		}
	}
	
	static String limpia(String palabra) {
		StringBuffer devolver = new StringBuffer(palabra);
		for (int i = 0; i < devolver.length(); i++) {
			if(!Character.isLetter(devolver.charAt(i)))
				devolver.deleteCharAt(i);
		}
		return devolver.toString();
	}
}
