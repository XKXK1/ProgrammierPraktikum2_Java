package aufgabenblatt1aufgabe2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class TestXML {

	/**
	 * Es wird getestet, ob der XMLReader aus einer vorhandenen XML-Datei ein
	 * richtiges Sensor-Objekt erstellt.
	 */
	@Test
	public void testXMLReader() {
		// Erstellen eines Test-Sensor-Objektes
		List<Messung> testList = new ArrayList<Messung>();
		testList.add(new Messung(23.2, "2016-06-23T16:51:40.408"));
		testList.add(new Messung(24.5, "2016-06-24T12:12:52.000"));
		Sensor testSensor = new Sensor("Temperatur Wohnzimmer", testList);

		// Auslesen einer vorhandenen Sensor-XML-Datei
		XMLReader auslesung;
		auslesung = new XMLReader("Z:/PTP/Semester 2/pm2_teamrocket/src/aufgabenblatt1aufgabe2/sensor.xml");

		// Schreiben eines Sensor-Objektes aus der ausgelesenen XML-Datei
		Sensor test = auslesung.reader();

		// Equals-Vergleich der beiden Sensor-Objekte
		assertTrue(test.equals(testSensor));
	}

	/**
	 * "Stille-Post-Prinizp" Es soll ueberprueft werden, ob der XML-Writer eine
	 * gueltige XML-Datei aus einem Sensor erstellt. Dies wird durch den
	 * XML-Reader ueberprueft
	 */
	@Test
	public void testXMLWriter() {

		// Erstellen eines Sensor-Objektes
		List<Messung> testList = new ArrayList<Messung>();
		testList.add(new Messung(23.2, "2016-06-23T16:51:40.408"));
		testList.add(new Messung(24.5, "2016-06-24T12:12:52.000"));
		Sensor testSensor = new Sensor("Temperatur Wohnzimmer", testList);

		XMLWriter xmlwriter = new XMLWriter();

		// Erstellen einer XML-Datei aus dem Sensor-Objekt an dem angegebene
		// Pfad
		xmlwriter.writer(testSensor, "Z:/PTP/Semester 2/pm2_teamrocket/src/aufgabenblatt1aufgabe2/blub.xml");

		// Erstellung eines Sensor Objektes anhand der gerade erstellten
		// XML-Datei
		XMLReader auslesung;
		auslesung = new XMLReader("Z:/PTP/Semester 2/pm2_teamrocket/src/aufgabenblatt1aufgabe2/blub.xml");
		Sensor test = auslesung.reader();

		// Vergleich der beiden Sensor-Objekte
		assertTrue(test.equals(testSensor));
	}
}
