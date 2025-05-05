package mms.transactions.controller.fb;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;

public class IssueToPatientBarCodeTransFB extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strErrMsg = "";
	private String strWarningMsg = "";
	private String strNormalMsg = "";
	private String  strflg= "";
	private String  newreqflg= "";
	private String strMsgType="";
	private String strMultiRowBatch="";
	
	
	
	private String strConfCatCode = "";
	
	private String strItemName = "";
	private String strIssueQtyUnit = "";
	private String strRateQtyUnit = "";
	private String strCost = "";
	
	private String strIssueNo = "";
	private String strIssueDate = "";
	private String strIssueDtl = "";
	private String strEpisodeCode;
	
	public String getStrEpisodeCode() {
		return strEpisodeCode;
	}

	public void setStrEpisodeCode(String strEpisodeCode) {
		this.strEpisodeCode = strEpisodeCode;
	}

	private String strCtDate = "";
	private String strDeptCode ="";
	private String strDeptName ="";
	private String strUnitCode = "";
	private String strPrescribedBy = "";
	private String strPrescribedFor = "";
	private String strPrescriptionDate = "";
	private String strPrescriptionFrom = "";
	
	private String strRequestNo = "0";
	private String strCrNo = "";
	private String crNo = "";
	
	private String StrCrNumber = "";
	private String storeName = "";
	private String itemCatName = "";
	private String strId = "";
	private String itemCategory = "";
	private String disFlag = "0";
	private String strMode = "";
	private String strInvalidCrFlag="0";
	private String strIssueNum= "0";
	private String strPatientDetails = "";
	private String strPatientDetailsNew = "";
	private String strRequestDetails = "";
	private String strHospitalName="";
	private String strPatientTypeCmbValues="";
	private String strReOrderFlgColor="";
	
	private String strPatientHiddenValue1="NA^NA^0^NA^0";    //    Patient Name ^    Father Name    ^    Category Code   ^    Address       ^     Mlc No
	private String strTotalCost="";
	private String strStoreId;
	private String strStoreValues = "";
	private String strCatValues="";
	public String getStrCatValues() {
		return strCatValues;
	}

	public void setStrCatValues(String strCatValues) {
		this.strCatValues = strCatValues;
	}

	private String strGroupValues = "";
	private String strReqValues = "";
	private String strDeptValues = "";
	private String strFrequencyValues = "";
	private String strDosageValues = "";
	private String strItemDetails = "";
	private String strIssueMode = "0";
	private String strIsUpdateOpdDrugReq = "";
	private String strRemarks = "";
	private String strReceiveBy = "";
	private String[] strCostFinal = null;
	private String strApproxAmt = "";
	private String strReqTypeId = "";
	private String strReqDate = "";
	private String strPatientDtlHidVal = "";
	private String strAdmissionDtlHidVal = "";
	private String[] strIssueQty = null;
	private String[] strReqQty = null;
	private String[] strHidDivId = null;
	private String[] strAvlQty =null;
	private String[] strHidValue = null;
	private String[] strIssueUnitId = null;
	private String[] itemParamValue =null;
	private String[] strUnitName = null;
	private String[] itemUserValue = null;
	private String[] strQtyText ={"0"};
	
	private String[] strNotInListDrugName ={""};
	private String[] strNotInListDrugQty ={""};
	private String[] strPrescQty={""};
	
 	
	private String[] strDose = null;
	private String[] strDays = null;
	private String[] strFrequency = null;
	private String[] strHiddenDosageFreq = null;
	
	private String[] strRadioOnlineReqVal = null;
	
	private String strHidReqVal="";
	private String strVisitDtl = "1";
	private String strItemCatCombp="";
	private String strWithoutCrNoCheckBox;
	private String strWithOutCrNoFlg;
	private String strCrNoDefault;
    private String strDoseFrqFlg;
    private String strItemCat;
    
    
	//Patient Details
	private String strPatientId;
	private String strPatientType;
	private String strPatientName;
	private String strPatientAge;
	private String strPatientAgeUnit;
    private String strPatientFatherName;
	private String strPatientGenderCode;
	private String strPatientGenderCodeCmbValues;
    private String strPatientAddress;
    private String strStoreName = "";
    private String strFinalRemarks;
    private String strItemWiseCost;
    private String strBudget;
    private String strIndentNo="0";
    private String strIndentDate="";
    private String strUnitValues="";
    private String strFromDate="";
    private String strToDate="";
    private String strItemCatgCombo="";
    private String strRecommendNameCombo="";
    private String strPatientDetail="";
    private String strPrevIssueDrugList="";
    
    private String[] strBatch= null;
    private String[] strSalePrice= null;
    private String[] strExpDate= null;
    private String strItemNameValues ="";
    private String strMultiRowItemId;
    private String strBarCodeBrandId="";
    private String strBarCodeBatch="";
    private String strIssueTo = "";
    private String strItemCategoryId = "0";
    private String strIssuingStoreId="0";
    private String strViewChk;
    private String strIssueBy="";
    private String strFirstName;
    private String strMiddleName;
    private String strLastName;
    private String strOutOfStockFlag="0";
    private String strByCurrentDate;
    private String strByBackDate;
    private String strByCurrentAndDate;
    private String strFlagVal;
    private String strCancelCheckBox;
    private String strDrugIssueDate;
    private WebRowSet WsCancelIssueDtl=null;
    private String[] strItemBrandId;
    private String[] strBatchNo;
    private String[] strIssueChkIndex;
    private String strDDCName;
    private String strItemCatgName;
    private String strHindiText="";
    private String strRegNo;
    private String strVocherHLPString;
    private String strPatientTreatmentDtl;
    private String strLFAccountNo;
    private String strLFAccountOpenDate;
   

	private String strLFDepositedAmount;
    private String strLFBalanceAmount;
    private String strLFAccountStatus;
	private String strTotalCostText;
    private String strCRorLFwise="";
    private String strLFNo="";
    private String strInvalidLFFlag="";
    private String strPath;
    private String strPatientDiagDetails="";
    private String strPatientTreatmentDtl_BS="";

    private String strDiagCode;
    private String strEmpCode;
    private String strCatGrp;
    private String strVisitType;
    private String[] strHlpBillDtl;
    private String strHlpIssueNo;
    private String strCatgoryCode;
    private String storeId;
    private String printReq="0";
    private String strLocDL="0@0";
    private String  strHiddenIssueNo= "";
    private String strBillingHiddenValue;
    private String strRequestType="";
    private WebRowSet strRequestTypeValues=null;
    private String strPayMode="";
    private String strPayDtl="";
    private String strPayModeValues="";
    private String strNetCost="";
    private String strOffLineEpisode="";
    private String strOffLineEpisodeValues="";
    private String strPrintBill="";
    private String isOpenPopUp="";
    private String strAdmDtl="";
    private String strPatStatus="";
    private String strOnlineTreatment = "";
    
    private String strRowCount = "";
	private String strHiddenPatDtl="";
	private String StrPatientDtl="";
	private String strAfterSaveVoucher="";
	/*  Report Print   */
    private String[] itemnames 		= {""};
	private String[] items 			= {""};	
	private String[] batchno 		= {""};
	private String[] mfgdate 		= {""};
	private String[] expdate 		= {""};
	private String[] avlqty    	    = {""};
	private String[] issueqty 		= {""};
	private String[] index 		    = {""};

 
    
    

	public String getStrBarCodeBrandId() {
		return strBarCodeBrandId;
	}
	public void setStrBarCodeBrandId(String strBarCodeBrandId) {
		this.strBarCodeBrandId = strBarCodeBrandId;
	}
	public String getStrBarCodeBatch() {
		return strBarCodeBatch;
	}
	public void setStrBarCodeBatch(String strBarCodeBatch) {
		this.strBarCodeBatch = strBarCodeBatch;
	}

   
	
	public String getStrMultiRowItemId() {
		return strMultiRowItemId;
	}

	public void setStrMultiRowItemId(String strMultiRowItemId) {
		this.strMultiRowItemId = strMultiRowItemId;
	}

	public String getStrItemNameValues() {
		return strItemNameValues;
	}

	public void setStrItemNameValues(String strItemNameValues) {
		this.strItemNameValues = strItemNameValues;
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

	public String getStrMultiRowBatch() {
		return strMultiRowBatch;
	}

	public void setStrMultiRowBatch(String strMultiRowBatch) {
		this.strMultiRowBatch = strMultiRowBatch;
	}

	public String getStrMsgType() {
		return strMsgType;
	}

	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	public String getNewreqflg() {
		return newreqflg;
	}

	public void setNewreqflg(String newreqflg) {
		this.newreqflg = newreqflg;
	}
    
    public String getStrPrevIssueDrugList() {
		return strPrevIssueDrugList;
	}

	public void setStrPrevIssueDrugList(String strPrevIssueDrugList) {
		this.strPrevIssueDrugList = strPrevIssueDrugList;
	}

	public String getStrPatientDetail() {
		return strPatientDetail;
	}

	public void setStrPatientDetail(String strPatientDetail) {
		this.strPatientDetail = strPatientDetail;
	}

	public String getStrRecommendNameCombo() {
		return strRecommendNameCombo;
	}

	public void setStrRecommendNameCombo(String strRecommendNameCombo) {
		this.strRecommendNameCombo = strRecommendNameCombo;
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

	public String getStrItemCatgCombo() {
		return strItemCatgCombo;
	}

	public void setStrItemCatgCombo(String strItemCatgCombo) {
		this.strItemCatgCombo = strItemCatgCombo;
	}

	public String getStrUnitValues() {
		return strUnitValues;
	}

	public void setStrUnitValues(String strUnitValues) {
		this.strUnitValues = strUnitValues;
	}

	

	public String getStrAfterSaveVoucher() {
		return strAfterSaveVoucher;
	}

	public void setStrAfterSaveVoucher(String strAfterSaveVoucher) {
		this.strAfterSaveVoucher = strAfterSaveVoucher;
	}

	public String getStrPatientDtl() {
		return StrPatientDtl;
	}

	public void setStrPatientDtl(String strPatientDtl) {
		StrPatientDtl = strPatientDtl;
	}

	public String getStrBillingHiddenValue() {
		return strBillingHiddenValue;
	}

	public void setStrBillingHiddenValue(String strBillingHiddenValue) {
		this.strBillingHiddenValue = strBillingHiddenValue;
	}

	public String getStrHiddenIssueNo() {
		return strHiddenIssueNo;
	}

	public void setStrHiddenIssueNo(String strHiddenIssueNo) {
		this.strHiddenIssueNo = strHiddenIssueNo;
	}
    public String getStrLocDL() {
		return strLocDL;
	}

	public void setStrLocDL(String strLocDL) {
		this.strLocDL = strLocDL;
	}

	public String getPrintReq() {
		return printReq;
	}

	public void setPrintReq(String printReq) {
		this.printReq = printReq;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStrCatgoryCode() {
		return strCatgoryCode;
	}

	public void setStrCatgoryCode(String strCatgoryCode) {
		this.strCatgoryCode = strCatgoryCode;
	}

	public String getStrHlpIssueNo() {
		return strHlpIssueNo;
	}

	public String getStrflg() {
		return strflg;
	}

	public void setStrflg(String strflg) {
		this.strflg = strflg;
	}

	public void setStrHlpIssueNo(String strHlpIssueNo) {
		this.strHlpIssueNo = strHlpIssueNo;
	}

	public String[] getStrHlpBillDtl() {
		return strHlpBillDtl;
	}

	public void setStrHlpBillDtl(String[] strHlpBillDtl) {
		this.strHlpBillDtl = strHlpBillDtl;
	}

	public String getStrVisitType() {
		return strVisitType;
	}

	public void setStrVisitType(String strVisitType) {
		this.strVisitType = strVisitType;
	}

	public String getStrCatGrp() {
		return strCatGrp;
	}

	public void setStrCatGrp(String strCatGrp) {
		this.strCatGrp = strCatGrp;
	}

	public String getStrDiagCode() {
		return strDiagCode;
	}

	public void setStrDiagCode(String strDiagCode) {
		this.strDiagCode = strDiagCode;
	}

	
	
	
	public String getStrPatientDetailsNew() {
		return strPatientDetailsNew;
	}

	public void setStrPatientDetailsNew(String strPatientDetailsNew) {
		this.strPatientDetailsNew = strPatientDetailsNew;
	}

	public String getStrEmpCode() {
		return strEmpCode;
	}

	public void setStrEmpCode(String strEmpCode) {
		this.strEmpCode = strEmpCode;
	}

	public String getStrPatientDiagDetails() {
		return strPatientDiagDetails;
	}

	public void setStrPatientDiagDetails(String strPatientDiagDetails) {
		this.strPatientDiagDetails = strPatientDiagDetails;
	}

	public String getStrPath() {
		return strPath;
	}

	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}

	
    
    

    /** The ws issue details. */
	private WebRowSet wsIssueDetails = null;

	
	public WebRowSet getWsIssueDetails() {
		return wsIssueDetails;
	}

	public void setWsIssueDetails(WebRowSet wsIssueDetails) {
		this.wsIssueDetails = wsIssueDetails;
	}
    public String getStrWithOutCrNoFlg() {
		return strWithOutCrNoFlg;
	}
	public void setStrWithOutCrNoFlg(String strWithOutCrNoFlg) {
		this.strWithOutCrNoFlg = strWithOutCrNoFlg;
	}
	public String getStrWithoutCrNoCheckBox() {
		return strWithoutCrNoCheckBox;
	}
	public void setStrWithoutCrNoCheckBox(String strWithoutCrNoCheckBox) {
		this.strWithoutCrNoCheckBox = strWithoutCrNoCheckBox;
	}
	public String getStrVisitDtl() {
		return strVisitDtl;
	}
	public void setStrVisitDtl(String strVisitDtl) {
		this.strVisitDtl = strVisitDtl;
	}
	public String getStrHidReqVal() {
		return strHidReqVal;
	}
	public void setStrHidReqVal(String strHidReqVal) {
		this.strHidReqVal = strHidReqVal;
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
	public String[] getStrHidValue() {
		return strHidValue;
	}
	public void setStrHidValue(String[] strHidValue) {
		this.strHidValue = strHidValue;
	}
	public String[] getStrAvlQty() {
		return strAvlQty;
	}
	public void setStrAvlQty(String[] strAvlQty) {
		this.strAvlQty = strAvlQty;
	}
	public String[] getStrHidDivId() {
		return strHidDivId;
	}
	public void setStrHidDivId(String[] strHidDivId) {
		this.strHidDivId = strHidDivId;
	}
	public String getStrPatientDtlHidVal() {
		return strPatientDtlHidVal;
	}
	public void setStrPatientDtlHidVal(String strPatientDtlHidVal) {
		this.strPatientDtlHidVal = strPatientDtlHidVal;
	}
	public String getStrReqDate() {
		return strReqDate;
	}
	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
	}
	public String getStrReqTypeId() {
		return strReqTypeId;
	}
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
	public String getStrIssueMode() {
		return strIssueMode;
	}
	public void setStrIssueMode(String strIssueMode) {
		this.strIssueMode = strIssueMode;
	}
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	public String getStrStoreValues() {
		return strStoreValues;
	}
	public void setStrStoreValues(String strStoreValues) {
		this.strStoreValues = strStoreValues;
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
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getItemCatName() {
		return itemCatName;
	}
	public void setItemCatName(String itemCatName) {
		this.itemCatName = itemCatName;
	}
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getStrPatientTreatmentDtl_BS() {
		return strPatientTreatmentDtl_BS;
	}

	public void setStrPatientTreatmentDtl_BS(String strPatientTreatmentDtl_BS) {
		this.strPatientTreatmentDtl_BS = strPatientTreatmentDtl_BS;
	}

	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public String getDisFlag() {
		return disFlag;
	}
	public void setDisFlag(String disFlag) {
		this.disFlag = disFlag;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public String getStrCrNo() {
		return strCrNo;
	}
	public void setStrCrNo(String strCrNo) {
		this.strCrNo = strCrNo;
	}
	public String getCrNo() {
		return crNo;
	}
	public void setCrNo(String crNo) {
		this.crNo = crNo;
	}
	public String getStrPatientDetails() {
		return strPatientDetails;
	}
	public void setStrPatientDetails(String strPatientDetails) {
		this.strPatientDetails = strPatientDetails;
	}
	public String getStrConfCatCode() {
		return strConfCatCode;
	}
	public void setStrConfCatCode(String strConfCatCode) {
		this.strConfCatCode = strConfCatCode;
	}
	public String getStrItemName() {
		return strItemName;
	}
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	public String getStrRateQtyUnit() {
		return strRateQtyUnit;
	}
	public void setStrRateQtyUnit(String strRateQtyUnit) {
		this.strRateQtyUnit = strRateQtyUnit;
	}
	public String getStrCost() {
		return strCost;
	}
	public void setStrCost(String strCost) {
		this.strCost = strCost;
	}
	public String getStrIssueQtyUnit() {
		return strIssueQtyUnit;
	}
	public void setStrIssueQtyUnit(String strIssueQtyUnit) {
		this.strIssueQtyUnit = strIssueQtyUnit;
	}
	public String getStrIssueDtl() {
		return strIssueDtl;
	}
	public void setStrIssueDtl(String strIssueDtl) {
		this.strIssueDtl = strIssueDtl;
	}
	public String getStrReqValues() {
		return strReqValues;
	}
	public void setStrReqValues(String strReqValues) {
		this.strReqValues = strReqValues;
	}
	public String getStrRequestNo() {
		return strRequestNo;
	}
	public void setStrRequestNo(String strRequestNo) {
		this.strRequestNo = strRequestNo;
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
	public String getStrPrescribedBy() {
		return strPrescribedBy;
	}
	public void setStrPrescribedBy(String strPrescribedBy) {
		this.strPrescribedBy = strPrescribedBy;
	}
	public String getStrPrescribedFor() {
		return strPrescribedFor;
	}
	public void setStrPrescribedFor(String strPrescribedFor) {
		this.strPrescribedFor = strPrescribedFor;
	}
	public String getStrPrescriptionDate() {
		return strPrescriptionDate;
	}
	public void setStrPrescriptionDate(String strPrescriptionDate) {
		this.strPrescriptionDate = strPrescriptionDate;
	}
	public String getStrPrescriptionFrom() {
		return strPrescriptionFrom;
	}
	public void setStrPrescriptionFrom(String strPrescriptionFrom) {
		this.strPrescriptionFrom = strPrescriptionFrom;
	}
	public String getStrRequestDetails() {
		return strRequestDetails;
	}
	public void setStrRequestDetails(String strRequestDetails) {
		this.strRequestDetails = strRequestDetails;
	}
	public String getStrDeptValues() {
		return strDeptValues;
	}
	public void setStrDeptValues(String strDeptValues) {
		this.strDeptValues = strDeptValues;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrItemDetails() {
		return strItemDetails;
	}
	public void setStrItemDetails(String strItemDetails) {
		this.strItemDetails = strItemDetails;
	}
	
	public String getStrIssueNo() {
		return strIssueNo;
	}
	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
	}
	public String getStrIssueDate() {
		return strIssueDate;
	}
	public void setStrIssueDate(String strIssueDate) {
		this.strIssueDate = strIssueDate;
	}
	
	public String[] getStrIssueUnitId() {
		return strIssueUnitId;
	}
	public void setStrIssueUnitId(String[] strIssueUnitId) {
		this.strIssueUnitId = strIssueUnitId;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrReceiveBy() {
		return strReceiveBy;
	}
	public void setStrReceiveBy(String strReceiveBy) {
		this.strReceiveBy = strReceiveBy;
	}
	public String getStrGroupValues() {
		return strGroupValues;
	}
	public void setStrGroupValues(String strGroupValues) {
		this.strGroupValues = strGroupValues;
	}
	public String getStrAdmissionDtlHidVal() {
		return strAdmissionDtlHidVal;
	}
	public void setStrAdmissionDtlHidVal(String strAdmissionDtlHidVal) {
		this.strAdmissionDtlHidVal = strAdmissionDtlHidVal;
	}
	public String[] getStrIssueQty() {
		return strIssueQty;
	}
	public void setStrIssueQty(String[] strIssueQty) {
		this.strIssueQty = strIssueQty;
	}
	public String[] getStrReqQty() {
		return strReqQty;
	}
	public void setStrReqQty(String[] strReqQty) {
		this.strReqQty = strReqQty;
	}
	public String getStrIssueNum() {
		return strIssueNum;
	}
	public void setStrIssueNum(String strIssueNum) {
		this.strIssueNum = strIssueNum;
	}
	public String getStrIsUpdateOpdDrugReq() {
		return strIsUpdateOpdDrugReq;
	}
	public void setStrIsUpdateOpdDrugReq(String strIsUpdateOpdDrugReq) {
		this.strIsUpdateOpdDrugReq = strIsUpdateOpdDrugReq;
	}
	public String[] getStrRadioOnlineReqVal() {
		return strRadioOnlineReqVal;
	}
	public void setStrRadioOnlineReqVal(String[] strRadioOnlineReqVal) {
		this.strRadioOnlineReqVal = strRadioOnlineReqVal;
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
	public String getStrInvalidCrFlag() {
		return strInvalidCrFlag;
	}
	public void setStrInvalidCrFlag(String strInvalidCrFlag) {
		this.strInvalidCrFlag = strInvalidCrFlag;
	}
	/**
	 * @return the strFrequencyValues
	 */
	public String getStrFrequencyValues() {
		return strFrequencyValues;
	}
	/**
	 * @param strFrequencyValues the strFrequencyValues to set
	 */
	public void setStrFrequencyValues(String strFrequencyValues) {
		this.strFrequencyValues = strFrequencyValues;
	}
	/**
	 * @return the strDosageValues
	 */
	public String getStrDosageValues() {
		return strDosageValues;
	}
	/**
	 * @param strDosageValues the strDosageValues to set
	 */
	public void setStrDosageValues(String strDosageValues) {
		this.strDosageValues = strDosageValues;
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
	public String getStrItemCatCombp() {
		return strItemCatCombp;
	}
	public void setStrItemCatCombp(String strItemCatCombp) {
		this.strItemCatCombp = strItemCatCombp;
	}
	public String getStrCrNoDefault() {
		return strCrNoDefault;
	}
	public void setStrCrNoDefault(String strCrNoDefault) {
		this.strCrNoDefault = strCrNoDefault;
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
	public String getStrPatientGenderCodeCmbValues() {
		return strPatientGenderCodeCmbValues;
	}
	public void setStrPatientGenderCodeCmbValues(
			String strPatientGenderCodeCmbValues) {
		this.strPatientGenderCodeCmbValues = strPatientGenderCodeCmbValues;
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
	public String getStrDoseFrqFlg() {
		return strDoseFrqFlg;
	}
	public void setStrDoseFrqFlg(String strDoseFrqFlg) {
		this.strDoseFrqFlg = strDoseFrqFlg;
	}
	public String[] getItemUserValue() {
		return itemUserValue;
	}
	public void setItemUserValue(String[] itemUserValue) {
		this.itemUserValue = itemUserValue;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrItemCat() {
		return strItemCat;
	}
	public void setStrItemCat(String strItemCat) {
		this.strItemCat = strItemCat;
	}
	public String[] getStrQtyText() {
		return strQtyText;
	}
	public void setStrQtyText(String[] strQtyText) {
		this.strQtyText = strQtyText;
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

	public String getStrIssueTo() {
		return strIssueTo;
	}

	public void setStrIssueTo(String strIssueTo) {
		this.strIssueTo = strIssueTo;
	}

	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}

	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}

	public String getStrIssuingStoreId() {
		return strIssuingStoreId;
	}

	public void setStrIssuingStoreId(String strIssuingStoreId) {
		this.strIssuingStoreId = strIssuingStoreId;
	}

	public String getStrViewChk() {
		return strViewChk;
	}

	public void setStrViewChk(String strViewChk) {
		this.strViewChk = strViewChk;
	}

	public String getStrIssueBy() {
		return strIssueBy;
	}

	public void setStrIssueBy(String strIssueBy) {
		this.strIssueBy = strIssueBy;
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

	public String getStrHospitalName() {
		return strHospitalName;
	}

	public void setStrHospitalName(String strHospitalName) {
		this.strHospitalName = strHospitalName;
	}

	public String getStrPatientTypeCmbValues() {
		return strPatientTypeCmbValues;
	}

	public void setStrPatientTypeCmbValues(String strPatientTypeCmbValues) {
		this.strPatientTypeCmbValues = strPatientTypeCmbValues;
	}

	public String getStrReOrderFlgColor() {
		return strReOrderFlgColor;
	}

	public void setStrReOrderFlgColor(String strReOrderFlgColor) {
		this.strReOrderFlgColor = strReOrderFlgColor;
	}

	public String getStrPatientHiddenValue1() {
		return strPatientHiddenValue1;
	}

	public void setStrPatientHiddenValue1(String strPatientHiddenValue1) {
		this.strPatientHiddenValue1 = strPatientHiddenValue1;
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

	public String getStrCancelCheckBox() {
		return strCancelCheckBox;
	}

	public void setStrCancelCheckBox(String strCancelCheckBox) {
		this.strCancelCheckBox = strCancelCheckBox;
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

	public String[] getStrBatchNo() {
		return strBatchNo;
	}

	public void setStrBatchNo(String[] strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	public String[] getStrIssueChkIndex() {
		return strIssueChkIndex;
	}

	public void setStrIssueChkIndex(String[] strIssueChkIndex) {
		this.strIssueChkIndex = strIssueChkIndex;
	}

	public String getStrDDCName() {
		return strDDCName;
	}

	public void setStrDDCName(String strDDCName) {
		this.strDDCName = strDDCName;
	}

	public String getStrItemCatgName() {
		return strItemCatgName;
	}

	public void setStrItemCatgName(String strItemCatgName) {
		this.strItemCatgName = strItemCatgName;
	}

	public String getStrHindiText() {
		return strHindiText;
	}

	public void setStrHindiText(String strHindiText) {
		this.strHindiText = strHindiText;
	}

	

	public String[] getItemnames() {
		return itemnames;
	}

	public void setItemnames(String[] itemnames) {
		this.itemnames = itemnames;
	}

	public String[] getItems() {
		return items;
	}

	public void setItems(String[] items) {
		this.items = items;
	}

	public String[] getBatchno() {
		return batchno;
	}

	public void setBatchno(String[] batchno) {
		this.batchno = batchno;
	}

	public String[] getMfgdate() {
		return mfgdate;
	}

	public void setMfgdate(String[] mfgdate) {
		this.mfgdate = mfgdate;
	}

	public String[] getExpdate() {
		return expdate;
	}

	public void setExpdate(String[] expdate) {
		this.expdate = expdate;
	}

	public String[] getAvlqty() {
		return avlqty;
	}

	public void setAvlqty(String[] avlqty) {
		this.avlqty = avlqty;
	}

	public String[] getIssueqty() {
		return issueqty;
	}

	public void setIssueqty(String[] issueqty) {
		this.issueqty = issueqty;
	}

	public String[] getIndex() {
		return index;
	}

	public void setIndex(String[] index) {
		this.index = index;
	}

	public String getStrRegNo() {
		return strRegNo;
	}

	public void setStrRegNo(String strRegNo) {
		this.strRegNo = strRegNo;
	}

	public String getStrVocherHLPString() {
		return strVocherHLPString;
	}

	public void setStrVocherHLPString(String strVocherHLPString) {
		this.strVocherHLPString = strVocherHLPString;
	}

	public String getStrPatientTreatmentDtl() {
		return strPatientTreatmentDtl;
	}

	public void setStrPatientTreatmentDtl(String strPatientTreatmentDtl) {
		this.strPatientTreatmentDtl = strPatientTreatmentDtl;
	}

	public String getStrTotalCost() {
		return strTotalCost;
	}

	public void setStrTotalCost(String strTotalCost) {
		this.strTotalCost = strTotalCost;
	}

	
	public String getStrTotalCostText() {
		return strTotalCostText;
	}

	public void setStrTotalCostText(String strTotalCostText) {
		this.strTotalCostText = strTotalCostText;
	}
	
	public String getStrCRorLFwise() {
		return strCRorLFwise;
	}

	public void setStrCRorLFwise(String strCRorLFwise) {
		this.strCRorLFwise = strCRorLFwise;
	}


	public String getStrInvalidLFFlag() {
		return strInvalidLFFlag;
	}

	public void setStrInvalidLFFlag(String strInvalidLFFlag) {
		this.strInvalidLFFlag = strInvalidLFFlag;
	}

	public String getStrLFNo() {
		return strLFNo;
	}

	public void setStrLFNo(String strLFNo) {
		this.strLFNo = strLFNo;
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

			public String getStrRequestType() {
				return strRequestType;
			}

			public void setStrRequestType(String strRequestType) {
				this.strRequestType = strRequestType;
			}

			public WebRowSet getStrRequestTypeValues() {
				return strRequestTypeValues;
			}

			public void setStrRequestTypeValues(WebRowSet strRequestTypeValues) {
				this.strRequestTypeValues = strRequestTypeValues;
			}

			public String getStrPayMode() {
				return strPayMode;
			}

			public void setStrPayMode(String strPayMode) {
				this.strPayMode = strPayMode;
			}

			public String getStrPayDtl() {
				return strPayDtl;
			}

			public void setStrPayDtl(String strPayDtl) {
				this.strPayDtl = strPayDtl;
			}

			public String getStrPayModeValues() {
				return strPayModeValues;
			}

			public void setStrPayModeValues(String strPayModeValues) {
				this.strPayModeValues = strPayModeValues;
			}

			public String getStrNetCost() {
				return strNetCost;
			}

			public void setStrNetCost(String strNetCost) {
				this.strNetCost = strNetCost;
			}

			public String getStrOffLineEpisode() {
				return strOffLineEpisode;
			}

			public void setStrOffLineEpisode(String strOffLineEpisode) {
				this.strOffLineEpisode = strOffLineEpisode;
			}

			public String getStrOffLineEpisodeValues() {
				return strOffLineEpisodeValues;
			}

			public void setStrOffLineEpisodeValues(String strOffLineEpisodeValues) {
				this.strOffLineEpisodeValues = strOffLineEpisodeValues;
			}

			public String getStrPrintBill() {
				return strPrintBill;
			}

			public void setStrPrintBill(String strPrintBill) {
				this.strPrintBill = strPrintBill;
			}

			public String getIsOpenPopUp() {
				return isOpenPopUp;
			}

			public void setIsOpenPopUp(String isOpenPopUp) {
				this.isOpenPopUp = isOpenPopUp;
			}

			public String getStrAdmDtl() {
				return strAdmDtl;
			}

			public void setStrAdmDtl(String strAdmDtl) {
				this.strAdmDtl = strAdmDtl;
			}

			public String getStrPatStatus() {
				return strPatStatus;
			}

			public void setStrPatStatus(String strPatStatus) {
				this.strPatStatus = strPatStatus;
			}

			public String getStrOnlineTreatment() {
				return strOnlineTreatment;
			}

			public void setStrOnlineTreatment(String strOnlineTreatment) {
				this.strOnlineTreatment = strOnlineTreatment;
			}

			public String getStrRowCount() {
				return strRowCount;
			}

			public void setStrRowCount(String strRowCount) {
				this.strRowCount = strRowCount;
			}
			
			private WebRowSet OnlineTreatmentDtlsWs=null;


			public WebRowSet getOnlineTreatmentDtlsWs() {
				return OnlineTreatmentDtlsWs;
			}

			public void setOnlineTreatmentDtlsWs(WebRowSet onlineTreatmentDtlsWs) {
				OnlineTreatmentDtlsWs = onlineTreatmentDtlsWs;
			}

			public String getStrCrNumber() {
				return StrCrNumber;
			}

			public void setStrCrNumber(String strCrNumber) {
				StrCrNumber = strCrNumber;
			}

			public String getStrHiddenPatDtl() {
				return strHiddenPatDtl;
			}

			public void setStrHiddenPatDtl(String strHiddenPatDtl) {
				this.strHiddenPatDtl = strHiddenPatDtl;
			}

			public String getStrDeptName() {
				return strDeptName;
			}

			public void setStrDeptName(String strDeptName) {
				this.strDeptName = strDeptName;
			}
			
			
			
			
			
		
}
