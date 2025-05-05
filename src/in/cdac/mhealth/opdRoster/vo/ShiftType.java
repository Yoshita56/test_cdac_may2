package in.cdac.mhealth.opdRoster.vo;

public class ShiftType {

	private int shiftCode;
	private String shiftName;
	
	public ShiftType(int shiftCode, String shiftName) {
		super();
		this.shiftCode = shiftCode;
		this.shiftName = shiftName;
	}
	
	public int getShiftCode() {
		return shiftCode;
	}
	public void setShiftCode(int shiftCode) {
		this.shiftCode = shiftCode;
	}
	public String getShiftName() {
		return shiftName;
	}
	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}
}
