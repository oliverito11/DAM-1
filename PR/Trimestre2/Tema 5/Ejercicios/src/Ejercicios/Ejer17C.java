package Ejercicios;

//import java.util.Scanner;
import java.util.Vector;
public class Ejer17C {

	public static void main(String[] args){
		/*Scanner teclado = new Scanner(System.in);
		System.out.print("Dame una cadena de caracteres:\n>");
		String txt = teclado.nextLine();
		teclado.close();*/
		
		if(args.length != 1) {
			System.err.println("Uso correcto: java Ejer17C \"<frase>\"");
			return;
		}
		
		estadistica(args[0].toLowerCase());
	}
	
	/** Se usará una String como estructura de datos dinámica y se comprobará qué letras se han visto ya */
	static void estadistica(String txt){
		Vector<Character> carac = new Vector<Character>();
		//Añado todos los caracteres al vector
		for (int i = 0; i < txt.length(); i++)
			carac.add(txt.charAt(i));
		
		//Paso a la comprobacion
		for (int i = 0; i < txt.length(); i++) {
			if(carac.isEmpty())
				break;
			
			int count = 0;
			while(carac.contains(txt.charAt(i))) {
				count++;
				carac.remove(carac.indexOf(txt.charAt(i)));
			}
			if(count > 0)
				System.out.println("Letra: <" + txt.charAt(i) + ">: " + count);
		}
	}
}

