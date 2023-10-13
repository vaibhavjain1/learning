package designPatterns.structural.decorator_pattern;

public class Main_Decorator {

	public static void main(String[] args) {
		Coffee decoratorObj = new Latte();
		decoratorObj = new Sugar_Decorator(decoratorObj);
		decoratorObj.description();
	}
	
	
}
