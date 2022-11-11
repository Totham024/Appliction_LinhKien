package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





public class ConnectDB {
	public static Connection con = null;
	public static ConnectDB instance = new ConnectDB();
	
	public static ConnectDB getInstance() {
		return instance;
		
	}
	
	public void connect() {
//		String url = "jdbc:sqlserver://DESKTOP-5CN2O9R\\\\SQLEXPRESS:1433;DatabaseName=QuanLyLinhKien";
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=QuanLyLinhKien";
		String user = "sa";
		String password = "hong123";
		try {
			con= DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return con;
	}
	


}
