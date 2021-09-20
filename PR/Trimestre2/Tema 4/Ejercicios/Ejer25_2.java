import java.util.Scanner;

class Ejer25_2{
	static final byte NADA = 0;
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dime a partir de que numero hacia abajo quieres encontrar un primo");
		int num = teclado.nextInt();
		teclado.close();
		
		int primo = encontrarPrimo(num - 1);
		if (primo != NADA)
			System.out.println("Se ha encontrado el numero primo " + primo);
		else
			System.out.println("No se ha podido encontrar nigun primo");
	}
	
	/** Voy iterando por todos los numeros posibles hasta llegar al 0 */
	static int encontrarPrimo(int num){
		if(primo(num, 2))
			return num;
		return encontrarPrimo(num - 1);
	}
	
	/** Compruebo si hay o no algún primo **/
	static boolean primo(int num, int divisor){
		if (divisor > num / 2)
			return true;
		else if(num % divisor == 0)
			return false;
		else
			return primo(num, divisor++);
	}
}

