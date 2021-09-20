import java.util.Scanner;

class Ejer1{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("\t\t=========================");
		System.out.println("\t\t|OPERACIONES ARITMETICAS|");
		System.out.println("\t\t=========================");
		
		System.out.println("Dime un numero");
		int num1 = teclado.nextInt();
		System.out.println("Dime otro numero");
		int num2 = teclado.nextInt();
		System.out.println("Cual es la operacion a realizar deseada?(+, -, /, * o x)");
		char oper = teclado.next().charAt(0);
		teclado.close();
		
		double result = operacion(num1, num2, oper);
		if (result != -1)
			System.out.println("El resultado de " + num1 + " " + oper + " " + num2 + " = " + result);
	}
	
	static double operacion(double num1, double num2, char oper){
		double result;
		switch(oper){
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			case 'x':
			case 'X':
			case '*':
				result = num1 * num2;
				break;
			default:
				System.err.println("ERROR. Operacion incorrecta");
				result = -1;
		}
		return result;
	}
}
