import java.util.Scanner;

class Ejer21{
	public static void main(String[] args){
		int producto = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dame un numero");
		int num1 = teclado.nextInt();
		System.out.println("Dame otro operando");
		int num2 = teclado.nextInt();
		teclado.close();
		
		for (int i = 0; i < Math.abs(num2); i++)
			producto += Math.abs(num1);
			
		if(!(((num1 >= 0) && (num2 >= 0)) || ((num1 < 0) && num2 < 0)))
			producto = -producto;
			
		System.out.println(num1 + " * " + num2 + " = " + producto);
	}
}
