package test;

import java.io.IOException;

import desktop_resources.GUI;
import entities.Cup;
import entities.Player;
import fieldEntities.Brewery;
import fieldEntities.Ferry;
import fieldEntities.Ownable;
import fieldEntities.Street;
import inputHandlers.Text;
import mainControllers.MUI;


public class OwnableControllerMockup{
	
	private Text file = new Text("txtfiles/fieldControllerText.txt");
	private String[] textList;
	
	public OwnableControllerMockup(){
	}
	
	
	public void landOnOwnable(Player player, Ownable o) {
		
		if (o.getOwner() != null && o.getOwner() != player) payRent(player,o);
		else if (o.getOwner() == null) buyProperty(player, true,o);
	}

	
	public void payRent(Player player, Ownable o) {
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(o instanceof Brewery) {
			calcBrewRent(player,o);
		}
		else if(!o.isPawned()) {
//		MUI.showMessage(player.getplayerName() + textList[10] + o.getOwner().getplayerName());
		player.setFortune(-o.getRent());
		o.getOwner().setFortune(o.getRent());
		Ferry.setDoubleRent(false);
	}
}

	public void buyProperty(Player buyer, boolean choice, Ownable o) {
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		boolean choice = MUI.getTwoButtons(textList[11], textList[12], textList[13]);
		
		if (buyer.getFortune() < o.getPrice());// MUI.showMessage(textList[14]);
	
		else if (true) {
//			MUI.showMessage(textList[15] + o.getFieldName() + textList[16] + o.getPrice());
			buyer.setFortune(-o.getPrice());
			
			o.setOwner(buyer);
//			MUI.setOwner(o.getFieldID(), buyer.getplayerName());
			setOwnedFields(buyer,o); //ændre
		}
	}
	
	public void setOwnedFields(Player player, Ownable o){
		if(o instanceof Ferry){
			player.setOwnedFerries(player.getOwnedFerries()+1);
		}
		
		if(o instanceof Brewery){
			player.setOwnedBreweries(player.getOwnedBreweries()+1);
		}
	}
	
	public void calcBrewRent(Player p, Ownable o){
		Cup cup = new Cup();
		try {
			textList = file.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		MUI.showMessage(textList[17]);
		cup.useCup();
		//GUI.setDice(cup.getFaceValue1(), cup.getFaceValue2());
//		MUI.showMessage(textList[18]+o.getRent()*cup.getCupValue());
		
		p.setFortune(-o.getRent()*cup.getCupValue());
		o.getOwner().setFortune(o.getRent()*cup.getCupValue());
	}
}
