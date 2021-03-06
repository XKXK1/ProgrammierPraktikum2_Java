package aufgabenblatt1aufgabe1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
/**
 * 
 * @author Derya Uyargil, Daniel von Drathen
 * 
 * Testklasse mit 3 Test-Methoden.
 * 
 */

public class TestStudent {
  /**
   * Test der CompareTo-Methode aus der Klasse Student
   * 
   * Der Test ist erfolgreich wenn der Student mit der kleinsten Matrikelnummer
   * an erster Stelle der Liste ist(nach sortieren).
   * 
   */
  @Test
  public void testCompareTo() {
    Student student1 = new Student("derya", "uyargil", 6410);
    Student student2 = new Student("daniel", "drathen", 2410);
    Student student3 = new Student("peter", "mueller", 1338);
    Student student4 = new Student("jan", "sieben", 9542);

    List<Student> testListe1 = new ArrayList<Student>();
    testListe1.add(student1);
    testListe1.add(student2);
    testListe1.add(student4);
    testListe1.add(student3);

    //Student 3 sollte vor dem sortieren nicht an index(0) der Liste stehen
    assertNotEquals(student3, testListe1.get(0));
    //Student 4 sollte vor dem sortieren nicht an index(3) der Liste stehen
    assertNotEquals(student4, testListe1.get(3));

    //Liste wird nach Matrikelnummer sortiert
    Collections.sort(testListe1);

    //Student 3 soll  an index(0) stehen, da er die kleinste Matrikelnummer hat
    assertEquals(student3, testListe1.get(0));
    //Student 4 soll  an index(0) stehen, da er die groesste Matrikelnummer hat
    assertEquals(student4, testListe1.get(3));

  }

  /**
   * Test der ueberschriebenen Equals-Methode. Zwei Studenten sind genau dann
   * gleich, wenn die Matrikelnummern gleich sind.
   */
  @Test
  public void testEquals() {
    Student student1 = new Student("derya", "uyargil", 6410);
    Student student2 = new Student("daniel", "drathen", 6410);

    //Die Matrikelnummern beider Studenten sind gleich
    assertTrue(student1.equals(student2));

    Student student3 = new Student("derya", "uyargil", 5410);
    Student student4 = new Student("daniel", "drathen", 6410);
    
    //Die Matrikelnummern beider Studenten sind unterschiedlich
    assertFalse(student3.equals(student4));
  }

  /**
   * Test der Klasse CompareName, welche Comparator implementiert. Wenn ein
   * Student lexikographisch vor einem anderen steht, so liefert das Ergebnis
   * des Vergleichs "-1" zurueck. Wenn beide gleich sind "0". Wenn ein Student nach
   * einem anderen steht, so liefert das Ergebnis des Vergleichs "1" zurueck.
   */
  @Test
  public void testComparator() {
    CompareName comparator1 = new CompareName();
    Student student1 = new Student("Adam", "Drathen", 6410);
    Student student2 = new Student("Wolfgang", "Uyargil", 6410);
    Student student3 = new Student("Betina", "Drathen", 6123);

    assertEquals("Fehler: Erwarteter Wert -1(Name kleiner)", -1,
        comparator1.compare(student1, student2));

    assertEquals("Fehler: Erwarteter Wert 1(Name groesser)", 1,
        comparator1.compare(student2, student1));

    assertEquals("Fehler: Erwarteter Wert 0(Namen gleich)", 0,
        comparator1.compare(student2, student2));
    
    assertEquals("Fehler: Es wurde -1 erwartet!", -1, comparator1.compare(student1, student3));

  }

}
