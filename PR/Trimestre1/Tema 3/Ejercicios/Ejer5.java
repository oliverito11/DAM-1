import java.util.Scanner;

class Ejer5{
	public static void main(String[] args){
		float notaT, notaP, notaMin, notaTot;
		boolean suspenso;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dime la nota sacada en teoria");
		notaT = teclado.nextFloat();
		
		if (notaT < 5)
		{
			System.out.println("Has suspendido!");
		}
		else
		{
			System.out.println("Dime la nota sacada en practica");
			notaP = teclado.nextFloat();
			notaTot = (notaT * 70 + notaP * 30) / 100;
			System.out.println("La nota final es: " + notaTot);
		}
		teclado.close();
	}
}
