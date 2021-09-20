package Ejer5;

public class Parte {
	private int codigo;
	private String descripcion;
	private int importe;
	
	public Parte(int codigo, String descripcion, int importe) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.importe = importe;
	}
	
	public String toString() {
		return "Código del parte: " + codigo + "\nDescripción: " + descripcion + "\nImporte: " + importe;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public int getImporte() {
		return importe;
	}
}
