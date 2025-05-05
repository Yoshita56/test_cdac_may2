package mms.transactions.vo;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

public class SampleSentTransVO {
	private static final long serialVersionUID = 02L;
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "";

	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strGroupId = "";
	private String strCtDate = "";
	/************Variable Start Here******************/
	private String strItemCatNo="";
	private String strItemCatgCombo = "";
	private String strStoreId = "";
	private String strBkgEntryDate ="";
	private String strStoreName = "";
	private WebRowSet GroupWs  =null;
	private WebRowSet breakageItemWS  =null;
	private String strStoreTypeId = "";
	private String strGroupIdForItemSearch = "";
	private String[] strCostFinal=null;
	private String strApproxAmt="";
	private String[] itemParamValue = {""};
	private String[] strBkgQty ={""};
	private String[] strUnitName={""};
	private String strRemarks = ""; 
	private String strFinancialStartYear = "";
	
	private String strApprovedBy="";
	private String strAprovedRemarks="";
    private String strApprovedDate="";

    private String strFinancialEndYear = "";
    private String strItemCatg;
	
    private String strFromDate;
    private String strToDate;
    private String strModuleId;
    private String strCTRNumber;
    
    private WebRowSet approvedByWS=null;
    private WebRowSet indentItemWS=null;
	private String strTypeMode;
	
	private String strSampleIssueQty;

	private String strSampleUnitId;

	private String strLabId;

	private String strSampleCodeNumber;
	private String strHiddenBatchDtl;

	private String strDrugBrandId;

	private String strDrugNameCmb;
	private String strLabNameCombo;
	private String strLabSendNo;

	private String strBatchNo;
	private String strReSendFlg;
    private String strUnitRateID;
	private String strBatchNameCmb;
	private String strBatchDetails;
	private WebRowSet wsItemCategoryCombo = null;
	private WebRowSet wsDrugNameCombo = null;
	private WebRowSet wsDrugBatchCombo = null;
	private WebRowSet wsUnitCombo = null;
	private WebRowSet wsLabNameCombo = null;
	private WebRowSet wsLabSentHlp = null;
	private String strLabName;
	private String strItemBrandId;
	private String strItemCategoryName;
	private String strItemCategoryCode;
	private String strDescription;
	 private String strDrugName;
	 private String strLabCode;
		private String[] strNewSampleIssueQty={""};
		private String[] strNewSampleCodeNumber={""};
		private String[] hiddenValue={""};
		private String strSearchNameType;
		private String strSearchType;
		private String[] itemUserValue={""};
		private String[] strHidValueFlag={"0"};
		private String[] strCheckHidValue={""};
		private String[] chkFlg={""};

		public String[] getChkFlg() {
			return chkFlg;
		}

		public void setChkFlg(String[] chkFlg) {
			this.chkFlg = chkFlg;
		}


	
	
	
	public String[] getStrHidValueFlag() {
			return strHidValueFlag;
		}

		public void setStrHidValueFlag(String[] strHidValueFlag) {
			this.strHidValueFlag = strHidValueFlag;
		}

		public String[] getStrCheckHidValue() {
			return strCheckHidValue;
		}

		public void setStrCheckHidValue(String[] strCheckHidValue) {
			this.strCheckHidValue = strCheckHidValue;
		}

	public String[] getItemUserValue() {
			return itemUserValue;
		}

		public void setItemUserValue(String[] itemUserValue) {
			this.itemUserValue = itemUserValue;
		}

	public String getStrSearchType() {
			return strSearchType;
		}

		public void setStrSearchType(String strSearchType) {
			this.strSearchType = strSearchType;
		}

	public String[] getStrNewSampleIssueQty() {
			return strNewSampleIssueQty;
		}

		public void setStrNewSampleIssueQty(String[] strNewSampleIssueQty) {
			this.strNewSampleIssueQty = strNewSampleIssueQty;
		}

		public String[] getStrNewSampleCodeNumber() {
			return strNewSampleCodeNumber;
		}

		public void setStrNewSampleCodeNumber(String[] strNewSampleCodeNumber) {
			this.strNewSampleCodeNumber = strNewSampleCodeNumber;
		}

	public String getStrLabCode() {
		return strLabCode;
	}

	public void setStrLabCode(String strLabCode) {
		this.strLabCode = strLabCode;
	}

	public String getStrDrugName() {
		return strDrugName;
	}

	public void setStrDrugName(String strDrugName) {
		this.strDrugName = strDrugName;
	}

	public String getStrDescription() {
		return strDescription;
	}

	public void setStrDescription(String strDescription) {
		this.strDescription = strDescription;
	}

	public String getStrLabName() {
		return strLabName;
	}

	public void setStrLabName(String strLabName) {
		this.strLabName = strLabName;
	}

	public String getStrItemBrandId() {
		return strItemBrandId;
	}

	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
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

