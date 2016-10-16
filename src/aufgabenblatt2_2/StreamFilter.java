package aufgabenblatt2_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamFilter<T extends Comparable<T>> {

  public List<T> verarbteitung(String[]eingabe){
    List<String> verwurster = (List<String>) Arrays.asList(eingabe);
    List<String> ausgabe = new ArrayList<>();
    
    verwurster.stream()
            .filter(Objects::nonNull)
            .flatMap(string -> Stream.of(string.trim()))
            .filter(string -> string.length()<8)
            .map(String::toUpperCase)
            .map(string->string.replace("ƒ", "AE"))
            .map(string->string.replace("‹", "UE"))
            .map(string->string.replace("÷", "OE"))
            .map(string->string.replace("ﬂ", "SS"))
            .forEach(ausgabe::add);
    return (List<T>) ausgabe;
    
  }
  
  public static void main(String[]args){
    StreamFilter<String> test = new StreamFilter<>();
    String[] eingabe;
    
    eingabe = new String[10];
       
    // initialize first element
    eingabe[0] = "Hallo ";
    // initialize second element
    eingabe[1] = "DIESISTEIN";
    // and so forth
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
