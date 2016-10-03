package aufgabenblatt1aufgabe1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		CompareName cn1 = new CompareName();

		Student derya = new Student("derya", "uyargil", 6510);
		Student daniel = new Student("daniel", "drathen", 6077);
		System.out.println("CompareTo zeigt :: " + derya.compareTo(daniel));
		
		daniel.list.add(new Pruefungsleistung(5,"mathe"));
		daniel.list.add(new Pruefungsleistung(5,"mathe"));
		System.out.println(daniel);

		
		
			int result = derya.compareTo(daniel);

		if (result < 0) {
			System.out.println(derya.getVorname() + " hat eine kleinere Matrikelnummer als " + daniel.getVorname());
		} else if (result > 0) {
			System.out.println(derya.getVorname() + " hat eine groessere Matrikelnummer als " + daniel.getVorname());
		} else {
			System.out.println(derya.getVorname() + " hat die gleiche Matrikelnummer wie " + daniel.getVorname());
		}
		int resultName = cn1.compare(derya, daniel);

		if (resultName < 0) {
			System.out.println(derya.getVorname() + " <- kommt vor diesem Namen im Alphabet -> " + daniel.getVorname());
		} else if (resultName > 0) {
			System.out.println(derya.getVorname() + " <- kommt nach diesem Namen im Alphabet -> " + daniel.getVorname());
		} else {
			System.out.println(derya.getVorname() + " <- gleiche stelle im alphabet -> " + daniel.getVorname());
		}
	}
	

}
