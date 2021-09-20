import java.util.Scanner;

class Ejer13{
	public static void main(String[] args){
		int num;
		int factorial = 1;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dame un numero y te dare su factorial");
		num = teclado.nextInt();
		teclado.close();
		
		for (int i = num; i > 1; i--)
			factorial *= i;
			
		System.out.println("El factorial de dicho numero es: " + factorial);
	}
}
