package Figuras;

abstract public class Figura implements Pintable, Comparable<Figura>{
	private String color;
	
	public Figura() {
		color = "Blanco";
	}
	
	public Figura(String color) {
		this.color = color;
	}
	
	abstract public double calcularArea();
	abstract public double calcularPerimetro();
	
	public int compareTo(Figura otra) {
		return this.color.length() - otra.color.length();
	}
	
	public String toString() {
		return "Color: " + color;
	}
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
}
