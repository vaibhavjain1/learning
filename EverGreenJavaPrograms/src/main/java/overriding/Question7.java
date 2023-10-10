package overriding;

class MyA
{
    void myMethod(Object o, Double D)
    {
        System.out.println(1);
    }
     
    void myMethod(Integer I, Number N)
    {
        System.out.println(2);
    }
}
 
class MyB extends MyA{
    void myMethod(Float F, Double D)
    {
        System.out.println(3);
    }
     
    void myMethod(Double D, Integer I)
    {
        System.out.println(4);
    }
}
 
public class Question7
{
    public static void main(String[] args)
    {
        MyB b = new MyB();
         
        b.myMethod(11.11, 0000);
         
        b.myMethod(8778, 3223);
         
        b.myMethod(2.3*1.2, 4.1*1.4);
         
        b.myMethod((float)23.56, 21.45);
    }    
}