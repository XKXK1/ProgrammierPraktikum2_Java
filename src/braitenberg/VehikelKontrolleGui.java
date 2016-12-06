package braitenberg;

import java.util.ArrayList;
import java.util.List;
import braitenberg.braitenbergvehikel.BVSimulation;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;

/**
 * Diese Klasse erstellt Kontrollelemente (Combobox zur Auswahl der Bewegungsart
 * plus Namen des jeweiligen Vehikels) für alle Vehikel der Simulation.
 *
 * @author Derya Uyargil, Daniel von Drathen
 */
public class VehikelKontrolleGui {
	// Erstellen von Listen fuer die Kontrollelemente
	private List<Label> labels = new ArrayList<Label>();
	private List<ComboBox<String>> comboboxen = new ArrayList<ComboBox<String>>();
	// Splitpanes werden erstellt damit Label und Combobox nebeneinander
	// angezeigt werden.
	private List<SplitPane> splitpanes = new ArrayList<SplitPane>();

	/**
	 * Diese Methode fuegt einer schon bestehenden der GUI kontrollelemente zum
	 * Aendern der Bewegungsrichtung Hinzu. Jedes Vehikel bekommt sein eigenes
	 * Label und Dropdown-Menue.
	 * 
	 * @param sim
	 * @param vbox
	 */
	public void kontrollElementeErstellen(BVSimulation sim, VBox vbox) {

		for (int i = 0; i < sim.getAnzahlVehike(); i++) {
			// Splitpane zur visuellen aufteilung von Label und Combobox
			splitpanes.add(new SplitPane());

			// Adden des Dropdown-Menues mit den Bewegungsrichtungen
			comboboxen.add(new ComboBox<String>(FXCollections.observableArrayList("ATTRAKTION", "ABSTOSSUNG")));
			// Die aktuelle Bewegungsrichtung wird vorausgewaehlt angezeigt
			comboboxen.get(i).setValue(sim.getVehikel(i).getBewegung().getId());

			// Jedes Vehikel hat sein eigenes Label
			labels.add(new Label(sim.getVehikel(i).getName()));

			// Hinzufuegen von Label und Combobox zum Splitpane
			splitpanes.get(i).getItems().addAll(labels.get(i), comboboxen.get(i));
			// Splitpane ohne Rand anzeigen
			splitpanes.get(i).setStyle("-fx-box-border: transparent;");

			// Hinzufuegen der Elemente an die uebergebene Vbox
			vbox.getChildren().add(splitpanes.get(i));
		}
	}

	public List<ComboBox<String>> getComboboxen() {
		return comboboxen;
	}
}
