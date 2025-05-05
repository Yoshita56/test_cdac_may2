package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

public class ThirdPartyIssueReqTransFB extends ActionForm{

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
	private String comboValue = "";
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
	private String strGroupName = "";
	private String strReqDateView = "";
	private String strIssueDate = "";
	private String strIssueDateView = "";
	private String strSancDate = "";
	private String strSancDateView = "";
	private String strReOrderFlgColor;
	private String strThirdPartyName;
	private String strThirdPartyFlag;
	private String strThirdPartyIssueDate;
	private String strReceiveBy;
	
	public String getStrReceiveBy() {
		return strReceiveBy;
	}
	public void setStrReceiveBy(String strReceiveBy) {
		this.strReceiveBy = strReceiveBy;
	}
	public String getStrThirdPartyIssueDate() {
		return strThirdPartyIssueDate;
	}
	public void setStrThirdPartyIssueDate(String strThirdPartyIssueDate) {
		this.strThirdPartyIssueDate = strThirdPartyIssueDate;
	}
	public String getStrThirdPartyFlag() {
		return strThirdPartyFlag;
	}
	public void setStrThirdPartyFlag(String strThirdPartyFlag) {
		this.strThirdPartyFlag = strThirdPartyFlag;
	}
	public String getStrThirdPartyName() {
		return strThirdPartyName;
	}
	public void setStrThirdPartyName(String strThirdPartyName) {
		this.strThirdPartyName = strThirdPartyName;
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
	public String getComboValue() {
		return comboValue;
	}
	public void setComboValue(String comboValue) {
		this.comboValue = comboValue;
	}
	public String getStrReOrderFlgColor() {
		return strReOrderFlgColor;
	}
	public void setStrReOrderFlgColor(String strReOrderFlgColor) {
		this.strReOrderFlgColor = strReOrderFlgColor;
	}
	
}
