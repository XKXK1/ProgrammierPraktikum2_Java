package aufgabenblatt2_3;

import java.util.ArrayList;
import java.util.List;

public class Flughafen extends Thread {
  Flugzeug flugzeug;
  public int anzahlFlugzeuge = 0;
  private final int MAX_FLUGZEUGE = 10;
  int flugzeugNummer = 1000;
  private int zeit;
  public boolean landebahnFrei = true;
  String[] fluggesellschaft = {"Lufthansa", "Air Berlin", "Air France",
      "EuroWings", "Turkish Airlines"};

  List<Flugzeug> flugzeuge = new ArrayList<Flugzeug>();

  public Flughafen(int anzahlFlugzeuge) {
    this.anzahlFlugzeuge = anzahlFlugzeuge;
  }

  public void landen(Flugzeug flugzeug) {
  }

  @Override
  public void run() {

    while (!isInterrupted()) {
      try {
        if (anzahlFlugzeuge <= MAX_FLUGZEUGE) {
          flugzeuge.add(erzeugeFlugzeug(this, zeit));
        }
        Thread.sleep(500);
        zeit += 500;
      } catch (InterruptedException e) {
        System.err.println("Thread wurde durch Interrupt angesprochen");
      }
      System.out.format(this.toString());

      for (int i = 0; i < flugzeuge.size(); i++) {
        if (flugzeuge.get(i).isGelandet()) {
          flugzeuge.remove(i);
        }
      }
    }
    System.err.println("Thead beendet");
  }

  private Flugzeug erzeugeFlugzeug(Flughafen flughafen, int startzeit) {
    String flugzeugName = fluggesellschaft[(int)(Math.random()*fluggesellschaft.length)] + " " + (int) (Math.random()*9000);
    flugzeugNummer++;
    anzahlFlugzeuge++;
    int flugdauer = (int) ((Math.random() + 1) * 5000);

    Flugzeug flugzeug = new Flugzeug(flugzeugName, flugdauer, flughafen,
        startzeit);
    flugzeug.start();
    System.out.println("->Neues Flugzeug wurde erzeugt: " + flugzeug);
    return flugzeug;
  }

  @Override
  public String toString() {
    String ausgabe = "Zeit: " + zeit;
    try {
      for (int i = 0; i < flugzeuge.size(); i++) {
        ausgabe += flugzeuge.get(i).toString();
      }
    } catch (IndexOutOfBoundsException e) {
      System.err.println("Index vom Flugzeugarray ist out of Bounds");
    }

    return ausgabe + "\n \n";
  }

  public static void main(String[] args) {
    Flughafen flughafenHamburg = new Flughafen(1);
    flughafenHamburg.start();
  }

  public int getZeit() {
    return zeit;
  }
}
