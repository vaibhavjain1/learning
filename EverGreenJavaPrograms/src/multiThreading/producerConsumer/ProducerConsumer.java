package multiThreading.producerConsumer;

import java.util.ArrayList;
import java.util.List;

class Producer implements Runnable {

	Object lock = new Object();
	Buffer obj = new Buffer();

	public Producer(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				obj.push(lock, i);
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}

class Consumer implements Runnable {

	Object lock = new Object();
	Buffer obj = new Buffer();

	public Consumer(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				obj.pop(lock);
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
	}

}

class Buffer {
	static List<Integer> buffer = new ArrayList<>(5);

	public void push(Object lock, int i) {
		synchronized (lock) {
			if (buffer.size() < 5) {
				System.out.println("Adding: " + i + " in buffer");
				buffer.add(i);
				lock.notifyAll();
			} else {
				try {
					lock.wait();
				} catch (InterruptedException e) {
				}
			}
		}
	}

	public void pop(Object lock) {
		synchronized (lock) {
			if (!buffer.isEmpty()) {
				System.out.println("Removing: " + buffer.remove(0) + " from buffer");
				lock.notifyAll();
			} else {
				try {
					lock.wait();
				} catch (InterruptedException e) {
				}
			}
		}
	}

}

public class ProducerConsumer {

	public static void main(String[] args) {
		Object lock = new Object();
		Thread prodThread = new Thread(new Producer(lock));
		Thread consThread = new Thread(new Consumer(lock));
		prodThread.start();
		consThread.start();
	}
}
