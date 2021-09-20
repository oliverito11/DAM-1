package Ejer2;
import javax.swing.*;
import java.awt.event.*;
public class Panel extends JPanel implements ActionListener{
	static final long serialVersionUID = 1;
	private int cont = 0;
	private JTextField texto = new JTextField(20);
	
	public Panel() {
		JButton b = new JButton("Bot�n contador");
		b.setToolTipText("Bot�n que aumentar� el contador");
		b.addActionListener(this);
		add(b);
		
		texto.setToolTipText("Texto donde se mostrar� el contador");
		add(texto);
	}
	
	public void actionPerformed(ActionEvent e) {
		cont++;
		texto.setText("Se ha pulsado " + cont + " veces el bot�n");
	}
}
