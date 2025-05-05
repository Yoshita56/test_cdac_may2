package mms.transactions.controller.fb;

import hisglobal.transactionutil.GenericFormBean;

public class IndentSuperApprovalTransFB extends GenericFormBean 
{
	private static final long serialVersionUID = 02L;
    private String strHospCode ="";
    private String strSeatId ="";
    private String strChk ="";
    private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "0";
	private String strErrMsg = "";
	private String strMultiRow="";
	//Primary Key
	private String strNonDiscrepancyRpt = "";
	private String strDiscripancyRpt = "";
	private String[] strBatchNo        = null;
	private String[] strItemSlNo       = null;
	private String[] strStockStatusCode = null;
	private String[] strAvlQty          = null;
	private String[] strInHandQty          = null;	
	private String strReturnTypeCmb ="";
	private String strDeliveryDate="";
	private String strRemarks ="";
	private String strLevelType = "";
	private String []strItemRemarks= null;
	private String strPath="";
	private String strHospitalCode ="";
	private String strReqNo = "";
	private String strStoreId = "";
	private String strReqTypeId =""; 
	private String strItemCatgNo = "";
	private String strIsUrgentFlg ="";
	private String strIndentPeriod="";	
	private String strSetItemDetails="";
	private String strIndentDetails="";
	private String strSpecialAppDtls="";
	
	private String strRequestName="";
	private String strSetApprovedDetails ="";
	private String strJustification ="";
	private String strApproved="";
	private String strRejected ="";
	private String strUnitCombo ="";
	private String strLstApprovalDetails ="";
	private String strIpAddr ="";
	private String strItemLength="";
	private String strCommitteTypeCmb ="";
	private String strCommitteTypeCode = "";
	private String[] strBlockedQtyAdd = null;
	private String[] strIssueFrmReservStock={"0"};
	private String[] strInsertHiddenValue =null;
	private String[] strInsUnitCombo=null;
	private String[] strInsSancQty=null;
	private String[] strHiddenValue=null;
	private String strReturnType   = "";
	
	private String strSetPreTechApprovedDetails="";
	private String strSpecialAppFlg="";
    
	
	
	public String getStrSpecialAppFlg() {
		return strSpecialAppFlg;
	}
	public void setStrSpecialAppFlg(String strSpecialAppFlg) {
		this.strSpecialAppFlg = strSpecialAppFlg;
	}
	public String getStrSpecialAppDtls() {
		return strSpecialAppDtls;
	}
	public void setStrSpecialAppDtls(String strSpecialAppDtls) {
		this.strSpecialAppDtls = strSpecialAppDtls;
	}
	/**
	 * @return the strSetPreTechApprovedDetails
	 */
	public String getStrSetPreTechApprovedDetails() {
		return strSetPreTechApprovedDetails;
	}
	/**
	 * @param strSetPreTechApprovedDetails the strSetPreTechApprovedDetails to set
	 */
	public void setStrSetPreTechApprovedDetails(String strSetPreTechApprovedDetails) {
		this.strSetPreTechApprovedDetails = strSetPreTechApprovedDetails;
	}
	
	public String[] getStrHiddenValue() {
		return strHiddenValue;
	}
	public void setStrHiddenValue(String[] strHiddenValue) {
		this.strHiddenValue = strHiddenValue;
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
	public String getStrLstApprovalDetails() {
		return strLstApprovalDetails;
	}
	public void setStrLstApprovalDetails(String strLstApprovalDetails) {
		this.strLstApprovalDetails = strLstApprovalDetails;
	}
	public String getStrUnitCombo() {
		return strUnitCombo;
	}
	public void setStrUnitCombo(String strUnitCombo) {
		this.strUnitCombo = strUnitCombo;
	}
	public String getStrSetApprovedDetails() {
		return strSetApprovedDetails;
	}
	public void setStrSetApprovedDetails(String strSetApprovedDetails) {
		this.strSetApprovedDetails = strSetApprovedDetails;
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
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrLevelType() {
		return strLevelType;
	}
	public void setStrLevelType(String strLevelType) {
		this.strLevelType = strLevelType;
	}
	public String getStrSetItemDetails() {
		return strSetItemDetails;
	}
	public void setStrSetItemDetails(String strSetItemDetails) {
		this.strSetItemDetails = strSetItemDetails;
	}
	public String getStrIndentDetails() {
		return strIndentDetails;
	}
	public void setStrIndentDetails(String strIndentDetails) {
		this.strIndentDetails = strIndentDetails;
	}
	public String getStrRequestName() {
		return strRequestName;
	}
	public void setStrRequestName(String strRequestName) {
		this.strRequestName = strRequestName;
	}
	public String getStrJustification() {
		return strJustification;
	}
	public void setStrJustification(String strJustification) {
		this.strJustification = strJustification;
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
	public String getStrPath() {
		return strPath;
	}
	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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
	public String[] getStrBlockedQtyAdd() {
		return strBlockedQtyAdd;
	}
	public void setStrBlockedQtyAdd(String[] strBlockedQtyAdd) {
		this.strBlockedQtyAdd = strBlockedQtyAdd;
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
	public String[] getStrAvlQty() {
		return strAvlQty;
	}
	public void setStrAvlQty(String[] strAvlQty) {
		this.strAvlQty = strAvlQty;
	}
	public String[] getStrInHandQty() {
		return strInHandQty;
	}
	public void setStrInHandQty(String[] strInHandQty) {
		this.strInHandQty = strInHandQty;
	}
	public String getStrNonDiscrepancyRpt() {
		return strNonDiscrepancyRpt;
	}
	public void setStrNonDiscrepancyRpt(String strNonDiscrepancyRpt) {
		this.strNonDiscrepancyRpt = strNonDiscrepancyRpt;
	}
	public String getStrDiscripancyRpt() {
		return strDiscripancyRpt;
	}
	public void setStrDiscripancyRpt(String strDiscripancyRpt) {
		this.strDiscripancyRpt = strDiscripancyRpt;
	}
	public String getStrCommitteTypeCmb() {
		return strCommitteTypeCmb;
	}
	public void setStrCommitteTypeCmb(String strCommitteTypeCmb) {
		this.strCommitteTypeCmb = strCommitteTypeCmb;
	}
	public String getStrCommitteTypeCode() {
		return strCommitteTypeCode;
	}
	public void setStrCommitteTypeCode(String strCommitteTypeCode) {
		this.strCommitteTypeCode = strCommitteTypeCode;
	}
	public String getStrReturnType() {
		return strReturnType;
	}
	public void setStrReturnType(String strReturnType) {
		this.strReturnType = strReturnType;
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

	
	
	
}
