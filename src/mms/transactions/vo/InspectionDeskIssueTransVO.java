/**
 * 
 */
package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 Date : 09/April/2009
 * 
 */
public class InspectionDeskIssueTransVO implements TransferObject{
	
	private static final long serialVersionUID = 02L;
	
	private Boolean BExistStatus = false;
	private String strMsgString = "";
	private String strMsgType = "";
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strStoreId = "";
	private String strStoreName = "";
	private String strStatus = "";
	
	private String strRequestNo = "";
	private String strRequestDate = "";
	private String strPONo = "";
	private String strPODate = "";
	private String strSupplierName = "";
	private String strItemCategory = "";
	private String strCommitteeName = "";
	private String strPath = "";
	
	private String strItemId = "";
	private String strItemName = "";
	private String strItemBrandId = "";
	private String strItemBrandName = "";
	private String strBatchSlNo = "";
	private String strExpiryDate = "";
	private String strReceiptQty = "";
	private String[] strIssueQty = null;
    private String strReceivedUnitId = "";
    private String[] strIssuedUnitId = null;
    private String strIsValid = "";
	
	private WebRowSet issueUnitPkgWS = null;
	private String strIssueUnitPkgCombo = "";
	
	private String strRemarks = "";
	
	private String strRequestDetails = "";
	private WebRowSet requestDetailsWS = null;
	private String strItemDetails = "";
	private WebRowSet itemDetailsWS = null;
	
	private String strFinStartDate = "";
	private String strFinEndDate = "";
	
	
	/**
	 * @return the strFinStartDate
	 */
	public String getStrFinStartDate() {
		return strFinStartDate;
	}
	/**
	 * @param strFinStartDate the strFinStartDate to set
	 */
	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
	}
	/**
	 * @return the strFinEndDate
	 */
	public String getStrFinEndDate() {
		return strFinEndDate;
	}
	/**
	 * @param strFinEndDate the strFinEndDate to set
	 */
	public void setStrFinEndDate(String strFinEndDate) {
		this.strFinEndDate = strFinEndDate;
	}
	/**
	 * @return the strRequestNo
	 */
	public String getStrRequestNo() {
		return strRequestNo;
	}
	/**
	 * @param strRequestNo the strRequestNo to set
	 */
	public void setStrRequestNo(String strRequestNo) {
		this.strRequestNo = strRequestNo;
	}
	/**
	 * @return the strRequestDate
	 */
	public String getStrRequestDate() {
		return strRequestDate;
	}
	/**
	 * @param strRequestDate the strRequestDate to set
	 */
	public void setStrRequestDate(String strRequestDate) {
		this.strRequestDate = strRequestDate;
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
	 * @return the strCommitteeName
	 */
	public String getStrCommitteeName() {
		return strCommitteeName;
	}
	/**
	 * @param strCommitteeName the strCommitteeName to set
	 */
	public void setStrCommitteeName(String strCommitteeName) {
		this.strCommitteeName = strCommitteeName;
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
	public String getStrItemBrandName() {
		return strItemBrandName;
	}
	/**
	 * @param strBrandName the strBrandName to set
	 */
	public void setStrItemBrandName(String strItemBrandName) {
		this.strItemBrandName = strItemBrandName;
	}
	/**
	 * @return the strBatchSlNo
	 */
	public String getStrBatchSlNo() {
		return strBatchSlNo;
	}
	/**
	 * @param strBatchSlNo the strBatchSlNo to set
	 */
	public void setStrBatchSlNo(String strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
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
	 * @return the strReceiptQty
	 */
	public String getStrReceiptQty() {
		return strReceiptQty;
	}
	/**
	 * @param strReceiptQty the strReceiptQty to set
	 */
	public void setStrReceiptQty(String strReceiptQty) {
		this.strReceiptQty = strReceiptQty;
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
	 * @return the strRequestDetails
	 */
	public String getStrRequestDetails() {
		return strRequestDetails;
	}
	/**
	 * @param strRequestDetails the strRequestDetails to set
	 */
	public void setStrRequestDetails(String strRequestDetails) {
		this.strRequestDetails = strRequestDetails;
	}
	/**
	 * @return the requestDetailsWS
	 */
	public WebRowSet getRequestDetailsWS() {
		return requestDetailsWS;
	}
	/**
	 * @param requestDetailsWS the requestDetailsWS to set
	 */
	public void setRequestDetailsWS(WebRowSet requestDetailsWS) {
		this.requestDetailsWS = requestDetailsWS;
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
	 * @return the itemDetailsWS
	 */
	public WebRowSet getItemDetailsWS() {
		return itemDetailsWS;
	}
	/**
	 * @param itemDetailsWS the itemDetailsWS to set
	 */
	public void setItemDetailsWS(WebRowSet itemDetailsWS) {
		this.itemDetailsWS = itemDetailsWS;
	}
	/**
	 * @return the bExistStatus
	 */
	public Boolean getBExistStatus() {
		return BExistStatus;
	}
	/**
	 * @param existStatus the bExistStatus to set
	 */
	public void setBExistStatus(Boolean existStatus) {
		BExistStatus = existStatus;
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
	 * @return the strStatus
	 */
	public String getStrStatus() {
		return strStatus;
	}
	/**
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
	/**
	 * @return the strReceivedUnitId
	 */
	public String getStrReceivedUnitId() {
		return strReceivedUnitId;
	}
	/**
	 * @param strReceivedUnitId the strReceivedUnitId to set
	 */
	public void setStrReceivedUnitId(String strReceivedUnitId) {
		this.strReceivedUnitId = strReceivedUnitId;
	}
	/**
	 * @return the issueUnitPkgWS
	 */
	public WebRowSet getIssueUnitPkgWS() {
		return issueUnitPkgWS;
	}
	/**
	 * @param issueUnitPkgWS the issueUnitPkgWS to set
	 */
	public void setIssueUnitPkgWS(WebRowSet issueUnitPkgWS) {
		this.issueUnitPkgWS = issueUnitPkgWS;
	}
	/**
	 * @return the strIssueUnitPkgCombo
	 */
	public String getStrIssueUnitPkgCombo() {
		return strIssueUnitPkgCombo;
	}
	/**
	 * @param strIssueUnitPkgCombo the strIssueUnitPkgCombo to set
	 */
	public void setStrIssueUnitPkgCombo(String strIssueUnitPkgCombo) {
		this.strIssueUnitPkgCombo = strIssueUnitPkgCombo;
	}
	/**
	 * @return the strItemId
	 */
	public String getStrItemId() {
		return strItemId;
	}
	/**
	 * @param strItemId the strItemId to set
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	/**
	 * @return the strItemBrandId
	 */
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	/**
	 * @param strItemBrandId the strItemBrandId to set
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
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
	 * @return the strIssuedUnitId
	 */
	public String[] getStrIssuedUnitId() {
		return strIssuedUnitId;
	}
	/**
	 * @param strIssuedUnitId the strIssuedUnitId to set
	 */
	public void setStrIssuedUnitId(String[] strIssuedUnitId) {
		this.strIssuedUnitId = strIssuedUnitId;
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
	

}
