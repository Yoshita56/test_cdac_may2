package mms.masters.vo;

import javax.sql.rowset.WebRowSet;


/**
 * @author Vivek Aggarwal  
 * Creation Date:- 1-June-2011 
 * Modifying Date:- 3-June-2011
 * Used For:- 
 * Team Lead By:-  
 *  Module:- DWH(HIS Project)
 * 
 */
public class StateMstVO
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3230668883167917587L;

	  private String strMsgString = "";
	  private String strMsgType = "";
	
	  private String strMode;
	  
	  private String strStateCode;    
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

	public String getStrStateCode() {
		return strStateCode;
	}

	public void setStrStateCode(String strStateCode) {
		this.strStateCode = strStateCode;
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

	public WebRowSet getWrsData() {
		return wrsData;
	}

	public void setWrsData(WebRowSet wrsData) {
		this.wrsData = wrsData;
	}

	public boolean isBExistStatus() {
		return bExistStatus;
	}

	public void setBExistStatus(boolean existStatus) {
		bExistStatus = existStatus;
	}

	public String getStrCountryName() {
		return strCountryName;
	}

	public void setStrCountryName(String strCountryName) {
		this.strCountryName = strCountryName;
	}

}
