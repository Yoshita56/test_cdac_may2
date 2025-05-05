package in.cdac.mhealth.login.vo;

import java.util.ArrayList;

public class PatientsVO {

	private ArrayList<PatientVO> patientsVO;
	private String OTP;
	
	
	public ArrayList<PatientVO> getPatientsVO() {
		return patientsVO;
	}
	public void setPatientsVO(ArrayList<PatientVO> patientsVO) {
		this.patientsVO = patientsVO;
	}
	public String getOTP() {
		return OTP;
	}
	public void setOTP(String oTP) {
		OTP = oTP;
	}
	
	
	
}
