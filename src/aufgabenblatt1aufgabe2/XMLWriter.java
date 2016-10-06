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
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * 
 * @author Derya Uyargil, Daniel von Drathen
 * 
 *         Die Klasse XMLWriter dient zum erstellen eines XML-Dokuments aus
 *         einem schon vorhandenen Sensor Objekt.
 *
 */
public class XMLWriter {

	// Erstellen des Builders
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder;

	/**
	 * Die Methode Writer() erwartet ein Sensor-Objekt und einen Dateipfad, an
	 * welchem die Datei erstellt wird.
	 * 
	 * @param sensor1
	 * @param dateipfad
	 */
	public void writer(Sensor sensor1, String dateipfad) {
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			// Hinzufuegen der Elemente zum Dokument
			Element rootElement = doc.createElement("Sensor");
			rootElement.setAttribute("id", sensor1.getId());
			// Wurzel-Element an das Dokument anhaengen
			doc.appendChild(rootElement);

			for (int i = 0; i < sensor1.getList().size(); i++) {
				// Kind-Element an das Wurzel-Element anhaengen
				rootElement.appendChild(setzeMessung(doc, Double.toString(sensor1.getList().get(i).getWert()),
						sensor1.getList().get(i).getZeitstempel()));
			}

			// zum Ausgeben der Datei an die Konsole
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			// Zur schoenere Ausgabe
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);

			// Auf Konsole ausgeben und in Datei schreiben
			StreamResult console = new StreamResult(System.out);
			StreamResult file = new StreamResult(new File(dateipfad));

			// Abschliessen des Schreibens durch Transformer
			transformer.transform(source, console);
			transformer.transform(source, file);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Die Methode getSensor dient zur Hilfe der Hauptmethode "writer()". Ein
	 * Knotenobjekt wird aus den uergebenen Sensor Attributen erstellt und
	 * zurueckgeliefert.
	 * 
	 * @param doc
	 * @param wert
	 * @param zeitstempel
	 * @return
	 */
	private Node setzeMessung(Document doc, String wert, String zeitstempel) {
		// Element wird im Dokument erstellt
		Element sensor = doc.createElement("Messung");

		// Element bekommt Attribut mit dem Namen "wert" dem inhalt des
		// Argumentes "wert"
		sensor.setAttribute("wert", wert);

		// Element bekommt Attribut mit dem Namen "zeitstempel" dem inhalt des
		// Argumentes "zeitstempel"
		sensor.setAttribute("zeitstempel", zeitstempel);

		return sensor;
	}

}