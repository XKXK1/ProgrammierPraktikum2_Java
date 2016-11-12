package aufgabenblatt3;

import java.util.ArrayList;
import java.util.List;

public class Rangierbahnhof extends Thread {
	private int anzGleise = 3;
	private final Object monitor;
	private int zeit;

	public Rangierbahnhof(Object monitor) {
		this.monitor = monitor;
	}

	private List<Zug> gleise = new ArrayList<Zug>();
	private String[] lokfuehrerBuero = { "Hans", "Willi", "Werner", "Udo", "Ralf" };

	public void einfahren() {
		synchronized (monitor) {
			while (gleise.size() == anzGleise) {
				try {
					System.out.println("***Alle gleise sind besetzt. Der fahrer Wartet bis ein Gleis frei ist.");
					monitor.wait();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					return;
				}
			}
			try {
				Thread.sleep(1500);
				gleise.add(new Zug());
				System.out.println("Zug faehrt ein");
			} catch (InterruptedException e) {
			}
			monitor.notifyAll();
		}

	}

	public void ausfahren() {
		synchronized (monitor) {
			if (gleise.size() == 0) {
				System.out.println("***Es ist kein Zug zum ausfahren vorhanden.");

			} else {
				try {
					Thread.sleep(1500);
					for (int i = 0; i < gleise.size(); i++) {
						if (gleise.get(i) != null) {
							gleise.remove(i);
							System.out.println("Zug faehrt aus");
						}
					}
				} catch (InterruptedException e) {
				}
			}
		}
	}

	private Lokfuehrer erzeugeLokfuehrer(Rangierbahnhof bahnhof) {
		String lokfuehrerName = lokfuehrerBuero[(int) (Math.random() * lokfuehrerBuero.length)];
		Lokfuehrer lokfuehrer = new Lokfuehrer(bahnhof, lokfuehrerName);
		lokfuehrer.start();
		System.out.println("->Neues Lokfuehrer beginnt seine Arbeit: " + lokfuehrerName + "\n");
		return lokfuehrer;
	}

	@Override
	public void run() {
		while (!isInterrupted()) {
			try {
				System.out.println("\nZEIT: " + zeit);
				zeit++;
				erzeugeLokfuehrer(this);
				erzeugeLokfuehrer(this);
				erzeugeLokfuehrer(this);
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				System.err.println("Thread wurde durch Interrupt angesprochen");
				interrupt();
			}
		}
		System.err.println("Thead beendet");
	}
}
