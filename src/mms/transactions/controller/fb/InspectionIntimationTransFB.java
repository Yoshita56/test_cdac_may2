/**
 * 
 */
package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

/**
 * Developer : Anshul Jindal 
 * Version : 1.0 Date : 10/Apr/2009
 * 
 */
public class InspectionIntimationTransFB extends ActionForm {
		
		private static final long serialVersionUID = 02L;

		private String strErrMsg = "";
		private String strNormalMsg = "";
		private String strWarningMsg = "";
		private String strCtDate = "";
		private String strHospitalCode = "";
		private String strIsValid = "";
		private String strSeatId = "";
		
		private String strStoreId="";
		private String strStoreName="";
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
		private String strPath="";  
		private String strCommitteeCmb=""; 
		private String strRemarks="";
		private String strCommittee=""; 
		
		private String[] strItemDetailsChk=null; 
		private String strOrderNoCmb="";  
		private String strComboValue=""; 
		
		
		/**
		 * @return the strErr
		 */
		
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
		 * @return the strOrderNoCmb
		 */
		public String getStrOrderNoCmb() {
			return strOrderNoCmb;
		}
		/**
		 * @param strOrderNoCmb the strOrderNoCmb to set
		 */
		public void setStrOrderNoCmb(String strOrderNoCmb) {
			this.strOrderNoCmb = strOrderNoCmb;
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
		 * @return the strErrMsg
		 */
		public String getStrErrMsg() {
			return strErrMsg;
		}
		/**
		 * @param strErrMsg the strErrMsg to set
		 */
		public void setStrErrMsg(String strErrMsg) {
			this.strErrMsg = strErrMsg;
		}
		/**
		 * @return the strNormalMsg
		 */
		public String getStrNormalMsg() {
			return strNormalMsg;
		}
		/**
		 * @param strNormalMsg the strNormalMsg to set
		 */
		public void setStrNormalMsg(String strNormalMsg) {
			this.strNormalMsg = strNormalMsg;
		}
		/**
		 * @return the strWarningMsg
		 */
		public String getStrWarningMsg() {
			return strWarningMsg;
		}
		/**
		 * @param strWarningMsg the strWarningMsg to set
		 */
		public void setStrWarningMsg(String strWarningMsg) {
			this.strWarningMsg = strWarningMsg;
		}
		/**
		 * @return the strCommitteeCmb
		 */
		public String getStrCommitteeCmb() {
			return strCommitteeCmb;
		}
		/**
		 * @param strCommitteeCmb the strCommitteeCmb to set
		 */
		public void setStrCommitteeCmb(String strCommitteeCmb) {
			this.strCommitteeCmb = strCommitteeCmb;
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
		 * @return the strItemDetailsChk
		 */
		public String[] getStrItemDetailsChk() {
			return strItemDetailsChk;
		}
		/**
		 * @param strItemDetailsChk the strItemDetailsChk to set
		 */
		public void setStrItemDetailsChk(String[] strItemDetailsChk) {
			this.strItemDetailsChk = strItemDetailsChk;
		}
		/**
		 * @return the strComboValue
		 */
		public String getStrComboValue() {
			return strComboValue;
		}
		/**
		 * @param strComboValue the strComboValue to set
		 */
		public void setStrComboValue(String strComboValue) {
			this.strComboValue = strComboValue;
		}
		

}
