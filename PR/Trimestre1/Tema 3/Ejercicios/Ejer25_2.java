import java.util.Scanner;

class Ejer25_2{
	static Scanner teclado = new Scanner(System.in);
	static int opc;
	
	static final int TABLA = 1;
	static final int PRODUCTO = 2;
	static final int COMPRENDIDOS = 3;
	static final int SALIR = 4;
	
	public static void main(String[] args){
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
				System.out.println("Dame un numero");
				int num1 = teclado.nextInt();
				
				//MUESTRO SU TABLA DE MULTIPLICAR
				for (int i = 0; i < 11; i++)
					System.out.println(num1 + " x " + i + " = " + num1 * i);
				break;
			case PRODUCTO:
				System.out.println("Dame un numero");
				num1 = teclado.nextInt();
				System.out.println("Dame otro numero");
				int num2 = teclado.nextInt();
				
				//REALIZO EL PRODUCTO DE AMBOS NÚMEROS MEDIANTE SUMAS
				int productoSuma = 0;
				for (int i = 1; i <= Math.abs(num2); i++)
					productoSuma += Math.abs(num1);
				
				//COMPRUEBO SI ES NEGATIVO O NO EL NUMERO ITNRODUCIDO
				if(!(((num1 >= 0) && (num2 >= 0)) || (num1 < 0) && (num2 < 0)))
					productoSuma = -productoSuma;
				
				System.out.println("El producto de " + num1 + " y " + num2 + " es: " + productoSuma);
				break;
			case COMPRENDIDOS:
				System.out.println("Dame un numero");
				num1 = teclado.nextInt();
				System.out.println("Dame otro numero");
				num2 = teclado.nextInt();
				
				//ME ASEGURO DE QUE num1 ES MAYOR
				if (num1 > num2){
					int aux = num2;
					num2 = num1;
					num1 = aux;
				}
				
				//MUESTRO LOS VALORES COMPRENDIDOS
				for (int i = num1 + 1; i < num2; i++)
					System.out.print(i + " ");
				break;
			case SALIR:
				System.out.println("Hasta otra!");
				break;
			default:
				System.err.println("ERROR: Opcion incorrecta");
				break;
		}
		teclado.close();
	}
}
