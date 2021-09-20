package Ejercicios;

import java.util.StringTokenizer;

//import java.util.Scanner;
public class Ejer22C {
	
	static final int OCTETOS = 4;
	public static void main(String[] args) {
		/*Scanner teclado = new Scanner(System.in);
		System.out.print("Dime una direccion IP:\n>");
		String ip = teclado.nextLine();
		teclado.close();*/
		
		if(args.length != 1) {
			System.err.println("Uso correcto: java Ejer22C <IP>");
			return;
		}
		
		if(comprobarIp(args[0]))
			System.out.println("Direccion IP correcta.");
		else
			System.err.println("Direccion IP invalida.");
	}
	
	/** Una IP tiene que tener 4 partes, cada una con numeros desde el 0 hasta el 255 */
	static boolean comprobarIp(String ip) {
		StringTokenizer st = new StringTokenizer(ip, ".");

		//Se compruba su longitud
		if(st.countTokens() != 4) {
			System.err.println("Faltan octetos");
			return false;
		}
		
		//Se comprueba si es un número y si está comprendido entre 0 y 255;
		try {
			while(st.hasMoreTokens()) {
				int octeto = Integer.parseInt(st.nextToken());
				if(octeto < 0 || octeto > 255) {
					System.err.println("Alguno de los octetos no tiene un número comprendido entre 0 o 255");
					return false;
				}
			}			
		}catch(NumberFormatException e) {
			System.err.println("Alguno de los octetos no es un entero");
			return false;
		}
		
		return true;
	}
}
