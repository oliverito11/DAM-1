import java.util.Scanner;

class Ejer11_2{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("\t\t======================");
		System.out.println("\t\t|TABLA DE MULTIPLICAR|");
		System.out.println("\t\t======================");
		
		for (int i = 0; i <= 10; i++){
			System.out.println("\n\n\t\tTABLA DEL " + i);
			tablaMult(i);
			teclado.nextLine();
		}
		teclado.close();
	}
	
	static void tablaMult(int num){
		for (int i = 0; i <= 10; i++)
			System.out.println(num + " x " + i + " = " + (num * i));
	}
}
