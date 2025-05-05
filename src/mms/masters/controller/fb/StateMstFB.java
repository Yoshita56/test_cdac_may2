package mms.masters.controller.fb;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import hisglobal.masterutil.GenericFormBean;

/**
 * @author Vivek Aggarwal  
 * Creation Date:- 1-June-2011 
 * Modifying Date:- 3-June-2011
 * Used For:- 
 * Team Lead By:-  
 *  Module:- DWH(HIS Project)
 * 
 */
public class StateMstFB  extends GenericFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8167076865491281349L;
	
	/*
	 * Messages for errors,warnings and normal messages
	 */
	private String strErrMsg;
	private String 	strWarningMsg;
	private String strNormalMsg;

	  private String strStatecode;    
	  private String strCountryCode;
	  private String strStateName; 
	  private String strStateShortName;
	  private String strSeatId; 
	  private String strEntrydate; 
	  private String strIsValid;  
	  private String strHl7Code;  
	  private String strLstModDate; 
	  private String strLstModSeatId; 
	  private String strRemarks;     
	  private String strHospitalCode;
	  private String strCountryName;
	  
	public String getStrCountryName() {
		return strCountryName;
	}
	public void setStrCountryName(String strCountryName) {
		this.strCountryName = strCountryName;
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
	public String getStrStatecode() {
		return strStatecode;
	}
	public void setStrStatecode(String strStatecode) {
		this.strStatecode = strStatecode;
	}
	public String getStrCountryCode() {
		return strCountryCode;
	}
	public void setStrCountryCode(String strCountryCode) {
		this.strCountryCode = strCountryCode;
	}
	public String getStrStateName() {
		return strStateName;
	}
	public void setStrStateName(String strStateName) {
		this.strStateName = strStateName;
	}
	public String getStrStateShortName() {
		return strStateShortName;
	}
	public void setStrStateShortName(String strStateShortName) {
		this.strStateShortName = strStateShortName;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrEntrydate() {
		return strEntrydate;
	}
	public void setStrEntrydate(String strEntrydate) {
		this.strEntrydate = strEntrydate;
	}
	public String getStrIsValid() {
		return strIsValid;
	}
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	public String getStrHl7Code() {
		return strHl7Code;
	}
	public void setStrHl7Code(String strHl7Code) {
		this.strHl7Code = strHl7Code;
	}
	public String getStrLstModDate() {
		return strLstModDate;
	}
	public void setStrLstModDate(String strLstModDate) {
		this.strLstModDate = strLstModDate;
	}
	public String getStrLstModSeatId() {
		return strLstModSeatId;
	}
	public void setStrLstModSeatId(String strLstModSeatId) {
		this.strLstModSeatId = strLstModSeatId;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request)  
	  {  
	    super.reset(mapping,request);  
	    setStrStateName("");  
	    setStrStateShortName("");
	    setStrIsValid("1");
	  }  
	
}
