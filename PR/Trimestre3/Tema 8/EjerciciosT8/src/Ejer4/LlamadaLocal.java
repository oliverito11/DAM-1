package Ejer4;

public class LlamadaLocal extends Llamada{
	private static final int PRECIO_LLAMADA = 15;
	
	/** CONSTRUCTORES */
	public LlamadaLocal(long numOrigen, long numDestino, long duracion) {
		super(numOrigen, numDestino, duracion, PRECIO_LLAMADA);
	}
	/************************************************/
	
	public String toString() {
		return super.toString() + "Es una llamada local.\nSu precio total es de " + getPrecio();
	}
}
