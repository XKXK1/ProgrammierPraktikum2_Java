package aufgabenblatt3;

import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * @author Derya Uyargil, Daniel von Drathen
 * 
 * Diese Klasse dient zum Anzeigen des Bahnhofs als grafische Oberflaeche. Die
 * implementiert das Observer-Interface, da sie auf die Updates ihres
 * Observierten Klasse(Rangierbahnhof) angewiesen ist um sich entsprechend zu
 */
public class BahnhofGUI extends Application implements Observer {

	private SimulationRangierbahnhof simulation;
	private Pane root;

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Laden der im Scene-Builder erstellten grafischen Oberflaeche
		root = FXMLLoader.load(getClass().getResource("main.fxml"));

		// Erstellen der Szene mit der grafischen Oberflaeche Weite:400px
		// Hoehe:400px
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setTitle("Simulation Rangierbahnhof");
		primaryStage.setScene(scene);
		// Anzeigen der Stage
		primaryStage.show();

		// Erstellen und Starten der Simulation
		simulation = new SimulationRangierbahnhof(this);
		Thread simulationThread = new Thread(simulation);
		simulationThread.start();

		// Beenden des erstellten SimulationsThreads durch Schliessen des
		// GUI-Fensters
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				simulationThread.interrupt();
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Die update-Methode wird vom Observer-Interface geerbt. Sie wird immer
	 * dann aufgerufen wenn im Observierten Objekt die Methode
	 * "notifyObservers();" aufgerufen wird.
	 * @param arg0
	 * @param arg
	 */
	@Override
	public void update(Observable arg0, Object arg) {
		// Die Gleise des Bahnhofs werden Ueberprueft
		for (int i = 0; i < simulation.getGleisArr().length; i++) {
			if (simulation.getGleisArr()[i] != null) {
				// Bei besetztem Gleis
				printGleisBesetzt(i);
			} else {
				// Bei freiem Gleis
				printGleisFrei(i);
			}
		}
	}

	/**
	 * Das erwartet Argument des gleisIndexes wird verarbeitet und dann auf den
	 * Zustand:Frei gesetzt d.h.: Beschriftung des Gleises und Abbildung des
	 * Zuges aendern.
	 * 
	 * @param gleisIndex
	 */
	public void printGleisFrei(int gleisIndex) {
		// Erstellen von Rectangle und Textobjekt um die Children bearbeiten zu
		// koennen
		Rectangle rect;
		Text text;

		// Die zu veraendernden Elemente muessen auf das jeweilige Element
		// gecastet werden um eine Veraenderung zu bewirken
		text = (Text) (root.getChildren().get(12 + gleisIndex));
		rect = (Rectangle) (root.getChildren().get(9 + gleisIndex));

		Platform.runLater(() -> {
			text.setText(gleisIndex + ": FREI");
			rect.setFill(Color.TRANSPARENT);
		});
	}

	/**
	 * Das erwartet Argument des gleisIndexes wird in der Switch-Abfrage
	 * verarbeitet und dann auf den Zustand:Besetzt gesetzt d.h.: Beschriftung
	 * des Gleises und Abbildung des Zuges aendern(Rot faerben).
	 * 
	 * @param gleisIndex
	 */
	public void printGleisBesetzt(int gleisIndex) {

		// Erstellen von Rectangle und Textobjekt um die Children bearbeiten zu
		// koennen
		Rectangle rect;
		Text text;

		// Die zu veraendernden Elemente muessen auf das jeweilige Element
		// gecastet werden um eine Veraenderung zu bewirken
		text = (Text) (root.getChildren().get(12 + gleisIndex));
		rect = (Rectangle) (root.getChildren().get(9 + gleisIndex));

		Platform.runLater(() -> {
			text.setText(gleisIndex + ": BESETZT");
			rect.setFill(Color.RED);
		});
	}
}
