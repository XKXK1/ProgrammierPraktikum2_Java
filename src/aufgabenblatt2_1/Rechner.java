package aufgabenblatt2_1;

import java.util.HashMap;
import java.util.function.BinaryOperator;

/**
 * Diese Klasse repraesentiert die Funktionalitaet eines Rechners mit den 4
 * Rechenoperationen Addition, Subtraktion, Multiplikation,Division.
 * 
 * @author Derya Uyargil, Daniel von Drathen
 *
 */
public class Rechner {
	// Eine Hashmap, welche Objekte der 2 Typen(Operation und
	// BinaryOperator<Double>) verwaltet.
	private HashMap<Operation, DoubleDoubleZuDouble> rechnerMap;

	/**
	 * Die Methode Rechner() erstellt eine Map, welche die 4 Rechenarten
	 * verwaltet.
	 */
	public Rechner() {
		// Die Hashmap fuer unsere Rechenoperationen wird erstellt
		rechnerMap = new HashMap<Operation, DoubleDoubleZuDouble>();
		// Die Operation Addition wird als Lambda Ausdruck in die Map
		// eingefuegt. Es werden 2 Zahlen des Typs BinaryOperator<Double>
		// erwartet. Das Ergebnis der Addition wird zurueckgegeben

		rechnerMap.put(Operation.ADDITION, (zahl1, zahl2) -> {
			return zahl1 + zahl2;
		});
		// Die Operation Subtraktion wird als Lambda Ausdruck in die Map
		// eingefuegt. Es werden 2 Zahlen des Typs BinaryOperator<Double>
		// erwartet. Das Ergebnis der Subtraktion wird zurueckgegeben
		rechnerMap.put(Operation.SUBTRAKTION, (zahl1, zahl2) -> {
			return zahl1 - zahl2;
		});
		// Die Operation Multiplikation wird als Lambda Ausdruck in die Map
		// eingefuegt. Es werden 2 Zahlen des Typs BinaryOperator<Double>
		// erwartet. Das Ergebnis der Multiplikation wird zurueckgegeben
		rechnerMap.put(Operation.MULTIPLIKATION, (zahl1, zahl2) -> {
			return zahl1 * zahl2;
		});
		// Die Operation Division wird als Lambda Ausdruck in die Map
		// eingefuegt. Es werden 2 Zahlen des Typs BinaryOperator<Double>
		// erwartet. Das Ergebnis der Division wird zurueckgegeben
		rechnerMap.put(Operation.DIVISION, (zahl1, zahl2) -> {
			if (zahl2 == 0) {
				throw new IllegalArgumentException("Argument 'divisor' is 0");
			}
			return zahl1 / zahl2;
		});
	}

	/**
	 * Die Methode berechne wird fuer die Anwendung der Rechenoperationen
	 * verwendet. Der gewuenschte Rechenoperator und 2 Zahlen des Typs Double
	 * werden erwartet. Das berechnete Ergebnis wird zurueckgegeben.
	 * 
	 * @param operator
	 * @param zahl1
	 * @param zahl2
	 * @return
	 */
	public double berechne(Operation operator, double zahl1, double zahl2) {

		return rechnerMap.get(operator).werteAus(zahl1, zahl2);
	}
}
