package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class IndentReturnTransVO {	
	private static final long serialVersionUID = 02L;
	private String strErrMsg = "";
	private String strNormalMsg = "";
	private String strWarningMsg = "";
    private String strMsgString = "";
	private String strMsgType = "0";

	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String[] strStockStatusCode = {"0"};
	private String[] strItemSlNo = {"0"};
	private String[] strBatchNo = {"0"};
	
	private WebRowSet strItemDetailsWs = null;
	private WebRowSet strIndentDetailsWs = null;
	private WebRowSet strApprovalDetailsWs = null;
	
	private String strFinancialStartYear = "";
    
	private String strFinancialEndYear = "";
	private String strItemId="";
	private String strItemBrandId="";
	//private String strStockStatusCode="";
	private String strAvlQtyUnit="";
	private String strSancQtyUnit;
	private String strIndentNo = "";
	private String strIndentDate = "";
	private String strIndentType = "";
	private String strItemCategory = "";
	private String strRaisingStore = "";
	private String strReqNo ="";
	private String strReqTypeId = "";
	private String strStoreId = "";
	private String strIndentName ="";
	private String strToStoreId = "";
	private String strRemarsks ="";
	private String strRecevBy = "";
	private String strAvlQty ="";
	private String strSancQty ="";
	public String getStrAvlQty() {
		return strAvlQty;
	}
	public void setStrAvlQty(String strAvlQty) {
		this.strAvlQty = strAvlQty;
	}
	public String getStrSancQty() {
		return strSancQty;
	}
	public void setStrSancQty(String strSancQty) {
		this.strSancQty = strSancQty;
	}
	public String getStrToStoreId() {
		return strToStoreId;
	}
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
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
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
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
	public WebRowSet getStrItemDetailsWs() {
		return strItemDetailsWs;
	}
	public void setStrItemDetailsWs(WebRowSet strItemDetailsWs) {
		this.strItemDetailsWs = strItemDetailsWs;
	}
	public WebRowSet getStrApprovalDetailsWs() {
		return strApprovalDetailsWs;
	}
	public void setStrApprovalDetailsWs(WebRowSet strApprovalDetailsWs) {
		this.strApprovalDetailsWs = strApprovalDetailsWs;
	}
	public WebRowSet getStrIndentDetailsWs() {
		return strIndentDetailsWs;
	}
	public void setStrIndentDetailsWs(WebRowSet strIndentDetailsWs) {
		this.strIndentDetailsWs = strIndentDetailsWs;
	}
	public String getStrIndentName() {
		return strIndentName;
	}
	public void setStrIndentName(String strIndentName) {
		this.strIndentName = strIndentName;
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
	
	public String getStrAvlQtyUnit() {
		return strAvlQtyUnit;
	}
	public void setStrAvlQtyUnit(String strAvlQtyUnit) {
		this.strAvlQtyUnit = strAvlQtyUnit;
	}
	public String getStrSancQtyUnit() {
		return strSancQtyUnit;
	}
	public void setStrSancQtyUnit(String strSancQtyUnit) {
		this.strSancQtyUnit = strSancQtyUnit;
	}
	public String getStrFinancialStartYear() {
		return strFinancialStartYear;
	}
	public void setStrFinancialStartYear(String strFinancialStartYear) {
		this.strFinancialStartYear = strFinancialStartYear;
	}
	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}
	public String getStrRemarsks() {
		return strRemarsks;
	}
	public void setStrRemarsks(String strRemarsks) {
		this.strRemarsks = strRemarsks;
	}
	public String getStrRecevBy() {
		return strRecevBy;
	}
	public void setStrRecevBy(String strRecevBy) {
		this.strRecevBy = strRecevBy;
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
