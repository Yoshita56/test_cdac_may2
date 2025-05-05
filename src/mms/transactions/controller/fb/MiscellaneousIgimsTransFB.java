package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

public class MiscellaneousIgimsTransFB extends ActionForm{
	
	private static final long serialVersionUID = 02L;

	private String strErrMsg = "";
	private String strNormalMsg = "";
	private String strWarningMsg = "";
	
	private String strCtDate = "";
	private String strHospitalCode = "";
	private String strIsValid = "";
	
	private String strSeatId = "";
	
	private String strConsumptionDate = "";
	private String strItemCategory = "";
	private String strItemCategoryId = "";
	private String strItemCategoryId1 ="";
	private String strItemCategoryValues = "";
	private String strGroupName = "";
	private String strStoreName = "";
	private String strStoreId="";
	private String strStoreNameValues="";
	private String strRequestType = "";
	private String strItemName = "";
	private String[] strItemId = null;
	private String strGroupId = "";
	private String strGroupNameValues = "";
	private String strBrandName = "";
	private String[] strBrandId = null;
	private String[] strBatchSlNo = null;
	private String strAvlQty = "";
	private String[] strConsumptionQty = null;
	private String[] strUnitId = null;
	private String[] strUnitName = null;
	private String strRemarks = "";
	private String strStoreTypeId = "";
	private String[] itemParamValue=null;
	private String rowIndex1="";
	private String rowLength1="";
	private String strGroupIdForItemSearch="";
	private String[] strConsumptionQtyUnitId=null;
	private String strFinancialStartDate="";
	private String strFinancialEndDate="";
	private String[] strStockStatusCode=null;
	private String strReservedFlag ="";
	private String strReOrderFlgColor="";
	private String strIndentNo="";
	private String strIndentIssueDate="";
	
    private String strConsumptionNo="";
    private String strConsmpStoreId="";
    private String strConsumptionPuk="";
	private String strPatientName="";
	private String strConsumptionPatientName="";
    private String strItemCatgCombo="";	
	private String strFromDate;
	private String strCurrentDate;
	
	
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	private String strMsgType= "";
	
	public String getStrItemCatgCombo() {
		return strItemCatgCombo;
	}
	public void setStrItemCatgCombo(String strItemCatgCombo) {
		this.strItemCatgCombo = strItemCatgCombo;
	}
	
