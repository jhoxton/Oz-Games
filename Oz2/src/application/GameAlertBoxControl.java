package application;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameAlertBoxControl {
	
	@FXML
	private Button sprint;
	@FXML
	private Button cycle;
	@FXML
	private Button swim;
	
	@FXML//This leads to the Game choice scene
	private void selectGame(ActionEvent event) throws IOException {
		
		Parent gamePage =FXMLLoader.load(getClass().getResource("GameSelect.fxml"));
		Scene gamePageScene = new Scene(gamePage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(gamePageScene);
		thisStage.show();		
	}

	@FXML
	private void sprintEvent(ActionEvent event) throws IOException {
		
		Event currentEvent = Ozlympic.selectGame(1);		
		ArrayList<Athlete> loadArray = new ArrayList<Athlete>();
		
		loadArray = Ozlympic.comp;//Copies the all athletes to a new array		
		
//		ArrayList<Athlete> competeingArray = currentEvent.loadEvent(loadArray);
		//This was the old implmentation
		
		Ozlympic.competeingArray = currentEvent.loadEvent(loadArray);
		
		for(int i = 0; i < Ozlympic.competeingArray.size(); i++) {			
			Athlete currentAthlete = Ozlympic.competeingArray.get(i);			
			System.out.println("Type: " + currentAthlete.getType() + "Name: " + currentAthlete.getName());
			
		}
		
		Ozlympic.upcoming = currentEvent;
		
		//Runs "loadEvent"(which selects eligible athletes for the event) and copies them to
		//"competeingArray", which will be used to run the Game
		
			
//				System.out.println("AND BELOW IS THE COMP ARRAY");
//				for(int i = 0; i <  Ozlympic.comp.size(); i++) {			
//					Athlete currentAthlete = Ozlympic.comp.get(i);			
//					System.out.println("Type: " + currentAthlete.getType());
//					System.out.println("Name: " + currentAthlete.getName());
//					
//				} System.out.println("=======");
//		
		//TODO Change event to abstarct, cast when accessing 
		
		Parent gamePage =FXMLLoader.load(getClass().getResource("GameSelect.fxml"));
		Scene gamePageScene = new Scene(gamePage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(gamePageScene);
		thisStage.show();	
		
	}

	
	@FXML
	private void cycleEvent(ActionEvent event) throws IOException{
//		Event currentEvent = Ozlympic.selectGame(2);		
////		Ozlympic.selectGame(2);
//		ArrayList<Athlete> loadArray = Ozlympic.comp;
		Event currentEvent = Ozlympic.selectGame(2);		
		ArrayList<Athlete> loadArray = new ArrayList<Athlete>();
		
		loadArray = Ozlympic.comp;//Copies the all athletes to a new array	
		
//		ArrayList<Athlete> competeingArray = currentEvent.loadEvent(loadArray);
		//This was the old implmentation
		
		Ozlympic.competeingArray = currentEvent.loadEvent(loadArray);
		
		for(int i = 0; i < Ozlympic.competeingArray.size(); i++) {			
			Athlete currentAthlete = Ozlympic.competeingArray.get(i);			
			System.out.println("Type: " + currentAthlete.getType() + "Name: " + currentAthlete.getName());
			
		}
		//TODO For some reason super athletes aren't being added here. Breakpoints
	
				
		Parent gamePage =FXMLLoader.load(getClass().getResource("GameSelect.fxml"));
		Scene gamePageScene = new Scene(gamePage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(gamePageScene);
		thisStage.show();			 
	}
	@FXML
	private void swimEvent(ActionEvent event) throws IOException{
		Event currentEvent = Ozlympic.selectGame(3);				
		ArrayList<Athlete> loadArray = Ozlympic.comp;
		
//		ArrayList<Athlete> competeingArray = currentEvent.loadEvent(loadArray);
		//This was the old implmentation
		
		Ozlympic.competeingArray = currentEvent.loadEvent(loadArray);
		
		//TODO For some reason super athletes aren't being added here. Breakpoints
				
		Parent gamePage =FXMLLoader.load(getClass().getResource("GameSelect.fxml"));
		Scene gamePageScene = new Scene(gamePage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(gamePageScene);
		thisStage.show();			 
	}

}


