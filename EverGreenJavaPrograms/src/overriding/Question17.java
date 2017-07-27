package overriding;

class Question17Parent{
	public int i;
	protected int j;
}

class Question17Child extends Question17Parent{
	int j;
	public void display(){
		super.j = 3;
		super.i = 10;
		System.out.println(i+" "+j);
	}
}

public class Question17 {
	public static void main(String[] args) {
		Question17Child obj = new Question17Child();
		obj.i = 1;
		obj.j = 2;
		obj.display();
	}
}
