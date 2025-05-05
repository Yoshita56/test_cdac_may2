/**
 * 
 */
package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

/**
 * Developer : Anshul Jindal 
 * Version : 1.0 
 * Date : 15/Apr/2009
 * 
 */
public class InspectionReportTransFB  extends ActionForm {
	
	private static final long serialVersionUID = 02L;

	private String strErrMsg = "";
	private String strNormalMsg = "";
	private String strWarningMsg = "";
	private String strCtDate = "";
	private String strHospitalCode = "";
	private String strIsValid = "";
	private String strSeatId = "";
	
	
	
	private String strStoreId="";
	//private String strStoreName="";
	private String strReqDate="";
	private String strReqNo="";
	private String strPODate="";
	private String strPONo="";
	//private String strTenderNo="";
	//private String strQuotationNo="";
	private String strSupplierName="";
	private String strItemCategory="";
	private String strCommittee=""; 
	
	
	//private String strReceiptNo="";
	private String strReceiptDate="";
	private String strItemName="";
	private String strBrandName=""; 
	private String strBatchSlNo="";
	private String strExpiryDate="";
	private String strReceivedQty="";
	private String strIssueQty="";
	private String strItemStatus="";
	
	private String strItemDetails=""; 
	private String strPath="";  
	
	private String strInspectionReport="";
	private String strInspectionStatus="";
	private String strReturnQty="";
	private String strReturnUnitId="";
	
	private String strStoreCmb=""; 
	private String strReturnUnitCmb=""; 
	private String StrComboValue=""; 
	
	private String strReportStatus=""; 
	private String[] strReportDtl=null; 
	private String[] strItemDetailsChk=null;
	private String strSelectedChkIndex=""; 


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
	 * @return the strInspectionReport
	 */
	public String getStrInspectionReport() {
		return strInspectionReport;
	}


	/**
	 * @param strInspectionReport the strInspectionReport to set
	 */
	public void setStrInspectionReport(String strInspectionReport) {
		this.strInspectionReport = strInspectionReport;
	}


	/**
	 * @return the strInspectionStatus
	 */
	public String getStrInspectionStatus() {
		return strInspectionStatus;
	}


	/**
	 * @param strInspectionStatus the strInspectionStatus to set
	 */
	public void setStrInspectionStatus(String strInspectionStatus) {
		this.strInspectionStatus = strInspectionStatus;
	}


	/**
	 * @return the strReturnQty
	 */
	public String getStrReturnQty() {
		return strReturnQty;
	}


	/**
	 * @param strReturnQty the strReturnQty to set
	 */
	public void setStrReturnQty(String strReturnQty) {
		this.strReturnQty = strReturnQty;
	}


	/**
	 * @return the strReturnUnitId
	 */
	public String getStrReturnUnitId() {
		return strReturnUnitId;
	}


	/**
	 * @param strReturnUnitId the strReturnUnitId to set
	 */
	public void setStrReturnUnitId(String strReturnUnitId) {
		this.strReturnUnitId = strReturnUnitId;
	}




	/**
	 * @return the strStoreCmb
	 */
	public String getStrStoreCmb() {
		return strStoreCmb;
	}


	/**
	 * @param strStoreCmb the strStoreCmb to set
	 */
	public void setStrStoreCmb(String strStoreCmb) {
		this.strStoreCmb = strStoreCmb;
	}


	/**
	 * @return the strReturnUnitCmb
	 */
	public String getStrReturnUnitCmb() {
		return strReturnUnitCmb;
	}


	/**
	 * @param strReturnUnitCmb the strReturnUnitCmb to set
	 */
	public void setStrReturnUnitCmb(String strReturnUnitCmb) {
		this.strReturnUnitCmb = strReturnUnitCmb;
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
		return StrComboValue;
	}


	/**
	 * @param strComboValue the strComboValue to set
	 */
	public void setStrComboValue(String strComboValue) {
		StrComboValue = strComboValue;
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
	 * @return the strReportStatus
	 */
	public String getStrReportStatus() {
		return strReportStatus;
	}


	/**
	 * @param strReportStatus the strReportStatus to set
	 */
	public void setStrReportStatus(String strReportStatus) {
		this.strReportStatus = strReportStatus;
	}


	/**
	 * @return the strReportDtl
	 */
	public String[] getStrReportDtl() {
		return strReportDtl;
	}


	/**
	 * @param strReportDtl the strReportDtl to set
	 */
	public void setStrReportDtl(String[] strReportDtl) {
		this.strReportDtl = strReportDtl;
	}


	/**
	 * @return the strSelectedChkIndex
	 */
	public String getStrSelectedChkIndex() {
		return strSelectedChkIndex;
	}


	/**
	 * @param strSelectedChkIndex the strSelectedChkIndex to set
	 */
	public void setStrSelectedChkIndex(String strSelectedChkIndex) {
		this.strSelectedChkIndex = strSelectedChkIndex;
	}


	
	

}
