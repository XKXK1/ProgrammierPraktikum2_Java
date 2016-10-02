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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((list == null) ? 0 : list.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Sensor) {
      Sensor that = (Sensor) obj;
      if (this.getList().size() == that.getList().size()) {
        if (this.getId().matches(that.getId())) {
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
          return true;
        }
      }
    }
    return false;

  }

  public String getId() {
    return id;
  }

  public List<Messung> getList() {
    return list;
  }

  @Override
  public String toString() {
    return "Sensor [id=" + id + ", list=" + list + "]";
  }

  public static void main(String[] args) {

  }
}
