package Examen;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Todo {
	public static void main(String[] args) {
		JFrame f = new JFrame("Todo");

		//Menu
		JMenuBar mb = new JMenuBar();
		JMenu m = new JMenu("Archivo");
		JMenu m2 = new JMenu("Opciones");
		m.setMnemonic('a');
		m2.setMnemonic('o');
		
		JMenuItem i = new JMenuItem("Otro...");
		i.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		
		m.add(new JMenuItem("Abrir..."));
		m.add(new JMenuItem("Guardar..."));
		
		m2.add(new JMenuItem("Acerda de..."));
		m2.add(new JMenuItem("Salir"));
		m2.add(i);
		
		mb.add(m);
		mb.add(m2);
		
		f.setJMenuBar(mb);
		f.setSize(500, 500);
		f.setContentPane(new Panel());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
