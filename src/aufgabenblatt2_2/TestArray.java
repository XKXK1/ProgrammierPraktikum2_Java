package aufgabenblatt2_2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestArray {

  @Test
  public void test() {
    StreamFilter<String> test = new StreamFilter<>();
    String[] eingabe;

    //Das String Array des Aufgabenblatts wird erstellt
    eingabe = new String[10];
    eingabe[0] = "Eingabe ";
    eingabe[1] = "Äußeres ";
    eingabe[2] = null;
    eingabe[3] = "Strassen-Feger";
    eingabe[4] = " ein Haus";
    //Der verarbeitungs-Stream der Klasse Streamfilter wird aufgerufen und das Array wird uebergeben.
    List<String> ausgabeListe = test.verarbteitung(eingabe);

    List<String> erwartungsListe = new ArrayList<>();
    erwartungsListe.add("EINGABE");
    erwartungsListe.add("AEUSSERE");
    erwartungsListe.add("STRASSEN");
    erwartungsListe.add("EIN HAUS");
    
    assertEquals("Das erste Wort stimmt nicht", erwartungsListe.get(0), ausgabeListe.get(0));
    assertEquals("Das zweite Wort stimmt nicht", erwartungsListe.get(1), ausgabeListe.get(1));
    assertEquals("Das dritte Wort stimmt nicht", erwartungsListe.get(2), ausgabeListe.get(2));
    assertEquals("Das vierte Wort stimmt nicht", erwartungsListe.get(3), ausgabeListe.get(3));
  }

}
