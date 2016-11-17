package aufgabenblatt3;

/**
 * @author Derya Uyargil, Daniel von Drathen
 * 
 * Die Lokfuehrer-Klasse hat die Aufgabe mit jedem erstellten Objekt einen
 * Thread zu starten. Dieser Lokfuehrer-Thread hat eine 50:50 Chance nur einen
 * von zwei Aufgaben(einfahren(),ausfahren() auszufuehren. Mit der Erstellung
 * des Objekts wird die Aufgabe festgelegt. Es wird beim Erstellen festgelegt,
 * auf welchem Gleis er dies ausfuehren wird.
 */
public class Lokfuehrer extends Thread {

	private Rangierbahnhof bahnhof;
	private String lokfuehrerName;
	private int gleis;
	private Job job;

	public Lokfuehrer(Rangierbahnhof bahnhof, String name) {
		this.bahnhof = bahnhof;
		this.lokfuehrerName = name;
		if ((Math.random() * 2) > 1) {
			job = Job.EINFAHREN;
		} else {
			job = Job.AUSFAHREN;
		}
		gleis = (int) (Math.random() * bahnhof.getAnzahlGleise());
	}

	/**
	 * Die run Methode des Threads fragt ab, welche Aufgabe der Lokfuehrer hat
	 * undn ruft diese Auf. Nach beenden der Aufgabe wird der Thread beendet.
	 */
	@Override
	public void run() {
		while (!isInterrupted()) {
			if (job == Job.EINFAHREN) {
				bahnhof.einfahren(lokfuehrerName, gleis);
			} else {
				bahnhof.ausfahren(lokfuehrerName, gleis);
			}
			interrupt();
		}
	}
}
