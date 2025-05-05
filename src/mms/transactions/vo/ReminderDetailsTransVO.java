package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class ReminderDetailsTransVO {
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strStoreId = "";
	private String strPONo = "";
	private String strPOStoreId = "";
	private String strScheduleNo = "";
	private String strReminderType = "";
	
	private String strPODate = "";
	private String strSuppId = "";
	private String strItemCatId = "";
	private String strPOPrefix = "";
	private String strReminderNo = "";
	private String strReminderPrefix = "";
	
	private String strMsgType = "";
	private String strMsgString = "";
	
	private WebRowSet strStoreWs = null;
	private WebRowSet strPONoWs = null;
	private WebRowSet strScheduleNoWs = null;
	private WebRowSet strPODtlsWs = null;
	private WebRowSet strPrevReminderDtlWs = null;
	
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
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
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public WebRowSet getStrPONoWs() {
		return strPONoWs;
	}
	public void setStrPONoWs(WebRowSet strPONoWs) {
		this.strPONoWs = strPONoWs;
	}
	public String getStrPONo() {
		return strPONo;
	}
	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
	}
	public WebRowSet getStrScheduleNoWs() {
		return strScheduleNoWs;
	}
	public void setStrScheduleNoWs(WebRowSet strScheduleNoWs) {
		this.strScheduleNoWs = strScheduleNoWs;
	}
	public WebRowSet getStrPODtlsWs() {
		return strPODtlsWs;
	}
	public void setStrPODtlsWs(WebRowSet strPODtlsWs) {
		this.strPODtlsWs = strPODtlsWs;
	}
	public WebRowSet getStrPrevReminderDtlWs() {
		return strPrevReminderDtlWs;
	}
	public void setStrPrevReminderDtlWs(WebRowSet strPrevReminderDtlWs) {
		this.strPrevReminderDtlWs = strPrevReminderDtlWs;
	}
	public String getStrPOStoreId() {
		return strPOStoreId;
	}
	public void setStrPOStoreId(String strPOStoreId) {
		this.strPOStoreId = strPOStoreId;
	}
	public String getStrScheduleNo() {
		return strScheduleNo;
	}
	public void setStrScheduleNo(String strScheduleNo) {
		this.strScheduleNo = strScheduleNo;
	}
	public String getStrItemCatId() {
		return strItemCatId;
	}
	public void setStrItemCatId(String strItemCatId) {
		this.strItemCatId = strItemCatId;
	}
	public String getStrPOPrefix() {
		return strPOPrefix;
	}
	public void setStrPOPrefix(String strPOPrefix) {
		this.strPOPrefix = strPOPrefix;
	}
	public String getStrReminderType() {
		return strReminderType;
	}
	public void setStrReminderType(String strReminderType) {
		this.strReminderType = strReminderType;
	}
	public String getStrSuppId() {
		return strSuppId;
	}
	public void setStrSuppId(String strSuppId) {
		this.strSuppId = strSuppId;
	}
	public String getStrPODate() {
		return strPODate;
	}
	public void setStrPODate(String strPODate) {
		this.strPODate = strPODate;
	}
	public String getStrReminderNo() {
		return strReminderNo;
	}
	public void setStrReminderNo(String strReminderNo) {
		this.strReminderNo = strReminderNo;
	}
	public String getStrReminderPrefix() {
		return strReminderPrefix;
	}
	public void setStrReminderPrefix(String strReminderPrefix) {
		this.strReminderPrefix = strReminderPrefix;
	}

}
