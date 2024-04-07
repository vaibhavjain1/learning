package multiThreading.oddEven;

public class OddEvenSameClass {
	int counter  = 0;
	void runThreads(){
		new Thread(()->{
			synchronized (this){
				while (counter < 50) {
					if (counter % 2 != 0) {
						try {
							wait();
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}
					System.out.println("Even thread: " + counter);
					counter++;
					notify();
				}
			}
		}).start();

		new Thread(()->{
			synchronized (this) {
				while (counter < 50) {
					if (counter % 2 == 0) {
						try {
							wait();
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}
					System.out.println("Odd thread: " + counter);
					counter++;
					notify();
				}
			}
		}).start();
	}

	public static void main(String[] args) {
		new OddEvenSameClass().runThreads();
	}
}
