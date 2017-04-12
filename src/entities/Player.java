package entities;

public class Player {
	// Attributes
	private String playerName;
	private Account account;
	private int ID;
	private int jailRounds;
	private int ownedFerries;
	private int ownedBreweries;
	private int currentPosition;
	public boolean immunity;
	private int fortune;
	private int totalAssets;
	private int jailToken;
	

	// Constructor for a player-object.
	public Player(String name, int ID) {
		this.playerName = name;
		this.ID = ID;
		this.account = new Account(26000);
		this.immunity = false;	
		this.totalAssets = 0;
		this.jailToken = 0;
		fortune = this.account.getBalance();


	}

	// used to get the amount of jailTokens held by a player.
		public int getJailToken() {
			return jailToken;
		}

		//used to set the amount of jailTokens held by a player.
		public void setJailToken() {
			this.jailToken++; 
		}
		
		public int getTotalAssets(){
			return this.totalAssets;
		}
		
		public void setTotalAssets(int add){
			totalAssets += add;
		}
		
		//used to see if a player is immune or not.
		public boolean isImmunity() {
			return immunity;
		}

		//used to set a player's immunity.
		public void setImmunity(boolean immunity) {
			this.immunity = immunity;
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

		public void setFortune(int add) {
			this.fortune += add;
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

		// sets the player's current position. ny adding an int to his current position.
		public void setCurrentPosition(int addToPosition) {
			currentPosition = addToPosition + currentPosition;
			if (currentPosition > 40) {
				currentPosition -= 40; 
				if (currentPosition > 0) {
					setFortune(4000); // startBonus //genovervej skal denne vÃ¦re i playerklassen?
				}
			}
		}
		
		//used to set a player to a specific field.
		public void changePosition (int newPosition){
			this.currentPosition = newPosition;
		}

		//used to set the amount of ferries owned by a player.
		public void setOwnedFerries(int ferriesOwned) {
			ownedFerries = ownedFerries + ferriesOwned;
		}
		
		//used to get the amount of ferries owned by a player.
		public int getOwnedFerries() {
			return ownedFerries;
	}
	public void setOwnedBreweries(int breweriesOwned) {
		ownedBreweries = ownedBreweries + breweriesOwned;
	}

	public int getOwnedBreweries() {
		return ownedBreweries;
	}
}
