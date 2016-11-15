package aufgabenblatt3;

/**
 * Die Lokfuehrer-Klasse hat die Aufgabe mit jedem erstellten Objekt einen
 * Thread zu starten. Dieser Lokfuehrer-Thread hat eine 50:50 Chance nur einen
 * von zwei Aufgaben(einfahren(),ausfahren() auszufuehren. Mit der Erstellung
 * des Objekts wird die Aufgabe festgelegt.
 */
public class Lokfuehrer extends Thread {

	private Rangierbahnhof bahnhof;
	private String lokfuehrerName;
	private double job;
	private int gleis;

	public Lokfuehrer(Rangierbahnhof bahnhof, String name) {
		this.bahnhof = bahnhof;
		this.lokfuehrerName = name;
		job = (int) (Math.random() * 2);
		gleis = (int) (Math.random() * bahnhof.getAnzahlGleise());
	}

	/**
	 * Die run Methode des Threads fragt ab, welche Aufgabe der Lokfuehrer hat
	 * undn ruft diese Auf. Nach beenden der Aufgabe wird der Thread beendet.
	 */
	@Override
	public void run() {
		while (!isInterrupted()) {
			if (job < 1) {
				bahnhof.einfahren(lokfuehrerName, gleis);
			} else {
				bahnhof.ausfahren(lokfuehrerName, gleis);
			}
			interrupt();
		}
	}
}
