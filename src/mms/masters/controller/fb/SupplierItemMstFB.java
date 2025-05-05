package mms.masters.controller.fb;

import hisglobal.masterutil.GenericFormBean;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierItemMstFB.
 */
public class SupplierItemMstFB extends GenericFormBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str err. */
	private String strErr = "";
	
	/** The str msg. */
	private String strMsg = "";
	
	/** The str warning. */
	private String strWarning = "";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str supplier id. */
	private String strSupplierId = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str supplier item sl no. */
	private String strSupplierItemSlNo = "";
	
	/** The str item rate. */
	private String strItemRate = "";
	
	/** The str rate unit id. */
	private String strRateUnitId = "";

	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str effective to. */
	private String strEffectiveTo = "";
	
	/** The str last mode seat id. */
	private String strLastModeSeatId = "";
	
	/** The str last mode date. */
	private String strLastModeDate = "";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "";

	/** The str left item list. */
	private String strLeftItemList = "";
	
	/** The str right item list. */
	private String strRightItemList = "";
	
	/** The str right item ids. */
	private String[] strRightItemIds = null;
	
	/** The str left item ids. */
	private String[] strLeftItemIds = null;

	/** The str delivery lead time. */
	private String strDeliveryLeadTime = "";
	
	/** The str delivery lead time unit. */
	private String strDeliveryLeadTimeUnit = "";

	/** The str chk1. */
	private String strChk1 = "";

	// private String[] combo =null;

	/** The str combo value. */
	private String strComboValue = "";

	/** The str supplier name. */
	private String strSupplierName = "";
	
	/** The str supplier status. */
	private String strSupplierStatus = "";
	
	/** The str item name combo. */
	private String strItemNameCombo = "";
	
	/** The str rate unit combo. */
	private String strRateUnitCombo = "";
	
	/** The str item brand combo. */
	private String strItemBrandCombo = "";

	/** The str item brand name. */
	private String strItemBrandName = "";
	
	/** The str item name. */
	private String strItemName = "";
	
	/** The str item category name. */
	private String strItemCategoryName = "";

	/** The str group id. */
	private String strGroupId = "";
	
	/** The str group name combo. */
	private String strGroupNameCombo = "";
	
	/** The str sub group id. */
	private String strSubGroupId = "";
	
	/** The str group name. */
	private String strGroupName = "";
	
	/** The str sub group name. */
	private String strSubGroupName = "";
	
	/** The str store type id. */
	private String strStoreTypeId = "";

	/** The str ct date. */
	private String strCtDate = "";
	
	private String strSlNo;
	
	private String strCategoryNo;

	public String getStrCategoryNo() {
		return strCategoryNo;
	}

	public void setStrCategoryNo(String strCategoryNo) {
		this.strCategoryNo = strCategoryNo;
	}

	public String getStrSlNo() {
		return strSlNo;
	}

	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
	}

	/**
	 * Gets the str err.
	 * 
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * Gets the str msg.
	 * 
	 * @return the strMsg
	 */
	public String getStrMsg() {
		return strMsg;
	}

	/**
	 * Sets the str msg.
	 * 
	 * @param strMsg the strMsg to set
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	/**
	 * Gets the str warning.
	 * 
	 * @return the strWarning
	 */
	public String getStrWarning() {
		return strWarning;
	}

	/**
	 * Sets the str warning.
	 * 
	 * @param strWarning the strWarning to set
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}

	/**
	 * Gets the str hospital code.
	 * 
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str supplier id.
	 * 
	 * @return the strSupplierId
	 */
	public String getStrSupplierId() {
		return strSupplierId;
	}

	/**
	 * Sets the str supplier id.
	 * 
	 * @param strSupplierId the strSupplierId to set
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	/**
	 * Gets the str item id.
	 * 
	 * @return the strItemId
	 */
	public String getStrItemId() {
		return strItemId;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemId the strItemId to set
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * Gets the str item brand id.
	 * 
	 * @return the strItemBrandId
	 */
	public String getStrItemBrandId() {
		return strItemBrandId;
	}

	/**
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandId the strItemBrandId to set
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	/**
	 * Gets the str supplier item sl no.
	 * 
	 * @return the strSupplierItemSlNo
	 */
	public String getStrSupplierItemSlNo() {
		return strSupplierItemSlNo;
	}

	/**
	 * Sets the str supplier item sl no.
	 * 
	 * @param strSupplierItemSlNo the strSupplierItemSlNo to set
	 */
	public void setStrSupplierItemSlNo(String strSupplierItemSlNo) {
		this.strSupplierItemSlNo = strSupplierItemSlNo;
	}

	/**
	 * Gets the str item rate.
	 * 
	 * @return the strItemRate
	 */
	public String getStrItemRate() {
		return strItemRate;
	}

	/**
	 * Sets the str item rate.
	 * 
	 * @param strItemRate the strItemRate to set
	 */
	public void setStrItemRate(String strItemRate) {
		this.strItemRate = strItemRate;
	}

	/**
	 * Gets the str rate unit id.
	 * 
	 * @return the strRateUnitId
	 */
	public String getStrRateUnitId() {
		return strRateUnitId;
	}

	/**
	 * Sets the str rate unit id.
	 * 
	 * @param strRateUnitId the strRateUnitId to set
	 */
	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}

	/**
	 * Gets the str remarks.
	 * 
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Gets the str effective from.
	 * 
	 * @return the strEffectiveFrom
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	/**
	 * Sets the str effective from.
	 * 
	 * @param strEffectiveFrom the strEffectiveFrom to set
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
	}

	/**
	 * Gets the str effective to.
	 * 
	 * @return the strEffectiveTo
	 */
	public String getStrEffectiveTo() {
		return strEffectiveTo;
	}

	/**
	 * Sets the str effective to.
	 * 
	 * @param strEffectiveTo the strEffectiveTo to set
	 */
	public void setStrEffectiveTo(String strEffectiveTo) {
		this.strEffectiveTo = strEffectiveTo;
	}

	/**
	 * Gets the str last mode seat id.
	 * 
	 * @return the strLastModeSeatId
	 */
	public String getStrLastModeSeatId() {
		return strLastModeSeatId;
	}

	/**
	 * Sets the str last mode seat id.
	 * 
	 * @param strLastModeSeatId the strLastModeSeatId to set
	 */
	public void setStrLastModeSeatId(String strLastModeSeatId) {
		this.strLastModeSeatId = strLastModeSeatId;
	}

	/**
	 * Gets the str last mode date.
	 * 
	 * @return the strLastModeDate
	 */
	public String getStrLastModeDate() {
		return strLastModeDate;
	}

	/**
	 * Sets the str last mode date.
	 * 
	 * @param strLastModeDate the strLastModeDate to set
	 */
	public void setStrLastModeDate(String strLastModeDate) {
		this.strLastModeDate = strLastModeDate;
	}

	/**
	 * Gets the str entry date.
	 * 
	 * @return the strEntryDate
	 */
	public String getStrEntryDate() {
		return strEntryDate;
	}

	/**
	 * Sets the str entry date.
	 * 
	 * @param strEntryDate the strEntryDate to set
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the str is valid.
	 * 
	 * @return the strIsValid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}

	/**
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * Gets the str delivery lead time.
	 * 
	 * @return the strDeliveryLeadTime
	 */
	public String getStrDeliveryLeadTime() {
		return strDeliveryLeadTime;
	}

	/**
	 * Sets the str delivery lead time.
	 * 
	 * @param strDeliveryLeadTime the strDeliveryLeadTime to set
	 */
	public void setStrDeliveryLeadTime(String strDeliveryLeadTime) {
		this.strDeliveryLeadTime = strDeliveryLeadTime;
	}

	/**
	 * Gets the str delivery lead time unit.
	 * 
	 * @return the strDeliveryLeadTimeUnit
	 */
	public String getStrDeliveryLeadTimeUnit() {
		return strDeliveryLeadTimeUnit;
	}

	/**
	 * Sets the str delivery lead time unit.
	 * 
	 * @param strDeliveryLeadTimeUnit the strDeliveryLeadTimeUnit to set
	 */
	public void setStrDeliveryLeadTimeUnit(String strDeliveryLeadTimeUnit) {
		this.strDeliveryLeadTimeUnit = strDeliveryLeadTimeUnit;
	}

	/**
	 * Gets the str chk1.
	 * 
	 * @return the strChk1
	 */
	public String getStrChk1() {
		return strChk1;
	}

	/**
	 * Sets the str chk1.
	 * 
	 * @param strChk1 the strChk1 to set
	 */
	public void setStrChk1(String strChk1) {
		this.strChk1 = strChk1;
	}

	/**
	 * Gets the str supplier name.
	 * 
	 * @return the strSupplierName
	 */
	public String getStrSupplierName() {
		return strSupplierName;
	}

	/**
	 * Sets the str supplier name.
	 * 
	 * @param strSupplierName the strSupplierName to set
	 */
	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}

	/**
	 * Gets the str supplier status.
	 * 
	 * @return the strSupplierStatus
	 */
	public String getStrSupplierStatus() {
		return strSupplierStatus;
	}

	/**
	 * Sets the str supplier status.
	 * 
	 * @param strSupplierStatus the strSupplierStatus to set
	 */
	public void setStrSupplierStatus(String strSupplierStatus) {
		this.strSupplierStatus = strSupplierStatus;
	}

	/**
	 * Gets the str item name combo.
	 * 
	 * @return the strItemNameCombo
	 */
	public String getStrItemNameCombo() {
		return strItemNameCombo;
	}

	/**
	 * Sets the str item name combo.
	 * 
	 * @param strItemNameCombo the strItemNameCombo to set
	 */
	public void setStrItemNameCombo(String strItemNameCombo) {
		this.strItemNameCombo = strItemNameCombo;
	}

	/**
	 * Gets the str rate unit combo.
	 * 
	 * @return the strRateUnitCombo
	 */
	public String getStrRateUnitCombo() {
		return strRateUnitCombo;
	}

	/**
	 * Sets the str rate unit combo.
	 * 
	 * @param strRateUnitCombo the strRateUnitCombo to set
	 */
	public void setStrRateUnitCombo(String strRateUnitCombo) {
		this.strRateUnitCombo = strRateUnitCombo;
	}

	/**
	 * Gets the str ct date.
	 * 
	 * @return the strCtDate
	 */
	public String getStrCtDate() {
		return strCtDate;
	}

	/**
	 * Sets the str ct date.
	 * 
	 * @param strCtDate the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	/**
	 * Gets the serial version uid.
	 * 
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * Gets the str item brand combo.
	 * 
	 * @return the strItemBrandCombo
	 */
	public String getStrItemBrandCombo() {
		return strItemBrandCombo;
	}

	/**
	 * Sets the str item brand combo.
	 * 
	 * @param strItemBrandCombo the strItemBrandCombo to set
	 */
	public void setStrItemBrandCombo(String strItemBrandCombo) {
		this.strItemBrandCombo = strItemBrandCombo;
	}

	/**
	 * Gets the str combo value.
	 * 
	 * @return the strComboValue
	 */
	public String getStrComboValue() {
		return strComboValue;
	}

	/**
	 * Sets the str combo value.
	 * 
	 * @param strComboValue the strComboValue to set
	 */
	public void setStrComboValue(String strComboValue) {
		this.strComboValue = strComboValue;
	}

	/**
	 * Gets the str item brand name.
	 * 
	 * @return the strItemBrandName
	 */
	public String getStrItemBrandName() {
		return strItemBrandName;
	}

	/**
	 * Sets the str item brand name.
	 * 
	 * @param strItemBrandName the strItemBrandName to set
	 */
	public void setStrItemBrandName(String strItemBrandName) {
		this.strItemBrandName = strItemBrandName;
	}

	/**
	 * Gets the str item name.
	 * 
	 * @return the strItemName
	 */
	public String getStrItemName() {
		return strItemName;
	}

	/**
	 * Sets the str item name.
	 * 
	 * @param strItemName the strItemName to set
	 */
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}

	/**
	 * Gets the str item category name.
	 * 
	 * @return the strItemCategoryName
	 */
	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}

	/**
	 * Sets the str item category name.
	 * 
	 * @param strItemCategoryName the strItemCategoryName to set
	 */
	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}

	/**
	 * Gets the str group id.
	 * 
	 * @return the strGroupId
	 */
	public String getStrGroupId() {
		return strGroupId;
	}

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * Gets the str group name combo.
	 * 
	 * @return the strGroupNameCombo
	 */
	public String getStrGroupNameCombo() {
		return strGroupNameCombo;
	}

	/**
	 * Sets the str group name combo.
	 * 
	 * @param strGroupNameCombo the strGroupNameCombo to set
	 */
	public void setStrGroupNameCombo(String strGroupNameCombo) {
		this.strGroupNameCombo = strGroupNameCombo;
	}

	/**
	 * Gets the str sub group id.
	 * 
	 * @return the strSubGroupId
	 */
	public String getStrSubGroupId() {
		return strSubGroupId;
	}

	/**
	 * Sets the str sub group id.
	 * 
	 * @param strSubGroupId the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	/**
	 * Gets the str group name.
	 * 
	 * @return the strGroupName
	 */
	public String getStrGroupName() {
		return strGroupName;
	}

	/**
	 * Sets the str group name.
	 * 
	 * @param strGroupName the strGroupName to set
	 */
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}

	/**
	 * Gets the str sub group name.
	 * 
	 * @return the strSubGroupName
	 */
	public String getStrSubGroupName() {
		return strSubGroupName;
	}

	/**
	 * Sets the str sub group name.
	 * 
	 * @param strSubGroupName the strSubGroupName to set
	 */
	public void setStrSubGroupName(String strSubGroupName) {
		this.strSubGroupName = strSubGroupName;
	}

	/**
	 * Gets the str store type id.
	 * 
	 * @return the strStoreTypeId
	 */
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}

	/**
	 * Sets the str store type id.
	 * 
	 * @param strStoreTypeId the strStoreTypeId to set
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}

	/**
	 * Gets the str left item list.
	 * 
	 * @return the strLeftItemList
	 */
	public String getStrLeftItemList() {
		return strLeftItemList;
	}

	/**
	 * Sets the str left item list.
	 * 
	 * @param strLeftItemList the strLeftItemList to set
	 */
	public void setStrLeftItemList(String strLeftItemList) {
		this.strLeftItemList = strLeftItemList;
	}

	/**
	 * Gets the str right item list.
	 * 
	 * @return the strRightItemList
	 */
	public String getStrRightItemList() {
		return strRightItemList;
	}

	/**
	 * Sets the str right item list.
	 * 
	 * @param strRightItemList the strRightItemList to set
	 */
	public void setStrRightItemList(String strRightItemList) {
		this.strRightItemList = strRightItemList;
	}

	/**
	 * Gets the str right item ids.
	 * 
	 * @return the strRightItemIds
	 */
	public String[] getStrRightItemIds() {
		return strRightItemIds;
	}

	/**
	 * Sets the str right item ids.
	 * 
	 * @param strRightItemIds the strRightItemIds to set
	 */
	public void setStrRightItemIds(String[] strRightItemIds) {
		this.strRightItemIds = strRightItemIds;
	}

	/**
	 * Gets the str left item ids.
	 * 
	 * @return the strLeftItemIds
	 */
	public String[] getStrLeftItemIds() {
		return strLeftItemIds;
	}

	/**
	 * Sets the str left item ids.
	 * 
	 * @param strLeftItemIds the strLeftItemIds to set
	 */
	public void setStrLeftItemIds(String[] strLeftItemIds) {
		this.strLeftItemIds = strLeftItemIds;
	}

}
