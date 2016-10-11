package augabenblatt2_1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Rechner {
  Operation op;
  Map<Operation, BinaryOperator>aufgabe = new HashMap<Operation, BinaryOperator>();
  aufgabe.put(ADDITION, BinaryOperator<String> binaryOpt = );

  public double berechne(Operation rechenart, double wert1, double wert2) {

    switch (rechenart) {
      case ADDITION :
        return wert1 + wert2;
      case SUBTRAKTION :
        return wert1 - wert2;
      case DIVISION :
        if (wert2 == 0) {
          throw new IllegalArgumentException("Divisor ist 0");
        } else {
          return wert1 / wert2;
        }
      case MULTIPLIKATION :
        return wert1 * wert2;
    }

    return 0;
  }

}
