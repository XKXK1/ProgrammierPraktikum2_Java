package aufgabenblatt2_3;

public class Flugzeug extends Thread {
	private Flughafen flughafen;
	private String id;
	private int flugdauer;
	private int startzeit;
	private Status status;

	/**
	 * Der Konstruktor fuer ein Flugzeug-Objekt erwartet folgende argumente:
	 * 
	 * @param id
	 * @param flugdauer
	 * @param flughafen
	 * @param startzeit
	 */
	public Flugzeug(String id, int flugdauer, Flughafen flughafen, int startzeit) {
		this.id = id;
		this.flugdauer = flugdauer;
		this.flughafen = flughafen;
		this.startzeit = startzeit;
		this.status = Status.IM_FLUG;
	}

	/**
	 * Die Methode run() wird redefiniert. Diese Methode laeuft in einer
	 * Dauerschleife, bis der Thread durch interrupt() oder einen
	 * Programmabbruch beendet wird. Falls ein Flugzeug noch nicht angekommen
	 * ist, schlaeft dieser Thread fuer 250ms um Ressourcen zu sparen. Falls ein
	 * Flugzeug angekommen ist wird die Methode landeanflug() aus der Klasse
	 * Flughafen aufgerufen um den Landeanflug einzuleiten.
	 * 
	 */
	@Override
	public void run() {
		while (!isInterrupted()) {
			// Wenn das Objekt die Bedingung fuer eine Ankunft noch nicht
			// erfuellt, schlaeft der Thread fuer 250ms um Ressourcen zu sparen
			while (!ankunft()) {
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					System.err.println("Thread wurde durch Interrupt angesprochen");
					interrupt();
				}
			}
			// Die Bedingung fuer eine Ankunft sind erfuellt und der Landeanflug
			// von diesem Objekt wird eingeleitet
			flughafen.landeanflug(this);
		}
	}

	/**
	 * Die Methode ankunft() vom typ Boolean liefert "true", wenn die Bedingung
	 * fuer die Ankunft erfuellt sind, falls nicht wird "false" zurueckgeliefert
	 * 
	 * @return
	 */
	public boolean ankunft() {
		// Die Globale Zeit - die Startzeit des Objektes muss groesser/gleich
		// der Flugdauer von diesem Objekt sein um die Bedingung fuer eine
		// ankunft zu erfuellen
		// Beispiel: Globale Zeit=5 Startzeit=3 Flugdauer=2.
		// 5-3=2 -> Bedingung erfuellt
		if (flughafen.getZeit() - this.startzeit >= this.flugdauer) {
			return true;
		}
		return false;
	}

	/**
	 * Die Methode istGelandet() aendert den Status eines Flugzeug-Objektes auf
	 * "Gelandet" und beendet seinen Thread
	 */
	public void istGelandet() {
		if (this.status == Status.IM_LANDEANFLUG) {

			this.status = Status.GELANDET;
			// Beenden des Thtreads
			interrupt();
		}
	}

	/**
	 * Die Methode isGelandet() vom typ Boolean liefert "true" wenn der Status
	 * des Flugzeugs "Gelandet" ist, falls nicht dann false.
	 * 
	 * @return
	 */
	public boolean isGelandet() {
		if (status == Status.GELANDET) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		if (flugdauer - (flughafen.getZeit() - this.startzeit) <= 0) {
			return "\nFlugzeug " + id + " (" + status + ", Zeit bis Ziel: 0 )";
		}
		return "\nFlugzeug " + id + " (" + status + ", Zeit bis Ziel: "
				+ (flugdauer - (flughafen.getZeit() - this.startzeit)) + ")";
	}
	
	public void setStatus(Status status){
		this.status = status;
	}
}
