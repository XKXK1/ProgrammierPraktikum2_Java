package aufgabenblatt3;

public class RangierbahnhofTest {

	public static void main(String[] args) {
		Object monitor = new Object();
		Rangierbahnhof HBF = new Rangierbahnhof(monitor);
		Thread RangierbahnhofThread = new Thread(HBF);
		RangierbahnhofThread.start();
		bahnhofObserver observ = new bahnhofObserver(HBF);

	}
}
