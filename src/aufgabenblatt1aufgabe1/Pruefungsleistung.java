package aufgabenblatt1aufgabe1;
/**
 * 
 * @author Derya Uyargil, Daniel von Drathen
 * 
 * Ein Objekt der Klasse Pruefungsleistung besteht aus "note"(int) und "modulname"(String).
 * Er repraesentiert eine Pruefungsleistung eines Studenten.
 *
 */

public class Pruefungsleistung {
	private int note;
	private String modulname;
	
	/**
	 * Der Konstruktor erwartet folgende zwei Argumente:
	 * @param note
	 * @param modulname
	 */
	public Pruefungsleistung(int note, String modulname){
		this.note = note;
		this.modulname = modulname;
	}
	/**
	 * Ueberschreiben der toString Methode
	 *  Note und Modulname werden ausgegeben.
	 */

	@Override
	public String toString() {
		return "Pruefungsleistung [note=" + note + ", modulname=" + modulname + "]";
	}

}
