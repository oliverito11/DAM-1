package Ejercicios;

import java.util.Vector;
public class Ejer19 {
	public static void main(String[] args) {
		if(args.length < 1) {
			System.err.println("Uso correcto: java Ejer19 \"<frase1>\" \"<frase2>\"...");
			return;
		}
		for(int i = 0; i < args.length; i++) {
			System.out.println("\t\tFRASE Nº " + (i + 1));
			System.out.println("\t\t========");
			comprobarPalabras(args[i].toLowerCase().split("[ ]"));
		}
	}
	
	static void comprobarPalabras(String[] txt) {
		Vector<String> palabras = new Vector<String>();
		String palabrasLista = "";
		for (int i = 0; i < txt.length; i++)
			palabras.add(txt[i].toLowerCase());
		
		for (int i = 0; i < txt.length; i++) {
			if(palabras.isEmpty())
				break;
			
			int count = 0;
			while(palabras.contains(txt[i].toLowerCase())){
				count++;
				palabras.remove(palabras.indexOf(txt[i].toLowerCase()));
			}
			if(count > 0)
				palabrasLista += "Palabra: <" + txt[i].toLowerCase() + ">: " + count + "\n";
		}
		System.out.println(palabrasLista);
	}
}
