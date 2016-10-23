package aufgabenblatt2_3;

public class Flugzeug extends Thread {
	private Flughafen flughafen;
	private String id;
	private int flugdauer;
	private int startzeit;
	private int zeitLandeanflug;
	public Status status;

	public Flugzeug(String id, int flugdauer, Flughafen flughafen, int startzeit) {
		this.id = id;
		this.flugdauer = flugdauer;
		this.flughafen = flughafen;
		this.startzeit = startzeit;
		this.status = Status.IM_FLUG;
	}

	@Override
	public void run() {
		while (!isInterrupted()) {
			if (flughafen.getZeit() - this.startzeit >= this.flugdauer) {
				if (flughafen.landebahnFrei) {
					this.status = Status.IM_LANDEANFLUG;
					this.zeitLandeanflug = flughafen.getZeit();
					flughafen.landebahnFrei = false;

				}

			}
			if (this.status == Status.IM_LANDEANFLUG) {
				if (flughafen.getZeit() - this.zeitLandeanflug >= 1500) {
					this.status = status.GELANDET;
					flughafen.landebahnFrei = true;
					flughafen.anzahlFlugzeuge--;
					interrupt();

				}

			}

		}

	}

	public void istGelandet() {
		if (isGelandet()) {
			status = Status.GELANDET;
		}
	}

	@Override
	public String toString() {
		if(flugdauer - (flughafen.getZeit() - this.startzeit)<=0){
			return "\nFlugzeug " + id + " (" + status + ", Zeit bis Ziel: 0 )";
		}
		return "\nFlugzeug " + id + " (" + status + ", Zeit bis Ziel: "
				+ (flugdauer - (flughafen.getZeit() - this.startzeit)) + ")";
	}

	public boolean isGelandet() {

		istGelandet();
		return true;
	}

}
