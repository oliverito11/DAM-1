package Examen;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;

import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
public class FileChoose {
	public static void main(String[] args) {
		JFrame f = new JFrame("CheckBox");
		JPanel p = new JPanel();
		
		JFileChooser jf = new JFileChooser();
		jf.addChoosableFileFilter(new FileFilter() {

			
			public boolean accept(File f) {
				if(f.getName().endsWith(".png") || f.isDirectory())
					return true;
				return false;
			}

			
			public String getDescription() {
				return "Filtro";
			}
			
		});
		if(jf.showOpenDialog(p) == JFileChooser.APPROVE_OPTION) {
			System.out.println("Hola");
		}
		
		f.add(p);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
