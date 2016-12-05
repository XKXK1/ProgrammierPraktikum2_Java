package braitenberg;

import java.util.ArrayList;
import java.util.List;
import braitenberg.braitenbergvehikel.BVSimulation;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;

public class VehikelKontrolleGui {
	private List<Label> labels = new ArrayList<Label>();
	private List<ComboBox<String>> comboboxen = new ArrayList<ComboBox<String>>();
	private List<SplitPane> splitpanes = new ArrayList<SplitPane>();

	public void kontrollElementeErstellen(BVSimulation sim, VBox vbox) {

		for (int i = 0; i < sim.getAnzahlVehike(); i++) {
			splitpanes.add(new SplitPane());
			labels.add(new Label(sim.getVehikel(i).getName()));
			comboboxen.add(new ComboBox<String>(FXCollections.observableArrayList("ATTRAKTION", "ABSTOSSUNG")));
			splitpanes.get(i).getItems().add(labels.get(i));
			splitpanes.get(i).getItems().add(comboboxen.get(i));
			vbox.getChildren().add(splitpanes.get(i));
			splitpanes.get(i).setStyle("-fx-box-border: transparent;");
			comboboxen.get(i).setValue(sim.getVehikel(i).getBewegung().getId());
		}
	}

	public List<ComboBox<String>> getComboboxen() {
		return comboboxen;
	}
}
