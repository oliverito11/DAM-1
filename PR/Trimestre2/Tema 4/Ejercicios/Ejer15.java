import java.util.Scanner;

class Ejer15{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		char c;
		
		do{
			System.out.println("Dame una letra");
			c = teclado.nextLine().charAt(0);
		}while(!((c >= 'A' && c <= 'Z')||(c >= 'a' && c <= 'z')));
		teclado.close();
		
		System.out.println("Letra original: " + c);
		System.out.println("Letra modificada: " + conversion(c));
	}
	
	static char conversion(char c){
		if (Character.isLowerCase(c))
			return Character.toUpperCase(c);
		
		return Character.toLowerCase(c);
	}
}
