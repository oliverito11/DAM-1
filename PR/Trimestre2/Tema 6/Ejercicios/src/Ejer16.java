import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.util.Vector;
public class Ejer16 {
	static final int NUEVO = 1;
	static final int BUSCAR_TLF = 2;
	static final int CONSULTAR_CANTIDAD = 3;
	static final int LECTURA_CONCRETA = 4;
	static final int CONSULTAR_ENTRADAS = 5;
	static final int ACTUALIZAR = 6;
	static final int BORRAR = 7;
	static final int SALIR = 8;
	static final int ERROR = -1;
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Uso correcto del programa: java Ejer16 <agenda>");
			return;
		}
		File agenda = new File(args[0]);
		if(agenda.isDirectory()) {
			System.err.println("La agenda <" + agenda + "> no puede ser un directorio.");
			return;
		}
		
		int opc = 0;
		do {
			opc = menu();
			switch(opc) {
				case NUEVO:
					//Si la agenda es nueva, se tiene que añadir el header del tipo de objetos que son, si no, solo se añaden nuevos objetos
					if(!agenda.exists()) {
						if(primerAlumno(agenda))
							System.out.println("Alumno añadido correctamente.");
						else
							System.err.println("Hubo un problema al añadir un nuevo alumno.");
					}else {
						if(nuevoAlumno(agenda))
							System.out.println("Alumno añadido correctamente.");
						else
							System.err.println("Hubo un problema al añadir un nuevo alumno.");
					}
					break;
				case BUSCAR_TLF:
					int telefono = buscarTlf(pedirAlumno(), agenda); 
					if(telefono == ERROR)
						System.err.println("No se encontró el teléfono de dicho alumno.");
					else
						System.out.println("El número de teléfono de dicho alumno es: " + telefono);
					break;
				case CONSULTAR_CANTIDAD:
					int cantidad = cantidadAlumnos(agenda);
					if(cantidad == ERROR)
						System.err.println("Error al conseguir los alumnos.");
					else
						System.out.println("Hay " + cantidad + " alumnos dentro de la agenda.");
					break;
				case LECTURA_CONCRETA:
					System.out.print("Dime la posición del alumno que quieres buscar:\n>");
					int pos = teclado.nextInt();
					Alumno alumno = lecturaPosicion(agenda, pos);
					if(alumno == null)
						System.err.println("Error al visualizar el alumno.");
					else
						mostrarAlumno(alumno);
					break;
				case CONSULTAR_ENTRADAS:
					if(!consultarAlumnos(agenda))
						System.out.println("Hubo un problema al visualizar los alumnos.");
					break;
				case ACTUALIZAR:
					if(!actualizarAlumno(agenda, crearAlumno(), pedirAlumno()))
						System.err.println("Error al actualizar el alumno.");
					else
						System.out.println("Alumno actualizado correctamente.");
					break;
				case BORRAR:
					if(!borrarAlumno(agenda, pedirAlumno()))
						System.err.println("Error al borrar el alumno.");
					else
						System.out.println("Alumno borrado correctamente.");
					break;
				case ERROR:
				case SALIR:
					System.out.println("Fin del programa.");
					break;
				default:
					System.err.println("Opción incorrecta.");
					break;
			}
			teclado.nextLine();
			teclado.nextLine();
		}while(opc != SALIR);
		
		teclado.close();
	}
	
	static int menu() {
		System.out.println("\t\tAGENDA DEL PROFESOR");
		System.out.println("\t\t===================");
		System.out.println("\t[" + NUEVO + "] - Nuevo alumno.");
		System.out.println("\t[" + BUSCAR_TLF + "] - Buscar número de teléfono.");
		System.out.println("\t[" + CONSULTAR_CANTIDAD + "] - Número de alumnos.");
		System.out.println("\t[" + LECTURA_CONCRETA + "] - Siguiente alumno.");
		System.out.println("\t[" + CONSULTAR_ENTRADAS  + "] - Consultar todos los alumnos.");
		System.out.println("\t[" + ACTUALIZAR + "] - Actualizar datos de un alumno.");
		System.out.println("\t[" + BORRAR + "] - Borrar alumno.");
		System.out.println("\t[" + SALIR + "] - Salir.");
		System.out.print("\n>");
		
		int opc = 0;
		try {
			opc = teclado.nextInt();
		}catch(InputMismatchException e) {
			System.err.println("Se esperaba un entero");
			opc = ERROR;
		}
		return opc;
	}
	
	/** Se hace uso de la clase ObjectOutputStream para crear un nuevo fichero que contendrá objetos del tipo "Alumno" */
	static boolean primerAlumno(File agenda) {
		boolean resultado = true;
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(agenda));
			Alumno a = crearAlumno();
			oos.writeObject(a);
		}catch(IOException e) {
			System.err.println("Error al escribir en el archivo." + e.getMessage());
			resultado = false;
		}finally {
			try {
				if(oos != null)
					oos.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el archivo");
				resultado = false;
			}
		}
		return resultado;
	}
	
	/** Se hace uso de la clase MiObjectOutputStream para crear nuevos objetos y ser añadidos a la ya existente agenda */
	static boolean nuevoAlumno(File agenda) {
		boolean resultado = true;
		MiObjectOutputStream oos = null;
		try {
			oos = new MiObjectOutputStream(new FileOutputStream(agenda, true));
			Alumno a = crearAlumno();
			oos.writeObject(a);
		}catch(IOException e) {
			System.out.println("Error al escribir en el fichero.");
			resultado = false;
		}finally {
			try {
				if(oos != null)
					oos.close();
			}catch(IOException e) {
				System.out.println("Error al cerrar el fichero.");
				resultado = false;
			}
		}
		return resultado;
	}
	
	static boolean consultarAlumnos(File agenda) {
		boolean resultado = true;
		boolean finArchivo = false;
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(agenda));
			while(!finArchivo) {
				try {
					mostrarAlumno((Alumno)ois.readObject());
				}catch(ClassNotFoundException e) {
					System.out.println("No se encuentran objetos de ese tipo.");
					resultado = false;
					finArchivo = true;
				}catch(EOFException e) {
					finArchivo = true;
				}
			}
		}catch(IOException e) {
			System.err.println("Error de E/S." + e.getMessage());
			resultado = false;
		}finally {
			try {
				if(ois != null)
					ois.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el archivo.");
				resultado = false;
			}
		}
		return resultado;
	}
	
	static int buscarTlf(String alumNombre, File agenda) {
		int telefono = ERROR;
		boolean finArchivo = false;
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(agenda));
			while(!finArchivo) {
				try {
					Alumno a = (Alumno)ois.readObject();
					if(a.nombre.equals(alumNombre)) {
						telefono = a.tlf;
						finArchivo = true;
					}
				}catch(ClassNotFoundException e) {
					finArchivo = true;
				}catch(EOFException e) {
					finArchivo = true;
				}
			}
		}catch(IOException e) {
			System.err.println("Error de E/S." + e.getMessage());
			telefono = ERROR;
		}finally {
			try {
				if(ois != null)
					ois.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el archivo.");
				telefono = ERROR;
			}
		}
		return telefono;
	}
	
	static Alumno lecturaPosicion(File agenda, int posicion) {
		ObjectInputStream ois = null;
		Alumno al = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(agenda));
			for(int i = 0; i < posicion; i++)
				al = (Alumno)ois.readObject();
		}catch(EOFException e) {
			
		}catch(ClassNotFoundException e) {
			System.err.println("Clase no encontrada:" + e.getMessage());
			al = null;
		}catch(IOException e) {
			System.err.println("Error de E/S." + e.getMessage());
			al = null;
		}finally {
			try {
				if(ois != null)
					ois.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el archivo.");
				al = null;
			}
		}
		return al;
	}
	
	static int cantidadAlumnos(File agenda) {
		int cantidad = 0;
		boolean finArchivo = false;
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(agenda));
			while(!finArchivo) {
				try {
					ois.readObject();
					cantidad++;
				}catch(ClassNotFoundException e) {
					finArchivo = true;
				}catch(EOFException e) {
					finArchivo = true;
				}
			}
		}catch(IOException e) {
			System.err.println("Error de E/S." + e.getMessage());
			cantidad = ERROR;
		}finally {
			try {
				if(ois != null)
					ois.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el archivo.");
				cantidad = ERROR;
			}
		}
		return cantidad;
	}
	
	static boolean actualizarAlumno(File agenda, Alumno a, String nombre) {
		boolean resultado = true;
		ObjectInputStream ois = null;
		Vector<Alumno> agendaNueva = new Vector<Alumno>();
		try {
			ois = new ObjectInputStream(new FileInputStream(agenda));
			while(true) {
				Alumno al = (Alumno)ois.readObject();
				if(al.nombre.equalsIgnoreCase(nombre))
					agendaNueva.add(a);
				else
					agendaNueva.add(al);
			}
		}catch(EOFException e) {
		}catch(ClassNotFoundException e) {
			System.err.println("No se encuentra la clase:" + e.getMessage());
			resultado = false;
		}catch(IOException e) {
			System.err.println("Error de E/S." + e.getMessage());
			resultado = false;
		}finally {
			try {
				if(ois != null)
					ois.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el archivo.");
				resultado = false;
			}
		}
		
		if(!nuevaAgenda(agendaNueva, agenda))
			resultado = false;
		
		return resultado;
	}
	
	static boolean borrarAlumno(File agenda, String nombre) {
		boolean resultado = true;
		ObjectInputStream ois = null;
		Vector<Alumno> agendaNueva = new Vector<Alumno>();
		try {
			ois = new ObjectInputStream(new FileInputStream(agenda));
			while(true) {
				Alumno al = (Alumno)ois.readObject();
				if(!al.nombre.equalsIgnoreCase(nombre))
					agendaNueva.add(al);
			}
		}catch(EOFException e) {
		}catch(ClassNotFoundException e) {
			System.err.println("No se encuentra la clase:" + e.getMessage());
			resultado = false;
		}catch(IOException e) {
			System.err.println("Error de E/S." + e.getMessage());
			resultado = false;
		}finally {
			try {
				if(ois != null)
					ois.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el archivo.");
				resultado = false;
			}
		}
		
		if(!nuevaAgenda(agendaNueva, agenda))
			resultado = false;
		
		return resultado;
	}
	
	
	static boolean nuevaAgenda(Vector<Alumno> alumnos, File agenda) {
		boolean resultado = true;
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(agenda));
			for(int i = 0; i < alumnos.size(); i++)
				oos.writeObject(alumnos.elementAt(i));
		}catch(EOFException e) {
		}catch(IOException e) {
			System.err.println("Error de E/S." + e.getMessage());
			resultado = false;
		}finally {
			try {
				if(oos != null)
					oos.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el archivo.");
				resultado = false;
			}
		}
		return resultado;
	}
	
	static Alumno crearAlumno() {
		Alumno a = new Alumno();
		System.out.print("Curso del alumno:\n>");
		a.curso = teclado.nextLine();
		System.out.print("Letra identificativa del curso:\n>");
		a.grupo = teclado.nextLine().charAt(0);
		System.out.print("Nombre del alumno:\n>");
		a.nombre= teclado.nextLine();
		System.out.print("Teléfono del alumno:\n>");
		a.tlf= teclado.nextInt();
		
		return a;
	}
	
	static void mostrarAlumno(Alumno a) {
		System.out.println("------------------------------------------------------");
		System.out.println("El nombre del alumno es: " + a.nombre);
		System.out.println("Cursa en: " + a.curso);
		System.out.println("La letra identificativa del curso es: " + a.grupo);
		System.out.println("Su teléfono es: " + a.tlf);
		System.out.println("------------------------------------------------------");
	}
	
	static String pedirAlumno() {
		teclado.nextLine();
		System.out.print("¿Cuál es el nombre del alumno que quieres buscar?\n>");
		return teclado.nextLine();
	}
}
