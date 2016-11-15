package aufgabenblatt3;

import java.util.Observable;

/**
 * Die Klasse Rangierbahnhof hat eine feste Anzahl von Gleisen. Auf jedem Gleis
 * kann nur genau ein Zug stehen.
 * 
 */
public class Rangierbahnhof extends Observable implements Runnable {

	private int anzahlGleise = 3;
	private int zeit;
	private int lokfuehrerzahl = 0;

	private Zug[] gleisArr = new Zug[anzahlGleise];

	public int getAnzahlGleise() {
		return anzahlGleise;
	}

	public synchronized void einfahren(String lokfuehrername, int gleis) {
		try {
			if (gleisArr[gleis] != null) {
				this.wait();
			} else {
				gleisArr[gleis] = new Zug();
				setChanged();
				notifyObservers(gleisArr);
				System.out.println(lokfuehrername + " faehrt den Zug ein--> GLEIS: " + gleis);
				Thread.sleep(0);
				this.notifyAll();
			}
		} catch (InterruptedException e) {
		}
	}

	public synchronized void ausfahren(String lokfuehrername, int gleis) {
		try {
			if (gleisArr[gleis] == null) {
				this.wait();
			} else {
				gleisArr[gleis] = null;
				setChanged();
				notifyObservers(gleisArr);
				System.out.println(lokfuehrername + " faehrt den Zug aus--> GLEIS: " + gleis);
				Thread.sleep(0);
				this.notifyAll();
			}
		} catch (InterruptedException e) {
		}
	}

	public Lokfuehrer erzeugeLokfuehrer(Rangierbahnhof bahnhof) {
		String lokfuehrerName = "Lokfuehrer " + lokfuehrerzahl;
		Lokfuehrer lokfuehrer = new Lokfuehrer(bahnhof, lokfuehrerName);
		lokfuehrer.start();
		System.out.println("->Neues Lokfuehrer beginnt seine Arbeit: " + lokfuehrerName + "\n");
		lokfuehrerzahl++;
		return lokfuehrer;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				System.out.println("\nZEIT: " + zeit);
				zeit++;
				erzeugeLokfuehrer(this);

				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.err.println("Thread wurde durch Interrupt angesprochen");
				Thread.currentThread().interrupt();
			}
		}
		System.err.println("Thead beendet");
	}

	public Zug[] getGleisArr() {
		return gleisArr;
	}

}
