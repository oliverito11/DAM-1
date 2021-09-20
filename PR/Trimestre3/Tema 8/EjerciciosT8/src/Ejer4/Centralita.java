package Ejer4;

import java.util.Vector;
public class Centralita {
	private int numLlamadas, costeTotal;
	private Vector<Llamada> llamadas = new Vector<Llamada>();
	
	//No hace falta constructor explícito, ya que se instanciará con los valores por defecto a 0;
	public void registrarLlamada(Llamada l) {
		numLlamadas++;
		costeTotal += l.getPrecio();
		llamadas.add(l);
		limpiarPantalla();
		mostrarLlamadas();
	}
	
	public void mostrarLlamadas() {
		for(int i = 0; i < llamadas.size(); i++) {
			System.out.println(llamadas.elementAt(i));
			System.out.println("-------------------");
		}
	}
	
	public void registroLlamadas() {
		limpiarPantalla();
		System.out.println("\t\tLLAMADAS REALIZADAS:\t" + getNumLlamadas());
		System.out.println("\t\t========================");
		mostrarLlamadas();
		System.out.println("\t\tPRECIO TOTAL:\t\t" + getCosteTotal());
	}
	
	private void limpiarPantalla(){
		for(int i = 0; i < 25; i++)
			System.out.println();
	}
	
	/** GETTERS Y SETTERS */
	public int getNumLlamadas() {
		return numLlamadas;
	}
	
	public void setCosteTotal(int costeTotal) {
		this.costeTotal = costeTotal;
	}
	
	public int getCosteTotal() {
		return costeTotal;
	}
}
