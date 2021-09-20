import java.util.Scanner;

class Ejer25{
	static Scanner teclado = new Scanner(System.in);
	static int opc;
	
	static final int TABLA = 1;
	static final int PRODUCTO = 2;
	static final int COMPRENDIDOS = 3;
	static final int SALIR = 4;
	
	public static void main(String[] args){
		Menu();
	}
	
	static void Menu(){
		System.out.println("\t\t----------------");
		System.out.println("\t\t|MENU PRINCIPAL|");
		System.out.println("\t\t----------------");
		System.out.println("\t" + TABLA + ". Tabla de multiplicar");
		System.out.println("\t" + PRODUCTO + ". Producto por sumas");
		System.out.println("\t" + COMPRENDIDOS + ". Mostrar numeros comprendidos");
		System.out.println("\t" + SALIR + ". Salir\n\n");
		
		System.out.print("-> ");
		opc = teclado.nextInt();
		
		switch(opc){
			case TABLA:
				TablaMult();
				break;
			case PRODUCTO:
				ProductoSumas();
				break;
			case COMPRENDIDOS:
				ValComprendidos();
				break;
			case SALIR:
				System.out.println("Hasta otra!");
				break;
			default:
				Menu();
				break;
		}
		teclado.close();
	}
	
	static void TablaMult(){
		int num = PedirNum();
		for (int i = 0; i < 11; i++)
			System.out.println(num + " x " + i + " = " + num * i);
		
	}
	static void ProductoSumas(){
		int num1 = PedirNum();
		int num2 = PedirNum();
		int productoSuma = 0;
		for (int i = 1; i <= num2; i++)
		{
			productoSuma += num1;
		}
		System.out.println("El producto de ambos numeros hecho por sumas es: " + productoSuma);
	}
	static void ValComprendidos(){
		int num1 = PedirNum();
		int num2 = PedirNum();
		if (num1 > num2)
		{
			int aux = num2;
			num2 = num1;
			num1 = aux;
		}
		for (int i = num1 + 1; i < num2; i++)
		{
			System.out.print(i + " ");
		}
		
	}
	
	static int PedirNum(){
		System.out.println("Dame un numero");
		int numAPedir = teclado.nextInt();
		return numAPedir;
	}
}
