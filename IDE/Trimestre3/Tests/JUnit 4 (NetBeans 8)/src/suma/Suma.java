/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suma;

/**
 *
 * @author mañana
 */
public class Suma {
	private int valor1, valor2;
	
	public Suma(int a, int b) {
		valor1 = a;
		valor2 = b;
	}
	
	public int sumar() {
		int resultado = valor1 + valor2;
		return resultado;
	}
	
	public int restar() {
		int resultado = valor1 - valor2;
		return resultado;
	}
}
