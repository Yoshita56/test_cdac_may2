/**
 * 
 */
package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

/**
 * Developer : Anshul Jindal 
 * Version : 1.0 
 * Date : 10/Apr/2009
 * 
 */
public class InspectionIntimationTransVO {

	
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
	private String strOrderDate="";
	private String strOrderNo="";
	private String strTenderNo="";
	private String strQuotationNo="";
	private String strSupplierName="";
	private String strItemCategory="";
	private String strReceiptNo="";
	private String strReceiptDate="";
	private String strItemName="";
	private String strBrandName="";
	private String strBatchNo="";
	private String strExpiryDate="";
	private String strReceivedQty="";
	private String strItemDetails="";
	
	private WebRowSet OrderNoComboWS = null;
	private WebRowSet OrderDetailsWS = null;
	private WebRowSet ReceiptNoWS = null;
	private WebRowSet ItemDetailsWS = null; 
	private WebRowSet CommitteeCmbWS = null;
	
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
	 * @return the strOrderDate
	 */
	public String getStrOrderDate() {
		return strOrderDate;
	}
	/**
	 * @param strOrderDate the strOrderDate to set
	 */
	public void setStrOrderDate(String strOrderDate) {
		this.strOrderDate = strOrderDate;
	}
	/**
	 * @return the strOrderNo
	 */
	public String getStrOrderNo() {
		return strOrderNo;
	}
	/**
	 * @param strOrderNo the strOrderNo to set
	 */
	public void setStrOrderNo(String strOrderNo) {
		this.strOrderNo = strOrderNo;
	}
	/**
	 * @return the strTenderNo
	 */
	public String getStrTenderNo() {
		return strTenderNo;
	}
	/**
	 * @param strTenderNo the strTenderNo to set
	 */
	public void setStrTenderNo(String strTenderNo) {
		this.strTenderNo = strTenderNo;
	}
	/**
	 * @return the strQuotationNo
	 */
	public String getStrQuotationNo() {
		return strQuotationNo;
	}
	/**
	 * @param strQuotationNo the strQuotationNo to set
	 */
	public void setStrQuotationNo(String strQuotationNo) {
		this.strQuotationNo = strQuotationNo;
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
	 * @return the strReceiptNo
	 */
	public String getStrReceiptNo() {
		return strReceiptNo;
	}
	/**
	 * @param strReceiptNo the strReceiptNo to set
	 */
	public void setStrReceiptNo(String strReceiptNo) {
		this.strReceiptNo = strReceiptNo;
	}
	/**
	 * @return the strReceiptDate
	 */
	public String getStrReceiptDate() {
		return strReceiptDate;
	}
	/**
	 * @param strReceiptDate the strReceiptDate to set
	 */
	public void setStrReceiptDate(String strReceiptDate) {
		this.strReceiptDate = strReceiptDate;
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
	 * @return the strBatchNo
	 */
	public String getStrBatchNo() {
		return strBatchNo;
	}
	/**
	 * @param strBatchNo the strBatchNo to set
	 */
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
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
	 * @return the orderNoComboWS
	 */
	public WebRowSet getOrderNoComboWS() {
		return OrderNoComboWS;
	}
	/**
	 * @param orderNoComboWS the orderNoComboWS to set
	 */
	public void setOrderNoComboWS(WebRowSet orderNoComboWS) {
		OrderNoComboWS = orderNoComboWS;
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
	 * @return the receiptNoWS
	 */
	public WebRowSet getReceiptNoWS() {
		return ReceiptNoWS;
	}
	/**
	 * @param receiptNoWS the receiptNoWS to set
	 */
	public void setReceiptNoWS(WebRowSet receiptNoWS) {
		ReceiptNoWS = receiptNoWS;
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
	 * @return the committeeCmbWS
	 */
	public WebRowSet getCommitteeCmbWS() {
		return CommitteeCmbWS;
	}
	/**
	 * @param committeeCmbWS the committeeCmbWS to set
	 */
	public void setCommitteeCmbWS(WebRowSet committeeCmbWS) {
		CommitteeCmbWS = committeeCmbWS;
	} 
}
