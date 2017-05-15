package exceptions;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class ExceptionAlert extends Exception {
	/**
	 * Advanced Programming Semester 1 2017 Assignment 2
	 *
	 * @author Jake Novak s3609685
	 *
	 * github: github.com/jhoxton/AP
	 *
	 */
	public ExceptionAlert(String errMsg) {
			System.out.println("Exception Caught");
			
			Stage window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			window.setMinWidth(320);
			window.setMinHeight(120);
			
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