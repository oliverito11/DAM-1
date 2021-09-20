package paquete2;
import paquete1.Clase1;
public class Clase2 {
	public int visibilidad() {
		Clase1 base = new Clase1();
		base.metodoPublico();
		return base.publico;
	}
}
