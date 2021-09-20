package Ejer5;

import javax.swing.*;
public class Principal {
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Datos personales");
		ventana.setSize(250, 300);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new Panel());
		ventana.setVisible(true);
	}
}
