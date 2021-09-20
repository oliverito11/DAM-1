package EjerPrueba;

public class Sobremesa extends EquipoInformatico{
	private String torreTipo;
	private int numDiscos;
	public static final String TIPO_G = "GRANDE";
	public static final String TIPO_M = "MEDIANO";
	public static final String TIPO_P = "PEQUEÑO";
	
	/** CONSTRUCTOR */
	public Sobremesa(String color, int numPuertos, float precio, String torreTipo, int numDiscos) {
		super(color, numPuertos, precio);
		setTorreTipo(torreTipo);
		setNumDiscos(numDiscos);
	}
	/********************************************/
	
	public void encender() {
		System.out.println("Encendiendo el equipo...");
	}
	
	public void apagar() {
		System.out.println("Apagando el equipo...");
	}
	
	public void usar() {
		System.out.println("Trabajando con el equipo...");
	}
	
	public void programar() {
		System.out.println("Programando...");
	}
	
	public String toString() {
		return "Soy un PC!";
	}
	
	/** GETTERS Y SETTERS */
	public void setNumDiscos(int numDiscos) {
		this.numDiscos = numDiscos;
	}
	
	public int getNumDiscos() {
		return numDiscos;
	}
	
	public void setTorreTipo(String torreTipo) {
		if(torreTipo != TIPO_G && torreTipo != TIPO_M && torreTipo != TIPO_P)
			System.out.println("Formato de torre incorrecto.");
		else
			this.torreTipo = torreTipo;
	}
	
	public String getTorreTipo() {
		return torreTipo;
	}
}
