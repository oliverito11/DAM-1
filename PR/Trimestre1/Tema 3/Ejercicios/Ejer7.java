import java.util.Scanner;

class Ejer7
{
	public static void main(String[] args)
	{
		int num1, num2;
		int result = 0;
		char opc;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dime el primer numero: ");
		num1 = teclado.nextInt();
		System.out.println("Dime el segundo numero: ");
		num2 = teclado.nextInt();
		System.out.println("Dime el operando que quieras usar (+, -, /, *)");
		opc = teclado.next().charAt(0);
		teclado.close();
		
		switch(opc)
		{
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			default:
				System.err.println("OPCION INVALIDA");
				break;
		}
		
		System.out.println("El resultado es: " + result);
	}
}
