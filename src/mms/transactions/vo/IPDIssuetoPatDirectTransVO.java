package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class IPDIssuetoPatDirectTransVO {
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strDeptCode = "0";
	private String strUnitCode = "0";
	private String strItemCat = ""; // in case of search util
	private String strCatCode = "";
	private String strCrNum = "0";
	private String strCrNumber = "0"; // in case of request no
	private String strPatStaffDays = "";
	private String strEpisCode = "0";
	private String strVisitNo = "0";
	private String strMsgType = "";
	private String strMsgString = "";
	private String strFromDate="";
	private String strToDate="";
	private String strEpisodeCode;
	private String strDeptName ="";

	
	private String strMode = "";
	private String strIssueNo = "";
	private String strRequestNo = "";
	private String strStoreId = "";
	private String strReqTypeId = "";
	private String strReqType = "";
	private String strOnlineIssueReqDays = "";
	private String strConfCatCode = "";
	private String strIssueUnitId ="";
	private String[] strQtyText ={"0"};
	private String strPatientHiddenValue1="NA^NA^0^NA^0";    // Patient Name ^ Father Name ^ Category Code ^ Address  ^  Mlc No
	
	private WebRowSet strStoreWs = null;
	private WebRowSet strItemCatWs = null;
	private WebRowSet strIssueDetailWs = null;
	private WebRowSet strIssueDtlPopUpWs = null;
	private WebRowSet strRequestWs = null;
	private WebRowSet strRequestDetailWs = null;
	private WebRowSet strDepartmentWs = null;
	private WebRowSet strUnitWs = null;
	private WebRowSet strConsultantWs = null;
	private WebRowSet strItemDetailWs = null;
	private WebRowSet strIssueUnitWs = null;
	private WebRowSet strGroupWs = null;
	private WebRowSet strFrequencyWs = null;
	private WebRowSet strDosageWs = null;
	private WebRowSet strGenderWs;
	private WebRowSet strPatientTypeWs;
	private WebRowSet WsCancelIssueDtl=null;
	private WebRowSet Wsissuetopatcount=null;
	private String strAdmissionDtlHidVal;
	private String strBillingHiddenValue;
	private WebRowSet strPayMode=null;
	private WebRowSet strReqTypeWs=null;
	private String strRequestType="";
	private String strPayModeVal="";
	private String strNetCost="";
	private WebRowSet strOffLineEpisodeValues=null;
	private WebRowSet strPrescFormValues=null;
	private String strInvalidCrFlag;

	private WebRowSet issuedItemDtlWS=null;
	private WebRowSet patAccountDtl=null;
	
	private String strLogoName ="";
	private String strUserName ="";
	private String strItemCategoryCmb;
	private String strItemCagID="";

    private WebRowSet issueNoDtlWs;
	
    private WebRowSet recommendNameWS = null;
    
    private String[] strBatch= null;
    private String[] strSalePrice= null;
    private String[] strExpDate= null;
    private String[] strAvlQty =null;
    
    private WebRowSet strBrandItemListWs = null;
    private String strItemNameValues ="";
    private String strMultiRowItemId;
    private String[] itemUserValue =null;
 
    
    

	public String getStrItemNameValues() {
		return strItemNameValues;
	}
	public void setStrItemNameValues(String strItemNameValues) {
		this.strItemNameValues = strItemNameValues;
	}
	public String[] getItemUserValue() {
		return itemUserValue;
	}
	public void setItemUserValue(String[] itemUserValue) {
		this.itemUserValue = itemUserValue;
	}
	public String getStrMultiRowItemId() {
		return strMultiRowItemId;
	}
	public void setStrMultiRowItemId(String strMultiRowItemId) {
		this.strMultiRowItemId = strMultiRowItemId;
	}
	public WebRowSet getStrBrandItemListWs() {
		return strBrandItemListWs;
	}
	public void setStrBrandItemListWs(WebRowSet strBrandItemListWs) {
		this.strBrandItemListWs = strBrandItemListWs;
	}
	public String[] getStrAvlQty() {
		return strAvlQty;
	}
	public void setStrAvlQty(String[] strAvlQty) {
		this.strAvlQty = strAvlQty;
	}
	public String[] getStrBatch() {
		return strBatch;
	}
	public void setStrBatch(String[] strBatch) {
		this.strBatch = strBatch;
	}
	public String[] getStrSalePrice() {
		return strSalePrice;
	}
	public void setStrSalePrice(String[] strSalePrice) {
		this.strSalePrice = strSalePrice;
	}
	public String[] getStrExpDate() {
		return strExpDate;
	}
	public void setStrExpDate(String[] strExpDate) {
		this.strExpDate = strExpDate;
	}
	public WebRowSet getRecommendNameWS() {
		return recommendNameWS;
	}
	public void setRecommendNameWS(WebRowSet recommendNameWS) {
		this.recommendNameWS = recommendNameWS;
	}
	public WebRowSet getIssueNoDtlWs() {
		return issueNoDtlWs;
	}
	public void setIssueNoDtlWs(WebRowSet issueNoDtlWs) {
		this.issueNoDtlWs = issueNoDtlWs;
	}
	public String getStrItemCagID() {
		return strItemCagID;
	}
	public void setStrItemCagID(String strItemCagID) {
		this.strItemCagID = strItemCagID;
	}
	public String getStrItemCategoryCmb() {
		return strItemCategoryCmb;
	}
	public void setStrItemCategoryCmb(String strItemCategoryCmb) {
		this.strItemCategoryCmb = strItemCategoryCmb;
	}
	public String getStrUserName() {
		return strUserName;
	}
	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}
	public String getStrLogoName() {
		return strLogoName;
	}
	public void setStrLogoName(String strLogoName) {
		this.strLogoName = strLogoName;
	}
	private String strPatientDtl="";
	
	public String getStrPatientDtl() {
		return strPatientDtl;
	}

	public void setStrPatientDtl(String strPatientDtl) {
		this.strPatientDtl = strPatientDtl;
	}

	public WebRowSet getIssuedItemDtlWS() {
		return issuedItemDtlWS;
	}

	public void setIssuedItemDtlWS(WebRowSet issuedItemDtlWS) {
		this.issuedItemDtlWS = issuedItemDtlWS;
	}

	public WebRowSet getPatAccountDtl() {
		return patAccountDtl;
	}

	public void setPatAccountDtl(WebRowSet patAccountDtl) {
		this.patAccountDtl = patAccountDtl;
	}

	public String getStrInvalidCrFlag() {
		return strInvalidCrFlag;
	}

	public void setStrInvalidCrFlag(String strInvalidCrFlag) {
		this.strInvalidCrFlag = strInvalidCrFlag;
	}

	private String strBillNo="";
	
	public String getStrPayModeVal() {
		return strPayModeVal;
	}

	public void setStrPayModeVal(String strPayModeVal) {
		this.strPayModeVal = strPayModeVal;
	}

	public String getStrPayDtlVal() {
		return strPayDtlVal;
	}

	public void setStrPayDtlVal(String strPayDtlVal) {
		this.strPayDtlVal = strPayDtlVal;
	}

	private String strPayDtlVal="";
	
	
	public String getStrBillingHiddenValue() {
		return strBillingHiddenValue;
	}

	public void setStrBillingHiddenValue(String strBillingHiddenValue) {
		this.strBillingHiddenValue = strBillingHiddenValue;
	}

	public String getStrAdmissionDtlHidVal() {
		return strAdmissionDtlHidVal;
	}

	public void setStrAdmissionDtlHidVal(String strAdmissionDtlHidVal) {
		this.strAdmissionDtlHidVal = strAdmissionDtlHidVal;
	}

	public WebRowSet getWsissuetopatcount() {
		return Wsissuetopatcount;
	}

	public void setWsissuetopatcount(WebRowSet wsissuetopatcount) {
		Wsissuetopatcount = wsissuetopatcount;
	}

	private String strPatientDtlHidVal = "";
	private String strExceptionType="0";
	
	// insert
	
	private String strIssueNumber = "";
	private String strIssueMode = "";
	private String strFinStartDate = "";
	private String strFinEndDate = "";
	private String strReqDate = "";
	private String strPrescriptionDate = "";
	private String strReceiveBy = "";
	private String strPuk = "";
	private String strRemarks = "";
	private String strAdmNo = "";
	private String strEmpNo = "";
	private String strDescription = "";
	private String strDeptUnitCode = "";
	private String strWardCode = "";
	private String strVisitType = ""; 
	private String strPrescribedBy = "";
	private String strPrescriptionFor = "";
	private String strPrescriptionFrom = "";
	private String[] strCostFinal = null;
	private String strApproxAmt = "";
	
	// when req no is not selected	
	private String strReqDeptCode ="";
	private String strReqUnitCode = "";
	private String strReqPrescribedBy = "";
	private String strReqPrescribedFor = "";
	private String strReqPrescriptionDate = "";
	private String strReqPrescriptionFrom = "";
	private String strReqEmpNo = "";
	private String strReqAdmNo = "";
	private String strReqEpisodeCode = "";
	private String strReqVisitNo = "";
	private String strReqWardCode = "";
	private String strReqPatCatCode = "";
	
	private String[] strReqQty = null;
	private String[] strAvlQtyArray = null;
	private String[] strAvlQtyUnitIdArray = null;
	private String[] strBrandIdArray = null;
	private String[] strItemIdArray = null;
	private String[] strGroupIdArray = null;
	private String[] strSubGroupIdArray = null;
	private String[] strBalQtyUnitId = null;
	private String[] strBalQty = null;
	private String[] strHidDivId = null;
	private String[] strIssueQty = null;
	private String[] strIssUnitId = null;
	private String[] strIssueQtyBaseVal = null;
	private String[] strUnitName = null;
	private String[] itemParamValue =null;
	private String[] strItemNameArray = null;
	
	private String[] strInhandQtyArray=null;
	private String[] strInhandQtyUnitId=null;
	private String[] strExpiryDate=null;
	private String[] strManufDate = null;	
	private String[] strItemSlNo=null;
	private String[] strStockStatusCode=null;	
	private String[] strRate=null;
	private String[] strRateUnitId=null;
	private String[] strDose = null;
	private String[] strDays = null;
	private String[] strFrequency = null;
	private String[] strHiddenDosageFreq = null;	
	private String[] strNotInListDrugName ={""};
	private String[] strNotInListDrugQty ={""};
	private String[] strPrescQty={""};
	//Patient Details
	private String strPatientId;
	private String strPatientType;
	private String strPatientName;
	private String strPatientAge;
	private String strPatientAgeUnit;
    private String strPatientFatherName;
	private String strPatientGenderCode;
    private String strPatientAddress;	
    private String strOrderBy;
    private String strOrderDate;
    
    private String strStoreName = "";
    private String strFinalRemarks;
    private String strItemWiseCost;
    private String strBudget;
    private String strIndentNo="0";
    private String strIndentDate="";
    private String strSlNoflg;
    private String strIssueDate = "0";
    private String strIssueTo = "";
    private String strItemCategoryNo = "0";
    private String strFirstName;
    private String strMiddleName=" ";
    private String strLastName;
    private String strOutOfStockFlag="0";
    private String strByCurrentDate;
    private String strByBackDate;
    private String strByCurrentAndDate;
    private String strFlagVal;
    private String strDrugIssueDate;
    private String[] strItemBrandId;
    private String[] strBatchNo;
    private String[] strIssueChkIndex;
    private String strHospitalName;
    
    private String strVocherHLPString="";

    private String strLFAccountNo ="";
    private String strLFAccountOpenDate ="";
    private String strLFDepositedAmount ="";
    private String strLFBalanceAmount ="";
    private String strLFAccountStatus ="";
    private String strCrNo="";
    private String strLFNo="";
    private WebRowSet WsLFAccountSummary=null;
    private WebRowSet diagEmpWs=null;
    private WebRowSet diagMstWs=null;
    private WebRowSet empWs=null;
    private String strDiagCode;
    private String strEmpCode;
    private WebRowSet strBilledItemDetailWs=null;
    private String[] strHlpBillDtl;
    private String strCatgoryCode;
    private WebRowSet strTariffDtl;
    private WebRowSet strAccDtl;
    private String tariff;
       
    private WebRowSet itemDetailsWS = null;
    
    
	public WebRowSet getItemDetailsWS() {
		return itemDetailsWS;
	}
	public void setItemDetailsWS(WebRowSet itemDetailsWS) {
		this.itemDetailsWS = itemDetailsWS;
	}
	public String getTariff() {
		return tariff;
	}

	public void setTariff(String tariff) {
		this.tariff = tariff;
	}

	public WebRowSet getStrTariffDtl() {
		return strTariffDtl;
	}

	public void setStrTariffDtl(WebRowSet strTariffDtl) {
		this.strTariffDtl = strTariffDtl;
	}

	public String getStrCatgoryCode() {
		return strCatgoryCode;
	}

	public void setStrCatgoryCode(String strCatgoryCode) {
		this.strCatgoryCode = strCatgoryCode;
	}
    
    public String[] getStrHlpBillDtl() {
		return strHlpBillDtl;
	}

	public void setStrHlpBillDtl(String[] strHlpBillDtl) {
		this.strHlpBillDtl = strHlpBillDtl;
	}

	public WebRowSet getStrBilledItemDetailWs() {
		return strBilledItemDetailWs;
	}

	public void setStrBilledItemDetailWs(WebRowSet strBilledItemDetailWs) {
		this.strBilledItemDetailWs = strBilledItemDetailWs;
	}

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

	public WebRowSet getEmpWs() {
		return empWs;
	}

	public void setEmpWs(WebRowSet empWs) {
		this.empWs = empWs;
	}

	public WebRowSet getDiagMstWs() {
		return diagMstWs;
	}

	public void setDiagMstWs(WebRowSet diagMstWs) {
		this.diagMstWs = diagMstWs;
	}

	public WebRowSet getDiagEmpWs() {
		return diagEmpWs;
	}

	public void setDiagEmpWs(WebRowSet diagEmpWs) {
		this.diagEmpWs = diagEmpWs;
	}

	public String getStrLFNo() {
		return strLFNo;
	}

	public void setStrLFNo(String strLFNo) {
		this.strLFNo = strLFNo;
	}

	public String getStrCrNo() {
		return strCrNo;
	}

	public void setStrCrNo(String strCrNo) {
		this.strCrNo = strCrNo;
	}

	public String getStrLFAccountNo() {
		return strLFAccountNo;
	}

	public void setStrLFAccountNo(String strLFAccountNo) {
		this.strLFAccountNo = strLFAccountNo;
	}

	public String getStrLFAccountOpenDate() {
		return strLFAccountOpenDate;
	}

	public void setStrLFAccountOpenDate(String strLFAccountOpenDate) {
		this.strLFAccountOpenDate = strLFAccountOpenDate;
	}

	public String getStrLFDepositedAmount() {
		return strLFDepositedAmount;
	}

	public void setStrLFDepositedAmount(String strLFDepositedAmount) {
		this.strLFDepositedAmount = strLFDepositedAmount;
	}

	public String getStrLFBalanceAmount() {
		return strLFBalanceAmount;
	}

	public void setStrLFBalanceAmount(String strLFBalanceAmount) {
		this.strLFBalanceAmount = strLFBalanceAmount;
	}
	public String getStrLFAccountStatus() {
		return strLFAccountStatus;
	}
	public void setStrLFAccountStatus(String strLFAccountStatus) {
		this.strLFAccountStatus = strLFAccountStatus;
	}

	/** The ws issue details. */
	private WebRowSet wsIssueDetails = null;

	
	public WebRowSet getWsIssueDetails() {
		return wsIssueDetails;
	}

	public void setWsIssueDetails(WebRowSet wsIssueDetails) {
		this.wsIssueDetails = wsIssueDetails;
	}

	public String getStrOrderBy() {
		return strOrderBy;
	}

	public void setStrOrderBy(String strOrderBy) {
		this.strOrderBy = strOrderBy;
	}

	public String getStrOrderDate() {
		return strOrderDate;
	}

	public void setStrOrderDate(String strOrderDate) {
		this.strOrderDate = strOrderDate;
	}

	/**
	 * @return the strHiddenDosageFreq
	 */
	public String[] getStrHiddenDosageFreq() {
		return strHiddenDosageFreq;
	}

	/**
	 * @param strHiddenDosageFreq the strHiddenDosageFreq to set
	 */
	public void setStrHiddenDosageFreq(String[] strHiddenDosageFreq) {
		this.strHiddenDosageFreq = strHiddenDosageFreq;
	}

	/**
	 * @return the strDose
	 */
	public String[] getStrDose() {
		return strDose;
	}

	/**
	 * @param strDose the strDose to set
	 */
	public void setStrDose(String[] strDose) {
		this.strDose = strDose;
	}

	/**
	 * @return the strDays
	 */
	public String[] getStrDays() {
		return strDays;
	}

	/**
	 * @param strDays the strDays to set
	 */
	public void setStrDays(String[] strDays) {
		this.strDays = strDays;
	}

	/**
	 * @return the strFrequency
	 */
	public String[] getStrFrequency() {
		return strFrequency;
	}

	/**
	 * @param strFrequency the strFrequency to set
	 */
	public void setStrFrequency(String[] strFrequency) {
		this.strFrequency = strFrequency;
	}

	public String[] getItemParamValue() {
		return itemParamValue;
	}

	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}

	public String[] getStrIssueQtyBaseVal() {
		return strIssueQtyBaseVal;
	}

	public void setStrIssueQtyBaseVal(String[] strIssueQtyBaseVal) {
		this.strIssueQtyBaseVal = strIssueQtyBaseVal;
	}

	public String[] getStrIssueQty() {
		return strIssueQty;
	}

	public void setStrIssueQty(String[] strIssueQty) {
		this.strIssueQty = strIssueQty;
	}

	public String[] getStrHidDivId() {
		return strHidDivId;
	}

	public void setStrHidDivId(String[] strHidDivId) {
		this.strHidDivId = strHidDivId;
	}

	public String getStrAdmNo() {
		return strAdmNo;
	}

	public void setStrAdmNo(String strAdmNo) {
		this.strAdmNo = strAdmNo;
	}

	public String getStrEmpNo() {
		return strEmpNo;
	}

	public void setStrEmpNo(String strEmpNo) {
		this.strEmpNo = strEmpNo;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String getStrPuk() {
		return strPuk;
	}

	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}

	public String getStrReceiveBy() {
		return strReceiveBy;
	}

	public void setStrReceiveBy(String strReceiveBy) {
		this.strReceiveBy = strReceiveBy;
	}

	public WebRowSet getStrDepartmentWs() {
		return strDepartmentWs;
	}

	public void setStrDepartmentWs(WebRowSet strDepartmentWs) {
		this.strDepartmentWs = strDepartmentWs;
	}

	public WebRowSet getStrIssueDetailWs() {
		return strIssueDetailWs;
	}

	public void setStrIssueDetailWs(WebRowSet strIssueDetailWs) {
		this.strIssueDetailWs = strIssueDetailWs;
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

	public String getStrMsgType() {
		return strMsgType;
	}

	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	public String getStrMsgString() {
		return strMsgString;
	}

	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}

	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
	}

	public String getStrStoreId() {
		return strStoreId;
	}

	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	public String getStrReqTypeId() {
		return strReqTypeId;
	}

	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}

	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}

	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
	}

	public String getStrCatCode() {
		return strCatCode;
	}

	public void setStrCatCode(String strCatCode) {
		this.strCatCode = strCatCode;
	}

	public String getStrCrNum() {
		return strCrNum;
	}

	public void setStrCrNum(String strCrNum) {
		this.strCrNum = strCrNum;
	}

	public WebRowSet getStrIssueDtlPopUpWs() {
		return strIssueDtlPopUpWs;
	}

	public void setStrIssueDtlPopUpWs(WebRowSet strIssueDtlPopUpWs) {
		this.strIssueDtlPopUpWs = strIssueDtlPopUpWs;
	}

	public String getStrIssueNo() {
		return strIssueNo;
	}

	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
	}

	public String getStrConfCatCode() {
		return strConfCatCode;
	}

	public void setStrConfCatCode(String strConfCatCode) {
		this.strConfCatCode = strConfCatCode;
	}

	public WebRowSet getStrRequestWs() {
		return strRequestWs;
	}

	public void setStrRequestWs(WebRowSet strRequestWs) {
		this.strRequestWs = strRequestWs;
	}

	public String getStrCrNumber() {
		return strCrNumber;
	}

	public void setStrCrNumber(String strCrNumber) {
		this.strCrNumber = strCrNumber;
	}

	public String getStrRequestNo() {
		return strRequestNo;
	}

	public void setStrRequestNo(String strRequestNo) {
		this.strRequestNo = strRequestNo;
	}

	public WebRowSet getStrRequestDetailWs() {
		return strRequestDetailWs;
	}

	public void setStrRequestDetailWs(WebRowSet strRequestDetailWs) {
		this.strRequestDetailWs = strRequestDetailWs;
	}

	public WebRowSet getStrUnitWs() {
		return strUnitWs;
	}

	public void setStrUnitWs(WebRowSet strUnitWs) {
		this.strUnitWs = strUnitWs;
	}

	public String getStrDeptCode() {
		return strDeptCode;
	}

	public void setStrDeptCode(String strDeptCode) {
		this.strDeptCode = strDeptCode;
	}

	public String getStrUnitCode() {
		return strUnitCode;
	}

	public void setStrUnitCode(String strUnitCode) {
		this.strUnitCode = strUnitCode;
	}

	public WebRowSet getStrConsultantWs() {
		return strConsultantWs;
	}

	public void setStrConsultantWs(WebRowSet strConsultantWs) {
		this.strConsultantWs = strConsultantWs;
	}

	public WebRowSet getStrItemDetailWs() {
		return strItemDetailWs;
	}

	public void setStrItemDetailWs(WebRowSet strItemDetailWs) {
		this.strItemDetailWs = strItemDetailWs;
	}


	

	public WebRowSet getStrIssueUnitWs() {
		return strIssueUnitWs;
	}

	public void setStrIssueUnitWs(WebRowSet strIssueUnitWs) {
		this.strIssueUnitWs = strIssueUnitWs;
	}

	public WebRowSet getStrGroupWs() {
		return strGroupWs;
	}

	public void setStrGroupWs(WebRowSet strGroupWs) {
		this.strGroupWs = strGroupWs;
	}

	public String getStrItemCat() {
		return strItemCat;
	}

	public void setStrItemCat(String strItemCat) {
		this.strItemCat = strItemCat;
	}

	public String getStrReqType() {
		return strReqType;
	}

	public void setStrReqType(String strReqType) {
		this.strReqType = strReqType;
	}

	public String getStrEpisodeCode() {
		return strEpisodeCode;
	}

	public void setStrEpisodeCode(String strEpisodeCode) {
		this.strEpisodeCode = strEpisodeCode;
	}
	
	public String getStrMode() {
		return strMode;
	}

	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

	public String getStrPatStaffDays() {
		return strPatStaffDays;
	}

	public void setStrPatStaffDays(String strPatStaffDays) {
		this.strPatStaffDays = strPatStaffDays;
	}

	
	public String getStrIssueNumber() {
		return strIssueNumber;
	}

	public void setStrIssueNumber(String strIssueNumber) {
		this.strIssueNumber = strIssueNumber;
	}

	public String getStrIssueMode() {
		return strIssueMode;
	}

	public void setStrIssueMode(String strIssueMode) {
		this.strIssueMode = strIssueMode;
	}

	public String getStrFinStartDate() {
		return strFinStartDate;
	}

	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
	}

	public String getStrFinEndDate() {
		return strFinEndDate;
	}

	public void setStrFinEndDate(String strFinEndDate) {
		this.strFinEndDate = strFinEndDate;
	}

	public String getStrReqDate() {
		return strReqDate;
	}

	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
	}

	public String getStrPrescriptionDate() {
		return strPrescriptionDate;
	}

	public void setStrPrescriptionDate(String strPrescriptionDate) {
		this.strPrescriptionDate = strPrescriptionDate;
	}

	public String[] getStrAvlQtyArray() {
		return strAvlQtyArray;
	}

	public void setStrAvlQtyArray(String[] strAvlQtyArray) {
		this.strAvlQtyArray = strAvlQtyArray;
	}

	public String[] getStrAvlQtyUnitIdArray() {
		return strAvlQtyUnitIdArray;
	}

	public void setStrAvlQtyUnitIdArray(String[] strAvlQtyUnitIdArray) {
		this.strAvlQtyUnitIdArray = strAvlQtyUnitIdArray;
	}

	public String[] getStrBrandIdArray() {
		return strBrandIdArray;
	}

	public void setStrBrandIdArray(String[] strBrandIdArray) {
		this.strBrandIdArray = strBrandIdArray;
	}

	public String[] getStrItemIdArray() {
		return strItemIdArray;
	}

	public void setStrItemIdArray(String[] strItemIdArray) {
		this.strItemIdArray = strItemIdArray;
	}

	public String[] getStrGroupIdArray() {
		return strGroupIdArray;
	}

	public void setStrGroupIdArray(String[] strGroupIdArray) {
		this.strGroupIdArray = strGroupIdArray;
	}

	public String[] getStrSubGroupIdArray() {
		return strSubGroupIdArray;
	}

	public void setStrSubGroupIdArray(String[] strSubGroupIdArray) {
		this.strSubGroupIdArray = strSubGroupIdArray;
	}

	public String[] getStrBalQtyUnitId() {
		return strBalQtyUnitId;
	}

	public void setStrBalQtyUnitId(String[] strBalQtyUnitId) {
		this.strBalQtyUnitId = strBalQtyUnitId;
	}

	public String[] getStrBalQty() {
		return strBalQty;
	}

	public void setStrBalQty(String[] strBalQty) {
		this.strBalQty = strBalQty;
	}

	public String[] getStrIssUnitId() {
		return strIssUnitId;
	}

	public void setStrIssUnitId(String[] strIssUnitId) {
		this.strIssUnitId = strIssUnitId;
	}

	public String getStrIssueUnitId() {
		return strIssueUnitId;
	}

	public void setStrIssueUnitId(String strIssueUnitId) {
		this.strIssueUnitId = strIssueUnitId;
	}

	public String getStrDescription() {
		return strDescription;
	}

	public void setStrDescription(String strDescription) {
		this.strDescription = strDescription;
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
	public String getStrDeptUnitCode() {
		return strDeptUnitCode;
	}

	public void setStrDeptUnitCode(String strDeptUnitCode) {
		this.strDeptUnitCode = strDeptUnitCode;
	}

	public String getStrWardCode() {
		return strWardCode;
	}

	public void setStrWardCode(String strWardCode) {
		this.strWardCode = strWardCode;
	}

	public String getStrVisitType() {
		return strVisitType;
	}

	public void setStrVisitType(String strVisitType) {
		this.strVisitType = strVisitType;
	}

	public String getStrPrescribedBy() {
		return strPrescribedBy;
	}

	public void setStrPrescribedBy(String strPrescribedBy) {
		this.strPrescribedBy = strPrescribedBy;
	}

	public String getStrPrescriptionFor() {
		return strPrescriptionFor;
	}

	public void setStrPrescriptionFor(String strPrescriptionFor) {
		this.strPrescriptionFor = strPrescriptionFor;
	}

	public String getStrPrescriptionFrom() {
		return strPrescriptionFrom;
	}

	public void setStrPrescriptionFrom(String strPrescriptionFrom) {
		this.strPrescriptionFrom = strPrescriptionFrom;
	}

	public String getStrReqDeptCode() {
		return strReqDeptCode;
	}

	public void setStrReqDeptCode(String strReqDeptCode) {
		this.strReqDeptCode = strReqDeptCode;
	}

	public String getStrReqUnitCode() {
		return strReqUnitCode;
	}

	public void setStrReqUnitCode(String strReqUnitCode) {
		this.strReqUnitCode = strReqUnitCode;
	}

	public String getStrReqPrescribedBy() {
		return strReqPrescribedBy;
	}

	public void setStrReqPrescribedBy(String strReqPrescribedBy) {
		this.strReqPrescribedBy = strReqPrescribedBy;
	}

	public String getStrReqPrescribedFor() {
		return strReqPrescribedFor;
	}

	public void setStrReqPrescribedFor(String strReqPrescribedFor) {
		this.strReqPrescribedFor = strReqPrescribedFor;
	}

	public String getStrReqPrescriptionDate() {
		return strReqPrescriptionDate;
	}

	public void setStrReqPrescriptionDate(String strReqPrescriptionDate) {
		this.strReqPrescriptionDate = strReqPrescriptionDate;
	}

	public String getStrReqPrescriptionFrom() {
		return strReqPrescriptionFrom;
	}

	public void setStrReqPrescriptionFrom(String strReqPrescriptionFrom) {
		this.strReqPrescriptionFrom = strReqPrescriptionFrom;
	}

	public String getStrReqEmpNo() {
		return strReqEmpNo;
	}

	public void setStrReqEmpNo(String strReqEmpNo) {
		this.strReqEmpNo = strReqEmpNo;
	}

	public String getStrReqAdmNo() {
		return strReqAdmNo;
	}

	public void setStrReqAdmNo(String strReqAdmNo) {
		this.strReqAdmNo = strReqAdmNo;
	}

	public String getStrReqWardCode() {
		return strReqWardCode;
	}

	public void setStrReqWardCode(String strReqWardCode) {
		this.strReqWardCode = strReqWardCode;
	}

	public String getStrEpisCode() {
		return strEpisCode;
	}

	public void setStrEpisCode(String strEpisCode) {
		this.strEpisCode = strEpisCode;
	}

	public String getStrVisitNo() {
		return strVisitNo;
	}

	public void setStrVisitNo(String strVisitNo) {
		this.strVisitNo = strVisitNo;
	}


	public String getStrReqEpisodeCode() {
		return strReqEpisodeCode;
	}

	public void setStrReqEpisodeCode(String strReqEpisodeCode) {
		this.strReqEpisodeCode = strReqEpisodeCode;
	}

	public String getStrReqVisitNo() {
		return strReqVisitNo;
	}

	public void setStrReqVisitNo(String strReqVisitNo) {
		this.strReqVisitNo = strReqVisitNo;
	}

	public String getStrOnlineIssueReqDays() {
		return strOnlineIssueReqDays;
	}

	public void setStrOnlineIssueReqDays(String strOnlineIssueReqDays) {
		this.strOnlineIssueReqDays = strOnlineIssueReqDays;
	}

	public String[] getStrCostFinal() {
		return strCostFinal;
	}

	public void setStrCostFinal(String[] strCostFinal) {
		this.strCostFinal = strCostFinal;
	}

	public String getStrApproxAmt() {
		return strApproxAmt;
	}

	public void setStrApproxAmt(String strApproxAmt) {
		this.strApproxAmt = strApproxAmt;
	}

	public String getStrReqPatCatCode() {
		return strReqPatCatCode;
	}

	public void setStrReqPatCatCode(String strReqPatCatCode) {
		this.strReqPatCatCode = strReqPatCatCode;
	}

	/**
	 * @return the strFrequencyWs
	 */
	public WebRowSet getStrFrequencyWs() {
		return strFrequencyWs;
	}

	/**
	 * @param strFrequencyWs the strFrequencyWs to set
	 */
	public void setStrFrequencyWs(WebRowSet strFrequencyWs) {
		this.strFrequencyWs = strFrequencyWs;
	}

	/**
	 * @return the strDosageWs
	 */
	public WebRowSet getStrDosageWs() {
		return strDosageWs;
	}

	/**
	 * @param strDosageWs the strDosageWs to set
	 */
	public void setStrDosageWs(WebRowSet strDosageWs) {
		this.strDosageWs = strDosageWs;
	}

	public WebRowSet getStrGenderWs() {
		return strGenderWs;
	}

	public void setStrGenderWs(WebRowSet strGenderWs) {
		this.strGenderWs = strGenderWs;
	}

	public String getStrPatientId() {
		return strPatientId;
	}

	public void setStrPatientId(String strPatientId) {
		this.strPatientId = strPatientId;
	}

	public String getStrPatientType() {
		return strPatientType;
	}

	public void setStrPatientType(String strPatientType) {
		this.strPatientType = strPatientType;
	}

	public String getStrPatientName() {
		return strPatientName;
	}

	public void setStrPatientName(String strPatientName) {
		this.strPatientName = strPatientName;
	}

	public String getStrPatientAge() {
		return strPatientAge;
	}

	public void setStrPatientAge(String strPatientAge) {
		this.strPatientAge = strPatientAge;
	}

	public String getStrPatientAgeUnit() {
		return strPatientAgeUnit;
	}

	public void setStrPatientAgeUnit(String strPatientAgeUnit) {
		this.strPatientAgeUnit = strPatientAgeUnit;
	}

	public String getStrPatientFatherName() {
		return strPatientFatherName;
	}

	public void setStrPatientFatherName(String strPatientFatherName) {
		this.strPatientFatherName = strPatientFatherName;
	}

	public String getStrPatientGenderCode() {
		return strPatientGenderCode;
	}

	public void setStrPatientGenderCode(String strPatientGenderCode) {
		this.strPatientGenderCode = strPatientGenderCode;
	}

	public String getStrPatientAddress() {
		return strPatientAddress;
	}

	public void setStrPatientAddress(String strPatientAddress) {
		this.strPatientAddress = strPatientAddress;
	}

	public String[] getStrBatchNo() {
		return strBatchNo;
	}

	public void setStrBatchNo(String[] strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	public String[] getStrInhandQtyArray() {
		return strInhandQtyArray;
	}

	public void setStrInhandQtyArray(String[] strInhandQtyArray) {
		this.strInhandQtyArray = strInhandQtyArray;
	}

	public String[] getStrInhandQtyUnitId() {
		return strInhandQtyUnitId;
	}

	public void setStrInhandQtyUnitId(String[] strInhandQtyUnitId) {
		this.strInhandQtyUnitId = strInhandQtyUnitId;
	}

	public String[] getStrQtyText() {
		return strQtyText;
	}

	public void setStrQtyText(String[] strQtyText) {
		this.strQtyText = strQtyText;
	}

	public String[] getStrRate() {
		return strRate;
	}

	public void setStrRate(String[] strRate) {
		this.strRate = strRate;
	}

	public String[] getStrRateUnitId() {
		return strRateUnitId;
	}

	public void setStrRateUnitId(String[] strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}

	public String[] getStrExpiryDate() {
		return strExpiryDate;
	}

	public void setStrExpiryDate(String[] strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
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

	public String[] getStrManufDate() {
		return strManufDate;
	}

	public void setStrManufDate(String[] strManufDate) {
		this.strManufDate = strManufDate;
	}

	public String getStrStoreName() {
		return strStoreName;
	}

	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	public String getStrFinalRemarks() {
		return strFinalRemarks;
	}

	public void setStrFinalRemarks(String strFinalRemarks) {
		this.strFinalRemarks = strFinalRemarks;
	}

	public String getStrItemWiseCost() {
		return strItemWiseCost;
	}

	public void setStrItemWiseCost(String strItemWiseCost) {
		this.strItemWiseCost = strItemWiseCost;
	}

	public String getStrBudget() {
		return strBudget;
	}

	public void setStrBudget(String strBudget) {
		this.strBudget = strBudget;
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

	public String getStrSlNoflg() {
		return strSlNoflg;
	}

	public void setStrSlNoflg(String strSlNoflg) {
		this.strSlNoflg = strSlNoflg;
	}

	public String getStrIssueDate() {
		return strIssueDate;
	}

	public void setStrIssueDate(String strIssueDate) {
		this.strIssueDate = strIssueDate;
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

	public String getStrFromDate() {
		return strFromDate;
	}

	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}

	public String getStrToDate() {
		return strToDate;
	}

	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}

	public String getStrFirstName() {
		return strFirstName;
	}

	public void setStrFirstName(String strFirstName) {
		this.strFirstName = strFirstName;
	}

	public String getStrMiddleName() {
		return strMiddleName;
	}

	public void setStrMiddleName(String strMiddleName) {
		this.strMiddleName = strMiddleName;
	}

	public String getStrLastName() {
		return strLastName;
	}

	public void setStrLastName(String strLastName) {
		this.strLastName = strLastName;
	}

	public WebRowSet getStrPatientTypeWs() {
		return strPatientTypeWs;
	}

	public void setStrPatientTypeWs(WebRowSet strPatientTypeWs) {
		this.strPatientTypeWs = strPatientTypeWs;
	}

	public String getStrPatientHiddenValue1() {
		return strPatientHiddenValue1;
	}

	public void setStrPatientHiddenValue1(String strPatientHiddenValue1) {
		this.strPatientHiddenValue1 = strPatientHiddenValue1;
	}

	public String getStrPatientDtlHidVal() {
		return strPatientDtlHidVal;
	}

	public void setStrPatientDtlHidVal(String strPatientDtlHidVal) {
		this.strPatientDtlHidVal = strPatientDtlHidVal;
	}

	public String getStrExceptionType() {
		return strExceptionType;
	}

	public void setStrExceptionType(String strExceptionType) {
		this.strExceptionType = strExceptionType;
	}

	public String[] getStrNotInListDrugName() {
		return strNotInListDrugName;
	}

	public void setStrNotInListDrugName(String[] strNotInListDrugName) {
		this.strNotInListDrugName = strNotInListDrugName;
	}

	public String[] getStrNotInListDrugQty() {
		return strNotInListDrugQty;
	}

	public void setStrNotInListDrugQty(String[] strNotInListDrugQty) {
		this.strNotInListDrugQty = strNotInListDrugQty;
	}

	public String[] getStrPrescQty() {
		return strPrescQty;
	}

	public void setStrPrescQty(String[] strPrescQty) {
		this.strPrescQty = strPrescQty;
	}

	public String getStrOutOfStockFlag() {
		return strOutOfStockFlag;
	}

	public void setStrOutOfStockFlag(String strOutOfStockFlag) {
		this.strOutOfStockFlag = strOutOfStockFlag;
	}

	public String getStrByCurrentDate() {
		return strByCurrentDate;
	}

	public void setStrByCurrentDate(String strByCurrentDate) {
		this.strByCurrentDate = strByCurrentDate;
	}

	public String getStrByBackDate() {
		return strByBackDate;
	}

	public void setStrByBackDate(String strByBackDate) {
		this.strByBackDate = strByBackDate;
	}

	public String getStrByCurrentAndDate() {
		return strByCurrentAndDate;
	}

	public void setStrByCurrentAndDate(String strByCurrentAndDate) {
		this.strByCurrentAndDate = strByCurrentAndDate;
	}

	public String getStrFlagVal() {
		return strFlagVal;
	}

	public void setStrFlagVal(String strFlagVal) {
		this.strFlagVal = strFlagVal;
	}

	public String getStrDrugIssueDate() {
		return strDrugIssueDate;
	}

	public void setStrDrugIssueDate(String strDrugIssueDate) {
		this.strDrugIssueDate = strDrugIssueDate;
	}

	public WebRowSet getWsCancelIssueDtl() {
		return WsCancelIssueDtl;
	}

	public void setWsCancelIssueDtl(WebRowSet wsCancelIssueDtl) {
		WsCancelIssueDtl = wsCancelIssueDtl;
	}

	public String[] getStrItemBrandId() {
		return strItemBrandId;
	}

	public void setStrItemBrandId(String[] strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	public String[] getStrIssueChkIndex() {
		return strIssueChkIndex;
	}

	public void setStrIssueChkIndex(String[] strIssueChkIndex) {
		this.strIssueChkIndex = strIssueChkIndex;
	}

	public String getStrHospitalName() {
		return strHospitalName;
	}

	public void setStrHospitalName(String strHospitalName) {
		this.strHospitalName = strHospitalName;
	}

	public String getStrVocherHLPString() {
		return strVocherHLPString;
	}

	public void setStrVocherHLPString(String strVocherHLPString) {
		this.strVocherHLPString = strVocherHLPString;
	}

	public String[] getStrItemNameArray() {
		return strItemNameArray;
	}

	public void setStrItemNameArray(String[] strItemNameArray) {
		this.strItemNameArray = strItemNameArray;
	}

	public WebRowSet getWsLFAccountSummary() {
		return WsLFAccountSummary;
	}

	public void setWsLFAccountSummary(WebRowSet wsLFAccountSummary) {
		WsLFAccountSummary = wsLFAccountSummary;
	}

	public WebRowSet getStrPayMode() {
		return strPayMode;
	}

	public void setStrPayMode(WebRowSet strPayMode) {
		this.strPayMode = strPayMode;
	}

	public WebRowSet getStrReqTypeWs() {
		return strReqTypeWs;
	}

	public void setStrReqTypeWs(WebRowSet strReqTypeWs) {
		this.strReqTypeWs = strReqTypeWs;
	}

	public String getStrRequestType() {
		return strRequestType;
	}

	public void setStrRequestType(String strRequestType) {
		this.strRequestType = strRequestType;
	}

	public String getStrNetCost() {
		return strNetCost;
	}

	public void setStrNetCost(String strNetCost) {
		this.strNetCost = strNetCost;
	}

	public WebRowSet getStrOffLineEpisodeValues() {
		return strOffLineEpisodeValues;
	}

	public void setStrOffLineEpisodeValues(WebRowSet strOffLineEpisodeValues) {
		this.strOffLineEpisodeValues = strOffLineEpisodeValues;
	}

	public String getStrBillNo() {
		return strBillNo;
	}

	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}
	public WebRowSet getStrPrescFormValues() {
		return strPrescFormValues;
	}

	public void setStrPrescFormValues(WebRowSet strPrescFormValues) {
		this.strPrescFormValues = strPrescFormValues;
	}

	public WebRowSet getStrAccDtl() {
		return strAccDtl;
	}

	public void setStrAccDtl(WebRowSet strAccDtl) {
		this.strAccDtl = strAccDtl;
	}

	private WebRowSet OnlineTreatmentDtlsWs=null;

	private WebRowSet alreadyIssueDrug=null;
	
	public WebRowSet getAlreadyIssueDrug() {
		return alreadyIssueDrug;
	}

	public void setAlreadyIssueDrug(WebRowSet alreadyIssueDrug) {
		this.alreadyIssueDrug = alreadyIssueDrug;
	}

	public WebRowSet getOnlineTreatmentDtlsWs() {
		return OnlineTreatmentDtlsWs;
	}

	public void setOnlineTreatmentDtlsWs(WebRowSet onlineTreatmentDtlsWs) {
		OnlineTreatmentDtlsWs = onlineTreatmentDtlsWs;
	}

	public String getStrDeptName() {
		return strDeptName;
	}

	public void setStrDeptName(String strDeptName) {
		this.strDeptName = strDeptName;
	}
	
	

}