package Examen;
import javax.swing.*;
import java.awt.event.*;
public class RadioBut {
	public static void main(String[] args) {
		JFrame f = new JFrame("CheckBox");
		JPanel p = new JPanel();
		
		JRadioButton r1 = new JRadioButton("Radio 1");
		JRadioButton r2 = new JRadioButton("Radio 2");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		
		p.add(r2);
		p.add(r1);
		f.add(p);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
