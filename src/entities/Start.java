package entities;

public class Start implements Field {
	
	String fieldName;
	
	
	public Start(String fieldName, String fieldInfo, int startBonus) {
		this.fieldName = fieldName;
		
	}


	@Override
	public void setFieldName(String fieldName) {
		
	}

	@Override
	public String getFieldName() {
		return fieldName;
	}

	@Override
	public void setFieldInfo(String fieldInfo) {
		
	}

	@Override
	public String getFieldInfo() {
		return null;
	}
	
	public void landOnField(Player player){
		
		
		
	}
	
	@Override
	public String toString() {
		return fieldName;
	}

}
