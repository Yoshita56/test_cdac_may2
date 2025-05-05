package in.cdac.invWebServices.general.vo;

public class ParamDetails {

	private String parameterCode;
	private String parameterName;
	private String value;
	private String standardRange;
	
	
	
	public ParamDetails(String parameterName, String value, String standardRange, String parameterCode) {
		super();
		this.parameterCode = parameterCode;
		this.parameterName = parameterName;
		this.value = value;
		this.standardRange = standardRange;
	}
	
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
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

	public String getParameterCode() {
		return parameterCode;
	}

	public void setParameterCode(String parameterCode) {
		this.parameterCode = parameterCode;
	}
	
	
}
