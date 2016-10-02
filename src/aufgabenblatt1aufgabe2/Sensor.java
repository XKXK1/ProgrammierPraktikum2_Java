package aufgabenblatt1aufgabe2;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsInstanceOf;

public class Sensor {
  private String id;
  List<Messung> list = new ArrayList<Messung>();

  public Sensor(String id, List<Messung> messungen) {
    this.id = id;
    list = messungen;
  }
  
  /**
   * Equals-Methode für den XMLReader-Test
   */
  @Override
  public boolean equals(Object obj) {
    if (obj.getClass()==null)
      return false;
    // wenn beide Objekte die gleiche Klasse haben,
    if (obj instanceof Sensor) {
      // wird das obj zum Sensor gecastet
      Sensor that = (Sensor) obj;

      // Vergleich der Listengroessen beider Objekte
      if (this.getList().size() != that.getList().size())
        return false;

      // Vergleichen der ID´s
      if (!this.getId().matches(that.getId()))
        return false;

      //Die Listen werden durchlaufen und die Werte verglichen
      for (int i = 0; i < this.getList().size(); i++) {
        double wertA = this.getList().get(i).getWert();
        double wertB = that.getList().get(i).getWert();
        String stempelA = this.getList().get(i).getZeitstempel();
        String stempelB = that.getList().get(i).getZeitstempel();
        if (wertA != wertB) {
          return false;
        }
        if (!stempelA.contains(stempelB)) {
          return false;
        }
      }
    }
    return true;
  }

  public String getId() {
    return id;
  }

  public List<Messung> getList() {
    return list;
  }

  public static void main(String[] args) {

  }
}
