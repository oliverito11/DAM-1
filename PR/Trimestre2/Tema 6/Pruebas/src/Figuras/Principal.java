package Figuras;

import java.util.TreeSet;
import java.util.Iterator;
public class Principal {
	public static void main(String[] args) {
		TreeSet<Figura> figuras = new TreeSet<Figura>();
		figuras.add(new Circunferencia("Negro", 34.4d));
		figuras.add(new Circunferencia("Rojo", 12.1d));
		figuras.add(new Cuadrado("Azul", 2.3d));
		figuras.add(new Cuadrado("Verde", 54.34d));
		
		System.out.println("Hay un total de " + figuras.size() + " figuras guardadas.");
		
		Iterator<Figura> it = figuras.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		figuras.clear();
		System.out.println("Hay un total de " + figuras.size() + " figuras guardadas.");
	}
}
