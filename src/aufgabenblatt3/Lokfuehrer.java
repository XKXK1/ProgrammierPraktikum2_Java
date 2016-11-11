package aufgabenblatt3;

public class Lokfuehrer extends Thread{
	Rangierbahnhof bahnhof;
	
	public Lokfuehrer(Rangierbahnhof bahnhof){
		this.bahnhof = bahnhof;
	}
	
	@Override
	public void run() {
		while (!isInterrupted()) {
				try {
					Thread.sleep(500);
					bahnhof.einfahren();
					System.out.println("\nEin Lokfuehrer faehrt die Bahn auf gleis 1 ein.");
					interrupt();
				} catch (InterruptedException e) {
					System.err.println("Thread wurde durch Interrupt angesprochen");
					interrupt();
				}


		}
	}

}
