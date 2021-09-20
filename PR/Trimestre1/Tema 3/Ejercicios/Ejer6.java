import java.util.Scanner;

class Ejer6{
	public static void main(String[] args){
		float nota;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dime la nota: ");
		nota = teclado.nextFloat();
		teclado.close();
		
		if(nota < 5)
			System.out.println("Suspenso");
		else if (nota >= 5 && nota < 7)
			System.out.println("Aprobado");
		else if (nota >= 7 && nota < 9)
			System.out.println("Notable");
		else if (nota >= 9 && nota < 10)
			System.out.println("Sobresaliente");
		else if (nota == 10)
			System.out.println("Matricula de honor");
		else
			System.out.println("Valor incorrecto");
	}
}
