package EstructurasDinamicas;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEjemplo {
	public static void main(String[] args) {
		Alumno a1 = new Alumno("Alumno1", "Curso1", 18, 1234);
		Alumno a2 = new Alumno("Alumno2", "Curso2", 20, 2345);
		Alumno a3 = new Alumno("Alumno3", "Curso3", 19, 6789);
		Alumno a4 = new Alumno("Alumno4", "Curso4", 22, 1597);
		
		//Creación de la estructura de datos
		ArrayList<Alumno> clase = new ArrayList<Alumno>();

		//Insercción de datos
		clase.add(a1);
		clase.add(a2);
		clase.add(a3);
		clase.add(a4);
		
		//Prueba de insercción de un duplicado
		clase.add(a3);
		
		//Tamaño de la estructura de datos
		System.out.println("La estructura tiene " + clase.size() + " elementos.");
		
		//Iterador
		Iterator<Alumno> it = clase.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		clase.clear();
		System.out.println("La estructura tiene " + clase.size() + " elementos.");
	}
}
