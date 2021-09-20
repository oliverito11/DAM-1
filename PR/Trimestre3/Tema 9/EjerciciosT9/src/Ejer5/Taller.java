package Ejer5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class Taller {
	static Scanner teclado = new Scanner(System.in);
	static final int CREAR = 1;
	static final int LISTAR = 2;
	static final int MOSTRAR = 3;
	static final int ELIMINAR = 4;
	static final int SALIR = 5;
	
	public static void main(String[] args) {
		int opc = 0;
		Parte parte;
		HashMap<String, Parte> mapa = new HashMap<String, Parte>();
		String matricula = "";
		do {
			opc = menu();
			teclado.nextLine();
			switch(opc) {
				case CREAR:
					//Crear un nuevo parte
					parte = new Parte(20, "Parte", 123);
					System.out.print("Dime la matrícula del coche:\n>");
					mapa.put(teclado.nextLine(), parte);
					break;
				case LISTAR:
					//Listar todos los partes
					Set<Map.Entry<String, Parte>> p = mapa.entrySet();
					for(int i = 0; i < p.size(); i++) {
						Iterator<Map.Entry<String, Parte>> it = p.iterator();
						while(it.hasNext()) {
							System.out.println(it.next().getValue());
						}
					}
					break;
				case MOSTRAR:
					//Mostrar un único parte a partir de la matrícula de un coche
					System.out.print("Dime la mátricula del coche para mostrar su parte:\n>");
					matricula = teclado.nextLine();
					if(mapa.containsKey(matricula))
						System.out.println(mapa.get(matricula));
					else
						System.err.println("No existe el coche con matrícula " + matricula);
					break;
				case ELIMINAR:
					//Eliminar un parte de un coche según su matrícula
					System.out.print("Dime la mátricula del coche para borrar su parte:\n>");
					matricula = teclado.nextLine();
					if(mapa.containsKey(matricula)) {
						mapa.remove(matricula);
						System.out.println("Borrado satisfactorio!");
					}else
						System.err.println("No existe el coche con matrícula " + matricula);
					break;
				case SALIR:
					System.out.println("Fin del programa.");
					break;
				default:
					System.err.println("Opción inválida.");	
			}
		}while(opc != SALIR);
		teclado.close();
	}
	
	static int menu() {
		System.out.println("\t\tTALLER");
		System.out.println("\t\t======");
		System.out.println("[" + CREAR + "] - Crear parte");
		System.out.println("[" + LISTAR + "] - Listar parte");
		System.out.println("[" + MOSTRAR + "] - Mostrar parte");
		System.out.println("[" + ELIMINAR + "] - Eliminar parte");
		System.out.println("[" + SALIR + "] - Salir");
		return teclado.nextInt();
	}
}
