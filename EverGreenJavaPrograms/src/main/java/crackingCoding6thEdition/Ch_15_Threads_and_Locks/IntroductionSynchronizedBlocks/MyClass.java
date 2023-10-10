package crackingCoding6thEdition.Ch_15_Threads_and_Locks.IntroductionSynchronizedBlocks;

public class MyClass extends Thread  {
	private String name;
	private MyObject myObj;
	
	public MyClass(MyObject obj, String n) {
		name = n;
		myObj = obj;
	}
	
	public void run() {
		myObj.foo(name);
	}
}
