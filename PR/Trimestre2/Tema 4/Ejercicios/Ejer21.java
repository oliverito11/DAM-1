import java.util.Scanner;

class Ejer21{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		int num;
		do{
			System.out.println("Dime el numero de la secuencia de Fibonacci que quieres ver");
			num = teclado.nextInt();
		}while(num < 1);
		teclado.close();
		
		System.out.println("El numero en la posicion " + num + " de la serie de Fibonacci es " + fibonacci(num - 1));
	}
	
	static int fibonacci(int n){
		//Casos base
		if(n == 0)
			return n;
		else if(n == 1)
			return n;
		
		//Recursividad
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
