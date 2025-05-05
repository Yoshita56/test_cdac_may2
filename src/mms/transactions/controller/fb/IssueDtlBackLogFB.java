package mms.transactions.controller.fb;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;

public class IssueDtlBackLogFB extends ActionForm 
{
	private static final long serialVersionUID = 02L;
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "";
	private String strErrMsg = "";
	private String strNormalMsg;

	private String strHospitalCode = "";
	private String strGroupId = "";
	private String strCtDate = "";
	private String strSeatId = "";
	private String strViewChk="";
	/************Variable Start Here******************/
	private String strTmpStoreNo;
	private String strVerifiedBy;
	private String strIssueNo="0";
	private String strIssueValue;
	
	private String strIsView;
    private String strFromDate;
	private String strToDate;
	private String isNormal ="0";
	private String strItemCatgCombo = "";
	private String strStoreId = "";
	private String strStoreName = "";
	private WebRowSet GroupWs  =null;
	private String strStoreTypeId = "";
	private String strRemarks = "";
	private String strFinancialStartYear = "";
	private String strApprovedBy="";
	private String strAprovedRemarks="";
	private String strApprovedByValues="";
	private String strCurrentDate="";
	private String strApprovedDate="";
    private String strFinancialEndYear = "";
   
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
    private String  strTmpIndentNo;
    private String  strVoucherCombo;
    private String  strVoucherNo;
    private String  strNewVoucherNumber;
    private String  strUnitCombo;
     
    private String[] itemParamValue = {""};
	private String[] strUnitName={""};
	private String strModDate;
	
	
	
	
	private String[] strReqQty ={""};
	 private String[] strItemDetailsChk ={""};
	 private String[] stockDtlsId ={""};
	 private String[] strAvlQty={""};
	 
	
		private String[] strBalQty = null; 
		private String[] strSancUnitId = null; 
		
		
		private String[] strIssueUnitId = null; 
	
		private String[] strItemRemarks = null; 
		
	private String[] strDrugId= null;
	private String[] strBatchNo = null; 
	private String[] strIssueQty ={""};
	private String[] strOldBatchNo = null; 
	private String[] strOldIssueQty ={""};
	private String[] strUnitId=null;
	private String[] strNewDrugId={""};
		
	private String strReOrderFlgColor;
	private String strBudgetFlg;
	private String strDemandActivePrd;
	private String strIsDemandActiveFlag;
	
	private String strAvalaibleBudget;
	private String strAvalaibleBudgetDtl;
	private String[] strCost={""};
	private String strFinalApproxAmt;
	private String strFinalApproxAmtDiv;
	
	private String strItemCategory;
	private String strRaisingStoreId;
	private String strRaisingStoreName;
	private String strReqStatusName;
	private String strViewItemDtls;
	private String strPendIssueQty;

	private String strPendQtyCost;

	private String strTotalPendCostDivId;

	private String strApproxPendAmt;

	private String strPendVerifiedBy;

	private String strPendAprovedRemarks;
	
	private String strTmpIssuingStoreId;

	private String strTmpRaisingStoreId;

	private String strIssuingStoreId;
	private String strTmpIndentDate;
	private String strNewDemandFinalApproxAmt;
	private String strRemainingBudget;
	private String strDemandTypeFlg;
	private String strIndentIssueDate;
	
