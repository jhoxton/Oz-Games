package application;
import java.io.IOException;
import java.util.ArrayList;

import exceptions.ExceptionAlert;
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
import ozlympic.Athlete;
import ozlympic.Event;
import ozlympic.Official;
import ozlympic.Ozlympic;

public class GameAlertBoxControl {
	
	@FXML
	private Button sprint;
	@FXML
	private Button cycle;
	@FXML
	private Button swim;
//	Official eventOff = Ozlympic.pickOfficial(Ozlympic.offs);
	

	@FXML
	private void sprintEvent(ActionEvent event) throws IOException {
		
//					for(int fuck = 0; fuck < Ozlympic.comp.size(); fuck++) {
//			    		Athlete test = Ozlympic.comp.get(fuck);
//			    		System.out.println("DID YOU FUCKING WORK?\n" + test.getName());   		
//			    	}
//					
		Ozlympic.eligableAthletes.clear();
		
		
		Event currentEvent = Ozlympic.selectGame(1);//Selects game on Ozlymopic object
		ArrayList<Athlete> loadArray = new ArrayList<Athlete>();//Blank Athlete array		
		loadArray = Ozlympic.comp;//Copies the all athlete references to the loadArray array
		

		
		Ozlympic.eligableAthletes = currentEvent.loadEvent(loadArray);
		
		
					
		
//		for(int i = 0; i < Ozlympic.competeingArray.size(); i++) {			
//		Athlete currentAthlete = Ozlympic.competeingArray.get(i);			
//		System.out.println("Type: " + currentAthlete.getType() + "Name: " + currentAthlete.getName());			
//	} TEST LOOP DELETE THIS
		
		Ozlympic.upcoming = currentEvent; //Sets the next event as "upcoming" in Ozlympic
		
//		Ozlympic.upcoming.setOfficial(eventOff);
//		System.out.println(Ozlympic.upcoming.getOfficial().getName());
		//Runs "loadEvent"(which selects eligible athletes for the event) and copies them to
		//"competeingArray", which will be used to run the Game
	
		//TODO Change event to abstarct, cast when accessing 

		Parent gamePage =FXMLLoader.load(getClass().getResource("GameSelect.fxml"));
		Scene gamePageScene = new Scene(gamePage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(gamePageScene);
		thisStage.show();	
		
	}

	
	@FXML
	private void cycleEvent(ActionEvent event) throws IOException{
		
		Ozlympic.eligableAthletes.clear();
		Event currentEvent = Ozlympic.selectGame(2);//Selects game on Ozlymopic object
		ArrayList<Athlete> loadArray = new ArrayList<Athlete>();//Blank Athlete array		
		loadArray = Ozlympic.comp;//Copies the all athletes to a new array		
		
		Ozlympic.eligableAthletes = currentEvent.loadEvent(loadArray);

		Ozlympic.upcoming = currentEvent;

		Parent gamePage =FXMLLoader.load(getClass().getResource("GameSelect.fxml"));
		Scene gamePageScene = new Scene(gamePage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(gamePageScene);
		thisStage.show();	
	}
	
	@FXML
	private void swimEvent(ActionEvent event) throws IOException{
		Ozlympic.eligableAthletes.clear();
		Event currentEvent = Ozlympic.selectGame(3);//Selects game on Ozlymopic object
		ArrayList<Athlete> loadArray = new ArrayList<Athlete>();//Blank Athlete array		
		loadArray = Ozlympic.comp;//Copies the all athletes to a new array		
		
		Ozlympic.eligableAthletes = currentEvent.loadEvent(loadArray);

		Ozlympic.upcoming = currentEvent;

		
		Parent gamePage =FXMLLoader.load(getClass().getResource("GameSelect.fxml"));
		Scene gamePageScene = new Scene(gamePage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(gamePageScene);
		thisStage.show();	
	}

	
}


