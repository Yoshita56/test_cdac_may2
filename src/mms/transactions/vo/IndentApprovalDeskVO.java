package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class IndentApprovalDeskVO 
{
	
    private String strHospCode ="";
    private String strSeatId ="";
    private String strChk ="";
    private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "0";
	private String strErrMsg = "";
	
	//Primary Key
	private String  strGrpId = "";
	private String[] strBatchNo        = {"0"};
	private String[] strItemSlNo       = {"0"};
	private String[] strStockStatusCode = {"0"};
	private String[] strInHandQty          = null;
	
	private String strBatchNoBlocked        = "";
	private String strItemSlNoBlocked       = "";
	private String strStockStatusCodeBlocked = "";
	private String strCommitteTypeName ="";
	private String strMultiRow="";
	private String strApprovalType = "";
	private String strReservUnReservQty ="";
	private String strCommitteTypeCode = "0";
	private String strCommitteRemarks = "";
	private String []strItemRemarks= null;
	private String strRasingRecevingFlg ="";
	private String strReturnTypeCmb ="";
	private String strDeliveryDate="";
	/* Web Row Set Variable */
	private WebRowSet strCommitteTypeWS = null;
	private WebRowSet strBlockedItemDetailsWs =null;
	private WebRowSet strItemDetailsWs =null;
	private WebRowSet strIndentDetailsWs = null;
	private WebRowSet strUnitComboWs = null;
	private WebRowSet strReceivedItemListWs = null;
	
	private String strRemarks ="";
	private String strToStoreId ="";
	private String strUnitCombo = "";
	private String strIndentName ="";
	private String strLevelType = "";
	private String strHospitalCode ="";
	private String strReqNo = "";
	private String strStoreId = "";
	private String strReqTypeId ="";
	private String strItemCatgNo = "";
	private String strIsUrgentFlg ="";
	private String strIndentPeriod="";
	private String strApprovedBy ="";
	private String strStockDtl ="";
	private String strApproved ="";
	private String strRejected ="";
	private String strIpAddr ="";
	private String[] strIssueFrmReservStock={"0"};
	private String[] strInsertHiddenValue =null;
	private String[] strInsUnitCombo=null;
	private String[] strInsSancQty=null;
	private String[] strHiddenValue=null;
	
	private String strItemId ="";
	private String strItemBrandId = "";
	private String strInsReqQty="";
	private String strInsReqQtyUnitId="";
	private String strFinancialStartYear = "";

	private String strFinancialEndYear = "";
	private String strReturnType   = "";
	private String strItemLength="";
	private String strStockDtlTwo;
	private String strTableWidth="825";
	private String strSpecialAppFlg="";
	private WebRowSet lastIssueQtyWs = null;	
	private String strLastAppLevel="";	
	private String strModeVal ="";
	private String strTostoreId ="";
	
	private String strDBTabel ="";

	
	
	public String getStrDBTabel() {
		return strDBTabel;
	}
	public void setStrDBTabel(String strDBTabel) {
		this.strDBTabel = strDBTabel;
	}
	public String getStrModeVal() {
		return strModeVal;
	}
	public void setStrModeVal(String strModeVal) {
		this.strModeVal = strModeVal;
	}
	public String getStrTostoreId() {
		return strTostoreId;
	}
	public void setStrTostoreId(String strTostoreId) {
		this.strTostoreId = strTostoreId;
	}
	
	public String getStrLastAppLevel() {
		return strLastAppLevel;
	}
	public void setStrLastAppLevel(String strLastAppLevel) {
		this.strLastAppLevel = strLastAppLevel;
	}
	public WebRowSet getLastIssueQtyWs() {
		return lastIssueQtyWs;
	}
	public void setLastIssueQtyWs(WebRowSet lastIssueQtyWs) {
		this.lastIssueQtyWs = lastIssueQtyWs;
	}
	public String getStrSpecialAppFlg() {
		return strSpecialAppFlg;
	}
	public void setStrSpecialAppFlg(String strSpecialAppFlg) {
		this.strSpecialAppFlg = strSpecialAppFlg;
	}
	public String getStrTableWidth() {
		return strTableWidth;
	}
	public void setStrTableWidth(String strTableWidth) {
		this.strTableWidth = strTableWidth;
	}
	/**
	 * @return the strItemLength
	 */
	public String getStrItemLength() {
		return strItemLength;
	}
	/**
	 * @param strItemLength the strItemLength to set
	 */
	public void setStrItemLength(String strItemLength) {
		this.strItemLength = strItemLength;
	}
	public String getStrReturnType() {
		return strReturnType;
	}
	public void setStrReturnType(String strReturnType) {
		this.strReturnType = strReturnType;
	}
	public String getStrApproved() {
		return strApproved;
	}
	public void setStrApproved(String strApproved) {
		this.strApproved = strApproved;
	}
	public String getStrRejected() {
		return strRejected;
	}
	public void setStrRejected(String strRejected) {
		this.strRejected = strRejected;
	}
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	public String getStrInsReqQty() {
		return strInsReqQty;
	}
	public void setStrInsReqQty(String strInsReqQty) {
		this.strInsReqQty = strInsReqQty;
	}
	public String getStrInsReqQtyUnitId() {
		return strInsReqQtyUnitId;
	}
	public void setStrInsReqQtyUnitId(String strInsReqQtyUnitId) {
		this.strInsReqQtyUnitId = strInsReqQtyUnitId;
	}
	
	public String getStrStockDtl() {
		return strStockDtl;
	}
	public void setStrStockDtl(String strStockDtl) {
		this.strStockDtl = strStockDtl;
	}
	public String getStrApprovedBy() {
		return strApprovedBy;
	}
	public void setStrApprovedBy(String strApprovedBy) {
		this.strApprovedBy = strApprovedBy;
	}
	public String getStrHospCode() {
		return strHospCode;
	}
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrChk() {
		return strChk;
	}
	public void setStrChk(String strChk) {
		this.strChk = strChk;
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
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrReqNo() {
		return strReqNo;
	}
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
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
	public String getStrItemCatgNo() {
		return strItemCatgNo;
	}
	public void setStrItemCatgNo(String strItemCatgNo) {
		this.strItemCatgNo = strItemCatgNo;
	}
	public String getStrIsUrgentFlg() {
		return strIsUrgentFlg;
	}
	public void setStrIsUrgentFlg(String strIsUrgentFlg) {
		this.strIsUrgentFlg = strIsUrgentFlg;
	}
	public String getStrIndentPeriod() {
		return strIndentPeriod;
	}
	public void setStrIndentPeriod(String strIndentPeriod) {
		this.strIndentPeriod = strIndentPeriod;
	}
	public String getStrLevelType() {
		return strLevelType;
	}
	public void setStrLevelType(String strLevelType) {
		this.strLevelType = strLevelType;
	}
	public WebRowSet getStrItemDetailsWs() {
		return strItemDetailsWs;
	}
	public void setStrItemDetailsWs(WebRowSet strItemDetailsWs) {
		this.strItemDetailsWs = strItemDetailsWs;
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
	public WebRowSet getStrUnitComboWs() {
		return strUnitComboWs;
	}
	public void setStrUnitComboWs(WebRowSet strUnitComboWs) {
		this.strUnitComboWs = strUnitComboWs;
	}
	public String getStrUnitCombo() {
		return strUnitCombo;
	}
	public void setStrUnitCombo(String strUnitCombo) {
		this.strUnitCombo = strUnitCombo;
	}
	public String getStrToStoreId() {
		return strToStoreId;
	}
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}
	
	public String[] getStrIssueFrmReservStock() {
		return strIssueFrmReservStock;
	}
	public void setStrIssueFrmReservStock(String[] strIssueFrmReservStock) {
		this.strIssueFrmReservStock = strIssueFrmReservStock;
	}
	public String[] getStrInsertHiddenValue() {
		return strInsertHiddenValue;
	}
	public void setStrInsertHiddenValue(String[] strInsertHiddenValue) {
		this.strInsertHiddenValue = strInsertHiddenValue;
	}
	public String[] getStrInsUnitCombo() {
		return strInsUnitCombo;
	}
	public void setStrInsUnitCombo(String[] strInsUnitCombo) {
		this.strInsUnitCombo = strInsUnitCombo;
	}
	public String[] getStrInsSancQty() {
		return strInsSancQty;
	}
	public void setStrInsSancQty(String[] strInsSancQty) {
		this.strInsSancQty = strInsSancQty;
	}
	public String[] getStrHiddenValue() {
		return strHiddenValue;
	}
	public void setStrHiddenValue(String[] strHiddenValue) {
		this.strHiddenValue = strHiddenValue;
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
	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}
	public String getStrIpAddr() {
		return strIpAddr;
	}
	public void setStrIpAddr(String strIpAddr) {
		this.strIpAddr = strIpAddr;
	}
	public String getStrReturnTypeCmb() {
		return strReturnTypeCmb;
	}
	public void setStrReturnTypeCmb(String strReturnTypeCmb) {
		this.strReturnTypeCmb = strReturnTypeCmb;
	}
	public String getStrDeliveryDate() {
		return strDeliveryDate;
	}
	public void setStrDeliveryDate(String strDeliveryDate) {
		this.strDeliveryDate = strDeliveryDate;
	}
		
	public String getStrRasingRecevingFlg() {
		return strRasingRecevingFlg;
	}
	public void setStrRasingRecevingFlg(String strRasingRecevingFlg) {
		this.strRasingRecevingFlg = strRasingRecevingFlg;
	}
	public WebRowSet getStrBlockedItemDetailsWs() {
		return strBlockedItemDetailsWs;
	}
	public void setStrBlockedItemDetailsWs(WebRowSet strBlockedItemDetailsWs) {
		this.strBlockedItemDetailsWs = strBlockedItemDetailsWs;
	}
	public String getStrReservUnReservQty() {
		return strReservUnReservQty;
	}
	public void setStrReservUnReservQty(String strReservUnReservQty) {
		this.strReservUnReservQty = strReservUnReservQty;
	}
	public String getStrApprovalType() {
		return strApprovalType;
	}
	public void setStrApprovalType(String strApprovalType) {
		this.strApprovalType = strApprovalType;
	}
	public String[] getStrBatchNo() {
		return strBatchNo;
	}
	public void setStrBatchNo(String[] strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
	public String[] getStrItemSlNo() {
		return strItemSlNo;
	}
	public void setStrItemSlNo(String[] strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
	}
	public String[] getStrStockStatusCode() {
		return strStockStatusCode;
	}
	public void setStrStockStatusCode(String[] strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}
	public String getStrBatchNoBlocked() {
		return strBatchNoBlocked;
	}
	public void setStrBatchNoBlocked(String strBatchNoBlocked) {
		this.strBatchNoBlocked = strBatchNoBlocked;
	}
	public String getStrItemSlNoBlocked() {
		return strItemSlNoBlocked;
	}
	public void setStrItemSlNoBlocked(String strItemSlNoBlocked) {
		this.strItemSlNoBlocked = strItemSlNoBlocked;
	}
	public String getStrStockStatusCodeBlocked() {
		return strStockStatusCodeBlocked;
	}
	public void setStrStockStatusCodeBlocked(String strStockStatusCodeBlocked) {
		this.strStockStatusCodeBlocked = strStockStatusCodeBlocked;
	}
	public String[] getStrInHandQty() {
		return strInHandQty;
	}
	public void setStrInHandQty(String[] strInHandQty) {
		this.strInHandQty = strInHandQty;
	}
	public String getStrGrpId() {
		return strGrpId;
	}
	public void setStrGrpId(String strGrpId) {
		this.strGrpId = strGrpId;
	}
	public WebRowSet getStrCommitteTypeWS() {
		return strCommitteTypeWS;
	}
	public void setStrCommitteTypeWS(WebRowSet strCommitteTypeWS) {
		this.strCommitteTypeWS = strCommitteTypeWS;
	}
	public String getStrCommitteTypeCode() {
		return strCommitteTypeCode;
	}
	public void setStrCommitteTypeCode(String strCommitteTypeCode) {
		this.strCommitteTypeCode = strCommitteTypeCode;
	}
	public String getStrCommitteRemarks() {
		return strCommitteRemarks;
	}
	public void setStrCommitteRemarks(String strCommitteRemarks) {
		this.strCommitteRemarks = strCommitteRemarks;
	}
	public String getStrCommitteTypeName() {
		return strCommitteTypeName;
	}
	public void setStrCommitteTypeName(String strCommitteTypeName) {
		this.strCommitteTypeName = strCommitteTypeName;
	}
	/**
	 * @return the strItemRemarks
	 */
	public String[] getStrItemRemarks() {
		return strItemRemarks;
	}
	/**
	 * @param strItemRemarks the strItemRemarks to set
	 */
	public void setStrItemRemarks(String[] strItemRemarks) {
		this.strItemRemarks = strItemRemarks;
	}
	/**
	 * @return the strMultiRow
	 */
	public String getStrMultiRow() {
		return strMultiRow;
	}
	/**
	 * @param strMultiRow the strMultiRow to set
	 */
	public void setStrMultiRow(String strMultiRow) {
		this.strMultiRow = strMultiRow;
	}
	public WebRowSet getStrReceivedItemListWs() {
		return strReceivedItemListWs;
	}
	public void setStrReceivedItemListWs(WebRowSet strReceivedItemListWs) {
		this.strReceivedItemListWs = strReceivedItemListWs;
	}
	public String getStrStockDtlTwo() {
		return strStockDtlTwo;
	}
	public void setStrStockDtlTwo(String strStockDtlTwo) {
		this.strStockDtlTwo = strStockDtlTwo;
	}
		

}
