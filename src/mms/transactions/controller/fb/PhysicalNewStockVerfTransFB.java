package mms.transactions.controller.fb;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericFormBean;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

public class PhysicalNewStockVerfTransFB extends GenericFormBean
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str err. */
	private String strErr = "";

	/** The str msg. */
	private String strMsg = "";

	/** The str warning. */
	private String strWarning = "";

	/** The str msg string. */
	private String strMsgString = "";

	/** The str msg type. */
	private String strMsgType = "";

	/** The str err msg. */
	private String strErrMsg = "";

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str group id. */
	private String strGroupId = "";

	/** The str ct date. */
	private String strCtDate = "";

	/** The str seat id. */
	private String strSeatId = "";
	
	private String strChk = "";
	
	private String strTolranceLimit = null;
	
	private String strPhyStockRequestDtls="";
	
	private String strPhyStockVerifiedItemDtls="";

	/** The str view chk. */
	private String strViewChk = "";
	
	private String strReqTypeId = "";
	
	private String strPath = "";
	
	private String strSupplierList = "";
	
	private String  strDrugList = "";
	private String strPhyDetails="";

	private String strBatchNo=null;

	private String strMfgDate=null;

	private String strExpDate=null;

	private String strCountedQty=null;

	private String strDrugRemarks=null;
	
    private String strGroupNameCombo="";
    private String strDrugNameCombo="";
    private String strMfgNameCombo="";
    private String strUnitNameCombo="";
    private String strStoreNameText="";
    private String strApprovalFlag="";
    private String strReApprovalFlag="";
    private String strCatName="";
    private String strCatcode="";
    private String strItemCatcode="";
    private String strCategorycode="";
    
	public String getStrCategorycode() {
		return strCategorycode;
	}

	public void setStrCategorycode(String strCategorycode) {
		this.strCategorycode = strCategorycode;
	}

	public String getStrItemCatcode() {
		return strItemCatcode;
	}

	public void setStrItemCatcode(String strItemCatcode) {
		this.strItemCatcode = strItemCatcode;
	}

	public String getStrCatcode() {
		return strCatcode;
	}

	public void setStrCatcode(String strCatcode) {
		this.strCatcode = strCatcode;
	}

	public String getStrCatName() {
		return strCatName;
	}

	public void setStrCatName(String strCatName) {
		this.strCatName = strCatName;
	}

	private String strReqStatus="";
	private String strUserLevel="";
	private String strUserId="";
	private String strLevelType="";
	private String strItemCatgNo="";
	private String strToStoreId="";
    private String strSetApprovedDetails = "";
    private String strIndentDetails = "";
    private String strApprovalType="";
    private String strApprovalNo="";

    
    private String[] strMultiRowPKKey1 = { "" };
    private String[] strMultiRowPKKey2 = { "" };
    private String[] strVerifyCountedQty = { "" };
    private String[] strNewItemFlg = { "" };
    private String[] strItemRemarks = { "" };  
    private String[] strHiddenValue = {""};
    private String[] strMultiExpiryDate = { "" };
    private String[] strMultiMfgDate = { "" };
    private String[] strMultiSupplierId= { "" };
    private String[] strMultiTenderNo= { "" };
    private String[] strMultiRateUnitId= { "" };
    private String[] strRateWithBaseValue= { "" };
    private String[] strPKKey = {""};
    private String[] strMultiNewItemFlg = {""};
    private String[] strMultiRemarks = {""};
    
	private String   strDraftFlg = "";    
	private String   strModifyFlg = "";	
	private String   strStockUpdateFlg = "";    
	private String   strCancelFlg = "";
	private String   strVerifiedPageFlg="";
	private String   strRequestDtls="";
	private String   strDiscItemDetails="";
	private String   strNonDiscItemDetails="";
	
	/** ********** Variable Start Here *****************. */
	private String strBkgEntryDate = "";
	
	private String strCurrFY = null;

	/** The str item catg combo. */
	private String strItemCatgCombo = "";

	/** The str store id. */
	private String strStoreId = "";

	/** The str store name. */
	private String strStoreName = "";

	/** The Group ws. */
	private WebRowSet GroupWs = null;

	/** The str store type id. */
	private String strStoreTypeId = "";

	/** The str group id for item search. */
	private String strGroupIdForItemSearch = "";

	/** The item param value. */
	private String[] itemParamValue = { "" };

	/** The str bkg qty. */
	private String[] strBkgQty = { "" };

	/** The str cost final. */
	private String[] strCostFinal = null;

	/** The str unit name. */
	private String[] strUnitName = { "" };

	/** The str remarks. */
	private String strRemarks = "";

	/** The str financial start year. */
	private String strFinancialStartYear = "";

	/** The str approved by. */
	private String strApprovedBy = "";

	/** The str aproved remarks. */
	private String strAprovedRemarks = "";

	/** The str approved by values. */
	private String strApprovedByValues = "";

	/** The str current date. */
	private String strCurrentDate = "";

	/** The str approved date. */
	private String strApprovedDate = "";

	/** The str financial end year. */
	private String strFinancialEndYear = "";

	/** The str breakage item dtl val. */
	private String strBreakageItemDtlVal = "";

	/** The str approx amt. */
	private String strApproxAmt = "";

	/** The str cost required. */
	private String strCostRequired = "";

	/** The str type mode. */
	private String strTypeMode;

	/** The str msg saved. */
	private String strMsgSaved = "";

	
	private String strPendingDtl="";
	private String strApprovalReq="";
	private String strReqNo="";
	private String strIssueNo = "";
	private String strHtmlCode = "";
	
	
	public String getStrIssueNo() {
		return strIssueNo;
	}

	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
	}

	public String getStrReqNo() {
		return strReqNo;
	}

	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}

	public String getStrPendingDtl() {
		return strPendingDtl;
	}

	public void setStrPendingDtl(String strPendingDtl) {
		this.strPendingDtl = strPendingDtl;
	}

	/**
	 * Gets the str msg saved.
	 * 
	 * @return the str msg saved
	 */
	public String getStrMsgSaved() {
		return strMsgSaved;
	}

	/**
	 * Sets the str msg saved.
	 * 
	 * @param strMsgSaved
	 *            the new str msg saved
	 */
	public void setStrMsgSaved(String strMsgSaved) {
		this.strMsgSaved = strMsgSaved;
	}

	/**
	 * Gets the str type mode.
	 * 
	 * @return the str type mode
	 */
	public String getStrTypeMode() {
		return strTypeMode;
	}

	/**
	 * Sets the str type mode.
	 * 
	 * @param strTypeMode
	 *            the new str type mode
	 */
	public void setStrTypeMode(String strTypeMode) {
		this.strTypeMode = strTypeMode;
	}

	/**
	 * Gets the str cost required.
	 * 
	 * @return the strCostRequired
	 */
	public String getStrCostRequired() {
		return strCostRequired;
	}

	/**
	 * Sets the str cost required.
	 * 
	 * @param strCostRequired
	 *            the strCostRequired to set
	 */
	public void setStrCostRequired(String strCostRequired) {
		this.strCostRequired = strCostRequired;
	}

	/**
	 * Gets the str approx amt.
	 * 
	 * @return the str approx amt
	 */
	public String getStrApproxAmt() {
		return strApproxAmt;
	}

	/**
	 * Sets the str approx amt.
	 * 
	 * @param strApproxAmt
	 *            the new str approx amt
	 */
	public void setStrApproxAmt(String strApproxAmt) {
		this.strApproxAmt = strApproxAmt;
	}

	/**
	 * Gets the str breakage item dtl val.
	 * 
	 * @return the str breakage item dtl val
	 */
	public String getStrBreakageItemDtlVal() {
		return strBreakageItemDtlVal;
	}

	/**
	 * Sets the str breakage item dtl val.
	 * 
	 * @param strBreakageItemDtlVal
	 *            the new str breakage item dtl val
	 */
	public void setStrBreakageItemDtlVal(String strBreakageItemDtlVal) {
		this.strBreakageItemDtlVal = strBreakageItemDtlVal;
	}

	/**
	 * Gets the str remarks.
	 * 
	 * @return the str remarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks
	 *            the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Gets the str group id for item search.
	 * 
	 * @return the str group id for item search
	 */
	public String getStrGroupIdForItemSearch() {
		return strGroupIdForItemSearch;
	}

	/**
	 * Sets the str group id for item search.
	 * 
	 * @param strGroupIdForItemSearch
	 *            the new str group id for item search
	 */
	public void setStrGroupIdForItemSearch(String strGroupIdForItemSearch) {
		this.strGroupIdForItemSearch = strGroupIdForItemSearch;
	}

	/**
	 * Gets the str store type id.
	 * 
	 * @return the str store type id
	 */
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}

	/**
	 * Sets the str store type id.
	 * 
	 * @param strStoreTypeId
	 *            the new str store type id
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}

	/**
	 * Gets the group ws.
	 * 
	 * @return the group ws
	 */
	public WebRowSet getGroupWs() {
		return GroupWs;
	}

	/**
	 * Sets the group ws.
	 * 
	 * @param groupWs
	 *            the new group ws
	 */
	public void setGroupWs(WebRowSet groupWs) {
		GroupWs = groupWs;
	}

	/**
	 * Gets the str store name.
	 * 
	 * @return the str store name
	 */
	public String getStrStoreName() {
		return strStoreName;
	}

	/**
	 * Sets the str store name.
	 * 
	 * @param strStoreName
	 *            the new str store name
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	/**
	 * Gets the ********** Variable Start Here *****************.
	 * 
	 * @return the ********** Variable Start Here *****************
	 */
	public String getStrBkgEntryDate() {
		return strBkgEntryDate;
	}

	/**
	 * Sets the ********** Variable Start Here *****************.
	 * 
	 * @param strBkgEntryDate
	 *            the new ********** Variable Start Here *****************
	 */
	public void setStrBkgEntryDate(String strBkgEntryDate) {
		this.strBkgEntryDate = strBkgEntryDate;
	}

	/**
	 * ******** Current Date ************.
	 * 
	 * @return the str ct date
	 */
	public String getStrCtDate() {
		HisUtil util = new HisUtil("Breakge Item Detail Transaction",
				"BreakgeItemDtlTransFB");
		try {
			strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;
		} catch (Exception e) {
			new HisException("MMS Module", "Breakge Item Detail Transaction",
					"BreakgeItemDtlTransFB.getStrCtDate()-->" + e.getMessage());
		}
		return strCtDate;

	}

	/**
	 * Gets the str err.
	 * 
	 * @return the str err
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr
	 *            the new str err
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * Gets the str msg.
	 * 
	 * @return the str msg
	 */
	public String getStrMsg() {
		return strMsg;
	}

	/**
	 * Sets the str msg.
	 * 
	 * @param strMsg
	 *            the new str msg
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	/**
	 * Gets the str warning.
	 * 
	 * @return the str warning
	 */
	public String getStrWarning() {
		return strWarning;
	}

	/**
	 * Sets the str warning.
	 * 
	 * @param strWarning
	 *            the new str warning
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}

	/**
	 * Gets the str msg string.
	 * 
	 * @return the str msg string
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/**
	 * Sets the str msg string.
	 * 
	 * @param strMsgString
	 *            the new str msg string
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/**
	 * Gets the str msg type.
	 * 
	 * @return the str msg type
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/**
	 * Sets the str msg type.
	 * 
	 * @param strMsgType
	 *            the new str msg type
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	/**
	 * Gets the str hospital code.
	 * 
	 * @return the str hospital code
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode
	 *            the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str group id.
	 * 
	 * @return the str group id
	 */
	public String getStrGroupId() {
		return strGroupId;
	}

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupId
	 *            the new str group id
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the str seat id
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId
	 *            the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the str err msg.
	 * 
	 * @return the str err msg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}

	/**
	 * Sets the str err msg.
	 * 
	 * @param strErrMsg
	 *            the new str err msg
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	/**
	 * Gets the item param value.
	 * 
	 * @return the item param value
	 */
	public String[] getItemParamValue() {
		return itemParamValue;
	}

	/**
	 * Sets the item param value.
	 * 
	 * @param itemParamValue
	 *            the new item param value
	 */
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}

	/**
	 * Gets the str bkg qty.
	 * 
	 * @return the str bkg qty
	 */
	public String[] getStrBkgQty() {
		return strBkgQty;
	}

	/**
	 * Sets the str bkg qty.
	 * 
	 * @param strBkgQty
	 *            the new str bkg qty
	 */
	public void setStrBkgQty(String[] strBkgQty) {
		this.strBkgQty = strBkgQty;
	}

	/**
	 * Gets the str unit name.
	 * 
	 * @return the str unit name
	 */
	public String[] getStrUnitName() {
		return strUnitName;
	}

	/**
	 * Sets the str unit name.
	 * 
	 * @param strUnitName
	 *            the new str unit name
	 */
	public void setStrUnitName(String[] strUnitName) {
		this.strUnitName = strUnitName;
	}

	/**
	 * Gets the str financial start year.
	 * 
	 * @return the str financial start year
	 */
	public String getStrFinancialStartYear() {
		return strFinancialStartYear;
	}

	/**
	 * Sets the str financial start year.
	 * 
	 * @param strFinancialStartYear
	 *            the new str financial start year
	 */
	public void setStrFinancialStartYear(String strFinancialStartYear) {
		this.strFinancialStartYear = strFinancialStartYear;
	}

	/**
	 * Gets the str financial end year.
	 * 
	 * @return the str financial end year
	 */
	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}

	/**
	 * Sets the str financial end year.
	 * 
	 * @param strFinancialEndYear
	 *            the new str financial end year
	 */
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}

	/**
	 * Gets the str item catg combo.
	 * 
	 * @return the str item catg combo
	 */
	public String getStrItemCatgCombo() {
		return strItemCatgCombo;
	}

	/**
	 * Sets the str item catg combo.
	 * 
	 * @param strItemCatgCombo
	 *            the new str item catg combo
	 */
	public void setStrItemCatgCombo(String strItemCatgCombo) {
		this.strItemCatgCombo = strItemCatgCombo;
	}

	/**
	 * Gets the str store id.
	 * 
	 * @return the str store id
	 */
	public String getStrStoreId() {
		return strStoreId;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId
	 *            the new str store id
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Gets the str approved by.
	 * 
	 * @return the str approved by
	 */
	public String getStrApprovedBy() {
		return strApprovedBy;
	}

	/**
	 * Sets the str approved by.
	 * 
	 * @param strApprovedBy
	 *            the new str approved by
	 */
	public void setStrApprovedBy(String strApprovedBy) {
		this.strApprovedBy = strApprovedBy;
	}

	/**
	 * Gets the str aproved remarks.
	 * 
	 * @return the str aproved remarks
	 */
	public String getStrAprovedRemarks() {
		return strAprovedRemarks;
	}

	/**
	 * Sets the str aproved remarks.
	 * 
	 * @param strAprovedRemarks
	 *            the new str aproved remarks
	 */
	public void setStrAprovedRemarks(String strAprovedRemarks) {
		this.strAprovedRemarks = strAprovedRemarks;
	}

	/**
	 * Gets the str approved by values.
	 * 
	 * @return the str approved by values
	 */
	public String getStrApprovedByValues() {
		return strApprovedByValues;
	}

	/**
	 * Sets the str approved by values.
	 * 
	 * @param strApprovedByValues
	 *            the new str approved by values
	 */
	public void setStrApprovedByValues(String strApprovedByValues) {
		this.strApprovedByValues = strApprovedByValues;
	}

	/**
	 * Gets the str current date.
	 * 
	 * @return the str current date
	 */
	public String getStrCurrentDate() {
		return strCurrentDate;
	}

	/**
	 * Sets the str current date.
	 * 
	 * @param strCurrentDate
	 *            the new str current date
	 */
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}

	/**
	 * Gets the str approved date.
	 * 
	 * @return the str approved date
	 */
	public String getStrApprovedDate() {
		return strApprovedDate;
	}

	/**
	 * Sets the str approved date.
	 * 
	 * @param strApprovedDate
	 *            the new str approved date
	 */
	public void setStrApprovedDate(String strApprovedDate) {
		this.strApprovedDate = strApprovedDate;
	}

	/**
	 * Sets the str ct date.
	 * 
	 * @param strCtDate
	 *            the new str ct date
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	/**
	 * Gets the str view chk.
	 * 
	 * @return the str view chk
	 */
	public String getStrViewChk() {
		return strViewChk;
	}

	/**
	 * Sets the str view chk.
	 * 
	 * @param strViewChk
	 *            the new str view chk
	 */
	public void setStrViewChk(String strViewChk) {
		this.strViewChk = strViewChk;
	}

	/**
	 * Gets the str cost final.
	 * 
	 * @return the str cost final
	 */
	public String[] getStrCostFinal() {
		return strCostFinal;
	}

	/**
	 * Sets the str cost final.
	 * 
	 * @param strCostFinal
	 *            the new str cost final
	 */
	public void setStrCostFinal(String[] strCostFinal) {
		this.strCostFinal = strCostFinal;
	}

	public String getStrApprovalReq() {
		return strApprovalReq;
	}

	public void setStrApprovalReq(String strApprovalReq) {
		this.strApprovalReq = strApprovalReq;
	}

	public String getStrHtmlCode() {
		return strHtmlCode;
	}

	public void setStrHtmlCode(String strHtmlCode) {
		this.strHtmlCode = strHtmlCode;
	}

	public String getStrTolranceLimit() {
		return strTolranceLimit;
	}

	public void setStrTolranceLimit(String strTolranceLimit) {
		this.strTolranceLimit = strTolranceLimit;
	}

	public String getStrCurrFY() {
		return strCurrFY;
	}

	public void setStrCurrFY(String strCurrFY) {
		this.strCurrFY = strCurrFY;
	}

	public String getStrSupplierList() {
		return strSupplierList;
	}

	public void setStrSupplierList(String strSupplierList) {
		this.strSupplierList = strSupplierList;
	}

	public String getStrDrugList() {
		return strDrugList;
	}

	public void setStrDrugList(String strDrugList) {
		this.strDrugList = strDrugList;
	}

	public String getStrBatchNo() {
		return strBatchNo;
	}

	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	public String getStrMfgDate() {
		return strMfgDate;
	}

	public void setStrMfgDate(String strMfgDate) {
		this.strMfgDate = strMfgDate;
	}

	public String getStrExpDate() {
		return strExpDate;
	}

	public void setStrExpDate(String strExpDate) {
		this.strExpDate = strExpDate;
	}

	public String getStrCountedQty() {
		return strCountedQty;
	}

	public void setStrCountedQty(String strCountedQty) {
		this.strCountedQty = strCountedQty;
	}

	public String getStrDrugRemarks() {
		return strDrugRemarks;
	}

	public void setStrDrugRemarks(String strDrugRemarks) {
		this.strDrugRemarks = strDrugRemarks;
	}

	public String getStrPhyDetails() {
		return strPhyDetails;
	}

	public void setStrPhyDetails(String strPhyDetails) {
		this.strPhyDetails = strPhyDetails;
	}

	public String getStrPhyStockRequestDtls() {
		return strPhyStockRequestDtls;
	}

	public void setStrPhyStockRequestDtls(String strPhyStockRequestDtls) {
		this.strPhyStockRequestDtls = strPhyStockRequestDtls;
	}

	public String getStrPhyStockVerifiedItemDtls() {
		return strPhyStockVerifiedItemDtls;
	}

	public void setStrPhyStockVerifiedItemDtls(String strPhyStockVerifiedItemDtls) {
		this.strPhyStockVerifiedItemDtls = strPhyStockVerifiedItemDtls;
	}

	public String getStrGroupNameCombo() {
		return strGroupNameCombo;
	}

	public void setStrGroupNameCombo(String strGroupNameCombo) {
		this.strGroupNameCombo = strGroupNameCombo;
	}

	public String getStrDrugNameCombo() {
		return strDrugNameCombo;
	}

	public void setStrDrugNameCombo(String strDrugNameCombo) {
		this.strDrugNameCombo = strDrugNameCombo;
	}

	public String getStrMfgNameCombo() {
		return strMfgNameCombo;
	}

	public void setStrMfgNameCombo(String strMfgNameCombo) {
		this.strMfgNameCombo = strMfgNameCombo;
	}

	public String getStrUnitNameCombo() {
		return strUnitNameCombo;
	}

	public void setStrUnitNameCombo(String strUnitNameCombo) {
		this.strUnitNameCombo = strUnitNameCombo;
	}

	public String[] getStrMultiRowPKKey1() {
		return strMultiRowPKKey1;
	}

	public void setStrMultiRowPKKey1(String[] strMultiRowPKKey1) {
		this.strMultiRowPKKey1 = strMultiRowPKKey1;
	}

	public String[] getStrMultiRowPKKey2() {
		return strMultiRowPKKey2;
	}

	public void setStrMultiRowPKKey2(String[] strMultiRowPKKey2) {
		this.strMultiRowPKKey2 = strMultiRowPKKey2;
	}

	public String[] getStrVerifyCountedQty() {
		return strVerifyCountedQty;
	}

	public void setStrVerifyCountedQty(String[] strVerifyCountedQty) {
		this.strVerifyCountedQty = strVerifyCountedQty;
	}

	public String[] getStrNewItemFlg() {
		return strNewItemFlg;
	}

	public void setStrNewItemFlg(String[] strNewItemFlg) {
		this.strNewItemFlg = strNewItemFlg;
	}

	public String[] getStrItemRemarks() {
		return strItemRemarks;
	}

	public void setStrItemRemarks(String[] strItemRemarks) {
		this.strItemRemarks = strItemRemarks;
	}

	public String getStrDraftFlg() {
		return strDraftFlg;
	}

	public void setStrDraftFlg(String strDraftFlg) {
		this.strDraftFlg = strDraftFlg;
	}

	public String getStrModifyFlg() {
		return strModifyFlg;
	}

	public void setStrModifyFlg(String strModifyFlg) {
		this.strModifyFlg = strModifyFlg;
	}

	public String[] getStrHiddenValue() {
		return strHiddenValue;
	}

	public void setStrHiddenValue(String[] strHiddenValue) {
		this.strHiddenValue = strHiddenValue;
	}

	public String[] getStrMultiExpiryDate() {
		return strMultiExpiryDate;
	}

	public void setStrMultiExpiryDate(String[] strMultiExpiryDate) {
		this.strMultiExpiryDate = strMultiExpiryDate;
	}

	public String[] getStrMultiMfgDate() {
		return strMultiMfgDate;
	}

	public void setStrMultiMfgDate(String[] strMultiMfgDate) {
		this.strMultiMfgDate = strMultiMfgDate;
	}

	public String[] getStrMultiSupplierId() {
		return strMultiSupplierId;
	}

	public void setStrMultiSupplierId(String[] strMultiSupplierId) {
		this.strMultiSupplierId = strMultiSupplierId;
	}

	public String[] getStrMultiTenderNo() {
		return strMultiTenderNo;
	}

	public void setStrMultiTenderNo(String[] strMultiTenderNo) {
		this.strMultiTenderNo = strMultiTenderNo;
	}

	public String[] getStrMultiRateUnitId() {
		return strMultiRateUnitId;
	}

	public void setStrMultiRateUnitId(String[] strMultiRateUnitId) {
		this.strMultiRateUnitId = strMultiRateUnitId;
	}

	public String[] getStrRateWithBaseValue() {
		return strRateWithBaseValue;
	}

	public void setStrRateWithBaseValue(String[] strRateWithBaseValue) {
		this.strRateWithBaseValue = strRateWithBaseValue;
	}

	public String[] getStrPKKey() {
		return strPKKey;
	}

	public void setStrPKKey(String[] strPKKey) {
		this.strPKKey = strPKKey;
	}

	public String getStrStockUpdateFlg() {
		return strStockUpdateFlg;
	}

	public void setStrStockUpdateFlg(String strStockUpdateFlg) {
		this.strStockUpdateFlg = strStockUpdateFlg;
	}

	public String getStrCancelFlg() {
		return strCancelFlg;
	}

	public void setStrCancelFlg(String strCancelFlg) {
		this.strCancelFlg = strCancelFlg;
	}

	public String getStrVerifiedPageFlg() {
		return strVerifiedPageFlg;
	}

	public void setStrVerifiedPageFlg(String strVerifiedPageFlg) {
		this.strVerifiedPageFlg = strVerifiedPageFlg;
	}

	public String[] getStrMultiNewItemFlg() {
		return strMultiNewItemFlg;
	}

	public void setStrMultiNewItemFlg(String[] strMultiNewItemFlg) {
		this.strMultiNewItemFlg = strMultiNewItemFlg;
	}

	public String getStrRequestDtls() {
		return strRequestDtls;
	}

	public void setStrRequestDtls(String strRequestDtls) {
		this.strRequestDtls = strRequestDtls;
	}

	public String getStrStoreNameText() {
		return strStoreNameText;
	}

	public void setStrStoreNameText(String strStoreNameText) {
		this.strStoreNameText = strStoreNameText;
	}

	public String getStrChk() {
		return strChk;
	}

	public void setStrChk(String strChk) {
		this.strChk = strChk;
	}

	public String getStrReqTypeId() {
		return strReqTypeId;
	}

	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}

	public String getStrPath() {
		return strPath;
	}

	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}

	public String getStrReqStatus() {
		return strReqStatus;
	}

	public void setStrReqStatus(String strReqStatus) {
		this.strReqStatus = strReqStatus;
	}

	public String getStrUserLevel() {
		return strUserLevel;
	}

	public void setStrUserLevel(String strUserLevel) {
		this.strUserLevel = strUserLevel;
	}

	public String getStrUserId() {
		return strUserId;
	}

	public void setStrUserId(String strUserId) {
		this.strUserId = strUserId;
	}

	public String getStrLevelType() {
		return strLevelType;
	}

	public void setStrLevelType(String strLevelType) {
		this.strLevelType = strLevelType;
	}

	public String getStrItemCatgNo() {
		return strItemCatgNo;
	}

	public void setStrItemCatgNo(String strItemCatgNo) {
		this.strItemCatgNo = strItemCatgNo;
	}

	public String getStrToStoreId() {
		return strToStoreId;
	}

	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}

	public String getStrSetApprovedDetails() {
		return strSetApprovedDetails;
	}

	public void setStrSetApprovedDetails(String strSetApprovedDetails) {
		this.strSetApprovedDetails = strSetApprovedDetails;
	}

	public String getStrIndentDetails() {
		return strIndentDetails;
	}

	public void setStrIndentDetails(String strIndentDetails) {
		this.strIndentDetails = strIndentDetails;
	}

	public String getStrDiscItemDetails() {
		return strDiscItemDetails;
	}

	public void setStrDiscItemDetails(String strDiscItemDetails) {
		this.strDiscItemDetails = strDiscItemDetails;
	}

	public String getStrNonDiscItemDetails() {
		return strNonDiscItemDetails;
	}

	public void setStrNonDiscItemDetails(String strNonDiscItemDetails) {
		this.strNonDiscItemDetails = strNonDiscItemDetails;
	}

	public String getStrApprovalFlag() {
		return strApprovalFlag;
	}

	public void setStrApprovalFlag(String strApprovalFlag) {
		this.strApprovalFlag = strApprovalFlag;
	}

	public String getStrReApprovalFlag() {
		return strReApprovalFlag;
	}

	public void setStrReApprovalFlag(String strReApprovalFlag) {
		this.strReApprovalFlag = strReApprovalFlag;
	}

	public String getStrApprovalType() {
		return strApprovalType;
	}

	public void setStrApprovalType(String strApprovalType) {
		this.strApprovalType = strApprovalType;
	}

	public String getStrApprovalNo() {
		return strApprovalNo;
	}

	public void setStrApprovalNo(String strApprovalNo) {
		this.strApprovalNo = strApprovalNo;
	}

	public String[] getStrMultiRemarks() {
		return strMultiRemarks;
	}

	public void setStrMultiRemarks(String[] strMultiRemarks) {
		this.strMultiRemarks = strMultiRemarks;
	}
}
