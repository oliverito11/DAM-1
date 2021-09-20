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
		System.out.println("Encendiendo el móvil...");
	}
	
	public void apagar() {
		System.out.println("Apagando el móvil...");
	}
	
	public void usar() {
		System.out.println("Chateando en el móvil...");
	}
	
	public void foto() {
		System.out.println("Foto hecha.");
	}
	
	public String toString() {
		return "Soy un móvil";
	}
	
	/** GETTERS Y SETTERS */
	public String getMarca() {
		return marca;
	}
}
