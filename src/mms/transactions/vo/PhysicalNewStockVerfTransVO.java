package mms.transactions.vo;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

public class PhysicalNewStockVerfTransVO {

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
	
	private String strBrandId;
	private String strRequestDate="";
	private String strPhyDetails="";
	private String strCountQty;
	private String strItemBrandName;
	private String strManufactureDate;
	private String strExpiryDate;
	private String strIsValid;
	private String strSupplierId;
	private String strSupplierName;
	private String strItemInStockFlg;
	private String strRateContractDtl;
	private String strRate;
	private String strRateUnitId;
	private String strRateUnitName;
	private String strCatcode;
	 private String strCategorycode="";
	public String getStrCategorycode() {
		return strCategorycode;
	}

	public void setStrCategorycode(String strCategorycode) {
		this.strCategorycode = strCategorycode;
	}

	public String getStrCatcode() {
		return strCatcode;
	}

	public void setStrCatcode(String strCatcode) {
		this.strCatcode = strCatcode;
	}

	private WebRowSet  ItemCategWS= null;
	public WebRowSet getItemCategWS() {
		return ItemCategWS;
	}

	public void setItemCategWS(WebRowSet itemCategWS) {
		ItemCategWS = itemCategWS;
	}

	private WebRowSet unitNameComboWS = null;
	private WebRowSet prevPhyStockReqHlpWS = null;
	private String strPhyStockVerifiedItemDtls="";
	private WebRowSet phyStockVerifiedItemDtlsHlp = null;
    private String strGroupNameCombo="";
    private String strDrugNameCombo="";
    private String strMfgNameCombo="";
    private String strUnitNameCombo="";
    private String strHospCode;
    public String getStrHospCode() {
		return strHospCode;
	}

	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}

	private String strStockStatusCombo="";
    private String strCurrentDate="";
    private String strPhyStockFlag="";
    private String strPhyStockNo="";
    private WebRowSet unitlityProcWS = null;
    private WebRowSet strIndentDetailsWs = null;
    private String[] strMultiRowPKKey1 = { "" };
    private String[] strMultiRowPKKey2 = { "" };
    private String[] strVerifyCountedQty = { "" };
    private String[] strNewItemFlg = { "" };
    private String[] strItemRemarks = { "" };
    private String[] strHiddenValue = {""};
    private String[] strPKKey = {""};
    
    private String[] strMultiExpiryDate = { "" };
    private String[] strMultiMfgDate = { "" };
    private String[] strMultiSupplierId= { "" };
    private String[] strMultiTenderNo= { "" };
    private String[] strMultiRateUnitId= { "" };
    private String[] strRateWithBaseValue= { "" };
    private String[] strMultiNewItemFlg = {""};
    private String[] strMultiRemarks = {""};
    
	private String   strDraftFlg = "";    
	private String   strModifyFlg = "";
	private String   strStockUpdateFlg = "";    
	private String   strCancelFlg = "";
	private String   strVerifiedPageFlg="";
	private String   strRequestDtls="";
	private String   strStoreNameText="";
	private String   strPKey="";
	
	private String strReqStatus="";
	private String strUserLevel="";
	private String strUserId="";
	private String strLevelType="";
	private String strReqTypeId="";
	private String strItemCatgNo="";
	private String strToStoreId="";
    private String strIndentName = "";   
    private String strReApprovalFlag="";
    private String strApprovalType="";
    private String strApprovalNo="";
    private String strIPAdd="";
   
	
	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str seat id. */
	private String strSeatId = "";
	
	private String strTolranceLimit = "";

	/** The str group id. */
	private String strGroupId = "0";

	/** The str ct date. */
	private String strCtDate = "";

	/** ********** Variable Start Here *****************. */
	private String strItemCatNo = "";

	/** The str item catg combo. */
	private String strItemCatgCombo = "";

	/** The str store id. */
	private String strStoreId = "0";

	/** The str bkg entry date. */
	private String strBkgEntryDate = "";

	/** The str store name. */
	private String strStoreName = "";

	/** The Group ws. */
	private WebRowSet GroupWs = null;
	
	private String strSupplierList = "";
	
	private String  strDrugList = "";

	
	private String strCurrFY = null;

	/** The breakage item ws. */
	private WebRowSet breakageItemWS = null;
	
	private WebRowSet strSupplierComboWS = null;
	
	private String strProgNameComboWS = null;
	
	private WebRowSet strItemListWs = null;
	
	private String strBatchNo=null;

	private String strMfgDate=null;

	private String strExpDate=null;

	private String strCountedQty=null;

	private String strDrugRemarks=null;

	/** The str store type id. */
	private String strStoreTypeId = "";

	/** The str group id for item search. */
	private String strGroupIdForItemSearch = "";

	/** The str cost final. */
	private String[] strCostFinal = null;

	/** The str approx amt. */
	private String strApproxAmt = "";

	/** The item param value. */
	private String[] itemParamValue = { "" };

	/** The str bkg qty. */
	private String[] strBkgQty = { "" };

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

	/** The str approved date. */
	private String strApprovedDate = "";

	/** The str financial end year. */
	private String strFinancialEndYear = "";

	/** The str from date. */
	private String strFromDate;

	/** The str to date. */
	private String strToDate;

	/** The approved by ws. */
	private WebRowSet approvedByWS = null;

	/** The str type mode. */
	private String strTypeMode;

	private String strMode;
	private String strReqNo;
	private String strStatus;
	private String strApprovalFlag;
	private String strIssueDate;
	private String strIssueTo;
	private String strItemId = "";

	private String strItemCategoryId = "0";
	private String strPhysicalStockNo = "0";

	private String strStockNo="";
	private String strItemCategNo="";
	private String strFinancialStartDate = "";
	private String strCategoryName = "";
	private String strLastVerifiedDate = "";
	private String strCommitteeTypeId="";
	private String strPrevCountedFlag= "";
	private String[] strItemBrandId = null;
	private String[] strBatchSlNo = null;

	private String[] strCountedQtyUnitId = null;
	private String[] strMulCountedQty = null;
	private String[] strInHandQty = null;
	private String[] strInHandQtyUnitId = null;
	private String[] strToBeCountedItemBatchDtls=null;
	private String[] strVarianceQty=null;
	private String[] strVarianceCost=null;

	private String strPhysicalCount = "0";

	private String []strCountedItemDtls=null;
	private String strFromRow = "0";
	private String strToRow = "0";
	private String[] strCountedDtls = null;
	private String strCountedQtyBatchWise="";
	private String strCommiteeTypeId="";
	private String[] strMemberRecommendation=null;
	private String[] strCommitteeMemberHidden=null;
	private String strFileExt="";
	private String strFileName="";
	private String strFileNo="";
	private String strPageNo="";
	
    private WebRowSet   WrsData;
	private String[]    strDrugDtls = null;
	private String[]    strTDrugName = null;
	private String[]    strTItemBrandId = null;
	private String[] 	strTCountQty= null;
	private String[] 	strTVariance= null;
	private String[] 	strTVarianceCost= null;
	private String[] 	strTAvlQty= null;
    private String[]    strMulCountedRemarks=null;
	
	
	
	public String getStrReqNo() {
		return strReqNo;
	}

	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}

	public String getStrMode() {
		return strMode;
	}

	public void setStrMode(String strMode) {
		this.strMode = strMode;
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
	 * Gets the approved by ws.
	 * 
	 * @return the approved by ws
	 */
	public WebRowSet getApprovedByWS() {
		return approvedByWS;
	}

	/**
	 * Sets the approved by ws.
	 * 
	 * @param approvedByWS
	 *            the new approved by ws
	 */
	public void setApprovedByWS(WebRowSet approvedByWS) {
		this.approvedByWS = approvedByWS;
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

	public String getStrProgNameComboWS() {
		return strProgNameComboWS;
	}

	public void setStrProgNameComboWS(String strProgNameComboWS) {
		this.strProgNameComboWS = strProgNameComboWS;
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
	 * Gets the str bkg entry date.
	 * 
	 * @return the str bkg entry date
	 */
	public String getStrBkgEntryDate() {
		return strBkgEntryDate;
	}

	/**
	 * Sets the str bkg entry date.
	 * 
	 * @param strBkgEntryDate
	 *            the new str bkg entry date
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
				"BreakgeItemDtlTransVO");
		try {
			strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;
		} catch (Exception e) {
			new HisException("MMS Module", "Breakge Item Detail Transaction",
					"BreakgeItemDtlTransVO.getStrCtDate()-->" + e.getMessage());
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
	 * Gets the ********** Variable Start Here *****************.
	 * 
	 * @return the ********** Variable Start Here *****************
	 */
	public String getStrItemCatNo() {
		return strItemCatNo;
	}

	/**
	 * Sets the ********** Variable Start Here *****************.
	 * 
	 * @param strItemCatNo
	 *            the new ********** Variable Start Here *****************
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
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
	 * Gets the breakage item ws.
	 * 
	 * @return the breakage item ws
	 */
	public WebRowSet getBreakageItemWS() {
		return breakageItemWS;
	}

	/**
	 * Sets the breakage item ws.
	 * 
	 * @param breakageItemWS
	 *            the new breakage item ws
	 */
	public void setBreakageItemWS(WebRowSet breakageItemWS) {
		this.breakageItemWS = breakageItemWS;
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
	 * Gets the str from date.
	 * 
	 * @return the str from date
	 */
	public String getStrFromDate() {
		return strFromDate;
	}

	/**
	 * Sets the str from date.
	 * 
	 * @param strFromDate
	 *            the new str from date
	 */
	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}

	/**
	 * Gets the str to date.
	 * 
	 * @return the str to date
	 */
	public String getStrToDate() {
		return strToDate;
	}

	/**
	 * Sets the str to date.
	 * 
	 * @param strToDate
	 *            the new str to date
	 */
	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}

	public String getStrStatus() {
		return strStatus;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	public String getStrApprovalFlag() {
		return strApprovalFlag;
	}

	public void setStrApprovalFlag(String strApprovalFlag) {
		this.strApprovalFlag = strApprovalFlag;
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

	public String getStrCurrFY() {
		return strCurrFY;
	}

	public void setStrCurrFY(String strCurrFY) {
		this.strCurrFY = strCurrFY;
	}

	public String getStrTolranceLimit() {
		return strTolranceLimit;
	}

	public void setStrTolranceLimit(String strTolranceLimit) {
		this.strTolranceLimit = strTolranceLimit;
	}

	public WebRowSet getStrSupplierComboWS() {
		return strSupplierComboWS;
	}

	public void setStrSupplierComboWS(WebRowSet strSupplierComboWS) {
		this.strSupplierComboWS = strSupplierComboWS;
	}

	public WebRowSet getStrItemListWs() {
		return strItemListWs;
	}

	public void setStrItemListWs(WebRowSet strItemListWs) {
		this.strItemListWs = strItemListWs;
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

	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	public String getStrItemId() {
		return strItemId;
	}

	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}

	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}

	public String getStrPhysicalStockNo() {
		return strPhysicalStockNo;
	}

	public void setStrPhysicalStockNo(String strPhysicalStockNo) {
		this.strPhysicalStockNo = strPhysicalStockNo;
	}

	public String getStrStockNo() {
		return strStockNo;
	}

	public void setStrStockNo(String strStockNo) {
		this.strStockNo = strStockNo;
	}

	public String getStrItemCategNo() {
		return strItemCategNo;
	}

	public void setStrItemCategNo(String strItemCategNo) {
		this.strItemCategNo = strItemCategNo;
	}

	public String getStrFinancialStartDate() {
		return strFinancialStartDate;
	}

	public void setStrFinancialStartDate(String strFinancialStartDate) {
		this.strFinancialStartDate = strFinancialStartDate;
	}

	public String getStrCategoryName() {
		return strCategoryName;
	}

	public void setStrCategoryName(String strCategoryName) {
		this.strCategoryName = strCategoryName;
	}

	public String getStrLastVerifiedDate() {
		return strLastVerifiedDate;
	}

	public void setStrLastVerifiedDate(String strLastVerifiedDate) {
		this.strLastVerifiedDate = strLastVerifiedDate;
	}

	public String getStrCommitteeTypeId() {
		return strCommitteeTypeId;
	}

	public void setStrCommitteeTypeId(String strCommitteeTypeId) {
		this.strCommitteeTypeId = strCommitteeTypeId;
	}

	public String getStrPrevCountedFlag() {
		return strPrevCountedFlag;
	}

	public void setStrPrevCountedFlag(String strPrevCountedFlag) {
		this.strPrevCountedFlag = strPrevCountedFlag;
	}

	public String[] getStrItemBrandId() {
		return strItemBrandId;
	}

	public void setStrItemBrandId(String[] strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	public String[] getStrBatchSlNo() {
		return strBatchSlNo;
	}

	public void setStrBatchSlNo(String[] strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
	}

	public String[] getStrCountedQtyUnitId() {
		return strCountedQtyUnitId;
	}

	public void setStrCountedQtyUnitId(String[] strCountedQtyUnitId) {
		this.strCountedQtyUnitId = strCountedQtyUnitId;
	}

	public String[] getStrMulCountedQty() {
		return strMulCountedQty;
	}

	public void setStrMulCountedQty(String[] strMulCountedQty) {
		this.strMulCountedQty = strMulCountedQty;
	}

	public String[] getStrInHandQty() {
		return strInHandQty;
	}

	public void setStrInHandQty(String[] strInHandQty) {
		this.strInHandQty = strInHandQty;
	}

	public String[] getStrInHandQtyUnitId() {
		return strInHandQtyUnitId;
	}

	public void setStrInHandQtyUnitId(String[] strInHandQtyUnitId) {
		this.strInHandQtyUnitId = strInHandQtyUnitId;
	}

	public String[] getStrToBeCountedItemBatchDtls() {
		return strToBeCountedItemBatchDtls;
	}

	public void setStrToBeCountedItemBatchDtls(String[] strToBeCountedItemBatchDtls) {
		this.strToBeCountedItemBatchDtls = strToBeCountedItemBatchDtls;
	}

	public String[] getStrVarianceQty() {
		return strVarianceQty;
	}

	public void setStrVarianceQty(String[] strVarianceQty) {
		this.strVarianceQty = strVarianceQty;
	}

	public String[] getStrVarianceCost() {
		return strVarianceCost;
	}

	public void setStrVarianceCost(String[] strVarianceCost) {
		this.strVarianceCost = strVarianceCost;
	}

	public String getStrPhysicalCount() {
		return strPhysicalCount;
	}

	public void setStrPhysicalCount(String strPhysicalCount) {
		this.strPhysicalCount = strPhysicalCount;
	}

	public String[] getStrCountedItemDtls() {
		return strCountedItemDtls;
	}

	public void setStrCountedItemDtls(String[] strCountedItemDtls) {
		this.strCountedItemDtls = strCountedItemDtls;
	}

	public String getStrFromRow() {
		return strFromRow;
	}

	public void setStrFromRow(String strFromRow) {
		this.strFromRow = strFromRow;
	}

	public String getStrToRow() {
		return strToRow;
	}

	public void setStrToRow(String strToRow) {
		this.strToRow = strToRow;
	}

	public String[] getStrCountedDtls() {
		return strCountedDtls;
	}

	public void setStrCountedDtls(String[] strCountedDtls) {
		this.strCountedDtls = strCountedDtls;
	}

	public String getStrCountedQtyBatchWise() {
		return strCountedQtyBatchWise;
	}

	public void setStrCountedQtyBatchWise(String strCountedQtyBatchWise) {
		this.strCountedQtyBatchWise = strCountedQtyBatchWise;
	}

	public String getStrCommiteeTypeId() {
		return strCommiteeTypeId;
	}

	public void setStrCommiteeTypeId(String strCommiteeTypeId) {
		this.strCommiteeTypeId = strCommiteeTypeId;
	}

	public String[] getStrMemberRecommendation() {
		return strMemberRecommendation;
	}

	public void setStrMemberRecommendation(String[] strMemberRecommendation) {
		this.strMemberRecommendation = strMemberRecommendation;
	}

	public String[] getStrCommitteeMemberHidden() {
		return strCommitteeMemberHidden;
	}

	public void setStrCommitteeMemberHidden(String[] strCommitteeMemberHidden) {
		this.strCommitteeMemberHidden = strCommitteeMemberHidden;
	}

	public String getStrFileExt() {
		return strFileExt;
	}

	public void setStrFileExt(String strFileExt) {
		this.strFileExt = strFileExt;
	}

	public String getStrFileName() {
		return strFileName;
	}

	public void setStrFileName(String strFileName) {
		this.strFileName = strFileName;
	}

	public String getStrFileNo() {
		return strFileNo;
	}

	public void setStrFileNo(String strFileNo) {
		this.strFileNo = strFileNo;
	}

	public String getStrPageNo() {
		return strPageNo;
	}

	public void setStrPageNo(String strPageNo) {
		this.strPageNo = strPageNo;
	}

	public String getStrBrandId() {
		return strBrandId;
	}

	public void setStrBrandId(String strBrandId) {
		this.strBrandId = strBrandId;
	}

	public String getStrCountQty() {
		return strCountQty;
	}

	public void setStrCountQty(String strCountQty) {
		this.strCountQty = strCountQty;
	}

	public String getStrItemBrandName() {
		return strItemBrandName;
	}

	public void setStrItemBrandName(String strItemBrandName) {
		this.strItemBrandName = strItemBrandName;
	}

	public String getStrManufactureDate() {
		return strManufactureDate;
	}

	public void setStrManufactureDate(String strManufactureDate) {
		this.strManufactureDate = strManufactureDate;
	}

	public String getStrExpiryDate() {
		return strExpiryDate;
	}

	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}

	public String getStrIsValid() {
		return strIsValid;
	}

	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	public String getStrSupplierId() {
		return strSupplierId;
	}

	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	public String getStrSupplierName() {
		return strSupplierName;
	}

	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}

	public String getStrItemInStockFlg() {
		return strItemInStockFlg;
	}

	public void setStrItemInStockFlg(String strItemInStockFlg) {
		this.strItemInStockFlg = strItemInStockFlg;
	}

	public String getStrRateContractDtl() {
		return strRateContractDtl;
	}

	public void setStrRateContractDtl(String strRateContractDtl) {
		this.strRateContractDtl = strRateContractDtl;
	}

	public String getStrRate() {
		return strRate;
	}

	public void setStrRate(String strRate) {
		this.strRate = strRate;
	}

	public String getStrRateUnitId() {
		return strRateUnitId;
	}

	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}

	public String getStrRateUnitName() {
		return strRateUnitName;
	}

	public void setStrRateUnitName(String strRateUnitName) {
		this.strRateUnitName = strRateUnitName;
	}

	public WebRowSet getWrsData() {
		return WrsData;
	}

	public void setWrsData(WebRowSet wrsData) {
		WrsData = wrsData;
	}

	public String[] getStrDrugDtls() {
		return strDrugDtls;
	}

	public void setStrDrugDtls(String[] strDrugDtls) {
		this.strDrugDtls = strDrugDtls;
	}

	public String[] getStrTDrugName() {
		return strTDrugName;
	}

	public void setStrTDrugName(String[] strTDrugName) {
		this.strTDrugName = strTDrugName;
	}

	public String[] getStrTItemBrandId() {
		return strTItemBrandId;
	}

	public void setStrTItemBrandId(String[] strTItemBrandId) {
		this.strTItemBrandId = strTItemBrandId;
	}

	public String[] getStrTCountQty() {
		return strTCountQty;
	}

	public void setStrTCountQty(String[] strTCountQty) {
		this.strTCountQty = strTCountQty;
	}

	public String[] getStrTVariance() {
		return strTVariance;
	}

	public void setStrTVariance(String[] strTVariance) {
		this.strTVariance = strTVariance;
	}

	public String[] getStrTVarianceCost() {
		return strTVarianceCost;
	}

	public void setStrTVarianceCost(String[] strTVarianceCost) {
		this.strTVarianceCost = strTVarianceCost;
	}

	public String[] getStrTAvlQty() {
		return strTAvlQty;
	}

	public void setStrTAvlQty(String[] strTAvlQty) {
		this.strTAvlQty = strTAvlQty;
	}

	public String[] getStrMulCountedRemarks() {
		return strMulCountedRemarks;
	}

	public void setStrMulCountedRemarks(String[] strMulCountedRemarks) {
		this.strMulCountedRemarks = strMulCountedRemarks;
	}

	public String getStrPhyDetails() {
		return strPhyDetails;
	}

	public void setStrPhyDetails(String strPhyDetails) {
		this.strPhyDetails = strPhyDetails;
	}

	public WebRowSet getPrevPhyStockReqHlpWS() {
		return prevPhyStockReqHlpWS;
	}

	public void setPrevPhyStockReqHlpWS(WebRowSet prevPhyStockReqHlpWS) {
		this.prevPhyStockReqHlpWS = prevPhyStockReqHlpWS;
	}

	public String getStrPhyStockVerifiedItemDtls() {
		return strPhyStockVerifiedItemDtls;
	}

	public void setStrPhyStockVerifiedItemDtls(String strPhyStockVerifiedItemDtls) {
		this.strPhyStockVerifiedItemDtls = strPhyStockVerifiedItemDtls;
	}

	public WebRowSet getPhyStockVerifiedItemDtlsHlp() {
		return phyStockVerifiedItemDtlsHlp;
	}

	public void setPhyStockVerifiedItemDtlsHlp(WebRowSet phyStockVerifiedItemDtlsHlp) {
		this.phyStockVerifiedItemDtlsHlp = phyStockVerifiedItemDtlsHlp;
	}

	public WebRowSet getUnitNameComboWS() {
		return unitNameComboWS;
	}

	public void setUnitNameComboWS(WebRowSet unitNameComboWS) {
		this.unitNameComboWS = unitNameComboWS;
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

	public String getStrCurrentDate() {
		return strCurrentDate;
	}

	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}

	public String getStrStockStatusCombo() {
		return strStockStatusCombo;
	}

	public void setStrStockStatusCombo(String strStockStatusCombo) {
		this.strStockStatusCombo = strStockStatusCombo;
	}

	public String getStrPhyStockFlag() {
		return strPhyStockFlag;
	}

	public void setStrPhyStockFlag(String strPhyStockFlag) {
		this.strPhyStockFlag = strPhyStockFlag;
	}

	public String getStrPhyStockNo() {
		return strPhyStockNo;
	}

	public void setStrPhyStockNo(String strPhyStockNo) {
		this.strPhyStockNo = strPhyStockNo;
	}

	public WebRowSet getUnitlityProcWS() {
		return unitlityProcWS;
	}

	public void setUnitlityProcWS(WebRowSet unitlityProcWS) {
		this.unitlityProcWS = unitlityProcWS;
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

	public String getStrPKey() {
		return strPKey;
	}

	public void setStrPKey(String strPKey) {
		this.strPKey = strPKey;
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

	public String getStrReqTypeId() {
		return strReqTypeId;
	}

	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
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

	public WebRowSet getStrIndentDetailsWs() {
		return strIndentDetailsWs;
	}

	public void setStrIndentDetailsWs(WebRowSet strIndentDetailsWs) {
		this.strIndentDetailsWs = strIndentDetailsWs;
	}

	public String getStrIndentName() {
		return strIndentName;
	}

	public void setStrIndentName(String strIndentName) {
		this.strIndentName = strIndentName;
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

	public String getStrIPAdd() {
		return strIPAdd;
	}

	public void setStrIPAdd(String strIPAdd) {
		this.strIPAdd = strIPAdd;
	}

	public String[] getStrMultiRemarks() {
		return strMultiRemarks;
	}

	public void setStrMultiRemarks(String[] strMultiRemarks) {
		this.strMultiRemarks = strMultiRemarks;
	}

	public String getStrRequestDate() {
		return strRequestDate;
	}

	public void setStrRequestDate(String strRequestDate) {
		this.strRequestDate = strRequestDate;
	}
}
