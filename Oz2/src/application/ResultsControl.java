package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ResultsControl {
	
	@FXML
	private Button returnToMenu;
	@FXML
	private TextArea resultsBox;

	@FXML
	private void initialize() {
		resultsBox.appendText("First place is: " + Ozlympic.upcoming.getWinner() + " at " + Ozlympic.upcoming.getFirstTime());
		resultsBox.appendText("\nSecond place is: " + Ozlympic.upcoming.getSecond() + " at " + Ozlympic.upcoming.getSecondTime());
		resultsBox.appendText("\nThird place is: " + Ozlympic.upcoming.getThird() + " at " + Ozlympic.upcoming.getThirdTime());
		resultsBox.appendText("\n  ");
	}
	
	@FXML
	private void returnToMainMenu(ActionEvent event) throws IOException {
		
		Ozlympic.updateFile();//This appends the results to the output file

		Ozlympic.eventSet = false; //Set as false so when the main menu runs again, the event object is set as null (line 73 Controller.java)

		Ozlympic.finishEvent();
		Ozlympic.eligableAthletes.clear();
		Ozlympic.eventAthletes.clear();

		Parent menuPage =FXMLLoader.load(getClass().getResource("Menu.fxml"));
		Scene menuPageScene = new Scene(menuPage);
		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(menuPageScene);
		thisStage.show();
		
	}
	@FXML
	private void reLaunchMenu(ActionEvent event) throws IOException {
		
//		Parent menuPage =FXMLLoader.load(getClass().getResource("Menu.fxml"));
//		Scene menuPageScene = new Scene(menuPage);
//		Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		thisStage.setScene(menuPageScene);
//		thisStage.show();
	}
	
}
