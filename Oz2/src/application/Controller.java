package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

	@FXML
	Button button1  = new Button();

	@FXML
	Label label1  = new Label ();
	
	Ozlympic oz = new Ozlympic();

	public void testClick(){
		button1.setOnAction(e -> {
			System.out.println("dasd");
			label1.setText("fg");
		});
	}
}
