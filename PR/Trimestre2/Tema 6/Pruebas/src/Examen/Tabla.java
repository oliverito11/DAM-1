package Examen;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Tabla {
	public static void main(String[] args) {
		JFrame f = new JFrame("CheckBox");
		JPanel p = new JPanel();
		
		String[] colum = {"Uno", "Dos"};
		String[][] data = {
				{"Yes", "No"},
				{"Y", "N"}
		};
		
		JTable t = new JTable(data, colum);
		
		t.setModel(new DefaultTableModel(data, colum) {
			
			private static final long serialVersionUID = 1;
			
			public boolean isCellEditable(int row, int col) {
				return false;
			}
			
		});
		
		
		p.add(t);
		f.add(p);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
