package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 31/Apr/2009
 * Modif Date : / /2009 
*/
public class RequestForLPPatientVO  implements TransferObject
{ 
	private static final long serialVersionUID = 02L;
	/*********************************/
	private String strErr = "";
	private String strWarning = "";
	private String strNormalMsg = "";
    private String strHospitalCode = "";
	private String strGroupId = "";
	private String strCtDate = "";
	private String strSeatId = "";
	private String strMsgString = "";
	private String strMsgType = "0";
    private String strStoreId = "0";
	/********************************/
    private String strApproxAmt = "";
    private String strUrgentFlg = "";
    private String strIsNormal = ""; 
    private String strIsUrgent  = "";
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
	private String strCrNo ="";
	private String strEmpNo ="0";
	private String StrAdmnNo ="0";
	private String  strDiagnosisType ="";
	private String  strStoreTypeId="";
	private String  strReqType = "";
	private String  strItemCategoryNo ="";
	private String  strRecmndBy ="";
	private String  strRecmndByCombo="";
	private String  strPatientDemDtl="";
	
	private String  strConfigCatCode ="";
	private String  strTmpStoreName ="";
	private String  strTmpCrNo = "";
	private String  strTmpToStore = "";
	private String  strTmpGrantType = "";
	private String  strTmpItemCatg ="";
	
	private String strFinancialStartYear = "";

    private String strFinancialEndYear = "";
    
    private String strBalanceAmount="";
    private String strPatAccountNo="";
    
    private String strBillInt="";
    private String patType="";
    private WebRowSet strItemDetailsWs=null;
    private String strIndentNo;
    
    private String strBSReqNo;
    private String strBillingHiddenValue;
    private String strIsUtilityIndent;
    private String strPatientDepartmentDtls;
    
    
    
    public String getStrPatientDepartmentDtls() {
		return strPatientDepartmentDtls;
	}
	public void setStrPatientDepartmentDtls(String strPatientDepartmentDtls) {
		this.strPatientDepartmentDtls = strPatientDepartmentDtls;
	}
	public String getStrIsUtilityIndent() {
		return strIsUtilityIndent;
	}
	public void setStrIsUtilityIndent(String strIsUtilityIndent) {
		this.strIsUtilityIndent = strIsUtilityIndent;
	}
    public String getStrBillingHiddenValue() {
		return strBillingHiddenValue;
	}
	public void setStrBillingHiddenValue(String strBillingHiddenValue) {
		this.strBillingHiddenValue = strBillingHiddenValue;
	}
	private String strDiagCode;
	private String strEmpCode;
	public String getStrDiagCode() {
		return strDiagCode;
	}
	public void setStrDiagCode(String strDiagCode) {
		this.strDiagCode = strDiagCode;
	}
	public String getStrEmpCode() {
		return strEmpCode;
	}
	public void setStrEmpCode(String strEmpCode) {
		this.strEmpCode = strEmpCode;
	}
    
