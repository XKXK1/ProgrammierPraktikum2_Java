package aufgabenblatt3;

public class simulationRangierbahnhof implements Runnable {
	Rangierbahnhof bahnhof;
	
	public simulationRangierbahnhof(bahnhofGUI gui) {
		this.bahnhof = new Rangierbahnhof();
		this.bahnhof.addObserver(gui);	
	}
	
	public Zug[] getGleisArr() {
		return bahnhof.getGleisArr();
	}

	@Override
	public void run() {
		
		while (!Thread.currentThread().isInterrupted()) {
			try {
				bahnhof.erzeugeLokfuehrer(bahnhof);

				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.err.println("Thread wurde durch Interrupt angesprochen");
				Thread.currentThread().interrupt();
			}
		}
		System.err.println("Thead beendet");
		
	}
	

}
