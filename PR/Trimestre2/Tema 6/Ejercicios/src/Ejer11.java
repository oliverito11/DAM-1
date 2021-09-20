/**
 * Versión java de la orden copy de MS-DOS que recibirá 2 argumentos y 
 * copiará el contenido del primer fichero al segundo.
 * */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Ejer11 {
	static final int SI = 1;
	static final int NO = 0;
	public static void main(String[] args) {
		if(args.length != 2) {
			System.err.println("Uso correcto del programa: java Ejer11 <fichero_origen> <fichero_destino>");
			return;
		}
		File fich1 = new File(args[0]);
		File fich2 = new File(args[1]);
		//El fichero origen no existe
		if(!fich1.exists() || fich1.isDirectory()) {
			System.err.println("El fichero <" + fich1 + "> no existe o es un directorio.");
			return;
		}
		if(fich2.isDirectory()) {
			System.err.println("El fichero <" + fich2 + "> es un directorio.");
			return;
		}
		
		//El fichero destino ya existe
		if(fich2.exists()) {
			Scanner teclado = new Scanner(System.in);
			System.out.print("El fichero <" + fich2 + "> ya existe, ¿desea sobreescribir?\n[" + SI + "] - Sí\n[" + NO + "] - No\n>");
			int opc = teclado.nextInt();
			teclado.close();
			
			if(opc == SI)
				fich2.delete();
			else
				return;
		}
		
		if(!copiar(fich1, fich2))
			System.err.println("No se pudo copiar el fichero.");
		else
			System.out.println("Copiado correctamente.");
	}
	
	static boolean copiar(File fichO, File fichD) {
		BufferedReader br = null;
		PrintWriter pw = null;
		boolean resultado = true;
		try {
			br = new BufferedReader(new FileReader(fichO));
			pw = new PrintWriter(new FileWriter(fichD));
			String linea = "";
			boolean primera = true;
			while((linea = br.readLine()) != null) {
				if(!primera)
					pw.println();
				
				pw.print(linea);
				primera = false;
			}
		}catch(IOException e) {
			System.err.println("Error al copiar el archivo. " + e.getMessage());
			resultado = false;
		}finally {
			try {
				if(br != null)
					br.close();
				if(pw != null)
					pw.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el archivo. " + e.getMessage());
				resultado = false;
			}
		}
		return resultado;
	}
}
