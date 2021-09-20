package Ejer3;
import java.awt.event.*;
import javax.swing.*;
public class Principal {
	public static void main(String[] args) {
		JFrame jf = new JFrame("Días de la semana");
		jf.setContentPane(new Panel());
		jf.setSize(200, 200);
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		jf.setVisible(true);
	}
}
