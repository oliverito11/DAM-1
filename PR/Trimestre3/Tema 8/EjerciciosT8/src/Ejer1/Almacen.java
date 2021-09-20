package Ejer1;

import java.util.Vector;
public class Almacen {
	public static void main(String[] args) {
		//Primera prueba
		Vector<Producto> p = new Vector<Producto>();
		p.add(new Producto("Lapiz", 9.4f, 1));
		p.add(new Producto("Goma", 5.4f, 2));
		p.add(new Producto("Boligrafo", 10.4f, 3));
		p.add(new Producto("Cuaderno", 15.2f, 4));
		p.add(new Producto("Libro", 20.8f, 5));
		
		//Segunda prueba
		Indice index = new Indice(p, "referencia");

		//Tercera prueba
		System.out.println("\n\nOrden por referencia\n");
		mostrarProductos(index);
		
		//Cuarta prueba
		index.setOrden("precio");
		
		//Quinta prueba
		System.out.println("\n\nOrden por precio\n");
		mostrarProductos(index);
		
		//Sexta prueba		
		index.insertar(new Producto("Estuche", 3.1f, 10));
		
		//Séptima prueba
		System.out.println("\n\nOrden por precio con nuevo producto\n");
		mostrarProductos(index);
		
		//Octava prueba
		index.buscar("Lapiz");
	}
	
	static void mostrarProductos(Indice index) {
		for(int i = 0; i < index.getProductos().size(); i++) {
			System.out.println(index.getProductos().elementAt(i).toString());			
		}
	}
}
