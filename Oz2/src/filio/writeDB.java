package filio;

import java.sql.*;

public class writeDB {
	public static Connection Connector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:participants.sqlite");
			return conn;
		} catch (Exception e) {
			System.out.println("Database not in correct location.\nPlease enrue database is outside src folder");
			return null;
		}		
	}
	
	

}
