package aufgabenblatt2_3;

public class Flugzeug extends Thread {
	private Flughafen flughafen;
	private String id;
	private int flugdauer;
	private int startzeit;
	private Status status;
	private int zeit;

	public Flugzeug(String id, int flugdauer, Flughafen flughafen, int startzeit) {
		this.id = id;
		this.flugdauer = flugdauer;
		this.flughafen = flughafen;
		this.startzeit = startzeit;
	}

	@Override
	public void run() {

		// Flug zeit seit start<flugdauer
		// Ueberpruefung = flugzeug gelandet?
		// warten 1500ms

	}

	@Override
	public String toString() {
		return "Flugzeug [flughafen=" + flughafen + ", id=" + id + ", flugdauer=" + flugdauer + ", startzeit="
				+ startzeit + ", status=" + status + ", zeit=" + zeit + "]";
	}

	public void setZeit(int zeit) {
		this.zeit += zeit;
	}

	public int getZeit() {
		return zeit;
	}

	public boolean istGelandet() {
		return true;
	}

}
