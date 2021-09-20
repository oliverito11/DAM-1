package Ejer4;

public class Vecino {
	private String nombre, apellidos;
	private int piso;
	private char letra;
	
	/** CONSTRUCTOR */
	public Vecino(String nombre, String apellidos, int piso, char letra) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.piso = piso;
		this.letra = letra;
	}
	/***********************************/
	
	public String toString() {
		return "Vecino " + getNombre() + " " + getApellidos() + ". Vive en el piso " + getPiso() + "" + getLetra();
	}
	
	/** GETTERS Y SETTERS */
	public String getNombre() {
		return nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public int getPiso() {
		return piso;
	}
	
	public char getLetra() {
		return letra;
	}
}
