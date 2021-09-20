package Ejer5;

public class Diferencia extends Algoritmo{
	public Diferencia(int clave) {
		super(clave);
	}
	public int encriptar(int codigo) {
		return codigo - getClave();
	}
	
	public int desencriptar(int codigo) {
		return codigo + getClave();
	}
}
