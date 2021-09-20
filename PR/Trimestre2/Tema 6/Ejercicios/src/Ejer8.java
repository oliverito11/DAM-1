/**
 * Método que recibe un carácter y un fichero y muestra aquellas 
 * líneas dentro del fichero que contengan dicho carácter.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;

public class Ejer8 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Dame un carácter: ");
		char c = teclado.nextLine().charAt(0);
		File fichero;
		
		do {
			System.out.println("Dame el nombre de un fichero: ");
			String ruta = teclado.nextLine();
			fichero = new File(ruta);
		}while(!comprobarFichero(fichero));
		
		buscarCaracter(c, fichero);
		teclado.close();
	}
	
	/** Se comprueba que el fichero exista y no sea un directorio */
	static boolean comprobarFichero(File fich) {
		if(!fich.exists() || !fich.isFile()) {
			System.err.println("El fichero <" + fich + "> no existe o no es un fichero.");
			return false;
		}
		return true;
	}
	
	/** Se busca línea por línea, si hay un carácter o no */
	static void buscarCaracter(char c, File fich) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fich));
			
			String linea = "";
			while((linea = br.readLine()) != null) {
				for(int i = 0; i < linea.length(); i++) {
					if(linea.toLowerCase().charAt(i) == c) {
						System.out.println(linea);
						break;
					}
				}
			}
		}catch(IOException e) {
			System.err.println("Se ha producido un error de lectura.");
		}finally {
			try {
				if(br != null)
					br.close();
			}catch(IOException e) {
				System.err.println("Se ha producido un error al cerrar el archivo.");
			}
		}
	}
}
