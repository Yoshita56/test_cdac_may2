package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class MiscellaneousConsumptionTransVO {

	
	private static final long serialVersionUID = 02L;

	private String strErrMsg = "";
	private String strNormalMsg = "";
	private String strWarningMsg = "";
	
	private String strCtDate = "";
	private String strHospitalCode = "";
	private String strIsValid = "";
	private String strConsumpNo = "";
	private String strSeatId = "";
	
	
	private String strConsumptionDate = "";
	private String strItemCategory = "";
	private String strItemCategoryId = "";
	private String strItemCategoryId1 ="";
	private String strItemCategoryValues = "";
	private String strGroupName = "";
	private String strStoreName = "";
	private String strStoreValId="";
	private String strStoreNameValues="";
	private String strItemName = "";
	private String[] strItemId = null;
	private String strGroupId = "";
	private String strRequestType = "";
	private String strGroupNameValues = "";
	private String strBrandName = "";
	private String[] strItemBrandId =null;
	private String[] strBatchSlNo = null;
	private String strAvlQty = "";
	private String[] strConsumptionQty = null;
	private String[] strUnitId = null;
	private String[] strUnitName = null;
	private String strRemarks = "";
	private String strMsgType="";
	private String strMsgString="";
	private WebRowSet storeNameValuesWS=null;
	private WebRowSet itemCategoryWS=null;
	private WebRowSet groupNameWS=null;
	
	private String[] strConsumptionQtyUnitId=null;
	
	private String strFinancialStartDate="";
	private String strFinancialEndDate="";
	private String strExpiryDate="";
	private String[] strInhandQtyUnitId=null;
	private String[] strInhandQty=null;
	private String strEntryDate="";
	
	private String strStoreTypeId="";
	
	private String[] itemParamValue = null;
	private String[] strStockStatusCode=null;
	private String strReservedFlag ="";
	private String[] strMRP=null;
	private String[] strPur=null;
	private String strLogoName ="";
	
	
	private String strPatientName ="";
	private String strIndentNo ="";
	private String strIndentIssueDate ="";
	private String strUserName="";
	private WebRowSet wsIssueDetails =null;
	
	
	
	public String getStrPatientName() {
		return strPatientName;
	}
	public void setStrPatientName(String strPatientName) {
		this.strPatientName = strPatientName;
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
	public String getStrUserName() {
		return strUserName;
	}
	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}
	public WebRowSet getWsIssueDetails() {
		return wsIssueDetails;
	}
	public void setWsIssueDetails(WebRowSet wsIssueDetails) {
		this.wsIssueDetails = wsIssueDetails;
	}
	public String getStrLogoName() {
		return strLogoName;
	}
	public void setStrLogoName(String strLogoName) {
		this.strLogoName = strLogoName;
	}
	public String[] getStrPur() {
		return strPur;
	}
	public void setStrPur(String[] strPur) {
		this.strPur = strPur;
	}
	public String[] getStrMRP() {
		return strMRP;
	}
	public void setStrMRP(String[] strMRP) {
		this.strMRP = strMRP;
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
	/**
	 * @return the itemParamValue
	 */
	public String[] getItemParamValue() {
		return itemParamValue;
	}
	/**
	 * @param itemParamValue the itemParamValue to set
	 */
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}
	public WebRowSet getItemCategoryWS() {
		return itemCategoryWS;
	}
	public void setItemCategoryWS(WebRowSet itemCategoryWS) {
		this.itemCategoryWS = itemCategoryWS;
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
	
	public String getStrStoreValId() {
		return strStoreValId;
	}
	public void setStrStoreValId(String strStoreValId) {
		this.strStoreValId = strStoreValId;
	}
	public String getStrStoreNameValues() {
		return strStoreNameValues;
	}
	public void setStrStoreNameValues(String strStoreNameValues) {
		this.strStoreNameValues = strStoreNameValues;
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
	public String getStrGroupNameValues() {
		return strGroupNameValues;
	}
	public void setStrGroupNameValues(String strGroupNameValues) {
		this.strGroupNameValues = strGroupNameValues;
	}
	public String getStrBrandName() {
		return strBrandName;
	}
	public void setStrBrandName(String strBrandName) {
		this.strBrandName = strBrandName;
	}
	
	
	public String getStrAvlQty() {
		return strAvlQty;
	}
	public void setStrAvlQty(String strAvlQty) {
		this.strAvlQty = strAvlQty;
	}
	
	
	/**
	 * @return the strUnitId
	 */
	public String[] getStrUnitId() {
		return strUnitId;
	}
	/**
	 * @param strUnitId the strUnitId to set
	 */
	public void setStrUnitId(String[] strUnitId) {
		this.strUnitId = strUnitId;
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
	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	public String getStrMsgString() {
		return strMsgString;
	}
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	public WebRowSet getStoreNameValuesWS() {
		return storeNameValuesWS;
	}
	public void setStoreNameValuesWS(WebRowSet storeNameValuesWS) {
		this.storeNameValuesWS = storeNameValuesWS;
	}
	public WebRowSet getGroupNameWS() {
		return groupNameWS;
	}
	public void setGroupNameWS(WebRowSet groupNameWS) {
		this.groupNameWS = groupNameWS;
	}
	
	public String getStrFinancialStartDate() {
		return strFinancialStartDate;
	}
	public void setStrFinancialStartDate(String strFinancialStartDate) {
		this.strFinancialStartDate = strFinancialStartDate;
	}
	public String getStrFinancialEndDate() {
		return strFinancialEndDate;
	}
	public void setStrFinancialEndDate(String strFinancialEndDate) {
		this.strFinancialEndDate = strFinancialEndDate;
	}
	
	public String getStrExpiryDate() {
		return strExpiryDate;
	}
	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}
	
	public String[] getStrConsumptionQty() {
		return strConsumptionQty;
	}
	public void setStrConsumptionQty(String[] strConsumptionQty) {
		this.strConsumptionQty = strConsumptionQty;
	}
	public String[] getStrConsumptionQtyUnitId() {
		return strConsumptionQtyUnitId;
	}
	public void setStrConsumptionQtyUnitId(String[] strConsumptionQtyUnitId) {
		this.strConsumptionQtyUnitId = strConsumptionQtyUnitId;
	}
	
	public String getStrEntryDate() {
		return strEntryDate;
	}
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}
	public String getStrConsumpNo() {
		return strConsumpNo;
	}
	public void setStrConsumpNo(String strConsumpNo) {
		this.strConsumpNo = strConsumpNo;
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
	 * @return the strInhandQtyUnitId
	 */
	public String[] getStrInhandQtyUnitId() {
		return strInhandQtyUnitId;
	}
	/**
	 * @param strInhandQtyUnitId the strInhandQtyUnitId to set
	 */
	public void setStrInhandQtyUnitId(String[] strInhandQtyUnitId) {
		this.strInhandQtyUnitId = strInhandQtyUnitId;
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
	/**
	 * @return the strInhandQty
	 */
	public String[] getStrInhandQty() {
		return strInhandQty;
	}
	/**
	 * @param strInhandQty the strInhandQty to set
	 */
	public void setStrInhandQty(String[] strInhandQty) {
		this.strInhandQty = strInhandQty;
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

}
