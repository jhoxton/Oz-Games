package application;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.event.Event;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class GameController {
	
	@FXML
	private Button home;
	
	@FXML 
	private Button display;

	@FXML
	private ChoiceBox add;
	
	@FXML
	private TextArea info;
	
	
	@FXML
	//TODO Be sure that is doesn't remove or clear any data about the Athletes or Event
	private void menu(ActionEvent event) throws IOException {
		Parent menuPage =FXMLLoader.load(getClass().getResource("Menu.fxml"));
		Scene menuPageScene = new Scene(menuPage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(menuPageScene);
		thisStage.show();		
	}
	@FXML
	private void addToEvent() {		
		
	}
	@FXML
	private void print() {
		info.setText("");
						
			info.appendText("Name: " + Ozlympic.upcoming.getName());
		
		}
	
	
	
	  
}