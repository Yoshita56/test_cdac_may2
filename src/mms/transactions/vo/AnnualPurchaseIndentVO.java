package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;

public class AnnualPurchaseIndentVO implements TransferObject 
{
	private static final long serialVersionUID = 02L;
	private String strErr = "";
	private String strWarning = "";
	private String strNormalMsg = "";
    private String strHospitalCode = "";
	private String strGroupId = "";
	private String strCtDate = "";
	private String strSeatId = "";
	private String strMsgString = "";
	private String strMsgType = "0";
    public String getStrCostRequired() {
		return strCostRequired;
	}
	public void setStrCostRequired(String strCostRequired) {
		this.strCostRequired = strCostRequired;
	}
	private String strCostRequired;
	private String strIndentPeriodValue = "";
	private String strIndentPeriodCombo ="";
	private String strUrgentFlg="";
	private String strStoreId = "0";
	private String strToStoreCombo = "";
	private String strGrantType = "";
	private String strGrantTypeCombo = "";
	private String strItemCatg = "";
	private String strItemCatgCombo = "";
	private String strStoreName = "";
	private String strToStore ="";
	private String strReqDate ="";
	private String strGroupIdForItemSearch="";
	private String strRemarks = "";
	private String strIsNormal = ""; 
	private String strIsUrgent  = "";
	private String strCrNo ="";
	private String strIndentPeriod = "0";
	private String  strStoreTypeId="";
	private String  strReqType = "";
	private String  strItemCategoryNo ="";
	private String  strRecmndBy ="";
	private String  strRecmndByCombo="";
	private String  strPatientDemDtl="";
	private String  strItemType = "";
	private String  strItemTypeCombo ="";
	private String strApproxAmt = "";
	private String[] itemParamValue = {""};
	private String[] strReqQty ={""};
	private String[] strUnitName={""};
	private String[] strCost={"0"};
	private String strFinancialStartYear ="";
	private String strFinancialEndYear="";
	private String strIndentNo;
	private WebRowSet naDrugsDetailsWs = null;
    private String[] naDrugPK = {""};
	
	public String[] getNaDrugPK() {
		return naDrugPK;
	}
	public void setNaDrugPK(String[] naDrugPK) {
		this.naDrugPK = naDrugPK;
	}
	
	
	public WebRowSet getNaDrugsDetailsWs() {
		return naDrugsDetailsWs;
	}
	public void setNaDrugsDetailsWs(WebRowSet naDrugsDetailsWs) {
		this.naDrugsDetailsWs = naDrugsDetailsWs;
	}
	public String getStrIndentNo() {
		return strIndentNo;
	}
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
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
	public String[] getItemParamValue() {
		return itemParamValue;
	}
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}
	public String[] getStrReqQty() {
		return strReqQty;
	}
	public void setStrReqQty(String[] strReqQty) {
		this.strReqQty = strReqQty;
	}
	public String[] getStrUnitName() {
		return strUnitName;
	}
	public void setStrUnitName(String[] strUnitName) {
		this.strUnitName = strUnitName;
	}
	public String getStrItemType() {
		return strItemType;
	}
	public void setStrItemType(String strItemType) {
		this.strItemType = strItemType;
	}
	public String getStrItemTypeCombo() {
		return strItemTypeCombo;
	}
	public void setStrItemTypeCombo(String strItemTypeCombo) {
		this.strItemTypeCombo = strItemTypeCombo;
	}
	public String getStrPatientDemDtl() {
		return strPatientDemDtl;
	}
	public void setStrPatientDemDtl(String strPatientDemDtl) {
		this.strPatientDemDtl = strPatientDemDtl;
	}
	public String getStrRecmndBy() {
		return strRecmndBy;
	}
	public void setStrRecmndBy(String strRecmndBy) {
		this.strRecmndBy = strRecmndBy;
	}
	public String getStrRecmndByCombo() {
		return strRecmndByCombo;
	}
	public void setStrRecmndByCombo(String strRecmndByCombo) {
		this.strRecmndByCombo = strRecmndByCombo;
	}
	public String getStrCrNo() {
		return strCrNo;
	}
	public void setStrCrNo(String strCrNo) {
		this.strCrNo = strCrNo;
	}
	public String getStrIsNormal() {
		return strIsNormal;
	}
	public void setStrIsNormal(String strIsNormal) {
		this.strIsNormal = strIsNormal;
	}
	public String getStrIsUrgent() {
		return strIsUrgent;
	}
	public void setStrIsUrgent(String strIsUrgent) {
		this.strIsUrgent = strIsUrgent;
	}
	public String getStrErr() {
		return strErr;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	public String getStrWarning() {
		return strWarning;
	}
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
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
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrToStoreCombo() {
		return strToStoreCombo;
	}
	public void setStrToStoreCombo(String strToStoreCombo) {
		this.strToStoreCombo = strToStoreCombo;
	}
	public String getStrGrantType() {
		return strGrantType;
	}
	public void setStrGrantType(String strGrantType) {
		this.strGrantType = strGrantType;
	}
	public String getStrGrantTypeCombo() {
		return strGrantTypeCombo;
	}
	public void setStrGrantTypeCombo(String strGrantTypeCombo) {
		this.strGrantTypeCombo = strGrantTypeCombo;
	}
	public String getStrItemCatg() {
		return strItemCatg;
	}
	public void setStrItemCatg(String strItemCatg) {
		this.strItemCatg = strItemCatg;
	}
	public String getStrItemCatgCombo() {
		return strItemCatgCombo;
	}
	public void setStrItemCatgCombo(String strItemCatgCombo) {
		this.strItemCatgCombo = strItemCatgCombo;
	}
	public String getStrToStore() {
		return strToStore;
	}
	public void setStrToStore(String strToStore) {
		this.strToStore = strToStore;
	}
	public String getStrReqDate() {
		return strReqDate;
	}
	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
	}
	public String getStrGroupIdForItemSearch() {
		return strGroupIdForItemSearch;
	}
	public void setStrGroupIdForItemSearch(String strGroupIdForItemSearch) {
		this.strGroupIdForItemSearch = strGroupIdForItemSearch;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}
	public String getStrReqType() {
		return strReqType;
	}
	public void setStrReqType(String strReqType) {
		this.strReqType = strReqType;
	}
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}
	public String getStrIndentPeriod() {
		return strIndentPeriod;
	}
	public void setStrIndentPeriod(String strIndentPeriod) {
		this.strIndentPeriod = strIndentPeriod;
	}
	public String[] getStrCost() {
		return strCost;
	}
	public void setStrCost(String[] strCost) {
		this.strCost = strCost;
	}
	public String getStrApproxAmt() {
		return strApproxAmt;
	}
	public void setStrApproxAmt(String strApproxAmt) {
		this.strApproxAmt = strApproxAmt;
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

}
