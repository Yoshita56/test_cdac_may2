package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

public class AdvanceRequestTransFB extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strErrMsg = "";
	private String strWarningMsg = "";
	private String strNormalMsg = "";
	private String strMsgString = "";
	private String strMsgType = "";
	
	private String strReportId = "";
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strRequestNumber = "";
	private String strStoreValues = "";
	private String strPONOValues = "";
	private String poPrefix = "";
	
	private String strRadioVal = "";
	private String strCurrentDate = "";
	private String strStoreId = "";
	private String strItemCat = "";
	private String strPONO = "";
	private String strPODate = "";
	private String strSupplierId = "";
	private String strItemCategoryId = "";
	private String strRemarks = "";
	private String storeName = "";
	private String itemCatName = "";
	private String poNoVal = "";
	private String strChkAdvanceReq = "1";
	
	private String strPODetailsVal = "";
	private String strPODetailsValDup = "";
	private String strReqDetailsVal = "";
	private String strBankDetailsValDup = "";
	
	private String strCheckValue = "";
	private String disFlag = "0";
	
	private String strId = "0";
	private String itemCategory = "0";
	private String ponovalue = "0";
	
	private String strSuppId = "";
	private String strCurrId = "";
	private String strPOAmt = "";
	private String strAdvRequest = "";
	private String strHasInsert="0";
	
	private String strBankAccName = "";
	private String strBankAccNo = "";
	
	private String strItemCatCombo="";
	public String getStrHasInsert() {
		return strHasInsert;
	}
	public void setStrHasInsert(String strHasInsert) {
		this.strHasInsert = strHasInsert;
	}
	public String getStrAdvRequest() {
		return strAdvRequest;
	}
	public void setStrAdvRequest(String strAdvRequest) {
		this.strAdvRequest = strAdvRequest;
	}
	public String getStrPOAmt() {
		return strPOAmt;
	}
	public void setStrPOAmt(String strPOAmt) {
		this.strPOAmt = strPOAmt;
	}
	public String getStrCurrId() {
		return strCurrId;
	}
	public void setStrCurrId(String strCurrId) {
		this.strCurrId = strCurrId;
	}
	public String getStrSuppId() {
		return strSuppId;
	}
	public void setStrSuppId(String strSuppId) {
		this.strSuppId = strSuppId;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public String getPonovalue() {
		return ponovalue;
	}
	public void setPonovalue(String ponovalue) {
		this.ponovalue = ponovalue;
	}
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getStrCheckValue() {
		return strCheckValue;
	}
	public void setStrCheckValue(String strCheckValue) {
		this.strCheckValue = strCheckValue;
	}
	public String getStrChkAdvanceReq() {
		return strChkAdvanceReq;
	}
	public void setStrChkAdvanceReq(String strChkAdvanceReq) {
		this.strChkAdvanceReq = strChkAdvanceReq;
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
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
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
	public String getStrStoreValues() {
		return strStoreValues;
	}
	public void setStrStoreValues(String strStoreValues) {
		this.strStoreValues = strStoreValues;
	}
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
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
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public String getStrPONOValues() {
		return strPONOValues;
	}
	public void setStrPONOValues(String strPONOValues) {
		this.strPONOValues = strPONOValues;
	}
	public String getStrPODetailsVal() {
		return strPODetailsVal;
	}
	public void setStrPODetailsVal(String strPODetailsVal) {
		this.strPODetailsVal = strPODetailsVal;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getItemCatName() {
		return itemCatName;
	}
	public void setItemCatName(String itemCatName) {
		this.itemCatName = itemCatName;
	}
	public String getPoNoVal() {
		return poNoVal;
	}
	public void setPoNoVal(String poNoVal) {
		this.poNoVal = poNoVal;
	}
	public String getDisFlag() {
		return disFlag;
	}
	public void setDisFlag(String disFlag) {
		this.disFlag = disFlag;
	}
	public String getStrReqDetailsVal() {
		return strReqDetailsVal;
	}
	public void setStrReqDetailsVal(String strReqDetailsVal) {
		this.strReqDetailsVal = strReqDetailsVal;
	}
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
	public String getStrReportId() {
		return strReportId;
	}
	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
	}
	public String getStrRequestNumber() {
		return strRequestNumber;
	}
	public void setStrRequestNumber(String strRequestNumber) {
		this.strRequestNumber = strRequestNumber;
	}
	public String getStrRadioVal() {
		return strRadioVal;
	}
	public void setStrRadioVal(String strRadioVal) {
		this.strRadioVal = strRadioVal;
	}
	public String getStrPODetailsValDup() {
		return strPODetailsValDup;
	}
	public void setStrPODetailsValDup(String strPODetailsValDup) {
		this.strPODetailsValDup = strPODetailsValDup;
	}
	public String getPoPrefix() {
		return poPrefix;
	}
	public void setPoPrefix(String poPrefix) {
		this.poPrefix = poPrefix;
	}
	public String getStrItemCat() {
		return strItemCat;
	}
	public void setStrItemCat(String strItemCat) {
		this.strItemCat = strItemCat;
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
	 * @return the strBankDetailsValDup
	 */
	public String getStrBankDetailsValDup() {
		return strBankDetailsValDup;
	}
	/**
	 * @param strBankDetailsValDup the strBankDetailsValDup to set
	 */
	public void setStrBankDetailsValDup(String strBankDetailsValDup) {
		this.strBankDetailsValDup = strBankDetailsValDup;
	}
	public String getStrItemCatCombo() {
		return strItemCatCombo;
	}
	public void setStrItemCatCombo(String strItemCatCombo) {
		this.strItemCatCombo = strItemCatCombo;
	}
}
