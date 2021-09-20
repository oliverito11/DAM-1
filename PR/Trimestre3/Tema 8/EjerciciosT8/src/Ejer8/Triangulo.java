package Ejer8;

public class Triangulo extends Figura{
	private double[] lados = new double[3];
	
	/** CONSTRUCTOR*/
	public Triangulo(String color, int[][] posicion, double[] lados) {
		super(color, posicion);
		setLados(lados);
	}
	/**************************************/
	
	public double calcularArea() {
		double sp = calcularPerimetro() / 2;
		return Math.sqrt(sp * (sp - lados[0]) * (sp - lados[1]) * (sp - lados[2]));
	}
	
	public double calcularPerimetro() {
		double suma = 0;
		for(int i = 0; i < getLados().length; i++)
			suma += getLados()[i];
		return suma;
	}
	
	/** GETTERS Y SETTERS */
	public void setLados(double[] lados) {
		this.lados = lados;
	}
	
	public double[] getLados() {
		return lados;
	}
}
