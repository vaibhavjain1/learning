package justForTesting;

public abstract class Duck {
	//abstract class either can have abstract methods(without body) specified by
	//access modifier abstract as
	public abstract void display();
	
	FlyBehaviour flyBehaviourObj;
	
	public void performFly(){
		flyBehaviourObj.fly();
	}
	
	public void methodToOverride(){
		System.out.println("Base function called. No overriding.");
	}

}
