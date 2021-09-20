import java.util.Scanner;

class Ejer1 {
	public static void main(String[] args){
		int num1, num2;
		int suma = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dame un valor");
		num1 = teclado.nextInt();
		System.out.println("Dame otro valor");
		num2 = teclado.nextInt();
		teclado.close();
		
		suma = num1 + num2;
		System.out.println("La suma es: " + suma);
	}
}
