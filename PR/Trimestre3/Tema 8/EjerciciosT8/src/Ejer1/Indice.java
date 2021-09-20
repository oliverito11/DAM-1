package Ejer1;

import java.util.Arrays;
import java.util.Vector;
public class Indice {
	private final String precioOrden = "precio";
	private final String referenciaOrden = "referencia";
	private Vector<Producto> productos;
	private String orden;
	
	public Indice(Vector<Producto> productos, String orden) {
		this.productos = productos;
		setOrden(orden.toLowerCase());
	}
	
	public void insertar(Producto producto) {
		productos.add(producto);
		setOrden(getOrden());
	}
	
	public Vector<Producto> buscar(String nombre){
		Vector<Producto> p = new Vector<Producto>();
		for(int i = 0; i < productos.size(); i++) {
			if(productos.elementAt(i).getNombre().toLowerCase().equals(nombre.toLowerCase())) {
				p.add(productos.elementAt(i));
			}
		}
		return p;
	}
	
	
	/** GETTERS y SETTERS*/
	public Vector<Producto> getProductos(){
		return productos;
	}
	
	public String getOrden() {
		return orden;
	}
	
	//Método ordenar
	public void setOrden(String orden) {
		Vector<Producto> nuevoOrden = new Vector<Producto>();
		this.orden = orden;
		if(orden.equals(precioOrden)) {
			//Obtenemos los precios
			float[] precios = new float[productos.size()];
			for(int i = 0; i < precios.length; i++) {
				precios[i] = productos.elementAt(i).getPrecio();
			}
			
			//Ordenamos los precios
			Arrays.sort(precios);
			
			for(int i = 0; i < precios.length; i++) {
				Producto p = new Producto();
				for(int j = 0; j < productos.size(); j++) {
					if(productos.elementAt(j).getPrecio() == precios[i]) {
						p = productos.elementAt(j);
						break;
					}
				}
				nuevoOrden.add(p);
			}
			productos = nuevoOrden;
		}else if (orden.equals(referenciaOrden)) {
			//Obtenemos las referencias
			int[] referencias = new int[productos.size()];
			for(int i = 0; i < referencias.length; i++) {
				referencias[i] = productos.elementAt(i).getReferencia();
			}
			
			//Ordenamos los precios
			Arrays.sort(referencias);
			
			for(int i = 0; i < referencias.length; i++) {
				Producto p = new Producto();
				for(int j = 0; j < productos.size(); j++) {
					if(productos.elementAt(j).getReferencia() == referencias[i]) {
						p = productos.elementAt(j);
						break;
					}
				}
				nuevoOrden.add(p);
			}
			productos = nuevoOrden;
		}else {
			System.out.println("Orden inválido.");
		}
	}
}
