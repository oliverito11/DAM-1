package Swing;

import java.awt.Graphics;
import java.awt.Image;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Fondo extends JPanel{
	private Image fondo;
	
	public Fondo() throws IOException{
		fondo = ImageIO.read(new File("fondoPrueba.png"));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondo, 0, 0, this);
	}
}
