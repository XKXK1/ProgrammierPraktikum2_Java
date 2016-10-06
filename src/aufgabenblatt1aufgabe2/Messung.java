package aufgabenblatt1aufgabe2;

/**
 * 
 * @author Derya Uyargil, Daniel von Drathen
 * 
 *         Ein Objekt der KlasseMessung besteht aus "wert"(double) und
 *         "zeitstempel"(String). Er repraesentiert eine Messung eines
 *         Sensor-Objektes.
 *
 */
public class Messung {

	private double wert;
	private String zeitstempel;

	public Messung(double wert, String zeitstempel) {
		this.wert = wert;
		this.zeitstempel = zeitstempel;
	}

	public double getWert() {
		return wert;
	}

	public String getZeitstempel() {
		return zeitstempel;
	}
}
