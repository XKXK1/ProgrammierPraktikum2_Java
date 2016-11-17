package aufgabenblatt3.daniel;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Controll extends Application implements Observer{
  private ZugSimulation sim;
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
    sim = new ZugSimulation(this);
    sim.start();


    // Beenden des erstellten SimulationsThreads durch Schliessen des
    // GUI-Fensters
    primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

      @Override
      public void handle(WindowEvent event) {
        sim.interrupt();
      }});
  }

  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Die update-Methode wird vom Observer-Interface geerbt. Sie wird immer
   * dann aufgerufen wenn im Observierten Objekt die Methode
   * "notifyObservers();" aufgerufen wird.
   */
  @Override
  public void update(Observable arg0, Object arg) {
    // Die Gleise des Bahnhofs werden Ueberprueft
    for (int i = 0; i < sim.getGleisArr().length; i++) {
      if (sim.getGleisArr()[i] != null) {
        // Bei besetztem Gleis
        printGleisBesetzt(i);
      } else {
        // Bei freiem Gleis
        printGleisFrei(i);
      }
    }
  }

  /**
   * Das erwartet Argument des gleisIndexes wird in der Switch-Abfrage
   * verarbeitet und dann auf den Zustand:Frei gesetzt d.h.: Beschriftung des
   * Gleises und Abbildung des Zuges aendern.
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
    switch (gleisIndex) {
    case 0:
      text = (Text) (root.getChildren().get(12));
      text.setText("Gleis 0: FREI");
      rect = (Rectangle) (root.getChildren().get(9));
      rect.setFill(Color.TRANSPARENT);
      break;
    case 1:
      text = (Text) (root.getChildren().get(13));
      text.setText("Gleis 0: FREI");
      rect = (Rectangle) (root.getChildren().get(10));
      rect.setFill(Color.TRANSPARENT);
      break;
    case 2:
      text = (Text) (root.getChildren().get(14));
      text.setText("Gleis 0: FREI");
      rect = (Rectangle) (root.getChildren().get(11));
      rect.setFill(Color.TRANSPARENT);
      break;
    }
  }

  /**
   * Das erwartet Argument des gleisIndexes wird in der Switch-Abfrage
   * verarbeitet und dann auf den Zustand:Besetzt gesetzt d.h.: Beschriftung des
   * Gleises und Abbildung des Zuges aendern(Rot faerben).
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
    switch (gleisIndex) {
    case 0:
      text = (Text) (root.getChildren().get(12));
      text.setText("Gleis 0: BESETZT");
      rect = (Rectangle) (root.getChildren().get(9));
      rect.setFill(Color.RED);
      break;
    case 1:
      text = (Text) (root.getChildren().get(13));
      text.setText("Gleis 0: BESETZT");
      rect = (Rectangle) (root.getChildren().get(10));
      rect.setFill(Color.RED);
      break;
    case 2:
      text = (Text) (root.getChildren().get(14));
      text.setText("Gleis 0: BESETZT");
      rect = (Rectangle) (root.getChildren().get(11));
      rect.setFill(Color.RED);
      break;
    }
  }
}
