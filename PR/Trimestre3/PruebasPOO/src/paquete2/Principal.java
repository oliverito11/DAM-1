package paquete2;
import paquete1.*;
public class Principal {
	public static void main(String[] args) {
		Clase1 clase1 = new Clase1();
		Derivada derivada = new Derivada();
		Clase2 clase2 = new Clase2();
		Derivada2 derivada2 = new Derivada2();
		
		System.out.println(clase1.visibilidad());
		System.out.println(derivada.visibilidad());
		System.out.println(clase2.visibilidad());
		System.out.println(derivada2.visibilidad());
	}
}
