package Ejer5;

public class Multiplicacion extends Algoritmo {
	public Multiplicacion(int clave) {
		super(clave);
	}
	
	public int encriptar(int codigo) {
		return codigo * getClave();
	}
	
	public int desencriptar(int codigo) {
		return codigo / getClave();
	}
}
