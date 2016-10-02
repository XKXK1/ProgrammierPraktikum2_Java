package aufgabenblatt1aufgabe2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {
  private Document document;
  private List<Messung>list = new ArrayList<>();
  
  public XMLReader(String dateipfad) throws ParserConfigurationException, SAXException, IOException{
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    document = builder.parse(new File("/sensor.xml"));
  }
  
  public Sensor reader(){

    NodeList sensorList = document.getElementsByTagName("Sensor");
      Node f = sensorList.item(0);
      Element sensor = (Element) f;
      String sensorID = sensor.getAttribute("id");
      System.out.println("\nSensor ID: " + sensorID);

      NodeList messungList = document.getElementsByTagName("Messung");
      for (int i = 0; i < messungList.getLength(); i++) {
        Node p = messungList.item(i);
        Element messung = (Element) p;
        String wert = messung.getAttribute("wert");
        String zeitstempel = messung.getAttribute("zeitstempel");
        list.add(i, new Messung(Double.parseDouble(wert), zeitstempel));
        System.out.print("\nWert: " + wert + " Zeitstempel: " + zeitstempel);
      }
    return new Sensor(sensorID, (List<Messung>) list);
  }

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		  XMLReader auslesung = new XMLReader("C:/Users/Saintsaw/git/TeamRocket/PM2/src/aufgabenblatt1aufgabe2/sensor.xml");

		  Sensor test = reader();

	}
}
