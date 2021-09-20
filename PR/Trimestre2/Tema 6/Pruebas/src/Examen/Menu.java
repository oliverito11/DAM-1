package Examen;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
public class Menu {
	public static void main(String[] args) {
		JFrame f = new JFrame("CheckBox");
		JPanel p = new JPanel();
		
		JMenuBar mb = new JMenuBar();
		
		JMenu m = new JMenu("S");
		JMenu m2 = new JMenu("N");
		m.add(new JMenuItem("asd"));
		m2.add(new JMenuItem("asd"));
		mb.add(m);
		mb.add(m2);
		
		f.setJMenuBar(mb);
		f.add(p);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
