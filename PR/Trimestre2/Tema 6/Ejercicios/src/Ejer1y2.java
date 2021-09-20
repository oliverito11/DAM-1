/**
 * Programa que recibe como argumentos 1 o 2 valores y se mostrará el contenido
 * dentro de una carpeta con o sin recursividad.
 * */
import java.io.File;
import java.io.IOException;
public class Ejer1y2 {
	static final String RECURSIVO = "-r";
	public static void main(String[] args) {
		if(args.length > 2) {
			System.out.println("Uso correcto del programa: java Ejer1 \"[ruta_absoluta]\" [-r]");
			return;
		}
		
		//Si no se pasan argumentos, se mostrará el directorio actual
		File dir;
		//Si se pasa un argumento, hay que comprobar si es una ruta o una opción
		if(args.length == 1) {
			if(args[0].toLowerCase().equals(RECURSIVO)) {
				dir = new File(".");
				mostrarContenidoRecursivo(dir.listFiles());
			}
			else{
				dir = new File(args[0]);
				if(!dir.exists()) {
					System.err.println("El directorio no existe!");
					return;
				}
				mostrarContenido(dir.listFiles());
			}
		}
		//Se comprueba qué se ha pasado primero, si la ruta o la opción
		else if(args.length == 2) {
			if(args[0].toLowerCase().equals(RECURSIVO))
				dir = new File(args[1]);
			else
				dir = new File(args[0]);
			
			if(!dir.exists()) {
				System.err.println("El directorio no existe!");
				return;
			}
			mostrarContenidoRecursivo(dir.listFiles());
		}
		else {
			dir = new File(".");
			mostrarContenido(dir.listFiles());			
		}

	}
	
	static void mostrarContenido(File[] arch) {
		for(int i = 0; i < arch.length; i++) {
			if(arch[i].isDirectory())
				System.out.println(arch[i].getName() + "\t-\t<DIR>");
			else
				System.out.println(arch[i].getName() + "\t-\t" + arch[i].length());
		}
	}
	
	static void mostrarContenidoRecursivo(File[] arch) {
		for(int i = 0; i < arch.length; i++) {
			if(arch[i].isDirectory()) {
				System.out.println(arch[i].getName() + "\t-\t<DIR>");
				System.out.println("<--------CONTENIDO------>");
				mostrarContenidoRecursivo(arch[i].listFiles());
			}
			else
				System.out.println(arch[i].getName() + "\t-\t" + arch[i].length());
		}
		
		System.out.println("-------------------------");
	}
}
