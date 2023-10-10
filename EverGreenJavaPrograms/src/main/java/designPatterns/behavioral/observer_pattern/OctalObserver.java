package observer_pattern;

public class OctalObserver implements Observer{
		private Subject subject;
	
	   public OctalObserver(Subject subject){
	      this.subject = subject;
	      this.subject.attach(this);
	   }

	   @Override
	   public void update() {
	      System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) ); 
	   }
	}