package EstructurasDinamicas;

public class Libro {
	private String nombre, autor;
	private int numPags;
	
	public Libro(String nombre, String autor, int numPags) {
		this.nombre = nombre;
		this.autor = autor;
		this.numPags = numPags;
	}
	
	public String toString() {
		return "Libro: " + nombre + " | Autor: " + autor + " | " + numPags + " págs.";
	}
	
	/** GETTERS Y SETTERS */
	public String getNombre() {
		return nombre;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public int getNumPags() {
		return numPags;
	}
}
