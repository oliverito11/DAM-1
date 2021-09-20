import java.util.Scanner;

class Ejer12{
	public static void main(String[] args){
		int num1, num2, num3, aux;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dame el primer numero");
		num1 = teclado.nextInt();
		System.out.println("Dame el segundo numero");
		num2 = teclado.nextInt();
		System.out.println("Dame el tercer numero");
		num3 = teclado.nextInt();
		teclado.close();
		
		if (num1 < num2)
		{
			aux = num2;
			num2 = num1;
			num1 = aux;
		}
		if (num1 < num3)
		{
			aux = num3;
			num3 = num1;
			num1 = aux;
		}
		if (num2 < num3)
		{
			aux = num3;
			num3 = num2;
			num2 = aux;
		}
		
		System.out.println(num1 + " > " + num2 + " > " + num3);
	}
}
