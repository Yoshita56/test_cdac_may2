package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;
/**
 * @author baisakhi
 * 
 */
public class GatePassDetailsTransVO {
private static final long serialVersionUID = 02L;
	
	private String strMsgString = "";
	private String strMsgType = "";
	
   // private String strCtDate = "";
	
	private String strHospitalCode = "";
	
	
	private String strStoreId="";

	private String strValidity="";
	private String strValidityUnit="";
	
	private String strSeatId="";
	private String strIssueBy="";
	private String strIssuedTo="";
	private String strRemarks="";
	private String strFinancialStartyear="";
	private String strFinancialEndYear=""; 
	private String strGatepassTypeCode="";
	
	
	
	private WebRowSet storeNameComboWS =null;
	private WebRowSet gatePassTypeComboWS =null;
	private WebRowSet issueByComboWS =null;
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
	
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	
	public String getStrValidity() {
		return strValidity;
	}
	public void setStrValidity(String strValidity) {
		this.strValidity = strValidity;
	}
	
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrIssuedTo() {
		return strIssuedTo;
	}
	public void setStrIssuedTo(String strIssuedTo) {
		this.strIssuedTo = strIssuedTo;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	
	
	
	/**
	 * @return the strFinancialStartyear
	 */
	public String getStrFinancialStartyear() {
		return strFinancialStartyear;
	}
	/**
	 * @param strFinancialStartyear the strFinancialStartyear to set
	 */
	public void setStrFinancialStartyear(String strFinancialStartyear) {
		this.strFinancialStartyear = strFinancialStartyear;
	}
	/**
	 * @return the strFinancialEndYear
	 */
	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}
	/**
	 * @param strFinancialEndYear the strFinancialEndYear to set
	 */
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}


	public WebRowSet getStoreNameComboWS() {
		return storeNameComboWS;
	}
	public void setStoreNameComboWS(WebRowSet storeNameComboWS) {
		this.storeNameComboWS = storeNameComboWS;
	}
	public WebRowSet getGatePassTypeComboWS() {
		return gatePassTypeComboWS;
	}
	public void setGatePassTypeComboWS(WebRowSet gatePassTypeComboWS) {
		this.gatePassTypeComboWS = gatePassTypeComboWS;
	}
	public WebRowSet getIssueByComboWS() {
		return issueByComboWS;
	}
	public void setIssueByComboWS(WebRowSet issueByComboWS) {
		this.issueByComboWS = issueByComboWS;
	}
	
	/**
	 * @return the strValidityUnit
	 */
	public String getStrValidityUnit() {
		return strValidityUnit;
	}
	/**
	 * @param strValidityUnit the strValidityUnit to set
	 */
	public void setStrValidityUnit(String strValidityUnit) {
		this.strValidityUnit = strValidityUnit;
	}
	/**
	 * @return the strIssueBy
	 */
	public String getStrIssueBy() {
		return strIssueBy;
	}
	/**
	 * @param strIssueBy the strIssueBy to set
	 */
	public void setStrIssueBy(String strIssueBy) {
		this.strIssueBy = strIssueBy;
	}
	/**
	 * @return the strGatepassTypeCode
	 */
	public String getStrGatepassTypeCode() {
		return strGatepassTypeCode;
	}
	/**
	 * @param strGatepassTypeCode the strGatepassTypeCode to set
	 */
	public void setStrGatepassTypeCode(String strGatepassTypeCode) {
		this.strGatepassTypeCode = strGatepassTypeCode;
	}
}
