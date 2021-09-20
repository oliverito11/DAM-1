/**
 * Programa que mostrará un menú con los distintos cursos que hay. En cada uno habrá carpetas con cada alumno
 * y dentro de estas habrá un fichero de texto con observaciones sobre dicho alumno y otro fichero no
 * legible que contenga toda su información. Además, existirá un archivo con las distintas notas que ha sacado.
 * */
import java.io.*;
import java.util.Scanner;
public class GestionDeCursos {
	//Opciones del menú
	static final int DAM1 = 1;
	static final int DAM2 = 2;
	static final int SMR1 = 3;
	static final int SMR2 = 4;
	static final int SALIR = 5;
	
	//Opciones del submenú
	static final int NUEVO = 1;
	static final int VER_TODOS = 2;
	static final int VER_UNO = 3;
	static final int ACTUALIZAR = 4;
	static final int BORRAR = 5;
	static final int VOLVER = 6;
	
	//Extensiones
	static final String OBSERV = ".txt";
	static final String NOTAS = ".not";
	static final String INFOR = ".dat";
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int opc = 0;
		do {
			File curso;
			opc = menu();
			teclado.nextLine();
			teclado.nextLine();
			switch(opc) {
				case DAM1:
					curso = new File("DAM1");
					curso.mkdir();
					listarAlumnos(curso);
					//Mostrar submenú
					int opc2 = 0;
					do {
						opc2 = submenu(curso.getName());
						switch(opc2) {
							case NUEVO:
								//Se creará una carpeta por cada nuevo alumno donde, a su vez, dentro habra un archivo de datos, otro de texto y otro de objetos
								if(crearCarpetaAlumno(curso, pedirNombre()))
									System.out.println("Alumno creado correctamente.");
								else
									System.err.println("Error al crear el alumno.");
								
								break;
							case VER_TODOS:
								verAlumnos(curso);
								break;
							case VER_UNO:
								if(verAlumno(curso, pedirNombre()))
									System.out.println("Visualización del alumno correcta.");
								else
									System.err.println("No se ha encontrado el alumno.");
								break;
							case ACTUALIZAR:
								break;
							case BORRAR:
								if(borrarAlumno(curso, pedirNombre()))
									System.out.println("Alumno borrado correctamente.");
								else
									System.err.println("Error al borrar el alumno.");
								break;
							case VOLVER:
								break;
							default:
								System.err.println("Opción no válida...");
								break;
						}
					}while(opc2 != VOLVER);
					break;
				case DAM2:
					curso = new File("DAM2");
					curso.mkdir();
					break;
				case SMR1:
					curso = new File("SMR1");
					curso.mkdir();
					break;
				case SMR2:
					curso = new File("SMR2");
					curso.mkdir();
					break;
				case SALIR:
					System.out.println("Fin del programa...");
					break;
				default:
					System.err.println("Opción no válida.");
			}
			teclado.nextLine();
			teclado.nextLine();
		}while(opc != SALIR);
		teclado.close();
	}
	
	static int menu(){
		System.out.println("\t\tCURSOS");
		System.out.println("\t\t~~~~~~");
		System.out.println("[" + DAM1 + "] - DAM1");
		System.out.println("[" + DAM2 + "] - DAM2");
		System.out.println("[" + SMR1 + "] - SMR1");
		System.out.println("[" + SMR2 + "] - SMR2");
		System.out.println("[" + SALIR + "] - Salir");
		System.out.print("\n>");
		return teclado.nextInt();
	}
	
	static int submenu(String curso){
		System.out.println("\t\tCURSO DE " + curso);
		System.out.println("\t\t~~~~~~~~~~~~~~~~~~~~");
		System.out.println("[" + NUEVO + "] - Añadir un nuevo alumno");
		System.out.println("[" + VER_TODOS + "] - Mostrar todos los alumnos");
		System.out.println("[" + VER_UNO + "] - Ver los datos de un alumno");
		System.out.println("[" + ACTUALIZAR + "] - Actualizar los datos de un alumno");
		System.out.println("[" + BORRAR + "] - Borrar un alumno");
		System.out.println("[" + VOLVER + "] - Volver");
		System.out.print("\n>");
		return teclado.nextInt();
	}
	
	static void listarAlumnos(File curso) {
		File[] alumnos = curso.listFiles();
		System.out.println("\t\tAlumnos de " + curso.getName());
		for(int i = 0; i < alumnos.length; i++)
			System.out.println(alumnos[i]);
	}
	
	static boolean crearCarpetaAlumno(File curso, String nombre) {
		boolean resultado = true;
		File dir = new File(curso, nombre);
		dir.mkdir();
		crearObservacion(dir, nombre);
		crearNotas(dir, nombre);
		crearObjeto(dir, nombre);
		return resultado;
	}
	
	/** Se creará un nuevo directorio que contendrá 3 archivos con información sobre el alumno correspondiente */
	static boolean crearObservacion(File dir, String nombre) {
		boolean resultado = true;
		File obs = new File(dir, nombre + OBSERV);
		try {
			obs.createNewFile();
		} catch (IOException e) {
			System.err.println("Error de E/S: " + e.getMessage());
			resultado = false;
		}
		return resultado;
	}
	
	static boolean crearNotas(File dir, String nombre) {
		boolean resultado = true;
		File obs = new File(dir, nombre + NOTAS);
		try {
			obs.createNewFile();
		} catch (IOException e) {
			System.err.println("Error de E/S: " + e.getMessage());
			resultado = false;
		}
		return resultado;
	}
	
	static boolean crearObjeto(File dir, String nombre) {
		boolean resultado = true;
		File obs = new File(dir, nombre + INFOR);
		try {
			obs.createNewFile();
		} catch (IOException e) {
			System.err.println("Error de E/S: " + e.getMessage());
			resultado = false;
		}
		return resultado;
	}
	
	static boolean borrarAlumno(File curso, String nombre) {
		boolean resultado = true;
		
		File dir = new File(curso, nombre);
		File[] archivos = dir.listFiles();
		for(int i = 0; i < archivos.length; i++)
			archivos[i].delete();
		
		if(!dir.delete())
			resultado = false;
		
		return resultado;
	}
	
	static void verAlumnos(File curso) {
		File[] archivos = curso.listFiles();
		for(int i = 0; i < archivos.length; i++)
			System.out.println(archivos[i].getName());
	}
	
	static boolean verAlumno(File curso, String nombre) {
		File[] archivos = curso.listFiles();
		boolean encontrado = false;
		File alumno = null;
		for(int i = 0; i < archivos.length && !encontrado; i++) {
			if(archivos[i].getName().equalsIgnoreCase(nombre)) {
				alumno = new File(archivos[i].getAbsolutePath());
				encontrado = true;
			}
		}
		encontrado = mostrarInformacion(curso, alumno);
		return encontrado;
	}
	
	/** Método que muestra el contenido dentro del fichero de texto, del de notas y del alumno */
	static boolean mostrarInformacion(File curso, File al) {
		boolean resultado = true;
		File observaciones = new File(al, al.getName() + OBSERV);
		File notas = new File(al, al.getName() + NOTAS);
		File alumno = new File(al, al.getName() + INFOR);
								
		//Lectura de observaciones
		if(observaciones.length() > 0) {
			if(leerTexto(observaciones))
				System.out.println("----------");
		}else
			System.out.println("El alumno no tiene ninguna observación de momento.");
		
		//Lectura de notas
		if(notas.length() > 0) {
			leerDatos(notas);
		}else
			System.out.println("El alumno no tiene ninguna nota de momento.");
		
		//Lectura de alumnos
		if(alumno.length() > 0) {				
			leerObjeto(alumno);
		}else
			System.out.println("El alumno no tiene ninguna información de momento.");
		
		return resultado;
	}
	
	static boolean leerTexto(File archivo) {
		boolean resultado = true;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(archivo));
			String linea = "";
			while((linea = br.readLine()) != null)
				System.out.println(linea);			
		}catch(IOException e) {
			System.err.println("Error de E/S al leer texto: " + e.getMessage());
			resultado = false;
		}finally {
			try {
				if(br != null)
					br.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el fichero de texto: " + e.getMessage());
				resultado = false;
			}
		}
		return resultado;
	}
	
	static boolean leerDatos(File archivo) {
		boolean resultado = true;
		DataInputStream dis = null;
		boolean finArchivo = false;
		try {
			dis = new DataInputStream(new FileInputStream(archivo));
			while(!finArchivo) {
				try {
					System.out.println(dis.readFloat());
				}catch(EOFException e) {
					//Fin del archivo
					finArchivo = true;
				}catch(IOException e) {
					System.err.println("Error de E/S al leer las notas: " + e.getMessage());
					resultado = false;
				}
			}		
		}catch(IOException e) {
			System.err.println("Error de E/S al leer las notas: " + e.getMessage());
			resultado = false;
		}finally {
			try {
				if(dis != null)
					dis.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el fichero de notas: " + e.getMessage());
				resultado = false;
			}
		}
		return resultado;
	}
	
	static boolean leerObjeto(File archivo) {
		boolean resultado = true;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(archivo));
			while(true) {
				Alumno a = (Alumno)ois.readObject();
				System.out.println(a);
			}	
		}catch(EOFException e) {
			//Fin archivo
		}catch(ClassNotFoundException e) {
			System.err.println("Error de clase al leer el alumno: " + e.getMessage());
			resultado = false;
		}catch(IOException e) {
			System.err.println("Error de E/S al leer el alumno: " + e.getMessage());
			resultado = false;
		}finally {
			try {
				if(ois != null)
					ois.close();
			}catch(IOException e) {
				System.err.println("Error al cerrar el fichero de información del alumno: " + e.getMessage());
				resultado = false;
			}
		}
		return resultado;
	}
	static String pedirNombre() {
		teclado.nextLine();
		System.out.print("Dime el nombre del alumno:\n>");
		return teclado.nextLine();
	}
}
