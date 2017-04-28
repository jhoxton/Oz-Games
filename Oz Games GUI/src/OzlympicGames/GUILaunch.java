package OzlympicGames;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUILaunch extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		primaryStage.setTitle("Ozlympics");
		primaryStage.setScene(new Scene(root, 300, 275));
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
