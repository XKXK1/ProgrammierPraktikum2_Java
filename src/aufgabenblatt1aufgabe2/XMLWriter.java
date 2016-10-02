package aufgabenblatt1aufgabe2;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;


import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLWriter {
	
	  public static void main(String[] args) {
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder;
	        try {
	            dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.newDocument();
	            //add elements to Document
	            Element rootElement =
	                doc.createElementNS("http://www.journaldev.com/employee", "Employees");
	            //append root element to document
	            doc.appendChild(rootElement);
	 
	            //append first child element to root element
	            rootElement.appendChild(getSensor(doc, "1", "Pankaj", "29", "1400"));
	 
	            //append second child
	            rootElement.appendChild(getSensor(doc, "2", "Lisa", "35", "20000"));
	 
	            //for output to file, console
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            //for pretty print
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            DOMSource source = new DOMSource(doc);
	 
	            //write to console or file
	            StreamResult console = new StreamResult(System.out);
	            StreamResult file = new StreamResult(new File("C:/Users/dry/Desktop/emps.xml"));
	 
	            //write data
	            transformer.transform(source, console);
	            transformer.transform(source, file);
	            System.out.println("DONE");
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	  
	   private static Node getSensor(Document doc, String id, String messung, String wert, String zeitstempel) {
	        Element sensor = doc.createElement("Sensor");
	 
	        //set id attribute
	        sensor.setAttribute("id", id);
	 
	        //create messung element
	        sensor.appendChild(getSensorElements(doc, sensor, "messung", messung));
	        
	        
	        sensor.setAttribute("wert", wert);
	        
	        sensor.setAttribute("zeitstempel", zeitstempel);


	 
	        return sensor;
	    }
	 
	 
	    //utility method to create text node
	    private static Node getSensorElements(Document doc, Element element, String name, String value) {
	        Element node = doc.createElement(name);
	        node.appendChild(doc.createTextNode(value));
	        return node;
	    }

}