	public String getStrFromDate() {
		return strFromDate;
	}
	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}
	public String getStrToDate() {
		return strToDate;
	}
	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}
	private String strToDate;
	
	public String getStrConsumptionPatientName() {
		return strConsumptionPatientName;
	}
	public void setStrConsumptionPatientName(String strConsumptionPatientName) {
		this.strConsumptionPatientName = strConsumptionPatientName;
	}
	public String getStrPatientName() {
		return strPatientName;
	}
	public void setStrPatientName(String strPatientName) {
		this.strPatientName = strPatientName;
	}
	public String getStrConsumptionPuk() {
		return strConsumptionPuk;
	}
	public void setStrConsumptionPuk(String strConsumptionPuk) {
		this.strConsumptionPuk = strConsumptionPuk;
	}
	public String getStrConsmpStoreId() {
		return strConsmpStoreId;
	}
	public void setStrConsmpStoreId(String strConsmpStoreId) {
		this.strConsmpStoreId = strConsmpStoreId;
	}
	public String getStrConsumptionNo() {
		return strConsumptionNo;
	}
	public void setStrConsumptionNo(String strConsumptionNo) {
		this.strConsumptionNo = strConsumptionNo;
	}
	
	public String getStrIndentNo() {
		return strIndentNo;
	}
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}
	public String getStrIndentIssueDate() {
		return strIndentIssueDate;
	}
	public void setStrIndentIssueDate(String strIndentIssueDate) {
		this.strIndentIssueDate = strIndentIssueDate;
	}
	/**
	 * @return the strReservedFlag
	 */
	public String getStrReservedFlag() {
		return strReservedFlag;
	}
	/**
	 * @param strReservedFlag the strReservedFlag to set
	 */
	public void setStrReservedFlag(String strReservedFlag) {
		this.strReservedFlag = strReservedFlag;
	}
	
	/**
	 * @return the strStockStatusCode
	 */
	public String[] getStrStockStatusCode() {
		return strStockStatusCode;
	}
	/**
	 * @param strStockStatusCode the strStockStatusCode to set
	 */
	public void setStrStockStatusCode(String[] strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}
	public String getRowLength1() {
		return rowLength1;
	}
	public void setRowLength1(String rowLength1) {
		this.rowLength1 = rowLength1;
	}
	public String getRowIndex1() {
		return rowIndex1;
	}
	public void setRowIndex1(String rowIndex1) {
		this.rowIndex1 = rowIndex1;
	}
	
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrIsValid() {
		return strIsValid;
	}
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrConsumptionDate() {
		return strConsumptionDate;
	}
	public void setStrConsumptionDate(String strConsumptionDate) {
		this.strConsumptionDate = strConsumptionDate;
	}
	public String getStrItemCategory() {
		return strItemCategory;
	}
	public void setStrItemCategory(String strItemCategory) {
		this.strItemCategory = strItemCategory;
	}
	public String getStrGroupName() {
		return strGroupName;
	}
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrItemName() {
		return strItemName;
	}
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	
	public String getStrGroupId() {
		return strGroupId;
	}
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	public String getStrBrandName() {
		return strBrandName;
	}
	public void setStrBrandName(String strBrandName) {
		this.strBrandName = strBrandName;
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
	 * @return the strBrandId
	 */
	public String[] getStrBrandId() {
		return strBrandId;
	}
	/**
	 * @param strBrandId the strBrandId to set
	 */
	public void setStrBrandId(String[] strBrandId) {
		this.strBrandId = strBrandId;
	}
	/**
	 * @return the strBatchSlNo
	 */
	public String[] getStrBatchSlNo() {
		return strBatchSlNo;
	}
	/**
	 * @param strBatchSlNo the strBatchSlNo to set
	 */
	public void setStrBatchSlNo(String[] strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
	}
	public String getStrAvlQty() {
		return strAvlQty;
	}
	public void setStrAvlQty(String strAvlQty) {
		this.strAvlQty = strAvlQty;
	}
	
	public String[] getStrConsumptionQty() {
		return strConsumptionQty;
	}
	public String[] getItemParamValue() {
		return itemParamValue;
	}
	
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrStoreNameValues() {
		return strStoreNameValues;
	}
	public void setStrStoreNameValues(String strStoreNameValues) {
		this.strStoreNameValues = strStoreNameValues;
	}
	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}
	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}
	public String getStrItemCategoryValues() {
		return strItemCategoryValues;
	}
	public void setStrItemCategoryValues(String strItemCategoryValues) {
		this.strItemCategoryValues = strItemCategoryValues;
	}
	public String getStrGroupNameValues() {
		return strGroupNameValues;
	}
	public void setStrGroupNameValues(String strGroupNameValues) {
		this.strGroupNameValues = strGroupNameValues;
	}
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}
	public String getStrGroupIdForItemSearch() {
		return strGroupIdForItemSearch;
	}
	public void setStrGroupIdForItemSearch(String strGroupIdForItemSearch) {
		this.strGroupIdForItemSearch = strGroupIdForItemSearch;
	}
	public void setStrConsumptionQty(String[] strConsumptionQty) {
		this.strConsumptionQty = strConsumptionQty;
	}
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}
	public void setStrConsumptionQtyUnitId(String[] strConsumptionQtyUnitId) {
		this.strConsumptionQtyUnitId = strConsumptionQtyUnitId;
	}
	public String[] getStrConsumptionQtyUnitId() {
		return strConsumptionQtyUnitId;
	}
	/**
	 * @return the strRequestType
	 */
	public String getStrRequestType() {
		return strRequestType;
	}
	/**
	 * @param strRequestType the strRequestType to set
	 */
	public void setStrRequestType(String strRequestType) {
		this.strRequestType = strRequestType;
	}
	/**
	 * @return the strFinancialStartDate
	 */
	public String getStrFinancialStartDate() {
		return strFinancialStartDate;
	}
	/**
	 * @param strFinancialStartDate the strFinancialStartDate to set
	 */
	public void setStrFinancialStartDate(String strFinancialStartDate) {
		this.strFinancialStartDate = strFinancialStartDate;
	}
	/**
	 * @return the strFinancialEndDate
	 */
	public String getStrFinancialEndDate() {
		return strFinancialEndDate;
	}
	/**
	 * @param strFinancialEndDate the strFinancialEndDate to set
	 */
	public void setStrFinancialEndDate(String strFinancialEndDate) {
		this.strFinancialEndDate = strFinancialEndDate;
	}
	/**
	 * @param strUnitId the strUnitId to set
	 */
	public void setStrUnitId(String[] strUnitId) {
		this.strUnitId = strUnitId;
	}
	/**
	 * @return the strUnitId
	 */
	public String[] getStrUnitId() {
		return strUnitId;
	}
	/**
	 * @return the strUnitName
	 */
	public String[] getStrUnitName() {
		return strUnitName;
	}
	/**
	 * @param strUnitName the strUnitName to set
	 */
	public void setStrUnitName(String[] strUnitName) {
		this.strUnitName = strUnitName;
	}
	/**
	 * @return the strItemCategoryId1
	 */
	public String getStrItemCategoryId1() {
		return strItemCategoryId1;
	}
	/**
	 * @param strItemCategoryId1 the strItemCategoryId1 to set
	 */
	public void setStrItemCategoryId1(String strItemCategoryId1) {
		this.strItemCategoryId1 = strItemCategoryId1;
	}
	public String getStrReOrderFlgColor() {
		return strReOrderFlgColor;
	}
	public void setStrReOrderFlgColor(String strReOrderFlgColor) {
		this.strReOrderFlgColor = strReOrderFlgColor;
	}
	
	
	
	
	

}
