package entities;

public class Ferry extends Ownable{

	//Attributes
	private int rent_1 = 500;
	private int rent_2 = 1000;
	private int rent_3 = 2000;
	private int rent_4 = 4000;
	private int owenedFerries;
	
	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return super.getValue();
	}

	@Override
	public void setValue(int value) {
		// TODO Auto-generated method stub
		super.setValue(value);
	}

	@Override
	public int getRent() {
		// TODO Auto-generated method stub
		return super.getRent();
	}

	@Override
	public void setRent(int rent) {
		// TODO Auto-generated method stub
		super.setRent(rent);
	}

	@Override
	public Player getOwner() {
		// TODO Auto-generated method stub
		return super.getOwner();
	}

	@Override
	public void setOwner(Player owner) {
		// TODO Auto-generated method stub
		super.setOwner(owner);
	}

	@Override
	public void setFieldName(String text) {
		// TODO Auto-generated method stub
		super.setFieldName(text);
	}

	@Override
	public String getFieldName() {
		// TODO Auto-generated method stub
		return super.getFieldName();
	}

	@Override
	public void setFieldInfo(String text) {
		// TODO Auto-generated method stub
		super.setFieldInfo(text);
	}

	@Override
	public String getFieldInfo() {
		// TODO Auto-generated method stub
		return super.getFieldInfo();
	}

}
