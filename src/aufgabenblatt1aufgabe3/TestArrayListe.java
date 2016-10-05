package aufgabenblatt1aufgabe3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayListe {

  @Test
  public void testListeErstellen() {
    ArrayListe<String> testListe = new ArrayListe<String>();
    testListe.hinzufuegen("Test1");
    testListe.hinzufuegen("Test2");
    testListe.hinzufuegen("Test3");

    int erwartungsAnzahl = 3;

    assertEquals(erwartungsAnzahl, testListe.getAnzahlElemente());
  }

  @Test
  public void testEntfernenAmIndex() {
    ArrayListe<String> testListe = new ArrayListe<String>();
    testListe.hinzufuegen("Test1");
    testListe.hinzufuegen("Test2");
    testListe.hinzufuegen("Test3");
    testListe.hinzufuegen("Test4");

    testListe.entferneElementAnIndex(0);

    int erwartungAnzahl = 3;
    String erwartungsString = "Test2";
    String realerString = testListe.get(0);

    assertNotEquals("Es wurde nicht 5 erwartet", 5,
        testListe.getAnzahlElemente());
    assertEquals("Es wurde 3 erwartet", erwartungAnzahl,
        testListe.getAnzahlElemente());
    assertTrue(realerString.compareTo(erwartungsString) == 0);
  }

  @Test
  public void testEntfernen() {
    ArrayListe<Integer> testListe = new ArrayListe<Integer>();
    testListe.hinzufuegen(1);
    testListe.hinzufuegen(2);
    testListe.hinzufuegen(3);
    testListe.hinzufuegen(4);

    testListe.entfernen(3);

    int erwartungAnzahl = 3;

    assertEquals("Es wurden drei Werte erwartet", erwartungAnzahl,
        testListe.getAnzahlElemente());
  }

  
  @Test
  public void testClassAbfrage(){
    ArrayListe<Integer> testListe1 = new ArrayListe<Integer>();
    testListe1.hinzufuegen(1);
    testListe1.hinzufuegen(2);
    
    ArrayListe<Integer> testListe2 = new ArrayListe<Integer>();
    
    ArrayListe<String> testListe3 = new ArrayListe<String>();
    testListe3.hinzufuegen("test");
    testListe3.hinzufuegen("");
        
    assertTrue(ListenTester.listenTest(testListe1));
    assertTrue(!ListenTester.listenTest(testListe2));
    assertTrue(!ListenTester.listenTest(testListe3));
  }
}
