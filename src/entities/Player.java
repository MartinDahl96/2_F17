package entities;

public class Player {
	// Attributes
	private String playerName;
	private Account account;
	private int playerID;
	private int jailRounds;
	private int ownedFerries;
	private int ownedBreweries;
	private int currentPosition;
	public boolean immunity;
	private int fortune;
	private int totalAssets;
	private int jailToken;
	private int prevPosition;
	private boolean isBankRupt;

	// Constructor for a player-object.
	public Player(int playerID , String playerName) {
		this.playerName = playerName;
		this.playerID = playerID;
		this.account = new Account(30000);
		this.immunity = false;	
		this.totalAssets = this.account.getBalance();
		this.jailToken = 0;
		this.prevPosition = 0;
		fortune = this.account.getBalance();


	}
	//Constructor for a player object loaded from the database.
	public Player(int playerID, String playerName, int fortune, boolean immunity, int totalAssets, int ownedFerries, int ownedBreweries, int jailRounds, int jailToken, int currentPosition){
		this.playerID = playerID;
		this.playerName = playerName;
		this.fortune = fortune;
		this.immunity = immunity;
		this.totalAssets = totalAssets;
		this.ownedFerries = ownedFerries;
		this.ownedBreweries = ownedBreweries;
		this.jailRounds = jailRounds;
		this.jailToken = jailToken;
		this.currentPosition = currentPosition;
	}

	// used to get the amount of jailTokens held by a player.
		public int getJailToken() {
			return jailToken;
		}

		//used to set the amount of jailTokens held by a player.
		public void setJailToken(int add) {
			jailToken += add;
		}
		
		public int getTotalAssets(){
			return this.totalAssets;
		}
		
		public void setTotalAssets(int add){
			totalAssets += add;
		}
	
		
		//used to see if a player is immune or not.
		public boolean getImmunity() {
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
			this.totalAssets = fortune;
		}

		// gets the player's ID.
		public int getPlayerID() {
			return this.playerID;
		}

		// sets the player's ID.
		public void setPlayerID(int ID) {
			this.playerID = ID;
		}

		// gets the amount of rounds left of a player's jail-time.
		public int getJailRounds() {
			return jailRounds;
		}

		// sets the amount of rounds left of a player's jail-time.
		public void setJailRounds(int jailRounds) {
			this.jailRounds = jailRounds;
		}
		
		public int getPrevPosition(){
			return prevPosition;
		}

		// gets the player's current position.
		public int getCurrentPosition() {
			return currentPosition;
		}

		// sets the player's current position. ny adding an int to his current position.
		public void setCurrentPosition(int addToPosition) {
			prevPosition = currentPosition;
			currentPosition = addToPosition + currentPosition;
			if (currentPosition > 40) {
				currentPosition -= 40; 
				
			}
		}
		
		//used to set a player to a specific field.
		public void changePosition (int newPosition) {
			prevPosition = currentPosition;
			this.currentPosition = newPosition;
		}

		//used to set the amount of ferries owned by a player.
		public void setOwnedFerries(int ferriesOwned) {
			ownedFerries = ferriesOwned;
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
	
		public boolean isBankRupt() {
			if (totalAssets <= 0)
				return true;
			else
				return false;
			
			}
		
	
		public String toString(){
			return playerName;
	}
}
