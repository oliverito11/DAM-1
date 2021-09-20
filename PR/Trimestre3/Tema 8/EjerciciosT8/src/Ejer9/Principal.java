package Ejer9;

public class Principal {
	public static void main(String[] args) {
		Instituto ins = new Instituto("Claudio");
		float[] notas = new float[] {2.3f, 5.4f, 8.9f, 10f, 3.1f, 1.1f, 2.8f, 5.5f, 6.8f};
		System.out.println("N�mero de alumnos aprobados: " + ins.numAprobados(notas));
		System.out.println("N�mero de alumnos suspensos: " + ins.numSuspensos(notas));
		System.out.println("Nota media: " + ins.notaMedia(notas));
		
		System.out.println(ins);
		
		System.out.println("La normativa dice que " + Instituto.NUM_AULAS + " aulas m�nimo por instituto.");
		System.out.println("La normativa dice que " + Instituto.NUM_DESPACHOS + " despachos m�nimo por instituto.");
		System.out.println("La normativa dice que " + Instituto.NUM_PISOS + " pisos m�nimo por instituto.");
	}
}
