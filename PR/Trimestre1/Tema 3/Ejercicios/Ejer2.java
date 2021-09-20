import java.util.Scanner;

class Ejer2{
	public static void main(String[] args){
		final float PI = 3.1415f;
		float rad;
		double lng, area;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dame el radio de una circunferencia");
		rad = teclado.nextFloat();
		teclado.close();
		
		lng = rad * 2;
		area = PI * lng;
		
		System.out.println("La longitud del circulo es: " + lng + " y el area es: " + area);
	}
}
