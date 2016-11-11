package aufgabenblatt3;

public class RangierbahnhofTest {

	public static void main(String[] args) {
		Rangierbahnhof bahnhof = new Rangierbahnhof();
		Lokfuehrer Hans = new Lokfuehrer(bahnhof);
		Hans.start();
		
		
	}
}
