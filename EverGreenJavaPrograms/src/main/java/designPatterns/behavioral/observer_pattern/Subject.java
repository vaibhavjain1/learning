package observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	   List<Observer> observers = new ArrayList<Observer>();
	   private int state;

	   public int getState() {
	      return state;
	   }

	   public void setState(int state) {
	      this.state = state;
	      notifyAllObservers();
	   }

	   public void deattach(Observer observer){
		   int i = observers.indexOf(observer);
		   if(i>0)
			   observers.remove(i);
	   }
	   
	   public void attach(Observer observer){
	      observers.add(observer);		
	   }

	   public void notifyAllObservers(){
	      for (Observer observer : observers) {
	         observer.update();
	      }
	   } 
	
}

