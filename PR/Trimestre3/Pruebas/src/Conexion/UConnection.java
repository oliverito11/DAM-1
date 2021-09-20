package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UConnection {
	
	private static Connection con = null;
	
	public static Connection getConnection() {
		try {
			if(con == null) {
				//Cierro la conexión cuando se cierre el programa
				Runtime.getRuntime().addShutdownHook(new Thread() {
					public void run() {
						try {
							con = UConnection.getConnection();
							con.close();
						}catch(SQLException e) {
							e.printStackTrace();
						}
					}
				});
				
				//Obtengo las variables de un fichero .properties
				ResourceBundle rs = ResourceBundle.getBundle("jdbc");
				String driver = rs.getString("driver"),
					   url = rs.getString("url"),
					   usr = rs.getString("usr"),
					   pwd = rs.getString("pwd");
				
				//Cargo el driver y abro la conexión
				Class.forName(driver);
				con = DriverManager.getConnection(url, usr, pwd);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
