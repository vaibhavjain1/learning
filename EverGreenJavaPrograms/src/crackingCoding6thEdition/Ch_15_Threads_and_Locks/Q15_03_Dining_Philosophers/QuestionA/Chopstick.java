package crackingCoding6thEdition.Ch_15_Threads_and_Locks.Q15_03_Dining_Philosophers.QuestionA;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
	private Lock lock;
	
	public Chopstick() {
		lock = new ReentrantLock();
	}

	public boolean pickUp() {
		return lock.tryLock();
	}
	
	public void putDown() {
		lock.unlock();	
	}
}
