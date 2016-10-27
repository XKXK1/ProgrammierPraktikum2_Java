package aufgabenblatt2_2;

/**
 * ein Funktionales Interface mit genau einer Methodensignatur des Typs String.
 * Es es wird als beschneider eines Strings dienen und erwartet einen string als
 * Argument.
 * 
 *  * @author Derya Uyargil, Daniel von Drathen
 */
@FunctionalInterface
public interface StringBeschneider {
	public String richtigeLaenge(String str);
}
