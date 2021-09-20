import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ejer20 {
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Dime el fichero que quieres usar como salida de error:\n>");
		File log = new File(teclado.nextLine());
		
		if(cambiarSalidaError(log)) {
			System.out.println("Redireccionamiento completado!");
			int[] arr = new int[2];
			arr[2] = 2;
		}
		else
			System.err.println("Fallo al redireccionar.");
	}
	
	static boolean cambiarSalidaError(File fichero) {
		boolean resultado = true;
		try {
			System.setErr(new PrintStream(new FileOutputStream(fichero)));
			//System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		}catch(IOException e) {
			System.err.println("Error de E/S: " + e.getMessage());
			resultado = false;
		}
		return resultado;
	}
}
