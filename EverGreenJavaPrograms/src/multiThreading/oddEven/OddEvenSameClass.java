package multiThreading.oddEven;

class PrintOddEvenClass implements Runnable{

	Object lock;
	int currValue;
	boolean isEven = true;
	public PrintOddEvenClass(Object lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {
		while (currValue<20) {
			if(Thread.currentThread().getName().equalsIgnoreCase("Even"))
				printEven();
			else
				printOdd();
		}
	}
	
	public void printEven(){
		synchronized (lock) {
			if(isEven){
				System.out.println("Even: "+currValue);
				currValue+=1;
				isEven = false;
				lock.notifyAll();
			}else{
				try {
					lock.wait();
				} catch (InterruptedException e) {
				}
			}
		}
	}
	
	public void printOdd(){
		synchronized (lock) {
			if(!isEven){
				System.out.println("Odd:  "+currValue);
				currValue+=1;
				isEven = true;
				lock.notifyAll();
			}else{
				try {
					lock.wait();
				} catch (InterruptedException e) {
				}
			}
		}
	}
}

public class OddEvenSameClass {

	public static void main(String[] args) {
		Object lock = new Object();
		PrintOddEvenClass threadObj = new PrintOddEvenClass(lock);
		Thread teven = new Thread(threadObj, "Even");
		Thread todd = new Thread(threadObj, "Odd");
		teven.start();
		todd.start();
	}
}