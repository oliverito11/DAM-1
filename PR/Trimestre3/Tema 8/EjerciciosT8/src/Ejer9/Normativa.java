package Ejer9;

interface Normativa {
	int NUM_PISOS = 3;
	int NUM_AULAS = 10;
	int NUM_DESPACHOS = 2;
	
	int numAprobados(float[] notas);
	int numSuspensos(float[] notas);
	float notaMedia(float[] notas);
}
