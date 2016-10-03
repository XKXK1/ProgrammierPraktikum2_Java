package aufgabenblatt1aufgabe1;

public class Pruefungsleistung {
	private int note;
	private String modulname;
	
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
