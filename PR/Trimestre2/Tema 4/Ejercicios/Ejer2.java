import java.util.Scanner;

class Ejer2{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dame el radio de una circunferencia");
		double r = Math.abs(teclado.nextDouble());
		teclado.close();
		
		System.out.println("\n---------------------------------------------------");
		
		double lng = longitud(r);
		System.out.println("\nLa longitud de la circunferencia es: " + lng);
		double are = area(r);
		System.out.println("\nEl area de la circunferencia es: " + are);
	}
	
	static double longitud(double r){
		return 2 * Math.PI + r;
	}
	
	static double area(double r){
		return Math.PI * Math.pow(r, 2);
	}
}
