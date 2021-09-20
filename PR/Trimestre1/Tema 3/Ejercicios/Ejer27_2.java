import java.util.Scanner;
class Ejer27_2{
	public static void main(String[] args){
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Cuantas lineas de la piramide quieres ver");
		int limit = teclado.nextInt();
		teclado.close();
		
		for (int i = 1, asteriscos = 1; i <= limit; i++, asteriscos += 2){
			//ESPACIOS
			for (int j = i; j < limit; j++)
				System.out.print(" ");
			
			//ASTERISCOS
			for (int j = 0; j < asteriscos; j++)
				System.out.print("*");
			
			//NUEVA LINEA
			System.out.println();
		}
	}
}
