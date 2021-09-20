import java.util.Scanner;

class Ejer11{
	public static void main(String[] args){
		int suma = 0;
		int impar = 0;
		int limit;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Mostrar la suma de los impares comprendidos entre 0 y");
		limit = teclado.nextInt();
		teclado.close();
		
		for (int i = 1; i < limit; i += 2)
			suma += i;
		
		System.out.println("La suma de los impares es: " + suma);
	}
}
