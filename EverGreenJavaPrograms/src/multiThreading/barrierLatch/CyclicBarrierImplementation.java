package multiThreading.barrierLatch;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class CBThread implements Runnable{
	CyclicBarrier barrier;
	CBThread(CyclicBarrier barrier){
		this.barrier = barrier;
	}
	@Override
	public void run() {
		Random rand = new Random();
		int makeSleep = (rand.nextInt(10) + 5) * 1000;
		try {
			System.out.println("Thread:" + Thread.currentThread().getName() + " is going to sleep for:" + makeSleep + " miliseconds");
			Thread.sleep(makeSleep);
			System.out.println("Thread:" + Thread.currentThread().getName() + " is waiting on barrier");
			barrier.await();
			System.out.println("Thread:" + Thread.currentThread().getName() + " has crossed barrier");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

public class CyclicBarrierImplementation {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);
		Thread t1 = new Thread(new CBThread(barrier),"Thread 1");
		Thread t2 = new Thread(new CBThread(barrier),"Thread 2");
		Thread t3 = new Thread(new CBThread(barrier),"Thread 3");
		t1.start();
		t2.start();
		t3.start();
	}

}
