package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class IssueDtlModificationTransVO 
{
	private static final long serialVersionUID = 02L;
	private String strErr;
	private String strMsg ;
	private String strWarning;
    private String strMsgString;
	private String strMsgType="0";

	private String strHospitalCode;
	private String strSeatId;
	private String strGroupId;
	private String strCtDate;
	/************Variable Start Here******************/
	private String strIssueStoreId;
	private String strFromDate;
	private String strToDate;
	private String strIssueNo;
	private String strIndentStoreCombo;
	private String strItemCategoryCmb;
	private String strStoreName;
	private String isNormal ="0";
	private String strItemCatNo;
	private String strItemCagID;
	private String strStoreId;
	private String strStoreTypeId;
	private String strRemarks; 
	private String strFinancialStartYear;	
	private String strApprovedBy;
	private String strAprovedRemarks;
    private String strApprovedDate;
    private String  strIndentingStoreID;
    private String  strIndentingStoreName;
    private String  strIndentType;
    private String  strIndentPeriodCombo;
    private String  strIndentPeriodValue;
    private String  strIndentNo;
    private String  strIndentDate;
    private String  strReceivedBy;
    private String  strApprovalDate;
    private String  strVerifiedByValues;
    private String  strVerifiedDate;
    private String  strIpAddress;
    private String  strCurrentDate;
    private String strIssueValue;

    private String strFinancialEndYear = "";
    private WebRowSet verifyByWS=null;
	private WebRowSet approvedByWS=null; 
	private WebRowSet itemCatgWS=null;
	private WebRowSet popUpWS=null;
	private WebRowSet issueItemWs;
	private WebRowSet issueNoDtlWs;
	private WebRowSet pendingDemandWS;
	private WebRowSet itemDetailsWS;
	private WebRowSet pendingIndentDemandWS;
	
	private WebRowSet issueNoItemWs;
	
    private String[] itemParamValue = {""};
	private String[] strUnitName={""};

	private String[] strReqQty ={""};
	private String[] strCost={""};
	private String strReqTypeId;
	
	 private String[] strItemDetailsChk ={""};
	 private String[] stockDtlsId ={""};
	
	private String strBudgetFlg;
	private String strDemandActivePrd;
	private String strIsDemandActiveFlag;
	private String strFinancialEndDate;
	private String strFinancialStartDate;
	private String strAvalaibleBudget;
	private String strAvalaibleBudgetDtl;
	//private String strCost;
	private String strFinalApproxAmt;
	
	
	private String strItemCategory;
	private String strRaisingStoreId;
	private String strRaisingStoreName;
	private String strReqStatusName;
	private String strViewItemDtls;
	private String strItemCategoryNo;
	private String strSancUnitId;
    
	private WebRowSet unitComboWS;
	private WebRowSet VoucherComboWS;
	private WebRowSet drugNameComboWS;
	private WebRowSet batchComboWS;	

	private String strItemIdArray[] = null;
	private String strBrandIdArray[] = null;
	private String strReservedFlagArray[] = null;
	private String strRateArray[] = null;
	private String strRateUnitIdArray[] = null;
	
	private String strStochStatusCodeArray[] = null;
	private String strBatchSlNoArray[] = null;
	private String strItemSlNoArray[] = null;
	private String strGroupIdArray[] = null;
	private String strSubGroupIdArray[] = null;
	private String strAvlQtyArray[] = null;
	private String strAvlQtyUnitIdArray[] = null;
	private String strBalQtyArray[] = null;
	private String strBalQtyUnitIdArray[] = null;
	private String strIssueQtyArray[] = null;
	private String strIssueQtyUnitIdArray[] = null;
	private String strManufDateArray[] = null;
	private String strExpiryDateUnitIdArray[] = null;
	private String strConsumableFlagArray[] = null;
	private String strCostArray[] = null;
	private String strRateBaseValArray[] = null;
	
	private String strTmpIssuingStoreId;

	private String strTmpRaisingStoreId;

	private String strIssuingStoreId;
	private String strNewDemandFinalApproxAmt;
	private String strIndentIssueDate;	
	
    private String  strVoucherCombo;
    private String  strVoucherNo;
    private String  strNewVoucherNumber;
	private String strVoucherDate;
	private String strIndentNumber;
	
	
	private String[] strDrugId= null;
	private String strBatchNo ; 
	private String strIssueQty;
	private String[] strUnitId=null;
	private String strOldBatchNo ; 
	private String strOldIssueQty;
	private String[] strNewDrugId={""};
	
	private String strItemBrandId="";
	private String strBatchCombo="";
	private String strBatchNumber="";
	private String strVoucherIndentDate;
	
	private String strTempAvlQty; 
	private String strTempBatchNo;
	private String strMode;
	private String strStockStatusCode;
	private String strIssQty;
	private String strDrugDtls;
	private String strOldStockStatus;
	private String strOldAvlQty;
	private String strIssueDate;
	private String strDrugName;
	
	
	public String getStrDrugName() {
		return strDrugName;
	}
	public void setStrDrugName(String strDrugName) {
		this.strDrugName = strDrugName;
	}
	public String getStrIssueDate() {
		return strIssueDate;
	}
	public void setStrIssueDate(String strIssueDate) {
		this.strIssueDate = strIssueDate;
	}
	public String getStrOldAvlQty() {
		return strOldAvlQty;
	}
	public void setStrOldAvlQty(String strOldAvlQty) {
		this.strOldAvlQty = strOldAvlQty;
	}
	public String getStrOldStockStatus() {
		return strOldStockStatus;
	}
	public void setStrOldStockStatus(String strOldStockStatus) {
		this.strOldStockStatus = strOldStockStatus;
	}
	public String getStrDrugDtls() {
		return strDrugDtls;
	}
	public void setStrDrugDtls(String strDrugDtls) {
		this.strDrugDtls = strDrugDtls;
	}
	public String getStrIssQty() {
		return strIssQty;
	}
	public void setStrIssQty(String strIssQty) {
		this.strIssQty = strIssQty;
	}
	public String getStrStockStatusCode() {
		return strStockStatusCode;
	}
	public void setStrStockStatusCode(String strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public String getStrVoucherIndentDate() {
		return strVoucherIndentDate;
	}
	public void setStrVoucherIndentDate(String strVoucherIndentDate) {
		this.strVoucherIndentDate = strVoucherIndentDate;
	}

	
	public String getStrBatchCombo() {
		return strBatchCombo;
	}
	public void setStrBatchCombo(String strBatchCombo) {
		this.strBatchCombo = strBatchCombo;
	}
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	public String[] getStrNewDrugId() {
		return strNewDrugId;
	}
	public void setStrNewDrugId(String[] strNewDrugId) {
		this.strNewDrugId = strNewDrugId;
	}
	public String getStrOldBatchNo() {
		return strOldBatchNo;
	}
	public void setStrOldBatchNo(String strOldBatchNo) {
		this.strOldBatchNo = strOldBatchNo;
	}
	public String getStrOldIssueQty() {
		return strOldIssueQty;
	}
	public void setStrOldIssueQty(String strOldIssueQty) {
		this.strOldIssueQty = strOldIssueQty;
	}
	public String getStrVoucherDate() {
		return strVoucherDate;
	}
	public void setStrVoucherDate(String strVoucherDate) {
		this.strVoucherDate = strVoucherDate;
	}
	public String getStrIndentNumber() {
		return strIndentNumber;
	}
	public void setStrIndentNumber(String strIndentNumber) {
		this.strIndentNumber = strIndentNumber;
	}
	public String getStrNewVoucherNumber() {
		return strNewVoucherNumber;
	}
	public void setStrNewVoucherNumber(String strNewVoucherNumber) {
		this.strNewVoucherNumber = strNewVoucherNumber;
	}
	public String getStrVoucherCombo() {
		return strVoucherCombo;
	}
	public void setStrVoucherCombo(String strVoucherCombo) {
		this.strVoucherCombo = strVoucherCombo;
	}
	public String getStrVoucherNo() {
		return strVoucherNo;
	}
	public void setStrVoucherNo(String strVoucherNo) {
		this.strVoucherNo = strVoucherNo;
	}
	public String[] getStrItemIdArray() {
		return strItemIdArray;
	}
	public void setStrItemIdArray(String[] strItemIdArray) {
		this.strItemIdArray = strItemIdArray;
	}
	public String[] getStrBrandIdArray() {
		return strBrandIdArray;
	}
	public void setStrBrandIdArray(String[] strBrandIdArray) {
		this.strBrandIdArray = strBrandIdArray;
	}
	public String[] getStrReservedFlagArray() {
		return strReservedFlagArray;
	}
	public void setStrReservedFlagArray(String[] strReservedFlagArray) {
		this.strReservedFlagArray = strReservedFlagArray;
	}
	public String[] getStrRateArray() {
		return strRateArray;
	}
	public void setStrRateArray(String[] strRateArray) {
		this.strRateArray = strRateArray;
	}
	public String[] getStrRateUnitIdArray() {
		return strRateUnitIdArray;
	}
	public void setStrRateUnitIdArray(String[] strRateUnitIdArray) {
		this.strRateUnitIdArray = strRateUnitIdArray;
	}
	public String[] getStrStochStatusCodeArray() {
		return strStochStatusCodeArray;
	}
	public void setStrStochStatusCodeArray(String[] strStochStatusCodeArray) {
		this.strStochStatusCodeArray = strStochStatusCodeArray;
	}
	public String[] getStrBatchSlNoArray() {
		return strBatchSlNoArray;
	}
	public void setStrBatchSlNoArray(String[] strBatchSlNoArray) {
		this.strBatchSlNoArray = strBatchSlNoArray;
	}
	public String[] getStrItemSlNoArray() {
		return strItemSlNoArray;
	}
	public void setStrItemSlNoArray(String[] strItemSlNoArray) {
		this.strItemSlNoArray = strItemSlNoArray;
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
	public String[] getStrBalQtyArray() {
		return strBalQtyArray;
	}
	public void setStrBalQtyArray(String[] strBalQtyArray) {
		this.strBalQtyArray = strBalQtyArray;
	}
	public String[] getStrBalQtyUnitIdArray() {
		return strBalQtyUnitIdArray;
	}
	public void setStrBalQtyUnitIdArray(String[] strBalQtyUnitIdArray) {
		this.strBalQtyUnitIdArray = strBalQtyUnitIdArray;
	}
	public String[] getStrIssueQtyArray() {
		return strIssueQtyArray;
	}
	public void setStrIssueQtyArray(String[] strIssueQtyArray) {
		this.strIssueQtyArray = strIssueQtyArray;
	}
	public String[] getStrIssueQtyUnitIdArray() {
		return strIssueQtyUnitIdArray;
	}
	public void setStrIssueQtyUnitIdArray(String[] strIssueQtyUnitIdArray) {
		this.strIssueQtyUnitIdArray = strIssueQtyUnitIdArray;
	}
	public String[] getStrManufDateArray() {
		return strManufDateArray;
	}
	public void setStrManufDateArray(String[] strManufDateArray) {
		this.strManufDateArray = strManufDateArray;
	}
	public String[] getStrExpiryDateUnitIdArray() {
		return strExpiryDateUnitIdArray;
	}
	public void setStrExpiryDateUnitIdArray(String[] strExpiryDateUnitIdArray) {
		this.strExpiryDateUnitIdArray = strExpiryDateUnitIdArray;
	}
	public String[] getStrConsumableFlagArray() {
		return strConsumableFlagArray;
	}
	public void setStrConsumableFlagArray(String[] strConsumableFlagArray) {
		this.strConsumableFlagArray = strConsumableFlagArray;
	}
	public String[] getStrCostArray() {
		return strCostArray;
	}
	public void setStrCostArray(String[] strCostArray) {
		this.strCostArray = strCostArray;
	}
	public String[] getStrRateBaseValArray() {
		return strRateBaseValArray;
	}
	public void setStrRateBaseValArray(String[] strRateBaseValArray) {
		this.strRateBaseValArray = strRateBaseValArray;
	}
	public String getStrSancUnitId() {
		return strSancUnitId;
	}
	public void setStrSancUnitId(String strSancUnitId) {
		this.strSancUnitId = strSancUnitId;
	}
	public WebRowSet getUnitComboWS() {
		return unitComboWS;
	}
	public void setUnitComboWS(WebRowSet unitComboWS) {
		this.unitComboWS = unitComboWS;
	}
	public String getStrItemCategory() {
		return strItemCategory;
	}
	public void setStrItemCategory(String strItemCategory) {
		this.strItemCategory = strItemCategory;
	}
	public String getStrRaisingStoreId() {
		return strRaisingStoreId;
	}
	public void setStrRaisingStoreId(String strRaisingStoreId) {
		this.strRaisingStoreId = strRaisingStoreId;
	}
	public String getStrRaisingStoreName() {
		return strRaisingStoreName;
	}
	public void setStrRaisingStoreName(String strRaisingStoreName) {
		this.strRaisingStoreName = strRaisingStoreName;
	}
	public String getStrReqStatusName() {
		return strReqStatusName;
	}
	public void setStrReqStatusName(String strReqStatusName) {
		this.strReqStatusName = strReqStatusName;
	}
	public String getStrViewItemDtls() {
		return strViewItemDtls;
	}
	public void setStrViewItemDtls(String strViewItemDtls) {
		this.strViewItemDtls = strViewItemDtls;
	}
	
	public String getStrFinalApproxAmt() {
		return strFinalApproxAmt;
	}
	public void setStrFinalApproxAmt(String strFinalApproxAmt) {
		this.strFinalApproxAmt = strFinalApproxAmt;
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
	public String getStrIsDemandActiveFlag() {
		return strIsDemandActiveFlag;
	}
	public void setStrIsDemandActiveFlag(String strIsDemandActiveFlag) {
		this.strIsDemandActiveFlag = strIsDemandActiveFlag;
	}
	public String getStrBudgetFlg() {
		return strBudgetFlg;
	}
	public void setStrBudgetFlg(String strBudgetFlg) {
		this.strBudgetFlg = strBudgetFlg;
	}
	public String getStrDemandActivePrd() {
		return strDemandActivePrd;
	}
	public void setStrDemandActivePrd(String strDemandActivePrd) {
		this.strDemandActivePrd = strDemandActivePrd;
	}
	/**
	 * @return the issueItemWs
	 */
	public WebRowSet getIssueItemWs() {
		return issueItemWs;
	}
	/**
	 * @param issueItemWs the issueItemWs to set
	 */
	public void setIssueItemWs(WebRowSet issueItemWs) {
		this.issueItemWs = issueItemWs;
	}
	/**
	 * @return the approvedByWS
	 */
	public WebRowSet getApprovedByWS() {
		return approvedByWS;
	}
	/**
	 * @param approvedByWS the approvedByWS to set
	 */
	public void setApprovedByWS(WebRowSet approvedByWS) {
		this.approvedByWS = approvedByWS;
	}
	/************Variable End Here******************/
	/**
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}
	/**
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	/**
	 * @return the strMsg
	 */
	public String getStrMsg() {
		return strMsg;
	}
	/**
	 * @param strMsg the strMsg to set
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}
	/**
	 * @return the strWarning
	 */
	public String getStrWarning() {
		return strWarning;
	}
	/**
	 * @param strWarning the strWarning to set
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}
	/**
	 * @return the strMsgString
	 */
	public String getStrMsgString() {
		return strMsgString;
	}
	/**
	 * @param strMsgString the strMsgString to set
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	/**
	 * @return the strMsgType
	 */
	public String getStrMsgType() {
		return strMsgType;
	}
	/**
	 * @param strMsgType the strMsgType to set
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	/**
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	/**
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	/**
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
	}
	/**
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	/**
	 * @return the strGroupId
	 */
	public String getStrGroupId() {
		return strGroupId;
	}
	/**
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	/**
	 * @return the strCtDate
	 */
	public String getStrCtDate() {
		return strCtDate;
	}
	/**
	 * @param strCtDate the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
		/**
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}
	/**
	 * @return the strStoreTypeId
	 */
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	public void setStrItemCatgCombo(String str) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @return the strItemCatNo
	 */
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	/**
	 * @param strItemCatNo the strItemCatNo to set
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	/**
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}
	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	/**
	 * @return the strFinancialStartYear
	 */
	public String getStrFinancialStartYear() {
		return strFinancialStartYear;
	}
	/**
	 * @param strFinancialStartYear the strFinancialStartYear to set
	 */
	public void setStrFinancialStartYear(String strFinancialStartYear) {
		this.strFinancialStartYear = strFinancialStartYear;
	}
	/**
	 * @return the strApprovedBy
	 */
	public String getStrApprovedBy() {
		return strApprovedBy;
	}
	/**
	 * @param strApprovedBy the strApprovedBy to set
	 */
	public void setStrApprovedBy(String strApprovedBy) {
		this.strApprovedBy = strApprovedBy;
	}
	/**
	 * @return the strAprovedRemarks
	 */
	public String getStrAprovedRemarks() {
		return strAprovedRemarks;
	}
	/**
	 * @param strAprovedRemarks the strAprovedRemarks to set
	 */
	public void setStrAprovedRemarks(String strAprovedRemarks) {
		this.strAprovedRemarks = strAprovedRemarks;
	}
	/**
	 * @return the strApprovedDate
	 */
	public String getStrApprovedDate() {
		return strApprovedDate;
	}
	/**
	 * @param strApprovedDate the strApprovedDate to set
	 */
	public void setStrApprovedDate(String strApprovedDate) {
		this.strApprovedDate = strApprovedDate;
	}
	/**
	 * @return the strFinancialEndYear
	 */
	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}
	/**
	 * @param strFinancialEndYear the strFinancialEndYear to set
	 */
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}
	
	
	/**
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	/**
	 * @param strStoreTypeId the strStoreTypeId to set
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}
	
	
	/**
	 * @return the isNormal
	 */
	public String getIsNormal() {
		return isNormal;
	}
	/**
	 * @param isNormal the isNormal to set
	 */
	public void setIsNormal(String isNormal) {
		this.isNormal = isNormal;
	}
	/**
	 * @return the strIndentingStoreID
	 */
	public String getStrIndentingStoreID() {
		return strIndentingStoreID;
	}
	/**
	 * @param strIndentingStoreID the strIndentingStoreID to set
	 */
	public void setStrIndentingStoreID(String strIndentingStoreID) {
		this.strIndentingStoreID = strIndentingStoreID;
	}
	/**
	 * @return the strIndentingStoreName
	 */
	public String getStrIndentingStoreName() {
		return strIndentingStoreName;
	}
	/**
	 * @param strIndentingStoreName the strIndentingStoreName to set
	 */
	public void setStrIndentingStoreName(String strIndentingStoreName) {
		this.strIndentingStoreName = strIndentingStoreName;
	}
	/**
	 * @return the strIndentType
	 */
	public String getStrIndentType() {
		return strIndentType;
	}
	/**
	 * @param strIndentType the strIndentType to set
	 */
	public void setStrIndentType(String strIndentType) {
		this.strIndentType = strIndentType;
	}
	/**
	 * @return the strIndentPeriodValue
	 */
	public String getStrIndentPeriodValue() {
		return strIndentPeriodValue;
	}
	/**
	 * @param strIndentPeriodValue the strIndentPeriodValue to set
	 */
	public void setStrIndentPeriodValue(String strIndentPeriodValue) {
		this.strIndentPeriodValue = strIndentPeriodValue;
	}
	/**
	 * @return the strIndentNo
	 */
	public String getStrIndentNo() {
		return strIndentNo;
	}
	/**
	 * @param strIndentNo the strIndentNo to set
	 */
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}
	/**
	 * @return the strIndentDate
	 */
	public String getStrIndentDate() {
		return strIndentDate;
	}
	/**
	 * @param strIndentDate the strIndentDate to set
	 */
	public void setStrIndentDate(String strIndentDate) {
		this.strIndentDate = strIndentDate;
	}
	/**
	 * @return the strReceivedBy
	 */
	public String getStrReceivedBy() {
		return strReceivedBy;
	}
	/**
	 * @param strReceivedBy the strReceivedBy to set
	 */
	public void setStrReceivedBy(String strReceivedBy) {
		this.strReceivedBy = strReceivedBy;
	}
	/**
	 * @return the strApprovalDate
	 */
	public String getStrApprovalDate() {
		return strApprovalDate;
	}
	/**
	 * @param strApprovalDate the strApprovalDate to set
	 */
	public void setStrApprovalDate(String strApprovalDate) {
		this.strApprovalDate = strApprovalDate;
	}
	/**
	 * @return the strVerifiedByValues
	 */
	public String getStrVerifiedByValues() {
		return strVerifiedByValues;
	}
	/**
	 * @param strVerifiedByValues the strVerifiedByValues to set
	 */
	public void setStrVerifiedByValues(String strVerifiedByValues) {
		this.strVerifiedByValues = strVerifiedByValues;
	}
	/**
	 * @return the strVerifiedDate
	 */
	public String getStrVerifiedDate() {
		return strVerifiedDate;
	}
	/**
	 * @param strVerifiedDate the strVerifiedDate to set
	 */
	public void setStrVerifiedDate(String strVerifiedDate) {
		this.strVerifiedDate = strVerifiedDate;
	}
	
	/**
	 * @return the strIndentPeriodCombo
	 */
	public String getStrIndentPeriodCombo() {
		return strIndentPeriodCombo;
	}
	/**
	 * @param strIndentPeriodCombo the strIndentPeriodCombo to set
	 */
	public void setStrIndentPeriodCombo(String strIndentPeriodCombo) {
		this.strIndentPeriodCombo = strIndentPeriodCombo;
	}
	/**
	 * @return the strStoreName
	 */
	public String getStrStoreName() {
		return strStoreName;
	}
	/**
	 * @param strStoreName the strStoreName to set
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	/**
	 * @return the itemCatgWS
	 */
	public WebRowSet getItemCatgWS() {
		return itemCatgWS;
	}
	/**
	 * @param itemCatgWS the itemCatgWS to set
	 */
	public void setItemCatgWS(WebRowSet itemCatgWS) {
		this.itemCatgWS = itemCatgWS;
	}
	/**
	 * @return the strItemCatgCombo
	 */
	
	
	/**
	 * @param strItemCategoryCmb the strItemCategoryCmb to set
	 */
	public void setStrItemCategoryCmb(String strItemCategoryCmb) {
		this.strItemCategoryCmb = strItemCategoryCmb;
	}
	/**
	 * @return the strIndentStoreCombo
	 */
	public String getStrIndentStoreCombo() {
		return strIndentStoreCombo;
	}
	/**
	 * @param strIndentStoreCombo the strIndentStoreCombo to set
	 */
	public void setStrIndentStoreCombo(String strIndentStoreCombo) {
		this.strIndentStoreCombo = strIndentStoreCombo;
	}
	/**
	 * @return the strItemCagID
	 */
	public String getStrItemCagID() {
		return strItemCagID;
	}
	/**
	 * @param strItemCagID the strItemCagID to set
	 */
	public void setStrItemCagID(String strItemCagID) {
		this.strItemCagID = strItemCagID;
	}
	/**
	 * @return the strIssueNo
	 */
	public String getStrIssueNo() {
		return strIssueNo;
	}
	/**
	 * @param strIssueNo the strIssueNo to set
	 */
	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
	}
	/**
	 * @return the popUpWS
	 */
	public WebRowSet getPopUpWS() {
		return popUpWS;
	}
	/**
	 * @param popUpWS the popUpWS to set
	 */
	public void setPopUpWS(WebRowSet popUpWS) {
		this.popUpWS = popUpWS;
	}
	/**
	 * @return the verifyByWS
	 */
	public WebRowSet getVerifyByWS() {
		return verifyByWS;
	}
	/**
	 * @param verifyByWS the verifyByWS to set
	 */
	public void setVerifyByWS(WebRowSet verifyByWS) {
		this.verifyByWS = verifyByWS;
	}
	/**
	 * @return the itemParamValue
	 */
	public String[] getItemParamValue() {
		return itemParamValue;
	}
	/**
	 * @param itemParamValue the itemParamValue to set
	 */
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}
	/**
	 * @return the strUnitName
	 */
	public String[] getStrUnitName() {
		return strUnitName;
	}
	/**
	 * @param strUnitName the strUnitName to set
	 */
	public void setStrUnitName(String[] strUnitName) {
		this.strUnitName = strUnitName;
	}
	/**
	 * @return the strIssueQty
	 */
	public String getStrIssueQty() {
		return strIssueQty;
	}
	/**
	 * @param strIssueQty the strIssueQty to set
	 */
	public void setStrIssueQty(String strIssueQty) {
		this.strIssueQty = strIssueQty;
	}
	/**
	 * @return the strReqQty
	 */
	public String[] getStrReqQty() {
		return strReqQty;
	}
	/**
	 * @param strReqQty the strReqQty to set
	 */
	public void setStrReqQty(String[] strReqQty) {
		this.strReqQty = strReqQty;
	}
	/**
	 * @return the strItemCategoryCmb
	 */
	public String getStrItemCategoryCmb() {
		return strItemCategoryCmb;
	}
	/**
	 * @return the strFromDate
	 */
	public String getStrFromDate() {
		return strFromDate;
	}
	/**
	 * @param strFromDate the strFromDate to set
	 */
	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}
	/**
	 * @return the strToDate
	 */
	public String getStrToDate() {
		return strToDate;
	}
	/**
	 * @param strToDate the strToDate to set
	 */
	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}
	/**
	 * @return the issueNoDtlWs
	 */
	public WebRowSet getIssueNoDtlWs() {
		return issueNoDtlWs;
	}
	/**
	 * @param issueNoDtlWs the issueNoDtlWs to set
	 */
	public void setIssueNoDtlWs(WebRowSet issueNoDtlWs) {
		this.issueNoDtlWs = issueNoDtlWs;
	}
	public WebRowSet getPendingDemandWS() {
		return pendingDemandWS;
	}
	public void setPendingDemandWS(WebRowSet pendingDemandWS) {
		this.pendingDemandWS = pendingDemandWS;
	}
	public WebRowSet getItemDetailsWS() {
		return itemDetailsWS;
	}
	public void setItemDetailsWS(WebRowSet itemDetailsWS) {
		this.itemDetailsWS = itemDetailsWS;
	}
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}
	public String getStrIssueStoreId() {
		return strIssueStoreId;
	}
	public void setStrIssueStoreId(String strIssueStoreId) {
		this.strIssueStoreId = strIssueStoreId;
	}
	public WebRowSet getPendingIndentDemandWS() {
		return pendingIndentDemandWS;
	}
	public void setPendingIndentDemandWS(WebRowSet pendingIndentDemandWS) {
		this.pendingIndentDemandWS = pendingIndentDemandWS;
	}
	public String[] getStrItemDetailsChk() {
		return strItemDetailsChk;
	}
	public void setStrItemDetailsChk(String[] strItemDetailsChk) {
		this.strItemDetailsChk = strItemDetailsChk;
	}
	public String[] getStockDtlsId() {
		return stockDtlsId;
	}
	public void setStockDtlsId(String[] stockDtlsId) {
		this.stockDtlsId = stockDtlsId;
	}
	public String getStrReqTypeId() {
		return strReqTypeId;
	}
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
	public String getStrTmpIssuingStoreId() {
		return strTmpIssuingStoreId;
	}
	public void setStrTmpIssuingStoreId(String strTmpIssuingStoreId) {
		this.strTmpIssuingStoreId = strTmpIssuingStoreId;
	}
	public String getStrTmpRaisingStoreId() {
		return strTmpRaisingStoreId;
	}
	public void setStrTmpRaisingStoreId(String strTmpRaisingStoreId) {
		this.strTmpRaisingStoreId = strTmpRaisingStoreId;
	}
	public String getStrIssuingStoreId() {
		return strIssuingStoreId;
	}
	public void setStrIssuingStoreId(String strIssuingStoreId) {
		this.strIssuingStoreId = strIssuingStoreId;
	}
	public String getStrNewDemandFinalApproxAmt() {
		return strNewDemandFinalApproxAmt;
	}
	public void setStrNewDemandFinalApproxAmt(String strNewDemandFinalApproxAmt) {
		this.strNewDemandFinalApproxAmt = strNewDemandFinalApproxAmt;
	}
	public String getStrIpAddress() {
		return strIpAddress;
	}
	public void setStrIpAddress(String strIpAddress) {
		this.strIpAddress = strIpAddress;
	}
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	public String[] getStrCost() {
		return strCost;
	}
	public void setStrCost(String[] strCost) {
		this.strCost = strCost;
	}
	public String getStrIndentIssueDate() {
		return strIndentIssueDate;
	}
	public void setStrIndentIssueDate(String strIndentIssueDate) {
		this.strIndentIssueDate = strIndentIssueDate;
	}
	public WebRowSet getVoucherComboWS() {
		return VoucherComboWS;
	}
	public void setVoucherComboWS(WebRowSet voucherComboWS) {
		VoucherComboWS = voucherComboWS;
	}
	public WebRowSet getDrugNameComboWS() {
		return drugNameComboWS;
	}
	public void setDrugNameComboWS(WebRowSet drugNameComboWS) {
		this.drugNameComboWS = drugNameComboWS;
	}
	public String[] getStrDrugId() {
		return strDrugId;
	}
	public void setStrDrugId(String[] strDrugId) {
		this.strDrugId = strDrugId;
	}
	public String getStrBatchNo() {
		return strBatchNo;
	}
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
	public String[] getStrUnitId() {
		return strUnitId;
	}
	public void setStrUnitId(String[] strUnitId) {
		this.strUnitId = strUnitId;
	}
	public WebRowSet getIssueNoItemWs() {
		return issueNoItemWs;
	}
	public void setIssueNoItemWs(WebRowSet issueNoItemWs) {
		this.issueNoItemWs = issueNoItemWs;
	}
	public String getStrIssueValue() {
		return strIssueValue;
	}
	public void setStrIssueValue(String strIssueValue) {
		this.strIssueValue = strIssueValue;
	}
	public WebRowSet getBatchComboWS() {
		return batchComboWS;
	}
	public void setBatchComboWS(WebRowSet batchComboWS) {
		this.batchComboWS = batchComboWS;
	}
	public String getStrBatchNumber() {
		return strBatchNumber;
	}
	public void setStrBatchNumber(String strBatchNumber) {
		this.strBatchNumber = strBatchNumber;
	}
	public String getStrTempBatchNo() {
		return strTempBatchNo;
	}
	public void setStrTempBatchNo(String strTempBatchNo) {
		this.strTempBatchNo = strTempBatchNo;
	}
	public String getStrTempAvlQty() {
		return strTempAvlQty;
	}
	public void setStrTempAvlQty(String strTempAvlQty) {
		this.strTempAvlQty = strTempAvlQty;
	}
	
	

}