	public WebRowSet getWsItemCategoryCombo() {
		return wsItemCategoryCombo;
	}

	public void setWsItemCategoryCombo(WebRowSet wsItemCategoryCombo) {
		this.wsItemCategoryCombo = wsItemCategoryCombo;
	}

	public String getStrTypeMode() {
		return strTypeMode;
	}

	public void setStrTypeMode(String strTypeMode) {
		this.strTypeMode = strTypeMode;
	}
	
	public WebRowSet getApprovedByWS() {
		return approvedByWS;
	}

	public void setApprovedByWS(WebRowSet approvedByWS) {
		this.approvedByWS = approvedByWS;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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

	public String[] getItemParamValue() {
		return itemParamValue;
	}

	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
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

	public String getStrBkgEntryDate() {
		return strBkgEntryDate;
	}

	public void setStrBkgEntryDate(String strBkgEntryDate) {
		this.strBkgEntryDate = strBkgEntryDate;
	}

	/**********Current Date*************/
	public String getStrCtDate() 
	{
		HisUtil util = new HisUtil("Breakge Item Detail Transaction", "BreakgeItemDtlTransVO");
		try {
			strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;
		} catch (Exception e) {
			new HisException("MMS Module", "Breakge Item Detail Transaction",
					"BreakgeItemDtlTransVO.getStrCtDate()-->" + e.getMessage());
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

	public String getStrStoreName() {
		return strStoreName;
	}

	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public WebRowSet getGroupWs() {
		return GroupWs;
	}

	public void setGroupWs(WebRowSet groupWs) {
		GroupWs = groupWs;
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

	public String getStrItemCatNo() {
		return strItemCatNo;
	}

	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
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

	public String getStrApprovedDate() {
		return strApprovedDate;
	}

	public void setStrApprovedDate(String strApprovedDate) {
		this.strApprovedDate = strApprovedDate;
	}

	public WebRowSet getBreakageItemWS() {
		return breakageItemWS;
	}

	public void setBreakageItemWS(WebRowSet breakageItemWS) {
		this.breakageItemWS = breakageItemWS;
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

	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	public String getStrReSendFlg() {
		return strReSendFlg;
	}

	public void setStrReSendFlg(String strReSendFlg) {
		this.strReSendFlg = strReSendFlg;
	}

	public WebRowSet getWsDrugNameCombo() {
		return wsDrugNameCombo;
	}

	public void setWsDrugNameCombo(WebRowSet wsDrugNameCombo) {
		this.wsDrugNameCombo = wsDrugNameCombo;
	}

	public WebRowSet getWsDrugBatchCombo() {
		return wsDrugBatchCombo;
	}

	public void setWsDrugBatchCombo(WebRowSet wsDrugBatchCombo) {
		this.wsDrugBatchCombo = wsDrugBatchCombo;
	}

	public String getStrBatchDetails() {
		return strBatchDetails;
	}

	public void setStrBatchDetails(String strBatchDetails) {
		this.strBatchDetails = strBatchDetails;
	}

	public String getStrModuleId() {
		return strModuleId;
	}

	public void setStrModuleId(String strModuleId) {
		this.strModuleId = strModuleId;
	}

	public String getStrUnitRateID() {
		return strUnitRateID;
	}

	public void setStrUnitRateID(String strUnitRateID) {
		this.strUnitRateID = strUnitRateID;
	}

	public WebRowSet getWsUnitCombo() {
		return wsUnitCombo;
	}

	public void setWsUnitCombo(WebRowSet wsUnitCombo) {
		this.wsUnitCombo = wsUnitCombo;
	}

	public WebRowSet getWsLabNameCombo() {
		return wsLabNameCombo;
	}

	public void setWsLabNameCombo(WebRowSet wsLabNameCombo) {
		this.wsLabNameCombo = wsLabNameCombo;
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

	public String getStrLabSendNo() {
		return strLabSendNo;
	}

	public void setStrLabSendNo(String strLabSendNo) {
		this.strLabSendNo = strLabSendNo;
	}

	public WebRowSet getWsLabSentHlp() {
		return wsLabSentHlp;
	}

	public void setWsLabSentHlp(WebRowSet wsLabSentHlp) {
		this.wsLabSentHlp = wsLabSentHlp;
	}

	public WebRowSet getIndentItemWS() {
		return indentItemWS;
	}

	public void setIndentItemWS(WebRowSet indentItemWS) {
		this.indentItemWS = indentItemWS;
	}

	public String[] getHiddenValue() {
		return hiddenValue;
	}

	public void setHiddenValue(String[] hiddenValue) {
		this.hiddenValue = hiddenValue;
	}

	public String getStrSearchNameType() {
		return strSearchNameType;
	}

	public void setStrSearchNameType(String strSearchNameType) {
		this.strSearchNameType = strSearchNameType;
	}
}



