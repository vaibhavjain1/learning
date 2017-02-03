package chainOfResponsibility;

public class DemoChainOfResponsibility {

	public static AbstractLogger getLogger(){
		AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
		AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
		AbstractLogger warnLogger = new WarnLogger(AbstractLogger.WARN);
		debugLogger.setNextLogger(infoLogger);
		debugLogger.setNextLogger(warnLogger);
		return debugLogger;
	}
	
	public static void main(String[] args) {
		AbstractLogger logger = getLogger();
		logger.logMessage(1, "DebugMessage");
		logger.logMessage(2, "InfoMessage");
		logger.logMessage(AbstractLogger.WARN, "Warn Message");
	}

}
