package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 31/Apr/2009
 * Modif Date : / /2009 
*/
public class RequestForLPStaffVO implements TransferObject 
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
  
	private String strApproxAmt ="0";
	private String strStoreId = "0";
	private String strUrgentFlg = "";
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
	private String strAdmnNo="";
	private String  strStoreTypeId="";
	private String  strReqType = "";
	private String  strItemCategoryNo ="";
	private String  strRecmndBy ="";
	private String  strRecmndByCombo="";
	private String  strPatientDemDtl="";
	private String  strDiagnosisType ="";
	private String strFinancialStartYear = "";
    
	private String strTotalCost ="";
	private String strEmpNo="";
	private String strHiddenValue = "";
    private String strFinancialEndYear = "";
	private WebRowSet Icd10DiagnosisWs = null;
	private WebRowSet HospitalDiagnosisWs = null;
	private String[] strProvisionDiagnosis={""};
	private String[] itemParamValue = {""};
	private String[] strReqQty ={""};
	private String[] strUnitName={""};
	
	
	
	
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
	public WebRowSet getIcd10DiagnosisWs() {
		return Icd10DiagnosisWs;
	}
	public void setIcd10DiagnosisWs(WebRowSet icd10DiagnosisWs) {
		Icd10DiagnosisWs = icd10DiagnosisWs;
	}
	public WebRowSet getHospitalDiagnosisWs() {
		return HospitalDiagnosisWs;
	}
	public void setHospitalDiagnosisWs(WebRowSet hospitalDiagnosisWs) {
		HospitalDiagnosisWs = hospitalDiagnosisWs;
	}
	public String[] getStrProvisionDiagnosis() {
		return strProvisionDiagnosis;
	}
	public void setStrProvisionDiagnosis(String[] strProvisionDiagnosis) {
		this.strProvisionDiagnosis = strProvisionDiagnosis;
	}
	public String getStrDiagnosisType() {
		return strDiagnosisType;
	}
	public void setStrDiagnosisType(String strDiagnosisType) {
		this.strDiagnosisType = strDiagnosisType;
	}
	public String getStrHiddenValue() {
		return strHiddenValue;
	}
	public void setStrHiddenValue(String strHiddenValue) {
		this.strHiddenValue = strHiddenValue;
	}
	public String getStrEmpNo() {
		return strEmpNo;
	}
	public void setStrEmpNo(String strEmpNo) {
		this.strEmpNo = strEmpNo;
	}
	public String getStrTotalCost() {
		return strTotalCost;
	}
	public void setStrTotalCost(String strTotalCost) {
		this.strTotalCost = strTotalCost;
	}
	public String getStrAdmnNo() {
		return strAdmnNo;
	}
	public void setStrAdmnNo(String strAdmnNo) {
		this.strAdmnNo = strAdmnNo;
	}
	public String getStrUrgentFlg() {
		return strUrgentFlg;
	}
	public void setStrUrgentFlg(String strUrgentFlg) {
		this.strUrgentFlg = strUrgentFlg;
	}
	public String getStrApproxAmt() {
		return strApproxAmt;
	}
	public void setStrApproxAmt(String strApproxAmt) {
		this.strApproxAmt = strApproxAmt;
	}

}
