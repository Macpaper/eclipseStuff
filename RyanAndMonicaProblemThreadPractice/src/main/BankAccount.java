package main;

public class BankAccount {
	private int balance = 100;
	int getBalance() {
		return balance;
	}
	public void withdraw(int amount) {
		balance -= amount;
	}
}
