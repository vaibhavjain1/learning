package multiThreading.threadLocalPackage;

import java.util.Random;

class ThreadLocalClass {

	static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

}

class MyThreadClass implements Runnable {

	@Override
	public void run() {
		Random obj = new Random();
		int randomNumber = 1 + obj.nextInt(15);
		ThreadLocalClass.threadLocal.set(randomNumber);
		try {
			Thread.sleep(1000*randomNumber);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Value of thread local for Thread: "+ Thread.currentThread().getName()+" is :"+ThreadLocalClass.threadLocal.get());
	}
}

public class ThreadLocalImplementation {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThreadClass());
		Thread t2 = new Thread(new MyThreadClass());
		Thread t3 = new Thread(new MyThreadClass());
		t1.start();
		t2.start();
		t3.start();
	}
}