	public String getStrBSReqNo() {
		return strBSReqNo;
	}
	public void setStrBSReqNo(String strBSReqNo) {
		this.strBSReqNo = strBSReqNo;
	}
	public String getStrIndentNo() {
		return strIndentNo;
	}
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}
	public WebRowSet getStrItemDetailsWs() {
		return strItemDetailsWs;
	}
	public void setStrItemDetailsWs(WebRowSet strItemDetailsWs) {
		this.strItemDetailsWs = strItemDetailsWs;
	}
	public String getPatType() {
		return patType;
	}
	public void setPatType(String patType) {
		this.patType = patType;
	}
	public String getStrBillInt() {
		return strBillInt;
	}
	public void setStrBillInt(String strBillInt) {
		this.strBillInt = strBillInt;
	}
	public String getStrPatAccountNo() {
		return strPatAccountNo;
	}
	public void setStrPatAccountNo(String strPatAccountNo) {
		this.strPatAccountNo = strPatAccountNo;
	}
	private WebRowSet HospitalDiagnosisWs = null;
	private WebRowSet Icd10DiagnosisWs = null; 
	private WebRowSet DiagEmpWs = null; 
	
	//added by shalini to get treatment details
	
	public WebRowSet getDiagEmpWs() {
		return DiagEmpWs;
	}
	public void setDiagEmpWs(WebRowSet diagEmpWs) {
		DiagEmpWs = diagEmpWs;
	}
	private WebRowSet TreatmentDetailWs=null;
	private WebRowSet UnitWs=null;
	
	public String getStrBalanceAmount() {
		return strBalanceAmount;
	}
	public void setStrBalanceAmount(String strBalanceAmount) {
		this.strBalanceAmount = strBalanceAmount;
	}
	public WebRowSet getUnitWs() {
		return UnitWs;
	}
	public void setUnitWs(WebRowSet unitWs) {
		UnitWs = unitWs;
	}
	public WebRowSet getTreatmentDetailWs() {
		return TreatmentDetailWs;
	}
	public void setTreatmentDetailWs(WebRowSet treatmentDetailWs) {
		TreatmentDetailWs = treatmentDetailWs;
	}
	private String[] strProvisionDiagnosis={""};
	private String[] itemParamValue = {""};
	private String[] strReqQty ={""};
	private String[] strUnitName={""};
	private String strSearchMode="";
	private String strSearchString="";
	
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
	public String getStrTmpCrNo() {
		return strTmpCrNo;
	}
	public void setStrTmpCrNo(String strTmpCrNo) {
		this.strTmpCrNo = strTmpCrNo;
	}
	public String getStrTmpToStore() {
		return strTmpToStore;
	}
	public void setStrTmpToStore(String strTmpToStore) {
		this.strTmpToStore = strTmpToStore;
	}
	public String getStrTmpGrantType() {
		return strTmpGrantType;
	}
	public void setStrTmpGrantType(String strTmpGrantType) {
		this.strTmpGrantType = strTmpGrantType;
	}
	public String getStrTmpItemCatg() {
		return strTmpItemCatg;
	}
	public void setStrTmpItemCatg(String strTmpItemCatg) {
		this.strTmpItemCatg = strTmpItemCatg;
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
	public String getStrTmpStoreName() {
		return strTmpStoreName;
	}
	public void setStrTmpStoreName(String strTmpStoreName) {
		this.strTmpStoreName = strTmpStoreName;
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
	public WebRowSet getHospitalDiagnosisWs() {
		return HospitalDiagnosisWs;
	}
	public void setHospitalDiagnosisWs(WebRowSet hospitalDiagnosisWs) {
		HospitalDiagnosisWs = hospitalDiagnosisWs;
	}
	public WebRowSet getIcd10DiagnosisWs() {
		return Icd10DiagnosisWs;
	}
	public void setIcd10DiagnosisWs(WebRowSet icd10DiagnosisWs) {
		Icd10DiagnosisWs = icd10DiagnosisWs;
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
	public String getStrConfigCatCode() {
		return strConfigCatCode;
	}
	public void setStrConfigCatCode(String strConfigCatCode) {
		this.strConfigCatCode = strConfigCatCode;
	}
	public String getStrEmpNo() {
		return strEmpNo;
	}
	public void setStrEmpNo(String strEmpNo) {
		this.strEmpNo = strEmpNo;
	}
	public String getStrAdmnNo() {
		return StrAdmnNo;
	}
	public void setStrAdmnNo(String strAdmnNo) {
		StrAdmnNo = strAdmnNo;
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
	public String getStrSearchMode() {
		return strSearchMode;
	}
	public void setStrSearchMode(String strSearchMode) {
		this.strSearchMode = strSearchMode;
	}
	public String getStrSearchString() {
		return strSearchString;
	}
	public void setStrSearchString(String strSearchString) {
		this.strSearchString = strSearchString;
	}

}
