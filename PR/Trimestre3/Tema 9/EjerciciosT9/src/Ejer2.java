import java.util.Stack;
import java.util.Scanner;
public class Ejer2 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Dame una frase y te dir� si es o no pal�ndromo:\n>");
		if(comprobar(teclado.nextLine()))
			System.out.println("La frase pasada es pal�ndromo");
		else
			System.err.println("La frase pasada NO es pal�ndromo");
		
		teclado.close();
	}
	
	static boolean comprobar(String f) {
		Stack<Character> pila = new Stack<Character>();

		//A�ado los caracteres a la pila
		for(int i = 0; i < f.length(); i++) {
			if(Character.isLetter(f.charAt(i))) {
				pila.push(f.charAt(i));
			}
		}
		
		//Comprobaci�n
		for(int i = 0; i < f.length(); i++) {
			if(Character.isLetter(f.charAt(i)) && pila.pop() != f.charAt(i))
				return false;
		}
		
		return true;
	}
}
