package Ejer8;

public class Rectangulo extends Cuadrilatero{
	public Rectangulo(String color, int[][] posiciones, double[] lados) {
		super(color, posiciones, lados);
	}
	
	public double calcularArea() {
		return getLados()[0] * getLados()[1];
	}
	
	public double calcularPerimetro() {
		double suma = 0;
		for(int i = 0; i < getLados().length; i++)
			suma += getLados()[i];
		return suma;
	}
}
