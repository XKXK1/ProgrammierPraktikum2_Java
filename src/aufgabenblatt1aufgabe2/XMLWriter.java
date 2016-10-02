package aufgabenblatt1aufgabe2;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;

public class XMLWriter {
  public XMLWriter(String dateiname) {
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    Node document;
    DOMSource source = new DOMSource(document);
    StreamResult result = new StreamResult(new File(dateiname));
    transformer.transform(source, result);

  }

  public void writer(String Dateiname) {

  }

  public static void main(String[] args) {

  }
}
