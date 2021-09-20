import java.util.Vector;
import java.util.Scanner;
public class RepasoStrings {
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Dime una frase:\n>");
		String frase = teclado.nextLine();
		
		mostrarEstadisticaLetras(frase);
	}
	
	static void mostrarEstadisticaLetras(String frase) {
		Vector<Character> letras = new Vector<Character>();
		Vector<Integer> frecuencia = new Vector<Integer>();
		for(int i = 0; i < frase.length(); i++) {
			if(letras.contains(frase.charAt(i)))
				frecuencia.set(letras.indexOf(frase.charAt(i)), frecuencia.elementAt(letras.indexOf(frase.charAt(i))) + 1);
			else {
				letras.add(frase.charAt(i));
				frecuencia.add(1);
			}
		}
		
		for(int i = 0; i < letras.size(); i++) {
			System.out.println("Letra <" + letras.elementAt(i) + ">. Frecuencia: " + frecuencia.elementAt(i));
		}
	}
}
