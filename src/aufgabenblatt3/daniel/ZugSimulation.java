package aufgabenblatt3.daniel;

public class ZugSimulation extends Thread {
  private Rangierbhf bahnhof;

  public ZugSimulation(Controll gui) {
    bahnhof = new Rangierbhf();
    bahnhof.addObserver(gui);
  }

  public Zug[] getGleisArr() {
    return bahnhof.getGleisArr();
  }

  @Override
  public void run() {
    while (!interrupted()) {
      try {
        bahnhof.erzeugeLokfhr(bahnhof);
        Thread.sleep(500);
      } catch (InterruptedException e) {
        System.err.println("Thread wurde durch Interrupt angesprochen");
        Thread.currentThread().interrupt();
      }
    }
    System.err.println("Thead beendet");
  }

  public static void main(String[] args) {

  }
}
