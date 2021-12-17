package tiendecita;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static  String URL = "jdbc:mysql://localhost:3306/tiendecita";
	private static  String USUARIO = "root";
	private static  String CLAVE = "Pollino23";
	
	public static Connection conectar() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			
		} catch (SQLException e) {
			System.out.println("Ocurrio un error al conectar con la base de datos" + e.getMessage());
		}
		return conexion;
	}
}
