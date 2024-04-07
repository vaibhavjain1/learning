package multiThreading.theradPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadImplementation implements Runnable {
	String name;

	public ThreadImplementation(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Current Thread " + this.name);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		}
	}
}

public class SimpleThreadPoolDemo {

	public static void main(String[] args) {
		ExecutorService serv = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 10; i++) {
			serv.execute(new ThreadImplementation(String.valueOf(i)));
		}
		serv.shutdown();
		while (!serv.isTerminated()) {}
		System.out.println("All threads finished");
	}
}
