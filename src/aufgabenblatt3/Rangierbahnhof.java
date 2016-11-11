package aufgabenblatt3;

import java.util.ArrayList;
import java.util.List;

public class Rangierbahnhof {
	private int anzGleise = 3;
	private List <Zug> gleise = new ArrayList<Zug>();
	private Object monitor1 = new Object();

	public void einfahren() {
		synchronized (monitor1) {
			for(int i = 0; i < anzGleise; i++){
				if (gleise.get(i)==null){
					gleise.add(i, new Zug());
				}
			}

		}
	}

	public void ausfahren() {
		synchronized (monitor1) {
			for(int i = 0; i < anzGleise; i++){
				if (gleise.get(i)!=null){
					gleise.remove(i);
				}
			}
		}

	}

}
