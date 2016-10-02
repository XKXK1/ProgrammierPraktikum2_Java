package aufgabenblatt1aufgabe2;

import java.io.File;
import java.io.IOException;

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

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("/sensor.xml"));

		NodeList sensorList = document.getElementsByTagName("Sensor");
		for (int j = 0; j < sensorList.getLength(); j++) {
			Node f = sensorList.item(j);
			Element sensor = (Element) f;
			String sensorID = sensor.getAttribute("id");
			System.out.println("\nSensor ID: " + sensorID);

			NodeList messungList = document.getElementsByTagName("Messung");
			for (int i = 0; i < messungList.getLength(); i++) {
				Node p = messungList.item(i);
				Element messung = (Element) p;
				String wert = messung.getAttribute("wert");
				String zeitstempel = messung.getAttribute("zeitstempel");
				System.out.print("\nWert: " + wert + " Zeitstempel: " + zeitstempel);
			}

		}
	}
}
