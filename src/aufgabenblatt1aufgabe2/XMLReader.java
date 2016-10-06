package aufgabenblatt1aufgabe2;

/**
 * 
 * @author Derya Uyargil, Daniel von Drathen
 * 
 *         Die Klasse XMLReader dient zum auslesen eines XML-Dokuments und zum
 *         Uebertragen der ausgelesenen Daten in ein Sensor Objekt.
 *
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {
	private Document document;

	/**
	 * Die Methode XMLReader erstellt den Documentbuilder und erstellt ein
	 * Dokument. Die Datei am uebergebenen Pfad wird analysiert. Der Try/Catch
	 * Block wurde automatisiert erstellt um Fehler beim erstellen abzufangen
	 * 
	 * @param dateipfad
	 */
	public XMLReader(String dateipfad) {
		// Erstellen des Builders
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			// Erstellen des Dokuments + uebergabe der Adresse des zu lesenden
			// Dokumentes
			document = builder.parse(new File(dateipfad));
		} catch (ParserConfigurationException e) {

			e.printStackTrace();
		} catch (SAXException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Die Methode reader() liest systematisch das zuvor festgelegte
	 * XML-Dokument aus. Zuerst wird die ID(String) des Sensor ausgelesen.
	 * Danach wird eine Liste Erstellt, in welche alle vorkommenden Messungen
	 * geschrieben werden. Somit sind alle Bedingungen fuer ein Sensor-Objekt
	 * erfuellt und ein vollstaendiges Sensor-Objekt wird zurueckgeliefert.
	 * 
	 * @return ein vollstaendiges Sensor Objekt wird zurueckgeliefert
	 */
	public Sensor reader() {

		// Knotepunkt-Liste wird erstellt. Wir setzen an der Stelle mit dem
		// String "Sensor" im erstellen Dokument an
		NodeList sensorList = document.getElementsByTagName("Sensor");
		// Knotenpunkt f ist das erste Item der erstellten Knotenpunktliste
		Node f = sensorList.item(0);
		// Der Knotenpunkt wird an das Element uebergeben
		Element sensor = (Element) f;
		// Das Attribut des Elements kann ausgelesen werden
		String sensorID = sensor.getAttribute("id");

		List<Messung> list = new ArrayList<>();
		// Knotenpunkt-Liste wird erstellt.Wir setzen an der Stelle mit dem
		// String "Messung" im erstellen Dokument an
		NodeList messungList = document.getElementsByTagName("Messung");
		for (int i = 0; i < messungList.getLength(); i++) {
			// Knotenpunkt p ist das erste Item der erstellten Knotenpunktliste
			Node p = messungList.item(i);
			// Der Knotenpunkt wird an das Element uebergebe
			Element messung = (Element) p;
			// Das Attribut des Elements muss auf ein Double geparst werden, da
			// es als String
			// im XML-Dokument existiert.
			double wert = Double.parseDouble(messung.getAttribute("wert"));
			// Das Attribut des Elements wird als Double uebergeben
			String zeitstempel = messung.getAttribute("zeitstempel");
			list.add(i, new Messung(wert, zeitstempel));
		}
		return new Sensor(sensorID, list);
	}

}
