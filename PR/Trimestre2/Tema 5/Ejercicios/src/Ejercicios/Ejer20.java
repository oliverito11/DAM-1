package Ejercicios;

//import java.util.Scanner;
public class Ejer20 {
	public static void main(String[] args){
		/*Scanner teclado = new Scanner(System.in);
		System.out.print("Dime un nombre de fichero:\n>");
		String fich = teclado.nextLine();
		teclado.close();*/
		
		if(args.length != 1) {
			System.err.println("Uso correcto: java Ejer20 <fichero>");
			return;
		}
		
		String[] nombre = args[0].split("[.]");

		if(nombre.length != 2) {
			System.err.println("El fichero tiene que tener la siguiente sintaxis: nombreFichero.extension");
			return;
		}
		else if(nombre[1].length() != 3) {
			System.err.println("El fichero tiene que tener entre 1 y 3 caracteres en la extension");
			return;			
		}
		
		System.out.println("Nombre de fichero válido");
	}
}
