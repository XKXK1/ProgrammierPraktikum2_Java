package aufgabenblatt2_3;

public class Flugzeug extends Thread {
  private Flughafen flughafen;
  private String id;
  private int flugdauer;
  private int startzeit;
  public Status status;

  public Flugzeug(String id, int flugdauer, Flughafen flughafen,
      int startzeit) {
    this.id = id;
    this.flugdauer = flugdauer;
    this.flughafen = flughafen;
    this.startzeit = startzeit;
    this.status = Status.IM_FLUG;
  }

  @Override
  public void run() {
    while (!isInterrupted()) {
      while (!ankunft()) {
        try {
          Thread.sleep(250);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      flughafen.landeanflug(this);
    }
  }

  public boolean ankunft() {
    if (flughafen.getZeit() - this.startzeit >= this.flugdauer) {
      return true;
    }
    return false;
  }

  public void istGelandet() {
    if (this.status == Status.IM_LANDEANFLUG) {

      this.status = Status.GELANDET;
      flughafen.anzahlFlugzeuge--;
      interrupt();
    }
  }

  public boolean isGelandet() {
    if (status == Status.GELANDET) {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    if (flugdauer - (flughafen.getZeit() - this.startzeit) <= 0) {
      return "\nFlugzeug " + id + " (" + status + ", Zeit bis Ziel: 0 )";
    }
    return "\nFlugzeug " + id + " (" + status + ", Zeit bis Ziel: "
        + (flugdauer - (flughafen.getZeit() - this.startzeit)) + ")";
  }

}
