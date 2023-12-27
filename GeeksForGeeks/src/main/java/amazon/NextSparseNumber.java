package amazon;

public class NextSparseNumber {

	public String getBinaryReprsentation(int number) {
		String temp = "";
		while(number!=0){
			temp = number%2+temp;
			number /=2;
		}
		return temp;
	}
	
	public int nextSparseNumber() {
		return 0;
	}
	
	public static void main(String[] args) {
		int number = 1111;
		NextSparseNumber obj = new NextSparseNumber();
		System.out.println(obj.getBinaryReprsentation(number));
	}
}
