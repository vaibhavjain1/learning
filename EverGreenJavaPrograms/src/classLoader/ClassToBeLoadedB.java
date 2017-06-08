package classLoader;

public class ClassToBeLoadedB {

	public void printmessage(String message){
		System.out.println("Message: "+message);
	}
	
	public void printClassLoaderName(){
		System.out.println("Class To Be Loaded B classloader: "+ClassToBeLoadedB.class.getClassLoader());
	}
}
