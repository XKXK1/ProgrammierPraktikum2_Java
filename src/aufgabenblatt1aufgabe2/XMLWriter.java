package aufgabenblatt1aufgabe2;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLWriter {
  
  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
  DocumentBuilder dBuilder;
    
  public void writer(Sensor sensor1, String dateipfad){
    try {
      dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.newDocument();
      // Hinzufuegen der Elemente zum Dokument
      Element rootElement = doc.createElement("Sensor");
      rootElement.setAttribute("id", sensor1.getId());
      // Wurzel-Element an das Dokument anhaengen
      doc.appendChild(rootElement);
      
      for(int i=0; i<sensor1.list.size(); i++){
      // Kind-Element an das Wurzel-Element anhaengen
       rootElement.appendChild(getSensor(doc, Double.toString(sensor1.list.get(i).getWert()), sensor1.list.get(i).getZeitstempel()));
      }
       
      // for output to file, console
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      // for pretty print
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      DOMSource source = new DOMSource(doc);

      // write to console or file
      StreamResult console = new StreamResult(System.out);
      StreamResult file = new StreamResult(new File(dateipfad));

      // write data
      transformer.transform(source, console);
      transformer.transform(source, file);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private Node getSensor(Document doc, String wert, String zeitstempel) {
    Element sensor = doc.createElement("Messung");

    // set id attribute
    sensor.setAttribute("wert", wert);
    
    sensor.setAttribute("zeitstempel", zeitstempel);

    return sensor;
  }

	public static void main(String[] args) {
		List<Messung> list = new ArrayList<>();
		list.add(new Messung(2.5, LocalDateTime.now().toString()));
		list.add(new Messung(3.2, LocalDateTime.now().toString()));
		list.add(new Messung(6.2, LocalDateTime.now().toString()));

		Sensor sensor1 = new Sensor("wohnzimmer", list);
		
		XMLWriter xmlwriter = new XMLWriter();
		
		xmlwriter.writer(sensor1, "Z:/PTP/Semester 2/pm2_teamrocket/src/aufgabenblatt1aufgabe2/blub.xml");
	
	}
}