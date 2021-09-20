package Ejer9;

public class Principal {
	public static void main(String[] args) {
		Instituto ins = new Instituto("Claudio");
		float[] notas = new float[] {2.3f, 5.4f, 8.9f, 10f, 3.1f, 1.1f, 2.8f, 5.5f, 6.8f};
		System.out.println("Número de alumnos aprobados: " + ins.numAprobados(notas));
		System.out.println("Número de alumnos suspensos: " + ins.numSuspensos(notas));
		System.out.println("Nota media: " + ins.notaMedia(notas));
		
		System.out.println(ins);
		
		System.out.println("La normativa dice que " + Instituto.NUM_AULAS + " aulas mínimo por instituto.");
		System.out.println("La normativa dice que " + Instituto.NUM_DESPACHOS + " despachos mínimo por instituto.");
		System.out.println("La normativa dice que " + Instituto.NUM_PISOS + " pisos mínimo por instituto.");
	}
}
