package overriding;

class SuperA
{
    public SuperA(int i)
    {
        System.out.println(myMethod(i));
    }
     
    int myMethod(int i)
    {
        return ++i + --i;
    }
}
 
class SuperB extends SuperA
{
    public SuperB(int i, int j)
    {
        super(i*j);
         
        System.out.println(myMethod(i, j));
    }
     
    int myMethod(int i, int j)
    {
        return myMethod(i*j);
    }
}
 
public class Question6
{
    public static void main(String[] args)
    {
        SuperB b = new SuperB(12, 21);
    }    
}
