package Ejer2_2;
import javax.swing.*;
import java.awt.event.*;
public class Ejer2 extends JPanel{
	static final long serialVersionUID = 1;
	private int cont = 0;
	private JTextField texto = new JTextField(20);
	
	public Ejer2() {
		JButton b = new JButton("Contador");
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cont++;
				texto.setText("Se ha pulsado " + cont + " veces el botón");
			}
		});
		b.setToolTipText("Botón contador");
		texto.setToolTipText("Cantidad de veces pulsadas");
		add(b);
		add(texto);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Contador");
		f.setSize(200, 100);
		f.setContentPane(new Ejer2());
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		f.setVisible(true);
	}
}
