package singleton_pattern;

public class Main_Singleton {

	public static void main(String[] args) {
		Singleton a = Singleton.getInstance();
		Singleton b = Singleton.getInstance();
		Singleton c = Singleton.getInstance();
		
		// We can create Eagerly instance. In this approach we rely on JCM to create the uniquie instance of the singleton
		// when the class is loaded. The JVM guarantees that the instance will be created before any thread accesses the static
		// unique instance.
		Singleton_Eagerly_Instance d = Singleton_Eagerly_Instance.getInstance();
		Singleton_Eagerly_Instance e = Singleton_Eagerly_Instance.getInstance();
		Singleton_Eagerly_Instance f = Singleton_Eagerly_Instance.getInstance();
		
		//Syncronized as well as efficient. As syncronization is done only first time.
		Singleton_Double_Checked_Locking g = Singleton_Double_Checked_Locking.getInstance();
		Singleton_Double_Checked_Locking h = Singleton_Double_Checked_Locking.getInstance();
		Singleton_Double_Checked_Locking i = Singleton_Double_Checked_Locking.getInstance();
	}
}
