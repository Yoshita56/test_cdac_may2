package mms.transactions.controller.fb;

import hisglobal.transactionutil.GenericFormBean;

public class ThirdPartyIssueDeskFB extends GenericFormBean{

	private static final long serialVersionUID = 1L;
	
	
	private String strErrMsg = "";
	private String strNormalMsg = "";
	private String strWarningMsg = "";
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strStoreTypeId = "";
	private String strCurrentDate = "";
	private String[] strReqDate = {""};
	private String strStoreId = "";
	private String strInstituteCode = "";
	private String strInstituteValues ="";
	private String strItemCatNo = "";
	private String strItemCatValues = "";
	private String strGroupIdForItemSearch = "";
	private String strGroupValues = "";
	private String strStoreName = "";
	private String strRemarks = "";
	private String[] itemParamValue = {""};
	private String[] itemUserValue = {""};
	private String[] itemCalcValue = {""};
	private String[] strQty = null;
	private String[] strUnitName = null;
	private String strReqNo = "0";
	private String strReqStatus = "";
	private String strItemDtls = "";
	private String strApprovalDtls = "";
	private String strGroupName = "";
	private String strReqDateView = "";
	private String strIssueDate = "";
	private String strIssueDateView = "";
	private String strSancDate = "";
	private String strSancDateView = "";
	private String strThirdPartyFlag="";
	
	private String strModeVal="";
	private String strFromStoreId="";
	private String strIssueNo="";

	private String strIssueTo="";
	private String strItemCategoryNo="";
	private String strSlNoflg="";
	
	
	private String strIndentNo="";
	private String strIndentDate="";
	private String strReturnReqNo="";
	private String strFinalRemarks="";
	private String strApprovalRemarks="";
	
	
	
	
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
	public String getStrReturnReqNo() {
		return strReturnReqNo;
	}
	public void setStrReturnReqNo(String strReturnReqNo) {
		this.strReturnReqNo = strReturnReqNo;
	}
	public String getStrFinalRemarks() {
		return strFinalRemarks;
	}
	public void setStrFinalRemarks(String strFinalRemarks) {
		this.strFinalRemarks = strFinalRemarks;
	}
	public String getStrApprovalRemarks() {
		return strApprovalRemarks;
	}
	public void setStrApprovalRemarks(String strApprovalRemarks) {
		this.strApprovalRemarks = strApprovalRemarks;
	}
	public String getStrModeVal() {
		return strModeVal;
	}
	public void setStrModeVal(String strModeVal) {
		this.strModeVal = strModeVal;
	}
	public String getStrFromStoreId() {
		return strFromStoreId;
	}
	public void setStrFromStoreId(String strFromStoreId) {
		this.strFromStoreId = strFromStoreId;
	}
	public String getStrIssueNo() {
		return strIssueNo;
	}
	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
	}
	public String getStrIssueTo() {
		return strIssueTo;
	}
	public void setStrIssueTo(String strIssueTo) {
		this.strIssueTo = strIssueTo;
	}
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}
	public String getStrSlNoflg() {
		return strSlNoflg;
	}
	public void setStrSlNoflg(String strSlNoflg) {
		this.strSlNoflg = strSlNoflg;
	}
	public String getStrThirdPartyFlag() {
		return strThirdPartyFlag;
	}
	public void setStrThirdPartyFlag(String strThirdPartyFlag) {
		this.strThirdPartyFlag = strThirdPartyFlag;
	}
	public String getStrGroupName() {
		return strGroupName;
	}
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}
	public String getStrReqNo() {
		return strReqNo;
	}
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrGroupValues() {
		return strGroupValues;
	}
	public void setStrGroupValues(String strGroupValues) {
		this.strGroupValues = strGroupValues;
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
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrInstituteCode() {
		return strInstituteCode;
	}
	public void setStrInstituteCode(String strInstituteCode) {
		this.strInstituteCode = strInstituteCode;
	}
	public String getStrInstituteValues() {
		return strInstituteValues;
	}
	public void setStrInstituteValues(String strInstituteValues) {
		this.strInstituteValues = strInstituteValues;
	}
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	public String getStrItemCatValues() {
		return strItemCatValues;
	}
	public void setStrItemCatValues(String strItemCatValues) {
		this.strItemCatValues = strItemCatValues;
	}
	public String getStrGroupIdForItemSearch() {
		return strGroupIdForItemSearch;
	}
	public void setStrGroupIdForItemSearch(String strGroupIdForItemSearch) {
		this.strGroupIdForItemSearch = strGroupIdForItemSearch;
	}
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}
	public String[] getStrQty() {
		return strQty;
	}
	public void setStrQty(String[] strQty) {
		this.strQty = strQty;
	}
	public String[] getStrUnitName() {
		return strUnitName;
	}
	public void setStrUnitName(String[] strUnitName) {
		this.strUnitName = strUnitName;
	}
	public String[] getItemParamValue() {
		return itemParamValue;
	}
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}
	public String[] getStrReqDate() {
		return strReqDate;
	}
	public void setStrReqDate(String[] strReqDate) {
		this.strReqDate = strReqDate;
	}
	public String getStrReqStatus() {
		return strReqStatus;
	}
	public void setStrReqStatus(String strReqStatus) {
		this.strReqStatus = strReqStatus;
	}
	public String getStrItemDtls() {
		return strItemDtls;
	}
	public void setStrItemDtls(String strItemDtls) {
		this.strItemDtls = strItemDtls;
	}
	public String getStrReqDateView() {
		return strReqDateView;
	}
	public void setStrReqDateView(String strReqDateView) {
		this.strReqDateView = strReqDateView;
	}
	public String getStrIssueDate() {
		return strIssueDate;
	}
	public String getStrIssueDateView() {
		return strIssueDateView;
	}
	public String getStrSancDate() {
		return strSancDate;
	}
	public String getStrSancDateView() {
		return strSancDateView;
	}
	public void setStrIssueDate(String strIssueDate) {
		this.strIssueDate = strIssueDate;
	}
	public void setStrIssueDateView(String strIssueDateView) {
		this.strIssueDateView = strIssueDateView;
	}
	public void setStrSancDate(String strSancDate) {
		this.strSancDate = strSancDate;
	}
	public void setStrSancDateView(String strSancDateView) {
		this.strSancDateView = strSancDateView;
	}
	public String[] getItemUserValue() {
		return itemUserValue;
	}
	public void setItemUserValue(String[] itemUserValue) {
		this.itemUserValue = itemUserValue;
	}
	public String[] getItemCalcValue() {
		return itemCalcValue;
	}
	public void setItemCalcValue(String[] itemCalcValue) {
		this.itemCalcValue = itemCalcValue;
	}
	public String getStrApprovalDtls() {
		return strApprovalDtls;
	}
	public void setStrApprovalDtls(String strApprovalDtls) {
		this.strApprovalDtls = strApprovalDtls;
	}
	
}
