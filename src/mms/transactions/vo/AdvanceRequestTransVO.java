package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class AdvanceRequestTransVO {
	
	private String strMsgType = "";
	private String strMsgString = "";
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strStoreId = "";
	private String strPONO = "";
	private String strPODate = "";
	private String strSupplierId = "";
	private String strItemCategoryId = "";
	private String strRemarks = "";
	private String strChkAdvanceReq = "";
	private String strSuppId = "";
	private String strCurrId = "";
	private String strPOAmt = "";
	private String strIsValid = "";
	private String strAdvRequest = "";
	private String strAdvStatus = "";
	private String strItemCatDup = "";
	private String strPONoDup = "";
	private String strStrDup = "";
	private String strRequestNumber = "";
	private String strRequestPrefix = "";
	private String strReqTypeId = "";
	private String strPOStoreId = "";
	private String strPOStoreIdDup = "";
	private String strBankAccName = "";
	private String strBankAccNo = "";
	
	
	private WebRowSet strStoreWs = null;
	private WebRowSet strPONOWs = null;
	private WebRowSet strItemCatWs = null;
	private WebRowSet strPODtlsWs = null;
	private WebRowSet strReqDetailsWs  =null;
	private WebRowSet strBankDtlsWs  =null;
	
	public WebRowSet getStrReqDetailsWs() {
		return strReqDetailsWs;
	}

	public void setStrReqDetailsWs(WebRowSet strReqDetailsWs) {
		this.strReqDetailsWs = strReqDetailsWs;
	}

	public WebRowSet getStrPODtlsWs() {
		return strPODtlsWs;
	}

	public void setStrPODtlsWs(WebRowSet strPODtlsWs) {
		this.strPODtlsWs = strPODtlsWs;
	}

	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}

	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
	}

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
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

	public String getStrStoreId() {
		return strStoreId;
	}

	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	public WebRowSet getStrPONOWs() {
		return strPONOWs;
	}

	public void setStrPONOWs(WebRowSet strPONOWs) {
		this.strPONOWs = strPONOWs;
	}

	public String getStrPONO() {
		return strPONO;
	}

	public void setStrPONO(String strPONO) {
		this.strPONO = strPONO;
	}

	public String getStrPODate() {
		return strPODate;
	}

	public void setStrPODate(String strPODate) {
		this.strPODate = strPODate;
	}

	public String getStrSupplierId() {
		return strSupplierId;
	}

	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}

	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String getStrChkAdvanceReq() {
		return strChkAdvanceReq;
	}

	public void setStrChkAdvanceReq(String strChkAdvanceReq) {
		this.strChkAdvanceReq = strChkAdvanceReq;
	}

	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}

	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
	}

	public String getStrItemCatDup() {
		return strItemCatDup;
	}

	public void setStrItemCatDup(String strItemCatDup) {
		this.strItemCatDup = strItemCatDup;
	}

	public String getStrPONoDup() {
		return strPONoDup;
	}

	public void setStrPONoDup(String strPONoDup) {
		this.strPONoDup = strPONoDup;
	}

	public String getStrStrDup() {
		return strStrDup;
	}

	public void setStrStrDup(String strStrDup) {
		this.strStrDup = strStrDup;
	}

	public String getStrSuppId() {
		return strSuppId;
	}

	public void setStrSuppId(String strSuppId) {
		this.strSuppId = strSuppId;
	}

	public String getStrCurrId() {
		return strCurrId;
	}

	public void setStrCurrId(String strCurrId) {
		this.strCurrId = strCurrId;
	}

	public String getStrPOAmt() {
		return strPOAmt;
	}

	public void setStrPOAmt(String strPOAmt) {
		this.strPOAmt = strPOAmt;
	}

	public String getStrAdvRequest() {
		return strAdvRequest;
	}

	public void setStrAdvRequest(String strAdvRequest) {
		this.strAdvRequest = strAdvRequest;
	}

	public String getStrAdvStatus() {
		return strAdvStatus;
	}

	public void setStrAdvStatus(String strAdvStatus) {
		this.strAdvStatus = strAdvStatus;
	}

	public String getStrIsValid() {
		return strIsValid;
	}

	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	public String getStrRequestNumber() {
		return strRequestNumber;
	}

	public void setStrRequestNumber(String strRequestNumber) {
		this.strRequestNumber = strRequestNumber;
	}

	public String getStrReqTypeId() {
		return strReqTypeId;
	}

	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}

	public String getStrRequestPrefix() {
		return strRequestPrefix;
	}

	public void setStrRequestPrefix(String strRequestPrefix) {
		this.strRequestPrefix = strRequestPrefix;
	}

	public String getStrPOStoreId() {
		return strPOStoreId;
	}

	public void setStrPOStoreId(String strPOStoreId) {
		this.strPOStoreId = strPOStoreId;
	}

	public String getStrPOStoreIdDup() {
		return strPOStoreIdDup;
	}

	public void setStrPOStoreIdDup(String strPOStoreIdDup) {
		this.strPOStoreIdDup = strPOStoreIdDup;
	}

	/**
	 * @return the strBankAccName
	 */
	public String getStrBankAccName() {
		return strBankAccName;
	}

	/**
	 * @param strBankAccName the strBankAccName to set
	 */
	public void setStrBankAccName(String strBankAccName) {
		this.strBankAccName = strBankAccName;
	}

	/**
	 * @return the strBankAccNo
	 */
	public String getStrBankAccNo() {
		return strBankAccNo;
	}

	/**
	 * @param strBankAccNo the strBankAccNo to set
	 */
	public void setStrBankAccNo(String strBankAccNo) {
		this.strBankAccNo = strBankAccNo;
	}

	/**
	 * @return the strBankDtlsWs
	 */
	public WebRowSet getStrBankDtlsWs() {
		return strBankDtlsWs;
	}

	/**
	 * @param strBankDtlsWs the strBankDtlsWs to set
	 */
	public void setStrBankDtlsWs(WebRowSet strBankDtlsWs) {
		this.strBankDtlsWs = strBankDtlsWs;
	}

	

}
