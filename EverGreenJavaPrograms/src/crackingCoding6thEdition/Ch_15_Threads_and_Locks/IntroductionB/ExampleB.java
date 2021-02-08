package crackingCoding6thEdition.Ch_15_Threads_and_Locks.IntroductionB;

public class ExampleB {
	public static void main(String args[]) {
		ThreadExample instance = new ThreadExample();
		instance.start();
		
		while (instance.count != 5) {		
			try {
				Thread.sleep(250);
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		}
	}
}
