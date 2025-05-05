package mms.masters.controller.fb;

import hisglobal.masterutil.GenericFormBean;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreItemMstFB.
 */
public class StoreItemMstFB extends GenericFormBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str err. */
	private String strErr = "";
	
	/** The str msg. */
	private String strMsg = "";
	
	/** The str warning. */
	private String strWarning = "";

	private String strLevelUnitName = "";
	
	private String strToleranceLimit = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str item sl no. */
	private String strItemSlNo = "";
	
	/** The str item short name. */
	private String strItemShortName = "";
	
	/** The str ved category. */
	private String strVEDCategory = "";
	
	/** The str fore cast. */
	private String strForeCast = "";
	
	/** The str reserved qty. */
	private String strReservedQty = "";
	
	/** The str max qty. */
	private String strMaxQty = "";
	
	/** The str min qty. */
	private String strMinQty = "";
	
	/** The str reorder qty. */
	private String strReorderQty = "";
	
	/** The str level unit id. */
	private String strLevelUnitId = "";
	
	/** The str last indent qty. */
	private String strLastIndentQty = "0";
	
	/** The str last indent unit id. */
	private String strLastIndentUnitId = "0";
	
	/** The str last issue qty. */
	private String strLastIssueQty = "0";
	
	/** The str last issue unit id. */
	private String strLastIssueUnitId = "";
	
	/** The str last receive qty. */
	private String strLastReceiveQty = "0";
	
	/** The str last receive unit id. */
	private String strLastReceiveUnitId = "";
	
	/** The str issueable flag. */
	private String strIssueableFlag = "";
	
	/** The str is returnable. */
	private String strIsReturnable = "";

	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
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

	/** The str chk1. */
	private String strChk1 = "";
	// private String[] combo =null;
	/** The str store name. */
	private String strStoreName = "";
	
	/** The str store level. */
	private String strStoreLevel = "";
	
	/** The str ct date. */
	private String strCtDate = "";

	/** The str level unit combo. */
	private String strLevelUnitCombo = "";

	/** The str item name combo. */
	private String strItemNameCombo = "";

	/** The str item brand combo. */
	private String strItemBrandCombo = "";

	/** The str category no. */
	private String strCategoryNo = "";
	
	/** The str combo value. */
	private String strComboValue = "";
	
	/** The str store type id. */
	private String strStoreTypeId = "";
	
	/** The str store combo. */
	private String strStoreCombo = "";

	/** The str group name. */
	private String strGroupName = "";
	
	/** The str sub group name. */
	private String strSubGroupName = "";

	/** The str from store id. */
	private String strFromStoreId = "";

	/** The str item brand name. */
	private String strItemBrandName = "";
	
	/** The str item name. */
	private String strItemName = "";

	/** The str group id. */
	private String strGroupId = "";
	
	/** The str group name combo. */
	private String strGroupNameCombo = "";

	/** The str sub group id. */
	private String strSubGroupId = "";

	/** The str item category name. */
	private String strItemCategoryName = "";
	private String strMaxLevelUnitId="";
	private String strMaxIndentQty;
	

	public String getStrMaxIndentQty() {
		return strMaxIndentQty;
	}

	public void setStrMaxIndentQty(String strMaxIndentQty) {
		this.strMaxIndentQty = strMaxIndentQty;
	}

	public String getStrMaxLevelUnitId() {
		return strMaxLevelUnitId;
	}

	public void setStrMaxLevelUnitId(String strMaxLevelUnitId) {
		this.strMaxLevelUnitId = strMaxLevelUnitId;
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
	 * Gets the str category no.
	 * 
	 * @return the strCategoryNo
	 */
	public String getStrCategoryNo() {
		return strCategoryNo;
	}

	/**
	 * Sets the str category no.
	 * 
	 * @param strCategoryNo the strCategoryNo to set
	 */
	public void setStrCategoryNo(String strCategoryNo) {
		this.strCategoryNo = strCategoryNo;
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
	 * Gets the str store id.
	 * 
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
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
	 * Gets the str item sl no.
	 * 
	 * @return the strItemSlNo
	 */
	public String getStrItemSlNo() {
		return strItemSlNo;
	}

	/**
	 * Sets the str item sl no.
	 * 
	 * @param strItemSlNo the strItemSlNo to set
	 */
	public void setStrItemSlNo(String strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
	}

	/**
	 * Gets the str item short name.
	 * 
	 * @return the strItemShortName
	 */
	public String getStrItemShortName() {
		return strItemShortName;
	}

	/**
	 * Sets the str item short name.
	 * 
	 * @param strItemShortName the strItemShortName to set
	 */
	public void setStrItemShortName(String strItemShortName) {
		this.strItemShortName = strItemShortName;
	}

	/**
	 * Gets the str ved category.
	 * 
	 * @return the strVEDCategory
	 */
	public String getStrVEDCategory() {
		return strVEDCategory;
	}

	/**
	 * Sets the str ved category.
	 * 
	 * @param strVEDCategory the strVEDCategory to set
	 */
	public void setStrVEDCategory(String strVEDCategory) {
		this.strVEDCategory = strVEDCategory;
	}

	/**
	 * Gets the str fore cast.
	 * 
	 * @return the strForeCast
	 */
	public String getStrForeCast() {
		return strForeCast;
	}

	/**
	 * Sets the str fore cast.
	 * 
	 * @param strForeCast the strForeCast to set
	 */
	public void setStrForeCast(String strForeCast) {
		this.strForeCast = strForeCast;
	}

	/**
	 * Gets the str max qty.
	 * 
	 * @return the strMaxQty
	 */
	public String getStrMaxQty() {
		return strMaxQty;
	}

	/**
	 * Sets the str max qty.
	 * 
	 * @param strMaxQty the strMaxQty to set
	 */
	public void setStrMaxQty(String strMaxQty) {
		this.strMaxQty = strMaxQty;
	}

	/**
	 * Gets the str min qty.
	 * 
	 * @return the strMinQty
	 */
	public String getStrMinQty() {
		return strMinQty;
	}

	/**
	 * Sets the str min qty.
	 * 
	 * @param strMinQty the strMinQty to set
	 */
	public void setStrMinQty(String strMinQty) {
		this.strMinQty = strMinQty;
	}

	/**
	 * Gets the str reorder qty.
	 * 
	 * @return the strReorderQty
	 */
	public String getStrReorderQty() {
		return strReorderQty;
	}

	/**
	 * Sets the str reorder qty.
	 * 
	 * @param strReorderQty the strReorderQty to set
	 */
	public void setStrReorderQty(String strReorderQty) {
		this.strReorderQty = strReorderQty;
	}

	/**
	 * Gets the str level unit id.
	 * 
	 * @return the strLevelUnitId
	 */
	public String getStrLevelUnitId() {
		return strLevelUnitId;
	}

	/**
	 * Sets the str level unit id.
	 * 
	 * @param strLevelUnitId the strLevelUnitId to set
	 */
	public void setStrLevelUnitId(String strLevelUnitId) {
		this.strLevelUnitId = strLevelUnitId;
	}

	/**
	 * Gets the str last indent qty.
	 * 
	 * @return the strLastIndentQty
	 */
	public String getStrLastIndentQty() {
		return strLastIndentQty;
	}

	/**
	 * Sets the str last indent qty.
	 * 
	 * @param strLastIndentQty the strLastIndentQty to set
	 */
	public void setStrLastIndentQty(String strLastIndentQty) {
		this.strLastIndentQty = strLastIndentQty;
	}

	/**
	 * Gets the str last indent unit id.
	 * 
	 * @return the strLastIndentUnitId
	 */
	public String getStrLastIndentUnitId() {
		return strLastIndentUnitId;
	}

	/**
	 * Sets the str last indent unit id.
	 * 
	 * @param strLastIndentUnitId the strLastIndentUnitId to set
	 */
	public void setStrLastIndentUnitId(String strLastIndentUnitId) {
		this.strLastIndentUnitId = strLastIndentUnitId;
	}

	/**
	 * Gets the str last issue qty.
	 * 
	 * @return the strLastIssueQty
	 */
	public String getStrLastIssueQty() {
		return strLastIssueQty;
	}

	/**
	 * Sets the str last issue qty.
	 * 
	 * @param strLastIssueQty the strLastIssueQty to set
	 */
	public void setStrLastIssueQty(String strLastIssueQty) {
		this.strLastIssueQty = strLastIssueQty;
	}

	/**
	 * Gets the str last issue unit id.
	 * 
	 * @return the strLastIssueUnitId
	 */
	public String getStrLastIssueUnitId() {
		return strLastIssueUnitId;
	}

	/**
	 * Sets the str last issue unit id.
	 * 
	 * @param strLastIssueUnitId the strLastIssueUnitId to set
	 */
	public void setStrLastIssueUnitId(String strLastIssueUnitId) {
		this.strLastIssueUnitId = strLastIssueUnitId;
	}

	/**
	 * Gets the str last receive qty.
	 * 
	 * @return the strLastReceiveQty
	 */
	public String getStrLastReceiveQty() {
		return strLastReceiveQty;
	}

	/**
	 * Sets the str last receive qty.
	 * 
	 * @param strLastReceiveQty the strLastReceiveQty to set
	 */
	public void setStrLastReceiveQty(String strLastReceiveQty) {
		this.strLastReceiveQty = strLastReceiveQty;
	}

	/**
	 * Gets the str last receive unit id.
	 * 
	 * @return the strLastReceiveUnitId
	 */
	public String getStrLastReceiveUnitId() {
		return strLastReceiveUnitId;
	}

	/**
	 * Sets the str last receive unit id.
	 * 
	 * @param strLastReceiveUnitId the strLastReceiveUnitId to set
	 */
	public void setStrLastReceiveUnitId(String strLastReceiveUnitId) {
		this.strLastReceiveUnitId = strLastReceiveUnitId;
	}

	/**
	 * Gets the str issueable flag.
	 * 
	 * @return the strIssueableFlag
	 */
	public String getStrIssueableFlag() {
		return strIssueableFlag;
	}

	/**
	 * Sets the str issueable flag.
	 * 
	 * @param strIssueableFlag the strIssueableFlag to set
	 */
	public void setStrIssueableFlag(String strIssueableFlag) {
		this.strIssueableFlag = strIssueableFlag;
	}

	/**
	 * Gets the str is returnable.
	 * 
	 * @return the strIsReturnable
	 */
	public String getStrIsReturnable() {
		return strIsReturnable;
	}

	/**
	 * Sets the str is returnable.
	 * 
	 * @param strIsReturnable the strIsReturnable to set
	 */
	public void setStrIsReturnable(String strIsReturnable) {
		this.strIsReturnable = strIsReturnable;
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
	 * Gets the str store name.
	 * 
	 * @return the strStoreName
	 */
	public String getStrStoreName() {
		return strStoreName;
	}

	/**
	 * Sets the str store name.
	 * 
	 * @param strStoreName the strStoreName to set
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
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
	 * Gets the str store level.
	 * 
	 * @return the strStoreLevel
	 */
	public String getStrStoreLevel() {
		return strStoreLevel;
	}

	/**
	 * Sets the str store level.
	 * 
	 * @param strStoreLevel the strStoreLevel to set
	 */
	public void setStrStoreLevel(String strStoreLevel) {
		this.strStoreLevel = strStoreLevel;
	}

	/**
	 * Gets the str level unit combo.
	 * 
	 * @return the strLevelUnitCombo
	 */
	public String getStrLevelUnitCombo() {
		return strLevelUnitCombo;
	}

	/**
	 * Sets the str level unit combo.
	 * 
	 * @param strLevelUnitCombo the strLevelUnitCombo to set
	 */
	public void setStrLevelUnitCombo(String strLevelUnitCombo) {
		this.strLevelUnitCombo = strLevelUnitCombo;
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
	 * Gets the str store combo.
	 * 
	 * @return the strStoreCombo
	 */
	public String getStrStoreCombo() {
		return strStoreCombo;
	}

	/**
	 * Sets the str store combo.
	 * 
	 * @param strStoreCombo the strStoreCombo to set
	 */
	public void setStrStoreCombo(String strStoreCombo) {
		this.strStoreCombo = strStoreCombo;
	}

	/**
	 * Gets the str from store id.
	 * 
	 * @return the strFromStoreId
	 */
	public String getStrFromStoreId() {
		return strFromStoreId;
	}

	/**
	 * Sets the str from store id.
	 * 
	 * @param strFromStoreId the strFromStoreId to set
	 */
	public void setStrFromStoreId(String strFromStoreId) {
		this.strFromStoreId = strFromStoreId;
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
	 * Gets the str item category name.
	 * 
	 * @return the str item category name
	 */
	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}

	/**
	 * Sets the str item category name.
	 * 
	 * @param strItemCategoryName the new str item category name
	 */
	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}

	/**
	 * Gets the str reserved qty.
	 * 
	 * @return the str reserved qty
	 */
	public String getStrReservedQty() {
		return strReservedQty;
	}

	/**
	 * Sets the str reserved qty.
	 * 
	 * @param strReservedQty the new str reserved qty
	 */
	public void setStrReservedQty(String strReservedQty) {
		this.strReservedQty = strReservedQty;
	}

	/**
	 * @return the strToleranceLimit
	 */
	public String getStrToleranceLimit() {
		return strToleranceLimit;
	}

	/**
	 * @param strToleranceLimit the strToleranceLimit to set
	 */
	public void setStrToleranceLimit(String strToleranceLimit) {
		this.strToleranceLimit = strToleranceLimit;
	}

	public String getStrLevelUnitName() {
		return strLevelUnitName;
	}

	public void setStrLevelUnitName(String strLevelUnitName) {
		this.strLevelUnitName = strLevelUnitName;
	}

}
