package aufgabenblatt3;

public class Lokfuehrer extends Thread {
	private Rangierbahnhof bahnhof;
	private String lokfuehrerName;
	private double job;

	public Lokfuehrer(Rangierbahnhof bahnhof, String name) {
		this.bahnhof = bahnhof;
		this.lokfuehrerName = name;
		job = Math.random() * 2;
	}

	public String getLokfuehrerName() {
		return lokfuehrerName;
	}

	@Override
	public void run() {
		while (!isInterrupted()) {
			if (job <= 1) {
				bahnhof.warteschlange.add(this);
				bahnhof.einfahren(lokfuehrerName);				
			} else {
					bahnhof.ausfahren(lokfuehrerName);
					bahnhof.warteschlange.add(this);
			}
			interrupt();
		}
	}

}
