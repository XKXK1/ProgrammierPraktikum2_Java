package aufgabenblatt3;

public class Lokfuehrer extends Thread {
	private Rangierbahnhof bahnhof;
	private String name;

	public Lokfuehrer(Rangierbahnhof bahnhof, String name) {
		this.bahnhof = bahnhof;
		this.name = name;
	}

	@Override
	public void run() {
		while (!isInterrupted()) {
			if (Math.random() * 2 <= 1) {
				bahnhof.einfahren();
			} else {
				bahnhof.ausfahren();
			}
			interrupt();
		}
	}

}
