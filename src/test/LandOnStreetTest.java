 package test;

//Test

import static org.junit.Assert.*;

import org.junit.Test;

import desktop_resources.GUI;
import entities.Board;
import entities.Player;
import fieldControllers.ParkingController;
import fieldControllers.StreetController;
import fieldEntities.Ownable;
import fieldEntities.Street;
import mainControllers.GUIcontroller;
import mainControllers.GameController;
import mainControllers.MUI;

public class LandOnStreetTest {

	@Test
	public void testBuildable() {
		Player p = new Player(1, "testPlayer");
		Board b = new Board();
		
		((Ownable) Board.getFields().get(2)).setOwner(p);
		((Ownable) Board.getFields().get(4)).setOwner(p);
		
		 StreetController sc = new StreetController();
		 assertEquals(((Ownable) Board.getFields().get(2)).getOwner(), p);
		 assertTrue(sc.checkIfBuildable(p,((Street) Board.getFields().get(2))));
		
		 ((Ownable) Board.getFields().get(7)).setOwner(p);
		 ((Ownable) Board.getFields().get(9)).setOwner(p);
		 ((Ownable) Board.getFields().get(10)).setOwner(p);
			
		 assertEquals(((Ownable) Board.getFields().get(10)).getOwner(), p);
		 assertTrue(sc.checkIfBuildable(p,((Street) Board.getFields().get(2))));
			
		 
		 
	}
	

	
	

}
