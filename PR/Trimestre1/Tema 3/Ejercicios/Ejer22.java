import java.util.Scanner;

class Ejer22{
	static final int SALIDA = 999;
	
	public static void main(String[] args){
		int num;
		int sumMedia = 0, cont = 0;
		Scanner teclado = new Scanner(System.in);
		
		do{
			System.out.println("Dame valores (" + SALIDA + " para salir)");
			num = teclado.nextInt();
			if (num != SALIDA)
			{
				cont++;
				sumMedia += num;
			}
		}while(num != SALIDA);
		
		teclado.close();
		System.out.println("La media de todos los numeros es: " + sumMedia / cont);
	}
}
