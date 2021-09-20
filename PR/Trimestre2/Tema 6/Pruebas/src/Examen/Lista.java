package Examen;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionListener;

import java.awt.event.*;
public class Lista {
	public static void main(String[] args) {
		JFrame f = new JFrame("CheckBox");
		JPanel p = new JPanel();
		
		Integer[] val = {1,2,3,4,5};
		
		JList<Integer> l = new JList<Integer>(val);
		
		JScrollPane jsp = new JScrollPane(l);
		
		
		p.add(jsp);
		f.add(p);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
