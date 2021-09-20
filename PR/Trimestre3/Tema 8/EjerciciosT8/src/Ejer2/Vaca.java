package Ejer2;

public class Vaca extends Animal{
	private String color = "Blanco y negro";

	public void comer() {
		System.out.println("Estoy comiendo hierba.");
	}
	
	/** GETTERS Y SETTERS */
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
}
