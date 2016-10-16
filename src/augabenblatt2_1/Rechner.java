package augabenblatt2_1;

import java.util.HashMap;
import java.util.function.BinaryOperator;

public class Rechner {
  HashMap<Operation, BinaryOperator<Double>> hm;

  public Rechner() {
    hm = new HashMap<Operation, BinaryOperator<Double>>();
    hm.put(Operation.ADDITION, (zahl1, zahl2) -> {
      return zahl1 + zahl2;
    });
    hm.put(Operation.SUBTRAKTION, (zahl1, zahl2) -> {
      return zahl1 - zahl2;
    });
    hm.put(Operation.MULTIPLIKATION, (zahl1, zahl2) -> {
      return zahl1 * zahl2;
    });
    hm.put(Operation.DIVISION, (zahl1, zahl2) -> {
      return zahl1 / zahl2;
    });
  }

  public double berechne(Operation operator, double zahl1, double zahl2) {
    return hm.get(operator).apply(zahl1, zahl2);
  }

  public static void main(String[] args) {
    Rechner rechner = new Rechner();
    System.out.println(rechner.berechne(Operation.ADDITION, 12, 11));
  }
}
