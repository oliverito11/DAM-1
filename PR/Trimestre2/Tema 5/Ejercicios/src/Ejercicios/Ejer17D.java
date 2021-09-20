package Ejercicios;

//import java.util.Scanner;
import java.util.Arrays;
public class Ejer17D {

	static final int CARACTERES = 36;
	public static void main(String[] args){
		/*Scanner teclado = new Scanner(System.in);
		System.out.print("Dame una cadena de caracteres:\n>");
		String txt = teclado.nextLine();
		teclado.close();*/
		
		if(args.length != 1) {
			System.err.println("Uso correcto: java Ejer17D \"<frase>\"");
			return;
		}
		
		estadistica(args[0].toLowerCase());
	}
	
	static void estadistica(String txt){
		int[] estad = new int[CARACTERES];
		Arrays.fill(estad, 0);
		
		for (int i = 0; i < txt.length(); i++)
			if(Character.getNumericValue(txt.charAt(i)) >= 0)
				estad[Character.getNumericValue(txt.charAt(i))]++;
		
		//Mostrar los valores
		for (int i = 0; i < estad.length; i++)
			if(estad[i] > 0)
				System.out.println("Letra <" + Character.forDigit(i, CARACTERES) + ">: " + estad[i]);
	}
}
