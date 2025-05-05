package mms.masters.vo;

import javax.sql.rowset.WebRowSet;

public class EmployeeDependentDtlVO {
	
	  private String strMsgString = "";
	  private String strMsgType = "";
	
	  private String strMode;
	
	  
	  private String strEmpNo;
	  private String strSlNo[];
	  private String strHospitalCode;
	 
	  private String strAgeOn;
	  private String strRelTypeId;
	  private String strEffectiveFrm;
	  private String strEffectiveTo;
	  private String strLstModSeatId;
	  private String strLstModDate;
	  private String strEntryDate;
	  private String strSeatId;
	  private String strIsValid; 
	  
	  
	  private String strDependentName[];

	  private String strAge[];

	  private String strRelationshipId[];

	  private String strRelationship;
	  
	  private boolean bExistStatus;
	  
	  private WebRowSet wrsData;

	public String getStrMsgString() {
		return strMsgString;
	}

	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	public String getStrMsgType() {
		return strMsgType;
	}

	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	public String getStrMode() {
		return strMode;
	}

	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

	public String getStrEmpNo() {
		return strEmpNo;
	}

	public void setStrEmpNo(String strEmpNo) {
		this.strEmpNo = strEmpNo;
	}

	public String[] getStrSlNo() {
		return strSlNo;
	}

	public void setStrSlNo(String[] strSlNo) {
		this.strSlNo = strSlNo;
	}

	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	
	

	public String[] getStrDependentName() {
		return strDependentName;
	}

	public void setStrDependentName(String[] strDependentName) {
		this.strDependentName = strDependentName;
	}

	public String[] getStrAge() {
		return strAge;
	}

	public void setStrAge(String[] strAge) {
		this.strAge = strAge;
	}

	public String[] getStrRelationshipId() {
		return strRelationshipId;
	}

	public void setStrRelationshipId(String[] strRelationshipId) {
		this.strRelationshipId = strRelationshipId;
	}

	public String getStrAgeOn() {
		return strAgeOn;
	}

	public void setStrAgeOn(String strAgeOn) {
		this.strAgeOn = strAgeOn;
	}

	public String getStrRelTypeId() {
		return strRelTypeId;
	}

	public void setStrRelTypeId(String strRelTypeId) {
		this.strRelTypeId = strRelTypeId;
	}

	public String getStrEffectiveFrm() {
		return strEffectiveFrm;
	}

	public void setStrEffectiveFrm(String strEffectiveFrm) {
		this.strEffectiveFrm = strEffectiveFrm;
	}

	public String getStrEffectiveTo() {
		return strEffectiveTo;
	}

	public void setStrEffectiveTo(String strEffectiveTo) {
		this.strEffectiveTo = strEffectiveTo;
	}

	public String getStrLstModSeatId() {
		return strLstModSeatId;
	}

	public void setStrLstModSeatId(String strLstModSeatId) {
		this.strLstModSeatId = strLstModSeatId;
	}

	public String getStrLstModDate() {
		return strLstModDate;
	}

	public void setStrLstModDate(String strLstModDate) {
		this.strLstModDate = strLstModDate;
	}

	public String getStrEntryDate() {
		return strEntryDate;
	}

	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public String getStrIsValid() {
		return strIsValid;
	}

	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	public boolean isBExistStatus() {
		return bExistStatus;
	}

	public void setBExistStatus(boolean existStatus) {
		bExistStatus = existStatus;
	}

	public WebRowSet getWrsData() {
		return wrsData;
	}

	public void setWrsData(WebRowSet wrsData) {
		this.wrsData = wrsData;
	}

	public String getStrRelationship() {
		return strRelationship;
	}

	public void setStrRelationship(String strRelationship) {
		this.strRelationship = strRelationship;
	}
	  
}
