import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;
public class LecturaEscrituraObjetos {
	static Scanner teclado = new Scanner(System.in);
	static final int NUEVO = 1;
	static final int LEER = 2;
	static final int ACTUALIZAR = 3;
	static final int BORRAR = 4;
	static final int SALIR = 5;
	public static void main(String[] args) {
		int opc = 0;
		String agenda = args[0];
		teclado.useLocale(Locale.ENGLISH);
		teclado.useDelimiter(System.getProperty("line.separator"));
		do {
			opc = menu();
			teclado.nextLine();
			String nombreCoche;
			Coche c;
			File age = new File(agenda);
			switch(opc) {
				case NUEVO:	
					if(age.length() == 0 && primerCoche(agenda))
						System.out.println("Coche añadido a la agenda correctamente.");
					else if(age.length() != 0 && nuevoCoche(agenda))
						System.out.println("Coche añadido a la agenda correctamente.");
					else
						System.err.println("No se pudo añadir un nuevo coche.");
					
					break;
				case LEER:
					if(!leerCoche(agenda))
						System.err.println("No se pudieron leer los coches.");
					break;
				case ACTUALIZAR:
					System.out.print("Dime el nombre del coche que quieres modificar:\n>");
					nombreCoche = teclado.nextLine();
					c = rellenarCoche();
					if(actualizarCoche(agenda, nombreCoche, c))
						System.out.println("Coche actualizado correctamente.");
					else
						System.err.println("Error al actualizar el coche.");
					
					break;
				case BORRAR:
					System.out.print("Dime el nombre del coche que quieres borrar:\n>");
					nombreCoche = teclado.nextLine();
					
					if(borrarCoche(agenda, nombreCoche))
						System.out.println("Coche borrado correctamente.");
					else
						System.err.println("Error al borrar el coche.");
					
					break;
				case SALIR:
					System.out.println("Fin del programa");
					break;
				default:
					System.err.println("Opción no válida...");	
			}
			teclado.nextLine();
			teclado.nextLine();
		}while(opc != SALIR);
		teclado.close();
	}
	
	static int menu() {
		System.out.println("[" + NUEVO + "]-Escribir coche");
		System.out.println("[" + LEER + "]-Leer coches");
		System.out.println("[" + ACTUALIZAR + "]-Actualizar coche");
		System.out.println("[" + BORRAR + "]-Borrar coche");
		System.out.println("[" + SALIR + "]-Salir");
		System.out.print("\n>");
		int opc = teclado.nextInt();
		return opc;
	}
	
	static boolean primerCoche(String agenda) {
		boolean resultado = true;
		ObjectOutputStream oos = null;
		Coche c;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(agenda));
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
		return resultado;
	}
	
	static boolean nuevoCoche(String agenda) {
		boolean resultado = true;
		MiObjectOutputStream moos = null;
		try {
			moos = new MiObjectOutputStream(new FileOutputStream(agenda, true));
			Coche c = rellenarCoche();
			
			moos.writeObject(c);
		}catch(IOException e) {
			System.err.println("Error de E/S al añadir un coche: " + e.getMessage());
			resultado = false;
		}finally {
			try {
				if(moos!= null)
					moos.close();
			}catch(IOException e) {
				System.err.println("Error de E/S cerrar el fichero: " + e.getMessage());
				resultado = false;
			}
		}
		return resultado;
	}
	
	static boolean leerCoche(String agenda) {
		boolean resultado = true;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(agenda));
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
		return resultado;
	}
	
	static boolean actualizarCoche(String agenda, String nombre, Coche c) {
		boolean resultado = true;
		boolean encontrado = false;
		ObjectInputStream ois = null;
		Vector<Coche> coches = new Vector<Coche>();
		try {
			ois = new ObjectInputStream(new FileInputStream(agenda));
			Coche co = null;
			
			while(!encontrado && (co = (Coche)ois.readObject()) != null) {
				if(co.nombre.equalsIgnoreCase(nombre))
					coches.add(c);
				else
					coches.add(co);
			}
		}catch(EOFException e) {
			//Fin del archivo
		}catch(ClassNotFoundException e) {
			System.err.println("Error de E/S al leer la clase: " + e.getMessage());
			resultado = false;
		}catch(IOException e) {
			System.err.println("Error de E/S al añadir un coche: " + e.getMessage());
			resultado = false;
		}finally {
			try {
				if(ois != null)
					ois.close();
			}catch(IOException e) {
				System.err.println("Error de E/S cerrar el fichero: " + e.getMessage());
				resultado = false;
			}
		}
		resultado = nuevaAgenda(agenda, coches);
		return resultado;
	}
	
	static boolean borrarCoche(String agenda, String nombre) {
		boolean resultado = true;
		boolean encontrado = false;
		ObjectInputStream ois = null;
		Vector<Coche> coches = new Vector<Coche>();
		try {
			ois = new ObjectInputStream(new FileInputStream(agenda));
			Coche co = null;
			
			while(!encontrado && (co = (Coche)ois.readObject()) != null) {
				if(!co.nombre.equalsIgnoreCase(nombre))
					coches.add(co);
			}
		}catch(EOFException e) {
			//Fin del archivo
		}catch(ClassNotFoundException e) {
			System.err.println("Error de E/S al leer la clase: " + e.getMessage());
			resultado = false;
		}catch(IOException e) {
			System.err.println("Error de E/S al añadir un coche: " + e.getMessage());
			resultado = false;
		}finally {
			try {
				if(ois != null)
					ois.close();
			}catch(IOException e) {
				System.err.println("Error de E/S cerrar el fichero: " + e.getMessage());
				resultado = false;
			}
		}
		resultado = nuevaAgenda(agenda, coches);
		return resultado;
	}
	
	static boolean nuevaAgenda(String agenda, Vector<Coche> coches) {
		boolean resultado = true;
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(agenda));
			for(int i = 0; i < coches.size(); i++)
				oos.writeObject(coches.elementAt(i));
		}catch(IOException e) {
			System.err.println("Error de E/S: " + e.getMessage());
			resultado = false;
		}finally {
			if(oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					System.err.println("Error de E/S al cerrar el fichero: " + e.getMessage());
					resultado = false;
				}
		}
		return resultado;
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

