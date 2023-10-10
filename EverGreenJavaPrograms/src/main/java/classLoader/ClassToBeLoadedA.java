package classLoader;

public class ClassToBeLoadedA {

	public static void main(String[] args) {
		System.out.println("Inside Class To be Loaded A");
		ClassToBeLoadedB objB = new ClassToBeLoadedB();
		objB.printmessage("Calling Print message from class A");
		objB.printClassLoaderName();
	}
	
	public void printClassLoaderName(){
		System.out.println("Class To Be Loaded A classloader: "+ClassToBeLoadedA.class.getClassLoader());
	}
}
