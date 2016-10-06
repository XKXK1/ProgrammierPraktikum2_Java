package aufgabenblatt1aufgabe3;

public class ListenTester {

	/**
	 * Uebreprueft die Uebergeben Liste nach dem ersten Element. Wenn dieses
	 * eine Nummer enthaellt, wird "true" zurueckgegeben ansonsten "false"
	 * 
	 * @param liste
	 * @return
	 */
	public static boolean listenTest(ArrayListe<?> liste) {
		if (liste.get(0) instanceof Number && liste.get(0) != null) {
			return true;
		}
		return false;

	}

}
