package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

public class IndentReturnTransFB extends ActionForm {

	private static final long serialVersionUID = 02L;
	
	private String strErr = "";
	private String strMsg = "";
	private String strWarningMsg = "";
    private String strMsgString = "";
	private String strMsgType = "";
	private String strErrMsg = "";
    private String strNormalMsg ="";
	private String strHiddenValue ="";
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strPath ="";
	private String strIndentNo = "";
	private String strIndentDate = "";
	private String strIndentType = "";
	private String strItemCategory = "";
	private String strRaisingStore = "";
	private String strChk ="";
	private String strIndentDetails ="";
	private String strRequestName ="";
	private String strReceviedBy ="";
	private String strRemarks="";
	private String strReqNo="";
	private String strReqTypeId="";
	private String strStoreId="";
	private String strToStoreId="";
	//private String strBatchNo="";
	private String strGoFlag ="0";
	
	private String[] strStockStatusCode = {"0"};
	private String[] strItemSlNo = {"0"};
	private String[] strBatchNo = {"0"};
	
	private String strSetItemDetails = "";
	private String strSetApprovedDetails = "";
	
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
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
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
	public String getStrSetItemDetails() {
		return strSetItemDetails;
	}
	public void setStrSetItemDetails(String strSetItemDetails) {
		this.strSetItemDetails = strSetItemDetails;
	}
	public String getStrSetApprovedDetails() {
		return strSetApprovedDetails;
	}
	public void setStrSetApprovedDetails(String strSetApprovedDetails) {
		this.strSetApprovedDetails = strSetApprovedDetails;
	}
	public String getStrPath() {
		return strPath;
	}
	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}
	public String getStrChk() {
		return strChk;
	}
	public void setStrChk(String strChk) {
		this.strChk = strChk;
	}
	public String getStrIndentDetails() {
		return strIndentDetails;
	}
	public void setStrIndentDetails(String strIndentDetails) {
		this.strIndentDetails = strIndentDetails;
	}
	public String getStrRequestName() {
		return strRequestName;
	}
	public void setStrRequestName(String strRequestName) {
		this.strRequestName = strRequestName;
	}
	public String getStrReceviedBy() {
		return strReceviedBy;
	}
	public void setStrReceviedBy(String strReceviedBy) {
		this.strReceviedBy = strReceviedBy;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrReqNo() {
		return strReqNo;
	}
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}
	public String getStrReqTypeId() {
		return strReqTypeId;
	}
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrToStoreId() {
		return strToStoreId;
	}
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}
	public String getStrHiddenValue() {
		return strHiddenValue;
	}
	public void setStrHiddenValue(String strHiddenValue) {
		this.strHiddenValue = strHiddenValue;
	}
	
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
	public String getStrGoFlag() {
		return strGoFlag;
	}
	public void setStrGoFlag(String strGoFlag) {
		this.strGoFlag = strGoFlag;
	}
	public String[] getStrStockStatusCode() {
		return strStockStatusCode;
	}
	public void setStrStockStatusCode(String[] strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}
	public String[] getStrItemSlNo() {
		return strItemSlNo;
	}
	public void setStrItemSlNo(String[] strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
	}
	public String[] getStrBatchNo() {
		return strBatchNo;
	}
	public void setStrBatchNo(String[] strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
	
}

