package aufgabenblatt3;

/**
 * Diese Klasse repraesentiert die Simulation eines Rangierbahnhofs. Es wird ein
 * Rangierbahnhof erstellt. Alle 500ms wird ein Lokfuehrer erzeugt, welcher nur
 * eine Aufgabe hat(Ein- oder Ausfahren auf ein bestimmtes Gleis.
 *
 */
public class simulationRangierbahnhof implements Runnable {
	
	private Rangierbahnhof bahnhof;

	/**
	 * Der Konstruktor erwartet als Argument ein bahnhofGUI-Objekt. Dies wird
	 * benötigt um dem Bahnhof(Observable) das Observer-Objekt(In diesem Fall
	 * unser GUI) zu übergeben.
	 */
	public simulationRangierbahnhof(bahnhofGUI gui) {
		this.bahnhof = new Rangierbahnhof();
		this.bahnhof.addObserver(gui);
	}

	/**
	 * Dieser Getter bekommt, den Wert vom Getter des GleisArrays des
	 * BahnhofsObjekts.
	 */
	public Zug[] getGleisArr() {
		return bahnhof.getGleisArr();
	}

	/**
	 * Der Thread erzeugt alle 500ms einen neuen Lokfuehrer.
	 */
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				bahnhof.erzeugeLokfuehrer(bahnhof);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.err.println("Thread wurde durch Interrupt angesprochen");
				Thread.currentThread().interrupt();
			}
		}
		System.err.println("Thead beendet");
	}
}
