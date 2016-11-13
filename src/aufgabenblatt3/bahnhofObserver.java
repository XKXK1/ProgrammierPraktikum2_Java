package aufgabenblatt3;



public class bahnhofObserver  implements Observer {

	private Zug[] gleisArrObs = new Zug[3];

	private static int observerIDTracker = 0;

	private int observerID;

	private Rangierbahnhof bahnhof;

	public bahnhofObserver(Rangierbahnhof bahnhof) {
		this.bahnhof = bahnhof;
		this.observerID = observerIDTracker++;

		System.out.println("New Observer " + this.observerID);

		bahnhof.addObserver(this);
	}

	@Override
	public void update(Zug[] gleisArr) {
		for (int i = 0; i < gleisArrObs.length; i++) {
			gleisArrObs[i] = gleisArr[i];
		}
		printGleise();

	}

	private void printGleise() {
		for (int i = 0; i < gleisArrObs.length; i++) {
			if (gleisArrObs[i] != null) {
				System.out.println("Gleis nummer " + i + " ist besetzt");
			} else {
				System.out.println("Gleis nummer " + i + " ist frei");
			}
		}
		System.out.println(observerID + " ");
	}

}















// package aufgabenblatt3;
//
// public class bahnhofObserver implements Observer {
//
// private Zug[] gleisArrObs = new Zug[3];
//
// private static int observerIDTracker = 0;
//
// private int observerID;
//
// private Rangierbahnhof bahnhof;
//
// public bahnhofObserver(Rangierbahnhof bahnhof) {
// this.bahnhof = bahnhof;
// this.observerID = observerIDTracker++;
//
// System.out.println("New Observer " + this.observerID);
//
// bahnhof.addObserver(this);
// }
//
// @Override
// public void update(Zug[] gleisArr) {
// for (int i = 0; i < gleisArrObs.length; i++) {
// gleisArrObs[i] = gleisArr[i];
// }
// printGleise();
//
// }
//
// private void printGleise() {
// for (int i = 0; i < gleisArrObs.length; i++) {
// if (gleisArrObs[i] != null) {
// System.out.println("Gleis nummer " + i + " ist besetzt");
// } else {
// System.out.println("Gleis nummer " + i + " ist frei");
// }
// }
// System.out.println(observerID + " ");
// }
// }
