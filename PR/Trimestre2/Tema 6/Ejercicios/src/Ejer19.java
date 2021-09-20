import java.io.*;
import java.util.Scanner;
import java.util.Vector;
public class Ejer19 {
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Dame el nombre de un fichero:\n>");
		File fichero = new File(teclado.nextLine());
		if(mostrarLineas(fichero))
			System.out.println("\nLíneas mostradas correctamente.");
		else
			System.err.println("\nError al mostrar las líneas.");
	}
	
	static boolean mostrarLineas(File fich) {
		boolean resultado = true;
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(fich, "r");
			Vector<Long> posiciones = new Vector<Long>();
			
			posiciones.add(raf.getFilePointer());
			while(raf.readLine() != null) {
				posiciones.add(raf.getFilePointer());
			}
			
			for(int i = 0, j = posiciones.size() - 2; i <= j; i++, j--) {
				if(i == j) {
					//Última línea
					raf.seek(posiciones.elementAt(i));
					System.out.println(raf.readLine());					
				}else {
					//Líneas de arriba a abajo
					raf.seek(posiciones.elementAt(i));
					System.out.println(raf.readLine());
					//Líneas de abajo a arriba
					raf.seek(posiciones.elementAt(j));
					System.out.println(raf.readLine());
				}
				
			}
		}catch(IOException e) {
			System.err.println("Error de E/S: " + e.getMessage());
			resultado = false;
		}finally {
			try {
				if(raf != null)
					raf.close();
			}catch(IOException e) {
				System.err.println("Error de E/S: " + e.getMessage());
				resultado = false;
			}
		}
		return resultado;
	}
}
