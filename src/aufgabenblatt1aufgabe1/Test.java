package aufgabenblatt1aufgabe1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		CompareName cn1 = new CompareName();

		Student derya = new Student("derya", "uyargil", 8810);
		Student daniel = new Student("daniel", "drathen", 6077);
		System.out.println("CompareTo zeigt :: " + derya.compareTo(daniel));
		List<Student> list = new ArrayList<Student>();

		list.add(derya);
		list.add(daniel);

		Collections.sort(list);

		for (Student a : list) {
			System.out.println(a.getVorname());
		}

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
