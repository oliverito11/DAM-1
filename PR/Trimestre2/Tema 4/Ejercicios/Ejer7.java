import java.util.Scanner;

class Ejer7{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("\t\t==============");
		System.out.println("\t\t|NUMERO PRIMO|");
		System.out.println("\t\t==============");
		
		System.out.println("\nDime un numero");
		int num = teclado.nextInt();
		teclado.close();
		if (esPrimo(num))
			System.out.println("El numero SI ES PRIMO");
		else
			System.out.println("El numero NO ES PRIMO");
	}
	
	static boolean esPrimo(int num){
		for (int i = 2; i < num / 2; i++){
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
