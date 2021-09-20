
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjemSelect {

	public static void main(String[] args){
			
		// Parámetros de la conexión
		String driver 	= "com.mysql.cj.jdbc.Driver";
		String database = "instituto";
		String hostname = "localhost";
		String port		= "3306";
		String url		= "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false&serverTimezone=UTC";
		String usr 		= "root";
		String pwd 		= "1234";
		
		Connection con 			= null;
		PreparedStatement pstm 	= null;
		ResultSet rs 			= null;
		
		try{
			// Se levanta el driver
			Class.forName(driver);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
			
		try{
			// Se establece la conexión con la base de datos
			con = DriverManager.getConnection(url, usr, pwd);
			
			// Se define la consulta
			String sql = "SELECT IDDepartamentos, nombre FROM Departamentos";
			
			// Se prepara la sentencia a ejecutar
			pstm = con.prepareStatement(sql);
			
			// Se ejecuta la sentencia y recogen los resultados
			rs = pstm.executeQuery();
			
			// Se itera por los resultados
			while(rs.next()){
				// Se muestran los campos del registro actual
				System.out.println("Departamento de ID " + rs.getInt("IDDepartamentos") + " y nombre " + rs.getString("nombre"));
			}
						
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			try{
				// Se cierran los recursos en orden inverso a su creación
				if(rs 	!= null)	rs.close();
				if(pstm != null)	pstm.close();
				if(con	!= null)	con.close();
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}
