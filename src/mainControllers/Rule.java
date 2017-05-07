package mainControllers;

import entities.Player;
import entities.Board;
import fieldEntities.Field;
import fieldEntities.Ownable;
import fieldEntities.Street;

public class Rule {

	/**
	 * Calculates and sets the player's total assets; fortune + value of
	 * properties and buildings.
	 * 
	 * @param player
	 *            is the player to be calculated.
	 */
	public static void calcTotalAssets(Player player) {
		int total = 0;

		for (Field field : Board.getFields()) {
			if (field instanceof Ownable && ((Ownable) field).getOwner() == player) {
				total += (((Ownable) field).getPrice()) / 2;
				if (field instanceof Street && ((Street) field).getNumOfBuildings() > 0) {
					total += ((((Street) field).getBuildPrice()) / 2) * ((Street) field).getNumOfBuildings();
				}
			}
		}

		player.setTotalAssets(total + player.getFortune());
	}

	/**
	 * used used to remove an owner from a field in the GUI.
	 * 
	 * @param p
	 *            is the owner to be removed.
	 */
	public static void removeOwner(Player p) {

		if (p.isBankRupt()) {
			for (Field f : Board.getFields()) {
				if (f instanceof Ownable && ((Ownable) f).getOwner() == p) {
					((Ownable) f).setOwner(null);
					MUI.removeOwner(f.getFieldID());

				}

			}
		}

	}

	/**
	 * used to assign an owner to a field in the GUI.
	 * 
	 * @param p
	 *            is the owner to be assigned.
	 */
	public static void assignOwner(Player p) {
		for (Field f : Board.getFields()) {
			if (f instanceof Ownable && ((Ownable) f).getOwner() == p) {
				MUI.setOwner(f.getFieldID(), p.getplayerName());

			}
		}
	}

	/**
	 * used to place houses on a field in the GUI.
	 * 
	 * @param p
	 *            is the player that owns the fields where the houses shall be
	 *            placed.
	 */
	public static void placeHouses(Player p) {

		for (Field f : Board.getFields()) {
			if (f instanceof Street && ((Street) f).getOwner() == p) {
				if (((Street) f).getNumOfBuildings() < 5) {
					MUI.SetHouses(f.getFieldID(), ((Street) f).getNumOfBuildings());
				} else if (((Street) f).getNumOfBuildings() == 5) {
					MUI.setHotel(f.getFieldID(), true);
				}
			}
		}
	}
}
