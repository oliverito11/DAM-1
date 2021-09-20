import java.util.Scanner;

class Ejer4{
	public static void main(String[] args){

		Scanner teclado = new Scanner(System.in);
		Asignatura asignatura = new Asignatura();
		
		System.out.println("Dime el nombre de la asignatura");
		asignatura.nombreAsig = teclado.next();
		System.out.println("Dime el nombre del profesor que imparte la asignatura");
		asignatura.nombreProfe = teclado.next();
		System.out.println("Dime la cantidad de horas semanales");
		asignatura.horasSemanales = teclado.nextFloat();
		System.out.println("Nota del alumno");
		asignatura.nota = teclado.nextFloat();
		teclado.close();
		
		System.out.println("El nombre de la asignatura es " + asignatura.nombreAsig + ", y el profesor que la imparte es " + asignatura.nombreProfe + ".");
		System.out.println("Se dan " + asignatura.horasSemanales + "h semanales.");
		System.out.println("La nota de este alumno es de " + asignatura.nota);
	}
}
