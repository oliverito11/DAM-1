import java.io.*;
import java.util.Scanner;
public class Ejer18 {
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Fichero:\n>");
		File fichero = new File(teclado.nextLine());
		System.out.print("Posición desde la que quieres ver la línea:\n>");
		long pos = teclado.nextLong();
		if(mostrarLinea(fichero, pos))
			System.out.println("Línea mostrada correctamente.");
		else
			System.err.println("Error al mostrar la línea.");
	}
	
	static boolean mostrarLinea(File fichero, long posicion) {
		boolean resultado = true;
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(fichero, "r");
			raf.seek(posicion);
			System.out.println(raf.readLine());
		}catch(IOException e) {
			System.err.println("Error de E/S: " + e.getMessage());
			resultado = false;
		}finally {
			try {
				if(raf != null)
					raf.close();
			}catch(IOException e){
				System.err.println("Error de cierre de fichero: " + e.getMessage());
				resultado = false;
			}
		}
		return resultado;
	}
}
