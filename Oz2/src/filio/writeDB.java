package filio;

import java.sql.*;

public class writeDB {
	
	public static Connection connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:participants.sqlite");
			System.out.println("writeDB worked");
			return conn;
		} catch (Exception e) {
			System.out.println("Database not in correct location.\nPlease enrue database is outside src folder");
			return null;
		}		
	}
	
	public void selectAll(){
        String sql = "SELECT id, name, capacity FROM warehouses";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	

}
