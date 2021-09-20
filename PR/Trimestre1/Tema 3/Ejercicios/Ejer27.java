import java.util.Scanner;

class Ejer27{
	public static void main(String[] args){
		int numLineas;
		String piramide = "*";
		Scanner teclado = new Scanner(System.in);
		
		do{
			System.out.println("Dime la cantidad de lineas (numero positivo) que quieres ver de la piramide");
			numLineas = teclado.nextInt();
		}while(numLineas < 0);
		teclado.close();
		
		for (int i = 0; i < numLineas; i++)
		{
			for (int j = i; j < numLineas - 1; j++)
				System.out.print(" ");
				
			System.out.println(piramide);
			piramide += "**";
		}
	}
}
