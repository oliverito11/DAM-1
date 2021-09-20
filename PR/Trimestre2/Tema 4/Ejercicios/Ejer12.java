import java.util.Scanner;

class Ejer12{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("\t\t====================");
		System.out.println("\t\t|PRODUCTO POR SUMAS|");
		System.out.println("\t\t====================");
		
		System.out.println("\nDime un numero");
		int num1 = teclado.nextInt();
		System.out.println("\nDime otro numero");
		int num2 = teclado.nextInt();
		teclado.close();
		
		System.out.println("\n" + num1 + " x " + num2 + " = " + producto(num1, num2));
	}
	
	static int producto(int num1, int num2){
		int pro = 0;
		for (int i = 0; i < num2; i++)
			pro += num1;
			
		return pro;
	}
}
