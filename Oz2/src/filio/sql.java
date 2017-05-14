package filio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import exceptions.ExceptionAlert;
import ozlympic.Athlete;

public class sql {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:participants.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
    
    /*
     * select all rows in the sql table
     */
    public void selectAll(){
    	ArrayList<Athlete> sqlAthlete = new ArrayList<Athlete>();
    	
        String sql = "SELECT id, name, type, age, state, score FROM participants";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
//                System.out.println(
                					int id = rs.getInt("id"); 
//                					+  "\t" + 
                                   String name = rs.getString("name"); 
//                                   + "\t" +
                                   String type = rs.getString("type");
//                                   + "\t" +
                                   int age = rs.getInt("age");
//                                   + "\t" +
                                   String state = rs.getString("state");
//                                   + "\t" +
                                  int score = rs.getInt("score");
                                   System.out.println(id + " " + name + " " + type + " " +age + " " +state + " " + score);
//                		);
                                   Athlete test = new Athlete(id, name,type, age, state, score);
                                   sqlAthlete.add(test);
                				
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
        	for(int fuck = 0; fuck < sqlAthlete.size(); fuck++) {
        		Athlete test = sqlAthlete.get(fuck);
        		System.out.println("DID YOU WORKING WORK?\n" + test.getName());
        	}
        }
    }  
	
	
	
	
	
	
	
	
	
	
	
	
//	Connection connection;
//	
//	public sql(){
//		connection = writeDB.connect();
//		
//		if(connection == null) {
////TODO Make the below so (lol) ie Actually only load the text file if the sql don't work			
//			ExceptionAlert nullSQL = new ExceptionAlert("participants.sqlite not found\nLoading data from text file");
//		}
//	}
//		
//	public boolean sqlFound() {
//		try{ 
//			return !connection.isClosed();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}	
//	}
}