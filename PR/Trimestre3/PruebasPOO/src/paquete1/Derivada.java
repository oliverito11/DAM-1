package paquete1;

public class Derivada extends Clase1{
	public int visibilidad() {
		metodoFriendly();
		metodoProtegido();
		metodoPublico();
		return friendly + publico + protegido;
	}
}
