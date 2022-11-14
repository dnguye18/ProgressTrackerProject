package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static final String URL = "jdbc:mysql://localhost:3306/progresstracker";
	// ?serverTimezone=EST5EDT   <-- add to end of URL if on Mac or Linux
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root"; // change password if need be,
												   // might be Root@123 for mac users
	
	// method for creating connection
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);			
			System.out.println("Connected.");
			
		} catch(SQLException e) {
			System.out.println("Could not make connection.");
		}
		
		return conn;
	}
	
//	// main is only here so we can test our method above
//	public static void main(String[] args) {
//		Connection conn = ConnectionManager.getConnection();
//		
//		try {
//			conn.close();
//			System.out.println("Connection closed.");
//			
//		} catch(SQLException e) {
//			System.out.println("Could not close connection.");
//		}
//	}
	
}