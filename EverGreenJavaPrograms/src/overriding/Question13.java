package overriding;

class Question13Parent{
    int i = 10;
    public void printValue(){
          System.out.print("Value-A");
    }
}

class Question13Child extends Question13Parent{
    int i = 12;
    public void printValue(){
          System.out.print("Value-B");
    }
}

public class Question13{
    public static void main(String args[]){
    	  Question13Parent obj = new Question13Child();
          obj.printValue();
          System.out.print(obj.i);
    }
}