import java.util.Scanner;

class Ejer6_2{
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
		if(num == 0)
			return 1;
			
		return num * factorial(num - 1);
	}
}
