package Ejer8;

public class Cuadrado extends Cuadrilatero{
	public Cuadrado(String color, int[][] posiciones, double[] lados) {
		super(color, posiciones, lados);
	}
	
	public double calcularArea() {
		return Math.pow(getLados()[0], 2);
	}
	
	public double calcularPerimetro() {
		return getLados()[0] * 4;
	}
}
