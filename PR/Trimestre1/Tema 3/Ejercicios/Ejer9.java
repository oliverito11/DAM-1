import java.util.Scanner;

class Ejer9 {
	public static void main(String[] args){
		int num1, num2;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dame un primer valor");
		num1 = teclado.nextInt();
		System.out.println("Dame un segundo valor");
		num2 = teclado.nextInt();
		teclado.close();
		
		if (num1 == num2)
			System.out.println("Ambos numeros son iguales");
		else if (num1 > num2)
			System.out.println(num1 + " es mayor que " + num2);
		else
			System.out.println(num2 + " es mayor que " + num1);			
	}
}
