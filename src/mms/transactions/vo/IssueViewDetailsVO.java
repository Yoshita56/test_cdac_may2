/**
	 * Developer : Pramod Kumar Mehta 
	 * Version : 1.0 
	 * Date : 01/April/2009
	 *  Module:MMS
	 * Unit:Issue Details View
	 *
	 */
package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class IssueViewDetailsVO {
	private static final long serialVersionUID = 02L;
	private String strMsgType="";
	private String strMsgString="";
	
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
	private String strCtDate = "";
	private String strHospitalCode = "";
	private String strIsValid = "";
	private String strSeatId = "";
	private String strIssueNo="";
	private String strIssueDate="";
	private String strIssuingStore="";
	private String strAckStatus="";
	private String strIndentNo="";
	private String strIndentDate="";
	private String strIndentType="";
	private String strItemCategory="";
	private String strRaisingStore="";
	private String strItemName="";
	private String strBrandName="";
	private String strRateUnit="";
	private String strReqQty="";
	private String strSaveQty="";
	private String strIssueQty="";
	private WebRowSet IssueDetailsWS=null;
	private WebRowSet ItemDetailsWS=null;
	public String getStrErr() {
		return strErr;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	public String getStrMsg() {
		return strMsg;
	}
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}
	public String getStrWarning() {
		return strWarning;
	}
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrIsValid() {
		return strIsValid;
	}
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrIssueNo() {
		return strIssueNo;
	}
	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
	}
	public String getStrIssueDate() {
		return strIssueDate;
	}
	public void setStrIssueDate(String strIssueDate) {
		this.strIssueDate = strIssueDate;
	}
	public String getStrIssuingStore() {
		return strIssuingStore;
	}
	public void setStrIssuingStore(String strIssuingStore) {
		this.strIssuingStore = strIssuingStore;
	}
	public String getStrAckStatus() {
		return strAckStatus;
	}
	public void setStrAckStatus(String strAckStatus) {
		this.strAckStatus = strAckStatus;
	}
	public String getStrIndentNo() {
		return strIndentNo;
	}
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}
	public String getStrIndentDate() {
		return strIndentDate;
	}
	public void setStrIndentDate(String strIndentDate) {
		this.strIndentDate = strIndentDate;
	}
	public String getStrIndentType() {
		return strIndentType;
	}
	public void setStrIndentType(String strIndentType) {
		this.strIndentType = strIndentType;
	}
	public String getStrItemCategory() {
		return strItemCategory;
	}
	public void setStrItemCategory(String strItemCategory) {
		this.strItemCategory = strItemCategory;
	}
	public String getStrRaisingStore() {
		return strRaisingStore;
	}
	public void setStrRaisingStore(String strRaisingStore) {
		this.strRaisingStore = strRaisingStore;
	}
	public String getStrItemName() {
		return strItemName;
	}
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	public String getStrBrandName() {
		return strBrandName;
	}
	public void setStrBrandName(String strBrandName) {
		this.strBrandName = strBrandName;
	}
	public String getStrRateUnit() {
		return strRateUnit;
	}
	public void setStrRateUnit(String strRateUnit) {
		this.strRateUnit = strRateUnit;
	}
	public String getStrReqQty() {
		return strReqQty;
	}
	public void setStrReqQty(String strReqQty) {
		this.strReqQty = strReqQty;
	}
	public String getStrSaveQty() {
		return strSaveQty;
	}
	public void setStrSaveQty(String strSaveQty) {
		this.strSaveQty = strSaveQty;
	}
	public String getStrIssueQty() {
		return strIssueQty;
	}
	public void setStrIssueQty(String strIssueQty) {
		this.strIssueQty = strIssueQty;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	public String getStrMsgString() {
		return strMsgString;
	}
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	public WebRowSet getIssueDetailsWS() {
		return IssueDetailsWS;
	}
	public void setIssueDetailsWS(WebRowSet issueDetailsWS) {
		IssueDetailsWS = issueDetailsWS;
	}
	public WebRowSet getItemDetailsWS() {
		return ItemDetailsWS;
	}
	public void setItemDetailsWS(WebRowSet itemDetailsWS) {
		ItemDetailsWS = itemDetailsWS;
	}
}
