/**
 * Se le pasarán 2 argumentos a este programa, siendo el primero el fichero a renombrar
 * y el segundo el nuevo nombre del fichero. Se pedirá confirmación en caso de que
 * exista un archivo con el mismo nombre a renombrar.
 * */


import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Ejer3 {
	static final int SI = 1;
	static final int NO = 2;
	public static void main(String[] args) {
		if(args.length < 2) {
			System.err.println("Uso correcto del programa: Ejer3 \"<fichero1>\" \"<fichero2>\"");
			return;
		}
		
		File fich1 = new File(args[0]);
		File fich2 = new File(args[1]);
		
		//Se comprueba si el primer fichero existe
		if(!fich1.exists()) {
			System.err.println("El fichero no existe!");
			return;
		}
		
		//También se mira si ya existe un fichero con el mismo nombre a la hora de renombrar
		if(fich2.exists()) {
			if(pedirConfirmacion() == SI)
				fich2.delete();
			else {
				System.out.println("Fin del programa.");
				return;
			}
		}
		
		if(fich1.renameTo(fich2))
			System.out.println("Renombrado con éxito.");
		else
			System.out.println("Fallo al renombrar " + fich1.getName() + " a " + fich2.getName());
	}
	
	/** Se le pide al usuario que confirme si realmente desea sobreescribir un fichero con el mismo nombre */
	static int pedirConfirmacion() {
		Scanner teclado = new Scanner(System.in);
		int opc = NO;
		try {
			System.out.print("Ya existe un fichero con ese nombre. ¿Desea continuar igualmente?\n[" + SI + "]-Sí\n[" + NO + "]-No\n>");
			opc = teclado.nextInt();
		}catch(InputMismatchException e) {
			System.err.println("Se esperaba un número.");
		}finally {
			teclado.close();
		}
		
		return opc;
	}
}
