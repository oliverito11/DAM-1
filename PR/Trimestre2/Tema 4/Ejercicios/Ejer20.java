import java.util.Scanner;

class Ejer20{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dime el primer numero");
		int a = teclado.nextInt();
		System.out.println("Dime el segundo numero");
		int b = teclado.nextInt();
		teclado.close();
		
		System.out.println("\nEl maximo comun divisor de " + a + " y " + b + " es " + mcd(a, b));
	}
	
	static int mcd(int a, int b){
		if(b == 0)
			return a;
			
		return mcd(b, a % b);
	}
}
