package main;

public class ThreadTester {

	public static void main(String[] args) {
		Runnable threadJob = new MyRunnable();
		Thread t = new Thread(threadJob);
		
		t.start();
		try {
			Thread.sleep(1);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());
		System.out.println("back in the main method");
	}

}
