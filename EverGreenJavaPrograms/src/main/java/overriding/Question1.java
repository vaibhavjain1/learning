package overriding;

class Question1GrandParent
{
     
}
 
class Question1Parent extends Question1GrandParent
{
     
}
 
class Question1Child extends Question1Parent
{
     
}
 
public class Question1 
{
    static void overloadedMethod(Question1GrandParent a)
    {
        System.out.println("ONE");
    }
     
    static void overloadedMethod(Question1Parent b)
    {
        System.out.println("TWO");
    }
     
    static void overloadedMethod(Object obj)
    {
        System.out.println("THREE");
    }
     
    public static void main(String[] args)
    {
        Question1Child c = new Question1Child();
         
        overloadedMethod(c);
    }
}
