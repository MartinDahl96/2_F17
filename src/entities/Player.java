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

	/**
	 * Constructor for a player-object.
	 * @param playerID is the playerID of the player. Player one will have the ID of 1 etc.
	 * @param playerName is the name of the player.
	 */
	public Player(int playerID, String playerName) {
		this.playerName = playerName;
		this.playerID = playerID;
		this.account = new Account(30000);
		this.immunity = false;	
		this.totalAssets = 0;
		this.jailToken = 0;
		this.prevPosition = 0;
		fortune = this.account.getBalance();
		this.isBankRupt = false;

	}
	/**
	 * Constructor for a player object loaded from the database.
	 * @param playerID is the playerID of the player.
	 * @param playerName is the name of the player.
	 * @param fortune is the amount of money held by a player.
	 * @param jailRounds is the amount of rounds left for a player in jail.
	 * @param jailToken is the amount of tokens held by a player.
	 * @param currentPosition is the player's current position.
	 */
	public Player(int playerID, String playerName, int fortune, int jailRounds, int jailToken, int currentPosition){
		this.playerID = playerID;
		this.playerName = playerName;
		this.fortune = fortune;
		this.jailRounds = jailRounds;
		this.jailToken = jailToken;
		this.currentPosition = currentPosition;
	}

		/**
		 * used to get the amount of jailTokens held by a player.
		 * @return jailToken is the amount of jailTokens 
		 */
		public int getJailToken() {
			return jailToken;
		}

		/**
		 * used to set the amount of jailTokens held by a player, adds the int to the player's amount of jailTokens.
		 * @param add is the amount of tokens to add.
		 */
		public void setJailToken(int add) {
			jailToken += add;
		}
		
		/**
		 * used to get the totalAssets for a player.
		 * @return totalAssets is the totalAssets for a player.
		 */
		public int getTotalAssets(){
			return this.totalAssets;
		}
		
		/**
		 * used to set the totalAsset for a player.
		 * @param total is the value to set the totalAsset as.
		 */
		public void setTotalAssets(int total){
			totalAssets = total;
		}
	
		
		/**
		 * used to see if a player is immune or not.
		 * @return immunity is the player's immunity status.
		 */
		public boolean getImmunity() {
			return immunity;
		}

		/**
		 * used to set a player's immunity.
		 * @param immunity is the player's immunity status.
		 */
		public void setImmunity(boolean immunity) {
			this.immunity = immunity;
		}

		/**
		 * used to get the name of the player.
		 * @return playerName is the name of the player.
		 */
		public String getplayerName() {
			return playerName;
		}

		/**
		 * used to set the name of a player.
		 * @param name is the name of the player.
		 */
		public void setplayerName(String name) {
			playerName = name;
		}

		/**
		 * used to get the player's fortune.
		 * @return fortune is the player's fortune.
		 */
		public int getFortune() {
			return this.fortune;
		}
		
		/**
		 * used to add to the player's fortune.
		 * @param add is the amount to add to the fortune.
		 */
		public void setFortune(int add) {
			this.fortune += add;
			this.totalAssets = fortune;
		}

		/**
		 * used to get the player's ID.
		 * @return playerID is the player's ID.
		 */
		public int getPlayerID() {
			return this.playerID;
		}

		/**
		 * used to set the player's ID.
		 * @param ID is the ID granted to the player.
		 */
		public void setPlayerID(int ID) {
			this.playerID = ID;
		}

		/**
		 * used to get the amount of rounds in jail a player has left.
		 * @return jailRounds is the amount of rounds in jail a player has left.
		 */
		public int getJailRounds() {
			return jailRounds;
		}

		/**
		 * used to set the amount of rounds a player has left in jail.
		 * @param jailRounds is the amount of rounds to add.
		 */
		public void setJailRounds(int jailRounds) {
			this.jailRounds = jailRounds;
		}
		
		/**
		 * used to get the previous position of a player.
		 * @return prevPosition is the player's previous position.
		 */
		public int getPrevPosition(){
			return prevPosition;
		}

		/**
		 * used to get the player's current position.
		 * @return currentPosition is the player's current position.
		 */
		public int getCurrentPosition() {
			return currentPosition;
		}

		/**
		 * used to set the current position of the player.
		 * also sets prevPosition to the player's current position.
		 * updates the player's position with the amount defined in addToPosition.
		 * if the player's position exceeds 40 (the amount of fields on the board) it will subtract 40 from his position in order to make him go around the board in a circular motion.
		 * @param addToPosition is the amount to add to the player's position.
		 */
		public void setCurrentPosition(int addToPosition) {
			prevPosition = currentPosition;
			currentPosition = addToPosition + currentPosition;
			if (currentPosition > 40) {
				currentPosition -= 40; 
				
			}
		}
		
		/**
		 * used to change a player's position. 
		 * @param newPosition is the player's new position.
		 */
		public void changePosition (int newPosition) {
			prevPosition = currentPosition;
			this.currentPosition = newPosition;
		}

		/**
		 * used to set the amount of ferries owned by a player.
		 * @param ferriesOwned is the amount to add to the amount ferries owned by a player.
		 */
		public void setOwnedFerries(int ferriesOwned) {
			ownedFerries += ferriesOwned;
		}
		
		/**
		 * used to get the amount of ferries owned by a player.
		 * @return ownedFerries is the amount of ferries owned by a player.
		 */
		public int getOwnedFerries() {
			return ownedFerries;
		}
		
		/**
		 * used to set the amount of breweries owned by a player.
		 * @param breweriesOwned is the amount to add to the amount of breweries owned by a player.
		 */
		public void setOwnedBreweries(int breweriesOwned) {
			ownedBreweries += breweriesOwned;
		}
		
		/**
		 * used to get the amount of breweries owned by a player.
		 * @return ownedBreweries is the amount of breweries owned.
		 */
		public int getOwnedBreweries() {
			return ownedBreweries;
		}
	
		/**
		 * used to see whether or not a player is bankrupt, which is determined by whether or not his/her totalAssets is at/or below 0.
		 * @return isBankRupt is the player's bankrupcy status.
		 */
		public boolean isBankRupt() {
			if (totalAssets <= 0)
				return true;
			else
				return false;
			
			}
		/**
		 * used to return the player's name and the player's ID as a string.
		 * @return is the player's name and the player's ID.
		 */
		public String toString(){
			return playerName + playerID;
		}
}
