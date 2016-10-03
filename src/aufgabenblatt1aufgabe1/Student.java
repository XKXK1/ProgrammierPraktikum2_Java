package aufgabenblatt1aufgabe1;

import java.util.ArrayList;
import java.util.List;

import aufgabenblatt1aufgabe2.Messung;

public class Student implements Comparable<Student> {

	private String vorname;
	private String nachname;
	private int matrikelnummer;
	List<Pruefungsleistung> list = new ArrayList<Pruefungsleistung>();

	/**
	 * Konstruktor fuer die Klasse Student mit Vorname(String), Nachname(String) und Matrikelnummer(int)
	 * @param vorname
	 * @param nachname
	 * @param matrikelnummer
	 */
	public Student(String vorname, String nachname, int matrikelnummer) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelnummer = matrikelnummer;
	}

	
	/**
	 * Ueberschreiben der compareTo Methode. Zwei Studentenobjekte sind genau dann gleich,
	 * wenn sie die gleiche Matrikelnummer haben.
	 */
	@Override
	public int compareTo(Student other) {

		if (getMatrikelnummer() > other.getMatrikelnummer()) {
			return 1;
		} else if (getMatrikelnummer() < other.getMatrikelnummer()) {
			return -1;
		} else
			return 0;

	}

	@Override
	public String toString() {
		return "Student [vorname=" + vorname + ", nachname=" + nachname + ", matrikelnummer=" + matrikelnummer
				+ ", list=" + list.toString() + "]";
	}

	/**
	 * Ueberschreiben der hashCode Methode damit zwei elemente mit gleicher matrikelnummer auch wirklich gleich sind.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matrikelnummer;
		return result;
	}

	/**
	 * Vergleicht hashcodes von 2 Matrikelnummern.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (matrikelnummer == other.matrikelnummer)
			return true;
		return false;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public int getMatrikelnummer() {
		return matrikelnummer;
	}

}
