package overriding;

public class Question4 
{    
    static void method(Integer i)
    {
        System.out.println(1);
    }
     
    static void method(int d)
    {
        System.out.println(2);
    }
     
    static void method(Number n)
    {
        System.out.println(4);
    }
     
    static void method(Object o)
    {
        System.out.println(5);
    }
     
    public static void main(String[] args)
    {
        method(12);
    }
}
