package Examen;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
public class Slider {
	public static void main(String[] args) {
		JFrame f = new JFrame("CheckBox");
		JPanel p = new JPanel();
		
		JSlider s = new JSlider(JSlider.VERTICAL);
		s.setMajorTickSpacing(50);
		s.setMinorTickSpacing(5);
		s.setPaintLabels(true);
		s.setPaintTicks(true);
		
		s.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				System.out.println(s.getValue());
			}
		});
		
		p.add(s);
		f.add(p);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
