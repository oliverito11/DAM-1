package EstructurasDinamicas;

import java.util.Scanner;
public class Menu {
	public static final int NUEVO = 1;
	public static final int LISTAR = 2;
	public static final int ELIMINAR = 3;
	public static final int SALIR = 4;
	private int opcion;
	private Scanner teclado = new Scanner(System.in);
	
	public void menu() {
		do {
			System.out.println("\t\tMENÚ");
			System.out.println("\t\t====");
			System.out.println("[" + NUEVO + "] - Nuevo libro.");
			System.out.println("[" + LISTAR + "] - Listar libros.");
			System.out.println("[" + ELIMINAR + "] - Eliminar un libro.");
			System.out.println("[" + SALIR + "] - Salir.");
			opcion = teclado.nextInt();
		}while(opcion < NUEVO || opcion > SALIR);
	}
	
	public int getOpcion() {
		return opcion;
	}
}
