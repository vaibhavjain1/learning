package lambdaExpression;

interface LambdaInterface{
	public int performTask(int a,int b);
}

public class LambdaExpressionUsage {

	// Till java 7 there was no way to create a method who is independent of Java
	public int add(int a,int b){
		return a+b;
	}
	
	public static void main(String[] args) {
		LambdaExpressionUsage obj = new LambdaExpressionUsage();
		System.out.println(obj.add(10, 20));
		
		// removing public, int, add from add method above and adding Lambda Expression, we will have this.
		LambdaInterface obj1 = (int a,int b) -> {
			return a+b;
		};
		
		//or better removing the type of parameters as we have already mentioned it in function defination inside interface.
		LambdaInterface obj2 = (a,b) -> {
			return a+b;
		};
		
		// or better remove the parenthesis & return statement as there is a single statment
		LambdaInterface obj3 = (a,b) ->  a+b;
		
	    // Main advantage of Lambda Expression is we don't pass the object rather then that we pass the behavior
		// If there is only single parameter then we can remove round brackets/parenthesis also like p -> p*p
		LambdaInterface obj4 = (a,b) -> a*b;
		
		System.out.println(obj1.performTask(10, 20));
		System.out.println(obj2.performTask(10, 20));
		System.out.println(obj3.performTask(10, 20));
		System.out.println(obj4.performTask(10, 20));
		
	}

}
