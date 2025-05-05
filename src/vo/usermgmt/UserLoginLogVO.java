package vo.usermgmt;

/***************************Start of Program Header ****************************
## Copyright Information				: C-DAC, Noida  
## Project Name							: Generation 5, HIS
## Name of Developer		 			: Pragya Sharma
## Module Name							: HIS Single Sign On and Web Security 
## Process/Database Object Name			: UserLoginLogVO
## Purpose								: 
## Date of Creation						:  
## Modification Log						:				
##		Modify Date				: 2016.16.05 
##		Reason	(CR/PRS)		: Session Time out Issue  
##		Modify By				: Pragya Sharma
**************************End of program*****************************/

import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.internal.xr.ValueObject;

@XmlRootElement
public class UserLoginLogVO extends ValueObject
{
	// Successful Log
	private String varUserId;
	private String varUserLoginDate;
	private String varUserLoginTime;
	private String varUserLogoutDate;
	private String varUserLogoutTime;
	private String varHospitalCode;
	private String varSeatId;
	private String varIPAddress;
	private String varLoginStatus;
	private String varCounterName;

	// Unsuccessful Log
	private String varUserName;
	private String varEntryDate;
	private String varIsValid;
	
	private String varUnsuccessfulCount;

	public String getVarUserId() {
		return varUserId;
	}

	public void setVarUserId(String varUserId) {
		this.varUserId = varUserId;
	}

	public String getVarUserLoginDate() {
		return varUserLoginDate;
	}

	public void setVarUserLoginDate(String varUserLoginDate) {
		this.varUserLoginDate = varUserLoginDate;
	}

	public String getVarUserLoginTime() {
		return varUserLoginTime;
	}

	public void setVarUserLoginTime(String varUserLoginTime) {
		this.varUserLoginTime = varUserLoginTime;
	}

	public String getVarUserLogoutDate() {
		return varUserLogoutDate;
	}

	public void setVarUserLogoutDate(String varUserLogoutDate) {
		this.varUserLogoutDate = varUserLogoutDate;
	}

	public String getVarUserLogoutTime() {
		return varUserLogoutTime;
	}

	public void setVarUserLogoutTime(String varUserLogoutTime) {
		this.varUserLogoutTime = varUserLogoutTime;
	}

	public String getVarHospitalCode() {
		return varHospitalCode;
	}

	public void setVarHospitalCode(String varHospitalCode) {
		this.varHospitalCode = varHospitalCode;
	}

	public String getVarSeatId() {
		return varSeatId;
	}

	public void setVarSeatId(String varSeatId) {
		this.varSeatId = varSeatId;
	}

	public String getVarIPAddress() {
		return varIPAddress;
	}

	public void setVarIPAddress(String varIPAddress) {
		this.varIPAddress = varIPAddress;
	}

	public String getVarLoginStatus() {
		return varLoginStatus;
	}

	public void setVarLoginStatus(String varLoginStatus) {
		this.varLoginStatus = varLoginStatus;
	}

	public String getVarCounterName() {
		return varCounterName;
	}

	public void setVarCounterName(String varCounterName) {
		this.varCounterName = varCounterName;
	}

	public String getVarUserName() {
		return varUserName;
	}

	public void setVarUserName(String varUserName) {
		this.varUserName = varUserName;
	}

	public String getVarEntryDate() {
		return varEntryDate;
	}

	public void setVarEntryDate(String varEntryDate) {
		this.varEntryDate = varEntryDate;
	}

	public String getVarIsValid() {
		return varIsValid;
	}

	public void setVarIsValid(String varIsValid) {
		this.varIsValid = varIsValid;
	}

	public String getVarUnsuccessfulCount() {
		return varUnsuccessfulCount;
	}

	public void setVarUnsuccessfulCount(String varUnsuccessfulCount) {
		this.varUnsuccessfulCount = varUnsuccessfulCount;
	}
}