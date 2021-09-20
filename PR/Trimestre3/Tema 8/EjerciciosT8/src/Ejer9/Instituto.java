package Ejer9;

public class Instituto implements Normativa{
	private String nombre;
	
	/** CONSTRUCTOR */
	public Instituto(String nombre) {
		this.nombre = nombre;
	}
	/***************************************/
	
	public int numAprobados(float[] notas) {
		int apr = 0;
		for(int i = 0; i < notas.length; i++) {
			if(notas[i] >= 5)
				apr++;
		}
		return apr;
	}
	
	public int numSuspensos(float[] notas) {
		int sus = 0;
		for(int i = 0; i < notas.length; i++) {
			if(notas[i] < 5)
				sus++;
		}
		return sus;
	}
	
	public float notaMedia(float[] notas) {
		float suma = 0;
		
		for(int i = 0; i < notas.length; i++)
			suma += notas[i];
		
		return suma / notas.length;
	}
	
	public String toString() {
		return "El instituto " + getNombre() + " tiene " + NUM_PISOS + " pisos, con " + NUM_DESPACHOS + " despachos en total. Hay " + NUM_AULAS + " aulas en todo el instituto.";
	}
	
	/** GETTERS Y SETTERS */
	public String getNombre() {
		return nombre;
	}
}
