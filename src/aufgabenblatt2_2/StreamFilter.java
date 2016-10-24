package aufgabenblatt2_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

import javafx.beans.binding.When.StringConditionBuilder;

/**
 * Die Klasse Streamfilter des generischen Typs T mit dem Typebound Comparable
 * um nur Typen zu akzeptieren, welche mit comparable<T> verglichen werden
 * koennen. Dies gewaehrleistet die Funktionalitaet der Methoden der Klasse.
 *
 * @param <T>
 */
public class StreamFilter<T extends Comparable<T>> {
	/**
	 * Eine Methode des Functional Interface "Stringbeschneider" Der Lambda
	 * Ausdruck erwartet einen String und beschneidet ihn auf Maximal 8 zeichen.
	 */
	private StringBeschneider schnippler = (String str) -> {
		if (str.length() > 8) {
			return str.substring(0, 8);
		}
		return str;
	};

	/**
	 * Die Methode verarbeitung(String[] eingabe) verarbeitet einen String
	 * Array. Der String wird wie folgt bearbeitet: "null" Objekte werden
	 * entfernt, Leerzeichen werden entfernt, alle Worte werden in Versalien
	 * dargestellt, alle Umlaute werden ersetzt (ä->ae,ö->oe ...). Alle Strings
	 * werden auf eine Maximallaenge von 8 beschnitten. Die Methode gibt eine
	 * bearbeitete Liste zurueck.
	 * 
	 * @param eingabe
	 * @return
	 */
	public List<T> verarbteitung(String[] eingabe) {
		// Das zu bearbeitende Array wird in eine Liste geschrieben um die
		// funktionalitaet des Streams nutzen zu koennen
		List<String> verwurster = (List<String>) Arrays.asList(eingabe);
		// eine Leere Ausgabeliste wird erstellt
		List<String> ausgabe = new ArrayList<>();

		verwurster.stream().filter(Objects::nonNull).map(String::trim).map(String::toUpperCase)
				.map(aeErsetzer -> aeErsetzer.replace("Ä", "AE")).map(ueErsetzer -> ueErsetzer.replace("Ü", "UE"))
				.map(oeErsetzer -> oeErsetzer.replace("Ö", "OE")).map(szErsetzer -> szErsetzer.replace("ß", "SS"))
				.map(String -> schnippler.richtigeLaenge(String)).forEach(ausgabe::add);
		return (List<T>) ausgabe;
	}
}
