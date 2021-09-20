package Ejercicios;

//import java.util.Scanner;
public class Ejer17 {

	public static void main(String[] args){
		if(args.length != 1) {
			System.err.println("Uso correcto: java Ejer17 \"<frase>\"");
			return;
		}
		
		estadistica(args[0].toLowerCase());
	}
	
	/** Se usará una String como estructura de datos dinámica y se comprobará qué letras se han visto ya */
	static void estadistica(String txt){
		String vistas = "";
		for (int i = 0; i < txt.length(); i++) {
			char letra = txt.charAt(i);
			if(!letraVista(letra, vistas)){
				vistas += letra;
				int count = repeticiones(letra, txt, i);
				System.out.println("Letra <" + letra + ">: " + count);
			}
		}
	}
	
	/** Se comprueba si la letra ya se ha visto o no */
	static boolean letraVista(char letra, String cadena) {
		for(int i = 0; i < cadena.length(); i++){
			if(cadena.charAt(i) == letra)
				return true;
		}
		return false;
	}
	
	/** Se comprueba las repeticiones de la letra en el texto */
	static int repeticiones(char letra, String txt, int inicio) {
		int count = 0;
		for(int j = inicio; j < txt.length(); j++){
			if(letra == txt.charAt(j))
				count++;
		}
		return count;
	}
}
