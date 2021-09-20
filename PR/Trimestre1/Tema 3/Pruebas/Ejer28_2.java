import java.util.Scanner;

class Ejer28_2{
	public static void main(String[] args){
		int limit;
		Scanner teclado = new Scanner(System.in);
		
		do{
			System.out.println("Dime la cantidad de lineas (numero positivo) que quieres ver de la piramide");
			limit = teclado.nextInt();
		}while(limit < 0);
		teclado.close();
		
		for (int i = 1; i <= limit; i++)
		{
			for (int j = i; j < limit; j++)
				System.out.print(" ");
			
			//PARTE IZQUIERDA
			for (int j = 1; j <= i; j++)
				System.out.print(j % 10);
			
			//PARTE DERECHA
			for (int j = i - 1; j > 0; j--)
				System.out.print(j % 10);
				
			System.out.println();
		}
	}
}
