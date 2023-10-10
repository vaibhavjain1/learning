package output;

public class StringBehaviour {

	public static void main(String[] args) {
		String temp1 = "vaibhav";  // String Pool
		String temp2 = "jain";   // String Pool
		String temp3 = temp1 + temp2; // Heap
		String temp4 = "vaibhav" + temp2; // Heap
		String temp5 = temp1 + "jain"; // Heap
		String temp6 = "vaibhav" + "jain"; // String Pool
		String temp7 = "vaibhavjain"; // String Pool
		
		String temp8 = new String("vaibhav"); // Heap
		String temp9 = new String("jain"); // Heap
		String temp10 = temp8+temp9; // Heap
		String temp11 = temp10.intern(); // String Pool
		
		System.out.println(temp7 == temp3);
		System.out.println(temp7 == temp4);
		System.out.println(temp7 == temp5);
		System.out.println(temp7 == temp6);
		System.out.println(temp7 == temp10);
		System.out.println(temp7 == temp11);
		
	}

}
