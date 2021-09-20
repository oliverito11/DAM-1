package BD;

import java.util.ArrayList;

import javax.swing.JTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Principal {
	public static void main(String[] args) {
		String 	driver ="com.mysql.cj.jdbc.Driver",
				database = "obras",
				hostname = "localhost",
				port = "3306",
				url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false&serverTimezone=UTC",
				usr = "root",
				pwd ="1234";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//Conexión
			Class.forName(driver);
			
			//Abrimos la conexión
			con = DriverManager.getConnection(url, usr, pwd);
			
			//Sentencia SQL
			String sql = "SELECT * FROM CONDUCTORES";
			
			//Preparamos la sentencia
			ps = con.prepareStatement(sql);
			
			//La ejecutamos y recogemos el resultado
			rs = ps.executeQuery();
			//Uso de los datos
			while(rs.next()) {
				System.out.println(	"\nCODC: " + rs.getString(1) +
									"\nNOMBRE: " + rs.getString(2) +
									"\nLOCALIDAD: " + rs.getString(3) +
									"\nCATEGORIA: " + rs.getInt(4));
			}
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
