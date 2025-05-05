package mms.masters.controller.fb;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import hisglobal.masterutil.GenericFormBean;

/**
 * @author Vivek Aggarwal  
 * Creation Date:- 7-June-2011 
 * Modifying Date:- 10-June-2011
 * Used For:- 
 * Team Lead By:-  
 *  Module:- DWH(HIS Project)
 * 
 */
public class EmployeeDetailMstFB  extends GenericFormBean
{

	/**
	 * Serial Version Id
	 */
	private static final long serialVersionUID = 7417371535407520855L;

	
	/*
	 * Messages for errors,warnings and normal messages
	 */
	private String strErrMsg;
	private String 	strWarningMsg;
	private String strNormalMsg;

	  
	  private String strEmpNo;
	  private String strHospitalCode;
	  private String strEmpCode;
	  private String strFirstName;
	  private String strMiddleName;
	  private String strLastName;
	  private String strDesigId;
	  private String strJoiningDate;
	  private String strBirthDate;
	  private String strGenderCode;
	  private String strPermanentAddress;
	  private String strLocalAddress;
	  private String strPhoneNo;
	  private String strMobileNo;
	  private String strFaxNo;
	  private String strServiceDocNo;
	  private String strServiceDocDate;
	  private String strFatherName;
	  private String strMotherName;
	  private String strSpouseName;
	  private String strSalutationId;
	  private String strRemarks;
	  private String strEffectiveFrm;
	  private String strLstModSeatId;
	  private String strLstModDate;
	  private String strEntryDate;
	  private String strSeatId;            
	  private String strIsValid;
	  
	  private String strEmailId; 
	  private String strDistrictId;
	  
	  private String strSalutationValues;
	  private String strDesignationValues;
	  private String strLocalAddressCheckbox;
	  
	  private String strSNo;// For showing the S. No. on the multi-row 
	  private String strDependentName[];

	  private String strAge[];

	  private String strRelationshipId[];

	  private String strRelationship;
	  
	  private String strCurrentDate;
	  
	  private String strEnteredDependentDetailsTable;
	  private String strTotalPreviousDependents;
	  private String strDeleteCheckbox[];
	  private String strSlNo[];
	  
	  private String strDistrictNameCombo;
	  
