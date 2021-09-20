package Ejer6;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
public class Panel extends JPanel implements MouseListener{
	static final long serialVersionUID = 1;
	JLabel lImagen = new JLabel(new ImageIcon("descarga.gif"));
	JButton bPulsar = new JButton("P�lsame");
	JLabel lResultado = new JLabel(new ImageIcon(""));
	
	public Panel() {
		bPulsar.addMouseListener(this);
		setBackground(Color.BLACK);
		lResultado.setForeground(Color.WHITE);
		lResultado.setFont(new Font("Arial", Font.BOLD, 18));
		add(lImagen);
		add(bPulsar);
		add(lResultado);
	}
	
	public void mouseEntered(MouseEvent e) {
		lResultado.setText("HAS ENTRADO EN EL BOT�N");
	}
	
	public void mouseExited(MouseEvent e) {
		lResultado.setText("HAS SALIDO DEL BOT�N");	
	}
	
	public void mouseClicked(MouseEvent e) {
		lResultado.setText("HAS PULSADO EL BOT�N");
	}
	
	public void mousePressed(MouseEvent e) {
		lResultado.setText("TIENES APRETADO EL BOT�N");
	}
	
	public void mouseReleased(MouseEvent e) {
		lResultado.setText("HAS SOLTADO EL BOT�N");
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Vigilante");
		frame.setContentPane(new Panel());
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
