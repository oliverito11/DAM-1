package Ejercicios;

public class Ejer11 {
	public static void main(String[] args){
		if(args.length != 1) {
			System.err.println("Uso correcto: java Ejer11 \"<frase>\"");
			return;
		}
		
		System.out.println("\n");
		mostrarCadenaMayus(args[0]);
		System.out.println("\n");
		mostrarCadenaMinus(args[0]);
	}
	
	static void mostrarCadenaMayus(String txt){
		System.out.println(txt.toUpperCase());
	}
	
	static void mostrarCadenaMinus(String txt){
		System.out.println(txt.toLowerCase());
	}
}
