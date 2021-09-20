package PruebasSwing;

import javax.imageio.ImageIO;
//import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.util.LinkedList;
public class Juego {
	static JFrame f = new JFrame();
	static JLabel l = new JLabel();
	static File fichero = new File("fich.txt");
	static final char FONDO = '|';
	static final char PERSONAJE = '$';
	static final char DECISION = '%';
	static final char MUSICA = '@';
	public static void main(String[] args){
		f.setSize(500, 500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Lector l = new Lector(fichero);
		LinkedList<String> lineas = l.leerLinea();
		while(!lineas.isEmpty()) {
			//Se obtiene una l�nea
			String linea = lineas.getLast();
			lineas.removeLast();
			
			//Se procesa el primer car�cter de la l�nea
			switch(linea.charAt(0)) {
				case FONDO:
					//Cambiar fondo
					
					break;
				case PERSONAJE:
					//Comprobar si hay otro personaje
					//Cambiar personaje/s
					break;
				case MUSICA:
					//Cambiar m�sica
					break;
				case DECISION:
					//Crear decisi�n
					break;
				default:
					//Mostrar l�nea	
			}
		}
	}
}
