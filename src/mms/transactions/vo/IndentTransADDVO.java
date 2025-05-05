package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

/**
 * @author Amit Kumar
 * Date of Creation : 31/3/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
public class IndentTransADDVO 
{
	private static final long serialVersionUID = 02L;
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "0";
	private String strErrMsg = "";

	private String strHospitalCode = "";
	private String strGroupId = "";
	private String strCtDate = "";
	private String strSeatId = "";
	/********Trans Variable Start from here*********/
	private String strIndentPeriodValue = "";
	private String strIndentPeriodCombo ="";
	private String strUrgentFlg="";
	private String strStoreId="";
	private String strStoreTypeId ="";
	private String strItemCatNo="";
	private String strIndentTypeId="";
	private String strToStoreCombo ="";
	private String strBkgEntryDate ="";
	private String strStoreName = "";
	private String strIndentDate ="";
	private String strIndentType ="";
	private String strItemCategory="";
	private String strIndentPeriod="";
	private String strGroupName ="";
	private String strPath="";
	private WebRowSet GroupWs  =null;
	private String strRemarks = "";
	private String isNormal ="";
	private String isUrgent = "";
	private String strGroupIdForItemSearch = "";
	private String strStoreNameFunc ="";
	private String strIndentTypeFunc="";
	private String strItemCategoryFunc="";
	private String strReqType ="";
	private String[] combo = null;
	private String[] itemParamValue = {""};
	private String[] strUnitName={""};
	private String[] strReqQty={""};
	private	String strFinancialStartYear = "";
	private String strFinancialEndYear = "";
	private String strIndentNo;
	
	//Change Request
	private String strFinancialEndDate;
	private String strFinancialStartDate;
	private String strAvalaibleBudget;
	private String strAvalaibleBudgetDtl;

	private String strMode;
	private String strToStore;
	private WebRowSet strItemDetailsWs = null;
	
