package Ejer3_2;
import javax.swing.*;
import java.awt.event.*;
public class Principal {
	private static String[] dias = new String[] {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
	private static int cont;
	public static void main(String[] args) {
		JFrame jf = new JFrame("Días de la semana");
		jf.setSize(500, 200);
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		JPanel jp = new JPanel();
		jf.setContentPane(jp);
		
		JTextField jtf = new JTextField(15);
		jtf.setEditable(false);
		
		JButton b = new JButton("Siguiente día");
		b.setToolTipText("Ver siguiente día");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtf.setText(dias[cont]);
				if(++cont >= dias.length)
					cont = 0;
			}
		});
		jp.add(b);
		jp.add(jtf);
		
		jf.setVisible(true);
	}
}
