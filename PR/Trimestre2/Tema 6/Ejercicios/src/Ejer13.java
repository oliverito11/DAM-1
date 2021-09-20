/**
 * Programa que recreará la función readLine() de la clase BufferedReader
 * */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class Ejer13 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		BufferedReader br = null;
		try {
			System.out.print("Dime la ruta del fichero:\n>");
			File fichero = new File(teclado.nextLine());
			br = new BufferedReader(new FileReader(fichero));
			String linea = "";
			while((linea = leeLinea(br)) != null)
				System.out.println(linea);
		}catch(FileNotFoundException e) {
			System.err.println("No existe ese fichero.");
		}catch(IOException e) {
			System.err.println("Error de E/S.");
		}finally {
			try {				
				if(br != null)
					br.close();
			}catch(IOException e) {
				System.err.println("Error de E/S");
			}
			teclado.close();
		}
	}
	
	static String leeLinea(BufferedReader br) {
		int lectura = 0;
		String resultado = "";
		try {
			while((lectura = br.read()) != '\n' && lectura != -1){
				resultado += (char)lectura;				
			}
		}catch(IOException e) {
			System.err.println("Error de E/S.");
		}
		if(lectura == -1)
			resultado = null;
		return resultado;
	}
}
