import java.util.Scanner;

class Circunferencia{
	double longitud, area;
}

class TiposDevueltos{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		System.out.println("Dame el radio de la circunferencia");
		double radio = teclado.nextDouble();
		
		Circunferencia c = medidas(radio);
		System.out.println("La longitud de la circunferencia es " + c.longitud);
		System.out.println("El area de la circunferencia es " + c.area);
	}
	
	static Circunferencia medidas(double r){
		Circunferencia c = new Circunferencia();
		c.longitud = 2 * Math.PI * r;
		c.area = Math.PI * Math.pow(r, 2);
		return c;
	}
}
