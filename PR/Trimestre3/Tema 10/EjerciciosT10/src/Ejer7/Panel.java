package Ejer7;

import javax.swing.*;
import java.awt.event.*;
public class Panel extends JPanel {
	
	static final long serialVersionUID = 1;
	static JLabel lTexto = new JLabel();
	static JLabel lEnter= new JLabel();
	static int cont = 0;
	
	public Panel() {
		add(lTexto);
		add(lEnter);
	}
	
	public static void main(String[] args) {
		JFrame vent = new JFrame("Pulsación de teclas");
		vent.setContentPane(new Panel());
		vent.setSize(800, 100);
		vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//El evento se efectúa sobre la propia ventana
		vent.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char letra = Character.toUpperCase(e.getKeyChar());
				System.out.println(letra);
				if((letra >= 'A') && (letra <= 'Z'))
					lTexto.setText(lTexto.getText() + letra);
				else if(e.getKeyCode() == KeyEvent.VK_ENTER)
					lEnter.setText("SE HA PULSADO ENTER " + ++cont + " VECES");
			}
		});
		
		vent.setVisible(true);
	}
}
