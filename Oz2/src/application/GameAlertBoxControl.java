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
	/**
	 * Advanced Programming Semester 1 2017 Assignment 2
	 *
	 * @author Jake Novak s3609685
	 *
	 * github: github.com/jhoxton/AP
	 *
	 */	
	@FXML
	private Button sprint;
	@FXML
	private Button cycle;
	@FXML
	private Button swim;
	

	@FXML
	private void sprintEvent(ActionEvent event) throws IOException {

		Ozlympic.eligableAthletes.clear();				
		Event currentEvent = Ozlympic.selectGame(1);//Selects game on Ozlymopic object
		ArrayList<Athlete> loadArray = new ArrayList<Athlete>();//Blank Athlete array		
		loadArray = Ozlympic.comp;//Copies the all athlete references to the loadArray array

		Ozlympic.eligableAthletes = currentEvent.loadEvent(loadArray);
		Ozlympic.upcoming = currentEvent; //Sets the next event as "upcoming" in Ozlympic

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


