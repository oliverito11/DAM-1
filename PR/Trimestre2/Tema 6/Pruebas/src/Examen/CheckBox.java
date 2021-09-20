package Examen;
import javax.swing.*;
import java.awt.event.*;
public class CheckBox {
	
	static JLabel l = new JLabel("Hola");
	static JCheckBox c;
	static JCheckBox c2;
	static ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (c.isSelected() && c2.isSelected()) {
				System.out.println("Carne y pescado");
			}else if(c.isSelected()) {
				System.out.println("Carne");
			}else if(c2.isSelected()) {
				System.out.println("Pescado");
			}
			
		}
	};
	
	public static void main(String[] args) {
		JFrame f = new JFrame("CheckBox");
		JPanel p = new JPanel();
		
		c = new JCheckBox("Carne");
		c2 = new JCheckBox("Pescado");
		
		
		c.addActionListener(al);
		c2.addActionListener(al);
		p.add(c2);
		p.add(c);
		p.add(l);
		f.add(p);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
}
