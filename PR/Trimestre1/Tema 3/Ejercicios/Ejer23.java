import java.util.Scanner;

class Ejer23{
	public static void main(String[] args){
		int suma = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dame un numero");
		int num = teclado.nextInt();
		teclado.close();
		
		for (int i = 1; i <= num / 2; i++)
		{
			if (num % i == 0)
				suma += i;
		}
		
		if (suma == num)
			System.out.println("EL NUMERO ES PERFECTO");
		else
			System.out.println("EL NUMERO NO ES PERFECTO");
	}
}
