package Swing;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Menu extends JFrame implements MouseListener{
	
	Menu(){
		try {
			setContentPane(new Fondo());
		} catch (IOException e) {
			System.err.println("Error al poner el fondo"); 
		}
		setLayout(new GridLayout(3, 3));
		
		JLabel label = new JLabel("Hola");
		add(label);
		Font fuente = new Font("Arial", Font.BOLD, 20);
		label.setForeground(Color.WHITE);
		label.setFont(fuente);
		
		
		JButton b = new JButton(new ImageIcon("baila.png"));
		b.setSize(100, 100);
		b.addMouseListener(this);
		add(b);
		
		JButton b2 = new JButton(new ImageIcon("baila.png"));
		b2.setSize(100, 100);
		b2.addMouseListener(this);
		add(b2);
		
		JButton b3 = new JButton(new ImageIcon("baila.png"));
		b3.setSize(100, 100);
		b3.addMouseListener(this);
		add(b3);
	}
	
	public void mouseClicked(MouseEvent e) {

	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {
		JButton b = (JButton)e.getComponent();
		b.setBackground(Color.black);
	}
	
	public void mouseExited(MouseEvent e) {
		JButton b = (JButton)e.getComponent();
		b.setBackground(Color.white);
	}	
}
