package Ejer3;

public class Titular {
	private String nombre, apellido1, apellido2;
	private int edad;
	
	/** CONSTRUCTOR */
	public Titular(String nombre, String apellido1, String apellido2, int edad) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
	}
	/************************************************/
	
	public String toString() {
		return getNombre() + " " + getApellido1() + " " + getApellido2();
	}
	/**GETTERS Y SETTERS*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	
	public String getApellido1() {
		return apellido1;
	}
	
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public String getApellido2() {
		return apellido2;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getEdad() {
		return edad;
	}
}
