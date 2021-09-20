package Ejercicios;

import java.util.Vector;
import java.util.Random;
public class Ejer25y26 {
	static final int REPARTO = 10;
	static final int BASTOS = 1;
	static final int ESPADAS = 2;
	static final int COPAS = 3;
	static final int OROS = 4;
	static final int MAX_CARTAS = 3;
	static final int ESCOBA = 15;
	static Carta[] baraja = new Carta[40];
	
	public static void main(String[] args) {
		rellenarBaraja();
		//mostrarBaraja();
		
		BazaEscoba baza = crearBaza();
		mostrarBaza(baza);
	}
	
	/** Todas las cartas se rellenaran con el palo correspondiente y numero */
	static void rellenarBaraja() {
		//NOMBRES: BASTOS, ESPADAS, COPAS Y OROS
		//VALORES: 1 - 10
		for (int i = 1; i <= 4; i++) {
			String palo = obtenerNombre(i);
			for (int j = (10 * (i - 1)); j < REPARTO + (10 * (i - 1)); j++) {
				baraja[j] = new Carta();
				baraja[j].numero = (j % 10) + 1;
				baraja[j].palo = palo;
			}
		}
	}
	
	static void mostrarBaraja(){
		for (int i = 0; i < baraja.length; i++)
			System.out.println(baraja[i].numero + " de " + baraja[i].palo);
	}
	
	static String obtenerNombre(int i) {
		switch (i) {
		case 1:
			return "BASTOS";
		case 2:
			return "ESPADAS";
		case 3:
			return "COPAS";
		case 4:
			return "OROS";
		default:
			return "";
		}
	}
	
	//Ejercicio 26
	static BazaEscoba crearBaza() {
		//Creo una nueva baza
		BazaEscoba baza = new BazaEscoba();
		
		//Le asigno unas cartas aleatorias
		Random r = new Random();
		int cantidadCartas = r.nextInt(MAX_CARTAS) + 1;
		
		for(int i = 0; i < cantidadCartas; i++)
			baza.cartas.add(baraja[r.nextInt(baraja.length)]);
		
		baza.numCartas = baza.cartas.size();
		baza.numOros = contarOros(baza.cartas);
		baza.numSietes = contarSietes(baza.cartas);
		baza.escoba = comprobarEscoba(baza.cartas);
		
		return baza;
	}
	
	/** Se buscan todos los oros posibles dentro de la baza */
	static int contarOros(Vector<Carta> cartasBaza){
		int cont = 0;
		//Recorro el vector buscando todos los oros posibles
		for (int i = 0; i < cartasBaza.size(); i++)
			if(cartasBaza.elementAt(i).palo.equals("OROS"))
				cont++;

		return cont;
	}
	
	/** Se buscan todos los 7 posibles dentro de la baza */
	static int contarSietes(Vector<Carta> cartasBaza){
		int cont = 0;
		//Recorro el vector buscando todos los sietes posibles
		for (int i = 0; i < cartasBaza.size(); i++)
			if(cartasBaza.elementAt(i).numero == 7)
				cont++;

		return cont;
	}
	
	/** Escoba ocurrirá cuando las cartas de la baza valgan 15*/
	static boolean comprobarEscoba(Vector<Carta> cartasBaza){
		boolean escoba = false;
		
		//Sumo todos los numeroes de las cartas y compruebo si es o no escoba
		if(sumarValores(cartasBaza) == ESCOBA)
			escoba = true;
		return escoba;
	}
	
	/** Se suman los numeroes de cada carta dentro de un conjunto */
	static int sumarValores(Vector<Carta> cartasASumar){
		int suma = 0;
		
		for (int i = 0; i < cartasASumar.size(); i++)
			suma += cartasASumar.elementAt(i).numero;
		
		return suma;
	}
	
	/** Se muestran todos los atributos de la baza correspondiente */
	static void mostrarBaza(BazaEscoba baza) {
		System.out.println("La cantidad de cartas de esta baza es " + baza.numCartas + " y son las siguientes:");
		for (int i = 0; i < baza.cartas.size(); i++)
			System.out.println(baza.cartas.elementAt(i).numero + " de " + baza.cartas.elementAt(i).palo);
		
		System.out.println("\nLa cantidad de oros de esta baza es: " + baza.numOros);
		System.out.println("\nLa cantidad de sietes de esta baza es: " + baza.numSietes);
		
		System.out.println("\nLa suma de todos los numeroes de las cartas es: " + sumarValores(baza.cartas));
		if(baza.escoba)
			System.out.println("Esta baza hace escoba!");
		else
			System.out.println("Esta baza no hace escoba...");
	}
}
