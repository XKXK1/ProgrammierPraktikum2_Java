package aufgabenblatt1aufgabe2;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.corba.se.impl.orbutil.graph.Node;

public class XMLReader {

	public static void main(String[] args) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = builderFactory.newDocumentBuilder();
			Document document = dBuilder.parse(XMLReader.class.getResourceAsStream("/sensor.xml"));
			document.normalize();
			
			NodeList rootNodes = document.getElementsByTagName("Sensor");
			Node rootNode = (Node) rootNodes.item(0);
			Element rootElement = (Element) rootNode;
			NodeList notesList = rootElement.getElementsByTagName("Sensor");
			
			
			for (int i = 0; i < notesList.getLength(); i++){
				Node theNote = (Node) notesList.item(i);
				Element noteElement = (Element) theNote;
				System.out.println("ID" + noteElement.getAttribute("id") );
			}
				
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

}
