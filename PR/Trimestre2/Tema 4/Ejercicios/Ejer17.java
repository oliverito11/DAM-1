import java.util.Scanner;

class Raices{
	double x1, x2;
}

class Ejer17{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dime el valor de A");
		int a = teclado.nextInt();
		System.out.println("Dime el valor de B");
		int b = teclado.nextInt();
		System.out.println("Dime el valor de C");
		int c = teclado.nextInt();
		
		Raices r = ecuacion(a, b, c);
		
		if (r.x1 <= 0 && r.x2 <= 0)
			System.out.println("No existe una solucion real");
		else{
			System.out.println("La primera raiz es: " + r.x1);
			System.out.println("La segudna raiz es: " + r.x2);
		}
	}
	
	/** Calculo de la raíz de segundo grado con los 3 parametros necesarios (a, b, c) */
	static Raices ecuacion(int a, int b, int c){
		Raices r = new Raices();
		double discri = Math.pow(b, 2) - (4 * a * c);
		
		if (discri > 0){
			r.x1 = Math.sqrt(Math.pow(b, 2) + discri);
			r.x2 = Math.sqrt(Math.pow(b, 2) - discri);
		}
		
		return r;
	}
}
