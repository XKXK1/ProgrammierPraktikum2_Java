package aufgabenblatt3;

public class RangierbahnhofTest {

	public static void main(String[] args) {
		Object monitor = new Object();
		Rangierbahnhof HBF = new Rangierbahnhof(monitor);
		HBF.start();
	}
}
