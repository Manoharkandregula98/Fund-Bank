package com.fundsbank.util;

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
				Properties props = new Properties();
				props.load(new FileInputStream("db.config"));
				Class.forName(props.getProperty("DRIVER"));
				System.out.println("Driver Loaded");
				conn = DriverManager.getConnection(props.getProperty("URL"),props.getProperty("USER"),new PasswordHandler().getDecoded(props.getProperty("PASSWORD")));
				System.out.println("Connection Established");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConnection() {
	if(conn != null) {
		try {conn.close();} catch (SQLException e) {}
	}
	}
}
