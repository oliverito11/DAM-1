/**
 * Versión alterna del ejercicio anterior, solo que en este caso en vez
 * de escribir un único carácter, se hará con una cadena de texto.
 * */
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Ejer6 {
	static final int ESCRIBIR_CAD= 1;
	static final int LEER_CAD = 2;
	static final int SALIR = 3;
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int opc = 0;
		do {
			System.out.println("\t\t--FICHEROS--");
			System.out.println(ESCRIBIR_CAD + " - Escribir una cadena de caracteres en un fichero.");
			System.out.println(LEER_CAD + " - Leer una cadena de caracteres en un fichero.");
			System.out.println(SALIR + " - Salir.");
			System.out.print("\n>");
			opc = pedirValor();
			teclado.nextLine();
			seleccionMenu(opc);
		}while(opc != SALIR);
		teclado.close();
	}
	
	/** Pido la opción a elegir del menú */
	static int pedirValor() {
		int opc = 0;
		try {
			opc = teclado.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Se esperaba un entero");
		}
		
		return opc;
	}
	
	/** Compruebo cual ha sido la opción elegida */
	static void seleccionMenu(int opc) {
		switch(opc) {
		case ESCRIBIR_CAD:
			escribirCad();
			break;
		case LEER_CAD:
			leerCad();
			break;
		case SALIR:
			System.out.println("Fin del programa.");
			break;
		}
	}
	
	/** Se pedirá al usuario el fichero en el que quiere escribir y el texto */
	static void escribirCad() {
		File fichero = pedirFichero();
		if(!fichero.canWrite())
			System.err.println("No tienes permisos de escritura en el fichero");
		else {			
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(new FileWriter(fichero));
				System.out.println("Dime el texto que quieres escribir en el fichero");
				String c = teclado.nextLine();
				pw.println(c);
			}catch(IOException e) {
				System.err.println("Error de escritura");
			}finally {
				pw.close();
			}
		}
	}
	
	/** Se pedirá al usuario el fichero a visualizar */
	static void leerCad() {
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
	
	/** Se pide al usuario la ruta del fichero, comprobando que existe y que no es un directorio */
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
