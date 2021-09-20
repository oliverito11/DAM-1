package PruebaMenu;

import javax.swing.*;
public class Principal {
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Juego");
		ventana.setContentPane(new MenuPanel());
		ventana.setSize(1270, 720);
		ventana.setVisible(true);
	}
}
