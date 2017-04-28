package OzlympicGames;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

	@FXML
	Button button1  = new Button();

	public void testClick(){
		button1.setOnAction(e -> {
			System.out.println("Test!") ;
		});

	}

}
