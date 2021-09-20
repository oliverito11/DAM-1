package Ejer5;

public abstract class Algoritmo implements Encriptable{
	private int clave;
	
	/** CONSTRUCTOR */
	public Algoritmo(int clave) {
		setClave(clave);
	}
	/*********************************/
	abstract public int encriptar(int codigo);
	abstract public int desencriptar(int codigo);
	
	/** GETTERS Y SETTERS */
	public void setClave(int clave) {
		this.clave = clave;
	}
	
	public int getClave() {
		return clave;
	}
}
