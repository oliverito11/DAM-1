package Ejer4;

public class LlamadaProvincial extends Llamada{
	private int franjaHoraria;
	private static final int FRANJA_1 = 20;
	private static final int FRANJA_2 = 25;
	private static final int FRANJA_3 = 30;
	
	/** CONSTRUCTORES */
	public LlamadaProvincial(long numOrigen, long numDestino, long duracion, int franjaHoraria) {
		super(numOrigen, numDestino, duracion);
		setFranjaHoraria(franjaHoraria);
		switch(getFranjaHoraria()) {
			case 1:
				setPrecio(FRANJA_1, getDuracion());
				break;
			case 2:
				setPrecio(FRANJA_2, getDuracion());
				break;
			case 3:
				setPrecio(FRANJA_3, getDuracion());
				break;
			default:
				System.out.println("Franja horaria no válida.");
		}
	}
	/************************************************/
	
	public String toString() {
		return super.toString() + "Es una llamada provincial situada en la franja horaria nº" + getFranjaHoraria() + ".\nSu precio total es de " + getPrecio();
	}
	
	/** GETTERS Y SETTERS */
	public void setFranjaHoraria(int franjaHoraria) {
		this.franjaHoraria = franjaHoraria;
	}
	
	public int getFranjaHoraria() {
		return franjaHoraria;
	}
}
