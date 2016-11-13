package aufgabenblatt3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class bahnhofGUI extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Fenster mit Knopf!");
		ToggleButton knopf = new ToggleButton();
		knopf.setText("Ich bin ein Knopf!");
		StackPane wurzel = new StackPane();
		wurzel.getChildren().add(knopf);
		primaryStage.setScene(new Scene(wurzel, 300, 250));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}


}
