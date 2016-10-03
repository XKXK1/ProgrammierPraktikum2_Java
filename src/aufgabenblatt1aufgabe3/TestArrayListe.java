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
  public void testEntfernen(){
    ArrayListe<String> testListe = new ArrayListe<String>();
    testListe.hinzufuegen("Test1");
    testListe.hinzufuegen("Test2");
    testListe.hinzufuegen("Test3");
    testListe.hinzufuegen("Test4");
    
    testListe.entferneElementAnIndex(0);
    
    int erwartungAnzahl = 3;
    String erwartungsString = "Test2";
    String realerString = testListe.get(0);
    
    assertNotEquals(5, testListe.getAnzahlElemente());
    assertEquals(erwartungAnzahl, testListe.getAnzahlElemente());
    assertTrue(realerString.compareTo(erwartungsString)==0);
  }

}
