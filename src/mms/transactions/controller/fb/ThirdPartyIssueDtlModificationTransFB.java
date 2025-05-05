package mms.transactions.controller.fb;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;

public class ThirdPartyIssueDtlModificationTransFB extends ActionForm 
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
   
    private String  strIndentingStoreName;
    private String  strIndentType;
    private String  strIndentPeriodCombo;
    private String  strIndentPeriodValue;
    private String  strIndentDate;
    private String  strReceivedBy;
    private String  strApprovalDate;
    private String  strVerifiedByValues;
    private String  strVerifiedDate;
    private String  strTmpIndentNo;
    private String  strVoucherCombo;
    private String  strVoucherNo;
    private String  strNewVoucherNumber;
   
	private String strModDate;
	
	private String strAvlQty;
		
	private String strDrugId;
	private String strBatchNo; 
	private String strIssueQty ;
	private String strOldBatchNo ; 
	private String strOldIssueQty;
	private String strUnitId;
	
	private String strAvalaibleBudget;
	private String strAvalaibleBudgetDtl;
	private String strCost;
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
	private String strPrevBudgetAvl;
	private String strCurrentBudgetAvl;
	private String strTotalCost;
	private String strTotalCostTemp;
	private String strDrugDtls;
	
	private String strReceivedById;
	private String strThirdPartyId;
	private String strThirdPartyValues;
	
	public String getStrThirdPartyValues() {
		return strThirdPartyValues;
	}
	public void setStrThirdPartyValues(String strThirdPartyValues) {
		this.strThirdPartyValues = strThirdPartyValues;
	}
	public String getStrReceivedById() {
		return strReceivedById;
	}
	public void setStrReceivedById(String strReceivedById) {
		this.strReceivedById = strReceivedById;
	}
	public String getStrDrugDtls() {
		return strDrugDtls;
	}
	public void setStrDrugDtls(String strDrugDtls) {
		this.strDrugDtls = strDrugDtls;
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
	public String getStrViewChk() {
		return strViewChk;
	}
	public void setStrViewChk(String strViewChk) {
		this.strViewChk = strViewChk;
	}
	public String getStrTmpStoreNo() {
		return strTmpStoreNo;
	}
	public void setStrTmpStoreNo(String strTmpStoreNo) {
		this.strTmpStoreNo = strTmpStoreNo;
	}
	public String getStrVerifiedBy() {
		return strVerifiedBy;
	}
	public void setStrVerifiedBy(String strVerifiedBy) {
		this.strVerifiedBy = strVerifiedBy;
	}
	public String getStrIssueNo() {
		return strIssueNo;
	}
	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
	}
	public String getStrIssueValue() {
		return strIssueValue;
	}
	public void setStrIssueValue(String strIssueValue) {
		this.strIssueValue = strIssueValue;
	}
	public String getStrIsView() {
		return strIsView;
	}
	public void setStrIsView(String strIsView) {
		this.strIsView = strIsView;
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
	public String getIsNormal() {
		return isNormal;
	}
	public void setIsNormal(String isNormal) {
		this.isNormal = isNormal;
	}
	public String getStrItemCatgCombo() {
		return strItemCatgCombo;
	}
	public void setStrItemCatgCombo(String strItemCatgCombo) {
		this.strItemCatgCombo = strItemCatgCombo;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public WebRowSet getGroupWs() {
		return GroupWs;
	}
	public void setGroupWs(WebRowSet groupWs) {
		GroupWs = groupWs;
	}
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrFinancialStartYear() {
		return strFinancialStartYear;
	}
	public void setStrFinancialStartYear(String strFinancialStartYear) {
		this.strFinancialStartYear = strFinancialStartYear;
	}
	public String getStrApprovedBy() {
		return strApprovedBy;
	}
	public void setStrApprovedBy(String strApprovedBy) {
		this.strApprovedBy = strApprovedBy;
	}
	public String getStrAprovedRemarks() {
		return strAprovedRemarks;
	}
	public void setStrAprovedRemarks(String strAprovedRemarks) {
		this.strAprovedRemarks = strAprovedRemarks;
	}
	public String getStrApprovedByValues() {
		return strApprovedByValues;
	}
	public void setStrApprovedByValues(String strApprovedByValues) {
		this.strApprovedByValues = strApprovedByValues;
	}
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	public String getStrApprovedDate() {
		return strApprovedDate;
	}
	public void setStrApprovedDate(String strApprovedDate) {
		this.strApprovedDate = strApprovedDate;
	}
	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}
	
	public String getStrIndentingStoreName() {
		return strIndentingStoreName;
	}
	public void setStrIndentingStoreName(String strIndentingStoreName) {
		this.strIndentingStoreName = strIndentingStoreName;
	}
	public String getStrIndentType() {
		return strIndentType;
	}
	public void setStrIndentType(String strIndentType) {
		this.strIndentType = strIndentType;
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
	
	public String getStrIndentDate() {
		return strIndentDate;
	}
	public void setStrIndentDate(String strIndentDate) {
		this.strIndentDate = strIndentDate;
	}
	public String getStrReceivedBy() {
		return strReceivedBy;
	}
	public void setStrReceivedBy(String strReceivedBy) {
		this.strReceivedBy = strReceivedBy;
	}
	public String getStrApprovalDate() {
		return strApprovalDate;
	}
	public void setStrApprovalDate(String strApprovalDate) {
		this.strApprovalDate = strApprovalDate;
	}
	public String getStrVerifiedByValues() {
		return strVerifiedByValues;
	}
	public void setStrVerifiedByValues(String strVerifiedByValues) {
		this.strVerifiedByValues = strVerifiedByValues;
	}
	public String getStrVerifiedDate() {
		return strVerifiedDate;
	}
	public void setStrVerifiedDate(String strVerifiedDate) {
		this.strVerifiedDate = strVerifiedDate;
	}
	public String getStrTmpIndentNo() {
		return strTmpIndentNo;
	}
	public void setStrTmpIndentNo(String strTmpIndentNo) {
		this.strTmpIndentNo = strTmpIndentNo;
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
	public String getStrModDate() {
		return strModDate;
	}
	public void setStrModDate(String strModDate) {
		this.strModDate = strModDate;
	}
	public String getStrAvlQty() {
		return strAvlQty;
	}
	public void setStrAvlQty(String strAvlQty) {
		this.strAvlQty = strAvlQty;
	}
	public String getStrDrugId() {
		return strDrugId;
	}
	public void setStrDrugId(String strDrugId) {
		this.strDrugId = strDrugId;
	}
	public String getStrBatchNo() {
		return strBatchNo;
	}
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
	public String getStrIssueQty() {
		return strIssueQty;
	}
	public void setStrIssueQty(String strIssueQty) {
		this.strIssueQty = strIssueQty;
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
	public String getStrUnitId() {
		return strUnitId;
	}
	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
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
	public String getStrCost() {
		return strCost;
	}
	public void setStrCost(String strCost) {
		this.strCost = strCost;
	}
	public String getStrFinalApproxAmt() {
		return strFinalApproxAmt;
	}
	public void setStrFinalApproxAmt(String strFinalApproxAmt) {
		this.strFinalApproxAmt = strFinalApproxAmt;
	}
	public String getStrFinalApproxAmtDiv() {
		return strFinalApproxAmtDiv;
	}
	public void setStrFinalApproxAmtDiv(String strFinalApproxAmtDiv) {
		this.strFinalApproxAmtDiv = strFinalApproxAmtDiv;
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
	public String getStrTmpIndentDate() {
		return strTmpIndentDate;
	}
	public void setStrTmpIndentDate(String strTmpIndentDate) {
		this.strTmpIndentDate = strTmpIndentDate;
	}
	public String getStrNewDemandFinalApproxAmt() {
		return strNewDemandFinalApproxAmt;
	}
	public void setStrNewDemandFinalApproxAmt(String strNewDemandFinalApproxAmt) {
		this.strNewDemandFinalApproxAmt = strNewDemandFinalApproxAmt;
	}
	public String getStrRemainingBudget() {
		return strRemainingBudget;
	}
	public void setStrRemainingBudget(String strRemainingBudget) {
		this.strRemainingBudget = strRemainingBudget;
	}
	public String getStrDemandTypeFlg() {
		return strDemandTypeFlg;
	}
	public void setStrDemandTypeFlg(String strDemandTypeFlg) {
		this.strDemandTypeFlg = strDemandTypeFlg;
	}
	public String getStrIndentIssueDate() {
		return strIndentIssueDate;
	}
	public void setStrIndentIssueDate(String strIndentIssueDate) {
		this.strIndentIssueDate = strIndentIssueDate;
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
	public String getStrDrugNameCombo() {
		return strDrugNameCombo;
	}
	public void setStrDrugNameCombo(String strDrugNameCombo) {
		this.strDrugNameCombo = strDrugNameCombo;
	}
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	public String getStrVoucherIndentDate() {
		return strVoucherIndentDate;
	}
	public void setStrVoucherIndentDate(String strVoucherIndentDate) {
		this.strVoucherIndentDate = strVoucherIndentDate;
	}
	public String getStrPrevBudgetAvl() {
		return strPrevBudgetAvl;
	}
	public void setStrPrevBudgetAvl(String strPrevBudgetAvl) {
		this.strPrevBudgetAvl = strPrevBudgetAvl;
	}
	public String getStrCurrentBudgetAvl() {
		return strCurrentBudgetAvl;
	}
	public void setStrCurrentBudgetAvl(String strCurrentBudgetAvl) {
		this.strCurrentBudgetAvl = strCurrentBudgetAvl;
	}
	public String getStrTotalCost() {
		return strTotalCost;
	}
	public void setStrTotalCost(String strTotalCost) {
		this.strTotalCost = strTotalCost;
	}
	public String getStrTotalCostTemp() {
		return strTotalCostTemp;
	}
	public void setStrTotalCostTemp(String strTotalCostTemp) {
		this.strTotalCostTemp = strTotalCostTemp;
	}
	public String getStrThirdPartyId() {
		return strThirdPartyId;
	}
	public void setStrThirdPartyId(String strThirdPartyId) {
		this.strThirdPartyId = strThirdPartyId;
	}
	
		
}
