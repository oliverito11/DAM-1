import java.util.Scanner;

class Ejer3{
	public static void main(String[] args){
		int a, b, c;
		double x1, x2;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dame el valor de A: ");
		a = teclado.nextInt();
		System.out.println("Dame el valor de B: ");
		b = teclado.nextInt();
		System.out.println("Dame el valor de C: ");
		c = teclado.nextInt();
		teclado.close();
		
		double discriminante = Math.pow(b, 2) - (4*a*c);
		
		if (discriminante < 0)
			System.out.println("No existe una solucion real");
		else
		{
			x1 = (-b + Math.sqrt(discriminante))/2*a;
			x2 = (-b - Math.sqrt(discriminante))/2*a;
			System.out.println("x1: " + x1 + "\nx2: " + x2);
		}
	}
}
