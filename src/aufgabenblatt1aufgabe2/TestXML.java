package aufgabenblatt1aufgabe2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


public class TestXML {

  @Test
  public void testXMLReader() {
    List<Messung>testList = new ArrayList<Messung>();
    testList.add(new Messung(23.2, "2016-06-23T16:51:40.408"));
    testList.add(new Messung(24.5, "2016-06-24T12:12:52.000"));
    Sensor testSensor = new Sensor("Temperatur Wohnzimmer", testList);
    XMLReader auslesung;
      auslesung = new XMLReader(
          "C:/Users/Saintsaw/git/TeamRocket/PM2/src/aufgabenblatt1aufgabe2/sensor.xml");

      Sensor test = auslesung.reader();
      
      assertTrue(test.equals(testSensor));
  }
}
