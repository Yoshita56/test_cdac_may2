package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

public class IndentViewTransFB extends ActionForm {

	private static final long serialVersionUID = 02L;
	
	private String strErrMsg = "";
	private String strNormalMsg = "";
	private String strWarningMsg = "";
    private String strMsgString = "";
	private String strMsgType = "";

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
	
	private String strAvalaibleBudgetDtl;
	private String strAvalaibleBudget;
	private String strRemainingBudget;
	
	private String strSetItemDetails = "";
	private String strSetApprovedDetails = "";
	private String strBudgetRequired;
	private String strAvlQty;
	private String strReqQty;
	private String strMsg="";
	private String StrErr="";
	private String  strIndentTypeId="";
	private String strItemBrandIds="";
	private String strModifedQty="";
	private String strReqTypeId="";
	
	
	public String getStrReqTypeId() {
		return strReqTypeId;
	}
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
	public String getStrErr() {
		return StrErr;
	}
	public void setStrErr(String strErr) {
		StrErr = strErr;
	}
	public String getStrAvlQty() {
		return strAvlQty;
	}
	public void setStrAvlQty(String strAvlQty) {
		this.strAvlQty = strAvlQty;
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
	public String getStrAvalaibleBudgetDtl() {
		return strAvalaibleBudgetDtl;
	}
	public void setStrAvalaibleBudgetDtl(String strAvalaibleBudgetDtl) {
		this.strAvalaibleBudgetDtl = strAvalaibleBudgetDtl;
	}
	public String getStrAvalaibleBudget() {
		return strAvalaibleBudget;
	}
	public void setStrAvalaibleBudget(String strAvalaibleBudget) {
		this.strAvalaibleBudget = strAvalaibleBudget;
	}
	public String getStrRemainingBudget() {
		return strRemainingBudget;
	}
	public void setStrRemainingBudget(String strRemainingBudget) {
		this.strRemainingBudget = strRemainingBudget;
	}
	public String getStrBudgetRequired() {
		return strBudgetRequired;
	}
	public void setStrBudgetRequired(String strBudgetRequired) {
		this.strBudgetRequired = strBudgetRequired;
	}
	public String getStrReqQty() {
		return strReqQty;
	}
	public void setStrReqQty(String strReqQty) {
		this.strReqQty = strReqQty;
	}
	public String getStrMsg() {
		return strMsg;
	}
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}
	public String getStrIndentTypeId() {
		return strIndentTypeId;
	}
	public void setStrIndentTypeId(String strIndentTypeId) {
		this.strIndentTypeId = strIndentTypeId;
	}
	public String getStrItemBrandIds() {
		return strItemBrandIds;
	}
	public void setStrItemBrandIds(String strItemBrandIds) {
		this.strItemBrandIds = strItemBrandIds;
	}
	public String getStrModifedQty() {
		return strModifedQty;
	}
	public void setStrModifedQty(String strModifedQty) {
		this.strModifedQty = strModifedQty;
	}
	
}
