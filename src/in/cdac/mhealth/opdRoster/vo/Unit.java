package in.cdac.mhealth.opdRoster.vo;

public class Unit {

	private int unitCode;
	private String unitName;
	
	public Unit(int unitCode, String unitName) {
		super();
		this.unitCode = unitCode;
		this.unitName = unitName;
	}
	
	public int getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(int unitCode) {
		this.unitCode = unitCode;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	@Override
	public String toString(){
		return this.unitName;
	}
}
