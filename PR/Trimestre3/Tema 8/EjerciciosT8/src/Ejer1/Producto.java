package Ejer1;

public class Producto {
	private String nombre;
	private float precio;
	private int referencia;
	
	/** Constructor por defecto */
	public Producto(){
		nombre = "";
		precio = 0f;
		referencia = 0;
	}
	
	/** Constructor que recibirá valores para cada atributo de la clase */
	public Producto(String nombre, float precio, int referencia) {
		this.nombre = nombre;
		this.precio = precio;
		this.referencia = referencia;
	}
	
	public String toString() {
		return "Nombre del producto: " + getNombre() + "\nPrecio del prodcuto: " + getPrecio() + "\nNúmero de referencia del producto: " + getReferencia();
	}
	
	/** GETTERS Y SETTERS */
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public int getReferencia() {
		return referencia;
	}
	
	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}
}
