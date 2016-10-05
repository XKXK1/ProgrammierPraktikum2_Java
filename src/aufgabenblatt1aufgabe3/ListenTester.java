package aufgabenblatt1aufgabe3;

import org.hamcrest.core.IsInstanceOf;

public class ListenTester {
	
	public static boolean listenTest(ArrayListe liste){
		if(liste.get(0) instanceof Number && liste.get(0)!=null){
		  return true;
		}
		return false;
		
	}

}
