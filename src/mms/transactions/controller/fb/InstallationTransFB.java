package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

public class InstallationTransFB extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strErrorMsg  = "";
	private String strWarningMsg  = "";
	private String strNormalMsg  = "";
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strCtDate = "";
	
	private String strStoreId = "";
	private String strStoreValues = "";
	private String strItemCatNo = "";
	private String strGroupId = "";
	private String strSubGroupId = "";
	private String strGenericItemId = "";
	private String strItemBrandId = "";
	private String strBatchNo = "";
	private String strItemSlNo = "";
	private String strInstallationStartDate = "";
	private String strInstallationEndDate = "";
	private String strInstallationBy = "";
	private String strInstallatorContactNo = "";
	private String strInstallationStatus = "";
	private String strReportBy = "";
	private String strRemarks = "";
	private String strIsConsumable = "";
	private String strStockStatusCode = "";
	private String strIsValid = "";
	private String strPONo = "";
	private String strPODate = "";
	private String strSupplierId = "";
	private String strInhandQty = "";
	private String strInhandQtyUnitId = "";
	private String strFinStartDate = "";
	private String strFinEndDate = "";
	private String strInstallationViewDetails = "";
	
	private String strView = "";
	private String displayFlag = "0";
	
	private String strHidStoreName = "";
	private String strItemCategoryName = "";
	private String strCategoryValues = "";
	private String strGroupNameValues ="";
	
	/**
	 * @return the strGroupNameValues
	 */
	public String getStrGroupNameValues() {
		return strGroupNameValues;
	}
	/**
	 * @param strGroupNameValues the strGroupNameValues to set
	 */
	public void setStrGroupNameValues(String strGroupNameValues) {
		this.strGroupNameValues = strGroupNameValues;
	}
	/**
	 * @return the strItemCategoryName
	 */
	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}
	/**
	 * @param strItemCategoryName the strItemCategoryName to set
	 */
	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}
	/**
	 * @return the strHidStoreName
	 */
	public String getStrHidStoreName() {
		return strHidStoreName;
	}
	/**
	 * @param strHidStoreName the strHidStoreName to set
	 */
	public void setStrHidStoreName(String strHidStoreName) {
		this.strHidStoreName = strHidStoreName;
	}
	/**
	 * @return the displayFlag
	 */
	public String getDisplayFlag() {
		return displayFlag;
	}
	/**
	 * @param displayFlag the displayFlag to set
	 */
	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}
	/**
	 * @return the strView
	 */
	public String getStrView() {
		return strView;
	}
	/**
	 * @param strView the strView to set
	 */
	public void setStrView(String strView) {
		this.strView = strView;
	}
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
	 * @return the strInhandQty
	 */
	public String getStrInhandQty() {
		return strInhandQty;
	}
	/**
	 * @param strInhandQty the strInhandQty to set
	 */
	public void setStrInhandQty(String strInhandQty) {
		this.strInhandQty = strInhandQty;
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
	 * @return the strSupplierId
	 */
	public String getStrSupplierId() {
		return strSupplierId;
	}
	/**
	 * @param strSupplierId the strSupplierId to set
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
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
	 * @return the strStoreValues
	 */
	public String getStrStoreValues() {
		return strStoreValues;
	}
	/**
	 * @param strStoreValues the strStoreValues to set
	 */
	public void setStrStoreValues(String strStoreValues) {
		this.strStoreValues = strStoreValues;
	}
	/**
	 * @return the strItemCatNo
	 */
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	/**
	 * @param strItemCatNo the strItemCatNo to set
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	/**
	 * @return the strGroupId
	 */
	public String getStrGroupId() {
		return strGroupId;
	}
	/**
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	/**
	 * @return the strSubGroupId
	 */
	public String getStrSubGroupId() {
		return strSubGroupId;
	}
	/**
	 * @param strSubGroupId the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}
	/**
	 * @return the strGenericItemId
	 */
	public String getStrGenericItemId() {
		return strGenericItemId;
	}
	/**
	 * @param strGenericItemId the strGenericItemId to set
	 */
	public void setStrGenericItemId(String strGenericItemId) {
		this.strGenericItemId = strGenericItemId;
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
	 * @return the strItemSlNo
	 */
	public String getStrItemSlNo() {
		return strItemSlNo;
	}
	/**
	 * @param strItemSlNo the strItemSlNo to set
	 */
	public void setStrItemSlNo(String strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
	}
	/**
	 * @return the strInstallationStartDate
	 */
	public String getStrInstallationStartDate() {
		return strInstallationStartDate;
	}
	/**
	 * @param strInstallationStartDate the strInstallationStartDate to set
	 */
	public void setStrInstallationStartDate(String strInstallationStartDate) {
		this.strInstallationStartDate = strInstallationStartDate;
	}
	/**
	 * @return the strInstallationEndDate
	 */
	public String getStrInstallationEndDate() {
		return strInstallationEndDate;
	}
	/**
	 * @param strInstallationEndDate the strInstallationEndDate to set
	 */
	public void setStrInstallationEndDate(String strInstallationEndDate) {
		this.strInstallationEndDate = strInstallationEndDate;
	}
	/**
	 * @return the strInstallationBy
	 */
	public String getStrInstallationBy() {
		return strInstallationBy;
	}
	/**
	 * @param strInstallationBy the strInstallationBy to set
	 */
	public void setStrInstallationBy(String strInstallationBy) {
		this.strInstallationBy = strInstallationBy;
	}
	/**
	 * @return the strInstallatorContactNo
	 */
	public String getStrInstallatorContactNo() {
		return strInstallatorContactNo;
	}
	/**
	 * @param strInstallatorContactNo the strInstallatorContactNo to set
	 */
	public void setStrInstallatorContactNo(String strInstallatorContactNo) {
		this.strInstallatorContactNo = strInstallatorContactNo;
	}
	/**
	 * @return the strInstallationStatus
	 */
	public String getStrInstallationStatus() {
		return strInstallationStatus;
	}
	/**
	 * @param strInstallationStatus the strInstallationStatus to set
	 */
	public void setStrInstallationStatus(String strInstallationStatus) {
		this.strInstallationStatus = strInstallationStatus;
	}
	/**
	 * @return the strReportBy
	 */
	public String getStrReportBy() {
		return strReportBy;
	}
	/**
	 * @param strReportBy the strReportBy to set
	 */
	public void setStrReportBy(String strReportBy) {
		this.strReportBy = strReportBy;
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
	 * @return the strErrorMsg
	 */
	public String getStrErrorMsg() {
		return strErrorMsg;
	}
	/**
	 * @param strErrorMsg the strErrorMsg to set
	 */
	public void setStrErrorMsg(String strErrorMsg) {
		this.strErrorMsg = strErrorMsg;
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
	 * @return the strIsConsumable
	 */
	public String getStrIsConsumable() {
		return strIsConsumable;
	}
	/**
	 * @param strIsConsumable the strIsConsumable to set
	 */
	public void setStrIsConsumable(String strIsConsumable) {
		this.strIsConsumable = strIsConsumable;
	}
	/**
	 * @return the strStockStatusCode
	 */
	public String getStrStockStatusCode() {
		return strStockStatusCode;
	}
	/**
	 * @param strStockStatusCode the strStockStatusCode to set
	 */
	public void setStrStockStatusCode(String strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}
	/**
	 * @return the strInhandQtyUnitId
	 */
	public String getStrInhandQtyUnitId() {
		return strInhandQtyUnitId;
	}
	/**
	 * @param strInhandQtyUnitId the strInhandQtyUnitId to set
	 */
	public void setStrInhandQtyUnitId(String strInhandQtyUnitId) {
		this.strInhandQtyUnitId = strInhandQtyUnitId;
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
	 * @return the strInstallationViewDetails
	 */
	public String getStrInstallationViewDetails() {
		return strInstallationViewDetails;
	}
	/**
	 * @param strInstallationViewDetails the strInstallationViewDetails to set
	 */
	public void setStrInstallationViewDetails(String strInstallationViewDetails) {
		this.strInstallationViewDetails = strInstallationViewDetails;
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
	 * @return the strCategoryValues
	 */
	public String getStrCategoryValues() {
		return strCategoryValues;
	}
	/**
	 * @param strCategoryValues the strCategoryValues to set
	 */
	public void setStrCategoryValues(String strCategoryValues) {
		this.strCategoryValues = strCategoryValues;
	}

}
