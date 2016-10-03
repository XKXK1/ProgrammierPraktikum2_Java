package aufgabenblatt1aufgabe3;

import java.lang.reflect.Array;

public class ArrayListe<T> {
  private int anzahlElemente;
  private Object[] elemente;
  
  public ArrayListe() {
    Object[] elemente = new Object[2];
  }


  public ArrayListe(T... element) {
    Object[] elemente = new Object[element.length];
    this.elemente[0] = (Object[])element;
  }

  public void hinzufuegen(T element) {
    if (getAnzahlElemente() == elemente.length){
      Object[] duplicate = new Object[elemente.length*2];
      System.arraycopy( elemente, 0, duplicate, 0, elemente.length );
      elemente = (T[]) duplicate;
    }
      elemente[anzahlElemente] = element;
      anzahlElemente++;

  }

  public T get(int index) {
    return (T) elemente[index];
  }

  public void entfernen(T element) {

    anzahlElemente--;
  }

  public void entferneElementAnIndex(int index) {
    for (int i = index; i< elemente.length-1; i++){
      elemente[i]=elemente[i+1];
    }
    anzahlElemente--;
  }

  public int getAnzahlElemente() {
    return anzahlElemente;
  }

  @Override
  public String toString() {
    String ausgabe = "";
    for (int i = 0; i<elemente.length;i++){
      ausgabe += elemente[i] + "\n";
    }
    return ausgabe;
  }

  public T getKleinstesElement() {
    return null;
  }
  
  public static void main(String[] args){
    ArrayListe<String> testListe = new ArrayListe<String>();

    
    System.out.println(testListe.anzahlElemente);
    
  }
}
