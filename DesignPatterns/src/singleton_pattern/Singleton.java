package singleton_pattern;

class Singleton
{
	private static Singleton uniqueInstance;

	private Singleton()
	{
		//Since we are making constructor private. No other class can instantiate it.
	}

	public static synchronized Singleton getInstance()
	{
		if (uniqueInstance == null){
			uniqueInstance = new Singleton();
			System.out.println("Got unique instance");
		}
		return uniqueInstance;
	}
	
	public void doSomething()
	{
		//	Add Extra methods here
		System.out.println("Do something here");
	}
}
