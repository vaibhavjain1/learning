package chainOfResponsibility.LoggerDesign;

public class WarnLogger extends AbstractLogger{

	
	public WarnLogger(int level) {
		this.level = level;
	}

	@Override
	public void writeMessage(String message) {
		System.out.println("Warn Logger: "+message);
	}

}
