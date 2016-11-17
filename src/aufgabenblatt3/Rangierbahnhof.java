package aufgabenblatt3;

import java.util.Observable;

/**
 * Die Klasse Rangierbahnhof hat eine feste Anzahl von Gleisen. Auf jedem Gleis
 * kann nur genau ein Zug stehen. Zuege koennen einfahren und Ausfahren, jedoch
 * nicht beides gleichzeitig. Es gibt nur ein Gleis welches zum Ein/Ausfahren
 * benutzt werden kann.
 * 
 */
public class Rangierbahnhof extends Observable {

	private int anzahlGleise = 3;
	private int lokfuehrerzahl = 0;
	private Zug[] gleisArr = new Zug[anzahlGleise];

	/**
	 * Die einfahren-Methode setzt den Thread in den "Wartemodus" wenn das zu
	 * befahrende Gleis schon besetzt sein sollte. Falls das Gleis frei ist wird
	 * dort ein neues Zug-Objekt erstellt. Diese Veraenderung wird dem Observer
	 * mitgeteilt. Bei erfolgreichem ausfuehren dieser Methode werden alle
	 * "wartenden" Threads aufgeweckt.Sowohl die ausfahren- als auch
	 * einfahren-Methode sind synchronized. Somit teilen sie sich einen
	 * statischen Monitor der fuer die gesamte Klasse gilt. Dadurch wird
	 * sichergestellt, dass diese beiden Methoden nur nacheinander ausfuehrbar
	 * sind.
	 * 
	 * @param lokfuehrername
	 * @param gleis
	 */
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

	/**
	 * Die ausfahren-Methode setzt den Thread in den "Wartemodus" wenn das zu
	 * befahrende Gleis leer sein sollte. Falls das Gleis besetzt ist wird das
	 * dortige Zug-Objekt entfernt. Diese Veraenderung wird dem Observer
	 * mitgeteilt. Bei erfolgreichem ausfuehren dieser Methode werden alle
	 * "wartenden" Threads aufgeweckt. Sowohl die ausfahren- als auch
	 * einfahren-Methode sind synchronized. Somit teilen sie sich einen
	 * statischen Monitor der fuer die gesamte Klasse gilt. Dadurch wird
	 * sichergestellt, dass diese beiden Methoden nur nacheinander ausfuehrbar
	 * sind.
	 * 
	 * @param lokfuehrername
	 * @param gleis
	 */
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

	/**
	 * Zum erstellen eines Lokfuehrer-Objektes. Dieser bekommt einen Namen der von 0 bis n hochgezaehlt wird.
	 * Die Methode erwartet ein Rangierbahnhof-Objekt, d
	 * @param bahnhof
	 * @return
	 */
	public Lokfuehrer erzeugeLokfuehrer(Rangierbahnhof bahnhof) {
		String lokfuehrerName = "Lokfuehrer " + lokfuehrerzahl;
		Lokfuehrer lokfuehrer = new Lokfuehrer(bahnhof, lokfuehrerName);
		lokfuehrer.start();
		System.out.println("->Neuer Lokfuehrer beginnt seine Arbeit: " + lokfuehrerName + "\n");
		lokfuehrerzahl++;
		return lokfuehrer;
	}

	public Zug[] getGleisArr() {
		return gleisArr;
	}

	public int getAnzahlGleise() {
		return anzahlGleise;
	}
}
