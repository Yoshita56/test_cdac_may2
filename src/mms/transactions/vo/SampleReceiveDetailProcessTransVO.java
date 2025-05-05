
package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

/**
 * Developer : Adil Wasi
 * Version : 1.0
 * Date : 09-Jan-2012
 * Modif Date :  
*/
public class SampleReceiveDetailProcessTransVO 
{
	private static final long serialVersionUID = 02L;
	
	private String strMode;
	
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "0";
	private String strErrMsg = "";
	private String strTmpVar;

	public String getStrTmpVar() {
		return strTmpVar;
	}
	public void setStrTmpVar(String strTmpVar) {
		this.strTmpVar = strTmpVar;
	}
	private String strHospitalCode = "";
	private String strCtDate = "";
	private String strSeatId = "";
	private String strFromDate="";
	private String strToDate=""; 

	private String strDrugWareHouseId;
	private String strDrugWareHouseName;
	private String strDrugWareHouseNameCmb;
	
	private WebRowSet wrsDrugWareHouseNameCmb;
	private WebRowSet wrsDrugIssueDetail;
	private WebRowSet wrsViewSampleReceiveDetail;
	private WebRowSet itemCategoryComboWS;
	private WebRowSet wrsCurrentStockStatusDetail;
	private WebRowSet wrsSampleSentDWHCmb;
	private WebRowSet wrsDWHItemCmb;
	private WebRowSet wrsDWHItemBatchCmb;
	
	private String strItemCategoryNo;
	private String strItemCatNoCmb;
	private String strIssueNo;
	private String strItemBrandId;
	private String strBatchNo;
	private String strItemSlNo;
	private String strStockStatusCode;
	private String strIssueDate;
	private String strItemID;
	private String strToStoreId;
	private String strExpiryDate;
	private String strStoreId;
	
	private String strRemarks;
	private String strIsValid;
	private String strEntryDate;
	
	private WebRowSet wrsData;
	
	private String[] strCheckHidValue;
	private String[] strIssueChkIndex;
	private String[] strPrintLabelValue;
	private String[] strCurrentStockStatusDetail;
	private String strSampleSentDWHId;
	private String strItemBrandID;
    private String[] strBkgQty={""};

	
	
	public String[] getStrBkgQty() {
		return strBkgQty;
	}
	public void setStrBkgQty(String[] strBkgQty) {
		this.strBkgQty = strBkgQty;
	}
	
	
	////

	
	public String getStrItemBrandID() {
		return strItemBrandID;
	}
	public void setStrItemBrandID(String strItemBrandID) {
		this.strItemBrandID = strItemBrandID;
	}
	public String getStrSampleSentDWHId() {
		return strSampleSentDWHId;
	}
	public void setStrSampleSentDWHId(String strSampleSentDWHId) {
		this.strSampleSentDWHId = strSampleSentDWHId;
	}
	/************Variable Start Here******************/
	
	
	
