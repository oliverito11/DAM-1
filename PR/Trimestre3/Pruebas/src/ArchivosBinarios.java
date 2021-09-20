
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.util.Scanner;
public class ArchivosBinarios {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ruta del fichero");
		String ruta = teclado.nextLine();
		System.out.println("Escribiendo...");
		escribir(ruta);
		System.out.println("Leyendo...");
		leer(ruta);
		teclado.close();
	}
	
	static void escribir(String ruta) {
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(new File(ruta)));
			for(int i = 0; i < 10; i++)
				dos.writeFloat(i);
		}catch(IOException e) {
			System.err.println("Error de E/S");
		}finally {
			try {
				if(dos != null)
					dos.close();
			}catch(IOException e) {
				System.err.println("Error de E/S");
			}
		}
	}
	
	static void leer(String ruta) {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(new File(ruta)));
			while(true)
				System.out.println(dis.readFloat());
			
		}catch(EOFException e) {
			System.out.println("Fin del archivo.");
		}catch(FileNotFoundException e) {
			System.err.println("Error de E/S");
		}catch(IOException e) {
			System.err.println("Error de E/S");
		}finally {
			try {
				if(dis != null)
					dis.close();
			}catch(IOException e) {
				System.err.println("Error de E/S");
			}
		}
	}
}
