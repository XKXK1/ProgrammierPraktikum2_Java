package aufgabenblatt3;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Rangierbahnhof extends Observable implements Runnable {

	private final Object monitor;
	private int zeit;
	int zahl = 0;

	public Rangierbahnhof(Object monitor) {
		this.monitor = monitor;
	}

	public List<Lokfuehrer> warteschlange = new ArrayList<Lokfuehrer>();
	
	private Zug[] gleisArr = new Zug[3];

	public void einfahren(String lokfuehrername) {
		synchronized (monitor) {
			warteschlange.remove(Thread.currentThread());
			try {
				for (int i = 0; i < gleisArr.length; i++) {
					if (gleisArr[i] == null) {
						gleisArr[i] = new Zug();
						setChanged();
						notifyObservers(gleisArr);
						System.out.println(lokfuehrername + " faehrt den Zug ein");
						Thread.sleep(2000);
						i = gleisArr.length;
					} else {
						System.out.println("Alle gleise Voll.");
						monitor.wait();
					}
				}
			} catch (InterruptedException e) {
			}
			monitor.notifyAll();
		}
	}

	public void ausfahren(String lokfuehrername) {
		synchronized (monitor) {
			warteschlange.remove(Thread.currentThread());
			try {
				for (int i = 0; i < gleisArr.length; i++) {
					if (gleisArr[i] != null) {
						gleisArr[i] = null;
						setChanged();
						notifyObservers(gleisArr);
						System.out.println(lokfuehrername + " faehrt den Zug aus");
						Thread.sleep(2000);
						i = gleisArr.length;
					} else {
						System.out.println("Kein gleis belegt.");
						monitor.wait();
					}
				}
			} catch (InterruptedException e) {
			}
			monitor.notifyAll();
		}
	}

	private Lokfuehrer erzeugeLokfuehrer(Rangierbahnhof bahnhof) {
		String lokfuehrerName = "Lokfuehrer " + zahl;
		Lokfuehrer lokfuehrer = new Lokfuehrer(bahnhof, lokfuehrerName);
		lokfuehrer.start();
		System.out.println("->Neues Lokfuehrer beginnt seine Arbeit: " + lokfuehrerName + "\n");
		zahl++;
		return lokfuehrer;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				System.out.println("\nZEIT: " + zeit);
				zeit++;
				erzeugeLokfuehrer(this);

				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println("Thread wurde durch Interrupt angesprochen");
				Thread.currentThread().interrupt();
			}
		}
		System.err.println("Thead beendet");
	}

}