	////
	
	
	
	
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
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	
	public String getStrFromDate() {
		return strFromDate;
	}
	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}
	public String getStrToDate() {
		return strToDate;
	}
	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}
	public String getStrDrugWareHouseId() {
		return strDrugWareHouseId;
	}
	public void setStrDrugWareHouseId(String strDrugWareHouseId) {
		this.strDrugWareHouseId = strDrugWareHouseId;
	}
	public String getStrDrugWareHouseName() {
		return strDrugWareHouseName;
	}
	public void setStrDrugWareHouseName(String strDrugWareHouseName) {
		this.strDrugWareHouseName = strDrugWareHouseName;
	}
	public WebRowSet getWrsDrugWareHouseNameCmb() {
		return wrsDrugWareHouseNameCmb;
	}
	public void setWrsDrugWareHouseNameCmb(WebRowSet wrsDrugWareHouseNameCmb) {
		this.wrsDrugWareHouseNameCmb = wrsDrugWareHouseNameCmb;
	}
	
	
	public WebRowSet getWrsDrugIssueDetail() {
		return wrsDrugIssueDetail;
	}
	public void setWrsDrugIssueDetail(WebRowSet wrsDrugIssueDetail) {
		this.wrsDrugIssueDetail = wrsDrugIssueDetail;
	}
	
	public WebRowSet getWrsViewSampleReceiveDetail() {
		return wrsViewSampleReceiveDetail;
	}
	public void setWrsViewSampleReceiveDetail(WebRowSet wrsViewSampleReceiveDetail) {
		this.wrsViewSampleReceiveDetail = wrsViewSampleReceiveDetail;
	}
	
	
	
	public WebRowSet getWrsCurrentStockStatusDetail() {
		return wrsCurrentStockStatusDetail;
	}
	public void setWrsCurrentStockStatusDetail(WebRowSet wrsCurrentStockStatusDetail) {
		this.wrsCurrentStockStatusDetail = wrsCurrentStockStatusDetail;
	}
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}
	public String getStrItemCatNoCmb() {
		return strItemCatNoCmb;
	}
	public void setStrItemCatNoCmb(String strItemCatNoCmb) {
		this.strItemCatNoCmb = strItemCatNoCmb;
	}
	public String getStrIssueNo() {
		return strIssueNo;
	}
	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
	}
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	public String getStrBatchNo() {
		return strBatchNo;
	}
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
	public String getStrItemSlNo() {
		return strItemSlNo;
	}
	public void setStrItemSlNo(String strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
	}
	public String getStrStockStatusCode() {
		return strStockStatusCode;
	}
	public void setStrStockStatusCode(String strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}
	public String getStrIssueDate() {
		return strIssueDate;
	}
	public void setStrIssueDate(String strIssueDate) {
		this.strIssueDate = strIssueDate;
	}
	public String getStrItemID() {
		return strItemID;
	}
	public void setStrItemID(String strItemID) {
		this.strItemID = strItemID;
	}
	public String getStrToStoreId() {
		return strToStoreId;
	}
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}
	public String getStrExpiryDate() {
		return strExpiryDate;
	}
	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrDrugWareHouseNameCmb() {
		return strDrugWareHouseNameCmb;
	}
	public void setStrDrugWareHouseNameCmb(String strDrugWareHouseNameCmb) {
		this.strDrugWareHouseNameCmb = strDrugWareHouseNameCmb;
	}
	
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public WebRowSet getWrsData() {
		return wrsData;
	}
	public void setWrsData(WebRowSet wrsData) {
		this.wrsData = wrsData;
	}
	
	public String getStrIsValid() {
		return strIsValid;
	}
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	
	public String getStrEntryDate() {
		return strEntryDate;
	}
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}
	public WebRowSet getItemCategoryComboWS() {
		return itemCategoryComboWS;
	}
	public void setItemCategoryComboWS(WebRowSet itemCategoryComboWS) {
		this.itemCategoryComboWS = itemCategoryComboWS;
	}
	public String[] getStrCheckHidValue() {
		return strCheckHidValue;
	}
	public void setStrCheckHidValue(String[] strCheckHidValue) {
		this.strCheckHidValue = strCheckHidValue;
	}
	public String[] getStrIssueChkIndex() {
		return strIssueChkIndex;
	}
	public void setStrIssueChkIndex(String[] strIssueChkIndex) {
		this.strIssueChkIndex = strIssueChkIndex;
	}
	public String[] getStrPrintLabelValue() {
		return strPrintLabelValue;
	}
	public void setStrPrintLabelValue(String[] strPrintLabelValue) {
		this.strPrintLabelValue = strPrintLabelValue;
	}
	public String[] getStrCurrentStockStatusDetail() {
		return strCurrentStockStatusDetail;
	}
	public void setStrCurrentStockStatusDetail(String[] strCurrentStockStatusDetail) {
		this.strCurrentStockStatusDetail = strCurrentStockStatusDetail;
	}
	public WebRowSet getWrsSampleSentDWHCmb() {
		return wrsSampleSentDWHCmb;
	}
	public void setWrsSampleSentDWHCmb(WebRowSet wrsSampleSentDWHCmb) {
		this.wrsSampleSentDWHCmb = wrsSampleSentDWHCmb;
	}
	public WebRowSet getWrsDWHItemCmb() {
		return wrsDWHItemCmb;
	}
	public void setWrsDWHItemCmb(WebRowSet wrsDWHItemCmb) {
		this.wrsDWHItemCmb = wrsDWHItemCmb;
	}
	public WebRowSet getWrsDWHItemBatchCmb() {
		return wrsDWHItemBatchCmb;
	}
	public void setWrsDWHItemBatchCmb(WebRowSet wrsDWHItemBatchCmb) {
		this.wrsDWHItemBatchCmb = wrsDWHItemBatchCmb;
	}
	
	
}