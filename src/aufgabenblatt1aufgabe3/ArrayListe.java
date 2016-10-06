package aufgabenblatt1aufgabe3;

/**
 * 
 * @author Derya Uyargil, Daniel von Drathen
 * 
 *         Die ArrayListe erzeugt ein Objekt, welches ein normales Array um
 *         funktionen erweitert. Der Generische Datentyp T wird durch den
 *         Typebound von Comparable T eingeschraenkt. Hierduch wird die
 *         Kompatibilitaet zu Compare sichergestellt.
 *
 */

public class ArrayListe<T extends Comparable<T>> {
	private int anzahlElemente = 0;
	private Object[] elemente = new Object[2];

	/**
	 * Methode zum hinzufuegen eines Elementes in das Array. Falls das
	 * vorhandene Array nicht genuegend Platz bietet, wird zunaechst die Groesse
	 * des Arrays verdoppelt.
	 * 
	 * @param element
	 */
	public void hinzufuegen(T element) {
		if (getAnzahlElemente() == elemente.length) {
			Object[] duplicate = new Object[elemente.length * 2];
			System.arraycopy(elemente, 0, duplicate, 0, elemente.length);
			elemente = duplicate;
		}
		elemente[anzahlElemente] = (Object) element;
		anzahlElemente++;

	}

	/**
	 * Diese Methode returnt den Wert an dem uebergebenen Index, fall es einen
	 * gibt.
	 * 
	 * @param index
	 * @return
	 */
	public T get(int index) {
		try {
			return (T) elemente[index];
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Es gibt kein Element an dieser Stelle!");
			return null;
		}
	}

	/**
	 * Entfernt das, als Argument uebergebene Element, falls vorhanden. Hierfuer
	 * wird die Methode entferneElementAnIndex aufgerufen.
	 * 
	 * @param element
	 */
	public void entfernen(T element) {
		if (getAnzahlElemente() > 0) {
			for (int i = 0; i < anzahlElemente; i++) {
				if (element.equals(elemente[i])) {
					entferneElementAnIndex(i);
				}
			}
			System.out.println("Kein Element gefunden das diesen Wert besitzt!");
		} else {
			System.out.println("Dies ist nicht die Liste die du Suchst!");
		}
	}

	/**
	 * Ueberschreibt das Element am uebergebene Index mit dem naechsten wert aus
	 * der Liste. Dies Wiederholt er bis er am Ende der Liste angekommen ist.
	 * 
	 * @param index
	 */
	public void entferneElementAnIndex(int index) {
		if (get(index) != null) {
			for (int i = index; i < elemente.length - 1; i++) {
				elemente[i] = elemente[i + 1];
			}
			elemente[elemente.length - 1] = null;

			anzahlElemente--;
		}
	}

	public int getAnzahlElemente() {
		return anzahlElemente;
	}

	@Override
	public String toString() {
		String ausgabe = "";
		for (int i = 0; i < getAnzahlElemente(); i++) {
			ausgabe += elemente[i] + "\n";
		}
		return ausgabe;
	}

	/**
	 * Eine Methode zum ermitteln des kleinsten Elementes aus der Liste.
	 * Hierfuer wird jedes Element der Liste mit dem Vorigen kleinsten Element
	 * verglichen.
	 * 
	 * @return
	 */
	public T getKleinstesElement() {
		if (anzahlElemente == 0) {
			return null;
		} 
		T kleinstes_element = (T) elemente[0];
		
		for (int i = 0; i < anzahlElemente; i++) {
			if (kleinstes_element.compareTo((T) elemente[i]) > 0) {
				kleinstes_element = (T) elemente[i];
			}
		}
		return kleinstes_element;
	}
}
