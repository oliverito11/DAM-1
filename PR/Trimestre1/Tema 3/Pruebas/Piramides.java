import java.util.Scanner;

class Piramides{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dime la cantidad de lineas que quieres visualizar");
		int n = teclado.nextInt();

		//PIRAMIDE
		System.out.println("\n\n\t\tPIRAMIDE");
		for (int i = 0, asteriscos = 1; i < n; i++, asteriscos += 2)
		{
			for (int j = 1; j < n - i; j++)
				System.out.print(" ");
			
			for (int j = 0; j < asteriscos; j++)
				System.out.print("*");
			
			System.out.println();
		}
		

		//PIRAMIDE INVERTIDA
		System.out.println("\n\n\t\tPIRAMIDE INVERTIDA");
		for (int i = 0, asteriscos = (n * 2) - 1; i < n; i++, asteriscos -= 2)
		{
			for (int j = 0; j < i; j++)
				System.out.print(" ");
			
			for (int j = 0; j < asteriscos; j++)
				System.out.print("*");
			
			System.out.println();
		}
		
		
		//DIAMANTE
		System.out.println("\n\n\t\tDIAMANTE");
		
		//PRIMERA PARTE
		for (int i = 0, asteriscos = 1; i < n / 2; i++)
		{
			
		}
		
	}
}
