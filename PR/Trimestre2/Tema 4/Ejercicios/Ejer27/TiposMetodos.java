import java.util.Scanner;

class Bicicleta{
	String color = "Negro";
	
	public void cambiarColor(String nuevoColor){
		color = nuevoColor;
	}
}

class TiposMetodos{
	public static void main(String[] args){
		System.out.println("===================");
		System.out.println("METODO DE INSTANCIA");
		System.out.println("===================");
		
		Bicicleta bici = new Bicicleta();
		System.out.println("El color de la bici es " + bici.color);
		bici.cambiarColor("Roja");
		System.out.println("El color de la bici es " + bici.color);
		
		System.out.println("\n\n");
		
		System.out.println("===============");
		System.out.println("METODO ESTATICO");
		System.out.println("===============");
		
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Dime un valor");
		int num1 = teclado.nextInt();
		System.out.println("Dime otro valor");
		int num2 = teclado.nextInt();
		
		System.out.println("La suma de " + num1 + " y " + num2 + " es " + suma(num1, num2));
	}
	
	static int suma(int num1, int num2){
		return num1 + num2;
	}
}
