package PruebaBDProyecto;

import javax.swing.*;
public class Principal {
	public static void main(String[] args) {
		JFrame f = new JFrame("BD");
		f.setSize(500, 500);
		f.setLocation(500, 250);
		f.setContentPane(new Panel());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
