package Examen;

import java.awt.event.*;

import javax.swing.*;

public class ComboBox {
	public static void main(String[] args) {
		JFrame jf = new JFrame("ComboBox");
		JPanel p = new JPanel();
		jf.setSize(500, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[] algo = {"1", "2", "3"};
		JComboBox<String> b = new JComboBox<String>(algo);
		JLabel l = new JLabel();
		JButton jb = new JButton("Pulsame");
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l.setText(b.getSelectedItem().toString());
			}
		});
		p.add(l);
		p.add(jb);
		p.add(b);
		jf.add(p);
		jf.setVisible(true);
	}
}
