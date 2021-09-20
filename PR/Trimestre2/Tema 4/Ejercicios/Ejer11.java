import java.util.Scanner;

class Ejer11{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("\t\t======================");
		System.out.println("\t\t|TABLA DE MULTIPLICAR|");
		System.out.println("\t\t======================");
		
		System.out.println("\nDime de que numero quieres ver su tabla de multiplicar");
		int num = teclado.nextInt();
		teclado.close();
		
		System.out.println("\n");
		tablaMult(num);
	}
	
	static void tablaMult(int num){
		for (int i = 0; i <= 10; i++)
			System.out.println(num + " x " + i + " = " + (num * i));
	}
}
