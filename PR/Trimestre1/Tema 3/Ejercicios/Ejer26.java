import java.util.Scanner;
class Ejer26{
	public static void main(String[] args){
		int base, expo;
		float result = 1f;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dame una base");
		base = teclado.nextInt();
		System.out.println("Dame un exponente");
		expo = teclado.nextInt();
		
		if (expo < 0){
			for (int i = 0; i < Math.abs(expo); i++)
				result *= (float)1/base;
				
			System.out.println(base + " elevado a " + expo + " es: " + result);
		}
		else{
			for (int i = 0; i < expo; i++)
				result *= base;
				
			System.out.println(base + " elevado a " + expo + " es: " + (int)result);
		}
	}
}
