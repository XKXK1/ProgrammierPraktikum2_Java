package aufgabenblatt1aufgabe2;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

	public void writer(Sensor sensor1, String dateipfad) {
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			// Hinzufuegen der Elemente zum Dokument
			Element rootElement = doc.createElement("Sensor");
			rootElement.setAttribute("id", sensor1.getId());
			// Wurzel-Element an das Dokument anhaengen
			doc.appendChild(rootElement);

			for (int i = 0; i < sensor1.list.size(); i++) {
				// Kind-Element an das Wurzel-Element anhaengen
				rootElement.appendChild(getSensor(doc, Double.toString(sensor1.list.get(i).getWert()),
						sensor1.list.get(i).getZeitstempel()));
			}

			// zum Ausgeben der Datei an die Konsole
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			// for pretty print
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
	 * Die Methode getSensor dient zur Hilfe der Hauptmethode "writer()".
	 * Ein Knotenobjekt wird aus den uergebenen Sensor Attributen erstellt.
	 * @param doc
	 * @param wert
	 * @param zeitstempel
	 * @return
	 */
	private Node getSensor(Document doc, String wert, String zeitstempel) {
		// 
		Element sensor = doc.createElement("Messung");

		
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