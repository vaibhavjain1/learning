package chainOfResponsibility.LoggerDesign;

public abstract class AbstractLogger {
	
	public int level;
	public AbstractLogger nextLogger;
	
	public void setNextLogger(AbstractLogger logger){
		this.nextLogger =logger;
	}
	
	public void logMessage(int level, String message){
		if(this.level==level)
			writeMessage(message);
		else if(nextLogger!=null){
			nextLogger.logMessage(level, message);
		} else {
			System.out.println("Default Logger: "+message);
		}
	}
	
	public abstract void writeMessage(String message);
}
