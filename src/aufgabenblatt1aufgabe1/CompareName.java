package aufgabenblatt1aufgabe1;

import java.util.Comparator;

/**
 * CompareName implementiert den Comparator mit dem typen Student. Die
 * CompareMethode wird ueberschrieben damit zwei studenten anhand des Vornamens
 * lexikographisch verglichen werden koennen.
 * 
 * @author dry
 *
 */
public class CompareName implements Comparator<Student> {

	/**
	 * Zuerst werden beide Nachnamen der Studenten vergleichen. Falls beide
	 * Namen gleich sein sollten wird zusaetzlich vergleichen welcher Nachname
	 * lexikographisch vor dem anderen kommt.
	 * 
	 * return -1 falls Name1 vor Name 2 kommt. return 1 falls Name 1 nach Name 2
	 * kommt. return 0 falls beide Namen gleich sind.
	 */
	@Override
	public int compare(Student student1, Student student2) {
		if (student1.getNachname().compareTo(student2.getNachname()) < 0) {
			return -1;
		}

		if (student1.getNachname().compareTo(student2.getNachname()) > 0) {
			return 1;
		}
		if (student1.getVorname().compareTo(student2.getVorname()) < 0) {
			return -1;
		}

		if (student1.getVorname().compareTo(student2.getVorname()) > 0) {
			return 1;
		}
		return 0;
	}

}
