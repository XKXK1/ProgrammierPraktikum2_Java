package aufgabenblatt2_3;

import java.util.ArrayList;
import java.util.List;

public class Flughafen extends Thread {
	Flugzeug flugzeug;
	private int anzahlFlugzeuge;
	int flugzeugNummer = 1000;
	List<Flugzeug> flugzeuge = new ArrayList();

	public Flughafen(int anzahlFlugzeuge) {
		this.anzahlFlugzeuge = anzahlFlugzeuge;
	}

	public void landen(Flugzeug flugzeug) {
	}

	@Override
	public void run() {

		while (!isInterrupted()) {
			//erzeuge Flugzeuge
			//falls flugzeug gelandet erzeuge flugzeug
			//globale Zeit fortlaufend
			
			try {
				Thread.sleep(500);
				flugzeug.setZeit(1);
			} catch (InterruptedException e) {
				System.err.println("Thread wurde durch Interrupt angesprochen");
			}
			System.out.println("Momentane Zeit:");
		}
		System.err.println("Thead beendet");
	}

	private Flugzeug erzeugeFlugzeug(Flughafen flughafen,int startzeit){
		flugzeugNummer++;
		int flugdauer = (int) (Math.random()*10);
		String flugzeugName = String.valueOf(flugzeugNummer);
		
		Flugzeug flugzeug = new Flugzeug(flugzeugName,flugdauer, flughafen, startzeit);
		return flugzeug;	
	}

	public static void main(String[] args) {
		Flughafen flughafenHamburg = new Flughafen(1);
		flughafenHamburg.start();
	}
}
