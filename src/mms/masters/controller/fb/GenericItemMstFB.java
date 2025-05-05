package mms.masters.controller.fb;

import hisglobal.masterutil.GenericFormBean;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericItemMstFB.
 */
public class GenericItemMstFB extends GenericFormBean {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str norm mssgstring. */
	private String strNormMssgstring = "";
	
	/** The str warn mssgstring. */
	private String strWarnMssgstring = "";
	
	/** The str err mssgstring. */
	private String strErrMssgstring = "";
	
	/** The str hosp code. */
	private String strHospCode = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str chk. */
	private String strChk = "";
	
	/** The str is valid. */
	private String strIsValid = "";
	
	/** The str current date. */
	private String strCurrentDate = "";
	// private String strItemType="";
	/** The str item name. */
	private String strItemName = "";
	// private String strDefaultRate="";
	/** The str batch no. */
	
	
	private String strCPACode = "" ;
	
	private String strBatchNo = "0";
	
	/** The str expiry date. */
	private String strExpiryDate = "0";
	
	/** The str purchase lead time. */
	private String strPurchaseLeadTime = "";
	
	/** The str time format. */
	private String strTimeFormat = "";
	
	/** The str stock maintain. */
	private String strStockMaintain = "0";
	
	/** The str shelf life. */
	private String strShelfLife = "";
	
	/** The str shelf time format. */
	private String strShelfTimeFormat = "0";
	// private String strApprovedBy="";
	// private String strIssueType="";
	/** The str consumable type. */
	private String strConsumableType = "";
	// private String strIsItemSachet="0";

	// private String strUnitValues="";
	/** The str stock maintained values. */
	private String strStockMaintainedValues = "";
	// private String strManufacturerValues="";
	// private String strItemTypeValues="";
	/** The str module id. */
	private String strModuleId = "0";
	private String strStockMaintainedCode;
	
	/** The combo1. */
	private String combo1[] = null;
	
	/** The str group name value. */
	private String strGroupNameValue = "";
	
	/** The str sub group name value. */
	private String strSubGroupNameValue = "";
	
	/** The combo value1. */
	private String comboValue1 = "";
	// private String strUnit="";
	/** The str group id. */
	private String strGroupId = "0";
	
	/** The str sub group id. */
	private String strSubGroupId = "0";
	// private String strUnitValuesModi="";
	// private String strItemTypeValuesModi="";
	/** The str stock maintained values modi. */
	private String strStockMaintainedValuesModi = "";
	
	private String strDepreciationcost="";
	private String strAssetsReq="0";
	// private String strBrandItemDtlValues="";
	// private String strBrandName[]=null;
	// private String strBrandedManufacturer[]=null;
	// private String strBrandedRate[]=null;
	// private String strBrandedUnit[]=null;
	// private String strBrandedApprovedBy[]=null;
	// private String strBrandedIssueType[]=null;
	// private String strBrandedItemMaker[]=null;
	// private String strBrandedItemStatus[]=null; // col delete from table on
	// 1-may-09
	// private String strModify[]=null;
	// private String primaryKeyBrandItem[]=null;
	/** The str count. */
	private String strCount = "";
	
	/** The check row. */
	private String[] checkRow = null;
	
	/** The str serial no. */
	private String strSerialNo = null;
	// private String strItemComposit=null; // col delete from table on 1-may-09
	/** The str param. */
	private String strParam = null;
	
	/** The str cat no. */
	private String strCatNo = "";
	
	/** The str param check. */
	private String[] strParamCheck = null;
	
	/** The str param value. */
	private String[] strParamValue = null;
	
	/** The str param dtls. */
	private String[] strParamDtls = null;
	
	/** The str param status. */
	private String[] strParamStatus = null;
	
	/** The str item id. */
	private String strItemID = "";
	// private String strSparePart="";
	/** The str cat values. */
	private String strCatValues = "";

	private String strInventoryUnitName = "";

