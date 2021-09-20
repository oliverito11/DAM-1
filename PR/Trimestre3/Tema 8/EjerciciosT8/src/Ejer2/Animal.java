package Ejer2;

public class Animal {
	private int edad;
	private float peso;
	
	public void comer() {
		System.out.println("Estoy comiendo.");
	}
	
	/** GETTERS Y SETTERS */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public float getPeso() {
		return peso;
	}
}
