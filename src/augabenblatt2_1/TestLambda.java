package augabenblatt2_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLambda {

  @Test
  public void testAddition() {
    Rechner rechner = new Rechner();
    double ergebnis = rechner.berechne(Operation.ADDITION, 12, 11);
    double erwartetesErgebnis = 23;
    assertEquals("Fehler: Es wurde 23 erwartet!", erwartetesErgebnis, ergebnis, 0.001);
  }

  @Test
  public void testSubtraktion() {
    Rechner rechner = new Rechner();
    double ergebnis = rechner.berechne(Operation.SUBTRAKTION, 12, 11);
    double erwartetesErgebnis = 1;
    assertEquals("Fehler: Es wurde 1 erwartet!", erwartetesErgebnis, ergebnis, 0.001);
  }

  @Test
  public void testDivision() {
    Rechner rechner = new Rechner();
    double ergebnis = rechner.berechne(Operation.DIVISION, 12, 6);
    double erwartetesErgebnis = 2;
    assertEquals("Fehler: Es wurde 2 erwartet!", erwartetesErgebnis, ergebnis, 0.001);
  }

  @Test
  public void testMultiplikation() {
    Rechner rechner = new Rechner();
    double ergebnis = rechner.berechne(Operation.MULTIPLIKATION, 12, 11);
    double erwartetesErgebnis = 132;
    assertEquals("Fehler: Es wurde 132 erwartet!", erwartetesErgebnis, ergebnis, 0.001);
  }

}
