package org.anshuahi.config;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;

public class DatabaseConfig {
	static Connection conn;
	public static synchronized Connection getConnection()  {
		if(conn == null) {
			synchronized (DatabaseConfig.class) {
				if(conn == null) {
					
					String dbUrl = "jdbc:mysql://localhost:3306/studyeasy?autoReconnect=true&allowPublicKeyRetrieval=true&useSSL=false";
					String dbUsername = "studyeasy";
					String dbPassword = "studyeasy";
					System.out.println("conencted to database");
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			return conn;
		}
		
		return conn;
		
	}
	
}
