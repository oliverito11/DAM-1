package Ejer3;
import java.awt.event.*;
import javax.swing.*;
public class Panel extends JPanel{
	static final long serialVersionUID = 1;
	private int cont = 0;
	private JTextField campo = new JTextField(15);
	private String[] dias = new String[]{"Lunes", "Martes", "Mi�rcoles", "Jueves", "Viernes", "S�bado", "Domingo"};
	
	public Panel() {
		JButton b = new JButton("Siguiente d�a");
		b.setToolTipText("Ver siguiente d�a");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campo.setText(dias[cont]);
				cont++;
				if(cont >= dias.length)
					cont = 0;
			}
		});
		add(b);
		
		campo.setEditable(false);
		add(campo);
		
	}
}
