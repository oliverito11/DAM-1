/**
 * Programa que le ofrece al usuario un menú con el que podrá escribir
 * un carácter en un fichero que se le pedirá su ruta.
 * */
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Ejer5 {
	static final int ESCRIBIR_CHAR= 1;
	static final int LEER_CHAR = 2;
	static final int SALIR = 3;
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int opc = 0;
		do {
			System.out.println("\t\t--FICHEROS--");
			System.out.println(ESCRIBIR_CHAR + " - Escribir una cadena de caracteres en un fichero.");
			System.out.println(LEER_CHAR + " - Leer una cadena de caracteres en un fichero.");
			System.out.println(SALIR + " - Salir.");
			System.out.print("\n>");
			opc = pedirValor();
			teclado.nextLine();
			seleccionMenu(opc);
		}while(opc != SALIR);
		teclado.close();
	}
	
	static int pedirValor() {
		int opc = 0;
		try {
			opc = teclado.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Se esperaba un entero");
		}
		
		return opc;
	}
	
	static void seleccionMenu(int opc) {
		switch(opc) {
		case ESCRIBIR_CHAR:
			escribirChar();
			break;
		case LEER_CHAR:
			leerChar();
			break;
		case SALIR:
			System.out.println("Fin del programa.");
			break;
		}
	}
	
	static void escribirChar() {
		File fichero = pedirFichero();
		if(!fichero.canWrite())
			System.err.println("No tienes permisos de escritura en el fichero");
		else {			
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(new FileWriter(fichero));
				System.out.println("Dime el caracter que quieres escribir en el fichero");
				char c = (char)System.in.read();
				pw.println(c);
				System.out.println();
				teclado.nextLine();
			}catch(IOException e) {
				System.err.println("Error de escritura");
			}finally {
				pw.close();
			}
		}
	}
	
	static void leerChar() {
		File fichero = pedirFichero();
		if(!fichero.canRead())
			System.err.println("No tienes permisos de lectura en el fichero");
		else {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(fichero));
				String linea = "";
				while((linea = br.readLine()) != null)
					System.out.println(linea);
			}catch(IOException e) {
				System.err.println("Error de escritura");
			}finally {
				try {
					br.close();
				} catch (IOException e) {
					System.err.println("Error al cerrar el archivo");
				}
			}
		}
	}
	
	static File pedirFichero() {
		String fichero = ".";
		File fich;
		do {
			System.out.println("¿Cuál es la ruta del fichero que deseas manipular?");
			fichero = teclado.nextLine();
			fich = new File(fichero);

			if(!fich.exists() || fich.isDirectory())
				System.err.println("El fichero en la ruta <" + fich.getName() + "> no existe o es un directorio");
		}while(!fich.exists() || fich.isDirectory());
		return fich;
	}
}
