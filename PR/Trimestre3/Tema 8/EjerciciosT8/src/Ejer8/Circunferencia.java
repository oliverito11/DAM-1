package Ejer8;

public class Circunferencia extends Figura{
	private double radio;
	
	/** CONSTRUCTOR */
	public Circunferencia(String color, int[][] posicion, double radio) {
		super(color, posicion);
		setRadio(radio);
	}
	/*********************************************/
	
	public double calcularArea() {
		return (Math.PI * Math.pow(radio, 2));
	}
	
	public double calcularPerimetro() {
		return (2 * Math.PI * radio);
	}
	
	/** GETTERS Y SETTERS */
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getRadio() {
		return radio;
	}
}
