package output;

import java.util.ArrayList;

public class Question1 {

	public static void main(String[] args) {
		ArrayList<String> obj1= new ArrayList<>();
		ArrayList<String> obj2 = new ArrayList<>();
		obj1.add("A");
		obj1.add("B");
		obj2.add("A");
		obj2.add(1,"B");
		System.out.println(obj1.equals(obj2));
		
		int x = 0, y = 0, z= 0;
		x = (++x + y--) * z++;
		System.out.println(x);
	}

}