	private String strVoucherDate;
	private String strIndentNumber;
	private String strDrugNameCombo;
	private String strItemBrandId="";
	private String strVoucherIndentDate;
		
	
	public String getStrVoucherIndentDate() {
		return strVoucherIndentDate;
	}
	public void setStrVoucherIndentDate(String strVoucherIndentDate) {
		this.strVoucherIndentDate = strVoucherIndentDate;
	}
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	public String getStrDrugNameCombo() {
		return strDrugNameCombo;
	}
	public void setStrDrugNameCombo(String strDrugNameCombo) {
		this.strDrugNameCombo = strDrugNameCombo;
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
	public String getStrIndentIssueDate() {
		return strIndentIssueDate;
	}
	public void setStrIndentIssueDate(String strIndentIssueDate) {
		this.strIndentIssueDate = strIndentIssueDate;
	}
	public String getStrDemandTypeFlg() {
		return strDemandTypeFlg;
	}
	public void setStrDemandTypeFlg(String strDemandTypeFlg) {
		this.strDemandTypeFlg = strDemandTypeFlg;
	}
	public String getStrRemainingBudget() {
		return strRemainingBudget;
	}
	public void setStrRemainingBudget(String strRemainingBudget) {
		this.strRemainingBudget = strRemainingBudget;
	}
	public String getStrNewDemandFinalApproxAmt() {
		return strNewDemandFinalApproxAmt;
	}
	public void setStrNewDemandFinalApproxAmt(String strNewDemandFinalApproxAmt) {
		this.strNewDemandFinalApproxAmt = strNewDemandFinalApproxAmt;
	}
	public String getStrTmpIndentDate() {
		return strTmpIndentDate;
	}
	public void setStrTmpIndentDate(String strTmpIndentDate) {
		this.strTmpIndentDate = strTmpIndentDate;
	}
	public String getStrPendIssueQty() {
		return strPendIssueQty;
	}
	public void setStrPendIssueQty(String strPendIssueQty) {
		this.strPendIssueQty = strPendIssueQty;
	}
	public String getStrPendQtyCost() {
		return strPendQtyCost;
	}
	public void setStrPendQtyCost(String strPendQtyCost) {
		this.strPendQtyCost = strPendQtyCost;
	}
	public String getStrTotalPendCostDivId() {
		return strTotalPendCostDivId;
	}
	public void setStrTotalPendCostDivId(String strTotalPendCostDivId) {
		this.strTotalPendCostDivId = strTotalPendCostDivId;
	}
	public String getStrApproxPendAmt() {
		return strApproxPendAmt;
	}
	public void setStrApproxPendAmt(String strApproxPendAmt) {
		this.strApproxPendAmt = strApproxPendAmt;
	}
	public String getStrPendVerifiedBy() {
		return strPendVerifiedBy;
	}
	public void setStrPendVerifiedBy(String strPendVerifiedBy) {
		this.strPendVerifiedBy = strPendVerifiedBy;
	}
	public String getStrPendAprovedRemarks() {
		return strPendAprovedRemarks;
	}
	public void setStrPendAprovedRemarks(String strPendAprovedRemarks) {
		this.strPendAprovedRemarks = strPendAprovedRemarks;
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
	/************Variable END Here******************/
    
	public String getStrReOrderFlgColor() {
		return strReOrderFlgColor;
	}
	public void setStrReOrderFlgColor(String strReOrderFlgColor) {
		this.strReOrderFlgColor = strReOrderFlgColor;
	}
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
	 * @return the strErrMsg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}
	/**
	 * @param strErrMsg the strErrMsg to set
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
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
	 * @return the strViewChk
	 */
	public String getStrViewChk() {
		return strViewChk;
	}
	/**
	 * @param strViewChk the strViewChk to set
	 */
	public void setStrViewChk(String strViewChk) {
		this.strViewChk = strViewChk;
	}
	/**
	 * @return the strItemCatgCombo
	 */
	public String getStrItemCatgCombo() {
		return strItemCatgCombo;
	}
	/**
	 * @param strItemCatgCombo the strItemCatgCombo to set
	 */
	public void setStrItemCatgCombo(String strItemCatgCombo) {
		this.strItemCatgCombo = strItemCatgCombo;
	}
	/**
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}
	/**
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
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
	 * @return the groupWs
	 */
	public WebRowSet getGroupWs() {
		return GroupWs;
	}
	/**
	 * @param groupWs the groupWs to set
	 */
	public void setGroupWs(WebRowSet groupWs) {
		GroupWs = groupWs;
	}
	/**
	 * @return the strStoreTypeId
	 */
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	/**
	 * @param strStoreTypeId the strStoreTypeId to set
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
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
	 * @return the strApprovedByValues
	 */
	public String getStrApprovedByValues() {
		return strApprovedByValues;
	}
	/**
	 * @param strApprovedByValues the strApprovedByValues to set
	 */
	public void setStrApprovedByValues(String strApprovedByValues) {
		this.strApprovedByValues = strApprovedByValues;
	}
	/**
	 * @return the strCurrentDate
	 */
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	/**
	 * @param strCurrentDate the strCurrentDate to set
	 */
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
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
	 * @return the strIsView
	 */
	public String getStrIsView() {
		return strIsView;
	}
	/**
	 * @param strIsView the strIsView to set
	 */
	public void setStrIsView(String strIsView) {
		this.strIsView = strIsView;
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
	 * @return the strVerifiedBy
	 */
	public String getStrVerifiedBy() {
		return strVerifiedBy;
	}
	/**
	 * @param strVerifiedBy the strVerifiedBy to set
	 */
	public void setStrVerifiedBy(String strVerifiedBy) {
		this.strVerifiedBy = strVerifiedBy;
	}
	/**
	 * @return the strNormalMsg
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	/**
	 * @param strNormalMsg the strNormalMsg to set
	 */
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
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
	public String[] getStrIssueQty() {
		return strIssueQty;
	}
	/**
	 * @param strIssueQty the strIssueQty to set
	 */
	public void setStrIssueQty(String[] strIssueQty) {
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
	 * @return the strTmpStoreNo
	 */
	public String getStrTmpStoreNo() {
		return strTmpStoreNo;
	}
	/**
	 * @param strTmpStoreNo the strTmpStoreNo to set
	 */
	public void setStrTmpStoreNo(String strTmpStoreNo) {
		this.strTmpStoreNo = strTmpStoreNo;
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
	public String getStrIsDemandActiveFlag() {
		return strIsDemandActiveFlag;
	}
	public void setStrIsDemandActiveFlag(String strIsDemandActiveFlag) {
		this.strIsDemandActiveFlag = strIsDemandActiveFlag;
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
	public String[] getStrAvlQty() {
		return strAvlQty;
	}
	public void setStrAvlQty(String[] strAvlQty) {
		this.strAvlQty = strAvlQty;
	}
	public String[] getStrBalQty() {
		return strBalQty;
	}
	public void setStrBalQty(String[] strBalQty) {
		this.strBalQty = strBalQty;
	}
	public String[] getStrSancUnitId() {
		return strSancUnitId;
	}
	public void setStrSancUnitId(String[] strSancUnitId) {
		this.strSancUnitId = strSancUnitId;
	}
	public String[] getStrIssueUnitId() {
		return strIssueUnitId;
	}
	public void setStrIssueUnitId(String[] strIssueUnitId) {
		this.strIssueUnitId = strIssueUnitId;
	}
	public String[] getStrItemRemarks() {
		return strItemRemarks;
	}
	public void setStrItemRemarks(String[] strItemRemarks) {
		this.strItemRemarks = strItemRemarks;
	}
	public String getStrTmpIndentNo() {
		return strTmpIndentNo;
	}
	public void setStrTmpIndentNo(String strTmpIndentNo) {
		this.strTmpIndentNo = strTmpIndentNo;
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
	public String getStrFinalApproxAmtDiv() {
		return strFinalApproxAmtDiv;
	}
	public void setStrFinalApproxAmtDiv(String strFinalApproxAmtDiv) {
		this.strFinalApproxAmtDiv = strFinalApproxAmtDiv;
	}
	public String[] getStrCost() {
		return strCost;
	}
	public void setStrCost(String[] strCost) {
		this.strCost = strCost;
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
	public String getStrNewVoucherNumber() {
		return strNewVoucherNumber;
	}
	public void setStrNewVoucherNumber(String strNewVoucherNumber) {
		this.strNewVoucherNumber = strNewVoucherNumber;
	}
	public String[] getStrBatchNo() {
		return strBatchNo;
	}
	public void setStrBatchNo(String[] strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
	public String getStrUnitCombo() {
		return strUnitCombo;
	}
	public void setStrUnitCombo(String strUnitCombo) {
		this.strUnitCombo = strUnitCombo;
	}
	public String[] getStrDrugId() {
		return strDrugId;
	}
	public void setStrDrugId(String[] strDrugId) {
		this.strDrugId = strDrugId;
	}
	public String[] getStrUnitId() {
		return strUnitId;
	}
	public void setStrUnitId(String[] strUnitId) {
		this.strUnitId = strUnitId;
	}
	public String[] getStrOldBatchNo() {
		return strOldBatchNo;
	}
	public void setStrOldBatchNo(String[] strOldBatchNo) {
		this.strOldBatchNo = strOldBatchNo;
	}
	public String[] getStrOldIssueQty() {
		return strOldIssueQty;
	}
	public void setStrOldIssueQty(String[] strOldIssueQty) {
		this.strOldIssueQty = strOldIssueQty;
	}
	public String[] getStrNewDrugId() {
		return strNewDrugId;
	}
	public void setStrNewDrugId(String[] strNewDrugId) {
		this.strNewDrugId = strNewDrugId;
	}
	public String getStrModDate() {
		return strModDate;
	}
	public void setStrModDate(String strModDate) {
		this.strModDate = strModDate;
	}
	public String getStrIssueValue() {
		return strIssueValue;
	}
	public void setStrIssueValue(String strIssueValue) {
		this.strIssueValue = strIssueValue;
	}
	
}
