package EjerPrueba;

public class Movil extends EquipoInformatico{
	private String marca;
	
	/** CONSTRUCTOR */
	public Movil(String color, int numPuertos, float precio, String marca) {
		super(color, numPuertos, precio);
		this.marca = marca;
	}
	/*************************************/
	
	public void encender() {
		System.out.println("Encendiendo el m�vil...");
	}
	
	public void apagar() {
		System.out.println("Apagando el m�vil...");
	}
	
	public void usar() {
		System.out.println("Chateando en el m�vil...");
	}
	
	public void foto() {
		System.out.println("Foto hecha.");
	}
	
	public String toString() {
		return "Soy un m�vil";
	}
	
	/** GETTERS Y SETTERS */
	public String getMarca() {
		return marca;
	}
}
