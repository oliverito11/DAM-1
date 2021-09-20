import java.util.Scanner;

class Ejer24{
	static final byte CONTADOR_INICIAL = 0;
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		int num;
		do{
			System.out.println("Dame un numero entero positivo");
			num = teclado.nextInt();
		}while(num < 0);
		teclado.close();
		
		System.out.println("\n\nCifras de " + num);
		System.out.println("\nHay " + cifras(num, CONTADOR_INICIAL) + " cifras en dicho numero");
	}
	
	/** Método que irá diviendo el número de 10 en 10 para mostrar cada cifra del número, obteniendo el resto primero */
	static int cifras(int num, int cont){
		if (num > 0){
			int resto = num % 10;
			num /= 10;
			cont = cifras(num, ++cont);
			System.out.println(resto);
		}
		return cont;
	}
}
