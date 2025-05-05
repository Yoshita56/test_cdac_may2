package mms.masters.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericItemMstVO.
 */
public class GenericItemMstVO implements TransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The B exist status. */
	private Boolean BExistStatus = false;

	/** The str msg string. */
	private String strMsgString = "";

	/** The str wrn msg. */
	private String strWrnMsg = "";

	/** The str msg type. */
	private String strMsgType = "0";

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
	// private String strItemType = "";
	// private String strDefaultRate = "";
	/** The str batch no. */
	private String strBatchNo = "";

	/** The str expiry date. */
	private String strExpiryDate = "";

	/** The str purchase lead time. */
	private String strPurchaseLeadTime = "";

	/** The str time format. */
	private String strTimeFormat = "";

	/** The str stock maintain. */
	private String strStockMaintain = "";

	/** The str shelf life. */
	private String strShelfLife = "";

	/** The str shelf time format. */
	private String strShelfTimeFormat = "";
	// private String strApprovedBy = "";
	// private String strIssueType = "";
	/** The str consumable type. */
	private String strConsumableType = "1";
	// private String strIsItemSachet = "0";

	// private String strUnitValues = "";
	/** The str stock maintained values. */
	private String strStockMaintainedValues = "";
	// private String strManufacturerValues = "";
	// private String strItemTypeValues = "";
	// private String strBrandItemSlNo = "";
	/** The str item id. */
	private String strItemId = "";
	// private String strBrandId = "";
	/** The Is flag. */
	private Boolean IsFlag = false;

	/** The str module id. */
	private String strModuleId = "0";

	/** The combo. */
	private String combo[] = null;

	/** The str group name value. */
	private String strGroupNameValue = "";

	/** The str sub group name value. */
	private String strSubGroupNameValue = "";

	/** The combo value. */
	private String comboValue = "";
	// private String strUnit = "";
	/** The str group id. */
	private String strGroupId = "0";

	/** The str sub group id. */
	private String strSubGroupId = "0";
	// private String strUnitCode = "0";
	/** The str stock maintained code. */
	private String strStockMaintainedCode = "";
	// private String strItemTypeCode = "";
	/*
	 * private String strBrandName[] = null; private String
	 * strBrandedManufacturer[] = null; private String strBrandedRate[] = null;
	 * private String strBrandedUnit[] = null; private String
	 * strBrandedApprovedBy[] = null; private String strBrandedIssueType[] =
	 * null; private String strBrandedItemMaker[] = null;
	 */
	// private String strBrandedItemStatus[] = null;
	// private String strBrandItemDtlValues = "";
	/** The str modify. */
	private String strModify[] = null;
	/*
	 * //private String primaryKeyBrandItem[] = null; private String strCount =
	 * ""; private String strItemMaker = ""; private String strItemstatus = "";
	 * private String strManufacturer = "";
	 */
	/** The str item name. */
	private String strItemName = "";

	private String strCPACode = "";

	/** The str cat no. */
	private String strCatNo = "";
	// private String strStockUpdate = "";
	/**
	 * *************************************************************************
	 * WebRow set Declaration Here
	 * ************************************************************************.
	 */
	private WebRowSet unitWS = null;

	/** The item category ws. */
	private WebRowSet itemCategoryWS = null;

	/** The manufacturer ws. */
	private WebRowSet manufacturerWS = null;

	/** The stock maintained ws. */
	private WebRowSet stockMaintainedWS = null;

	/** The item type ws. */
	private WebRowSet itemTypeWS = null;

	/** The brand item dtl ws. */
	private WebRowSet brandItemDtlWS = null;

	/** The check row. */
	private String[] checkRow = null;

	/** The str serial no. */
	private String strSerialNo = null;
	// private String strItemComposit = null;
	/** The str param. */
	private String strParam = null;

	/** The commitee name ws. */
	private WebRowSet commiteeNameWS = null;

	/** The str param check. */
	private String[] strParamCheck = null;

	/** The str param value. */
	private String[] strParamValue = null;

	/** The str param dtls. */
	private String[] strParamDtls = null;

	/** The str param status. */
	private String[] strParamStatus = null;

	/** The str spare part. */
	private String strSparePart = "";

	/** The str cat values. */
	private String strCatValues = "";

	private String strDepreciationcost = "";
	private String strAssetsReq = "0";

	private String strInventoryUnitName = "";

	private String strIsItemCodeRequired = "0";

	/*
	 * Added By Aritra
	 * Its value should be 0 or 1.
	 * 0 => Non Consumable
	 * 1 => Consumable
	 */

	private String strConsumableFlag = null; 


	/**
	 * @return the strIsItemCodeRequired
	 */
	public String getStrIsItemCodeRequired() {
		return strIsItemCodeRequired;
	}

	/**
	 * @param strIsItemCodeRequired
	 *            the strIsItemCodeRequired to set
	 */
	public void setStrIsItemCodeRequired(String strIsItemCodeRequired) {
		this.strIsItemCodeRequired = strIsItemCodeRequired;
	}

	public String getStrInventoryUnitName() {
		return strInventoryUnitName;
	}

	public void setStrInventoryUnitName(String strInventoryUnitName) {
		this.strInventoryUnitName = strInventoryUnitName;
	}

	/**
	 * @return the strDepreciationcost
	 */
	public String getStrDepreciationcost() {
		return strDepreciationcost;
	}

	/**
	 * @param strDepreciationcost
	 *            the strDepreciationcost to set
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
	 * @param strAssetsReq
	 *            the strAssetsReq to set
	 */
	public void setStrAssetsReq(String strAssetsReq) {
		this.strAssetsReq = strAssetsReq;
	}

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
	 * @param strCatValues
	 *            the new str cat values
	 */
	public void setStrCatValues(String strCatValues) {
		this.strCatValues = strCatValues;
	}

	/**
	 * Gets the str spare part.
	 * 
	 * @return the str spare part
	 */
	public String getStrSparePart() {
		return strSparePart;
	}

	/**
	 * Sets the str spare part.
	 * 
	 * @param strSparePart
	 *            the new str spare part
	 */
	public void setStrSparePart(String strSparePart) {
		this.strSparePart = strSparePart;
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
	 * @param strParamDtls
	 *            the new str param dtls
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
	 * @param strParamStatus
	 *            the new str param status
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
	 * @param strParamCheck
	 *            the new str param check
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
	 * @param strParamValue
	 *            the new str param value
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
	 * @param strCatNo
	 *            the new str cat no
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
	 * @param strSerialNo
	 *            the new str serial no
	 */
	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
	}

	/*
	 * public String getStrItemComposit() { return strItemComposit; }
	 * 
	 * public void setStrItemComposit(String strItemComposit) {
	 * this.strItemComposit = strItemComposit; }
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
	 * @param strParam
	 *            the new str param
	 */
	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}

	/**
	 * Gets the unit ws.
	 * 
	 * @return the unit ws
	 */
	public WebRowSet getUnitWS() {
		return unitWS;
	}

	/**
	 * Sets the unit ws.
	 * 
	 * @param unitWS
	 *            the new unit ws
	 */
	public void setUnitWS(WebRowSet unitWS) {
		this.unitWS = unitWS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.utility.TransferObject#getStrMsgString()
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.utility.TransferObject#setStrMsgString(java.lang.String)
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.utility.TransferObject#getStrMsgType()
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.utility.TransferObject#setStrMsgType(java.lang.String)
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
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
	 * @param strHospCode
	 *            the new str hosp code
	 */
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}

	/**
	 * Gets the commitee name ws.
	 * 
	 * @return the commitee name ws
	 */
	public WebRowSet getCommiteeNameWS() {
		return commiteeNameWS;
	}

	/**
	 * Sets the commitee name ws.
	 * 
	 * @param commiteeNameWS
	 *            the new commitee name ws
	 */
	public void setCommiteeNameWS(WebRowSet commiteeNameWS) {
		this.commiteeNameWS = commiteeNameWS;
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
	 * @param strSeatId
	 *            the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
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
	 * @param strRemarks
	 *            the new str remarks
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
	 * @param strEffectiveFrom
	 *            the new str effective from
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
	}

	/**
	 * Gets the str wrn msg.
	 * 
	 * @return the str wrn msg
	 */
	public String getStrWrnMsg() {
		return strWrnMsg;
	}

	/**
	 * Sets the str wrn msg.
	 * 
	 * @param strWrnMsg
	 *            the new str wrn msg
	 */
	public void setStrWrnMsg(String strWrnMsg) {
		this.strWrnMsg = strWrnMsg;
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
	 * @param strChk
	 *            the new str chk
	 */
	public void setStrChk(String strChk) {
		this.strChk = strChk;
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
	 * @param strIsValid
	 *            the new str is valid
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * Gets the checks if is flag.
	 * 
	 * @return the checks if is flag
	 */
	public Boolean getIsFlag() {
		return IsFlag;
	}

	/**
	 * Sets the checks if is flag.
	 * 
	 * @param isFlag
	 *            the new checks if is flag
	 */
	public void setIsFlag(Boolean isFlag) {
		IsFlag = isFlag;
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
	 * @param strBatchNo
	 *            the new str batch no
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
	 * @param strExpiryDate
	 *            the new str expiry date
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
	 * @param strPurchaseLeadTime
	 *            the new str purchase lead time
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
	 * @param strTimeFormat
	 *            the new str time format
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
	 * @param strStockMaintain
	 *            the new str stock maintain
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
	 * @param strShelfLife
	 *            the new str shelf life
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
	 * @param strShelfTimeFormat
	 *            the new str shelf time format
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
	 * @param strConsumableType
	 *            the new str consumable type
	 */
	public void setStrConsumableType(String strConsumableType) {
		this.strConsumableType = strConsumableType;
	}

	/**
	 * Gets the manufacturer ws.
	 * 
	 * @return the manufacturer ws
	 */
	public WebRowSet getManufacturerWS() {
		return manufacturerWS;
	}

	/**
	 * Sets the manufacturer ws.
	 * 
	 * @param manufacturerWS
	 *            the new manufacturer ws
	 */
	public void setManufacturerWS(WebRowSet manufacturerWS) {
		this.manufacturerWS = manufacturerWS;
	}

	/**
	 * Gets the stock maintained ws.
	 * 
	 * @return the stock maintained ws
	 */
	public WebRowSet getStockMaintainedWS() {
		return stockMaintainedWS;
	}

	/**
	 * Sets the stock maintained ws.
	 * 
	 * @param stockMaintainedWS
	 *            the new stock maintained ws
	 */
	public void setStockMaintainedWS(WebRowSet stockMaintainedWS) {
		this.stockMaintainedWS = stockMaintainedWS;
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
	 * @param strModuleId
	 *            the new str module id
	 */
	public void setStrModuleId(String strModuleId) {
		this.strModuleId = strModuleId;
	}

	/**
	 * Gets the item type ws.
	 * 
	 * @return the item type ws
	 */
	public WebRowSet getItemTypeWS() {
		return itemTypeWS;
	}

	/**
	 * Sets the item type ws.
	 * 
	 * @param itemTypeWS
	 *            the new item type ws
	 */
	public void setItemTypeWS(WebRowSet itemTypeWS) {
		this.itemTypeWS = itemTypeWS;
	}

	/**
	 * Gets the combo.
	 * 
	 * @return the combo
	 */
	public String[] getCombo() {
		return combo;
	}

	/**
	 * Sets the combo.
	 * 
	 * @param combo
	 *            the new combo
	 */
	public void setCombo(String[] combo) {
		this.combo = combo;
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
	 * @param strGroupNameValue
	 *            the new str group name value
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
	 * @param strSubGroupNameValue
	 *            the new str sub group name value
	 */
	public void setStrSubGroupNameValue(String strSubGroupNameValue) {
		this.strSubGroupNameValue = strSubGroupNameValue;
	}

	/**
	 * Gets the combo value.
	 * 
	 * @return the combo value
	 */
	public String getComboValue() {
		return comboValue;
	}

	/**
	 * Sets the combo value.
	 * 
	 * @param comboValue
	 *            the new combo value
	 */
	public void setComboValue(String comboValue) {
		this.comboValue = comboValue;
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
	 * @param strGroupId
	 *            the new str group id
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
	 * @param strSubGroupId
	 *            the new str sub group id
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	/**
	 * Gets the brand item dtl ws.
	 * 
	 * @return the brand item dtl ws
	 */
	public WebRowSet getBrandItemDtlWS() {
		return brandItemDtlWS;
	}

	/**
	 * Sets the brand item dtl ws.
	 * 
	 * @param brandItemDtlWS
	 *            the new brand item dtl ws
	 */
	public void setBrandItemDtlWS(WebRowSet brandItemDtlWS) {
		this.brandItemDtlWS = brandItemDtlWS;
	}

	/**
	 * Gets the str modify.
	 * 
	 * @return the str modify
	 */
	public String[] getStrModify() {
		return strModify;
	}

	/**
	 * Sets the str modify.
	 * 
	 * @param strModify
	 *            the new str modify
	 */
	public void setStrModify(String[] strModify) {
		this.strModify = strModify;
	}

	/**
	 * Gets the str item id.
	 * 
	 * @return the str item id
	 */
	public String getStrItemId() {
		return strItemId;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemId
	 *            the new str item id
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
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
	 * @param strItemName
	 *            the new str item name
	 */
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
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
	 * @param checkRow
	 *            the new check row
	 */
	public void setCheckRow(String[] checkRow) {
		this.checkRow = checkRow;
	}

	/**
	 * Gets the item category ws.
	 * 
	 * @return the itemCategoryWS
	 */
	public WebRowSet getItemCategoryWS() {
		return itemCategoryWS;
	}

	/**
	 * Sets the item category ws.
	 * 
	 * @param itemCategoryWS
	 *            the itemCategoryWS to set
	 */
	public void setItemCategoryWS(WebRowSet itemCategoryWS) {
		this.itemCategoryWS = itemCategoryWS;
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
	 * @param strStockMaintainedValues
	 *            the strStockMaintainedValues to set
	 */
	public void setStrStockMaintainedValues(String strStockMaintainedValues) {
		this.strStockMaintainedValues = strStockMaintainedValues;
	}

	/**
	 * Gets the str stock maintained code.
	 * 
	 * @return the strStockMaintainedCode
	 */
	public String getStrStockMaintainedCode() {
		return strStockMaintainedCode;
	}

	/**
	 * Sets the str stock maintained code.
	 * 
	 * @param strStockMaintainedCode
	 *            the strStockMaintainedCode to set
	 */
	public void setStrStockMaintainedCode(String strStockMaintainedCode) {
		this.strStockMaintainedCode = strStockMaintainedCode;
	}

	/**
	 * Gets the b exist status.
	 * 
	 * @return the bExistStatus
	 */
	public Boolean getBExistStatus() {
		return BExistStatus;
	}

	/**
	 * Sets the b exist status.
	 * 
	 * @param existStatus
	 *            the bExistStatus to set
	 */
	public void setBExistStatus(Boolean existStatus) {
		BExistStatus = existStatus;
	}

	/**
	 * @return the strCPACode
	 */
	public String getStrCPACode() {
		return strCPACode;
	}

	/**
	 * @param strCPACode
	 *            the strCPACode to set
	 */
	public void setStrCPACode(String strCPACode) {
		this.strCPACode = strCPACode;
	}

	/**
	 * @param strConsumableFlag
	 *            the strConsumableFlag to set
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

}
