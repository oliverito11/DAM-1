package Ejercicios;

//import java.util.Scanner;
import java.util.Vector;
public class Ejer18 {
	
	public static void main(String[] args){
		/*Scanner teclado = new Scanner(System.in);
		System.out.print("Dame una cadena:\n>");
		String txt = teclado.nextLine();
		teclado.close();*/
		
		if(args.length != 1) {
			System.err.println("Uso correcto: java Ejer18 \"<frase>\"");
			return;
		}
		
		estadisticaPalabras(args[0].toLowerCase().split("[ ]"));
	}
	
	static void estadisticaPalabras(String[] txt){
		Vector<String> palabras = new Vector<String>();
		for (int i = 0; i < txt.length; i++) {
			palabras.add(txt[i]);
		}
		
		//Comprobación
		for (int i = 0; i < txt.length; i++) {
			if(palabras.isEmpty())
				break;
			
			int count = 0;
			while(palabras.contains(txt[i])) {
				count++;
				palabras.remove(palabras.indexOf(txt[i]));
			}
			if(count > 0)
				System.out.println("Palabra <" + txt[i] + ">: " + count);
		}
	}
}
