package paquete1;

public class Clase1 {
	private int privado = 4;
	int friendly = 3;
	protected int protegido = 2;
	public int publico = 1;
	
	//Este nunca se mostrar� fuera de esta clase
	private void metodoPrivado() {
		System.out.println("Soy un m�todo privado");
	}
	
	void metodoFriendly() {
		System.out.println("Soy un m�todo friendly");
	}

	protected void metodoProtegido() {
		System.out.println("Soy un m�todo protegido");
	}
	
	public void metodoPublico() {
		System.out.println("Soy un m�todo p�blico");
	}
	
	public int visibilidad() {
		metodoFriendly();
		metodoPrivado();
		metodoProtegido();
		metodoPublico();
		return privado + friendly + protegido + publico;
	}
	
}
