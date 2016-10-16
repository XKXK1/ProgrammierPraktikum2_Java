package augabenblatt2_1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Rechner {

//  Map<Operation, BinaryOperator>aufgabe = new HashMap<Operation, BinaryOperator>();
//  aufgabe.put(ADDITION, BinaryOperator<String> binaryOpt = );
	
	private DoubleDoubleZuDouble addition = (zahl1, zahl2) -> {return zahl1 + zahl2;};
	private DoubleDoubleZuDouble subtraktion = (zahl1, zahl2) -> {return zahl1 - zahl2;};
	private DoubleDoubleZuDouble multiplikation = (zahl1, zahl2) -> {return zahl1 * zahl2;};
	private DoubleDoubleZuDouble division = (zahl1, zahl2) -> {return zahl1 / zahl2;};
	
	Map<Operation, BinaryOperator<DoubleDoubleZuDouble>> hm; 
	
	public void hashMaptest(){
		new HashMap<>();
	    hm.put(Operation.ADDITION, (BinaryOperator<DoubleDoubleZuDouble>) addition);
	    hm.put(Operation.SUBTRAKTION, (BinaryOperator<DoubleDoubleZuDouble>) subtraktion);
	    hm.put(Operation.MULTIPLIKATION, (BinaryOperator<DoubleDoubleZuDouble>) multiplikation);
	    hm.put(Operation.DIVISION, (BinaryOperator<DoubleDoubleZuDouble>) division);    
    }
    
	public double berechne(Operation operator, double zahl1, double zahl2){
		
		return 1.0;
	}
    

	

	
	 
	



}
