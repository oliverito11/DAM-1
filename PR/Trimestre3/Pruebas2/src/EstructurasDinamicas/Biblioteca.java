package EstructurasDinamicas;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Map;
public class Biblioteca {
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		HashMap<String, Libro> biblioteca = new HashMap<String, Libro>();
		Menu menu = new Menu();
		String id;
		int opc;
		do {
			menu.menu();
			opc = menu.getOpcion();
			switch(opc) {
				case Menu.NUEVO:
					id = pedirId();
					if(!biblioteca.containsKey(id)) {
						biblioteca.put(id, pedirLibro());
						System.out.println("Libro añadido");						
					}else
						System.err.println("Ya existe un libro con ese mismo ID");
					break;
				case Menu.LISTAR:
					Iterator<Map.Entry<String, Libro>> it = biblioteca.entrySet().iterator();
					while(it.hasNext()) {
						Map.Entry<String, Libro> sig = it.next();
						System.out.println("Libro con ID: " + sig.getKey());
						System.out.println(sig.getValue());
					}
					break;
				case Menu.ELIMINAR:
					id = pedirId();
					if(biblioteca.containsKey(id)) {
						biblioteca.remove(id);
						System.out.println("Borrado completado");
					}else
						System.err.println("No existe el libro con el ID " + id);
					break;
				case Menu.SALIR:
					break;
				default:
					System.out.println("Opcion no valida");
			}
			teclado.nextLine();
		}while(opc != Menu.SALIR);
	}
	
	static String pedirId() {
		System.out.println("Dime el ID del libro");
		return teclado.nextLine();
	}
	
	static Libro pedirLibro() {
		System.out.println("Dime el nombre del libro:");
		String nombre = teclado.nextLine();
		System.out.println("Dime el autor del libro:");
		String autor = teclado.nextLine();
		System.out.println("Dime el número de páginas del libro:");
		int num = teclado.nextInt();
		return new Libro(nombre, autor, num);
	}
}

