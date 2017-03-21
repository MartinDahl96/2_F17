package entities;

public class Player {
	//Attributes
	private String name;
	private Account balance;
	private boolean inJail;
	private int ID;
	private int jailRounds;
	private int currentPosition;
	
	//Constructor for a player-object.
	public Player(){
		
	}
	
	//Returns the name of the player.
	public String getName() {
		return name;
	}
	
	//Sets the name of a player.
	public void setName(String name) {
		this.name = name;
	}
	
	//Returns the player's balance.
	public Account getBalance() {
		return balance;
	}
	
	//sets the player's balance.
	public void setBalance(Account balance) {
		this.balance = balance;
	}

	//gets the player's jail-status.
	public boolean isInJail() {
		return inJail;
	}

	//sets the player's jail-status.
	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

	//gets the player's ID.
	public int getID() {
		return ID;
	}

	//sets the player's ID.
	public void setID(int iD) {
		ID = iD;
	}

	//gets the amount of rounds left of a player's jail-time.
	public int getJailRounds() {
		return jailRounds;
	}

	//sets the amount of rounds left of a player's jail-time.
	public void setJailRounds(int jailRounds) {
		this.jailRounds = jailRounds;
	}

	//gets the player's current position.
	public int getCurrentPosition() {
		return currentPosition;
	}

	//sets the player's current position.
	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
}
