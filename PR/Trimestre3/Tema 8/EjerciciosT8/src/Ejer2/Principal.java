package Ejer2;

public class Principal {
	public static void main(String[] args) {
		Vaca vaca = new Vaca();
		Tiburon tiburon = new Tiburon();
		Animal animal = new Animal();
		
		System.out.println("ELEMENTOS DE LA VACA");
		System.out.println("Color: " + vaca.getColor() + "\nEdad: " + vaca.getEdad() + "\nPeso: " + vaca.getPeso());
		vaca.comer();
		
		System.out.println("\nELEMENTOS DEL TIBURÓN");
		System.out.println("Edad: " + tiburon.getEdad() + "\nPeso: " + tiburon.getPeso());
		tiburon.comer();
		
		System.out.println("\nELEMENTOS DEL ANIMAL");
		System.out.println("Edad: " + animal.getEdad() + "\nPeso: " + animal.getPeso());
		animal.comer();
	}
}
