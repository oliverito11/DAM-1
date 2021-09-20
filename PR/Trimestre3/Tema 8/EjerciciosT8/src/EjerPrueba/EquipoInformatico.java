package EjerPrueba;

abstract public class EquipoInformatico {
	private String color;
	private int num_puertos;
	private float precio;
	
	/** CONSTRUCTOR */
	public EquipoInformatico(String color, int num_puertos, float precio) {
		setColor(color);
		this.num_puertos = num_puertos;
		this.precio = precio;
	}
	/****************************/
	abstract public void encender();
	abstract public void apagar();
	abstract public void usar();
	abstract public String toString();
	/** GETTERS Y SETTERS */
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getNum_Puertos() {
		return num_puertos;
	}
	
	public float getPrecio() {
		return precio;
	}
}
