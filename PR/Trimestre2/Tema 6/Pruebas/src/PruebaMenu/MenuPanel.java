package PruebaMenu;

import javax.swing.*;
import java.awt.event.*;
public class MenuPanel extends JPanel{
	
	static final long serialVersionUID = 1;
	
	JButton bNueva= new JButton("Nueva partida");
	JButton bContinuar = new JButton("Continuar partida");
	JButton bSalir = new JButton("Salir");
	public MenuPanel() {
		setLayout(null);
		bSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		bSalir.setLocation(500, 200);
		bSalir.setSize(200, 200);
		add(bSalir);
	}
}
