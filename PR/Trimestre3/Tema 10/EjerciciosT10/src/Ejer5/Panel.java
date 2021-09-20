package Ejer5;

import javax.swing.*;
import java.awt.event.*;
public class Panel extends JPanel{
	static final long serialVersionUID = 1;
	
	public Panel() {
		JLabel n = new JLabel("Nombre");
		JLabel ape1 = new JLabel("Primer apellido");
		JLabel ape2 = new JLabel("Segundo apellido");
		JLabel completo = new JLabel("");
		
		JTextField nTF = new JTextField(20);
		JTextField ape1TF = new JTextField(20);
		JTextField ape2TF = new JTextField(20);
		
		nTF.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				JTextField jtf = (JTextField)e.getSource();
				jtf.setText(jtf.getText().toUpperCase());
			}
		});
		
		ape1TF.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				JTextField jtf = (JTextField)e.getSource();
				jtf.setText(jtf.getText().toUpperCase());
			}
		});
		
		ape2TF.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				JTextField jtf = (JTextField)e.getSource();
				jtf.setText(jtf.getText().toUpperCase());
			}
		});
		
		JButton bVer = new JButton("Ver nombre");
		bVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				completo.setText(nTF.getText() + " " + ape1TF.getText() + " " + ape2TF.getText());
			}
		});
		
		add(n);
		add(nTF);
		
		add(ape1);
		add(ape1TF);
		
		add(ape2);
		add(ape2TF);
		
		add(bVer);
		add(completo);
	}
}
