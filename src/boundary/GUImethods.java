package boundary;

import desktop_resources.GUI;
import java.util.ArrayList;

import entities.Board;
import entities.Field;
import entities.Ownable;



public class GUImethods {

	public void createGUIFields(ArrayList<Field> fields) {


		// Start-field
		GUI.setTitleText(fields.get(0).getFieldID(), fields.get(0).getFieldName());
		GUI.setSubText(fields.get(0).getFieldID(), fields.get(0).getFieldInfo());
		GUI.setDescriptionText(1, fields.get(0).getFieldInfo());

		// Street - Rødovrevej
		GUI.setTitleText(fields.get(1).getFieldID(), fields.get(1).getFieldName());
		GUI.setSubText(fields.get(1).getFieldID(), "Pris: " + ((Ownable) fields.get(1)).getPrice());

		// Chancefield
		GUI.setTitleText(fields.get(2).getFieldID(), fields.get(2).getFieldName());
		GUI.setSubText(fields.get(2).getFieldID(), fields.get(2).getFieldInfo());
		GUI.setDescriptionText(fields.get(2).getFieldID(), fields.get(2).getFieldInfo());

		// Street - Hvidovrevej
		GUI.setTitleText(fields.get(3).getFieldID(), fields.get(3).getFieldName());
		GUI.setSubText(fields.get(3).getFieldID(), "Pris: " + ((Ownable) fields.get(3)).getPrice());

		// Tax field
		GUI.setTitleText(fields.get(4).getFieldID(), fields.get(4).getFieldName());
		GUI.setSubText(fields.get(4).getFieldID(), fields.get(4).getFieldInfo());
		GUI.setDescriptionText(fields.get(4).getFieldID(), fields.get(4).getFieldInfo());

		// Ferry field - LB Færgerne
		GUI.setTitleText(fields.get(5).getFieldID(), fields.get(5).getFieldName());
		GUI.setSubText(fields.get(5).getFieldID(), "Pris: " + ((Ownable) fields.get(5)).getPrice());
		GUI.setDescriptionText(fields.get(5).getFieldID(), fields.get(5).getFieldInfo());

		// Street - roskildevej
		GUI.setTitleText(fields.get(6).getFieldID(), fields.get(6).getFieldName());
		GUI.setSubText(fields.get(6).getFieldID(), "Pris: " + ((Ownable) fields.get(6)).getPrice());

		// Chance field
		GUI.setTitleText(fields.get(7).getFieldID(), fields.get(7).getFieldName());
		GUI.setSubText(fields.get(7).getFieldID(), fields.get(7).getFieldInfo());
		GUI.setDescriptionText(fields.get(7).getFieldID(), fields.get(7).getFieldInfo());

		// Street - valbylanggade
		GUI.setTitleText(fields.get(8).getFieldID(), fields.get(8).getFieldName());
		GUI.setSubText(fields.get(8).getFieldID(), "Pris: " + ((Ownable) fields.get(8)).getPrice());

		// Street - Allegade
		GUI.setTitleText(fields.get(9).getFieldID(), fields.get(9).getFieldName());
		GUI.setSubText(fields.get(9).getFieldID(), "Pris: " + ((Ownable) fields.get(9)).getPrice());

		// Jail
		GUI.setSubText(fields.get(10).getFieldID(), fields.get(10).getFieldName());
		GUI.setDescriptionText(fields.get(10).getFieldID(), fields.get(10).getFieldInfo());

		// Street - frederiksberg
		GUI.setTitleText(fields.get(11).getFieldID(), fields.get(11).getFieldName());
		GUI.setSubText(fields.get(11).getFieldID(), "Pris: " + ((Ownable) fields.get(11)).getPrice());

		// Brewery - tuborg
		GUI.setTitleText(fields.get(12).getFieldID(), fields.get(12).getFieldName());
		GUI.setSubText(fields.get(12).getFieldID(), "Pris: " + ((Ownable) fields.get(12)).getPrice());
		GUI.setDescriptionText(fields.get(12).getFieldID(), fields.get(12).getFieldInfo());

		// Street - bulowsvej
		GUI.setTitleText(fields.get(13).getFieldID(), fields.get(13).getFieldName());
		GUI.setSubText(fields.get(13).getFieldID(), "Pris: " + ((Ownable) fields.get(13)).getPrice());

		// Street - gl. kongevej
		GUI.setTitleText(fields.get(14).getFieldID(), fields.get(14).getFieldName());
		GUI.setSubText(fields.get(14).getFieldID(), "Pris: " + ((Ownable) fields.get(14)).getPrice());

		// Ferry - Danmark
		GUI.setTitleText(fields.get(15).getFieldID(), fields.get(15).getFieldName());
		GUI.setSubText(fields.get(15).getFieldID(), "Pris: " + ((Ownable) fields.get(15)).getPrice());
		GUI.setDescriptionText(fields.get(15).getFieldID(), fields.get(15).getFieldInfo());

		// Street - bernstoffsvej
		GUI.setTitleText(fields.get(16).getFieldID(), fields.get(16).getFieldName());
		GUI.setSubText(fields.get(16).getFieldID(), "Pris: " + ((Ownable) fields.get(16)).getPrice());

		// Chance
		GUI.setTitleText(fields.get(17).getFieldID(), fields.get(17).getFieldName());
		GUI.setSubText(fields.get(17).getFieldID(), fields.get(17).getFieldInfo());
		GUI.setDescriptionText(fields.get(17).getFieldID(), fields.get(17).getFieldInfo());

		// Street - Hellerupvej
		GUI.setTitleText(fields.get(18).getFieldID(), fields.get(18).getFieldName());
		GUI.setSubText(fields.get(18).getFieldID(), "Pris: " + ((Ownable) fields.get(18)).getPrice());

		// Street - Strandvejen
		GUI.setTitleText(fields.get(19).getFieldID(), fields.get(19).getFieldName());
		GUI.setSubText(fields.get(19).getFieldID(), "Pris: " + ((Ownable) fields.get(19)).getPrice());

		// Parking
		GUI.setSubText(fields.get(20).getFieldID(), fields.get(20).getFieldName());
		GUI.setDescriptionText(fields.get(20).getFieldID(), fields.get(20).getFieldInfo());

		// Street - trianglen
		GUI.setTitleText(fields.get(21).getFieldID(), fields.get(21).getFieldName());
		GUI.setSubText(fields.get(21).getFieldID(), "Pris: " + ((Ownable) fields.get(21)).getPrice());

		// Chance
		GUI.setTitleText(fields.get(22).getFieldID(), fields.get(22).getFieldName());
		GUI.setSubText(fields.get(22).getFieldID(), fields.get(22).getFieldInfo());
		GUI.setDescriptionText(fields.get(22).getFieldID(), fields.get(22).getFieldInfo());

		// Street - østerbrogade
		GUI.setTitleText(fields.get(23).getFieldID(), fields.get(23).getFieldName());
		GUI.setSubText(fields.get(23).getFieldID(), "Pris: " + ((Ownable) fields.get(23)).getPrice());

		// Street - grønningen
		GUI.setTitleText(fields.get(24).getFieldID(), fields.get(24).getFieldName());
		GUI.setSubText(fields.get(24).getFieldID(), "Pris: " + ((Ownable) fields.get(24)).getPrice());

		// Ferry - Mols-linjen
		GUI.setTitleText(fields.get(25).getFieldID(), fields.get(25).getFieldName());
		GUI.setSubText(fields.get(25).getFieldID(), "Pris: " + ((Ownable) fields.get(25)).getPrice());
		GUI.setDescriptionText(fields.get(25).getFieldID(), fields.get(25).getFieldInfo());

		// Street - bredgade
		GUI.setTitleText(fields.get(26).getFieldID(), fields.get(26).getFieldName());
		GUI.setSubText(fields.get(26).getFieldID(), "Pris: " + ((Ownable) fields.get(26)).getPrice());

		// Street - kgs. nytorv
		GUI.setTitleText(fields.get(27).getFieldID(), fields.get(27).getFieldName());
		GUI.setSubText(fields.get(27).getFieldID(), "Pris: " + ((Ownable) fields.get(27)).getPrice());

		// Brewery - Carlsberg
		GUI.setTitleText(fields.get(28).getFieldID(), fields.get(28).getFieldName());
		GUI.setSubText(fields.get(28).getFieldID(), "Pris: " + ((Ownable) fields.get(28)).getPrice());
		GUI.setDescriptionText(fields.get(28).getFieldID(), fields.get(28).getFieldInfo());

		// Street - østergade
		GUI.setTitleText(fields.get(29).getFieldID(), fields.get(29).getFieldName());
		GUI.setSubText(fields.get(29).getFieldID(), "Pris: " + ((Ownable) fields.get(29)).getPrice());

		// Jail - go to jail
		GUI.setSubText(fields.get(30).getFieldID(), fields.get(30).getFieldName());
		GUI.setDescriptionText(fields.get(30).getFieldID(), fields.get(30).getFieldInfo());

		// Street - amagertorv
		GUI.setTitleText(fields.get(31).getFieldID(), fields.get(31).getFieldName());
		GUI.setSubText(fields.get(31).getFieldID(), "Pris: " + ((Ownable) fields.get(31)).getPrice());

		// Street - Vimmelskaftet
		GUI.setTitleText(fields.get(32).getFieldID(), fields.get(32).getFieldName());
		GUI.setSubText(fields.get(32).getFieldID(), "Pris: " + ((Ownable) fields.get(32)).getPrice());

		// Chance
		GUI.setTitleText(fields.get(33).getFieldID(), fields.get(33).getFieldName());
		GUI.setSubText(fields.get(33).getFieldID(), fields.get(33).getFieldInfo());
		GUI.setDescriptionText(fields.get(33).getFieldID(), fields.get(33).getFieldInfo());

		// Street - nygade
		GUI.setTitleText(fields.get(34).getFieldID(), fields.get(34).getFieldName());
		GUI.setSubText(fields.get(34).getFieldID(), "Pris: " + ((Ownable) fields.get(34)).getPrice());

		// Ferry - Skandinavisk linjetrafik
		GUI.setTitleText(fields.get(35).getFieldID(), fields.get(35).getFieldName());
		GUI.setSubText(fields.get(35).getFieldID(), "Pris: " + ((Ownable) fields.get(35)).getPrice());
		GUI.setDescriptionText(fields.get(35).getFieldID(), fields.get(35).getFieldInfo());

		// Chance
		GUI.setTitleText(fields.get(36).getFieldID(), fields.get(36).getFieldName());
		GUI.setSubText(fields.get(36).getFieldID(), fields.get(36).getFieldInfo());
		GUI.setDescriptionText(fields.get(36).getFieldID(), fields.get(36).getFieldInfo());

		// Street - frederiksberggade
		GUI.setTitleText(fields.get(37).getFieldID(), fields.get(37).getFieldName());
		GUI.setSubText(fields.get(37).getFieldID(), "Pris: " + ((Ownable) fields.get(37)).getPrice());

		// Tax field
		GUI.setTitleText(fields.get(38).getFieldID(), fields.get(38).getFieldName());
		GUI.setSubText(fields.get(38).getFieldID(), fields.get(38).getFieldInfo());
		GUI.setDescriptionText(fields.get(38).getFieldID(), fields.get(38).getFieldInfo());

		// Street - rådhuspladsen
		GUI.setTitleText(fields.get(39).getFieldID(), fields.get(39).getFieldName());
		GUI.setSubText(fields.get(39).getFieldID(), "Pris: " + ((Ownable) fields.get(39)).getPrice());

		

	}
	
	
	public static void main(String[] args){
		
		GUImethods g = new GUImethods();
		Board b = new Board();
		
		g.createGUIFields(b.getFieldsArray());
	}
}
