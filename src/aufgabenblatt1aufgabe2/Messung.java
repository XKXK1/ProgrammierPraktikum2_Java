package aufgabenblatt1aufgabe2;

public class Messung {

  private double wert;
  private String zeitstempel;

  public Messung(double wert, String zeitstempel) {
    this.wert = wert;
    this.zeitstempel = zeitstempel;
  }

  @Override
  public String toString() {
    return "Messung [wert=" + wert + ", zeitstempel=" + zeitstempel + "]\n";
  }
}
