import java.util.Scanner;
public class TryCatchConScanner {
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		pedirEntero();
	}
	
	//De esta manera se está creando recursividad, hay que tener cuidado
	static void pedirEntero() {
		int entero = 0;
		try {
			entero = cogerValor();
			System.out.println("El valor es " + entero);
		}catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}finally {
			if(entero == 0)
				pedirEntero();
			teclado.close();		
		}
	}
	
	static int cogerValor() throws NumberFormatException{		
		System.out.println("Dame un valor");
		String entero = teclado.next();
		for(int i = 0; i < entero.length(); i++) {
			if(!Character.isDigit(entero.charAt(i)))
				throw new NumberFormatException("El valor " + entero + " no es un número");
		}
		return Integer.parseInt(entero);
	}
}
