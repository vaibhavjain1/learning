package designPatterns.behavioral.chainOfResponsibility_pattern.LoggerDesign;

public class DebugLogger extends AbstractLogger{

	
	public DebugLogger(int level) {
		this.level = level;
	}

	@Override
	public void writeMessage(String message) {
		System.out.println("Debug Message: "+ message);
	}

}
