package overriding;

class OkeyA
{
    static void methodOne()
    {
        System.out.println("AAA");
    }
    
    void methodTwo(){
    	System.out.println("CCC");
    }
}
 
class OkeyB extends OkeyA
{
    static void methodOne()
    {
        System.out.println("BBB");
    }
    
    void methodTwo() {
    	System.out.println("DDD");
    }
}
 
public class Question9
{
    public static void main(String[] args)
    {
        OkeyA a = new OkeyB();
         
        a.methodOne();
        a.methodTwo();
    }    
}
