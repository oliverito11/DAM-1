package Ejer2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
public class Principal {
	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setTitle("Contador");
		j.setContentPane(new Panel());
		j.setSize(200, 100);
		j.setVisible(true);
		
		j.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
