/**
 * Programa que recibe una palabra como argumento y busca el número de
 * concurrencias de esta dentro de un fichero también pasado como argumento.
 * */
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;

public class Ejer10 {
	static final int ERROR = -1;
	public static void main(String[] args) {
		if(args.length != 2) {
			System.err.println("Uso correcto del programa: java Ejer10 <palabra> <fichero>");
			return;
		}
		
		String ruta = args[1];
		String palabra = args[0];
		File fichero = new File(ruta);
		
		if(!fichero.exists() || !fichero.isFile()) {
			System.err.println("El fichero <" + fichero + "> no existe o no es un fichero");
			return;
		}
		int ocurrencias = 0;
		if((ocurrencias = buscarPalabras(palabra, fichero)) == ERROR) {
			System.err.println("No se ha podido completar la operación");
		}else {
			System.out.println("Dicho fichero contiene " + ocurrencias + " ocurrencias de la palabra <" + palabra +">");
		}
	}
	
	static int buscarPalabras(String palabra, File fichero) {
		BufferedReader br = null;
		int resultado = 0;
		try {
			br = new BufferedReader(new FileReader(fichero));
			String linea = "";
			int posicion = 0;
			while((linea = br.readLine()) != null) {
				posicion = linea.toLowerCase().indexOf(palabra);
				while(posicion != -1) {
					resultado++;
					posicion = linea.toLowerCase().indexOf(palabra, posicion + 1);
				}
			}
		}catch(IOException e) {
			System.err.println("Se ha producido un error de lectura. " + e.getMessage());
			resultado = ERROR;
		}finally {
			try {
				if(br != null)
					br.close();
			}catch (IOException e) {
				System.err.println("Se ha producido un error al cerrar el archivo. " + e.getMessage());
				resultado = ERROR;
			}
		}
		return resultado;
	}
}
