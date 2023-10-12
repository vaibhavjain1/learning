package designPatterns.behavioral.chainOfResponsibility_pattern.LoggerDesign;

public class Logger {

	public static final int DEBUG = 1;
	public static final int INFO = 2;
	public static final int WARN = 3;
	
	public static AbstractLogger getLogger(){
		AbstractLogger debugLogger = new DebugLogger(Logger.DEBUG);
		AbstractLogger infoLogger = new InfoLogger(Logger.INFO);
		AbstractLogger warnLogger = new WarnLogger(Logger.WARN);
		debugLogger.setNextLogger(infoLogger);
		infoLogger.setNextLogger(warnLogger);
		return debugLogger;
	}
}
