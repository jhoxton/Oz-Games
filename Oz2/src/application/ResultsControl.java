package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ResultsControl {
	
	@FXML
	private Button returnToMenu;
	@FXML
	private TextArea resultsBox;

	@FXML
	private void initialize() {
//		resultsBox.appendText("Ahhhhh yeeeahh");
		resultsBox.appendText("First place is: " + Ozlympic.upcoming.getWinner() + " at " + Ozlympic.upcoming.getFirstTime());
		resultsBox.appendText("\nSecond place is: " + Ozlympic.upcoming.getSecond() + " at " + Ozlympic.upcoming.getSecondTime());
		resultsBox.appendText("\nThird place is: " + Ozlympic.upcoming.getThird() + " at " + Ozlympic.upcoming.getThirdTime());
	}
	
	@FXML
	private void returnToMainMenu() {
		Ozlympic.updateFile();
		
	}
	
}
