import java.util.Scanner;

class Ejer10{
	public static void main(String[] args){
		int limit;
		int pares = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Mostrar los pares comprendidos entre 0 y ");
		limit = teclado.nextInt();
		teclado.close();
		
		//LOS NUMEROS DELIMITADORES NO SE CUENTAN
		for(int i = 2; i < limit; i += 2)
		{
			System.out.println(i);
		}
	}
}
