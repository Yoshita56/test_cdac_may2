package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

public class CondemnationRequestForNonConsumTransFB extends ActionForm  {
	
private static final long serialVersionUID = 02L;
	
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "";
	private String strErrMsg = "";

	private String strHospitalCode = "";
	private String strGroupId = "";
	private String strCtDate = "";
	private String strSeatId = "";
	private String strToStoreCombo ="";
	/********Trans Variable Start from here*********/
	private String strPath ="";
	private String strApproxAmt ="";
	private String strStoreId="";
	private String strStoreTypeId ="";
	private String strItemCatNo="";
	private String strIndentTypeId="";
	private String strItemCategory="";
	private String strGroupIdForItemSearch ="";
	private String strStoreName="";
	private String strItemCatName="";
	private String strReqDate="";
	private String strIndentTypeCombo ="";
	private String strItemTypeCombo="";
	private String strReqType="";	
	private String strTmpStoreId ="";
	private String strTmpStoreTypeId ="";
	private String strTmpItemCatg = "";
	private String strTmpReqType="";
	
	private String[] itemParamValue = {""};
	private String[] strCondemnationQty ={""};
	private String[] strUnitName={""};
	private String strRemarks = "";
	private String strCostRequired="0";
	
	/**
	 * @return the strCostRequired
	 */
	public String getStrCostRequired() {
		return strCostRequired;
	}
	/**
	 * @param strCostRequired the strCostRequired to set
	 */
	public void setStrCostRequired(String strCostRequired) {
		this.strCostRequired = strCostRequired;
	}
	public String getStrTmpStoreId() {
		return strTmpStoreId;
	}
	public void setStrTmpStoreId(String strTmpStoreId) {
		this.strTmpStoreId = strTmpStoreId;
	}
	public String getStrTmpStoreTypeId() {
		return strTmpStoreTypeId;
	}
	public void setStrTmpStoreTypeId(String strTmpStoreTypeId) {
		this.strTmpStoreTypeId = strTmpStoreTypeId;
	}
	public String getStrTmpItemCatg() {
		return strTmpItemCatg;
	}
	public void setStrTmpItemCatg(String strTmpItemCatg) {
		this.strTmpItemCatg = strTmpItemCatg;
	}
	public String getStrTmpReqType() {
		return strTmpReqType;
	}
	public void setStrTmpReqType(String strTmpReqType) {
		this.strTmpReqType = strTmpReqType;
	}
	
	public String[] getItemParamValue() {
		return itemParamValue;
	}
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}
	public String[] getStrCondemnationQty() {
		return strCondemnationQty;
	}
	public void setStrCondemnationQty(String[] strCondemnationQty) {
		this.strCondemnationQty = strCondemnationQty;
	}
	public String[] getStrUnitName() {
		return strUnitName;
	}
	public void setStrUnitName(String[] strUnitName) {
		this.strUnitName = strUnitName;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	/************Trans Variable End Here**********/
	public String getStrItemTypeCombo() {
		return strItemTypeCombo;
	}
	public void setStrItemTypeCombo(String strItemTypeCombo) {
		this.strItemTypeCombo = strItemTypeCombo;
	}
	public String getStrReqDate() {
		return strReqDate;
	}
	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
	}
	public String getStrIndentTypeCombo() {
		return strIndentTypeCombo;
	}
	public void setStrIndentTypeCombo(String strIndentTypeCombo) {
		this.strIndentTypeCombo = strIndentTypeCombo;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrGroupIdForItemSearch() {
		return strGroupIdForItemSearch;
	}
	public void setStrGroupIdForItemSearch(String strGroupIdForItemSearch) {
		this.strGroupIdForItemSearch = strGroupIdForItemSearch;
	}
	public String getStrItemCategory() {
		return strItemCategory;
	}
	public void setStrItemCategory(String strItemCategory) {
		this.strItemCategory = strItemCategory;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	public String getStrIndentTypeId() {
		return strIndentTypeId;
	}
	public void setStrIndentTypeId(String strIndentTypeId) {
		this.strIndentTypeId = strIndentTypeId;
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
	public String getStrGroupId() {
		return strGroupId;
	}
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
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
	public String getStrItemCatName() {
		return strItemCatName;
	}
	public void setStrItemCatName(String strItemCatName) {
		this.strItemCatName = strItemCatName;
	}
	public String getStrReqType() {
		return strReqType;
	}
	public void setStrReqType(String strReqType) {
		this.strReqType = strReqType;
	}
	public String getStrToStoreCombo() {
		return strToStoreCombo;
	}
	public void setStrToStoreCombo(String strToStoreCombo) {
		this.strToStoreCombo = strToStoreCombo;
	}
	public String getStrApproxAmt() {
		return strApproxAmt;
	}
	public void setStrApproxAmt(String strApproxAmt) {
		this.strApproxAmt = strApproxAmt;
	}
	public String getStrPath() {
		return strPath;
	}
	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}


}
