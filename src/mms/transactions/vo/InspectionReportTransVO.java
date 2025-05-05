/**
 * 
 */
package mms.transactions.vo;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;

/**
 * Developer : Anshul Jindal 
 * Version : 1.0 
 * Date : 15/Apr/2009
 * 
 */
public class InspectionReportTransVO implements TransferObject{
	

	private static final long serialVersionUID = 02L;
	private String strMsgType="";
	private String strMsgString="";
	
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
	private String strCtDate = "";
	private String strHospitalCode = "";
	private String strIsValid = "";
	private String strSeatId = "";
	
	private String strStoreId="";
	private String strReqDate="";
	private String strReqNo="";
	private String strPODate="";
	private String strPONo="";
	private String strSupplierName="";
	private String strItemCategory="";
	private String strCommittee=""; 
	private String strItemName="";
	private String strBrandName=""; 
	private String strExpiryDate="";
	private String strReceivedQty="";
	private String strIssueQty="";
	private String strItemStatus="";
	private String strItemDetails=""; 
	private String strPath="";  
	private String strUnitId="";
	
	
	private String[] strItemId = null;
	private String[] strItemBrandId = null;
	private String[] strBatchSLNo = null;
	private String[] strReport = null;
	private String[] strStatus = null;
	private String[] strReturnQtyUnitId = null;
	private String[] strReturnQty = null;
	
