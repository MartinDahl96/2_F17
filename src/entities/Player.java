package entities;

public class Player {
	// Attributes
	private String playerName;
	private Account account;
	private int ID;
	private int jailRounds;
	private int ownedFerries;
	private int currentPosition;
	private int fortune;

	// Constructor for a player-object.
	public Player(String name) {
		playerName = name;
		this.account = new Account(26000);
		fortune = this.account.getBalance();
	}

	// Returns the name of the player.
	public String getplayerName() {
		return playerName;
	}

	// Sets the name of a player.
	public void setplayerName(String name) {
		playerName = name;
	}

	// Returns the player's balance.
	public int getFortune() {
		return this.fortune;
	}

	public void setFortune(int newFortune) {
		this.fortune += newFortune;
	}

	// gets the player's ID.
	public int getPlayerNumber() {
		return ID;
	}

	// sets the player's ID.
	public void setPlayerNumber(int playerNumber) {
		ID = playerNumber;
	}

	// gets the amount of rounds left of a player's jail-time.
	public int getJailRounds() {
		return jailRounds;
	}

	// sets the amount of rounds left of a player's jail-time.
	public void setJailRounds(int jailRounds) {
		this.jailRounds = jailRounds;
	}

	// gets the player's current position.
	public int getCurrentPosition() {
		return currentPosition;
	}

	// sets the player's current position.
	public void setCurrentPosition(int newPosition) {
		currentPosition = newPosition + currentPosition;
		if (currentPosition > 40) {
			currentPosition -= 40;
			if (currentPosition > 0) {
				setFortune(4000); //startBonues
			}
		}
	}
	public void setOwnedFerries(int ferriesOwned)
	{
		ownedFerries = ownedFerries + ferriesOwned;
	}
	
	public int getOwnedFerries(){
		return ownedFerries;
	}
}
