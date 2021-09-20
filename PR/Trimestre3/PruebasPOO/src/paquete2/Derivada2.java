package paquete2;
import paquete1.Clase1;
public class Derivada2 extends Clase1{
	public int visibilidad() {
		metodoProtegido();
		metodoPublico();
		return protegido + publico;
	}
}
