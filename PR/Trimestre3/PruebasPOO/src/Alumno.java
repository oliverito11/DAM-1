
public class Alumno {
	private String nombre, curso;
	private int edad;
	private float media;
	
	Alumno(String nombre, int edad, String curso, float media){
		this.nombre = nombre;
		this.edad = edad;
		this.curso = curso;
		this.media = media;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	//No me interesa que cambie de nombre
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public float getMedia() {
		return media;
	}
	
	public void setMedia(float[] notas) {
		for(int i = 0; i < notas.length; i++) {
			
		}
	}
}
