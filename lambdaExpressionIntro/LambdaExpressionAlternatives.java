package lambdaExpressionIntro;

/* @FunctionInterface annotation makes it mandatory to have only one abstract method.
 * It basically signifies that this interface is meant for Lambda expression(s) as
 * Lambda expression accepts only those interface which have only one abstrace method. 
*/
//@FunctionalInterface
interface MyFunctionalInterface {
	public void printMessage();
}


class MyfunctionalInterfaceImpl implements MyFunctionalInterface{
	@Override
	public void printMessage() {
		System.out.println("Calling print message from interface implementation");
	}
}

public class LambdaExpressionAlternatives {
	public void Perform(MyFunctionalInterface obj){
		obj.printMessage();
	}
	
	public static void main(String[] args) {
		// There are 3 ways 
		// 1. Create a class which implements interface
		MyFunctionalInterface obj = new MyfunctionalInterfaceImpl();
		obj.printMessage();
		
		// 2. Create an anonymous class
		MyFunctionalInterface obj1 = new MyFunctionalInterface() {
			@Override
			public void printMessage() {
				System.out.println("Calling print message from anonymous class");
			}
		};
		LambdaExpressionAlternatives obj2 = new LambdaExpressionAlternatives();
		obj2.Perform(obj1);
		
		// 3. Using Lambda Expression
		MyFunctionalInterface obj3 = () -> System.out.println("Calling print message from Lamda Expression");
		obj2.Perform(obj3);
	}

}
