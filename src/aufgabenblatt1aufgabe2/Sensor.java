package aufgabenblatt1aufgabe2;

import java.util.ArrayList;
import java.util.List;

public class Sensor {
  private String id;
  List<Messung> list = new ArrayList<Messung>();

  public Sensor(String id, List<Messung> messungen) {
    this.id = id;
    list = messungen;
  }

  @Override
  public String toString() {
    return "Sensor [id=" + id + ", list=" + list + "]";
  }

  public static void main(String[] args) {

  }
}
