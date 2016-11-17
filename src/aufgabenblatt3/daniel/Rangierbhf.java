package aufgabenblatt3.daniel;

import java.util.Observable;

import aufgabenblatt3.Zug;

public class Rangierbhf extends Observable{
  private int anzGleise = 3;
  private Zug[] gleisArr = new Zug[anzGleise];
  
  public Zug[] getGleisArr() {
    // TODO Auto-generated method stub
    return gleisArr;
  }

  public synchronized void einfahren(int gleis) {
    try {
      if (gleisArr[gleis] != null) {
        this.wait();
      } else {
        gleisArr[gleis] = new Zug();
        setChanged();
        notifyObservers(gleisArr);
        System.out.println(" faehrt den Zug ein--> GLEIS: " + gleis);
        this.notifyAll();
      }
    } catch (InterruptedException e) {
    }
  }

  public synchronized void ausfahren(int gleis) {
    try {
      if (gleisArr[gleis] == null) {
        this.wait();
      } else {
        gleisArr[gleis] = null;
        setChanged();
        notifyObservers(gleisArr);
        System.out.println(" faehrt den Zug aus--> GLEIS: " + gleis);
        Thread.sleep(0);
        this.notifyAll();
      }
    } catch (InterruptedException e) {
    }
  }
    
  public int getAnzGleise(){
    return anzGleise;
  }

  public Lockfhr erzeugeLokfhr(Rangierbhf bahnhf) {
    Lockfhr lokfhr = new Lockfhr(bahnhf);
    lokfhr.start();
    System.out.println("->Neuer Lokfuehrer beginnt seine Arbeit \n");
    return lokfhr;    
  }


}
