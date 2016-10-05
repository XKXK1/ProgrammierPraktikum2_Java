package aufgabenblatt1aufgabe3;

public class ArrayListe<T extends Comparable<T>> {
  private int anzahlElemente = 0;
  private Object[] elemente = new Object[2];

  public void hinzufuegen(T element) {
    if (getAnzahlElemente() == elemente.length) {
      Object[] duplicate = new Object[elemente.length * 2];
      System.arraycopy(elemente, 0, duplicate, 0, elemente.length);
      elemente = duplicate;
    }
    elemente[anzahlElemente] = (Object) element;
    anzahlElemente++;

  }

  // LOOLOOO
  public T get(int index) {
    try {
      return (T) elemente[index];
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Es gibt kein Element an dieser Stelle!");
      return null;
    }
  }

  public void entfernen(T element) {
    if (getAnzahlElemente() > 0) {
      for (int i = 0; i < anzahlElemente; i++) {
        if (element.equals(elemente[i])) {
          entferneElementAnIndex(i);
        }
      }
      System.out.println("Kein Element gefunden das diesen Wert besitzt!");
    } else {
      System.out.println("Dies ist nicht die Liste die du Suchst!");
    }
  }

  public void entferneElementAnIndex(int index) {
    if (get(index) != null) {
      for (int i = index; i < elemente.length - 1; i++) {
        elemente[i] = elemente[i + 1];
      }
      elemente[elemente.length - 1] = null;

      anzahlElemente--;
    }
  }

  public int getAnzahlElemente() {
    return anzahlElemente;
  }

  @Override
  public String toString() {
    String ausgabe = "";
    for (int i = 0; i < getAnzahlElemente(); i++) {
      ausgabe += elemente[i] + "\n";
    }
    return ausgabe;
  }

  public T getKleinstesElement() {
    T kleinstes_element = null;
    for (int i = 0; i < anzahlElemente; i++) {
      if (i == 0) {
        kleinstes_element = (T) elemente[0];
      }
      if (kleinstes_element.compareTo((T) elemente[i]) > 0) {
        kleinstes_element = (T) elemente[i];
      }
    }
    return kleinstes_element;
  }
}
