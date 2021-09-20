import java.util.Scanner;

class Ejer4{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("\t\t===============");
		System.out.println("\t\t|NUMERO MAXIMO (3 VALORES)|");
		System.out.println("\t\t===============");
		int num1, num2, num3;
		do{
			System.out.println("Dime un numero");
			num1 = teclado.nextInt();
			System.out.println("Dime otro numero");
			num2 = teclado.nextInt();
			System.out.println("Dime otro numero");
			num3 = teclado.nextInt();
		}while(num1 < 0 || num2 < 0 || num3 < 0);
		teclado.close();
		
		System.out.println("El numero mas grande de los tres es: " + maximo(maximo(num1, num2), num3));
	}
	
	static int maximo(int num1, int num2){
		return num1 = num1 >= num2 ? num1 : num2;
	}
}
