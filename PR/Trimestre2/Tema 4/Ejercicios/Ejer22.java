import java.util.Scanner;

class Circunferencia{
	double longitud, area;
}

class Ejer22{
	public static void main(String[] args){
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Dime el radio de la circunferencia");
		int r = teclado.nextInt();
		teclado.close();
		
		Circunferencia circ = medidas(r);
		System.out.println("La longitud de la circunferencia es " + circ.longitud + " y el area es " + circ.area);
	}
	
	static Circunferencia medidas(int r){
		Circunferencia c = new Circunferencia();
		c.longitud = 2 * Math.PI * r;
		c.area = Math.PI * Math.pow(r, 2);
		return c;
	}
}
