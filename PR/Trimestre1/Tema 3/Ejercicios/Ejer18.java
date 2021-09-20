import java.util.Scanner;

class Ejer18 {
	public static void main(String[] args){
		int num;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Deme un numero: ");
		num = teclado.nextInt();
		teclado.close();
		for (int i = 0; i <= 10; i++)
			System.out.println(num + " x " + i + " = " + num * i);		
	}
}
