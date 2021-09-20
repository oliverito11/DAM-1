package Swing;

import javax.swing.JFrame;

public class Principal {
	public static void main(String[] args) {
		Menu m = new Menu();
		m.setSize(1280, 720);
		m.setLocation(200, 200);
		m.setVisible(true);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
