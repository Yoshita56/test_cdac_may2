package in.cdac.invWebServices.login.vo;

import java.util.Set;

public class LoginVO {

	private String userName;
	private String passWord;
	private String salt;
	private String valid;
	private String userDisplayName;
	private String hospitalCode;
	private String seatId;
	

	private Set<String> accessiblePackage;
	private Set<String> mandatoryUpdatePackage;
	private Set<String> updatePackage;
	
	public LoginVO() {
	}

	public LoginVO(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	public String getUserDisplayName() {
		return userDisplayName;
	}
	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}
	public Set<String> getAccessiblePackage() {
		return accessiblePackage;
	}
	public void setAccessiblePackage(Set<String> accessiblePackage) {
		this.accessiblePackage = accessiblePackage;
	}
	public Set<String> getMandatoryUpdatePackage() {
		return mandatoryUpdatePackage;
	}
	public void setMandatoryUpdatePackage(Set<String> mandatoryUpdatePackage) {
		this.mandatoryUpdatePackage = mandatoryUpdatePackage;
	}
	public Set<String> getUpdatePackage() {
		return updatePackage;
	}
	public void setUpdatePackage(Set<String> updatePackage) {
		this.updatePackage = updatePackage;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	
	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
}
