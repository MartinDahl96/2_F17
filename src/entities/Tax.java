package entities;

public class Tax extends Field {
	
	private int revenueTax;
	private int fixedTax;
	
	public Tax(String fieldName, String fieldInfo, int fixedTax, int revenueTax){
		super(fieldName, fieldInfo);
		this.fixedTax = fixedTax;
		this.revenueTax = revenueTax;
	}
	
	public void setrevenueTax(int tax){
		this.revenueTax = tax;
	}
	
	public int getrevenueTax(){
		return revenueTax;
	}

	public void setfixedTax(int tax){
		this.fixedTax = tax;
	}
	
	public int getfixedTax(){
		return fixedTax;
	}
	

	@Override
	public void landOnField(Player player) {
		
		
		
	}
}
