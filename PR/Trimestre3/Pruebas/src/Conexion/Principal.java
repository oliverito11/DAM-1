package Conexion;

import java.sql.*;
public class Principal {
	public static void main(String[] args) {
		
		PreparedStatement pstm = null;
		try {
			Connection con = UConnection.getConnection();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
