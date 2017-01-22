package singleton_pattern;

public class Singleton_Double_Checked_Locking {
	private volatile static Singleton_Double_Checked_Locking uniqueInstance;
	//Volatile keyword ensures that multiple threads handle the uniqueinstance variable correctly 
	//when it is being initialized to the singleton instance
	
	private Singleton_Double_Checked_Locking(){
		
	}
	
	public static Singleton_Double_Checked_Locking getInstance(){
		if(uniqueInstance==null){
			synchronized (Singleton_Double_Checked_Locking.class){
				if(uniqueInstance==null){
					uniqueInstance = new Singleton_Double_Checked_Locking();
					System.out.println("Unique instance Initialised using Double Checked locking");
				}
					
			}
			
		}
		return uniqueInstance;
	}
}
