package aufgabenblatt1aufgabe1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Derya Uyargil, Daniel von Drathen
 * 
 *         Die Klasse Student repraesentiert einen Studenten inkl. Vorname,
 *         Nachname, Matrikelnummer und einer Liste seiner Pruefungsleistungen.
 * 
 *         Das Interface Comparable wird implementiert damit die Objekte der
 *         Klasse Student mit der "compareTo" Methode verglichen werden koennen.
 *
 */
public class Student implements Comparable<Student> {

	private String vorname;
	private String nachname;
	private int matrikelnummer;
	private List<Pruefungsleistung> list;

	/**
	 * Konstruktor fuer die Klasse Student mit Vorname(String), Nachname(String)
	 * und Matrikelnummer(int)
	 * 
	 * @param vorname
	 * @param nachname
	 * @param matrikelnummer
	 */
	public Student(String vorname, String nachname, int matrikelnummer) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelnummer = matrikelnummer;
		list = new ArrayList<Pruefungsleistung>();
	}

	/**
	 * Ueberschreiben der compareTo Methode. Zwei Studentenobjekte sind genau
	 * dann gleich, wenn sie die gleiche Matrikelnummer haben.
	 */
	@Override
	public int compareTo(Student other) {
			return getMatrikelnummer()-other.getMatrikelnummer();
	}

	@Override
	public String toString() {
		return "Student [vorname=" + vorname + ", nachname=" + nachname + ", matrikelnummer=" + matrikelnummer
				+ ", list=" + list.toString() + "]";
	}

	/**
	 * Ueberschreiben der hashCode Methode damit zwei elemente mit gleicher
	 * matrikelnummer auch wirklich gleich sind.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result;
		
		result = prime * matrikelnummer;
		return result;
	}

	/**
	 * Ueberschreiben der equals Methode,so dass zwei Objekte der Klasse Student
	 * gleich sind, wenn sie die gleiche Matrikelnummer haben.
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
