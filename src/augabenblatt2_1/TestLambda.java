package augabenblatt2_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLambda {

  @Test
  public void testAddition() {
    Rechner rechner = new Rechner();
    double ergebnis = rechner.berechne(Operation.ADDITION, 12.1, 11.0);
    double erwartetesErgebnis = 23.1;
    assertEquals("Fehler: Es wurde 23.1 erwartet!", erwartetesErgebnis,
        ergebnis, 0.001);
  }

  @Test
  public void testSubtraktion() {
    Rechner rechner = new Rechner();
    double ergebnis = rechner.berechne(Operation.SUBTRAKTION, 12.1, 11.0);
    double erwartetesErgebnis = 1.1;
    assertEquals("Fehler: Es wurde 1,2 erwartet!", erwartetesErgebnis, ergebnis,
        0.001);
  }

  @Test
  public void testDivision() {
    Rechner rechner = new Rechner();
    double ergebnis = rechner.berechne(Operation.DIVISION, 12.1, 6.0);
    double erwartetesErgebnis = 2.016;
    assertEquals("Fehler: Es wurde 2 erwartet!", erwartetesErgebnis, ergebnis,
        0.1);
  }

  @Test
  public void testMultiplikation() {
    Rechner rechner = new Rechner();
    double ergebnis = rechner.berechne(Operation.MULTIPLIKATION, 12.1, 11.0);
    double erwartetesErgebnis = 133.1;
    assertEquals("Fehler: Es wurde 133.1 erwartet!", erwartetesErgebnis,
        ergebnis, 0.001);
  }

  @Test
  public void testDoubDouble() {
    DoubleDoubleZuDouble samMulti = (zahl1, zahl2) -> {
      return zahl1 * zahl2;};

      double berechnet = samMulti.werteAus(5, 3);
      
      assertEquals("Falsch", 15.0, berechnet , 0.1);

    }
}
