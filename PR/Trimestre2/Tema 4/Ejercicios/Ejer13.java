import java.util.Scanner;

class Ejer13{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("\t\t===================");
		System.out.println("\t\t|ELEVAR A POTENCIA|");
		System.out.println("\t\t===================");
		
		System.out.println("\nDime una base");
		int base = teclado.nextInt();
		System.out.println("\nDime un exponente");
		int expo = teclado.nextInt();
		teclado.close();
		
		System.out.println("El resultado de elevar " + base + " a " + expo + " es " + potencia(base, expo));
	}
	
	static int potencia(int base, int exponente){
		int pot = 1;
		for (int i = 0; i < exponente; i++)
			pot *= base;
			
		return pot;
	}
}
