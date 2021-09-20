package PruebaBDProyecto;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
public class Panel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1;
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	public Panel() {
		JButton b = new JButton("Ver datos");
		b.addActionListener(this);
		
		con = UConnection.getUConnection();
		pstm = null;
		rs = null;
		try {
			pstm = con.prepareStatement("SELECT * FROM TABLA");
			rs = pstm.executeQuery();
			while(rs.next()) {
				
			}
		}catch(SQLException e) {
			System.out.println();
		}
		
		add(b);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
