package overriding;

class MyABC
{    
    String myMethod(String s)
    {
        return s+s;
    }
}
 
class PQR extends MyABC
{
    String myMethod(String s, double d)
    {
        return myMethod(s+d);
    }
}
 
class MyXYZ extends PQR
{
    String myMethod(String s, double d, int i)
    {
        return myMethod(s, d+i);
    }
}
 
public class Question11
{
    public static void main(String[] args)
    {
        MyXYZ xyz = new MyXYZ();
         
        System.out.println(xyz.myMethod("JAVA", 23.23, 111));
    }    
}
