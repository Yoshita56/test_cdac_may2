/**
 * 
 */
package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

/**
 * @author Pankaj Kumar
 *
 */
public class AgendaDeskModifyTransVO {
	
	private String strMsgType="";
	private String strErr="";
	private String strWarning="";
	private String strMsgString="";
	private String strMsg="";
	private String strToStore="";
	private String strToStoreValues="";
	private String strItemCat="";
	private String strItemCatValues="";
	private String strAgendaPeriod="";
	private String strHospitalCode="";
	private String strSeatId="";
	private String strStoreId="";
	private String strItemCatNo="";
	private String strRemarks="";
	private String strAgendaNo="";
	private String strToStoreId="";
	private String strAgendaDate="";
	private String strAgendaStatus="";
	private String strFinancialStartDate="";
	private String strFinancialToDate="";
	
	
	
	private WebRowSet wbIndentDetail=null;

	/**
	 * @return the strItemCatNo
	 */
	public String getStrItemCatNo() {
		return strItemCatNo;
	}

	/**
	 * @param strItemCatNo the strItemCatNo to set
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}

	/**
	 * @return the strAgendaDate
	 */
	public String getStrAgendaDate() {
		return strAgendaDate;
	}

	/**
	 * @param strAgendaDate the strAgendaDate to set
	 */
	public void setStrAgendaDate(String strAgendaDate) {
		this.strAgendaDate = strAgendaDate;
	}

	/**
	 * @return the strAgendaNo
	 */
	public String getStrAgendaNo() {
		return strAgendaNo;
	}

	/**
	 * @param strAgendaNo the strAgendaNo to set
	 */
	public void setStrAgendaNo(String strAgendaNo) {
		this.strAgendaNo = strAgendaNo;
	}

	/**
	 * @return the strToStoreId
	 */
	public String getStrToStoreId() {
		return strToStoreId;
	}

	/**
	 * @param strToStoreId the strToStoreId to set
	 */
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}

	/**
	 * @return the strAgendaStatus
	 */
	public String getStrAgendaStatus() {
		return strAgendaStatus;
	}

	/**
	 * @param strAgendaStatus the strAgendaStatus to set
	 */
	public void setStrAgendaStatus(String strAgendaStatus) {
		this.strAgendaStatus = strAgendaStatus;
	}

	/**
	 * @return the strFinancialStartDate
	 */
	public String getStrFinancialStartDate() {
		return strFinancialStartDate;
	}

	/**
	 * @param strFinancialStartDate the strFinancialStartDate to set
	 */
	public void setStrFinancialStartDate(String strFinancialStartDate) {
		this.strFinancialStartDate = strFinancialStartDate;
	}

	/**
	 * @return the strFinancialToDate
	 */
	public String getStrFinancialToDate() {
		return strFinancialToDate;
	}

	/**
	 * @param strFinancialToDate the strFinancialToDate to set
	 */
	public void setStrFinancialToDate(String strFinancialToDate) {
		this.strFinancialToDate = strFinancialToDate;
	}

	/**
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}

	/**
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * @return the strMsgString
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/**
	 * @param strMsgString the strMsgString to set
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/**
	 * @return the strMsgType
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/**
	 * @param strMsgType the strMsgType to set
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	/**
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * @return the strWarning
	 */
	public String getStrWarning() {
		return strWarning;
	}

	/**
	 * @param strWarning the strWarning to set
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}

	/**
	 * @return the strMsg
	 */
	public String getStrMsg() {
		return strMsg;
	}

	/**
	 * @param strMsg the strMsg to set
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	/**
	 * @return the strToStore
	 */
	public String getStrToStore() {
		return strToStore;
	}

	/**
	 * @param strToStore the strToStore to set
	 */
	public void setStrToStore(String strToStore) {
		this.strToStore = strToStore;
	}

	/**
	 * @return the strToStoreValues
	 */
	public String getStrToStoreValues() {
		return strToStoreValues;
	}

	/**
	 * @param strToStoreValues the strToStoreValues to set
	 */
	public void setStrToStoreValues(String strToStoreValues) {
		this.strToStoreValues = strToStoreValues;
	}

	/**
	 * @return the strItemCat
	 */
	public String getStrItemCat() {
		return strItemCat;
	}

	/**
	 * @param strItemCat the strItemCat to set
	 */
	public void setStrItemCat(String strItemCat) {
		this.strItemCat = strItemCat;
	}

	/**
	 * @return the strItemCatValues
	 */
	public String getStrItemCatValues() {
		return strItemCatValues;
	}

	/**
	 * @param strItemCatValues the strItemCatValues to set
	 */
	public void setStrItemCatValues(String strItemCatValues) {
		this.strItemCatValues = strItemCatValues;
	}

	/**
	 * @return the strAgendaPeriod
	 */
	public String getStrAgendaPeriod() {
		return strAgendaPeriod;
	}

	/**
	 * @param strAgendaPeriod the strAgendaPeriod to set
	 */
	public void setStrAgendaPeriod(String strAgendaPeriod) {
		this.strAgendaPeriod = strAgendaPeriod;
	}

	/**
	 * @return the wbIndentDetail
	 */
	public WebRowSet getWbIndentDetail() {
		return wbIndentDetail;
	}

	/**
	 * @param wbIndentDetail the wbIndentDetail to set
	 */
	public void setWbIndentDetail(WebRowSet wbIndentDetail) {
		this.wbIndentDetail = wbIndentDetail;
	} 
	
	
}
