package observer_pattern;

public class HexaObserver implements Observer{
		private Subject subject;
	
	   public HexaObserver(Subject subject){
	      this.subject = subject;
	      this.subject.attach(this);
	   }

	   @Override
	   public void update() {
	      System.out.println( "Hexa String: " + Integer.toHexString( subject.getState() ) ); 
	   }
	}