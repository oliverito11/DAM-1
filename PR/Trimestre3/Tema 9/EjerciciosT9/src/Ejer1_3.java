import java.util.Stack;
import java.util.Scanner;
import java.util.Iterator;
public class Ejer1_3 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame una frase y te la daré invertida:\n>");
		System.out.println(invertirFrase(teclado.nextLine()));
		
		teclado.close();
	}
	
	/** Recibe una frase y la invierte con el uso de un ArrayList*/
	static String invertirFrase(String frase) {
		StringBuffer str = new StringBuffer();
		Stack<Character> pila = new Stack<Character>();
		for(int i = 0; i < frase.length(); i++) {
			pila.push(frase.charAt(i));
		}
		
		while(!pila.isEmpty())
			str.append(pila.pop());
		
		/*
		Iterator it = pila.iterator();
		while(it.hasNext())
			str.append(it.next());
		*/
		return str.toString();
	}
}
