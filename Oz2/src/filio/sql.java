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
import ozlympic.Cyclist;
import ozlympic.Official;
import ozlympic.Ozlympic;
import ozlympic.Sprinter;
import ozlympic.SuperAthlete;
import ozlympic.Swimmer;

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

                				int id = rs.getInt("id"); 
                                String name = rs.getString("name"); 
                                String type = rs.getString("type");
                                int age = rs.getInt("age");
                                String state = rs.getString("state");
                                int score = rs.getInt("score");
//                                   System.out.println(id + " " + name + " " + type + " " +age + " " +state + " " + score);

                                   Athlete test = new Athlete(id, name,type, age, state, score);
//                                   sqlAthlete.add(test);
//                                   Ozlympic.comp.add(test);
                				
                                if (test.getType().equals("Cyclist")) {				
                       				Cyclist cycleIn = new Cyclist(id, name,type, age, state, score);
                       				Ozlympic.comp.add(cycleIn);				
                       			}
                       			
                       			else if (test.getType().equals("Swimmer")) {
                       				Swimmer SwimIn = new Swimmer(id, name,type, age, state, score);
                       				Ozlympic.comp.add(SwimIn);				
                       			}
                       			
                       			else if (test.getType().equals("Sprinter")) {				
                       				Sprinter SprintIn = new Sprinter(id, name,type, age, state, score);
                       				Ozlympic.comp.add(SprintIn);				
                       			}
                       			else if (test.getType().equals("Super")) {
                       				SuperAthlete SuperIn = new SuperAthlete(id, name,type, age, state, score);
                       				Ozlympic.comp.add(SuperIn);		
                       			} else if (test.getType().equals("Official")) {
                       				Official OffIn = new Official(id, name,type, age, state, score);
                       				Ozlympic.offs.add(OffIn);				
                       			}
            }
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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