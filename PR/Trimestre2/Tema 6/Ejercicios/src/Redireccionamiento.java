import java.io.*;
import java.util.Scanner;
public class Redireccionamiento {
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Fichero donde se redireccionará la salida estándar de error:\n>");
		File fich = new File(teclado.nextLine());
		try {
			System.setErr(new PrintStream(new FileOutputStream(fich)));
		}catch(IOException e) {
			System.err.println("Error de E/S: " + e .getMessage());
		}
		teclado.close();
		int[] arr = new int[2];
		System.out.println(arr[0]);
		System.out.println(arr[2]);
	}
}
