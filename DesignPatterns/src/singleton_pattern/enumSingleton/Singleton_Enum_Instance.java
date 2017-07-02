package singleton_pattern.enumSingleton;

enum MySingleton{
	INSTANCE;
	private MySingleton(){
		System.out.println("Created single instance for Singleton");
	}
}

public class Singleton_Enum_Instance {
		
	public static void main(String[] args) {
		System.out.println(MySingleton.INSTANCE.hashCode());
		System.out.println(MySingleton.INSTANCE.hashCode());	
	}
}
