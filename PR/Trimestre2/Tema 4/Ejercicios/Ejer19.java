import java.util.Scanner;

class Ejer19{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dime el numero a elevar");
		int num = teclado.nextInt();
		System.out.println("Dime el exponente");
		int exp = teclado.nextInt();
		teclado.close();
		
		System.out.println("El resultado de elevar " + num + " a " + exp + " es " + elevar(Math.abs(num), Math.abs(exp)));
	}
	
	static long elevar(int num, int exp){
		if(exp == 0)
			return 1;
		
		return num * elevar(num, exp - 1);
	}
}
