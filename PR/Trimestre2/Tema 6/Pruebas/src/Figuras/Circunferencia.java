package Figuras;

public class Circunferencia extends Figura{
	private double radio;
	
	public Circunferencia(String color, double radio) {
		super(color);
		this.radio = radio;
	}
	
	public void pintar(String color) {
		setColor(color);
		System.out.println("El nuevo color del círculo es: " + getColor());
	}
	
	public String toString() {
		return "Soy un círculo.\n" + super.toString() + "\nRadio: " + radio;
	}
	
	public double calcularArea() {
		return Math.PI * Math.pow(radio, 2);
	}
	
	public double calcularPerimetro() {
		return 2 * Math.PI * radio;
	}
}
