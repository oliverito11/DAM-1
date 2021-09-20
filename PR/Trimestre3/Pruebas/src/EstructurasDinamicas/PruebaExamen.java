package EstructurasDinamicas;

import java.util.*;
public class PruebaExamen {
	public static void main(String[] args) {
		ArrayList<Alumno> al = new ArrayList<Alumno>();
		LinkedList<Alumno> ll = new LinkedList<Alumno>();
		HashSet<Alumno> hs = new HashSet<Alumno>();
		TreeSet<Alumno> ts = new TreeSet<Alumno>();
		HashMap<Integer, Alumno> hm = new HashMap<Integer, Alumno>();
		TreeMap<Integer, Alumno> tm = new TreeMap<Integer, Alumno>();
		
		//Creación de alumnos
		Alumno a1 = new Alumno("Pepe", "DAM1", 18, 5433);
		Alumno a2 = new Alumno("Mara", "DAM2", 19, 5432);
		Alumno a3 = new Alumno("Olga", "DAM1", 23, 5123);
		Alumno a4 = new Alumno("Juan", "ASIR2", 26, 5341);
		Alumno a5 = new Alumno("Gerardo", "ASIR2", 20, 5678);
		
		//ArrayList
		System.out.println("Acciones con ArrayList:");
		al.add(a1);
		al.add(a2);
		al.add(a3);
		al.add(a4);
		al.add(a5);
		al.add(a1);
		System.out.println("Tamaño: " + al.size());
		
		Iterator<Alumno> it = al.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		al.clear();
		System.out.println("Tamaño: " + al.size());
		
		//LinkedList
		System.out.println("Acciones con LinkedList:");
		ll.addFirst(a1);
		ll.addFirst(a2);
		ll.addFirst(a3);
		ll.addFirst(a4);
		ll.addLast(a5);
		ll.addLast(a1);
		System.out.println("Tamaño: " + ll.size());
		
		it = ll.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		al.clear();
		System.out.println("Tamaño: " + al.size());
		
	}
}
