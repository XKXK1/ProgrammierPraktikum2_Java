package aufgabenblatt1aufgabe2;

import java.util.ArrayList;
import java.util.List;

public class Sensor {
	private String id;
	private Messung messung;
	List<Messung> list = new ArrayList<Messung>();
	
	public Sensor(String id){
		this.id = id;	
	}
	
	public static void main(String[] args) {
		Sensor sensor1 = new Sensor("penis");
		
		
		Messung messung1 = new Messung(5.2);
		System.out.print(messung1.toString());
		
	
	}
}
