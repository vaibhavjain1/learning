package decorator_pattern;

public class Sugar_Decorator extends Coffee_Dacorator {

	Coffee dec;
	public Sugar_Decorator(Coffee Decorator){
		this.dec=Decorator;
	}
	
	@Override
	public void description() {
		this.dec.description();
		System.out.println("Adding Sugar");
	}


	
	
}
