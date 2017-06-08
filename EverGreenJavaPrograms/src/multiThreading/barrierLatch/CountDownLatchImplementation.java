package multiThreading.barrierLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

class CDLThread implements Runnable {

	CountDownLatch latch;

	CDLThread(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		Random rand = new Random();
		int makeSleep = (rand.nextInt(10) + 5) * 1000;
		try {
			System.out.println("Thread:" + Thread.currentThread().getName() + " is going to sleep for:" + makeSleep + " miliseconds");
			Thread.sleep(makeSleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();
	}

}

public class CountDownLatchImplementation {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		Thread t1 = new Thread(new CDLThread(latch), "Thread 1");
		Thread t2 = new Thread(new CDLThread(latch), "Thread 2");
		Thread t3 = new Thread(new CDLThread(latch), "Thread 3");
		t1.start();
		t2.start();
		t3.start();
		try {
			latch.await();
			System.out.println("All threads finished. Resuming main thread.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
