package multiThreading.oddEven;

class EvenClass implements Runnable {
	Object lock;
	int i = 0;
	PrintOddEven obj = new PrintOddEven();

	public EvenClass(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		while (i < 20) {
			i = obj.printEven(lock, i);
		}
	}

}

class OddClass implements Runnable {
	Object lock;
	int i = 0;
	PrintOddEven obj = new PrintOddEven();

	public OddClass(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		while (i < 20) {
			i = obj.printOdd(lock, i);
		}
	}

}

class PrintOddEven {
	static boolean isEven = true;

	public int printEven(Object lock, int i) {
		synchronized (lock) {
			if (isEven) {
				System.out.println("Even :" + (2 * i));
				isEven = false;
				lock.notifyAll();
				return i + 1;
			} else {
				try {
					lock.wait();
				} catch (InterruptedException e) {
				}
				return i;
			}
		}
	}

	public int printOdd(Object lock, int i) {
		synchronized (lock) {
			if (!isEven) {
				System.out.println("Odd  :" + (2 * i + 1));
				isEven = true;
				lock.notifyAll();
				return i + 1;
			} else {
				try {
					lock.wait();
				} catch (InterruptedException e) {
				}
				return i;
			}
		}
	}
}

public class OddEvenSeperateClass {
	public static void main(String[] args) {
		Object lock = new Object();
		EvenClass evenObj = new EvenClass(lock);
		OddClass oddObj = new OddClass(lock);
		Thread evenThread = new Thread(evenObj);
		Thread oddThread = new Thread(oddObj);
		evenThread.start();
		oddThread.start();
	}
}
