package aufgabenblatt3;

public class Rangierbahnhof {
	private int anzGleise = 3;
	private Zug gleis[] = new Zug[anzGleise];
	private Object monitor1 = new Object();
	private Object monitor2 = new Object();

	public synchronized void einfahren() {
		synchronized (monitor1) {
			for(int i = 0; i < anzGleise; i++){
				if (gleis[i]==null){
					gleis[i]= new Zug();
				}
			}

		}
	}

	public synchronized void ausfahren() {
		synchronized (monitor2) {
			for(int i = 0; i < anzGleise; i++){
				if (gleis[i]!=null){
					gleis[i]= null;
				}
			}
		}

	}

}
