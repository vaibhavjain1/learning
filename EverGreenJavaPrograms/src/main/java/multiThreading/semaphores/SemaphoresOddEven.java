package multiThreading.semaphores;

import java.util.concurrent.Semaphore;

class ProducerSema implements Runnable{
	
	Semaphore sema;
	
	public ProducerSema(Semaphore sema) {
		this.sema = sema;
	}
	@Override
	public void run() {
		
	}
	
}

class ConsumerSema implements Runnable{
	
	Semaphore sema;
	
	public ConsumerSema(Semaphore sema) {
		this.sema = sema;
	}
	@Override
	public void run() {
		
	}
	
}

class SemaThreadBuffer{
	
	public static void print(int i){
		
	}
	
}

class Mysemaphore implements Runnable{
	Semaphore evensema, oddsema;
	static boolean isEven = true;
	public Mysemaphore(Semaphore evensema, Semaphore oddsema) {
		this.evensema = evensema;
		this.oddsema = oddsema;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if(Thread.currentThread().getName().equals("Even")){
				try {
					evensema.acquire();
					System.out.println(2*i);
					isEven = false;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					oddsema.release();
					
				}
			}else{
					try {
						oddsema.acquire();
						System.out.println(2*i+1);
						isEven = true;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally{
						evensema.release();
					}
			}
		}
	}
}

public class SemaphoresOddEven {
	static volatile int i = 0;
	
	public static void main(String[] args) {
		Semaphore evensema = new Semaphore(1);
		Semaphore oddsema = new Semaphore(0);
		Thread t1 = new Thread(new Mysemaphore(evensema, oddsema),"Even");
		Thread t2 = new Thread(new Mysemaphore(evensema, oddsema),"Odd");
		t1.start();
		t2.start();
	}
}
