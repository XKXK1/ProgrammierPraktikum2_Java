package aufgabenblatt1aufgabe2;

import java.time.LocalDateTime;

public class Messung {

	private double wert;
	private String zeitstempel;
	
	public Messung(double wert){
		this.wert = wert;
		this.zeitstempel = LocalDateTime.now().toString();
		}

	@Override
	public String toString() {
		return "Messung [wert=" + wert + ", zeitstempel=" + zeitstempel + "]\n";
	}
}
