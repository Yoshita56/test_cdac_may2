package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class IndentViewTransVO 
{
	
	private static final long serialVersionUID = 02L;
	private String strErrMsg = "";
	private String strNormalMsg = "";
	private String strWarningMsg = "";
    private String strMsgString = "";
	private String strMsgType = "0";

	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private WebRowSet strItemDetailsWs = null;
	private WebRowSet strIndentDetailsWs = null;
	private WebRowSet strApprovalDetailsWs = null;
	private WebRowSet IndentItemWS = null;
	
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
	private String strIndentTypeId="";
	//Change Request
	private String strFinancialEndDate;
	private String strFinancialStartDate;
	private String strAvalaibleBudget;
	private String strAvalaibleBudgetDtl;	
	private String strReqQty;
	private String strItemBrandIds;
	private String strModifedQty;
	private String strLogoName ="";

	public String getStrLogoName() {
		return strLogoName;
	}
	public void setStrLogoName(String strLogoName) {
		this.strLogoName = strLogoName;
	}	
	
	
	
	
	public String getStrFinancialEndDate() {
		return strFinancialEndDate;
	}
	public void setStrFinancialEndDate(String strFinancialEndDate) {
		this.strFinancialEndDate = strFinancialEndDate;
	}
	public String getStrFinancialStartDate() {
		return strFinancialStartDate;
	}
	public void setStrFinancialStartDate(String strFinancialStartDate) {
		this.strFinancialStartDate = strFinancialStartDate;
	}
	public String getStrAvalaibleBudget() {
		return strAvalaibleBudget;
	}
	public void setStrAvalaibleBudget(String strAvalaibleBudget) {
		this.strAvalaibleBudget = strAvalaibleBudget;
	}
	public String getStrAvalaibleBudgetDtl() {
		return strAvalaibleBudgetDtl;
	}
	public void setStrAvalaibleBudgetDtl(String strAvalaibleBudgetDtl) {
		this.strAvalaibleBudgetDtl = strAvalaibleBudgetDtl;
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
	public WebRowSet getIndentItemWS() {
		return IndentItemWS;
	}
	public void setIndentItemWS(WebRowSet indentItemWS) {
		IndentItemWS = indentItemWS;
	}
	public String getStrReqQty() {
		return strReqQty;
	}
	public void setStrReqQty(String strReqQty) {
		this.strReqQty = strReqQty;
	}
	public String getStrIndentTypeId() {
		return strIndentTypeId;
	}
	public void setStrIndentTypeId(String strIndentTypeId) {
		this.strIndentTypeId = strIndentTypeId;
	}
	public String getStrModifedQty() {
		return strModifedQty;
	}
	public void setStrModifedQty(String strModifedQty) {
		this.strModifedQty = strModifedQty;
	}
	public String getStrItemBrandIds() {
		return strItemBrandIds;
	}
	public void setStrItemBrandIds(String strItemBrandIds) {
		this.strItemBrandIds = strItemBrandIds;
	}

}
