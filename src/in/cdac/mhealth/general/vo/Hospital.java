package in.cdac.mhealth.general.vo;

public class Hospital {
	
	private String hospitalCode;
	private String hospitalName;
	
	public Hospital(String hospitalCode, String hospitalName) {
		super();
		this.hospitalCode = hospitalCode;
		this.hospitalName = hospitalName;
	}

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
}
