import java.io.*;
import java.util.Scanner;
import java.util.Vector;
public class LEdeAlumnos {
	static final int NUEVO_ALUMNO = 1;
	static final int VER_ALUMNO = 2;
	static final int BORRAR = 3;
	static final int SALIR = 4;
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Uso correcto del programa: java LEdeAlumnos <fichero_agenda>");
			return;
		}
		int opc = 0;
		File agenda = new File(args[0]);
		do {
			opc = menu();
			teclado.nextLine();
			switch(opc) {
				case NUEVO_ALUMNO:
					if(agenda.exists() && agenda.isFile() && agenda.length() > 0) {
						if(agregarAlumno(agenda, pedirAlumno()))
							System.out.println("Alumno añadido correctamente.");
						else
							System.err.println("Error al añadir un nuevo alumno.");
					}else {
						if(primerAlumno(agenda, pedirAlumno()))
							System.out.println("Alumno añadido correctamente.");
						else
							System.err.println("Error al añadir un nuevo alumno.");						
					}
					break;
				case VER_ALUMNO:
					if(!verAlumno(agenda, pedirNombreAlumno()))
						System.err.println("Error al visualizar al alumno.");
					break;
				case BORRAR:
					if(!borrarAlumno(agenda, pedirNombreAlumno()))
						System.err.println("Error al borrar al alumno.");
					else
						System.out.println("Alumno borrado correctamente.");
					break;
				case SALIR:
					System.out.println("Fin del programa");
					break;
				default:
					System.err.println("Opción no válida");					
			}
			teclado.nextLine();
		}while(opc != SALIR);
		teclado.close();
	}
	
	static int menu() {
		System.out.println("\t\tALUMNOS");
		System.out.println("\t\t=======");
		System.out.println("[" + NUEVO_ALUMNO + "] - Añadir un nuevo alumno.");
		System.out.println("[" + VER_ALUMNO + "] - Visualizar un alumno.");
		System.out.println("[" + BORRAR + "] - Borrar un alumno.");
		System.out.println("[" + SALIR + "] - Salir.");
		return teclado.nextInt();
	}
	
	static boolean primerAlumno(File agenda, Alumno a) {
		boolean resultado = true;
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(agenda, true));
			oos.writeObject(pedirAlumno());
		}catch(IOException e) {
			System.err.println("Error al escribir en el fichero.");
			resultado = false;
		}finally {
			try {
				if(oos != null)
					oos.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el fichero.");
				resultado = false;
			}
		}
		
		return resultado;
	}
	
	static boolean agregarAlumno(File agenda, Alumno a) {
		boolean resultado = true;
		MiObjectOutputStream oos = null;
		
		try {
			oos = new MiObjectOutputStream(new FileOutputStream(agenda, true));
			oos.writeObject(a);
		}catch(IOException e) {
			System.err.println("Error al escribir en el fichero.");
			resultado = false;
		}finally {
			try {
				if(oos != null)
					oos.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el fichero.");
				resultado = false;
			}
		}
		
		return resultado;
	}
	
	static boolean verAlumno(File agenda, String nombre) {
		boolean resultado = true;
		ObjectInputStream ois = null;
		Alumno a = null;
		if(agenda.length() == 0)
			System.out.println("No hay alumnos integrados en la agenda.");
		else{
			try {
				ois = new ObjectInputStream(new FileInputStream(agenda));
				boolean encontrado = false;
				while(!encontrado && (a = (Alumno)ois.readObject()) != null) {
					if(a.nombre.equalsIgnoreCase(nombre)) {
						System.out.println(a);
						encontrado = true;
					}
				}
			}catch(EOFException e) {
				//Fin del archivo
			}catch(ClassNotFoundException e) {
				System.err.println("Error al leer del fichero.");
				resultado = false;
			}catch(IOException e) {
				System.err.println("Error al leer del fichero.");
				resultado = false;
			}finally {
				try {
					if(ois != null)
						ois.close();
				}catch(IOException e) {
					System.err.println("Error al cerrar el fichero.");
					resultado = false;
				}
			}
		}
		
		if(a == null)
			resultado = false;
		
		return resultado;
	}
	
	static boolean borrarAlumno(File agenda, String alumno) {
		boolean resultado = true;
		ObjectInputStream ois = null;
		Vector<Alumno> alumnos = new Vector<Alumno>();
		try {
			ois = new ObjectInputStream(new FileInputStream(agenda));
			while(true) {
				Alumno a = (Alumno)ois.readObject();
				if(!a.nombre.equalsIgnoreCase(alumno))
					alumnos.add(a);
			}
		}catch(EOFException e) {
			//Fin del fichero
		}catch(ClassNotFoundException e) {
			System.err.println("Error de clase: " + e.getMessage());
			resultado = false;
		}catch(IOException e) {
			System.err.println("Error de E/S: " + e.getMessage());
			resultado = false;
		}finally {
			try {
				if(ois != null)
					ois.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar la agenda.");
				resultado = false;
			}
		}
		
		if(!nuevaAgenda(agenda, alumnos))
			resultado = false;
		return resultado;
	}
	
	static boolean nuevaAgenda(File agenda, Vector<Alumno> alumnos) {
		boolean resultado = true;
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(agenda));
			for(int i = 0; i < alumnos.size(); i++)
				oos.writeObject(alumnos.elementAt(i));
		}catch(IOException e) {
			System.err.println("Error de E/S: " + e.getMessage());
			resultado = false;
		}finally {
			try {
				if(oos != null)
					oos.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el fichero: " + e.getMessage());
				resultado = false;
			}
		}
		return resultado;
	}
	
	static Alumno pedirAlumno() {
		Alumno a = new Alumno();
		System.out.print("Nombre del alumno:\n>");
		a.nombre = teclado.nextLine();
		System.out.print("Curso del alumno:\n>");
		a.curso = teclado.nextLine();
		System.out.print("Grupo del alumno:\n>");
		a.grupo = teclado.nextLine().charAt(0);
		System.out.print("Número de teléfono del alumno:\n>");
		a.tlf = teclado.nextInt();
		return a;
	}
	
	static String pedirNombreAlumno() {
		System.out.print("Dime el nombre del alumno sobre el que quieres trabajar:\n>");
		return teclado.nextLine();
	}
}
