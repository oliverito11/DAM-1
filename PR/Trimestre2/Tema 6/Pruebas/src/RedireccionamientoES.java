
import java.util.Scanner;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class RedireccionamientoES {
	static Scanner teclado = new Scanner(System.in);
	public static void main(String args[]) {
		System.out.print("Dime el nombre del fichero donde quieres redirigir la salida de error:\n");
		String fich = teclado.nextLine();
		teclado.close();
		try {
			PrintStream ps = new PrintStream(new FileOutputStream(fich));
			System.setErr(ps);
		}catch(IOException e) {
			System.err.println("Error de E/S:" + e.getMessage());
		}
		
		int[] arr = new int[2];
		arr[2] = 2;
	}
}
