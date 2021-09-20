import java.util.Scanner;

class Ejer10{
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args){
		Asignatura pr = setAsignatura();
		getAsignatura(pr);
		teclado.close();
	}
	
	static Asignatura setAsignatura(){
		Asignatura asig = new Asignatura();
		System.out.println("Dime el nombre de la asignatura");
		asig.nombre = teclado.next();
		System.out.println("Dime el nombre del profesor que la imparte");
		asig.profesor = teclado.next();
		System.out.println("Dime la cantidad de horas semanales");
		asig.horas = teclado.nextInt();
		System.out.println("Dime la nota del alumno");
		asig.nota = teclado.nextInt();
		
		return asig;
	}
	
	static void getAsignatura(Asignatura asig){
		System.out.println("El nombre de la asignatura es: " + asig.nombre);
		System.out.println("El nombre del profesor que la imparte es: " + asig.profesor);
		System.out.println("La cantidad de horas semanales que se da son: " + asig.horas + "h");
		System.out.println("La nota del alumno es: " + asig.nota);
	}
}
