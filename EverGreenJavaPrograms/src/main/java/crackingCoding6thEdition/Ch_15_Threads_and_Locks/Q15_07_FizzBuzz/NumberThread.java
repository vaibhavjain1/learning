package crackingCoding6thEdition.Ch_15_Threads_and_Locks.Q15_07_FizzBuzz;

public class NumberThread extends FizzBuzzThread {
	public NumberThread(boolean div3, boolean div5, int max) {
		super(div3, div5, max, null);
	}

	public void print() {
		System.out.println(current);
	}
}
