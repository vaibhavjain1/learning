package output;

public class Question2 {

	public static void main(String args[])
	{
	    method1();
	    method2();
	}
	
	//Use case1
	static void method1(){
		System.out.println("X in method1:"+Question2.x);
	}
	static {
	    System.out.println("X in static block:"+Question2.x);
	}
	static int x=90;
	
	//Use case2
	static void method2(){
		System.out.println("Y in method2:"+Question2.y);
	}
	static int y=90;
	static {
	    System.out.println("Y in static block:"+Question2.y);
	}

}
