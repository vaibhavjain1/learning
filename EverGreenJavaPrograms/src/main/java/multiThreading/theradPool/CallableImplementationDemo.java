package multiThreading.theradPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ThreadCallable implements Callable<Boolean>{
	String name;

	public ThreadCallable(String name) {
		this.name = name;
	}
	
	@Override
	public Boolean call() throws Exception {
		for (int i = 0; i < 10; i++) {
			System.out.println("Current Thread " + this.name);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		}
		return true;
	}
	
}

public class CallableImplementationDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService serv= Executors.newFixedThreadPool(4);
		List<Future<Boolean>> list = new ArrayList<Future<Boolean>>();
		for (int i = 0; i < 10; i++) {
			Future<Boolean> future = serv.submit(new ThreadCallable("Thread:" + i));
			list.add(future);
		}
		for (Future<Boolean> future : list) {
			System.out.println(future.get());
		}
		
		serv.shutdown();
		while (serv.isTerminated()) {
			
		}
		System.out.println("All threads finished");
	}
}
