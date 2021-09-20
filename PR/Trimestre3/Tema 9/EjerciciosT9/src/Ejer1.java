import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;
public class Ejer1 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame una frase y te la daré invertida:\n>");
		System.out.println(invertirFrase(teclado.nextLine()));
		
		teclado.close();
	}
	
	/** Recibe una frase y la invierte gracias al uso de una lista enlazada */
	static String invertirFrase(String frase) {
		StringBuffer str = new StringBuffer();
		LinkedList<Character> l = new LinkedList<Character>();
		for(int i = 0; i < frase.length(); i++) {
			l.addFirst(frase.charAt(i));
		}
		
		Iterator it = l.iterator();
		while(it.hasNext())
			str.append(it.next());
		
		return str.toString();
	}
}
