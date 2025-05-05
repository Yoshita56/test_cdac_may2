package in.cdac.mhealth.login.vo;

public class PatientVO {

	private String crNo;
	private String mobileNo;
	private String patientName;
	private String patientHasWallet;
	
	
	
	public String getCrNo() {
		return crNo;
	}
	public void setCrNo(String crNo) {
		this.crNo = crNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientHasWallet() {
		return patientHasWallet;
	}
	public void setPatientHasWallet(String patientHasWallet) {
		this.patientHasWallet = patientHasWallet;
	}
	
	
}
