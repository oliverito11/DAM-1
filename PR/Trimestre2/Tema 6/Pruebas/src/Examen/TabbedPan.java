package Examen;
import javax.swing.*;

public class TabbedPan {

	public static void main(String[] args) {
		JFrame f = new JFrame("Frame");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		JTabbedPane tb = new JTabbedPane();
		tb.add("Uno", p1);
		tb.add("Dos", p2);
		tb.add("Tres", p3);
		
		f.add(tb);
		f.setSize(500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
