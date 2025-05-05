package mms.reports.controller.fb;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;

public class DrugQualityStatusRptFB extends ActionForm 
{
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
	private String strViewChk="";
	/************Variable Start Here******************/
	private String strBkgEntryDate ="";
	private String strItemCatgCombo = "";
	private String strStoreId = "";
	private String strStoreName = "";
	private WebRowSet GroupWs  =null;
	private String strStoreTypeId = "";
	private String strGroupIdForItemSearch = "";
	private String[] itemParamValue = {""};
	private String[] strBkgQty ={""};
	private String[] strCostFinal=null;
	private String[] strUnitName={""};
	private String strRemarks = "";
	 private String strFinancialStartYear = "";
	 private String strApprovedBy="";
	 private String strAprovedRemarks="";
	 private String strApprovedByValues="";
	 private String strCurrentDate="";
	 private String strApprovedDate="";
     private String strFinancialEndYear = "";
	private String strBreakageItemDtlVal="";
	private String strApproxAmt="";
	private String strCostRequired="";
	private String strTypeMode;
	private String strItemCategoryCombo;
	private String strReSendMode;
	private String strViewMode;
	private String strLabNameCombo;
	private String strHiddenBatchDtl;
	 private String strCTRNumber;
	 private String strItemCatg;
	 private String strDrugName;
     private String strGroupNameCmb;
     private String strFromDate;
     private String strToDate;

	 private String strItemNameCombo;
	 
	
	
	private String strSampleIssueQty;

	private String strSampleUnitId;

	private String strLabId;

	private String strSampleCodeNumber;

	private String strDrugBrandId;

	private String strDrugNameCmb;

	private String strBatchNo;

	private String strBatchNameCmb;

	
	private String strLabName;
	private String strItemBrandId;
	private String strItemBrandName;
	private String strItemCategoryName;
	private String strItemCategoryCode;
	private String strResendFlag;

	
	private String strLabSendNo="0";
	private String strPCTRNo;
	private String strPBatchNo;
	private String strPManufDate;
	private String strPExpDate;
	private String strPManufBy;
	private String strLabCode;
	
	private String strReportFormat;
	private String strIsFooter="";
	private String strUserRemarks="";

	private String strQcStatus;
	
	public String getStrReportFormat() {
		return strReportFormat;
	}

	public void setStrReportFormat(String strReportFormat) {
		this.strReportFormat = strReportFormat;
	}

	public String getStrIsFooter() {
		return strIsFooter;
	}

	public void setStrIsFooter(String strIsFooter) {
		this.strIsFooter = strIsFooter;
	}

	public String getStrUserRemarks() {
		return strUserRemarks;
	}

	public void setStrUserRemarks(String strUserRemarks) {
		this.strUserRemarks = strUserRemarks;
	}

	public String getStrLabCode() {
		return strLabCode;
	}

	public void setStrLabCode(String strLabCode) {
		this.strLabCode = strLabCode;
	}

	public String getStrPCTRNo() {
		return strPCTRNo;
	}

	public void setStrPCTRNo(String strPCTRNo) {
		this.strPCTRNo = strPCTRNo;
	}

	public String getStrPBatchNo() {
		return strPBatchNo;
	}

	public void setStrPBatchNo(String strPBatchNo) {
		this.strPBatchNo = strPBatchNo;
	}

	public String getStrPManufDate() {
		return strPManufDate;
	}

	public void setStrPManufDate(String strPManufDate) {
		this.strPManufDate = strPManufDate;
	}

	public String getStrPExpDate() {
		return strPExpDate;
	}

	public void setStrPExpDate(String strPExpDate) {
		this.strPExpDate = strPExpDate;
	}

	public String getStrPManufBy() {
		return strPManufBy;
	}

	public void setStrPManufBy(String strPManufBy) {
		this.strPManufBy = strPManufBy;
	}

	public String getStrResendFlag() {
		return strResendFlag;
	}

	public void setStrResendFlag(String strResendFlag) {
		this.strResendFlag = strResendFlag;
	}

	public String getStrItemBrandId() {
		return strItemBrandId;
	}

	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	public String getStrItemBrandName() {
		return strItemBrandName;
	}

	public void setStrItemBrandName(String strItemBrandName) {
		this.strItemBrandName = strItemBrandName;
	}

	public String getStrLabName() {
		return strLabName;
	}

	public void setStrLabName(String strLabName) {
		this.strLabName = strLabName;
	}

	public String getStrLabSendNo() {
		return strLabSendNo;
	}

	public void setStrLabSendNo(String strLabSendNo) {
		this.strLabSendNo = strLabSendNo;
	}

	public String getStrItemCategoryCombo() {
		return strItemCategoryCombo;
	}

	public void setStrItemCategoryCombo(String strItemCategoryCombo) {
		this.strItemCategoryCombo = strItemCategoryCombo;
	}

	public String getStrTypeMode() {
		return strTypeMode;
	}

	public void setStrTypeMode(String strTypeMode) {
		this.strTypeMode = strTypeMode;
	}

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

	public String getStrApproxAmt() {
		return strApproxAmt;
	}

	public void setStrApproxAmt(String strApproxAmt) {
		this.strApproxAmt = strApproxAmt;
	}

	public String getStrBreakageItemDtlVal() {
		return strBreakageItemDtlVal;
	}

