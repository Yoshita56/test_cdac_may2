
package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class OnlineTransferDetailTransVO {
	
	private String strHospitalCode = "";
	private String strSeatId = "";

	private String strFromDate="";
	private String strToDate="";
	
	private String strMode = "";
	
	
	private String strStoreId = "";
	private String strToStoreId = "";	
	private String strStoreValues = "";
	private WebRowSet strStoreWs = null;
	
	private String strOrderNo;	
	private WebRowSet strOrderNoWs;
	
	private String strCtDate = "";
	
	private String strErrMsg = "";
	private String strWarningMsg = "";
	private String strNormalMsg = "";
	
	private String strMsgType = "";
	private String strMsgString = "";
	
    private String strStoreName = "";
	private String strItemName = "";
	


	private String[] strBatchNo = null;
	private String[] strAvailableQty = null;
	private String[] strRatePerUnit = null;
	private String[] strHidValue = null;
	private String[] strTransferQty = null;
	private String[] strCost = null;
	private String[] batchCheckbox = null;
	
	private String[] checkboxFlag= null;
	
	private String strItemId;
	private String strItemBrandId;
	
	private String strTotalTransferredCost;
	private String strTotalTransferredQty;
	private String strRemarks;
	private String strTransferNo;
	private WebRowSet wrsData;
	private WebRowSet transferDtlWs;
	
	public WebRowSet getTransferDtlWs() {
		return transferDtlWs;
	}
	public void setTransferDtlWs(WebRowSet transferDtlWs) {
		this.transferDtlWs = transferDtlWs;
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
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrStoreValues() {
		return strStoreValues;
	}
	public void setStrStoreValues(String strStoreValues) {
		this.strStoreValues = strStoreValues;
	}
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
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
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrItemName() {
		return strItemName;
	}
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	public String[] getStrBatchNo() {
		return strBatchNo;
	}
	public void setStrBatchNo(String[] strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
	public String[] getStrAvailableQty() {
		return strAvailableQty;
	}
	public void setStrAvailableQty(String[] strAvailableQty) {
		this.strAvailableQty = strAvailableQty;
	}
	public String[] getStrRatePerUnit() {
		return strRatePerUnit;
	}
	public void setStrRatePerUnit(String[] strRatePerUnit) {
		this.strRatePerUnit = strRatePerUnit;
	}
	public String[] getStrHidValue() {
		return strHidValue;
	}
	public void setStrHidValue(String[] strHidValue) {
		this.strHidValue = strHidValue;
	}
	public String[] getStrTransferQty() {
		return strTransferQty;
	}
	public void setStrTransferQty(String[] strTransferQty) {
		this.strTransferQty = strTransferQty;
	}
	public String[] getStrCost() {
		return strCost;
	}
	public void setStrCost(String[] strCost) {
		this.strCost = strCost;
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
	public WebRowSet getStrOrderNoWs() {
		return strOrderNoWs;
	}
	public void setStrOrderNoWs(WebRowSet strOrderNoWs) {
		this.strOrderNoWs = strOrderNoWs;
	}
	public String getStrOrderNo() {
		return strOrderNo;
	}
	public void setStrOrderNo(String strOrderNo) {
		this.strOrderNo = strOrderNo;
	}
	public WebRowSet getWrsData() {
		return wrsData;
	}
	public void setWrsData(WebRowSet wrsData) {
		this.wrsData = wrsData;
	}
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	public String getStrTotalTransferredCost() {
		return strTotalTransferredCost;
	}
	public void setStrTotalTransferredCost(String strTotalTransferredCost) {
		this.strTotalTransferredCost = strTotalTransferredCost;
	}
	public String getStrTotalTransferredQty() {
		return strTotalTransferredQty;
	}
	public void setStrTotalTransferredQty(String strTotalTransferredQty) {
		this.strTotalTransferredQty = strTotalTransferredQty;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrTransferNo() {
		return strTransferNo;
	}
	public void setStrTransferNo(String strTransferNo) {
		this.strTransferNo = strTransferNo;
	}
	public String getStrToStoreId() {
		return strToStoreId;
	}
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}
	public String[] getBatchCheckbox() {
		return batchCheckbox;
	}
	public void setBatchCheckbox(String[] batchCheckbox) {
		this.batchCheckbox = batchCheckbox;
	}
	public String[] getCheckboxFlag() {
		return checkboxFlag;
	}
	public void setCheckboxFlag(String[] checkboxFlag) {
		this.checkboxFlag = checkboxFlag;
	}

	
	
	
	
	

}
