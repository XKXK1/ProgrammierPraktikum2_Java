package aufgabenblatt1aufgabe1;

import java.util.Comparator;

public class CompareName implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		if (student1.getVorname().compareTo(student2.getVorname()) < 0){
			return -1; 
		}
		
		if (student1.getVorname().compareTo(student2.getVorname()) > 1){
			return 1;
		}
		return 0;
	}


}
