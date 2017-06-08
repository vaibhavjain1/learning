package classLoader.oneClassLoader;

public class ClassToBeLoaded {
	
	public void printClassLoaderName(){
		System.out.println("Class To Be Loaded A classloader: "+ClassToBeLoaded.class.getClassLoader());
	}
}
