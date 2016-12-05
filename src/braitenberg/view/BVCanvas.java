package braitenberg.view;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import braitenberg.braitenbergvehikel.BVSimulation;
import braitenberg.braitenbergvehikel.BraitenbergVehikel;
import braitenberg.braitenbergvehikel.Vektor2;

/**
 * Zeichenfläche für eine Braitenberg-Vehikle-Simulation.
 * 
 * @author Philipp Jenke
 */
public class BVCanvas extends Canvas implements Observer {

  /**
   * Bild eines Vehikels. Achtung: Package mit dem Bild muss korrekt angegeben
   * werden.
   */
  private Image bvImage =
      new Image("braitenberg/assets/braitenberg_vehikel.png");
  
  private Image bvAttr =
      new Image("braitenberg/assets/icon_attraktion.png");
  
  private Image bvAbst =
      new Image("braitenberg/assets/icon_abstossung.png");

  /**
   * Referenz auf die Simulation.
   */
  private final BVSimulation sim;

  public BVCanvas(int breite, int hoehe, BVSimulation sim) {
	  super(breite, hoehe);  
	  this.sim = sim;
	  this.sim.addObserver(this); 
  }

  /**
   * Zeichnet die gesamte Simulation neu.
   */
  public void zeichneSimulation() {
    GraphicsContext gc = getGraphicsContext2D();
    // Alles löschen
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, getWidth(), getHeight());
    // Vehikel zeichnen
    for (int i = 0; i < sim.getAnzahlVehike(); i++) {
      zeichneVehikel(gc, sim.getVehikel(i));
    }
    // Signal zeichnen
    zeichneSignal(gc, sim.getSignal());
  }

  /**
   * Rechnet von Welt- und Bild-Koordinaten um.
   */
  public Point welt2BildKoordinaten(Vektor2 position) {
    return new Point((int) (position.x() + getWidth() / 2),
        (int) (getHeight() / 2 - position.y()));
  }

  /**
   * Rotiert den aktuellen Grafik-Kontext (zum Zeichnen eines rotierten Bildes).
   */
  private void rotieren(GraphicsContext gc, double winkel, double px,
      double py) {
    Rotate r = new Rotate(winkel, px, py);
    gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(),
        r.getTy());
  }

  /**
   * Zeichnet ein Bild gedreht.
   */
  private void zeichneGedrehtesBild(GraphicsContext gc, Image image,Image richtung,String name,
      double winkel, double x, double y) {
    // Zustand auf dem Stack sichern
    gc.save();
    rotieren(gc, winkel, x + image.getWidth() / 2, y + image.getHeight() / 2);
    gc.drawImage(image, x, y);
    gc.drawImage(richtung, x+45, y);
    gc.setFill(Color.BLACK);
    gc.fillText(name, x+15, y+60);
    // Zustand wiederherstellen
    gc.restore();
  }

  /**
   * Zeichnet ein Braitenberg-Vehikel.
   */
  protected void zeichneVehikel(GraphicsContext gc, BraitenbergVehikel bv) {
    Point p = welt2BildKoordinaten(bv.getPosition());
    double winkelInGrad = bv.getRotationGradImUhrzeigersinn();
    int x = (int) (p.x - bv.getSeitenlaenge() / 2);
    int y = (int) (p.y - bv.getSeitenlaenge() / 2);
    String name = bv.getName();
    if(bv.getBewegung().getId()=="ATTRAKTION"){
    zeichneGedrehtesBild(gc, bvImage,bvAttr,name, winkelInGrad, x, y);
    }else{
      zeichneGedrehtesBild(gc, bvImage,bvAbst,name, winkelInGrad, x, y);
    }
  }

  /**
   * Zeichnet das Signal.
   */
  private void zeichneSignal(GraphicsContext gc, Vektor2 signal) {
    int breite = 10;
    int offset = 2;
    Point p = welt2BildKoordinaten(signal);
    gc.setFill(Color.BLACK);
    gc.fillOval(p.x - breite / 2 - offset, p.y - breite / 2 - offset,
        breite + offset * 2, breite + offset * 2);
    gc.setFill(Color.YELLOW);
    gc.fillOval(p.x - breite / 2, p.y - breite / 2, breite, breite);
  }

  @Override
  public void update(Observable o, Object arg) {
    // Zeichenroutine wird im JavaFX-Thread aufgerufen.
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        zeichneSimulation();
      }
    });
  }
}
