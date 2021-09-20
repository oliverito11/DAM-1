
import javax.swing.*;
public class Ejer1 {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(100, 100);
		f.setLocation(500,500);
		
		JLabel label = new JLabel("Hola Mundo!");
		f.add(label);
		f.setVisible(true);
	}
}
