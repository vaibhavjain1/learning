package chainOfResponsibility;

public abstract class AbstractLogger {

	public static final int DEBUG = 1;
	public static final int INFO = 2;
	public static final int WARN = 3;
	
	public int level;
	public AbstractLogger nextLogger;
	
	public void setNextLogger(AbstractLogger logger){
		this.nextLogger =logger;
	}
	
	public void logMessage(int level, String Message){
		if(this.level<=level)
			writeMessage(Message);
		else if(nextLogger!=null){
			nextLogger.logMessage(level, Message);
		}
	}
	
	public abstract void writeMessage(String message);
}
