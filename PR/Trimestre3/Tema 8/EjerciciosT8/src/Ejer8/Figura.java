package Ejer8;

public abstract class Figura {
	private String color;
	private int[][] posicion;
	/** CONSTRUCTOR */
	public Figura(String color, int[][] posicion) {
		setColor(color);
		setPosicion(posicion);
	}
	/****************************************************/
	
	abstract public double calcularArea();
	abstract public double calcularPerimetro();
	
	/** GETTERS Y SETTERS */
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setPosicion(int[][] posicion) {
		this.posicion = posicion;
	}
	
	public int[][] getPosicion(){
		return posicion;
	}
}
