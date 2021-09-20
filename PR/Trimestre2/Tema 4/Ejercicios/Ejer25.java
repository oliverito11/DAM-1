import java.util.Scanner;

class Ejer25{
	static final byte NADA = 0;
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dime a partir de que numero hacia abajo quieres encontrar un primo");
		int num = teclado.nextInt();
		teclado.close();
		
		int primo = encontrarPrimo(num);
		if (primo != NADA)
			System.out.println("Se ha encontrado el numero primo " + primo);
		else
			System.out.println("No se ha podido encontrar nigun primo");
	}
	
	/** Voy iterando por todos los numeros posibles hasta llegar al 0 */
	static int encontrarPrimo(int num){
		for (int i = num - 1; i > 0; i--){
			if (primo(i))
				return i;
		}
		return NADA;
	}
	
	/** Compruebo si hay o no algún primo **/
	static boolean primo(int num){
		for (int i = 2; i <= num / 2; i++){
			if (num % i == 0){
				return false;
			}
		}	
		return true;
	}
}
