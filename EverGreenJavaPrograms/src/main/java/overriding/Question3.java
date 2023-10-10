package overriding;

class Curr
{
    public Curr(int i)
    {
        System.out.println(1);
    }
     
    public Curr()
    {
        this(10);
         
        System.out.println(2);
    }
     
    void Curr()
    {
        Curr(10);
         
        System.out.println(3);
    }
     
    void Curr(int i)
    {
        System.out.println(4);
    }
}
 
 
public class Question3 
{    
    public static void main(String[] args)
    {
        new Curr().Curr();
    }
}
