package PruebasSwing;

import java.util.Scanner;

import javax.swing.*;
public class MostrarTexto extends Thread{
	private String texto;
	private JFrame f;
	private JLabel l;
	private boolean mostrado = false;
	static Scanner teclado = new Scanner(System.in);
	
	public MostrarTexto(String texto, JFrame f, JLabel l) {
		this.texto = texto;
		this.f = f;
		this.l = l;
	}
	
	public void run() {
		StringBuffer sb;
		while(true) {
			try {
				sb = new StringBuffer();
				for(int i = 0; i < texto.length(); i++) {
					sb.append(texto.charAt(i));
					l.setText(sb.toString());
					Thread.sleep(100);
					f.add(l);
				}
			}catch(InterruptedException e) {
				System.err.println("Error de hilo.");
			}
			System.out.println(">");
			texto = teclado.nextLine();
		}
	}
			
	public boolean getMostrado() {
		return mostrado;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
