import java.util.Scanner;

class Ejer28{
	public static void main(String[] args){
		int limit;
		String izquierda = "", derecha = "";
		Scanner teclado = new Scanner(System.in);
		
		do{
			System.out.println("Dime la cantidad de lineas (numero positivo) que quieres ver de la piramide");
			limit = teclado.nextInt();
		}while(limit < 0);
		teclado.close();
		
		//CUANDO SON NÚMEROS MAYORES QUE 10 SE DESCOLOCAN
		for (int i = 1; i <= limit; i++)
		{
			for (int j = i; j < limit; j++)
				System.out.print(" ");
			
			System.out.println(izquierda + Integer.toString(i) + derecha);
			izquierda += Integer.toString(i);			// 3 2 1
			derecha = Integer.toString(i) + derecha;	// 1 2 3
		}
				
	}
}
