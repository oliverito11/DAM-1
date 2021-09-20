package EstructurasDinamicas;

public class Alumno implements Comparable<Alumno>{
	private String nombre, curso;
	private int edad;
	private int numMatricula;
	
	public Alumno(String nombre, String curso, int edad, int numMatricula) {
		this.nombre = nombre;
		this.curso = curso;
		this.edad = edad;
		this.numMatricula = numMatricula;
	}
	
	public int compareTo(Alumno otro) {
		return this.numMatricula - otro.numMatricula;
	}
	
	public String toString() {
		return "Alumno " + nombre + " de edad " + edad + " est� en el curso " + curso + ". Su n�mero de matr�cula es " + numMatricula;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public int getNumMatricula() {
		return numMatricula;
	}
}
