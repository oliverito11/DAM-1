import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class LecturaYEscritura {
	static Scanner teclado = new Scanner(System.in);
	public static void main(String [] args) {
		System.out.print("Dime el nombre de un fichero de texto:\n>");
		String texto = teclado.nextLine();
		System.out.print("Dime el nombre de un fichero de datos:\n>");
		String datos = teclado.nextLine();
		System.out.print("Dime el nombre de un fichero de objetos:\n>");
		String objetos = teclado.nextLine();
		
		System.out.println("Escritura de un fichero de texto.");
		escribirTexto(texto);
		System.out.println("Lectura de un fichero de texto.");
		leerTexto(texto);
		
		System.out.println("Escritura de un fichero de datos.");
		escribirDatos(datos);
		System.out.println("Lectura de un fichero de datos.");
		leerDatos(datos);
		
		System.out.println("Escritura de un fichero de objetos.");
		escribirObjetos(objetos);
		System.out.println("Lectura de un fichero de objetos.");
		leerObjeto(objetos);
	}
	
	static void escribirTexto(String fichero) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream(fichero));
			for(int i = 0; i < 100; i++)
				pw.println(i);
		}catch(IOException e) {
			System.err.println("Error al escribir el fichero de texto: " + e.getMessage());
		}finally {
			if(pw != null)
				pw.close();
		}
	}
	
	static void leerTexto(String fichero) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fichero));
			String linea = "";
			while((linea = br.readLine()) != null)
				System.out.println(linea);
		}catch(IOException e) {
			System.err.println("Error al leer el fichero de texto: " + e.getMessage());
		}finally {
			if(br!= null)
				try {
					br.close();
				} catch (IOException e) {
					System.err.println("Error al cerrar el fichero de texto: " + e.getMessage());
				}
		}
	}
	
	static void escribirDatos(String fichero) {
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(fichero));
			for(int i = 0; i < 10; i++)
				dos.writeInt(i);
		}catch(IOException e) {
			System.err.println("Error al escribir el fichero de datos: " + e.getMessage());
		}finally {
			if(dos!= null)
				try {
					dos.close();
				} catch (IOException e) {
					System.err.println("Error al cerrar el fichero de datos: " + e.getMessage());
				}
		}
	}
	
	static void leerDatos(String fichero) {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(fichero));
			
			while(true) {
				System.out.println(dis.readInt());
			}
		}catch(EOFException e) {
			//Fin del fichero
		}catch(IOException e) {
			System.err.println("Error al leer el fichero de datos: " + e.getMessage());
		}finally {
			if(dis!= null)
				try {
					dis.close();
				} catch (IOException e) {
					System.err.println("Error al cerrar el fichero de datos: " + e.getMessage());
				}
		}
	}
	
	static void escribirObjetos(String fichero) {
		ObjectOutputStream oos = null;
		Coche c;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fichero));
			c = rellenarCoche();
			oos.writeObject(c);
		}catch(IOException e) {
			System.err.println("Error al escribir el fichero de objetos: " + e.getMessage());
		}finally {
			try {
				if(oos != null)
					oos.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el fichero de objetos: " + e.getMessage());
			}
		}
	}
	
	static void leerObjeto(String fichero) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(fichero));
			while(true) {
				System.out.println(mostrarCoche((Coche)ois.readObject()));
			}
		}catch(EOFException e) {
			//Fin del archivo
		}catch(ClassNotFoundException e) {
			System.err.println("Error al leer la clase: " + e.getMessage());
		}catch(IOException e) {
			System.err.println("Error al leer el fichero de objetos: " + e.getMessage());
		}finally {
			try {
				if(ois != null)
					ois.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el fichero de objetos: " + e.getMessage());
			}
		}
	}
	
	static Coche rellenarCoche() {
		Coche c = new Coche();
		teclado.useLocale(Locale.ENGLISH);
		teclado.useDelimiter(System.getProperty("line.separator"));
		
		System.out.print("Nombre del coche:\n>");
		c.nombre = teclado.nextLine();
		System.out.print("Marca del coche:\n>");
		c.marca = teclado.nextLine();
		System.out.print("Peso del coche:\n>");
		c.peso = teclado.nextFloat();
		
		return c;
	}
	
	static String mostrarCoche(Coche c) {
		return "El nombre del coche es " + c.nombre + " y es de la marca " + c.marca + ". Su peso es de " + c.peso + "kg.";
	}
}
