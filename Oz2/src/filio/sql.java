package filio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ozlympic.Athlete;
import ozlympic.Cyclist;
import ozlympic.Official;
import ozlympic.Ozlympic;
import ozlympic.Sprinter;
import ozlympic.SuperAthlete;
import ozlympic.Swimmer;

public class sql {
	/**
	 * Advanced Programming Semester 1 2017 Assignment 2
	 *
	 * @author Jake Novak s3609685
	 *
	 * github: github.com/jhoxton/AP
	 *
	 */
	private Connection connect() {     
        String url = "jdbc:sqlite:participants.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        	
        } catch (SQLException e) {
            System.out.println(e.getMessage()); //Change exception here
        } 
        return conn;
    }
    public void selectAll(){
  
        String sql = "SELECT id, name, type, age, state, score FROM participants";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
       
            while (rs.next()) {//Loops through the database

                				int id = rs.getInt("id"); 
                                String name = rs.getString("name"); 
                                String type = rs.getString("type");
                                int age = rs.getInt("age");
                                String state = rs.getString("state");
                                int score = rs.getInt("score");
                                
                                   Athlete test = new Athlete(id, name,type, age, state, score);
                				
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
        	
        	
        } 
    }
}