	private String strIsItemCodeRequired = "0";
	
	
	/*
	 * Added By Aritra
	 * Its value should be 0 or 1.
	 * 0 => Non Consumable
	 * 1 => Consumable
	 */

	private String strConsumableFlag;
	
	
	
	/**
	 * Gets the str cat values.
	 * 
	 * @return the str cat values
	 */
	public String getStrCatValues() {
		return strCatValues;
	}

	/**
	 * Sets the str cat values.
	 * 
	 * @param strCatValues the new str cat values
	 */
	public void setStrCatValues(String strCatValues) {
		this.strCatValues = strCatValues;
	}

	/**
	 * Gets the str item id.
	 * 
	 * @return the str item id
	 */
	public String getStrItemID() {
		return strItemID;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemID the new str item id
	 */
	public void setStrItemID(String strItemID) {
		this.strItemID = strItemID;
	}

	/**
	 * Gets the str param dtls.
	 * 
	 * @return the str param dtls
	 */
	public String[] getStrParamDtls() {
		return strParamDtls;
	}

	/**
	 * Sets the str param dtls.
	 * 
	 * @param strParamDtls the new str param dtls
	 */
	public void setStrParamDtls(String[] strParamDtls) {
		this.strParamDtls = strParamDtls;
	}

	/**
	 * Gets the str param status.
	 * 
	 * @return the str param status
	 */
	public String[] getStrParamStatus() {
		return strParamStatus;
	}

	/**
	 * Sets the str param status.
	 * 
	 * @param strParamStatus the new str param status
	 */
	public void setStrParamStatus(String[] strParamStatus) {
		this.strParamStatus = strParamStatus;
	}

	/**
	 * Gets the str param check.
	 * 
	 * @return the str param check
	 */
	public String[] getStrParamCheck() {
		return strParamCheck;
	}

	/**
	 * Sets the str param check.
	 * 
	 * @param strParamCheck the new str param check
	 */
	public void setStrParamCheck(String[] strParamCheck) {
		this.strParamCheck = strParamCheck;
	}

	/**
	 * Gets the str param value.
	 * 
	 * @return the str param value
	 */
	public String[] getStrParamValue() {
		return strParamValue;
	}

	/**
	 * Sets the str param value.
	 * 
	 * @param strParamValue the new str param value
	 */
	public void setStrParamValue(String[] strParamValue) {
		this.strParamValue = strParamValue;
	}

	/**
	 * Gets the str cat no.
	 * 
	 * @return the str cat no
	 */
	public String getStrCatNo() {
		return strCatNo;
	}

	/**
	 * Sets the str cat no.
	 * 
	 * @param strCatNo the new str cat no
	 */
	public void setStrCatNo(String strCatNo) {
		this.strCatNo = strCatNo;
	}

	/**
	 * Gets the str serial no.
	 * 
	 * @return the str serial no
	 */
	public String getStrSerialNo() {
		return strSerialNo;
	}

	/**
	 * Sets the str serial no.
	 * 
	 * @param strSerialNo the new str serial no
	 */
	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
	}

	/*
	 * public String getStrItemComposit() { return strItemComposit; } public
	 * void setStrItemComposit(String strItemComposit) { this.strItemComposit =
	 * strItemComposit; }
	 */
	/**
	 * Gets the str param.
	 * 
	 * @return the str param
	 */
	public String getStrParam() {
		return strParam;
	}

