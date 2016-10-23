package aufgabenblatt2_3;

public class Flugzeug extends Thread {
	private Flughafen flughafen;
	private String id;
	private int flugdauer;
	private int startzeit;
	private int zeitLandeanflug;
	private Status status;

	public Flugzeug(String id, int flugdauer, Flughafen flughafen, int startzeit) {
		this.id = id;
		this.flugdauer = flugdauer;
		this.flughafen = flughafen;
		this.startzeit = startzeit;
	}

	@Override
	public void run() {
		while (!isInterrupted()) {
			if (flughafen.getZeit() - this.startzeit >= this.flugdauer) {
				if (flughafen.landebahnFrei) {
					this.status = status.IM_LANDEANFLUG;
					this.zeitLandeanflug = flughafen.getZeit();
					flughafen.landebahnFrei = false;

				}
				if (this.status == status.IM_LANDEANFLUG) {
					if (flughafen.getZeit() - this.zeitLandeanflug >= 1500) {
						this.status = status.GELANDET;
						flughafen.landebahnFrei = true;
						flughafen.anzahlFlugzeuge--;
					}

				}

			}

		}

	}

	public void istGelandet() {
		if (isGelandet()) {
			status = status.GELANDET;
		}
	}

	public boolean isGelandet() {

		istGelandet();
		return true;
	}

}
