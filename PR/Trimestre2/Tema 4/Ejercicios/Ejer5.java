import java.util.Scanner;

class Ejer5{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("\t\t================");
		System.out.println("\t\t|ORDENADOS O NO|");
		System.out.println("\t\t================");
		
		System.out.println("\nDime un numero");
		int num1 = teclado.nextInt();
		System.out.println("\nDime otro numero");
		int num2 = teclado.nextInt();
		System.out.println("\nDime otro numero");
		int num3 = teclado.nextInt();
		teclado.close();
		
		if (isOrdenado(num1, num2, num3))
			System.out.println("La secuencia de numeros SI esta ordenada de mayor a menor");
		else
			System.out.println("La secuencia de numeros NO esta ordenada de mayor a menor");
	}
	
	static boolean isOrdenado(int num1, int num2, int num3){
		//~ if (num1 < num2)
			//~ return false;
		//~ else if(num1 < num3)
			//~ return false;
		boolean orden;
		return orden = num1 < num2 ? num1 <= num3 ? false : false : true;
	}
}
