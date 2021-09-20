import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
public class Ejer1_2 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame una frase y te la daré invertida:\n>");
		System.out.println(invertirFrase(teclado.nextLine()));
		
		teclado.close();
	}
	
	/** Recibe una frase y la invierte con el uso de un ArrayList*/
	static String invertirFrase(String frase) {
		StringBuffer str = new StringBuffer();
		ArrayList<Character> a = new ArrayList<Character>();
		for(int i = 0; i < frase.length(); i++) {
			a.add(a.size() - i, frase.charAt(i));
		}
		
		Iterator it = a.iterator();
		while(it.hasNext())
			str.append(it.next());
		
		return str.toString();
	}
}
