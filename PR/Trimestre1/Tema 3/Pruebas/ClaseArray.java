import java.util.Scanner;
import java.util.Locale;

class ClaseArray{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		teclado.useLocale(Locale.ENGLISH);
		teclado.useDelimiter(System.getProperty("line.separator"));
		
		Alumno[] alum = new Alumno[3];
		for (int i = 0; i < alum.length; i++)
		{
			alum[i] = new Alumno();
			System.out.println("Dame el nombre del alumno");
			alum[i].nombre = teclado.next();
			
			System.out.println("Dame el nombre del curso");
			alum[i].curso = teclado.next();
			
			System.out.println("Dame la edad del alumno");
			alum[i].edad = teclado.nextInt();
		}
		teclado.close();
		
		for (int i = 0; i < alum.length; i++)
		{
			System.out.println("\nNombre del alumno: " + alum[i].nombre);
			System.out.println("Curso del alumno: " + alum[i].curso);
			System.out.println("Edad del alumno: " + alum[i].edad);
		}
	}
}
