package Ejercicios;

public class Ejer16 {
	static final int MAX = 10;
	public static void main(String[] args){
		String[] tablas = new String[MAX];
		
		for (int i = 0; i < MAX; i++) {
			tablas[i] = new String("");
			tablas[i] = "\t\tTABLA DEL " + (i + 1) + "\n";
			rellenarString(tablas, i + 1);
		}
		
		mostrarString(tablas);
	}
	
	static void rellenarString(String[] tablas, int i){
		for (int j = 1; j <= MAX; j++) {
			tablas[i - 1] += i + " x " + j + " = " + (i * j) + "*"; 
		}
	}
	
	static void mostrarString(String[] tablas){
		for (int i = 0; i < tablas.length; i++) {
			System.out.println(tablas[i].replace('*', '\n'));
		}
	}
}
