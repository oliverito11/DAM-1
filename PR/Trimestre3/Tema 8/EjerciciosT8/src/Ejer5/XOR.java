package Ejer5;

public class XOR extends Algoritmo{
	public XOR(int clave) {
		super(clave);
	}
	public int encriptar(int codigo) {
		return codigo ^ getClave();
	}
	
	public int desencriptar(int codigo) {
		return codigo ^ getClave();
	}
}
