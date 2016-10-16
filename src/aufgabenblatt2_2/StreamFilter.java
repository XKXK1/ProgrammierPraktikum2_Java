package aufgabenblatt2_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class StreamFilter<T> {

  public List<T> verarbteitung(String[]eingabe){
    List<String> ausgabe = (List<String>) Arrays.asList(eingabe);
    List<T>test = new ArrayList<>();
    ausgabe.stream()
            .filter(Objects::nonNull)
            .flatMap(string -> Stream.of(string.trim()))
            .filter(string -> string.length()<8)
            .map(String::toUpperCase)
            .forEach(System.out::println);
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

    eingabe[4] = "Lpsda";
    eingabe[5] = "SkLdJs";
    eingabe[6] = "HaLlO";
    eingabe[7] = "TeSt";
    eingabe[8] = "BlUb";
    eingabe[9] = "AbCdE";
    
   System.out.println(test.verarbteitung(eingabe));
  }
}
