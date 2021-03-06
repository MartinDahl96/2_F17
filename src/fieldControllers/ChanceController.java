package fieldControllers;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Stack;

import entities.ChanceCard;
import entities.ChanceDeck;
import entities.Player;
import fieldEntities.Chance;
import fieldEntities.Ferry;
import fieldEntities.Street;
import entities.Board;
import inputHandlers.Text;
import mainControllers.GameController;
import mainControllers.MUI;
import sql.ChanceDAOimp;

public class ChanceController {
	
	//attributes
	private ChanceDeck deck;
	private Text file = new Text("txtfiles/fieldControllerText.txt");
	private String[] textList;
	private ChanceDAOimp cDAO = new ChanceDAOimp();
	
	/**
	 * Constructor for the Chancecontroller
	 * @param c is a Chance-field object.
	 */
	public ChanceController(Chance c){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.deck = new ChanceDeck();
		
	}
	/**
	 * Secondary constructor for the chancecontroller.
	 * This requires no chance-field object
	 */
	public ChanceController(){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.deck = new ChanceDeck();
	
		
	}
	
	
	/**
	 * landOnField-method for a chance-field.
	 * @param player is the player landing on the field.
	 */
	public void landOnChance(Player player){
		
		drawCard(player);
		
	}
	
	/**
	 * used to draw a card.
	 * if the stack is empty it will re-create it.
	 * pops a card from the stack and displays the cardmessage.
	 * the cardID from the popped card is used to determine the action done by the switch.
	 * @param player is the player drawing a card.
	 */
	public void drawCard(Player player){
			
		recreateIfEmpty();
	
		cDAO.updateCards(ChanceDeck.getDeck().peek());
		ChanceCard c = ChanceDeck.getDeck().pop();
		MUI.displayCard(c.getCardText());
		MUI.showMessage(player.getplayerName()+textList[0]);
		
		
		switch(c.getCardID()){
		
		case 1:
			player.setFortune(c.getCardValue()); 
			break;
		case 2:
			player.changePosition(c.getCardValue());
			break;
			
		case 3:
			player.changePosition(c.getCardValue());
			StartController.cancelStartBonus(player);
			break;
		case 4:
			player.changePosition(c.getCardValue());
			StartController.cancelStartBonus(player);
			break;
		case 5:
			player.setFortune(c.getCardValue());
			break;
		case 6:
			player.setFortune(c.getCardValue());
			break;
		case 7:
			player.setFortune(c.getCardValue());
			break;
		case 8:
			player.setFortune(c.getCardValue());
			break;
		case 9:
			player.setFortune(c.getCardValue());
			break;
		case 10:
			for(Player p:GameController.getPlayers()){
				if(p.getImmunity() == false && p != player){
					p.setFortune(-c.getCardValue()); MUI.setFortune(p.getplayerName(), p.getFortune());
					player.setFortune(c.getCardValue());
				}
			}
			break;
		case 11:
			player.setFortune(c.getCardValue());
			break;
		case 12:
			player.setFortune(c.getCardValue());
			break;
		case 13:
			int bill1 = 0; 
			for(fieldEntities.Field field : Board.getFields()){
				if(field instanceof Street && ((Street) field).getOwner() == player){
					if(((Street) field).getNumOfBuildings() > 0 && ((Street) field).getNumOfBuildings() < 5 ){
						player.setFortune(-800);
						bill1 += 800;
					}
					if(((Street) field).getNumOfBuildings() == 5){
						player.setFortune(-2300);
						bill1 += 2300;
					}
				}
			}
			MUI.showMessage(textList[48] + bill1);
			break;
		case 14:
			player.changePosition(25);
			break;
		case 15:
			int ferryField1 = 6;
			int ferryField2 = 16;
			int ferryField3 = 26;
			int ferryField4 = 36;
			
			if(player.getCurrentPosition() < ferryField1 || player.getCurrentPosition() > ferryField4){
				player.changePosition(ferryField1);
			}
			if(player.getCurrentPosition() > ferryField1 && player.getCurrentPosition() < ferryField2){
				player.changePosition(ferryField2);
			}
			if(player.getCurrentPosition() > ferryField2 && player.getCurrentPosition() < ferryField3){
				player.changePosition(ferryField3);
			}
			if(player.getCurrentPosition() > ferryField3 && player.getCurrentPosition() < ferryField4){
				player.changePosition(ferryField4);
			}	
			
			Ferry.setDoubleRent(true);
			break;
			
		case 16:
			int ferryFieldd1 = 6;
			int ferryFieldd2 = 16;
			int ferryFieldd3 = 26;
			int ferryFieldd4 = 36;
			
			if(player.getCurrentPosition() < ferryFieldd1 || player.getCurrentPosition() > ferryFieldd4){
				player.changePosition(ferryFieldd1);
			}
			if(player.getCurrentPosition() > ferryFieldd1 && player.getCurrentPosition() < ferryFieldd2){
				player.changePosition(ferryFieldd2);
			}
			if(player.getCurrentPosition() > ferryFieldd2 && player.getCurrentPosition() < ferryFieldd3){
				player.changePosition(ferryFieldd3);
			}
			if(player.getCurrentPosition() > ferryFieldd3 && player.getCurrentPosition() < ferryFieldd4){
				player.changePosition(ferryFieldd4);
			}	
			
			Ferry.setDoubleRent(true);
			break;
			
		case 17:
			player.changePosition(c.getCardValue());
			break;
		case 18:
			player.setJailToken(1);
			break;
		case 19:
			player.setJailToken(1);
			break;
		case 20:
			player.setFortune(c.getCardValue());
			break;
		case 21:
			player.changePosition(c.getCardValue());
			break;
		case 22:
			player.setFortune(c.getCardValue());
			break;
		case 23:
			player.changePosition(c.getCardValue());
			break;
		case 24:
			int numOfFields = 40;
			player.setCurrentPosition(c.getCardValue()+numOfFields);
			
			break;
		case 25:
			int bill2 = 0; 
			for(fieldEntities.Field field : Board.getFields()){
				if(field instanceof Street && ((Street) field).getOwner() == player){
					if(((Street) field).getNumOfBuildings() > 0 && ((Street) field).getNumOfBuildings() < 5 ){
						player.setFortune(-500);
						bill2 += 500;
					}
					if(((Street) field).getNumOfBuildings() == 5){
						player.setFortune(-2000);
						bill2 += 2000;
					}
				}
			}
			MUI.showMessage(textList[48] + bill2);
			break;
		case 26:
			MUI.displayCard(c.getCardText());
			player.setFortune(c.getCardValue());
			break;
		case 27:
			player.setFortune(c.getCardValue());
			break;
		case 28:
			int maxAssets = 15000;
			if(player.getTotalAssets() <= maxAssets){
				player.setFortune(c.getCardValue());
			}
			break;
		case 29:
			player.setFortune(c.getCardValue());
			break;
		case 30:
			player.setFortune(c.getCardValue());
			break;
		case 31:
			player.setFortune(c.getCardValue());
			break;
		case 32:
			player.setFortune(c.getCardValue());
			break;
		case 33:
			player.setFortune(c.getCardValue());
			break;
			
		
		}
		
		MUI.updateGUIPlayer(player.getplayerName(), player.getFortune(), player.getCurrentPosition());
	}

	/**
	 * used to recreate the stack if the stack is empty. Also removes the two jailTokens from the deck.
	 */
	public void recreateIfEmpty(){
		
		
		
		if(deck.getDeck().isEmpty()){
			deck.createDeck();
			deck.getDeck().remove(17);
			deck.getDeck().remove(17);
			deck.shuffleDeck();
			try {
				cDAO.insertCards();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * used to get the size of the stack.
	 * @return the size of the stack.
	 */
	
	
}