	public void setStrBreakageItemDtlVal(String strBreakageItemDtlVal) {
		this.strBreakageItemDtlVal = strBreakageItemDtlVal;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String getStrGroupIdForItemSearch() {
		return strGroupIdForItemSearch;
	}

	public void setStrGroupIdForItemSearch(String strGroupIdForItemSearch) {
		this.strGroupIdForItemSearch = strGroupIdForItemSearch;
	}

	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}

	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}

	public WebRowSet getGroupWs() {
		return GroupWs;
	}

	public void setGroupWs(WebRowSet groupWs) {
		GroupWs = groupWs;
	}

	public String getStrStoreName() {
		return strStoreName;
	}

	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	public String getStrBkgEntryDate() {
		return strBkgEntryDate;
	}

	public void setStrBkgEntryDate(String strBkgEntryDate) {
		this.strBkgEntryDate = strBkgEntryDate;
	}

	/**********Current Date*************/
	public String getStrCtDate() 
	{
		HisUtil util = new HisUtil("Breakge Item Detail Transaction", "BreakgeItemDtlTransFB");
		try {
			strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;
		} catch (Exception e) {
			new HisException("MMS Module", "Breakge Item Detail Transaction",
					"BreakgeItemDtlTransFB.getStrCtDate()-->" + e.getMessage());
		}
		return strCtDate;

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

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public String getStrErrMsg() {
		return strErrMsg;
	}

	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	public String[] getItemParamValue() {
		return itemParamValue;
	}

	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}

	public String[] getStrBkgQty() {
		return strBkgQty;
	}

	public void setStrBkgQty(String[] strBkgQty) {
		this.strBkgQty = strBkgQty;
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

	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	public String getStrViewChk() {
		return strViewChk;
	}

	public void setStrViewChk(String strViewChk) {
		this.strViewChk = strViewChk;
	}

	public String[] getStrCostFinal() {
		return strCostFinal;
	}

	public void setStrCostFinal(String[] strCostFinal) {
		this.strCostFinal = strCostFinal;
	}

	public String getStrSampleIssueQty() {
		return strSampleIssueQty;
	}

	public void setStrSampleIssueQty(String strSampleIssueQty) {
		this.strSampleIssueQty = strSampleIssueQty;
	}

	public String getStrSampleUnitId() {
		return strSampleUnitId;
	}

	public void setStrSampleUnitId(String strSampleUnitId) {
		this.strSampleUnitId = strSampleUnitId;
	}

	public String getStrLabId() {
		return strLabId;
	}

	public void setStrLabId(String strLabId) {
		this.strLabId = strLabId;
	}

	public String getStrSampleCodeNumber() {
		return strSampleCodeNumber;
	}

	public void setStrSampleCodeNumber(String strSampleCodeNumber) {
		this.strSampleCodeNumber = strSampleCodeNumber;
	}

	public String getStrDrugBrandId() {
		return strDrugBrandId;
	}

	public void setStrDrugBrandId(String strDrugBrandId) {
		this.strDrugBrandId = strDrugBrandId;
	}

	public String getStrDrugNameCmb() {
		return strDrugNameCmb;
	}

	public void setStrDrugNameCmb(String strDrugNameCmb) {
		this.strDrugNameCmb = strDrugNameCmb;
	}

	public String getStrBatchNo() {
		return strBatchNo;
	}

	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	public String getStrBatchNameCmb() {
		return strBatchNameCmb;
	}

	public void setStrBatchNameCmb(String strBatchNameCmb) {
		this.strBatchNameCmb = strBatchNameCmb;
	}

	public String getStrReSendMode() {
		return strReSendMode;
	}

	public void setStrReSendMode(String strReSendMode) {
		this.strReSendMode = strReSendMode;
	}

	public String getStrViewMode() {
		return strViewMode;
	}

	public void setStrViewMode(String strViewMode) {
		this.strViewMode = strViewMode;
	}

	public String getStrLabNameCombo() {
		return strLabNameCombo;
	}

	public void setStrLabNameCombo(String strLabNameCombo) {
		this.strLabNameCombo = strLabNameCombo;
	}

	public String getStrHiddenBatchDtl() {
		return strHiddenBatchDtl;
	}

	public void setStrHiddenBatchDtl(String strHiddenBatchDtl) {
		this.strHiddenBatchDtl = strHiddenBatchDtl;
	}

	public String getStrCTRNumber() {
		return strCTRNumber;
	}

	public void setStrCTRNumber(String strCTRNumber) {
		this.strCTRNumber = strCTRNumber;
	}

	public String getStrItemCatg() {
		return strItemCatg;
	}

	public void setStrItemCatg(String strItemCatg) {
		this.strItemCatg = strItemCatg;
	}

	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}

	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}

	public String getStrItemCategoryCode() {
		return strItemCategoryCode;
	}

	public void setStrItemCategoryCode(String strItemCategoryCode) {
		this.strItemCategoryCode = strItemCategoryCode;
	}

	public String getStrDrugName() {
		return strDrugName;
	}

	public void setStrDrugName(String strDrugName) {
		this.strDrugName = strDrugName;
	}

	public String getStrGroupNameCmb() {
		return strGroupNameCmb;
	}

	public void setStrGroupNameCmb(String strGroupNameCmb) {
		this.strGroupNameCmb = strGroupNameCmb;
	}

	public String getStrItemNameCombo() {
		return strItemNameCombo;
	}

	public void setStrItemNameCombo(String strItemNameCombo) {
		this.strItemNameCombo = strItemNameCombo;
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

	public String getStrQcStatus() {
		return strQcStatus;
	}

	public void setStrQcStatus(String strQcStatus) {
		this.strQcStatus = strQcStatus;
	}
}
