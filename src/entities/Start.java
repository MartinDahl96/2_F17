package entities;

public class Start extends Field {

	private String fieldName;
	private String fieldInfo;
	private int startBonus;

	public Start(String fieldName, String fieldInfo, int startBonus) {
		super(fieldName, fieldInfo);
		this.startBonus = startBonus;

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
		return this.fieldInfo;
	}

	public void landOnField(Player player) {
		player.setFortune(this.startBonus);

	}

	@Override
	public String toString() {
		return fieldName;
	}

}
