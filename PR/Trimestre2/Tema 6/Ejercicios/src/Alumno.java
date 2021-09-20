
import java.io.Serializable;
public class Alumno implements Serializable{
	
	public static final long serialVersionUID = 1;
	
	String nombre;
	int tlf;
	String curso;
	char grupo;
	
	public String toString() {
		return "El nombre del alumno es " + nombre + " y cursa en " + curso + " en el grupo " + grupo + ". Su teléfono es " + tlf;
	}
}
