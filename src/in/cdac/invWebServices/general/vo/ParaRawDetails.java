package in.cdac.invWebServices.general.vo;

public class ParaRawDetails {
	
	
	private String entryDate;
	private String testName;
	private String value;
	private String standardRange;
	
	public ParaRawDetails(String entryDate,String testName, String value, String standardRange) {
		super();
		
		this.entryDate = entryDate;
		this.testName = testName;
		this.value = value;
		this.standardRange = standardRange;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStandardRange() {
		return standardRange;
	}

	public void setStandardRange(String standardRange) {
		this.standardRange = standardRange;
	}
	

	
	  
	
	
}
