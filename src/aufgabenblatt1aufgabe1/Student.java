package aufgabenblatt1aufgabe1;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {

	private String vorname;
	private String nachname;
	private int matrikelnummer;

	public Student(String vorname, String nachname, int matrikelnummer) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelnummer = matrikelnummer;
		List<Pruefungsleistung> list1 = new ArrayList<Pruefungsleistung>();
		list1.add(new Pruefungsleistung(5,"mathe"));
	}

	public boolean equals(Student other) {
		return this.getMatrikelnummer() == other.getMatrikelnummer();
	}

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matrikelnummer;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (matrikelnummer != other.matrikelnummer)
			return false;
		return true;
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
