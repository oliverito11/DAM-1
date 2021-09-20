import java.util.Scanner;

class Ejer4{
	public static void main(String[] atgs){
		String nAsig, nProfe; 
		float horas, not;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dime el nombre de la asignatura");
		nAsig = teclado.next();
		System.out.println("Dime el nombre del profesor que imparte la asignatura");
		nProfe = teclado.next();
		System.out.println("Dime la cantidad de horas semanales");
		horas = teclado.nextFloat();
		System.out.println("Nota del alumno");
		not = teclado.nextFloat();
		teclado.close();
		
		Asignatura asig = new Asignatura(nAsig, nProfe, horas, not);
		
		System.out.println(asig.toString());
	}
}