	public String getStrDistrictNameCombo() {
		return strDistrictNameCombo;
	}
	public void setStrDistrictNameCombo(String strDistrictNameCombo) {
		this.strDistrictNameCombo = strDistrictNameCombo;
	}
	public String getStrTotalPreviousDependents() {
		return strTotalPreviousDependents;
	}
	public void setStrTotalPreviousDependents(String strTotalPreviousDependents) {
		this.strTotalPreviousDependents = strTotalPreviousDependents;
	}
	public String getStrEnteredDependentDetailsTable() {
		return strEnteredDependentDetailsTable;
	}
	public void setStrEnteredDependentDetailsTable(
			String strEnteredDependentDetailsTable) {
		this.strEnteredDependentDetailsTable = strEnteredDependentDetailsTable;
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
	public String getStrRelationship() {
		return strRelationship;
	}
	public void setStrRelationship(String strRelationship) {
		this.strRelationship = strRelationship;
	}
	public String getStrLocalAddressCheckbox() {
		return strLocalAddressCheckbox;
	}
	public void setStrLocalAddressCheckbox(String strLocalAddressCheckbox) {
		this.strLocalAddressCheckbox = strLocalAddressCheckbox;
	}
	public String getStrDesignationValues() {
		return strDesignationValues;
	}
	public void setStrDesignationValues(String strDesignationValues) {
		this.strDesignationValues = strDesignationValues;
	}
	public String getStrSalutationValues() {
		return strSalutationValues;
	}
	public void setStrSalutationValues(String strSalutationValues) {
		this.strSalutationValues = strSalutationValues;
	}
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	public String getStrEmpNo() {
		return strEmpNo;
	}
	public void setStrEmpNo(String strEmpNo) {
		this.strEmpNo = strEmpNo;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrEmpCode() {
		return strEmpCode;
	}
	public void setStrEmpCode(String strEmpCode) {
		this.strEmpCode = strEmpCode;
	}
	public String getStrFirstName() {
		return strFirstName;
	}
	public void setStrFirstName(String strFirstName) {
		this.strFirstName = strFirstName;
	}
	public String getStrMiddleName() {
		return strMiddleName;
	}
	public void setStrMiddleName(String strMiddleName) {
		this.strMiddleName = strMiddleName;
	}
	public String getStrLastName() {
		return strLastName;
	}
	public void setStrLastName(String strLastName) {
		this.strLastName = strLastName;
	}
	public String getStrDesigId() {
		return strDesigId;
	}
	public void setStrDesigId(String strDesigId) {
		this.strDesigId = strDesigId;
	}
	public String getStrJoiningDate() {
		return strJoiningDate;
	}
	public void setStrJoiningDate(String strJoiningDate) {
		this.strJoiningDate = strJoiningDate;
	}
	public String getStrBirthDate() {
		return strBirthDate;
	}
	public void setStrBirthDate(String strBirthDate) {
		this.strBirthDate = strBirthDate;
	}
	public String getStrGenderCode() {
		return strGenderCode;
	}
	public void setStrGenderCode(String strGenderCode) {
		this.strGenderCode = strGenderCode;
	}
	public String getStrPermanentAddress() {
		return strPermanentAddress;
	}
	public void setStrPermanentAddress(String strPermanentAddress) {
		this.strPermanentAddress = strPermanentAddress;
	}
	public String getStrLocalAddress() {
		return strLocalAddress;
	}
	public void setStrLocalAddress(String strLocalAddress) {
		this.strLocalAddress = strLocalAddress;
	}
	public String getStrPhoneNo() {
		return strPhoneNo;
	}
	public void setStrPhoneNo(String strPhoneNo) {
		this.strPhoneNo = strPhoneNo;
	}
	public String getStrMobileNo() {
		return strMobileNo;
	}
	public void setStrMobileNo(String strMobileNo) {
		this.strMobileNo = strMobileNo;
	}
	public String getStrFaxNo() {
		return strFaxNo;
	}
	public void setStrFaxNo(String strFaxNo) {
		this.strFaxNo = strFaxNo;
	}
	public String getStrServiceDocNo() {
		return strServiceDocNo;
	}
	public void setStrServiceDocNo(String strServiceDocNo) {
		this.strServiceDocNo = strServiceDocNo;
	}
	public String getStrServiceDocDate() {
		return strServiceDocDate;
	}
	public void setStrServiceDocDate(String strServiceDocDate) {
		this.strServiceDocDate = strServiceDocDate;
	}
	public String getStrFatherName() {
		return strFatherName;
	}
	public void setStrFatherName(String strFatherName) {
		this.strFatherName = strFatherName;
	}
	public String getStrMotherName() {
		return strMotherName;
	}
	public void setStrMotherName(String strMotherName) {
		this.strMotherName = strMotherName;
	}
	public String getStrSpouseName() {
		return strSpouseName;
	}
	public void setStrSpouseName(String strSpouseName) {
		this.strSpouseName = strSpouseName;
	}
	public String getStrSalutationId() {
		return strSalutationId;
	}
	public void setStrSalutationId(String strSalutationId) {
		this.strSalutationId = strSalutationId;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrEffectiveFrm() {
		return strEffectiveFrm;
	}
	public void setStrEffectiveFrm(String strEffectiveFrm) {
		this.strEffectiveFrm = strEffectiveFrm;
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
	
	
	public void reset(ActionMapping mapping, HttpServletRequest request)  
	  {  
	    super.reset(mapping,request);  
	    
	    setStrEmpCode("");
	    setStrGenderCode("1");
	    setStrSalutationId("0");
	    setStrFirstName("");
	    setStrMiddleName("");
	    
	    setStrLastName("");
	    
	    setStrFatherName("");
	    setStrMotherName("");
	    setStrSpouseName("");
	    setStrBirthDate("");
	    setStrDesigId("0");
	    setStrJoiningDate("");
	    setStrPermanentAddress("");
	    setStrLocalAddress("");
	    setStrPhoneNo("");
	    
	    setStrPhoneNo("");
	    setStrMobileNo("");
	    setStrFaxNo("");
	    setStrServiceDocNo("");
	    setStrServiceDocDate("");
	    setStrRemarks("");  
	  }
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	public String[] getStrDeleteCheckbox() {
		return strDeleteCheckbox;
	}
	public void setStrDeleteCheckbox(String[] strDeleteCheckbox) {
		this.strDeleteCheckbox = strDeleteCheckbox;
	}
	public String[] getStrSlNo() {
		return strSlNo;
	}
	public void setStrSlNo(String[] strSlNo) {
		this.strSlNo = strSlNo;
	}
	public String getStrSNo() {
		return strSNo;
	}
	public void setStrSNo(String strSNo) {
		this.strSNo = strSNo;
	}
	public String getStrEmailId() {
		return strEmailId;
	}
	public void setStrEmailId(String strEmailId) {
		this.strEmailId = strEmailId;
	}
	public String getStrDistrictId() {
		return strDistrictId;
	}
	public void setStrDistrictId(String strDistrictId) {
		this.strDistrictId = strDistrictId;
	}  
}

