import java.util.Scanner;

class Ejer3{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("\t\t===============");
		System.out.println("\t\t|NUMERO MAXIMO (2 VALORES)|");
		System.out.println("\t\t===============");
		int num1, num2;
		do{
			System.out.println("Dime un numero");
			num1 = teclado.nextInt();
			
			System.out.println("Dime otro numero");
			num2 = teclado.nextInt();
		}while(num1 < 0 || num2 < 0);
		teclado.close();
		
		System.out.println("El numero mas grande de los dos es: " + maximo(num1, num2));
	}
	
	static int maximo(int num1, int num2){
		if (num1 >= num2)
			return num1;
			
		return num2;
		//return num1 = num1 >= num2 ? num1 : num2;
	}
}
