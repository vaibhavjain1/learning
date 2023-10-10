package multiThreading.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

// Testing mutual exclusion by semaphore
class MySemaPhoreThread implements Runnable {

	Semaphore binarySemaphore;

	MySemaPhoreThread(Semaphore binarySemaphore) {
		this.binarySemaphore = binarySemaphore;
	}

	@Override
	public void run() {
		try {
			System.out.println("Available Permits outsides critical section: " + binarySemaphore.availablePermits());
			binarySemaphore.acquire();
			System.out.println("Current thread executing in Critical secion: " + Thread.currentThread().getName());
			System.out.println("Available Permits in critical section: " + binarySemaphore.availablePermits());
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			binarySemaphore.release();
		}
	}

}

public class SemaphoreImpl {

	public static void main(String[] args) {
		Semaphore binarySemaphore = new Semaphore(1);
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			threadPool.submit(new MySemaPhoreThread(binarySemaphore));
		}
		threadPool.shutdown();
		while (!threadPool.isTerminated()) {
		}
	}

}
