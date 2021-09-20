import java.util.Scanner;

class Ejer6{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("\t\t========================");
		System.out.println("\t\t|FACTORIAL DE UN NUMERO|");
		System.out.println("\t\t========================");
		
		System.out.println("\nDime un numero");
		int num = teclado.nextInt();
		teclado.close();
		
		int fact = factorial(num);
		System.out.println("El factorial de " + num + " es = " + fact);		
	}
	
	static int factorial(int num){
		int fact = 1;
		for (int i = 1; i <= num; i++)
			fact *= i;
		return fact;
	}
}
