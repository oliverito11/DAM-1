package PopupMenu;

import javax.swing.*;
public class Principal {
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Popup");
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("Menu"),
			  menu2 = new JMenu("Menu2"),
			  submenu = new JMenu("Submenu");
		JMenuItem i1 = new JMenuItem("Item 1"),
				  i2 = new JMenuItem("Item 2"),
				  i3 = new JMenuItem("Item 3");
		
		f.setSize(500, 500);
		f.setLocation(500, 200);
		menu2.add(i2);
		menu.add(submenu);
		submenu.add(i3);
		menu.add(i1);
		mb.add(menu2);
		mb.add(menu);
		
		f.setJMenuBar(mb);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
