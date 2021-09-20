import java.util.Scanner;

class Ejer16{
	public static void main(String[] args){
		int num;
		boolean esPrimo = true;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dame un numero");
		num = teclado.nextInt();
		teclado.close();
		
		for (int i = 2; i < num; i++)
		{
			if(num % i == 0){
				esPrimo = false;
				break;
			}
		}
		
		if(esPrimo)
			System.out.println("El numero ES PRIMO");
		else
			System.out.println("El numero NO ES PRIMO");
	}
}
