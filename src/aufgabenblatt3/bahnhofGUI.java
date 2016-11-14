package aufgabenblatt3;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class bahnhofGUI extends Application implements Observer {
	Rangierbahnhof bahnhof;
	private Zug[] gleisArrObs = new Zug[3];

	Rectangle r = new Rectangle();
	Rectangle r1 = new Rectangle();
	Rectangle r2 = new Rectangle();
	
	@FXML
	private Rectangle gleis0;
	
	@FXML
	private Rectangle gleis1;
	
	@FXML
	private Rectangle gleis2;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Object monitor = new Object();
		bahnhof = new Rangierbahnhof(monitor);
		bahnhof.addObserver(this);
		Thread RangierbahnhofThread = new Thread(bahnhof);
		RangierbahnhofThread.start();
		
	      Pane root =
	          (Pane)FXMLLoader.load(getClass().getResource("main.fxml"));		

		Scene scene = new Scene(root, 400, 400);
		root.getChildren().add(gleis0);
		root.getChildren().add(gleis1);
		root.getChildren().add(gleis2);
		

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void updateColorGreen(int index) {
		if (index == 0){
			r.setFill(Color.GREEN);
		} else if (index == 1){
			r1.setFill(Color.GREEN);
		} else if (index == 2){
			r2.setFill(Color.GREEN);
		}
	}
	
	public void updateColorRed(int index) {
		if (index == 0){
			r.setFill(Color.RED);
		} else if (index == 1){
			r1.setFill(Color.RED);
		} else if (index == 2){
			r2.setFill(Color.RED);
		}
	}


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void update(Observable arg0, Object arg) {
		Zug[] gleise = (Zug[]) arg;
		for (int i = 0; i < gleise.length; i++) {
			gleisArrObs[i] = gleise[i];
		}
		printGleise();

	}

	private void printGleise() {
		for (int i = 0; i < gleisArrObs.length; i++) {
			if (gleisArrObs[i] != null) {
				System.out.println("Gleis nummer " + i + " ist besetzt");
				updateColorRed(i);				
			} else {
				System.out.println("Gleis nummer " + i + " ist frei");
				updateColorGreen(i);
			}
		}
	}
}
