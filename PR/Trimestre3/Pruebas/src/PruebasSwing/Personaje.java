package PruebasSwing;

import javax.swing.ImageIcon;
public class Personaje extends Recurso {
	ImageIcon imagen;
	
	public Personaje(String nombre, String rutaArchivo, ImageIcon imagen) {
		super(nombre, rutaArchivo);
		this.imagen = imagen;
	}
	
	public ImageIcon getImagen() {
		return imagen;
	}
	
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}
}
