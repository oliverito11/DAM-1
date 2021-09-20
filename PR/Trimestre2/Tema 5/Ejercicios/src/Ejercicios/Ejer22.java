package Ejercicios;

//import java.util.Scanner;
public class Ejer22 {
	public static void main(String[] args) {
		/*Scanner teclado = new Scanner(System.in);
		System.out.print("Dime una direccion IP:\n>");
		String ip = teclado.nextLine();
		teclado.close();*/
		
		if(args.length != 1) {
			System.err.println("Uso correcto: java Ejer22C <IP>");
			return;
		}
		
		if(comprobarIp(args[0]))
			System.out.println("Direccion IP correcta.");
		else
			System.err.println("Direccion IP invalida.");
	}
	
	/** Una IP tiene que tener 4 partes, cada una con numeros desde el 0 hasta el 255 */
	static boolean comprobarIp(String ip) {
		String[] divisiones = ip.split("[.]");
		
		//Se comprueba si son 4 octetos
		if(divisiones.length != 4)
			return false;
		
		try {
			//Se comprueba si son en un rango valido
			for(int i = 0; i < divisiones.length; i++) {
				int num = Integer.parseInt(divisiones[i]);
				if(num < 0 || num > 255)
					return false;
			}			
		}catch(NumberFormatException e) {
			System.err.println("Alguno de los octetos no es un entero");
			return false;
		}
		
		return true;
	}
}
