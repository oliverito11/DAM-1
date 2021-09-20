package PruebasSwing;

abstract public class Recurso {
	private String nombre, rutaArchivo;
	
	public Recurso(String nombre, String rutaArchivo) {
		this.nombre = nombre;
		this.rutaArchivo = rutaArchivo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getRutaArchivo() {
		return rutaArchivo;
	}
}
