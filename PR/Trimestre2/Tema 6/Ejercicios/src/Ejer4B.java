/**
 * Se le pasan 1 o 2 argumentos al programa, siendo estos la ruta y/o la orden -r
 * para borrar un archivo o si se usa la orden dicha previamente, un directorio
 * y todo su contenido. 
 * */
import java.io.File;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Ejer4B {
	static final char SI = '1';
	static final char NO= '2';
	static final String BORRAR_DIR = "-r";
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		switch(args.length) {
			case 1:
				//Si se pasa un argumento se comprueba que es un fichero existente y no es un directorio
				borrarArch(args[0]);
				break;
			case 2:
				//Si se pasan 2 argumentos, se comprueba que el primero sea la opción "-r"
				if(args[0].equals(BORRAR_DIR)) {
					borrarDir(args[1]);
				}else {
					System.err.println("Uso correcto del programa: java Ejer4B  [-r] \"<fichero o directorio>\"");
					break;
				}
				break;
			default:
				System.err.println("Uso correcto del programa: java Ejer4B  [-r] \"<fichero o directorio>\"");
				break;
		}
		
		teclado.close();
	}
	
	/** Borrado de archivos */
	static void borrarArch(String fich) {
		File arch = new File(fich);
		if(!arch.exists()) {
			System.err.println("El fichero <" + arch.getName() + "> no existe.");
		}else if(arch.isDirectory()) {
			System.err.println("El fichero <" + arch.getName() + "> es un directorio. Use -r para borrar un directorio y su contenido");
		}else {
			System.out.println("<" + arch.getName() + ">");
			if(confirmacion()) {
				System.out.println("<" + arch.getName() + ">");
				if(arch.delete())
					System.out.println("Borrado con éxito!");
				else
					System.out.println("Se ha producido un error al borrar el fichero <" + arch.getName() + ">");				
			}
		}
	}
	
	/** Borrado de directorios */
	static void borrarDir(String dir) {
		File directorio = new File(dir);
		if(!directorio.exists()) {
			System.err.println("El directorio <" + directorio + "> no existe.");
		}else if(directorio.isFile()) {
			System.err.println("El archivo <" + directorio.getName() + "> es un archivo. No use -r para archivos normales.");
		}else {
			File[] archivos = directorio.listFiles();
			for(int i = 0; i < archivos.length; i++) {
				if(archivos[i].isDirectory())
					borrarDir(archivos[i].getPath());
				else if(archivos[i].isFile())
					borrarArch(archivos[i].getPath());				
			}
			//Directorio padre
			System.out.println("<" + directorio.getName() + ">");
			if(confirmacion())
				borrarDir(directorio.getPath());
			System.out.println("Borrado completado!");
		}
	}
	
	/** Se le pide al usuario confirmación para borrar los archivos */
	static boolean confirmacion() {
		char opc = NO;
		do {
			System.out.print("¿Está usted seguro que desea borrar este archivo?\n[" + SI + "]-Sí\n[" + NO + "]-No\n>");
			opc = teclado.next().charAt(0);			
		}while(opc != SI && opc != NO);
		
		if(opc == NO)
			return false;
		
		return true;
	}
}
