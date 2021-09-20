import java.util.Scanner;

class Ejer9{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el mensaje a mostrar");
		String txt = teclado.next();
		System.out.println("Dime cuantas veces quieres mostrar ese mensaje");
		int veces = teclado.nextInt();
		teclado.close();
		
		mostrarMensaje(txt, veces);
	}
	
	static void mostrarMensaje(String mensaje, int cantidad){
		for (int i = 0; i < cantidad; i++)
			System.out.println(mensaje);
	}
}
