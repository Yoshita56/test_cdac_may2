package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

public class ReminderDetailsTransFB extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strErrMsg = "";
	private String strWarningMsg = "";
	private String strNormalMsg = "";
	private String strMsgType= "";
	
	private String strReminderType = "1";
	private String strReminderNo = "";
	private String strStoreId = "";
	private String strPONo = "";
	private String strScheduleNo = "";
	private String strReportId = "";
	
	private String strPODate = "";
	private String strSuppId = "";
	private String strItemCatId = "";
		
	private String strPODetailsVal= "";
	
	private String strStoreValues = "";
	private String strPoValues = "";
	
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
	public String getStrStoreValues() {
		return strStoreValues;
	}
	public void setStrStoreValues(String strStoreValues) {
		this.strStoreValues = strStoreValues;
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
	public String getStrPODetailsVal() {
		return strPODetailsVal;
	}
	public void setStrPODetailsVal(String strPODetailsVal) {
		this.strPODetailsVal = strPODetailsVal;
	}
	public String getStrReminderType() {
		return strReminderType;
	}
	public void setStrReminderType(String strReminderType) {
		this.strReminderType = strReminderType;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrPONo() {
		return strPONo;
	}
	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
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
	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	public String getStrReminderNo() {
		return strReminderNo;
	}
	public void setStrReminderNo(String strReminderNo) {
		this.strReminderNo = strReminderNo;
	}
	public String getStrReportId() {
		return strReportId;
	}
	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
	}
	/**
	 * @return the strPoValues
	 */
	public String getStrPoValues() {
		return strPoValues;
	}
	/**
	 * @param strPoValues the strPoValues to set
	 */
	public void setStrPoValues(String strPoValues) {
		this.strPoValues = strPoValues;
	}
	
}
