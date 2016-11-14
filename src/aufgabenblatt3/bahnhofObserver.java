//package aufgabenblatt3;
//
//
//import java.util.Observable;
//import java.util.Observer;
//
//
//
//public class bahnhofObserver implements Observer {
//
//	private Zug[] gleisArrObs = new Zug[3];
//	
//	bahnhofGUI gui;
//	
//	public bahnhofObserver(Rangierbahnhof bahnhof) {
//		bahnhof.addObserver(this);
//	}
//
//	@Override
//	public void update(Observable o, Object arg) {
//		Zug[] gleise = (Zug[]) arg;			
//		for (int i = 0; i < gleise.length; i++) {
//			gleisArrObs[i] = gleise[i];
//		}
//		printGleise();
//		
//	}
//	
//	private void printGleise() {
//		for (int i = 0; i < gleisArrObs.length; i++) {
//			if (gleisArrObs[i] != null) {
//				System.out.println("Gleis nummer " + i + " ist besetzt");
//			} else {
//				System.out.println("Gleis nummer " + i + " ist frei");
//				gui.updateColor();
//			}
//		}
//	}
//}
//
//
//////@Override
//////public void update(Zug[] gleisArr) {
//////	for (int i = 0; i < gleisArrObs.length; i++) {
//////		gleisArrObs[i] = gleisArr[i];
//////	}
//////	printGleise();	
//////}
////
////
////// package aufgabenblatt3;
//////
////// public class bahnhofObserver implements Observer {
//////
////// private Zug[] gleisArrObs = new Zug[3];
//////
////// private static int observerIDTracker = 0;
//////
////// private int observerID;
//////
////// private Rangierbahnhof bahnhof;
//////
////// public bahnhofObserver(Rangierbahnhof bahnhof) {
////// this.bahnhof = bahnhof;
////// this.observerID = observerIDTracker++;
//////
////// System.out.println("New Observer " + this.observerID);
//////
////// bahnhof.addObserver(this);
////// }
//////
////// @Override
////// public void update(Zug[] gleisArr) {
////// for (int i = 0; i < gleisArrObs.length; i++) {
////// gleisArrObs[i] = gleisArr[i];
////// }
////// printGleise();
//////
////// }
//////
////// private void printGleise() {
////// for (int i = 0; i < gleisArrObs.length; i++) {
////// if (gleisArrObs[i] != null) {
////// System.out.println("Gleis nummer " + i + " ist besetzt");
////// } else {
////// System.out.println("Gleis nummer " + i + " ist frei");
////// }
////// }
////// System.out.println(observerID + " ");
////// }
////// }
