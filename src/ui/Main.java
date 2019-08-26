package ui;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("battlefieldGUI.fxml"));
			primaryStage.setScene(new Scene(root));
			primaryStage.setTitle("BattleField Calculator");
<<<<<<< HEAD
			primaryStage.setResizable(false);
=======
>>>>>>> bd8626129c376499f5f97b8fcac076a85a46a853
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}