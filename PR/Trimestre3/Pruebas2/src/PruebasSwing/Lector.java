package PruebasSwing;

/**
 * Clase que sive para la lectura del fichero donde se guardan las distintas
 * acciones que ha de tomar el programa y que se almacenará en una estructura dinámica
 * de cola.
 * */

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
public class Lector {
	private File fichero;
	
	public Lector(File fichero) {
		if(!fichero.exists() || fichero.isDirectory())
			System.err.println("El fichero no existe o no es un archivo de texto.");
		else
			this.fichero = fichero;
	}
	
	public LinkedList<String> leerLinea() {
		LinkedList<String> lineas = new LinkedList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fichero));
			String linea = "";
			while((linea = br.readLine()) != null)
				lineas.push(linea);
		}catch(IOException e) {
			System.err.println("Error de E/S: " + e.getMessage());
		}finally {
			try {
				if(br != null)
					br.close();
			}catch(IOException e) {
				System.err.println("Error de E/S: " + e.getMessage());
			}
		}
		return lineas;
	}
}
