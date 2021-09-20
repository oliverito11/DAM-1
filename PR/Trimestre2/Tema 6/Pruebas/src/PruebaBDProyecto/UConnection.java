package PruebaBDProyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UConnection {
	
	private static Connection con = null;
	
	public static Connection getUConnection() {
		try {
			if(con == null) {
				Runtime.getRuntime().addShutdownHook(new Thread() {
					public void run() {
						try {
							con = UConnection.getUConnection();
							con.close();
						}catch(SQLException e) {
							e.getStackTrace();
						}
					}
				});
				
				ResourceBundle rb = ResourceBundle.getBundle("PruebaBDProyecto.jdbc");
				
				String driver = rb.getString("driver"),
					   url = rb.getString("url"),
					   usr = rb.getString("usr"),
					   pwd = rb.getString("pwd");
				
				Class.forName(driver);
				con = DriverManager.getConnection(url, usr, pwd);
			}
		}catch(Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		
		return con;
	}
}
