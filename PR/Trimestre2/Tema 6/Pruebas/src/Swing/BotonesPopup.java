package Swing;

import java.awt.event.*;
import javax.swing.*;
public class BotonesPopup extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1;
	
	JButton bInfor = new JButton("Botones de información"),
			bInput = new JButton("Botones de input"),
			bConfirm = new JButton("Botones de confirmación");
	
	public BotonesPopup() {
		bInfor.addActionListener(this);
		bInput.addActionListener(this);
		bConfirm.addActionListener(this);
		add(bInfor);
		add(bInput);
		add(bConfirm);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bInfor)) {
			JOptionPane.showMessageDialog(this, "Hola de nuevo");
			JOptionPane.showMessageDialog(this, "Hola", "Titulo", JOptionPane.ERROR_MESSAGE);
		}else if (e.getSource().equals(bInput)) {
			JOptionPane.showMessageDialog(this, "Tu edad es: " + JOptionPane.showInputDialog(this, "Edad"));
		}else if (e.getSource().equals(bConfirm)) {
			JOptionPane.showConfirmDialog(this, "Si o que");
		}
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Botones de emergencia");
		f.setContentPane(new BotonesPopup());
		f.setSize(500, 500);
		f.setLocation(500, 250);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