	private WebRowSet StoreComboWS = null;
	private WebRowSet ReqNoComboWS = null;
	private WebRowSet OrderDetailsWS = null;
	//private WebRowSet ReceiptNoWS = null;
	private WebRowSet ItemDetailsWS = null; 
	private WebRowSet ReturnQtyUnitCmbWS = null;
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
	 * @return the strIsValid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}
	/**
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
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
	 * @return the strReqDate
	 */
	public String getStrReqDate() {
		return strReqDate;
	}
	/**
	 * @param strReqDate the strReqDate to set
	 */
	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
	}
	/**
	 * @return the strReqNo
	 */
	public String getStrReqNo() {
		return strReqNo;
	}
	/**
	 * @param strReqNo the strReqNo to set
	 */
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}
	/**
	 * @return the strPODate
	 */
	public String getStrPODate() {
		return strPODate;
	}
	/**
	 * @param strPODate the strPODate to set
	 */
	public void setStrPODate(String strPODate) {
		this.strPODate = strPODate;
	}
	/**
	 * @return the strPONo
	 */
	public String getStrPONo() {
		return strPONo;
	}
	/**
	 * @param strPONo the strPONo to set
	 */
	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
	}
	/**
	 * @return the strSupplierName
	 */
	public String getStrSupplierName() {
		return strSupplierName;
	}
	/**
	 * @param strSupplierName the strSupplierName to set
	 */
	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}
	/**
	 * @return the strItemCategory
	 */
	public String getStrItemCategory() {
		return strItemCategory;
	}
	/**
	 * @param strItemCategory the strItemCategory to set
	 */
	public void setStrItemCategory(String strItemCategory) {
		this.strItemCategory = strItemCategory;
	}
	/**
	 * @return the strCommittee
	 */
	public String getStrCommittee() {
		return strCommittee;
	}
	/**
	 * @param strCommittee the strCommittee to set
	 */
	public void setStrCommittee(String strCommittee) {
		this.strCommittee = strCommittee;
	}
	
	
	/**
	 * @return the strItemName
	 */
	public String getStrItemName() {
		return strItemName;
	}
	/**
	 * @param strItemName the strItemName to set
	 */
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	/**
	 * @return the strBrandName
	 */
	public String getStrBrandName() {
		return strBrandName;
	}
	/**
	 * @param strBrandName the strBrandName to set
	 */
	public void setStrBrandName(String strBrandName) {
		this.strBrandName = strBrandName;
	}
	
	/**
	 * @return the strExpiryDate
	 */
	public String getStrExpiryDate() {
		return strExpiryDate;
	}
	/**
	 * @param strExpiryDate the strExpiryDate to set
	 */
	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}
	/**
	 * @return the strReceivedQty
	 */
	public String getStrReceivedQty() {
		return strReceivedQty;
	}
	/**
	 * @param strReceivedQty the strReceivedQty to set
	 */
	public void setStrReceivedQty(String strReceivedQty) {
		this.strReceivedQty = strReceivedQty;
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
	 * @return the strItemStatus
	 */
	public String getStrItemStatus() {
		return strItemStatus;
	}
	/**
	 * @param strItemStatus the strItemStatus to set
	 */
	public void setStrItemStatus(String strItemStatus) {
		this.strItemStatus = strItemStatus;
	}
	/**
	 * @return the strItemDetails
	 */
	public String getStrItemDetails() {
		return strItemDetails;
	}
	/**
	 * @param strItemDetails the strItemDetails to set
	 */
	public void setStrItemDetails(String strItemDetails) {
		this.strItemDetails = strItemDetails;
	}
	/**
	 * @return the strPath
	 */
	public String getStrPath() {
		return strPath;
	}
	/**
	 * @param strPath the strPath to set
	 */
	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}
	
	
	/**
	 * @return the strItemId
	 */
	public String[] getStrItemId() {
		return strItemId;
	}
	/**
	 * @param strItemId the strItemId to set
	 */
	public void setStrItemId(String[] strItemId) {
		this.strItemId = strItemId;
	}
	/**
	 * @return the strItemBrandId
	 */
	public String[] getStrItemBrandId() {
		return strItemBrandId;
	}
	/**
	 * @param strItemBrandId the strItemBrandId to set
	 */
	public void setStrItemBrandId(String[] strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	/**
	 * @return the strBatchSLNo
	 */
	public String[] getStrBatchSLNo() {
		return strBatchSLNo;
	}
	/**
	 * @param strBatchSLNo the strBatchSLNo to set
	 */
	public void setStrBatchSLNo(String[] strBatchSLNo) {
		this.strBatchSLNo = strBatchSLNo;
	}
	/**
	 * @return the strReport
	 */
	public String[] getStrReport() {
		return strReport;
	}
	/**
	 * @param strReport the strReport to set
	 */
	public void setStrReport(String[] strReport) {
		this.strReport = strReport;
	}
	/**
	 * @return the strStatus
	 */
	public String[] getStrStatus() {
		return strStatus;
	}
	/**
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String[] strStatus) {
		this.strStatus = strStatus;
	}
	/**
	 * @return the strReturnQtyUnitId
	 */
	public String[] getStrReturnQtyUnitId() {
		return strReturnQtyUnitId;
	}
	/**
	 * @param strReturnQtyUnitId the strReturnQtyUnitId to set
	 */
	public void setStrReturnQtyUnitId(String[] strReturnQtyUnitId) {
		this.strReturnQtyUnitId = strReturnQtyUnitId;
	}
	/**
	 * @return the strReturnQty
	 */
	public String[] getStrReturnQty() {
		return strReturnQty;
	}
	/**
	 * @param strReturnQty the strReturnQty to set
	 */
	public void setStrReturnQty(String[] strReturnQty) {
		this.strReturnQty = strReturnQty;
	}
	/**
	 * @return the reqNoComboWS
	 */
	public WebRowSet getReqNoComboWS() {
		return ReqNoComboWS;
	}
	/**
	 * @param reqNoComboWS the reqNoComboWS to set
	 */
	public void setReqNoComboWS(WebRowSet reqNoComboWS) {
		ReqNoComboWS = reqNoComboWS;
	}
	/**
	 * @return the orderDetailsWS
	 */
	public WebRowSet getOrderDetailsWS() {
		return OrderDetailsWS;
	}
	/**
	 * @param orderDetailsWS the orderDetailsWS to set
	 */
	public void setOrderDetailsWS(WebRowSet orderDetailsWS) {
		OrderDetailsWS = orderDetailsWS;
	}
	/**
	 * @return the itemDetailsWS
	 */
	public WebRowSet getItemDetailsWS() {
		return ItemDetailsWS;
	}
	/**
	 * @param itemDetailsWS the itemDetailsWS to set
	 */
	public void setItemDetailsWS(WebRowSet itemDetailsWS) {
		ItemDetailsWS = itemDetailsWS;
	}
	/**
	 * @return the returnQtyUnitCmbWS
	 */
	public WebRowSet getReturnQtyUnitCmbWS() {
		return ReturnQtyUnitCmbWS;
	}
	/**
	 * @param returnQtyUnitCmbWS the returnQtyUnitCmbWS to set
	 */
	public void setReturnQtyUnitCmbWS(WebRowSet returnQtyUnitCmbWS) {
		ReturnQtyUnitCmbWS = returnQtyUnitCmbWS;
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
	 * @return the strUnitId
	 */
	public String getStrUnitId() {
		return strUnitId;
	}
	/**
	 * @param strUnitId the strUnitId to set
	 */
	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
	}
	/**
	 * @return the storeComboWS
	 */
	public WebRowSet getStoreComboWS() {
		return StoreComboWS;
	}
	/**
	 * @param storeComboWS the storeComboWS to set
	 */
	public void setStoreComboWS(WebRowSet storeComboWS) {
		StoreComboWS = storeComboWS;
	}

}