	/**
	 * Sets the str param.
	 * 
	 * @param strParam the new str param
	 */
	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}

	/**
	 * Gets the check row.
	 * 
	 * @return the check row
	 */
	public String[] getCheckRow() {
		return checkRow;
	}

	/**
	 * Sets the check row.
	 * 
	 * @param checkRow the new check row
	 */
	public void setCheckRow(String[] checkRow) {
		this.checkRow = checkRow;
	}

	/**
	 * Gets the combo1.
	 * 
	 * @return the combo1
	 */
	public String[] getCombo1() {
		return combo1;
	}

	/**
	 * Sets the combo1.
	 * 
	 * @param combo1 the combo1 to set
	 */
	public void setCombo1(String[] combo1) {
		this.combo1 = combo1;
	}

	/**
	 * Gets the combo value1.
	 * 
	 * @return the comboValue1
	 */
	public String getComboValue1() {
		return comboValue1;
	}

	/**
	 * Sets the combo value1.
	 * 
	 * @param comboValue1 the comboValue1 to set
	 */
	public void setComboValue1(String comboValue1) {
		this.comboValue1 = comboValue1;
	}

	/**
	 * Gets the str module id.
	 * 
	 * @return the str module id
	 */
	public String getStrModuleId() {
		return strModuleId;
	}

	/**
	 * Sets the str module id.
	 * 
	 * @param strModuleId the new str module id
	 */
	public void setStrModuleId(String strModuleId) {
		this.strModuleId = strModuleId;
	}

	/**
	 * Gets the str current date.
	 * 
	 * @return the str current date
	 */
	public String getStrCurrentDate() {
		return strCurrentDate;
	}

	/**
	 * Gets the str is valid.
	 * 
	 * @return the str is valid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}

	/**
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the new str is valid
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the str seat id
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the str norm mssgstring.
	 * 
	 * @return the str norm mssgstring
	 */
	public String getStrNormMssgstring() {
		return strNormMssgstring;
	}

	/**
	 * Sets the str norm mssgstring.
	 * 
	 * @param strNormMssgstring the new str norm mssgstring
	 */
	public void setStrNormMssgstring(String strNormMssgstring) {
		this.strNormMssgstring = strNormMssgstring;
	}

	/**
	 * Gets the str warn mssgstring.
	 * 
	 * @return the str warn mssgstring
	 */
	public String getStrWarnMssgstring() {
		return strWarnMssgstring;
	}

	/**
	 * Sets the str warn mssgstring.
	 * 
	 * @param strWarnMssgstring the new str warn mssgstring
	 */
	public void setStrWarnMssgstring(String strWarnMssgstring) {
		this.strWarnMssgstring = strWarnMssgstring;
	}

	/**
	 * Gets the str err mssgstring.
	 * 
	 * @return the str err mssgstring
	 */
	public String getStrErrMssgstring() {
		return strErrMssgstring;
	}

	/**
	 * Sets the str err mssgstring.
	 * 
	 * @param strErrMssgstring the new str err mssgstring
	 */
	public void setStrErrMssgstring(String strErrMssgstring) {
		this.strErrMssgstring = strErrMssgstring;
	}

	/**
	 * Gets the str hosp code.
	 * 
	 * @return the str hosp code
	 */
	public String getStrHospCode() {
		return strHospCode;
	}

	/**
	 * Sets the str hosp code.
	 * 
	 * @param strHospCode the new str hosp code
	 */
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}

	/**
	 * Gets the str remarks.
	 * 
	 * @return the str remarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Gets the str effective from.
	 * 
	 * @return the str effective from
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	/**
	 * Sets the str effective from.
	 * 
	 * @param strEffectiveFrom the new str effective from
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
	}

	/**
	 * Gets the str chk.
	 * 
	 * @return the str chk
	 */
	public String getStrChk() {
		return strChk;
	}

	/**
	 * Sets the str chk.
	 * 
	 * @param strChk the new str chk
	 */
	public void setStrChk(String strChk) {
		this.strChk = strChk;
	}

	/**
	 * Gets the str item name.
	 * 
	 * @return the str item name
	 */
	public String getStrItemName() {
		return strItemName;
	}

	/**
	 * Sets the str item name.
	 * 
	 * @param strItemName the new str item name
	 */
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}

	/**
	 * Gets the str batch no.
	 * 
	 * @return the str batch no
	 */
	public String getStrBatchNo() {
		return strBatchNo;
	}

	/**
	 * Sets the str batch no.
	 * 
	 * @param strBatchNo the new str batch no
	 */
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	/**
	 * Gets the str expiry date.
	 * 
	 * @return the str expiry date
	 */
	public String getStrExpiryDate() {
		return strExpiryDate;
	}

	/**
	 * Sets the str expiry date.
	 * 
	 * @param strExpiryDate the new str expiry date
	 */
	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}

	/**
	 * Gets the str purchase lead time.
	 * 
	 * @return the str purchase lead time
	 */
	public String getStrPurchaseLeadTime() {
		return strPurchaseLeadTime;
	}

	/**
	 * Sets the str purchase lead time.
	 * 
	 * @param strPurchaseLeadTime the new str purchase lead time
	 */
	public void setStrPurchaseLeadTime(String strPurchaseLeadTime) {
		this.strPurchaseLeadTime = strPurchaseLeadTime;
	}

	/**
	 * Gets the str time format.
	 * 
	 * @return the str time format
	 */
	public String getStrTimeFormat() {
		return strTimeFormat;
	}

	/**
	 * Sets the str time format.
	 * 
	 * @param strTimeFormat the new str time format
	 */
	public void setStrTimeFormat(String strTimeFormat) {
		this.strTimeFormat = strTimeFormat;
	}

	/**
	 * Gets the str stock maintain.
	 * 
	 * @return the str stock maintain
	 */
	public String getStrStockMaintain() {
		return strStockMaintain;
	}

	/**
	 * Sets the str stock maintain.
	 * 
	 * @param strStockMaintain the new str stock maintain
	 */
	public void setStrStockMaintain(String strStockMaintain) {
		this.strStockMaintain = strStockMaintain;
	}

	/**
	 * Gets the str shelf life.
	 * 
	 * @return the str shelf life
	 */
	public String getStrShelfLife() {
		return strShelfLife;
	}

	/**
	 * Sets the str shelf life.
	 * 
	 * @param strShelfLife the new str shelf life
	 */
	public void setStrShelfLife(String strShelfLife) {
		this.strShelfLife = strShelfLife;
	}

	/**
	 * Gets the str shelf time format.
	 * 
	 * @return the str shelf time format
	 */
	public String getStrShelfTimeFormat() {
		return strShelfTimeFormat;
	}

	/**
	 * Sets the str shelf time format.
	 * 
	 * @param strShelfTimeFormat the new str shelf time format
	 */
	public void setStrShelfTimeFormat(String strShelfTimeFormat) {
		this.strShelfTimeFormat = strShelfTimeFormat;
	}

	/**
	 * Gets the str consumable type.
	 * 
	 * @return the str consumable type
	 */
	public String getStrConsumableType() {
		return strConsumableType;
	}

	/**
	 * Sets the str consumable type.
	 * 
	 * @param strConsumableType the new str consumable type
	 */
	public void setStrConsumableType(String strConsumableType) {
		this.strConsumableType = strConsumableType;
	}

	/**
	 * Sets the str current date.
	 * 
	 * @param strCurrentDate the new str current date
	 */
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}

	/**
	 * Gets the str group name value.
	 * 
	 * @return the str group name value
	 */
	public String getStrGroupNameValue() {
		return strGroupNameValue;
	}

	/**
	 * Sets the str group name value.
	 * 
	 * @param strGroupNameValue the new str group name value
	 */
	public void setStrGroupNameValue(String strGroupNameValue) {
		this.strGroupNameValue = strGroupNameValue;
	}

	/**
	 * Gets the str sub group name value.
	 * 
	 * @return the str sub group name value
	 */
	public String getStrSubGroupNameValue() {
		return strSubGroupNameValue;
	}

	/**
	 * Sets the str sub group name value.
	 * 
	 * @param strSubGroupNameValue the new str sub group name value
	 */
	public void setStrSubGroupNameValue(String strSubGroupNameValue) {
		this.strSubGroupNameValue = strSubGroupNameValue;
	}

	/**
	 * Gets the str group id.
	 * 
	 * @return the str group id
	 */
	public String getStrGroupId() {
		return strGroupId;
	}

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupId the new str group id
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * Gets the str sub group id.
	 * 
	 * @return the str sub group id
	 */
	public String getStrSubGroupId() {
		return strSubGroupId;
	}

	/**
	 * Sets the str sub group id.
	 * 
	 * @param strSubGroupId the new str sub group id
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	/**
	 * Gets the str count.
	 * 
	 * @return the str count
	 */
	public String getStrCount() {
		return strCount;
	}

	/**
	 * Sets the str count.
	 * 
	 * @param strCount the new str count
	 */
	public void setStrCount(String strCount) {
		this.strCount = strCount;
	}

	/**
	 * Gets the str stock maintained values.
	 * 
	 * @return the strStockMaintainedValues
	 */
	public String getStrStockMaintainedValues() {
		return strStockMaintainedValues;
	}

	/**
	 * Sets the str stock maintained values.
	 * 
	 * @param strStockMaintainedValues the strStockMaintainedValues to set
	 */
	public void setStrStockMaintainedValues(String strStockMaintainedValues) {
		this.strStockMaintainedValues = strStockMaintainedValues;
	}

	/**
	 * Gets the str stock maintained values modi.
	 * 
	 * @return the strStockMaintainedValuesModi
	 */
	public String getStrStockMaintainedValuesModi() {
		return strStockMaintainedValuesModi;
	}

	/**
	 * Sets the str stock maintained values modi.
	 * 
	 * @param strStockMaintainedValuesModi the strStockMaintainedValuesModi to set
	 */
	public void setStrStockMaintainedValuesModi(
			String strStockMaintainedValuesModi) {
		this.strStockMaintainedValuesModi = strStockMaintainedValuesModi;
	}
	/**
	 * @return the strIsItemNarcotic
	 */

	/**
	 * @return the strDepreciationcost
	 */
	public String getStrDepreciationcost() {
		return strDepreciationcost;
	}

	/**
	 * @param strDepreciationcost the strDepreciationcost to set
	 */
	public void setStrDepreciationcost(String strDepreciationcost) {
		this.strDepreciationcost = strDepreciationcost;
	}

	/**
	 * @return the strAssetsReq
	 */
	public String getStrAssetsReq() {
		return strAssetsReq;
	}

	/**
	 * @param strAssetsReq the strAssetsReq to set
	 */
	public void setStrAssetsReq(String strAssetsReq) {
		this.strAssetsReq = strAssetsReq;
	}

	public String getStrInventoryUnitName() {
		return strInventoryUnitName;
	}

	public void setStrInventoryUnitName(String strInventoryUnitName) {
		this.strInventoryUnitName = strInventoryUnitName;
	}

	/**
	 * @return the strIsItemCodeRequired
	 */
	public String getStrIsItemCodeRequired() {
		return strIsItemCodeRequired;
	}

	/**
	 * @param strIsItemCodeRequired the strIsItemCodeRequired to set
	 */
	public void setStrIsItemCodeRequired(String strIsItemCodeRequired) {
		this.strIsItemCodeRequired = strIsItemCodeRequired;
	}

	/**
	 * @return the strCPACode
	 */
	public String getStrCPACode() {
		return strCPACode;
	}

	/**
	 * @param strCPACode the strCPACode to set
	 */
	public void setStrCPACode(String strCPACode) {
		this.strCPACode = strCPACode;
	}

	/**
	 * @param strConsumableFlag the strConsumableFlag to set
	 */
	public void setStrConsumableFlag(String strConsumableFlag) {
		this.strConsumableFlag = strConsumableFlag;
	}

	/**
	 * @return the strConsumableFlag
	 */
	public String getStrConsumableFlag() {
		return strConsumableFlag;
	}

	public String getStrStockMaintainedCode() {
		return strStockMaintainedCode;
	}

	public void setStrStockMaintainedCode(String strStockMaintainedCode) {
		this.strStockMaintainedCode = strStockMaintainedCode;
	}

}
