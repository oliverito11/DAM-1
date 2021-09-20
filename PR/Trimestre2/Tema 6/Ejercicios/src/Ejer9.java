/**
 * Programa que cuenta las palabras contenidas en un fichero pasado
 * por el usuario.
 * */
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Ejer9 {
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
				for(int i = 0; i < linea.length(); i++) {
					if(linea.charAt(i) == ' ' || i == linea.length() - 1) {
						palabras++;
					}
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
