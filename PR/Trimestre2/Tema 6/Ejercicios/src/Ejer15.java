/**
 * Programa que recibe 2 argumentos, uno el fichero de origen y otro el
 * fichero de destino. Se le pedirá al usuario la clave de cifrado que se
 * usará para dar lugar al fichero resultante. 
 * El programa debe ser capaz de cifrar y descifrar un fichero 
 * con la misma clave.
 * Se usará la operación XOR para dicho cifrado.
 * */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
public class Ejer15 {
	static final int SI = 1;
	static final int NO = 2;
	static final int MIN = 0;
	static final int MAX = 127;
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		if(args.length != 2) {
			System.err.println("Uso correcto del programa: java Ejer15 <fichero_origen> <fichero_destino>");
			return;
		}
		
		File fichO = new File(args[0]);
		File fichD = new File(args[1]);
		
		if(!comprobarFicheros(fichO, fichD))
			System.err.println("No se ha podido completar el programa.");
		else if(!cifrar(fichO, fichD, pedirClave()))
			System.err.println("No se ha podido completar el programa.");
		else
			System.out.println("Cifrado completado.");
		teclado.close();
	}
	
	static boolean cifrar(File fichO, File fichD, int clave) {
		BufferedReader br = null;
		PrintWriter pw = null;
		boolean resultado = true;
		
		try {
			br = new BufferedReader(new FileReader(fichO));
			pw = new PrintWriter(new FileWriter(fichD));
			
			int car;
			while((car = br.read()) != -1) {				
				pw.append((char)(car ^ clave));
			}
		}catch(IOException e) {
			System.err.println("Hubo un error de E/S.");
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
			int opc = teclado.nextInt();
			
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
	
	static int pedirClave() {
		int clave = 0;
		do {
			System.out.print("Dame la clave con la que quieres cifrar o descifrar el fichero (0 - 127):\n>");
			clave = teclado.nextInt();
		}while(clave < MIN || clave > MAX);
		return clave;
	}
}
