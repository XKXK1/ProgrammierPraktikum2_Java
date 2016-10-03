package aufgabenblatt1aufgabe3;

public class ArrayListe<T> {
  private int anzahlElemente = 0;
  private Object[] elemente = new Object[2];

  public void hinzufuegen(T element) {
    if (getAnzahlElemente() == elemente.length) {
      Object[] duplicate = new Object[elemente.length * 2];
      System.arraycopy(elemente, 0, duplicate, 0, elemente.length);
      elemente = (T[]) duplicate;
    }
    elemente[anzahlElemente] = (Object) element;
    anzahlElemente++;

  }

  public T get(int index) {
    try {
      return (T) elemente[index];
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Es gibt kein Element an dieser Stelle!");
      return null;
    }
  }

  public void entfernen(T element) {

    anzahlElemente--;
  }

  public void entferneElementAnIndex(int index) {
    for (int i = index; i < elemente.length - 1; i++) {
      elemente[i] = elemente[i + 1];
    }
    elemente[elemente.length - 1] = null;

    anzahlElemente--;
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
    return null;
  }

  public static void main(String[] args) {
    ArrayListe<String> testListe = new ArrayListe<String>();
    testListe.hinzufuegen("Hans");
    testListe.hinzufuegen("Hipster");
    testListe.hinzufuegen("Chill");
    testListe.hinzufuegen("Peter");

    System.out.println(testListe);

    testListe.entferneElementAnIndex(2);

    System.out.println(testListe);
    System.out.println(testListe.getAnzahlElemente());

    testListe.get(4);

  }
}
