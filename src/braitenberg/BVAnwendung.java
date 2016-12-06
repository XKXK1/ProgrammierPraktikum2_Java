/**
 * Prof. Philipp Jenke
 * Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package braitenberg;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import braitenberg.braitenbergvehikel.BVBewegungAbstossung;
import braitenberg.braitenbergvehikel.BVBewegungAttraktion;
import braitenberg.braitenbergvehikel.BVSimulation;
import braitenberg.braitenbergvehikel.BraitenbergVehikel;
import braitenberg.braitenbergvehikel.Vektor2;
import braitenberg.view.BVCanvas;

/**
 * JavaFX Anwendung zur Darstellung und Interaktion mit einer
 * Braitenberg-Vehikel-Simulation.
 * 
 * @author Philipp Jenke
 */
public class BVAnwendung extends Application {

	private VehikelKontrolleGui vehikelKontrolleGui = new VehikelKontrolleGui();
	private Thread simulationThread;

	@Override
	public void start(Stage primaryStage) {
		// Simulation zusammenstellen
		BVSimulation sim = erzeugeSimulationsszene();

		// Canvas setzen
		BVCanvas canvas = new BVCanvas(600, 600, sim);

		// Simulation wird erstmalig gezeichnet
		canvas.zeichneSimulation();

		// Szenengraph aufbauen
		primaryStage.setTitle("Braitenberg-Vehikel!");
		BorderPane wurzel = new BorderPane();
		wurzel.setCenter(canvas);

		// Vbox wird an der rechten Seite erstellt(zum hinzufuegen der
		// Kontrollelemente)
		VBox vbox = new VBox();
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(20, 50, 10, 20));
		wurzel.setRight(vbox);

		// Ueberschrift fuer Bewegungsrichtung
		Label ueberschrift1 = new Label("Simulation");
		ueberschrift1.setFont(Font.font(null, FontWeight.BOLD, 20));
		vbox.getChildren().add(ueberschrift1);

		// Button zum Simulieren
		Button knopf = new Button("Simuliere!");
		// Event wenn Button gedrueckt wird
		knopf.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				sim.simulationsSchritt();
				;
			}
		});
		vbox.getChildren().add(knopf);

		// Checkbox zum Starten/Schliessen eine SimulationThreads
		CheckBox auswahlbox = new CheckBox("Simuliere");
		auswahlbox.setOnAction((event) -> {

			if (auswahlbox.isSelected()) {
				simulationThread = new Thread(sim);
				simulationThread.start();

			} else {
				simulationThread.interrupt();
			}
		});
		vbox.getChildren().add(auswahlbox);

		// Ueberschrift fuer Bewegungsrichtung
		Label ueberschrift2 = new Label("Bewegungsrichtung");
		ueberschrift2.setFont(Font.font(null, FontWeight.BOLD, 20));
		vbox.getChildren().add(ueberschrift2);

		// Erstellt Kontrollelemente fuer alle Vehikel der Simulation
		vehikelKontrolleGui.kontrollElementeErstellen(sim, vbox);

		// Fuegt alle Comboboxen als Listener mit dem dazugehoerigen Fahrzeug
		// hinzu
		for (int i = 0; i < vehikelKontrolleGui.getComboboxen().size(); i++) {
			final int vehikelnummer = i;
			vehikelKontrolleGui.getComboboxen().get(i).getSelectionModel().selectedItemProperty()
					.addListener((v, oldValue, newValue) -> {
						if (newValue == "ATTRAKTION") {
							sim.getVehikel(vehikelnummer).setBewegung(new BVBewegungAttraktion());
						} else {
							sim.getVehikel(vehikelnummer).setBewegung(new BVBewegungAbstossung());
						}
					});
		}

		// Signal per Mausclick setzen
		canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// Mauskoordinaten werden in Weltkoordinaten umgerechnet
				sim.setSignal(event.getX() - canvas.getWidth() / 2, canvas.getHeight() / 2 - event.getY());
			}
		});

		primaryStage.setScene(new Scene(wurzel, 850, 600));
		primaryStage.show();
	}

	/**
	 * Erzeugt eine Simulationsszene zum Testen.
	 */
	public BVSimulation erzeugeSimulationsszene() {
		BraitenbergVehikel vehikel1 = new BraitenbergVehikel("Susi", new BVBewegungAttraktion());
		BraitenbergVehikel vehikel2 = new BraitenbergVehikel("Mike", new BVBewegungAbstossung(), new Vektor2(-100, 100),
				new Vektor2(1, 0));
		BVSimulation sim = new BVSimulation();
		sim.vehikelHinzufuegen(vehikel1);
		sim.vehikelHinzufuegen(vehikel2);

		return sim;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
