package Ejer8;

public abstract class Cuadrilatero extends Figura{
	private double[] lados = new double[2];
	
	/** CONSTRUCTOR */
	public Cuadrilatero(String color, int[][] posiciones, double[] lados) {
		super(color, posiciones);
		setLados(lados);
	}
	/*************************************/
	/** GETTERS Y SETTERS */
	public void setLados(double[] lados) {
		this.lados = lados;
	}
	
	public double[] getLados() {
		return lados;
	}
}
