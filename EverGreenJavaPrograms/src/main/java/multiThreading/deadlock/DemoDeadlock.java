package multiThreading.deadlock;

public class DemoDeadlock {

	public static void main(String[] args) {
		String resource1 = "lock1";
		String resource2 = "lock2";
		new Thread() {
			@Override
			public void run() {
				synchronized (resource1) {
					try {
						System.out.println("locked resource 1");
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
					synchronized (resource2) {

					}
				}
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				synchronized (resource2) {
					try {
						System.out.println("locked resource 2");
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
					synchronized (resource1) {

					}
				}
			}
		}.start();
	}
}
