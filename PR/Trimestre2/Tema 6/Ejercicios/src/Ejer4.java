/**
 * Se le pasan 1 o 2 argumentos al programa, siendo estos la ruta y/o la orden -r
 * para borrar un archivo o si se usa la orden dicha previamente, un directorio
 * y todo su contenido. 
 * */
import java.io.File;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Ejer4 {
	static final int SI = 1;
	static final int NO= 2;
	static final String BORRAR_DIR = "-r";
	public static void main(String[] args) {
		if(args.length < 1 || args.length > 2) {
			System.err.println("Uso correcto del programa: java Ejer4  [-r] \"<ruta_fichero>\"");
			return;
		}
		
		//Si se pasa un argumento se comprueba que es un fichero existente y no es un directorio
		if(args.length == 1)
			borrarArch(args[0]);
		//En caso de que no se haya cumplido la condición anterior, se confirma que se han pasado dos argumentos sí o sí
		else if(args[0].equals(BORRAR_DIR))
			borrarDir(args[1]);
		else
			System.err.println("Se ha invocado mal el programa");
			
		System.out.println("Fin del programa.");
	}
	
	/** Borrado de archivos */
	static void borrarArch(String fich) {
		File arch = new File(fich);
		if(!arch.exists()) {
			System.err.println("El fichero <" + arch.getName() + "> no existe.");
		}else if(arch.isDirectory()) {
			System.err.println("El fichero <" + arch.getName() + "> es un directorio. Use -r para borrar un directorio y su contenido");
		}else {
			if(confirmacion()) {
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
		}else if(confirmacion()){
			File[] archivos = directorio.listFiles();
			for(int i = 0; i < archivos.length; i++) {
				if(archivos[i].isDirectory())
					borrarDir(archivos[i].getPath());
				else if(!archivos[i].delete())
					System.out.println("No se pudo borrar el fichero <" + archivos[i] + ">");
				
			}
			directorio.delete();
			System.out.println("Borrado completado!");
		}
	}
	
	/** Se le pide al usuario confirmación para borrar los archivos */
	static boolean confirmacion() {
		Scanner teclado = new Scanner(System.in);
		int opc = NO;
		try {
			System.out.print("¿Está usted seguro?\n[" + SI + "]-Sí\n[" + NO + "]-No\n>");
			opc = teclado.nextInt();			
		}catch(InputMismatchException e) {
			System.err.println("Se esperaba un número.");
		}finally {
			teclado.close();
		}
		
		if(opc == NO)
			return false;
		
		return true;
	}
}
