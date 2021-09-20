import java.util.Scanner;

class Ejer16{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		int[] x = new int[2];
		int[] y = new int[2];
		
		/** Pido los valores de la esquina superior izquierda */
		System.out.println("Dime la coordenada Y inicial");
		y[0] = teclado.nextInt();
		System.out.println("Dime la coordenada X inicial");
		x[0] = teclado.nextInt();
		
		/** Pido los valores de la esquina inferior derecha */
		System.out.println("Dime la coordenada Y final");
		y[1] = teclado.nextInt();
		System.out.println("Dime la coordenada X final");
		x[1] = teclado.nextInt();
		teclado.close();
		
		cuadro(x, y);
	}
	
	/*
	 * Tengo que considerar que la primera y ultima linea tienen que
	 * dibujarse todos los caracteres, mientras que en las demas lineas
	 * solo he de dibujar el primero y ulimo caracter
	 * */
	static void cuadro(int[] x, int[] y){
		int difX = x[1] - x[0];
		int difY = y[1] - y[0];
		
		//SALTOS DE LINEA PARA LLEGAR A LA COORDENADA Y INICIAL
		for (int i = 1; i < y[0]; i++)
			System.out.println();
		
		//DIBUJO EL CUADRO
		for (int i = 0; i < difY; i++)
		{
			//ESPACIOS PARA LLEGAR A LA COORDENADA X
			for (int j = 1; j < x[0]; j++)
				System.out.print(" ");
				
			if (i == 0 || i == difY - 1){
				//ASTERISCOS DE LA PRIMERA Y ULTIMA LINEA
				for (int j = 0; j < difX; j++)
					System.out.print("*");
			}
			else{
				
				//DEMAS LINEAS
				System.out.print("*");
				for (int j = 2; j < difX; j++)
					System.out.print(" ");
				System.out.print("*");
			}
			
			//NUEVA LINEA
			System.out.println();
		}
	}
}
