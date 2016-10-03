package aufgabenblatt1aufgabe3;

import java.lang.reflect.Array;

public class ArrayListe<T> {
  private int anzahlElemente;
  private T[] elemente;

  public ArrayListe() {
    final T[] element = (T[]) Array.newInstance(elemente.getClass(), 2);
    this.elemente = element;
  }

  public void hinzufuegen(T element) {
    if (getAnzahlElemente() == elemente.length){
      final T[] duplicate = (T[]) Array.newInstance(element.getClass(), elemente.length*2);
      System.arraycopy( elemente, 0, duplicate, 0, elemente.length );
      elemente = (T[]) duplicate;
    }
      elemente[anzahlElemente] = element;
      anzahlElemente++;

  }

  public T get(int index) {
    return null;
  }

  public void entfernen(T element) {

  }

  public void entferneElementAnIndex(int index) {

  }

  public int getAnzahlElemente() {
    return anzahlElemente;
  }

  @Override
  public String toString() {
    return "nichts";
  }

  public T getKleinstesElement() {
    return null;
  }
  
  public static void main(String[] args){
    ArrayListe<String> testListe = new ArrayListe<String>();
    testListe.hinzufuegen("John Cena");
    testListe.hinzufuegen("Kartoffelpuffer");
    testListe.hinzufuegen("penis");
    
    System.out.println(testListe.anzahlElemente);
    
  }
}
