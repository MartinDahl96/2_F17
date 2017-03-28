package entities;

public class Street extends Ownable{


	
	//Attributes
	private int colourNum;
	private int houseRent_1;
	private int houseRent_2;
	private int houseRent_3;
	private int houseRent_4;
	private int hotelRent;
	private int mortgage;
	
	/*
	 * Konstruktør til at lave et Street, felt.
	 */
	public Street(String name, String info, int price, Player player) {
		super(name, info, price, player);
		// TODO Auto-generated constructor stub
	}
	/*
	 * gets the colour of the street field
	 */
	public int getColourNum() {
		return colourNum;

	/*
	 * sets the colour of the street field
	 */
	}
	public void setColourNum(int colourNum) {
		this.colourNum = colourNum;
	}
	
	
	/*
	 * gets the mortgage of the street field
	 */
	public int getMortgage() {
		return mortgage;
	}
	
	/*
	 * sets the mortgage of the street field
	 */
	public void setMortgage(int mortgage) {
		this.mortgage = mortgage;
	}
	
	/*
	 * (non-Javadoc)
	 * @see entities.Ownable#getRent()
	 */
	public int getRent() {
		return mortgage;
	}
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
