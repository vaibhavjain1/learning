package designPatterns.creational.singleton_pattern;

public class Singleton_Eagerly_Instance {

	private static Singleton_Eagerly_Instance uniqueinstance = new Singleton_Eagerly_Instance();
	
	private Singleton_Eagerly_Instance(){
		System.out.println("Eagerly Instance Created");
	}
	
	public static Singleton_Eagerly_Instance getInstance(){
		return uniqueinstance;
	}
}
