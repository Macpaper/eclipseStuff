package main;

public class RunThreads implements Runnable {
	public static void main(String[] args) {
		RunThreads runner = new RunThreads();
		Thread alpha = new Thread(runner);
		Thread beta = new Thread(runner);
		alpha.start();
		beta.start();
		alpha.setName("alpha");
		beta.setName("beta");
	}
	public void run() {
		for(int i = 0; i < 4; i++) {
			System.out.println(Thread.currentThread().getName() + " thread is running");
		}
	}
}
