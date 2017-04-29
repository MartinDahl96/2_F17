package mainControllers;

//GUIboard in this class

import desktop_resources.GUI;

import java.awt.Color;
import java.util.ArrayList;

import entities.Board;
import fieldEntities.Field;
import fieldEntities.Ownable;

public class GUIcontroller {

	public void createGUIFields(ArrayList<Field> fields) {

		desktop_fields.Field[] GUIfields = new desktop_fields.Field[40];

		GUIfields[0] = new desktop_fields.Start.Builder()
				.setTitle(fields.get(1).getFieldName())
				.setSubText(fields.get(1).getFieldInfo()).setDescription(fields.get(1).getFieldInfo())
				.setBgColor(Color.RED).build();

		GUIfields[1] = new desktop_fields.Street.Builder().setTitle(fields.get(2).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(2)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(2)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(2)).getRent()).setBgColor(Color.CYAN).build();

		GUIfields[2] = new desktop_fields.Chance.Builder().build();

		GUIfields[3] = new desktop_fields.Street.Builder().setTitle(fields.get(4).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(4)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(4)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(4)).getRent()).setBgColor(Color.CYAN).build();

		GUIfields[4] = new desktop_fields.Tax.Builder().setTitle(fields.get(5).getFieldInfo())
				.setSubText(fields.get(5).getFieldInfo()).setDescription(fields.get(5).getFieldName())
				.setBgColor(Color.LIGHT_GRAY).build();

		GUIfields[5] = new desktop_fields.Shipping.Builder().setTitle(fields.get(6).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(6)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(6)).getFieldInfo())
				.setPicture("pictures/Ferry.png").build();
				

		GUIfields[6] = new desktop_fields.Street.Builder().setTitle(fields.get(7).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(7)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(7)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(7)).getRent()).setBgColor(Color.pink).build();

		GUIfields[7] = new desktop_fields.Chance.Builder().build();

		GUIfields[8] = new desktop_fields.Street.Builder().setTitle(fields.get(9).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(9)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(9)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(9)).getRent()).setBgColor(Color.pink).build();

		GUIfields[9] = new desktop_fields.Street.Builder().setTitle(fields.get(10).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(10)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(10)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(10)).getRent()).setBgColor(Color.pink).build();

		GUIfields[10] = new desktop_fields.Jail.Builder().setSubText(fields.get(11).getFieldName())
				.setDescription(fields.get(11).getFieldInfo()).build();

		GUIfields[11] = new desktop_fields.Street.Builder().setTitle(fields.get(12).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(12)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(12)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(12)).getRent()).setBgColor(Color.GREEN).build();

		GUIfields[12] = new desktop_fields.Brewery.Builder().setTitle(fields.get(13).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(13)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(13)).getFieldInfo()).setPicture("pictures/Carlsberg2.png")
				.build();

		GUIfields[13] = new desktop_fields.Street.Builder().setTitle(fields.get(14).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(14)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(14)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(14)).getRent()).setBgColor(Color.GREEN).build();

		GUIfields[14] = new desktop_fields.Street.Builder().setTitle(fields.get(15).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(15)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(15)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(15)).getRent()).setBgColor(Color.GREEN).build();

		GUIfields[15] = new desktop_fields.Shipping.Builder().setTitle(fields.get(16).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(16)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(16)).getFieldInfo()).setPicture("pictures/Ferry.png")
				.build();

		GUIfields[16] = new desktop_fields.Street.Builder().setTitle(fields.get(17).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(17)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(17)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(17)).getRent()).setBgColor(Color.GRAY).build();

		GUIfields[17] = new desktop_fields.Chance.Builder().build();

		GUIfields[18] = new desktop_fields.Street.Builder().setTitle(fields.get(19).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(19)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(19)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(19)).getRent()).setBgColor(Color.GRAY).build();

		GUIfields[19] = new desktop_fields.Street.Builder().setTitle(fields.get(20).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(20)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(20)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(20)).getRent()).setBgColor(Color.GRAY).build();

		GUIfields[20] = new desktop_fields.Refuge.Builder().setTitle(fields.get(21).getFieldName())
				.setSubText(fields.get(21).getFieldName()).setDescription(fields.get(21).getFieldInfo())
				.setPicture("pictures/Parking.png").build();

		GUIfields[21] = new desktop_fields.Street.Builder().setTitle(fields.get(22).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(22)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(22)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(22)).getRent()).setBgColor(Color.RED).build();

		GUIfields[22] = new desktop_fields.Chance.Builder().build();

		GUIfields[23] = new desktop_fields.Street.Builder().setTitle(fields.get(24).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(24)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(24)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(24)).getRent()).setBgColor(Color.RED).build();

		GUIfields[24] = new desktop_fields.Street.Builder().setTitle(fields.get(25).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(25)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(25)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(25)).getRent()).setBgColor(Color.RED).build();

		GUIfields[25] = new desktop_fields.Shipping.Builder().setTitle(fields.get(26).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(26)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(26)).getFieldInfo()).setPicture("pictures/Ferry.png")
				.build();

		GUIfields[26] = new desktop_fields.Street.Builder().setTitle(fields.get(27).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(27)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(27)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(27)).getRent()).setBgColor(Color.WHITE).build();

		GUIfields[27] = new desktop_fields.Street.Builder().setTitle(fields.get(28).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(28)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(28)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(28)).getRent()).setBgColor(Color.WHITE).build();

		GUIfields[28] = new desktop_fields.Brewery.Builder().setTitle(fields.get(29).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(29)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(29)).getFieldInfo()).setPicture("pictures/Coca-cola.jpg")
				.build();

		GUIfields[29] = new desktop_fields.Street.Builder().setTitle(fields.get(30).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(30)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(30)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(30)).getRent()).setBgColor(Color.WHITE).build();

		GUIfields[30] = new desktop_fields.Jail.Builder().setSubText(fields.get(31).getFieldName())
				.setDescription(fields.get(31).getFieldInfo()).setPicture("pictures/goToJail.png").build();

		GUIfields[31] = new desktop_fields.Street.Builder().setTitle(fields.get(32).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(32)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(32)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(32)).getRent()).setBgColor(Color.YELLOW).build();

		GUIfields[32] = new desktop_fields.Street.Builder().setTitle(fields.get(33).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(33)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(33)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(33)).getRent()).setBgColor(Color.YELLOW).build();

		GUIfields[33] = new desktop_fields.Chance.Builder().build();

		GUIfields[34] = new desktop_fields.Street.Builder().setTitle(fields.get(35).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(35)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(35)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(35)).getRent()).setBgColor(Color.YELLOW).build();

		GUIfields[35] = new desktop_fields.Shipping.Builder().setTitle(fields.get(36).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(36)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(36)).getFieldInfo()).setPicture("pictures/Ferry.png")
				.build();

		GUIfields[36] = new desktop_fields.Chance.Builder().build();

		GUIfields[37] = new desktop_fields.Street.Builder().setTitle(fields.get(38).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(38)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(38)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(38)).getRent()).setBgColor(Color.MAGENTA).build();

		GUIfields[38] = new desktop_fields.Tax.Builder().setTitle(fields.get(39).getFieldInfo())
				.setSubText(fields.get(39).getFieldInfo()).setDescription(fields.get(39).getFieldName())
				.setBgColor(Color.LIGHT_GRAY).build();
	

		GUIfields[39] = new desktop_fields.Street.Builder().setTitle(fields.get(40).getFieldName())
				.setSubText("Pris: " + ((Ownable) fields.get(40)).getPrice())
				.setDescription("\n" + ((Ownable) fields.get(40)).getFieldInfo())
				.setRent("Leje: " + ((Ownable) fields.get(40)).getRent()).setBgColor(Color.MAGENTA).build();

		GUI.create(GUIfields);
		
		
	}
	
	public static void main(String[] args){
		GUIcontroller g = new GUIcontroller();
		Board b = new Board();
		g.createGUIFields(Board.getFields());
	}

	
}
