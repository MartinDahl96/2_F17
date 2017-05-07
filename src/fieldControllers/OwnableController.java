package fieldControllers;

import java.io.IOException;


import desktop_resources.GUI;
import entities.Cup;
import entities.Player;
import fieldEntities.Brewery;
import fieldEntities.Ferry;
import fieldEntities.Ownable;
import inputHandlers.Text;
import mainControllers.MUI;


public class OwnableController{
	
	//attributes
	Ownable o;
	private Text file = new Text("txtfiles/fieldControllerText.txt");
	private String[] textList;
	
	/**
	 * Constructor for the OwnableController.
	 * @param o is a Ownable-field object.
	 */
	public OwnableController(Ownable o){
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.o = o;	
	}
	
	/**
	 * landOnField for a ownable-field.
	 * @param player is the player landing on the field.
	 */
	public void landOnOwnable(Player player) {
		
		if (o.getOwner() != null && o.getOwner() != player) payRent(player);
		else if (o.getOwner() == null) buyProperty(player);
	}

	/**
	 * used to pay the rent for landing on a field.
	 * @param player is the player landing on the field.
	 */
	public void payRent(Player player) {
		if(o instanceof Brewery) {
			calcBrewRent(player);
		}
		else if(!o.isPawned()) {
		MUI.showMessage(player.getplayerName() + textList[10] + o.getOwner().getplayerName());
		player.setFortune(-o.getRent());
		o.getOwner().setFortune(o.getRent());
		Ferry.setDoubleRent(false);
	}
}
	/**
	 * used to buy the property of a field.
	 * @param buyer is the player buying the property.
	 */
	public void buyProperty(Player buyer) {
		boolean choice = MUI.getTwoButtons(textList[11], textList[12], textList[13]);
		if (buyer.getFortune() < o.getPrice()) MUI.showMessage(textList[14]);
		else if (choice) {
			MUI.showMessage(textList[15] + o.getFieldName() + textList[16] + o.getPrice());
			buyer.setFortune(-o.getPrice());
			
			o.setOwner(buyer);
			MUI.setOwner(o.getFieldID(), buyer.getplayerName());
			setOwnedFields(buyer); 
		}
	}
	
	/**
	 * used to set the owner on a field.
	 * if the field is a Ferry-field or a Brewery the amount of Ferries/Breweries owned by a player is increased by 1.
	 * @param player is the owner.
	 */
	public void setOwnedFields(Player player){
		if(o instanceof Ferry) player.setOwnedFerries(1);
		if(o instanceof Brewery) player.setOwnedBreweries(1);
	}
	
	/**
	 * used to calculate the rent of a brewery.
	 * @param p is the player used to calculate the rent for his/her owned breweries.
	 */
	public void calcBrewRent(Player p){
		Cup cup = new Cup();
		MUI.showMessage(textList[17]);
		cup.useCup();
		GUI.setDice(cup.getFaceValue1(), cup.getFaceValue2());
		MUI.showMessage(textList[18]+o.getRent()*cup.getCupValue());
		
		p.setFortune(-o.getRent()*cup.getCupValue());
		o.getOwner().setFortune(o.getRent()*cup.getCupValue());
	}
	
	
}
