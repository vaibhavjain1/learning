package chainOfResponsibility.LoggerDesign;

public class DemoChainOfResponsibility {
	
	/*
	 * Definition: Chain of responsibility decouples sender of request to receiver by giving
	 * more than one object the opportunity to handle the request.
	 * The pattern chains the receiving objects and then passed any request message from object
	 * to object until it reaches the object who is capable of handling it.
	 */
	
	/*
	 * Java inbuilt example:  Java.util.logging.Logger#Log()
	 * 						  Javax.servlet.Filter#Filter()
	 */
	public static void main(String[] args) {
		AbstractLogger logger = Logger.getLogger();
		logger.logMessage(1, "DebugMessage");
		logger.logMessage(2, "InfoMessage");
		logger.logMessage(Logger.WARN, "Warn Message");
		logger.logMessage(4, "Waste Message");
	}

}
