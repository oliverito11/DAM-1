/**
 * Programa que recibe 2 argumentos, un fichero de texto origen y un fichero de destino
 * que contendrá el mismo contenido que el primero pero con las líneas
 * enumeradas con el formato #numero#.
 * */
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Ejer14 {
	static final int SI = 1;
	static final int NO = 0;
	public static void main(String[] args) {
		if(args.length != 2) {
			System.err.println("Uso correcto del progama: java Ejer14 <fichero_origen> <fichero_destino>");
			return;
		}
		File fichO = new File (args[0]);
		File fichD = new File (args[1]);
		
		if(!comprobarFicheros(fichO, fichD)) {
			System.err.println("Ha habido un problema con la ejecución del programa.");
		}else if(copiarFichero(fichO, fichD))
			System.out.println("Finalización correcta del programa.");
	}
	
	static boolean comprobarFicheros(File fichO, File fichD) {
		boolean resultado = true;
		if(!fichO.exists() || fichO.isDirectory()) {
			System.err.println("El fichero <" + fichO + "> no existe o es un directorio.");
			resultado = false;
		}else if(fichD.isDirectory()) {
			System.err.println("El fichero <" + fichD + "> es un directorio.");
			resultado = false;
		}else if(fichD.getName().equals(fichO.getName())) {
			System.err.println("Ambos ficheros no pueden tener el mismo nombre.");
			resultado = false;
		}else if(fichD.exists()) {
			System.out.print("El fichero <" + fichD + "> ya existe. ¿Quiere continuar igualmente?.\n[" + SI + "] - Sí\n[" + NO + "] - No\n>");
			Scanner teclado = new Scanner(System.in);
			int opc = teclado.nextInt();
			teclado.close();
			
			if(opc == SI) {
				if(!fichD.delete()) {
					System.err.println("Ha habido un problema al borrar el fichero.");
					resultado = false;
				}
			}else
				resultado = false;
		}
		
		return resultado;
	}
	
	static boolean copiarFichero(File fichO, File fichD) {
		BufferedReader br = null;
		PrintWriter pw = null;
		boolean resultado = true;
		try {
			br = new BufferedReader(new FileReader(fichO));
			pw = new PrintWriter(new FileWriter(fichD));
			
			String linea = "";
			int i = 1;
			boolean primera = true;
			while((linea = br.readLine()) != null) {
				if(!primera)
					pw.println();
				
				pw.print("#" + i + "# " + linea);
				primera = false;
				i++;
			}
		}catch(IOException e) {
			System.err.println("Error de E/S.");
			resultado = false;
		}finally {
			try {
				if(pw != null)
					pw.close();
				if(br != null)
					br.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el archivo.");
				resultado = false;
			}
		}
		return resultado;
	}
}
