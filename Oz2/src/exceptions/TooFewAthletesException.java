package exceptions;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
	/*
 	Alert Box tutorial by thenewboston at
 	https://www.youtube.com/watch?v=SpL3EToqaXA
	*/


public class TooFewAthletesException extends Exception{
	
	public TooFewAthletesException(String errMsg) {
		System.out.println("Too Few Athletes Exception Run");
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinWidth(300);
		window.setMinHeight(100);
		
		Label label = new Label();
		label.setText(errMsg);
		Button close = new Button("Close");
		
		close.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, close);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
	}
}
