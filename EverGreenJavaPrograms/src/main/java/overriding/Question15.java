package overriding;

class Question15Parent{
    public void printValue(){
          System.out.println("Value-A");
    }
}
class Question15ChildB extends Question15Parent{
    public void printNameB(){
          System.out.println("Name-B");
    }
}
class Question15ChildC extends Question15Parent{
    public void printNameC(){
          System.out.println("Name-C");
    }
}

public class Question15{
       public static void main (String[] args){
             Question15ChildB b = new Question15ChildB();
             Question15ChildC c = new Question15ChildC();
             newPrint(b);
             newPrint(c);
       }
       public static void newPrint(Question15Parent a){
             a.printValue();
      }
 }