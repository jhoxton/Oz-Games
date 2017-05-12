package app;
	

import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
//				public static Ozlympic oz = new Ozlympic();

				
	public static Stage primaryStage;
	private Scene scene1;
	private Scene scene2;

	public void primaryStage() throws IOException { //Sets up the primary stage
		
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/gui/Menu.fxml"));
			Scene scene = new Scene(root,460,400);
			scene.getStylesheets().add(getClass().getResource("/gui/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();	
	}

	@Override
	public void start(Stage primaryStage) {
		try {	
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Ozlympic Games");			
			primaryStage();		
		}	catch(Exception e) {
				e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {			
	Ozlympic.outputFile();//Makes a new "gameResults.txt" file in Ozlympic
	Ozlympic.importData();
		launch(args);	
	}
	

}
