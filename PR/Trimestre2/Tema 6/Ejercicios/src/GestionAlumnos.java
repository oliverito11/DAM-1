/**
 * Crear un menú de gestión de notas de un alumnado. Se mostrará un menú que dará a elegir entre
 * las opciones de añadir un alumno, modificar un alumno, ver las notas de un alumno y ver la
 * media de las notas de todos.
 * Un alumno nuevo será un fichero con extensión al y que contendrá solo las notas (floats) del
 * alumno correspondiente.
 * */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.util.Locale;
import java.util.Scanner;
public class GestionAlumnos {
	static final int NUEVO_ALUMNO = 1;
	static final int NUEVA_NOTA = 2;
	static final int VER_NOTAS = 3;
	static final int MEDIA_NOTAS = 4;
	static final int SALIR = 5;
	static final int SI = 1;
	static final int NO = 2;
	static final float ERROR = -1f;
	static Scanner teclado = new Scanner(System.in);
	static final String EXTENSION = ".al";
	static String ruta;
	public static void main(String[] args) {
		ruta = pedirRuta();
		int opc = 0;
		teclado.useLocale(Locale.ENGLISH);
		do {
			opc = menu();
			teclado.nextLine();
			switch(opc) {
				case NUEVO_ALUMNO:
					//El alumno se creará con un fichero que contendrá las notas de dicho alumno
					if(notasAlumno(pedirAlumno()))
						System.out.println("Alumno creado satisfactoriamente.");
					else
						System.err.println("Error al insertar un nuevo alumno.");
					break;
				case NUEVA_NOTA:
					if(notasAlumno(pedirAlumno()))
						System.out.println("Nota añadida satisfactoriamente.");
					else
						System.err.println("Error al insertar una nueva nota.");
					break;
				case VER_NOTAS:
					if(!visualizarAlumno(pedirAlumno()))
						System.err.println("Error al visualizar el alumno.");
					break;
				case MEDIA_NOTAS:
					float media = mediaNotas(pedirAlumno());
					if(media == ERROR)
						System.err.println("Error al visualizar la nota media el alumno.");
					else
						System.out.println("La nota media del alumno es " + media);
					break;
				case SALIR:
					System.out.println("Fin del programa.");
					break;
				default:
					System.err.println("Opción no válida.");
			}
		}while(opc != SALIR);
		teclado.close();
	}
	
	static int menu() {
		System.out.println("\t\tNOTAS DE ALUMNOS");
		System.out.println("[" + NUEVO_ALUMNO + "] - Nuevo alumno.");
		System.out.println("[" + NUEVA_NOTA + "] - Añadir nota a un alumno.");
		System.out.println("[" + VER_NOTAS + "] - Consultar las notas de un alumno.");
		System.out.println("[" + MEDIA_NOTAS + "] - Consultar la nota media del alumno.");
		System.out.println("[" + SALIR + "] - Salir.");
		System.out.print("\n>");
		return teclado.nextInt();
	}
	
	static boolean notasAlumno(File alumno) {
		DataOutputStream dos = null;
		boolean resultado = true;
		try {
			//Se crea el alumno en caso de no existir
			dos = new DataOutputStream(new FileOutputStream(alumno, true));
			//Se le pide al usuario insertar notas
			while(pedirInsertarNotas()) {
				dos.writeFloat(insertarNota(alumno));
			}
		}catch(IOException e) {
			System.err.println("Error de E/S.");
			resultado = false;
		}finally {
			try {
				if(dos != null)
					dos.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el fichero.");
				resultado = false;
			}
		}
		return resultado;
	}
	
	static Float insertarNota(File alumno) {
		System.out.print("Dime la nota del alumno:\n>");
		return teclado.nextFloat();
	}
	
	static boolean visualizarAlumno(File alumno) {
		DataInputStream dos = null;
		boolean resultado = true;
		boolean finArchivo = false;
		try {
			dos = new DataInputStream(new FileInputStream(alumno));
			while(!finArchivo) {
				try {
					System.out.println("Nota del alumno: " + dos.readFloat());
				}catch(EOFException e) {
					finArchivo = true;
				}catch(IOException e) {
					System.err.println("Error de E/S.");
					resultado = false;
				}
			}
		}catch(FileNotFoundException e) {
			System.err.println("No se encuentra el fichero.");
			resultado = false;
		}finally {
			try {
				if(dos != null)
					dos.close();
			}catch(IOException e) {
				System.out.println("Error al cerrar el fichero.");
				resultado = false;
			}
		}
		return resultado;
	}
	
	static float mediaNotas(File alumno) {
		DataInputStream dos = null;
		float media = 0;
		int cont = 0;
		boolean finArchivo = false;
		try {
			dos = new DataInputStream(new FileInputStream(alumno));
			while(!finArchivo) {
				try {
					media += dos.readFloat();
					cont++;
				}catch(EOFException e) {
					finArchivo = true;
				}catch(IOException e) {
					System.err.println("Error de E/S.");
					media = ERROR;
				}
			}
		}catch(FileNotFoundException e) {
			System.err.println("No se encuentra el fichero.");
			media = ERROR;
		}finally {
			try {
				if(dos != null)
					dos.close();
			}catch(IOException e) {
				System.out.println("Error al cerrar el fichero.");
				media = ERROR;
			}
		}
		if(media != ERROR)
			media = media / cont;
		return media;
	}
	
	static boolean pedirInsertarNotas() {
		System.out.print("¿Quiéres añadir una nueva nota?\n[" + SI + "] - Sí\n[" + NO + "] - No\n>");
		int opc = teclado.nextInt();
		if(opc == NO)
			return false;
		return true;
	}
	
	static File pedirAlumno() {
		System.out.print("Dime el nombre del alumno:\n>");
		return new File(ruta, teclado.nextLine() + EXTENSION);
	}
	
	static String pedirRuta() {
		System.out.print("Dime la ruta en donde se encuentran los alumnos:\n>");
		File dir = new File(teclado.nextLine());
		dir.mkdir();
		return dir.getPath();
	}
}
