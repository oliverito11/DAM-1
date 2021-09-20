package Swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Tabla {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Prueba de tablas");
		
		String[] colum = {
				"Columna 1", "Columna 2"
		};
		
		String[][] data = {
				{"Dato 1 1", "Dato 1 2"},
				{"Dato 2 1", "Dato 2 2"}
		};
		
		JTable tabla = new JTable(data, colum);
		DefaultTableModel dtm = new DefaultTableModel(data, colum) {
			
			private static final long serialVersionUID = 1;
			
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tabla.setModel(dtm);
		
		frame.add(tabla);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
