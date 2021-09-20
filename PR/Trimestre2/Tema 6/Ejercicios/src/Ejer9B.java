/**
 * Versión alterna del ejercicio 9 en el que en este caso se usa
 * otro método distinto para buscar las palabras mediante
 * el uso de la clase StringTokenizer.
 * */
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ejer9B {
	static final int ERROR = -1;
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String ruta;
		File fichero;
		do {
			System.out.println("Dame el nombre de un fichero");
			ruta = teclado.nextLine();
			fichero = new File(ruta);
		}while(!comprobarFichero(fichero));
		
		System.out.println("El fichero contiene " + contarPalabras(fichero) + " palabras.");
		
		teclado.close();
	}
	
	static boolean comprobarFichero(File fich) {
		if(!fich.exists() || !fich.isFile()) {
			System.err.println("El fichero <" + fich + "> no existe o es un directorio");
			return false;
		}
		
		return true;
	}
	
	static int contarPalabras(File fich) {
		BufferedReader br = null;
		int palabras = 0;
		try {
			br = new BufferedReader(new FileReader(fich));
			String linea = "";
			while((linea = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(linea, " ");
				while(st.hasMoreElements()) {
					palabras++;
					st.nextToken();
				}
			}
		}catch(IOException e) {
			System.err.println("Se ha producido un error de lectura");
			palabras = ERROR;
		}finally {
			try {
				if(br != null)
					br.close();
			}catch(IOException e) {
				System.err.println("Se ha producido un error al intentar cerrar el fichero");
				palabras = ERROR;
			}
		}
		return palabras; 
	}
}
