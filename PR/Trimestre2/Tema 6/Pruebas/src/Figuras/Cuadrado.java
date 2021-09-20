package Figuras;

public class Cuadrado extends Figura{
	private double lado;
	public Cuadrado(String color, double lado) {
		super(color);
		this.lado = lado;
	}
	
	public double calcularArea() {
		return Math.pow(lado, 2);
	}
	
	public double calcularPerimetro() {
		return lado * 4;
	}
	
	public String toString() {
		return "Soy un cuadrado.\n" + super.toString() + "\nLado: " + lado;
	}
	
	public void pintar(String color) {
		setColor(color);
		System.out.println("El nuevo color del cuadrado es: " + getColor());
	}
	
	public double getLado() {
		return lado;
	}
}
