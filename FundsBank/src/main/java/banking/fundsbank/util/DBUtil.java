package banking.fundsbank.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static Connection conn;
	
	public static Connection getConnection() {
		try {
			if(conn==null || conn.isClosed()) {
				Properties properties = new Properties();
				properties.load(new FileInputStream("postgredb.config"));
				Class.forName(properties.getProperty("DRIVER"));
				System.out.println("Driver Loaded..!");
				conn = DriverManager.getConnection(properties.getProperty("URL"),
						properties.getProperty("USER"), properties.getProperty("PASSWORD"));
				System.out.println("Connection Established...!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection() {
		if(conn!=null) {
			try { conn.close(); } catch (SQLException e) {}
		}
	}

}