private WebRowSet  WsIndentDetails=null;
	
	
	private String strToStoreName="";
	
	private String strIndentTypeName="";
	
	private String strIndentGenByName="";
	
	private String strIndentPeriodName="";
	
	private String strItemCategoryCmb="";
	
	private WebRowSet strBrandItemListWs;
	
	private String[] itemUserValue;
	
	

	public String[] getItemUserValue() {
		return itemUserValue;
	}
	public void setItemUserValue(String[] itemUserValue) {
		this.itemUserValue = itemUserValue;
	}
	public WebRowSet getStrBrandItemListWs() {
		return strBrandItemListWs;
	}
	public void setStrBrandItemListWs(WebRowSet strBrandItemListWs) {
		this.strBrandItemListWs = strBrandItemListWs;
	}
	public String getStrItemCategoryCmb() {
		return strItemCategoryCmb;
	}
	public void setStrItemCategoryCmb(String strItemCategoryCmb) {
		this.strItemCategoryCmb = strItemCategoryCmb;
	}
	public WebRowSet getWsIndentDetails() {
		return WsIndentDetails;
	}
	public void setWsIndentDetails(WebRowSet wsIndentDetails) {
		WsIndentDetails = wsIndentDetails;
	}
	
	
	public String getStrToStoreName() {
		return strToStoreName;
	}
	public void setStrToStoreName(String strToStoreName) {
		this.strToStoreName = strToStoreName;
	}
	public String getStrIndentTypeName() {
		return strIndentTypeName;
	}
	public void setStrIndentTypeName(String strIndentTypeName) {
		this.strIndentTypeName = strIndentTypeName;
	}
	public String getStrIndentGenByName() {
		return strIndentGenByName;
	}
	public void setStrIndentGenByName(String strIndentGenByName) {
		this.strIndentGenByName = strIndentGenByName;
	}
	public String getStrIndentPeriodName() {
		return strIndentPeriodName;
	}
	public void setStrIndentPeriodName(String strIndentPeriodName) {
		this.strIndentPeriodName = strIndentPeriodName;
	}
	
	private String strBSReqNo="";
	public String getStrBSReqNo() {
		return strBSReqNo;
	}
	public void setStrBSReqNo(String strBSReqNo) {
		this.strBSReqNo = strBSReqNo;
	}
	public WebRowSet getStrItemDetailsWs() {
		return strItemDetailsWs;
	}
	public void setStrItemDetailsWs(WebRowSet strItemDetailsWs) {
		this.strItemDetailsWs = strItemDetailsWs;
	}
	public String getStrToStore() {
		return strToStore;
	}
	public void setStrToStore(String strToStore) {
		this.strToStore = strToStore;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public String getStrIndentNo() {
		return strIndentNo;
	}
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}
	public String[] getCombo() {
		return combo;
	}
	public void setCombo(String[] combo) {
		this.combo = combo;
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
	public String getStrBkgEntryDate() {
		return strBkgEntryDate;
	}
	public void setStrBkgEntryDate(String strBkgEntryDate) {
		this.strBkgEntryDate = strBkgEntryDate;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
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
	public String getStrIndentPeriod() {
		return strIndentPeriod;
	}
	public void setStrIndentPeriod(String strIndentPeriod) {
		this.strIndentPeriod = strIndentPeriod;
	}
	public String getStrGroupName() {
		return strGroupName;
	}
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}
	public WebRowSet getGroupWs() {
		return GroupWs;
	}
	public void setGroupWs(WebRowSet groupWs) {
		GroupWs = groupWs;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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

	public String getIsNormal() {
		return isNormal;
	}

	public void setIsNormal(String isNormal) {
		this.isNormal = isNormal;
	}

	public String getIsUrgent() {
		return isUrgent;
	}

	public void setIsUrgent(String isUrgent) {
		this.isUrgent = isUrgent;
	}

	public String getStrGroupIdForItemSearch() {
		return strGroupIdForItemSearch;
	}

	public void setStrGroupIdForItemSearch(String strGroupIdForItemSearch) {
		this.strGroupIdForItemSearch = strGroupIdForItemSearch;
	}

	public String getStrStoreNameFunc() {
		return strStoreNameFunc;
	}

	public void setStrStoreNameFunc(String strStoreNameFunc) {
		this.strStoreNameFunc = strStoreNameFunc;
	}

	public String getStrIndentTypeFunc() {
		return strIndentTypeFunc;
	}

	public void setStrIndentTypeFunc(String strIndentTypeFunc) {
		this.strIndentTypeFunc = strIndentTypeFunc;
	}

	public String getStrItemCategoryFunc() {
		return strItemCategoryFunc;
	}

	public void setStrItemCategoryFunc(String strItemCategoryFunc) {
		this.strItemCategoryFunc = strItemCategoryFunc;
	}

	
	public String[] getStrReqQty() {
		return strReqQty;
	}

	public void setStrReqQty(String[] strReqQty) {
		this.strReqQty = strReqQty;
	}

	public String[] getItemParamValue() {
		return itemParamValue;
	}

	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}

	public String[] getStrUnitName() {
		return strUnitName;
	}

	public void setStrUnitName(String[] strUnitName) {
		this.strUnitName = strUnitName;
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
	public String getStrPath() {
		return strPath;
	}
	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}
	public String getStrUrgentFlg() {
		return strUrgentFlg;
	}
	public void setStrUrgentFlg(String strUrgentFlg) {
		this.strUrgentFlg = strUrgentFlg;
	}
	public String getStrIndentPeriodCombo() {
		return strIndentPeriodCombo;
	}
	public void setStrIndentPeriodCombo(String strIndentPeriodCombo) {
		this.strIndentPeriodCombo = strIndentPeriodCombo;
	}
	public String getStrIndentPeriodValue() {
		return strIndentPeriodValue;
	}
	public void setStrIndentPeriodValue(String strIndentPeriodValue) {
		this.strIndentPeriodValue = strIndentPeriodValue;
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
}
