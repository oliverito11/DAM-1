package Ejer4;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
public class Panel extends JPanel {
	
	static final long serialVersionUID = 1;
	
	public Panel() {
		JLabel label = new JLabel("USTED DESEA...");
		add(label);
		
		JButton aprobar = new JButton("Aprobar");
		aprobar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				int posX = getWidth() - aprobar.getWidth();
				int posY = getHeight() - aprobar.getHeight();
				
				aprobar.setLocation(new Random().nextInt(posX), new Random().nextInt(posY));
			}
			
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		add(aprobar);
		
		JLabel l2 = new JLabel("Usted tendrá la nota deseada...");
		l2.setVisible(false);
		
		JButton suspender = new JButton("Suspender");
		suspender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l2.setVisible(true);
			}
		});
		
		add(suspender);
		add(l2);
	}
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("Botón loco");
		jf.setSize(500, 500);
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		jf.setContentPane(new Panel());
		jf.setVisible(true);
	}
}
