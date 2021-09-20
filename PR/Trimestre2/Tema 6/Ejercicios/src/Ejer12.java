/**
 * Juego de adivinanza con la obtención de palabras aleatorias 
 * a partir de un fichero pasado por el usuario.
 * */
import java.util.Scanner;
import java.util.Random;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class Ejer12 {
	static Scanner teclado = new Scanner(System.in);
	static final String ERROR = "";
	public static void main(String[] args) {
		if(args.length != 1) {
			System.err.println("Uso correcto del programa: java Ejer12 <fichero>");
			return;
		}
		String palabra = obtenerPalabra(args[0]);
		StringBuffer adivinar = new StringBuffer(palabra);
		
		for (int i = 0; i < adivinar.length(); i++)
			adivinar.setCharAt(i, '_');
		
		if(juego(palabra, adivinar))
			System.out.println("\nHas ganado, enhorabuena!");
		else
			System.out.println("\nLo lamento, has perdido... La palabra era: " + palabra);
	}
	
	/** Método principal donde se desarrollará el juego */
	static boolean juego(String palabra, StringBuffer adivinar) {
		int intentos = 10;
		boolean victoria = false;
		mostrarPalabra(adivinar);
		
		do {
			System.out.println("\nTe quedan " + intentos + " intentos.");
			char c = pedirCaracter();
			int posIni = 0, index = palabra.indexOf(c, posIni);
			while(index != -1) {
				adivinar.setCharAt(index, c);
				posIni = index + 1;
				index = palabra.indexOf(c, posIni);
			}
			
			victoria = comprobarVictoria(palabra, adivinar);
			intentos--;
			
			limpiarPantalla();
			mostrarPalabra(adivinar);
		}while(intentos > 0 && !victoria);
		
		if(intentos <= 0) {
			System.out.println("\nTe has quedado sin intentos... Puedes adivinar la palabra?");
			String ultOport = teclado.nextLine();
			
			if(ultOport.equals(palabra))
				victoria = true;
		}
		
		teclado.close();
		return victoria;
	}
	
	/** Se comprueba si el primer texto es igual al segundo */
	static boolean comprobarVictoria(String txt1, StringBuffer txt2){
		if(txt1.equals(txt2.toString()))
			return true;
		
		return false;
	}
	
	/** Se muestra la palabra caracter por caracter */
	static void mostrarPalabra(StringBuffer txt) {
		for (int i = 0; i < txt.length(); i++) {
			System.out.print(txt.charAt(i) + "\t");
		}
		System.out.println();
	}
	
	/** Se obtendrá una palabra aleatoria dentro del rango de un array de Strings obtenidas a partir del fichero pasado por el usuario */
	static String obtenerPalabra(String ruta) {
		BufferedReader br = null;
		String resultado;
		File ficheroPalabras = comprobarFichero(ruta);
		if(ficheroPalabras == null)
			resultado = ERROR;
		else {
			try {
				br = new BufferedReader(new FileReader(ficheroPalabras));
				Vector<String> palabras = new Vector<String>();
				
				String linea = "";
				while((linea = br.readLine()) != null)
					palabras.add(linea);
				
				Random r = new Random();
				resultado = palabras.elementAt(r.nextInt(palabras.size()));
			}catch(IOException e) {
				System.err.println("Error al leer el fichero");
				resultado = ERROR;
			}finally {
				try {
					if(br != null)
						br.close();
				}catch(IOException e) {
					System.err.println("Error al cerrar el fichero");
					resultado = ERROR;
				}
			}			
		}
		
		return resultado;
	}

	/** Se comprueba que el fichero exista o no sea un directorio */
	static File comprobarFichero(String ruta) {
		File fichero = new File(ruta);
		if(!fichero.exists() || fichero.isDirectory()) {
			System.err.println("EL fichero <" + fichero+ " no existe o es un directorio.");
			fichero = null;
		}
		return fichero;
	}
		
	
	/** Se pide un char al usuario */
	static char pedirCaracter() {
		System.out.println("¿Qué carácter crees que hay?");
		return teclado.nextLine().charAt(0);
	}
	
	/** Método para hacer una limpieza de la pantalla */
	static void limpiarPantalla() {
		for (int i = 0; i < 25; i++)
			System.out.println();
	}
}
