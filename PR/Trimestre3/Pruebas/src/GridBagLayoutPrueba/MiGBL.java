package GridBagLayoutPrueba;
import java.awt.Component;
import java.awt.GridBagConstraints;

import javax.swing.*;
public class MiGBL extends JPanel{
	GridBagConstraints rest = new GridBagConstraints();
	public MiGBL() {
		
		JButton b1 = new JButton("Bot�n 1"),
				b2 = new JButton("Bot�n 2"),
				b3 = new JButton("Bot�n 3");
		
	}
	
	public void a�adir(Component c, int x, int y) {
		rest.gridx = x;
		rest.gridy = y;
	}
	public static void main(String[] args) {
		JFrame f = new JFrame("GridBag");
		f.setSize(500, 500);
		f.setContentPane(new MiGBL());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
