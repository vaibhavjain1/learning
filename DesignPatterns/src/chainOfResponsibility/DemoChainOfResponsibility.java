package chainOfResponsibility;

public class DemoChainOfResponsibility {
	
	public static void main(String[] args) {
		AbstractLogger logger = Logger.getLogger();
		logger.logMessage(1, "DebugMessage");
		logger.logMessage(2, "InfoMessage");
		logger.logMessage(Logger.WARN, "Warn Message");
		logger.logMessage(4, "Waste Message");
	}

}
