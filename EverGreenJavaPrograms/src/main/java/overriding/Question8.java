package overriding;

class SeeA
{
    void methodOne(Double D)
    {
         
    }
     
    int methodTwo(Integer I)
    {
        return I;
    }
}
 
class SeeB extends SeeA
{
    /*@Override
    void methodOne(double d)
    {
         // causing trouble
    }*/
     
    @Override
    int methodTwo(Integer I)
    {
        return (int)1.1;
    }
}
