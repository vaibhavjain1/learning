package overriding;

class Question16Parent{
    public Question16Parent(){
          System.out.println("A");
    }
    public Question16Parent(int i){
          this();
          System.out.println(i);
    }
}
class Question16Child extends Question16Parent{
    public Question16Child(){
          System.out.println("B");
    }
    public Question16Child(int i){
          this();
          System.out.println(i+3);
    }
}

class Question16Parent1{
    public Question16Parent1(int i){
          System.out.println(i);
    }
}
class Question16Child1 extends Question16Parent1{
    public Question16Child1(){
    	  super(6);
          System.out.println("B1");
    }
    public Question16Child1(int i){
          this();
          System.out.println(i+3);
    }
}

public class Question16{
    public static void main (String[] args){
          new Question16Child(5);
          System.out.println();
          new Question16Child1(8);
    }
}