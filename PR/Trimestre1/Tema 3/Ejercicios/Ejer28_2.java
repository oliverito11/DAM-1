import java.util.Scanner;

class Ejer28_2{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		System.out.println("Cuantas lineas de la piramide quieres visualizar");
		int limit = teclado.nextInt();
		teclado.close();
		
		for (int i = 1, numeros = 1; i <= limit; i++, numeros += 2){
			//ESPACIOS
			for (int j = i; j < limit; j++)
				System.out.print(" ");
			
			//PRIMERA PARTE
			for (int j = 1; j <= i; j++)
				System.out.print(j % 10);
			
			//SEGUNDA PARTE
			for (int j = i - 1; j > 0; j--)
				System.out.print(j % 10);
				
			//NUEVA LINEA
			System.out.println();
		}
	}
}
