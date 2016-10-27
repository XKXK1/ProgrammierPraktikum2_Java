package aufgabenblatt2_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse Flughafen repraesentiert eine Simulation eines Flughafens. Ein
 * Flughafen hat eine Liste von Flugzeugen die randomisiert erstellt werden. Es
 * ist immer nur einem Flugzeug gleichzeitig gestattet einen Landeanflug zu
 * durchlaufen, alle anderen Flugzeuge muessen in der Zeit warten. Es werden so
 * lange Flugzeugobjekte erstellt und gestartet, bis die vordefinierte
 * Maximalanzahl in der Liste erreicht ist. Wenn ein Flugzeug gelandet ist, wird
 * es aus der Liste entfernt und ein neues Flugzeug wird erstellt.
 * 
 * @author Derya Uyargil, Daniel von Drathen
 *
 */

public class Flughafen extends Thread {
	private final int STEP_LENGTH = 500; //Zeiteinheit in ms
	private int maxFlugzeuge;
	private int zeit;
	private String[] fluggesellschaft = { "Lufthansa", "Air Berlin", "Air France", "EuroWings", "Turkish Airlines" };
	private List<Flugzeug> flugzeuge = new ArrayList<Flugzeug>();

	/**
	 * Konstruktor für einen Flughafen. Als Argument kann die maximale Anzahl an
	 * Flugzeug-Objekten uebergeben werden.--
	 * 
	 * @param maxFlugzeuge
	 */
	public Flughafen(int maxFlugzeuge) {
		this.maxFlugzeuge = maxFlugzeuge;
	}

	/**
	 * Die Methode run() wird redefiniert. Diese Methode laeuft in einer
	 * Dauerschleife, bis der Thread durch interrupt() oder einen
	 * Programmabbruch beendet wird. Die Schleife erstellt solange
	 * Flugzeugobjekte die zuvor uebergebene Zahl der maximalen Flugzeuge
	 * erreicht ist. Sobald ein Flugzeug gelandet ist wird ein neues
	 * Flugzeugobjekt erstellt. Im sekundentakt wir der Status des Flughafens
	 * ausgegeben.
	 */
	@Override
	public void run() {

		while (!isInterrupted()) {
			try {
				// Solange die Anzahl der Flugzeuge < maximale Anzahl der
				// FLugzeuge wird ein neues Flugzeugobjek der Flugzeug-Liste
				// hinzugefügt
				if (flugzeuge.size() <= maxFlugzeuge) {
					flugzeuge.add(erzeugeFlugzeug(this, zeit));
				}
				// Der Thread schlaeft fuer 1000ms und die globale Zeit des
				// Flughafens wird um 1 erhoet
				Thread.sleep(STEP_LENGTH);
				zeit++;
			} catch (InterruptedException e) {
				System.err.println("Thread wurde durch Interrupt angesprochen");
				interrupt();
			}
			System.out.format(this.toString());
			// Falls ein Flugzeugzeug-Objekt der Liste gelandet ist wird dieses
			// aus der Liste entfernt
			for (int i = 0; i < flugzeuge.size(); i++) {
				if (flugzeuge.get(i).isGelandet()) {
					flugzeuge.remove(i);
				}
			}
		}
		System.err.println("Thead beendet");
	}

	/**
	 * landeanflug(Flugzeug flugzeug) ist eine synchronisierte Methode, welche
	 * immer nur 1 Flugzeug zur in den Status "Im Landeanflug" setzt am ende der
	 * Methode wird die Methode "istGelandet()" aufgerufen. Ein Flugzeugobjekt
	 * wird als Argument erwartet.
	 * 
	 * @param flugzeug
	 */

	public synchronized void landeanflug(Flugzeug flugzeug) {
		flugzeug.setStatus(Status.IM_LANDEANFLUG);
		try {
			// Der Thread schlaeft 3000ms. Diese Zeit repraesentiert die
			// Landezeit
			Thread.sleep(STEP_LENGTH*3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		flugzeug.istGelandet();
	}

	/**
	 * Die Methode erzeugeFlugzeug dient zum Erstellen eines randomisierten
	 * Flugzeug-Objektes. Es wird ein zufaelliger Fluggesellschaftsname aus
	 * einem String[] gewaehlt,eine zufaellige Flugzeugnummer und eine
	 * zufaellige flugdauer hinzugefuegt. Als Argument wird der Flughafen und
	 * die Startzeit des Flugzeugs erwartet. Am Ende der Methode wird ein
	 * Flugzeug-Objekt zurueckgegeben.
	 * 
	 * @param flughafen
	 * @param startzeit
	 * @return
	 */
	private Flugzeug erzeugeFlugzeug(Flughafen flughafen, int startzeit) {
		// Der String des Flugzeugnamen wird mit zufaelligem Namen aus dem
		// String[] fluggesellschaft und einer Zahl bis 9000 erstellt
		String flugzeugName = fluggesellschaft[(int) (Math.random() * fluggesellschaft.length)] + " "
				+ (int) (Math.random() * 9000);
		// ***noch abzufangen, dass nicht 2 mal die gleiche Zahl vorkommt
		// flugzeugNummer++;
		// die Anzahl der Fluege wird hochgezaehlt damit das Programm in der
		// run() testen kann ob schon genug Objekte erstell wurden
		int flugdauer = (int) ((Math.random() + 1) * 9);

		// Der Konstruktor der Klasse Flugzeug wird aufgerufen um die Argumente
		// zu uebergeben.
		Flugzeug flugzeug = new Flugzeug(flugzeugName, flugdauer, flughafen, startzeit);
		// Der Thread des erstellten Flugzeug wird gestartet
		flugzeug.start();
		System.out.println("->Neues Flugzeug wurde erzeugt: " + flugzeug + "\n");
		return flugzeug;
	}

	@Override
	public String toString() {
		String ausgabe = "Zeit: " + zeit;
		try {
			for (int i = 0; i < flugzeuge.size(); i++) {
				ausgabe += flugzeuge.get(i).toString();
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Index vom Flugzeugarray ist out of Bounds");
		}

		return ausgabe + "\n \n";
	}

	public int getZeit() {
		return zeit;
	}
}
