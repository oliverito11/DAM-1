package Ejer4;

public abstract class Llamada {
	private long numOrigen, numDestino, duracion;
	private float precio;
	
	/** CONSTRUCTORES */
	public Llamada(long numOrigen, long numDestino, long duracion, float precio) {
		setNumOrigen(numOrigen);
		setNumDestino(numDestino);
		setDuracion(duracion);
		setPrecio(precio, duracion);
	}
	
	public Llamada(long numOrigen, long numDestino, long duracion) {
		setNumOrigen(numOrigen);
		setNumDestino(numDestino);
		setDuracion(duracion);
	}
	
	/******************************************/
	
	public String toString() {
		return "Llamada de " + getNumOrigen() + " a " + getNumDestino() + " con duración de " + getDuracion() + " segundos.\n";
	}
	
	/** GETTERS Y SETTERS */
	public void setNumOrigen(long numOrigen) {
		this.numOrigen = numOrigen;
	}
	
	public long getNumOrigen() {
		return numOrigen;
	}
	
	public void setNumDestino(long numDestino) {
		this.numDestino = numDestino;
	}
	
	public long getNumDestino() {
		return numDestino;
	}
	
	public void setDuracion(long duracion) {
		this.duracion = duracion;
	}
	
	public long getDuracion() {
		return duracion;
	}
	
	public void setPrecio(float precio, long duracion) {
		this.precio = ((float)duracion / 60f) * precio;
	}
	
	public float getPrecio() {
		return precio;
	}
}
