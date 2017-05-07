package entities;
//Account class

public class Account {
	
	/**
	 * Creating attributes for the class. 
	 * The first int is used to desribe the player's balance.
	 * The other int is used to put a limit to the player's balance so that it can never drop below 0.
	 */
	private int balance;
	private int MIN = 0;
	
	/**
	 * constructor for the Account.
	 * @param balance is the amount of money in the account.
	 */
	public Account(int balance){
		this.balance = balance;
	}

	/**
	 * Method used for adding money to the player's balance, this is also used to subtract money from the balance.
	 * @param point the int value that is added to the balance.
	 * minBalance is a method used here to make sure that the player's balance never goes below 0.
	 * @return Balance
	 */
	public int addBalance(int point){
		balance = balance + point;
		minBalance();
		return balance;
		
	}
	
	/**
	 * Used to set the player's balance.
	 * @param newBalance is the player's new balance.
	 */
	public void setBalance(int newBalance){
		balance = newBalance;
	}
	
	/**
	 * Used to return the player's current balance.
	 * @return Balance.
	 */
	public int getBalance(){
		return balance;
	}
	
	/**
	 * Used to check if the player's balance gets below 0, and if it does sets it to 0.
	 * @return
	 */
	private int minBalance(){
		if (balance <= MIN){
			balance=0;
		}
		return balance;
	}
	
	/**
	 * Converts the Balance int to a string.
	 */
	public String toString(){
		return Integer.toString(balance);
	}
}
