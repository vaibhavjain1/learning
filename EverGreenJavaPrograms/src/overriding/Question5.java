package overriding;

class SuperX
{
    int method(int i)
    {
        return i *= i;
    }
}
 
class SuperY extends SuperX
{
    double method(double d)
    {
        return d /= d;    
    }
}
 
class SuperZ extends SuperY
{
    float method(float f)
    {
        return f += f;
    }
}
 
public class Question5
{
    public static void main(String[] args)
    {
        SuperZ z = new SuperZ();
         
        System.out.println(z.method(21.12));
    }
}
