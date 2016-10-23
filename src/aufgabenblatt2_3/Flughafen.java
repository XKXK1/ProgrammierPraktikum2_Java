package aufgabenblatt2_3;

import java.util.ArrayList;
import java.util.List;

public class Flughafen extends Thread {
	Flugzeug flugzeug;
	public int anzahlFlugzeuge;
	private final int MAX_FLUGZEUGE = 3;
	int flugzeugNummer = 1000;
	private int zeit;
	public boolean landebahnFrei = true;

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
			System.out.format("\nMomentane Zeit: %d", zeit);
		}
		System.err.println("Thead beendet");
	}

	private Flugzeug erzeugeFlugzeug(Flughafen flughafen, int startzeit) {
		flugzeugNummer++;
		anzahlFlugzeuge++;
		int flugdauer = (int) (Math.random() * 10);
		String flugzeugName = String.valueOf(flugzeugNummer);

		Flugzeug flugzeug = new Flugzeug(flugzeugName, flugdauer, flughafen, startzeit);
		return flugzeug;
	}

	public static void main(String[] args) {
		Flughafen flughafenHamburg = new Flughafen(1);
		flughafenHamburg.start();
	}

	public int getZeit() {
		return zeit;
	}
}
