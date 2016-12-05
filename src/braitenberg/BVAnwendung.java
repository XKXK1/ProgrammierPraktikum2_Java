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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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

	@Override
	public void start(Stage primaryStage) {
		// Simulation zusammenstellen
		BVSimulation sim = erzeugeSimulationsszene();

		// Canvas setzen
		BVCanvas canvas = new BVCanvas(600, 600, sim);

		canvas.zeichneSimulation();

		// Szenengraph aufbauen
		primaryStage.setTitle("Braitenberg-Vehikel!");
		BorderPane wurzel = new BorderPane();
		wurzel.setCenter(canvas);

		VBox vbox = new VBox(2);
		wurzel.setRight(vbox);

		// Button zum Simulieren
		Button knopf = new Button("Simuliere!");
		knopf.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				sim.simulationsSchritt();
				;
			}
		});
		vbox.getChildren().add(knopf);

		// Checkbox hinzufuegen
		Thread simulationThread = new Thread(sim);
		CheckBox auswahlbox = new CheckBox("Simuliere");
		auswahlbox.setOnAction((event) -> {
			if (auswahlbox.isSelected()) {
				simulationThread.start();
			} else {
				simulationThread.interrupt();
			}
		});

		// Vbox zum anordnen der Elemente
		vbox.getChildren().add(auswahlbox);
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(50, 50, 10, 20));

		vehikelKontrolleGui.kontrollElementeErstellen(sim, vbox);

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

		canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
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
