package Ejercicios;

import java.util.Scanner;
import java.util.Random;

public class Ejer27 {
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		String palabra = obtenerPalabra();
		StringBuffer adivinar = new StringBuffer(palabra);
		
		for (int i = 0; i < adivinar.length(); i++)
			adivinar.setCharAt(i, '_');
		
		if(juego(palabra, adivinar))
			System.out.println("\nHas ganado, enhorabuena!");
		else
			System.out.println("\nLo lamento, has perdido...");
	}
	
	/** Método principal donde se desarrollará el juego */
	static boolean juego(String palabra, StringBuffer adivinar) {
		int intentos = 10;
		boolean victoria = false;
		mostrarPalabra(adivinar);
		
		do {
			char c = pedirCaracter();
			for (int i = 0; i < palabra.length(); i++)
				if(c == palabra.charAt(i))
					adivinar.setCharAt(i, c);
			
			victoria = comprobarVictoria(palabra, adivinar);
			intentos--;
			
			limpiarPantalla();
			mostrarPalabra(adivinar);
		}while(intentos > 0 && !victoria);
		
		if(intentos <= 0) {
			System.out.println("\nTe has quedado sin intentos... Puedes adivinar la palabra?");
			String ultOport = teclado.nextLine();
			
			if(ultOport.equals(palabra))
				victoria = true;
		}
		
		teclado.close();
		return victoria;
	}
	
	/** Se comprueba si el primer texto es igual al segundo */
	static boolean comprobarVictoria(String txt1, StringBuffer txt2){
		if(txt1.equals(txt2.toString()))
			return true;
		
		return false;
	}
	
	/** Se muestra la palabra caracter por caracter */
	static void mostrarPalabra(StringBuffer txt) {
		for (int i = 0; i < txt.length(); i++) {
			System.out.print(txt.charAt(i) + "\t");
		}
	}
	
	/** Se obtendrá una palabra aleatoria dentro del rango de un array de Strings */
	static String obtenerPalabra() {
		String[] palabras = {
				"manzana", "pera", "granada",
				"kiwi", "mandarina", "naranja",
				"moto", "mar", "coche", "casa"
		};
		
		Random r = new Random();	
		return palabras[r.nextInt(palabras.length)];
	}
	
	/** Se pide un char al usuario */
	static char pedirCaracter() {
		System.out.println("\nQue caracter crees que hay?");
		return teclado.nextLine().charAt(0);		
	}
	
	/** Método para hacer una limpieza de la pantalla */
	static void limpiarPantalla() {
		for (int i = 0; i < 25; i++)
			System.out.println();
	}
}
