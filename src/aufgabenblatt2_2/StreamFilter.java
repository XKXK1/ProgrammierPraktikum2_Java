package aufgabenblatt2_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

import javafx.beans.binding.When.StringConditionBuilder;

public class StreamFilter<T extends Comparable<T>> {

  private StringBeschneider schnippler = (String str) -> {if(str.length()>8){return str.substring(0, 8);}return str;};

  public List<T> verarbteitung(String[]eingabe){
    List<String> verwurster = (List<String>) Arrays.asList(eingabe);
    List<String> ausgabe = new ArrayList<>();
    
    verwurster.stream()
            .filter(Objects::nonNull)
            .map(String::trim)
            .map(String::toUpperCase)
            .map(aeErsetzer->aeErsetzer.replace("ƒ", "AE"))
            .map(ueErsetzer->ueErsetzer.replace("‹", "UE"))
            .map(oeErsetzer->oeErsetzer.replace("÷", "OE"))
            .map(szErsetzer->szErsetzer.replace("ﬂ", "SS"))
            .map(String -> schnippler.richtigeLaenge(String))
            .forEach(ausgabe::add);
    return (List<T>) ausgabe;
    
  }

  public static void main(String[] args) {
    StreamFilter<String> test = new StreamFilter<>();
    String[] eingabe;

    eingabe = new String[10];
    eingabe[0] = "Hallo ";
    eingabe[1] = "DIESISTEIN";
    eingabe[2] = " BauAnA";
    eingabe[4] = "Lpﬂda";
    eingabe[5] = "SkLdJs";
    eingabe[6] = "H‰LlO";
    eingabe[7] = "TeSt";
    eingabe[8] = "Bl‹b";
    eingabe[9] = "AbCdE";

    System.out.println(test.verarbteitung(eingabe));
  }
}
