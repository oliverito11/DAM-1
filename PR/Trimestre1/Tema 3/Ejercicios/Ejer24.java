import java.util.Scanner;

class Ejer24{
	public static void main(String[] args){
		int a = 0, b = 1;
		int limit;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Cuantos numeros de la serie Fibonacci quieres ver");
		limit = teclado.nextInt();
		teclado.close();
		
		for (int i = 0; i < limit; i += 2)
		{
			//Muestro 0 y 1 y luego a 0 (a) le sumo 1(b) y después a 1 (b) le sumo 0 + 1 (a)
			if(i + 2 > limit)
				System.out.print(a + " ");
			else{
				System.out.print(a + " " +  b + " ");
				a += b;
				b += a;
			}
		}
	}
}
