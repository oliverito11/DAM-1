package Examen;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
public class Panel extends JPanel{
	
	private static final long serialVersionUID = 1;
	
	public Panel() {
		setLayout(new FlowLayout());
		
		//Label
		JLabel jl = new JLabel("Esto es un JLabel");
		
		//CheckBox
		JCheckBox cb = new JCheckBox("Opcion 1");
		JCheckBox cb2 = new JCheckBox("Opcion 2");
		
		//Radio
		JRadioButton rb = new JRadioButton("Radio 1");
		JRadioButton rb2 = new JRadioButton("Radio 2");
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb);
		bg.add(rb2);
		
		//ComboBox
		Character[] chars = {
				'c', 's', 'e', 'd'
		};
		JComboBox<Character> comb = new JComboBox<Character>(chars);
		
		//Sliders
		JSlider sl = new JSlider(0, 10, 2);
		sl.setMinorTickSpacing(5);
		sl.setMajorTickSpacing(10);
		sl.setPaintLabels(true);
		sl.setPaintTicks(true);
		
		
		add(jl);
		add(cb);
		add(cb2);
		add(rb);
		add(rb2);
		add(comb);
		add(sl);
	}
}
