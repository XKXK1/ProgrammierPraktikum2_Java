package aufgabenblatt3.daniel;

public class Lockfhr extends Thread {
  private Rangierbhf bahnhf;
  private int job;
  private int gleis;

  public Lockfhr(Rangierbhf bahnhf) {
    this.bahnhf = bahnhf;
    job = (int) Math.random() * 2;
    gleis = (int) Math.random() * bahnhf.getAnzGleise();
  }

  @Override
  public void run() {
    while (!interrupted()) {
      if (job == 1) {
        bahnhf.einfahren(gleis);
      } else {
        bahnhf.ausfahren(gleis);
      }
      interrupt();
    }
  }
}
