package Ejer5;

public class Encriptador {
	private int codigo;
	private Algoritmo al;
	private boolean encriptar;
	
	/** CONSTRUCTOR */
	public Encriptador(int codigo, Algoritmo al, boolean encriptar) {
		setCodigo(codigo);
		setAlgoritmo(al);
		setEncriptar(encriptar);
		
	}
	/******************************************/
	public int encriptado() {
		if(encriptar)
			return al.encriptar(getCodigo());
		else
			return al.desencriptar(getCodigo());
	}
	
	/** GETTERS Y SETTERS */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setAlgoritmo(Algoritmo al) {
		this.al = al;
	}
	
	public Algoritmo getAlgoritmo() {
		return al;
	}
	
	public void setEncriptar(boolean encriptar) {
		this.encriptar = encriptar;
	}
	
	public boolean getEncriptar() {
		return encriptar;
	}
}
