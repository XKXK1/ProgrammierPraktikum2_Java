//package aufgabenblatt3;
//
//public class simulationRangierbahnhof implements Runnable {
//
//	@Override
//	public void run() {
//		
//		Rangierbahnhof bahnhof = new Rangierbahnhof();
//		while (!Thread.currentThread().isInterrupted()) {
//			try {
//				bahnhof.erzeugeLokfuehrer(bahnhof);
//
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				System.err.println("Thread wurde durch Interrupt angesprochen");
//				Thread.currentThread().interrupt();
//			}
//		}
//		System.err.println("Thead beendet");
//		
//	}
//	
//
//}
