package main;

public class MyRunnable implements Runnable {
	public void run() {
		go();
	}
	public void go() {
		System.out.println("what the fuck");
		doMore();
		System.out.println("what the fuckbut after");
	}
	public void doMore() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("this is the top of the stack!");
	}
}
