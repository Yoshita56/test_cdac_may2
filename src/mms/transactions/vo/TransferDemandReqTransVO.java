/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferDemandReqTransVO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class TransferDemandReqTransVO.
 */
public class TransferDemandReqTransVO {

	/** The B exist status. */
	private Boolean bExistStatus = false;

	/** The str msg string. */
	private String strMsgString = "";

	/** The str msg type. */
	private String strMsgType = "";

	/** The str ct date. */
	private String strCtDate = "";

	/** The str effective from. */
	private String strEffectiveFrom = "";

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str modify value. */
	private String strModifyValue = "0";

	/** The str bill no. */
	private String strBillNo = "";

	/** The str bill date. */
	private String strBillDate = "";

	/** The str remarks. */
	private String strRemarks = "";

	/** The str order number. */
	private String strOrderNumber = "";

	/** The str manufacture id. */
	private String strManufactureId = "";

	/** The str manufacture name. */
	private String strManufactureName = "";

	/** The str manufacture combo. */
	private String strManufactureCombo = "";

	/** The str manufacture combo ws. */
	private WebRowSet strManufactureComboWS = null;

	/** The Wb transfer order detail. */
	private WebRowSet WbTransferOrderDetail = null;

	/** The str supplied by. */
	private String strSuppliedBy = "0";

	/** The str demanded qty. */
	private String strDemandedQty = "";

	/** The str approved by id. */
	private String strApprovedById = "";

	/** The str approved by. */
	private String strApprovedBy = "";

	/** The str req status. */
	private String strReqStatus = "";

	/** The str request no. */
	private String strRequestNo = "";

	/** The str chk. */
	private String strChk = "";

	/** The str item brand combo ws. */
	private WebRowSet strItemBrandComboWS = null;

	/** The str item brand combo. */
	private String strItemBrandCombo = "";

	/** The str item brand name. */
	private String strItemBrandName = "";

	/** The str item brand id. */
	private String strItemBrandId = "";

	/** The str item name combo. */
	private String strItemNameCombo = "";

	/** The str item name combo ws. */
	private WebRowSet strItemNameComboWS = null;

	/** The approved by combo ws. */
	private WebRowSet approvedByComboWS = null;

	/** The str item name. */
	private String strItemName = "";

	/** The str item id. */
	private String strItemId = "";

	/** The str approved by combo. */
	private String strApprovedByCombo = "";

	/** The str approved date. */
	private String strApprovedDate = "";

	/** The str in hand quantity. */
	private String strInHandQuantity = "";

	/** The str in hand quantity unit id. */
	private String strInHandQuantityUnitID = "";

	/** The str in hand quantity unit name. */
	private String strInHandQuantityUnitName = "";

	/** The str batch no. */
	private String strBatchNo;

	/** The str expiry date. */
	private String strExpiryDate = "";

	/** The str manufacture date. */
	private String strManufactureDate = "";

	/** The str rate. */
	private String strRate = "";

	/** The str sale price. */
	private String strSalePrice = "";

	/** The str currency code. */
	private String strCurrencyCode = "0";

	/** The str currency code ws. */
	private WebRowSet strCurrencyCodeWs = null;

	/** The str currency value. */
	private String strCurrencyValue = "0";

	/** The str po no. */
	private String strPoNo = "";

	/** The str po date. */
	private String strPoDate = "";

	/** The str received date. */
	private String strReceivedDate = "";

	/** The str stock status. */
	private String strStockStatus = "";

	/** The str old stock status. */
	private String strOldStockStatus = "";

	/** The str stock status ws. */
	private WebRowSet strStockStatusWs = null;

	/** The str module id. */
	private String strModuleId = "0";

	/** The str consumable_flag. */
	private String strConsumable_flag = "";

	/** The str unit name combo ws. */
	private WebRowSet strUnitNameComboWS = null;

	/** The str existing batch combo ws. */
	private WebRowSet strExistingBatchComboWS = null;

	/** The str unit name combo. */
	private String strUnitNameCombo = "";

	/** The str store id. */
	private String strStoreId = "";

	/** The str store name. */
	private String strStoreName = "";

	/** The str group id. */
	private String strGroupId = "0";

	/** The str group name. */
	private String strGroupName = "";

	/** The str sub group id. */
	private String strSubGroupId = "0";

	/** The str sub group combo. */
	private String strSubGroupCombo = "";

	/** The str sub group combo ws. */
	private WebRowSet strSubGroupComboWs = null;

	/** The str sub group code. */
	private String strSubGroupCode = "";

	/** The str sub group name. */
	private String strSubGroupName = "";

	/** The str item category no. */
	private String strItemCategoryNo = "10";

	/** The str item specification. */
	private String strItemSpecification = "";

	/** The str reg flag. */
	private String strRegFlag = "";

	/** The str brand details. */
	private String strBrandDetails = "";

	/** The str free item flag. */
	private String strFreeItemFlag;

	/** The str free item quantity. */
	private String strFreeItemQuantity = "0";

	/** The str free item quantity unit id. */
	private String strFreeItemQuantityUnitID = "0";

	/** The str config issue rate. */
	private String strConfigIssueRate;

	/** The str issue rate config flg. */
	private String strIssueRateConfigFlg;

	/** The str rack number. */
	private String strRackNumber;

	/** The str existing batch id. */
	private String strExistingBatchId;

	/** The str existing batch combo. */
	private String strExistingBatchCombo;

	/** The str group name combo. */
	private String strGroupNameCombo;

	/** The str group cmb id. */
	private String strGroupCmbId;

	/** The str batch exist in stock flg. */
	private String strBatchExistInStockFlg;

	/** The str qc type flg. */
	private String strQcTypeFlg;

	/** The str drug tot cost. */
	private String strDrugTotCost;

	/** The str item brand id value. */
	private String strItemBrandIdValue;

	/** The str active qty. */
	private String strActiveQty;

	/** The str in active qty. */
	private String strInActiveQty;

	/** The str quarantine qty. */
	private String strQuarantineQty;

	/** The str approved by ws. */
	private WebRowSet strApprovedByWs = null;

	/** The str mode. */
	private String strMode;

	/** The str modify dtl ws. */
	private WebRowSet strModifyDtlWS = null;

	/** The str cancel reson. */
	private String strCancelReson = "";

	/** The str time period. */
	private String strTimePeriod = "";

	/** The str time period combo. */
	private String strTimePeriodCombo = "";

	/** The str hid item value. */
	private String[] strHiddenValue = null;

	/** The str serial no. */
	private String strSerialNo = "";

	/** The str online app status. */
	private String strOnlineAppStatus = "";

	/** The str req date. */
	private String strReqDate = "";
	
	private String strOrderSlNo = "";

	public String getStrOrderSlNo() {
		return strOrderSlNo;
	}

	public void setStrOrderSlNo(String strOrderSlNo) {
		this.strOrderSlNo = strOrderSlNo;
	}

	/**
	 * Gets the str time period.
	 * 
	 * @return the strTimePeriod
	 */
	public String getStrTimePeriod() {
		return strTimePeriod;
	}

	/**
	 * Sets the str time period.
	 * 
	 * @param strTimePeriod the strTimePeriod to set
	 */
	public void setStrTimePeriod(String strTimePeriod) {
		this.strTimePeriod = strTimePeriod;
	}

	/**
	 * Gets the str time period combo.
	 * 
	 * @return the strTimePeriodCombo
	 */
	public String getStrTimePeriodCombo() {
		return strTimePeriodCombo;
	}

	/**
	 * Sets the str time period combo.
	 * 
	 * @param strTimePeriodCombo the strTimePeriodCombo to set
	 */
	public void setStrTimePeriodCombo(String strTimePeriodCombo) {
		this.strTimePeriodCombo = strTimePeriodCombo;
	}

	/**
	 * Gets the str cancel reson.
	 * 
	 * @return the str cancel reson
	 */
	public String getStrCancelReson() {
		return strCancelReson;
	}

	/**
	 * Sets the str cancel reson.
	 * 
	 * @param strCancelReson the new str cancel reson
	 */
	public void setStrCancelReson(String strCancelReson) {
		this.strCancelReson = strCancelReson;
	}

	/**
	 * Gets the str mode.
	 * 
	 * @return the str mode
	 */
	public String getStrMode() {
		return strMode;
	}

	/**
	 * Sets the str mode.
	 * 
	 * @param strMode the new str mode
	 */
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

	/**
	 * Gets the str item brand id value.
	 * 
	 * @return the str item brand id value
	 */
	public String getStrItemBrandIdValue() {
		return strItemBrandIdValue;
	}

	/**
	 * Sets the str item brand id value.
	 * 
	 * @param strItemBrandIdValue the new str item brand id value
	 */
	public void setStrItemBrandIdValue(String strItemBrandIdValue) {
		this.strItemBrandIdValue = strItemBrandIdValue;
	}

	/**
	 * Gets the str drug tot cost.
	 * 
	 * @return the str drug tot cost
	 */
	public String getStrDrugTotCost() {
		return strDrugTotCost;
	}

	/**
	 * Sets the str drug tot cost.
	 * 
	 * @param strDrugTotCost the new str drug tot cost
	 */
	public void setStrDrugTotCost(String strDrugTotCost) {
		this.strDrugTotCost = strDrugTotCost;
	}

	/**
	 * Gets the str qc type flg.
	 * 
	 * @return the str qc type flg
	 */
	public String getStrQcTypeFlg() {
		return strQcTypeFlg;
	}

	/**
	 * Sets the str qc type flg.
	 * 
	 * @param strQcTypeFlg the new str qc type flg
	 */
	public void setStrQcTypeFlg(String strQcTypeFlg) {
		this.strQcTypeFlg = strQcTypeFlg;
	}

	/**
	 * Gets the str group cmb id.
	 * 
	 * @return the str group cmb id
	 */
	public String getStrGroupCmbId() {
		return strGroupCmbId;
	}

	/**
	 * Sets the str group cmb id.
	 * 
	 * @param strGroupCmbId the new str group cmb id
	 */
	public void setStrGroupCmbId(String strGroupCmbId) {
		this.strGroupCmbId = strGroupCmbId;
	}

	/**
	 * Gets the str existing batch id.
	 * 
	 * @return the str existing batch id
	 */
	public String getStrExistingBatchId() {
		return strExistingBatchId;
	}

	/**
	 * Sets the str existing batch id.
	 * 
	 * @param strExistingBatchId the new str existing batch id
	 */
	public void setStrExistingBatchId(String strExistingBatchId) {
		this.strExistingBatchId = strExistingBatchId;
	}

	/**
	 * Gets the str existing batch combo.
	 * 
	 * @return the str existing batch combo
	 */
	public String getStrExistingBatchCombo() {
		return strExistingBatchCombo;
	}

	/**
	 * Sets the str existing batch combo.
	 * 
	 * @param strExistingBatchCombo the new str existing batch combo
	 */
	public void setStrExistingBatchCombo(String strExistingBatchCombo) {
		this.strExistingBatchCombo = strExistingBatchCombo;
	}

	/**
	 * Gets the str rack number.
	 * 
	 * @return the str rack number
	 */
	public String getStrRackNumber() {
		return strRackNumber;
	}

	/**
	 * Sets the str rack number.
	 * 
	 * @param strRackNumber the new str rack number
	 */
	public void setStrRackNumber(String strRackNumber) {
		this.strRackNumber = strRackNumber;
	}

	/**
	 * Gets the str issue rate config flg.
	 * 
	 * @return the str issue rate config flg
	 */
	public String getStrIssueRateConfigFlg() {
		return strIssueRateConfigFlg;
	}

	/**
	 * Sets the str issue rate config flg.
	 * 
	 * @param strIssueRateConfigFlg the new str issue rate config flg
	 */
	public void setStrIssueRateConfigFlg(String strIssueRateConfigFlg) {
		this.strIssueRateConfigFlg = strIssueRateConfigFlg;
	}

	/**
	 * Gets the str config issue rate.
	 * 
	 * @return the str config issue rate
	 */
	public String getStrConfigIssueRate() {
		return strConfigIssueRate;
	}

	/**
	 * Sets the str config issue rate.
	 * 
	 * @param strConfigIssueRate the new str config issue rate
	 */
	public void setStrConfigIssueRate(String strConfigIssueRate) {
		this.strConfigIssueRate = strConfigIssueRate;
	}

	/**
	 * Gets the str free item quantity.
	 * 
	 * @return the str free item quantity
	 */
	public String getStrFreeItemQuantity() {
		return strFreeItemQuantity;
	}

	/**
	 * Sets the str free item quantity.
	 * 
	 * @param strFreeItemQuantity the new str free item quantity
	 */
	public void setStrFreeItemQuantity(String strFreeItemQuantity) {
		this.strFreeItemQuantity = strFreeItemQuantity;
	}

	/**
	 * Gets the str free item quantity unit id.
	 * 
	 * @return the str free item quantity unit id
	 */
	public String getStrFreeItemQuantityUnitID() {
		return strFreeItemQuantityUnitID;
	}

	/**
	 * Sets the str free item quantity unit id.
	 * 
	 * @param strFreeItemQuantityUnitID the new str free item quantity unit id
	 */
	public void setStrFreeItemQuantityUnitID(String strFreeItemQuantityUnitID) {
		this.strFreeItemQuantityUnitID = strFreeItemQuantityUnitID;
	}

	/**
	 * Gets the str free item flag.
	 * 
	 * @return the str free item flag
	 */
	public String getStrFreeItemFlag() {
		return strFreeItemFlag;
	}

	/**
	 * Sets the str free item flag.
	 * 
	 * @param strFreeItemFlag the new str free item flag
	 */
	public void setStrFreeItemFlag(String strFreeItemFlag) {
		this.strFreeItemFlag = strFreeItemFlag;
	}

	/**
	 * Gets the str brand details.
	 * 
	 * @return the str brand details
	 */
	public String getStrBrandDetails() {
		return strBrandDetails;
	}

	/**
	 * Sets the str brand details.
	 * 
	 * @param strBrandDetails the new str brand details
	 */
	public void setStrBrandDetails(String strBrandDetails) {
		this.strBrandDetails = strBrandDetails;
	}

	/**
	 * Gets the str item specification.
	 * 
	 * @return the str item specification
	 */
	public String getStrItemSpecification() {
		return strItemSpecification;
	}

	/**
	 * Sets the str item specification.
	 * 
	 * @param strItemSpecification the new str item specification
	 */
	public void setStrItemSpecification(String strItemSpecification) {
		this.strItemSpecification = strItemSpecification;
	}

	/**
	 * Gets the str old stock status.
	 * 
	 * @return the str old stock status
	 */
	public String getStrOldStockStatus() {
		return strOldStockStatus;
	}

	/**
	 * Sets the str old stock status.
	 * 
	 * @param strOldStockStatus the new str old stock status
	 */
	public void setStrOldStockStatus(String strOldStockStatus) {
		this.strOldStockStatus = strOldStockStatus;
	}

	/**
	 * Gets the str item category no.
	 * 
	 * @return the str item category no
	 */
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}

	/**
	 * Sets the str item category no.
	 * 
	 * @param strItemCategoryNo the new str item category no
	 */
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}

	/** The str unit rate id. */
	private String strUnitRateID = "";

	/** The str unit rate name. */
	private String strUnitRateName = "";

	/** The str unit rate combo. */
	private String strUnitRateCombo = "";

	/** The str unit rate combo ws. */
	private WebRowSet strUnitRateComboWS = null;

	/** The str unit sale id. */
	private String strUnitSaleID = "";

	/** The str unit name sale. */
	private String strUnitNameSale = "";

	/** The str unit sale combo. */
	private String strUnitSaleCombo = "";

	/** The str unit sale combo ws. */
	private WebRowSet strUnitSaleComboWS = null;

	/** The str item other dtls. */
	private String[] strItemOtherDtls = null;

	/**
	 * Gets the str item other dtls.
	 * 
	 * @return the str item other dtls
	 */
	public String[] getStrItemOtherDtls() {
		return strItemOtherDtls;
	}

	/**
	 * Sets the str item other dtls.
	 * 
	 * @param strItemOtherDtls the new str item other dtls
	 */
	public void setStrItemOtherDtls(String[] strItemOtherDtls) {
		this.strItemOtherDtls = strItemOtherDtls;
	}

	/**
	 * Gets the str currency code.
	 * 
	 * @return the str currency code
	 */
	public String getStrCurrencyCode() {
		return strCurrencyCode;
	}

	/**
	 * Sets the str currency code.
	 * 
	 * @param strCurrencyCode the new str currency code
	 */
	public void setStrCurrencyCode(String strCurrencyCode) {
		this.strCurrencyCode = strCurrencyCode;
	}

	/**
	 * Gets the str currency code ws.
	 * 
	 * @return the str currency code ws
	 */
	public WebRowSet getStrCurrencyCodeWs() {
		return strCurrencyCodeWs;
	}

	/**
	 * Sets the str currency code ws.
	 * 
	 * @param strCurrencyCodeWs the new str currency code ws
	 */
	public void setStrCurrencyCodeWs(WebRowSet strCurrencyCodeWs) {
		this.strCurrencyCodeWs = strCurrencyCodeWs;
	}

	/**
	 * Gets the str currency value.
	 * 
	 * @return the str currency value
	 */
	public String getStrCurrencyValue() {
		return strCurrencyValue;
	}

	/**
	 * Sets the str currency value.
	 * 
	 * @param strCurrencyValue the new str currency value
	 */
	public void setStrCurrencyValue(String strCurrencyValue) {
		this.strCurrencyValue = strCurrencyValue;
	}

	/**
	 * Gets the str stock status ws.
	 * 
	 * @return the str stock status ws
	 */
	public WebRowSet getStrStockStatusWs() {
		return strStockStatusWs;
	}

	/**
	 * Sets the str stock status ws.
	 * 
	 * @param strStockStatusWs the new str stock status ws
	 */
	public void setStrStockStatusWs(WebRowSet strStockStatusWs) {
		this.strStockStatusWs = strStockStatusWs;
	}

	/**
	 * Gets the str stock status.
	 * 
	 * @return the str stock status
	 */
	public String getStrStockStatus() {
		return strStockStatus;
	}

	/**
	 * Sets the str stock status.
	 * 
	 * @param strStockStatus the new str stock status
	 */
	public void setStrStockStatus(String strStockStatus) {
		this.strStockStatus = strStockStatus;
	}

	/**
	 * Gets the str po date.
	 * 
	 * @return the str po date
	 */
	public String getStrPoDate() {
		return strPoDate;
	}

	/**
	 * Sets the str po date.
	 * 
	 * @param strPoDate the new str po date
	 */
	public void setStrPoDate(String strPoDate) {
		this.strPoDate = strPoDate;
	}

	/**
	 * Gets the str received date.
	 * 
	 * @return the str received date
	 */
	public String getStrReceivedDate() {
		return strReceivedDate;
	}

	/**
	 * Sets the str received date.
	 * 
	 * @param strReceivedDate the new str received date
	 */
	public void setStrReceivedDate(String strReceivedDate) {
		this.strReceivedDate = strReceivedDate;
	}

	/**
	 * Gets the str supplied by.
	 * 
	 * @return the str supplied by
	 */
	public String getStrSuppliedBy() {
		return strSuppliedBy;
	}

	/**
	 * Sets the str supplied by.
	 * 
	 * @param strSuppliedBy the new str supplied by
	 */
	public void setStrSuppliedBy(String strSuppliedBy) {
		this.strSuppliedBy = strSuppliedBy;
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
	 * Gets the str consumable_flag.
	 * 
	 * @return the strConsumable_flag
	 */
	public String getStrConsumable_flag() {
		return strConsumable_flag;
	}

	/**
	 * Sets the str consumable_flag.
	 * 
	 * @param strConsumable_flag the strConsumable_flag to set
	 */
	public void setStrConsumable_flag(String strConsumable_flag) {
		this.strConsumable_flag = strConsumable_flag;
	}

	/**
	 * Gets the str msg string.
	 * 
	 * @return the strMsgString
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/**
	 * Sets the str msg string.
	 * 
	 * @param strMsgString the strMsgString to set
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/**
	 * Gets the str msg type.
	 * 
	 * @return the strMsgType
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/**
	 * Sets the str msg type.
	 * 
	 * @param strMsgType the strMsgType to set
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	/**
	 * Gets the str sub group combo.
	 * 
	 * @return the strSubGroupCombo
	 */
	public String getStrSubGroupCombo() {
		return strSubGroupCombo;
	}

	/**
	 * Sets the str sub group combo.
	 * 
	 * @param strSubGroupCombo the strSubGroupCombo to set
	 */
	public void setStrSubGroupCombo(String strSubGroupCombo) {
		this.strSubGroupCombo = strSubGroupCombo;
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
	 * Gets the b exist status.
	 * 
	 * @return the bExistStatus
	 */
	public Boolean getBExistStatus() {
		return bExistStatus;
	}

	/**
	 * Sets the b exist status.
	 * 
	 * @param existStatus the bExistStatus to set
	 */
	public void setBExistStatus(Boolean existStatus) {
		bExistStatus = existStatus;
	}

	/**
	 * Gets the str sub group combo ws.
	 * 
	 * @return the strSubGroupComboWs
	 */
	public WebRowSet getStrSubGroupComboWs() {
		return strSubGroupComboWs;
	}

	/**
	 * Sets the str sub group combo ws.
	 * 
	 * @param strSubGroupComboWs the strSubGroupComboWs to set
	 */
	public void setStrSubGroupComboWs(WebRowSet strSubGroupComboWs) {
		this.strSubGroupComboWs = strSubGroupComboWs;
	}

	/**
	 * Gets the str sub group code.
	 * 
	 * @return the strSubGroupCode
	 */
	public String getStrSubGroupCode() {
		return strSubGroupCode;
	}

	/**
	 * Sets the str sub group code.
	 * 
	 * @param strSubGroupCode the strSubGroupCode to set
	 */
	public void setStrSubGroupCode(String strSubGroupCode) {
		this.strSubGroupCode = strSubGroupCode;
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
	 * Gets the str store id.
	 * 
	 * @return the str store id
	 */
	public String getStrStoreId() {
		return strStoreId;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId the new str store id
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Gets the str store name.
	 * 
	 * @return the str store name
	 */
	public String getStrStoreName() {
		return strStoreName;
	}

	/**
	 * Sets the str store name.
	 * 
	 * @param strStoreName the new str store name
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
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
	 * Gets the str item name combo.
	 * 
	 * @return the str item name combo
	 */
	public String getStrItemNameCombo() {
		return strItemNameCombo;
	}

	/**
	 * Sets the str item name combo.
	 * 
	 * @param strItemNameCombo the new str item name combo
	 */
	public void setStrItemNameCombo(String strItemNameCombo) {
		this.strItemNameCombo = strItemNameCombo;
	}

	/**
	 * Gets the str item name combo ws.
	 * 
	 * @return the str item name combo ws
	 */
	public WebRowSet getStrItemNameComboWS() {
		return strItemNameComboWS;
	}

	/**
	 * Sets the str item name combo ws.
	 * 
	 * @param strItemNameComboWS the new str item name combo ws
	 */
	public void setStrItemNameComboWS(WebRowSet strItemNameComboWS) {
		this.strItemNameComboWS = strItemNameComboWS;
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
	 * @param strItemId the new str item id
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * Gets the str item brand combo ws.
	 * 
	 * @return the str item brand combo ws
	 */
	public WebRowSet getStrItemBrandComboWS() {
		return strItemBrandComboWS;
	}

	/**
	 * Sets the str item brand combo ws.
	 * 
	 * @param strItemBrandComboWS the new str item brand combo ws
	 */
	public void setStrItemBrandComboWS(WebRowSet strItemBrandComboWS) {
		this.strItemBrandComboWS = strItemBrandComboWS;
	}

	/**
	 * Gets the str item brand combo.
	 * 
	 * @return the str item brand combo
	 */
	public String getStrItemBrandCombo() {
		return strItemBrandCombo;
	}

	/**
	 * Sets the str item brand combo.
	 * 
	 * @param strItemBrandCombo the new str item brand combo
	 */
	public void setStrItemBrandCombo(String strItemBrandCombo) {
		this.strItemBrandCombo = strItemBrandCombo;
	}

	/**
	 * Gets the str item brand name.
	 * 
	 * @return the str item brand name
	 */
	public String getStrItemBrandName() {
		return strItemBrandName;
	}

	/**
	 * Sets the str item brand name.
	 * 
	 * @param strItemBrandName the new str item brand name
	 */
	public void setStrItemBrandName(String strItemBrandName) {
		this.strItemBrandName = strItemBrandName;
	}

	/**
	 * Gets the str item brand id.
	 * 
	 * @return the str item brand id
	 */
	public String getStrItemBrandId() {
		return strItemBrandId;
	}

	/**
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandId the new str item brand id
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
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
	 * Gets the str manufacture date.
	 * 
	 * @return the str manufacture date
	 */
	public String getStrManufactureDate() {
		return strManufactureDate;
	}

	/**
	 * Sets the str manufacture date.
	 * 
	 * @param strManufactureDate the new str manufacture date
	 */
	public void setStrManufactureDate(String strManufactureDate) {
		this.strManufactureDate = strManufactureDate;
	}

	/**
	 * Gets the str rate.
	 * 
	 * @return the strRate
	 */
	public String getStrRate() {
		return strRate;
	}

	/**
	 * Sets the str rate.
	 * 
	 * @param strRate the strRate to set
	 */
	public void setStrRate(String strRate) {
		this.strRate = strRate;
	}

	/**
	 * Gets the str po no.
	 * 
	 * @return the str po no
	 */
	public String getStrPoNo() {
		return strPoNo;
	}

	/**
	 * Sets the str po no.
	 * 
	 * @param strPoNo the new str po no
	 */
	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
	}

	/**
	 * Gets the str sale price.
	 * 
	 * @return the strSalePrice
	 */
	public String getStrSalePrice() {
		return strSalePrice;
	}

	/**
	 * Sets the str sale price.
	 * 
	 * @param strSalePrice the strSalePrice to set
	 */
	public void setStrSalePrice(String strSalePrice) {
		this.strSalePrice = strSalePrice;
	}

	/**
	 * Gets the str manufacture id.
	 * 
	 * @return the str manufacture id
	 */
	public String getStrManufactureId() {
		return strManufactureId;
	}

	/**
	 * Sets the str manufacture id.
	 * 
	 * @param strManufactureId the new str manufacture id
	 */
	public void setStrManufactureId(String strManufactureId) {
		this.strManufactureId = strManufactureId;
	}

	/**
	 * Gets the str manufacture name.
	 * 
	 * @return the str manufacture name
	 */
	public String getStrManufactureName() {
		return strManufactureName;
	}

	/**
	 * Sets the str manufacture name.
	 * 
	 * @param strManufactureName the new str manufacture name
	 */
	public void setStrManufactureName(String strManufactureName) {
		this.strManufactureName = strManufactureName;
	}

	/**
	 * Gets the str manufacture combo.
	 * 
	 * @return the str manufacture combo
	 */
	public String getStrManufactureCombo() {
		return strManufactureCombo;
	}

	/**
	 * Sets the str manufacture combo.
	 * 
	 * @param strManufactureCombo the new str manufacture combo
	 */
	public void setStrManufactureCombo(String strManufactureCombo) {
		this.strManufactureCombo = strManufactureCombo;
	}

	/**
	 * Gets the str manufacture combo ws.
	 * 
	 * @return the str manufacture combo ws
	 */
	public WebRowSet getStrManufactureComboWS() {
		return strManufactureComboWS;
	}

	/**
	 * Sets the str manufacture combo ws.
	 * 
	 * @param strManufactureComboWS the new str manufacture combo ws
	 */
	public void setStrManufactureComboWS(WebRowSet strManufactureComboWS) {
		this.strManufactureComboWS = strManufactureComboWS;
	}

	/**
	 * Gets the str unit name combo ws.
	 * 
	 * @return the str unit name combo ws
	 */
	public WebRowSet getStrUnitNameComboWS() {
		return strUnitNameComboWS;
	}

	/**
	 * Sets the str unit name combo ws.
	 * 
	 * @param strUnitNameComboWS the new str unit name combo ws
	 */
	public void setStrUnitNameComboWS(WebRowSet strUnitNameComboWS) {
		this.strUnitNameComboWS = strUnitNameComboWS;
	}

	/**
	 * Gets the str unit name combo.
	 * 
	 * @return the str unit name combo
	 */
	public String getStrUnitNameCombo() {
		return strUnitNameCombo;
	}

	/**
	 * Sets the str unit name combo.
	 * 
	 * @param strUnitNameCombo the new str unit name combo
	 */
	public void setStrUnitNameCombo(String strUnitNameCombo) {
		this.strUnitNameCombo = strUnitNameCombo;
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
	 * Gets the str in hand quantity.
	 * 
	 * @return the strInHandQuantity
	 */
	public String getStrInHandQuantity() {
		return strInHandQuantity;
	}

	/**
	 * Sets the str in hand quantity.
	 * 
	 * @param strInHandQuantity the strInHandQuantity to set
	 */
	public void setStrInHandQuantity(String strInHandQuantity) {
		this.strInHandQuantity = strInHandQuantity;
	}

	/**
	 * Gets the str in hand quantity unit id.
	 * 
	 * @return the strInHandQuantityUnitID
	 */
	public String getStrInHandQuantityUnitID() {
		return strInHandQuantityUnitID;
	}

	/**
	 * Sets the str in hand quantity unit id.
	 * 
	 * @param strInHandQuantityUnitID the strInHandQuantityUnitID to set
	 */
	public void setStrInHandQuantityUnitID(String strInHandQuantityUnitID) {
		this.strInHandQuantityUnitID = strInHandQuantityUnitID;
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
	 * Gets the str unit rate id.
	 * 
	 * @return the strUnitRateID
	 */
	public String getStrUnitRateID() {
		return strUnitRateID;
	}

	/**
	 * Sets the str unit rate id.
	 * 
	 * @param strUnitRateID the strUnitRateID to set
	 */
	public void setStrUnitRateID(String strUnitRateID) {
		this.strUnitRateID = strUnitRateID;
	}

	/**
	 * Gets the str unit rate name.
	 * 
	 * @return the strUnitRateName
	 */
	public String getStrUnitRateName() {
		return strUnitRateName;
	}

	/**
	 * Sets the str unit rate name.
	 * 
	 * @param strUnitRateName the strUnitRateName to set
	 */
	public void setStrUnitRateName(String strUnitRateName) {
		this.strUnitRateName = strUnitRateName;
	}

	/**
	 * Gets the str unit rate combo.
	 * 
	 * @return the strUnitRateCombo
	 */
	public String getStrUnitRateCombo() {
		return strUnitRateCombo;
	}

	/**
	 * Sets the str unit rate combo.
	 * 
	 * @param strUnitRateCombo the strUnitRateCombo to set
	 */
	public void setStrUnitRateCombo(String strUnitRateCombo) {
		this.strUnitRateCombo = strUnitRateCombo;
	}

	/**
	 * Gets the str unit rate combo ws.
	 * 
	 * @return the strUnitRateComboWS
	 */
	public WebRowSet getStrUnitRateComboWS() {
		return strUnitRateComboWS;
	}

	/**
	 * Sets the str unit rate combo ws.
	 * 
	 * @param strUnitRateComboWS the strUnitRateComboWS to set
	 */
	public void setStrUnitRateComboWS(WebRowSet strUnitRateComboWS) {
		this.strUnitRateComboWS = strUnitRateComboWS;
	}

	/**
	 * Gets the str unit sale id.
	 * 
	 * @return the strUnitSaleID
	 */
	public String getStrUnitSaleID() {
		return strUnitSaleID;
	}

	/**
	 * Sets the str unit sale id.
	 * 
	 * @param strUnitSaleID the strUnitSaleID to set
	 */
	public void setStrUnitSaleID(String strUnitSaleID) {
		this.strUnitSaleID = strUnitSaleID;
	}

	/**
	 * Gets the str unit name sale.
	 * 
	 * @return the strUnitNameSale
	 */
	public String getStrUnitNameSale() {
		return strUnitNameSale;
	}

	/**
	 * Sets the str unit name sale.
	 * 
	 * @param strUnitNameSale the strUnitNameSale to set
	 */
	public void setStrUnitNameSale(String strUnitNameSale) {
		this.strUnitNameSale = strUnitNameSale;
	}

	/**
	 * Gets the str unit sale combo.
	 * 
	 * @return the strUnitSaleCombo
	 */
	public String getStrUnitSaleCombo() {
		return strUnitSaleCombo;
	}

	/**
	 * Sets the str unit sale combo.
	 * 
	 * @param strUnitSaleCombo the strUnitSaleCombo to set
	 */
	public void setStrUnitSaleCombo(String strUnitSaleCombo) {
		this.strUnitSaleCombo = strUnitSaleCombo;
	}

	/**
	 * Gets the str unit sale combo ws.
	 * 
	 * @return the strUnitSaleComboWS
	 */
	public WebRowSet getStrUnitSaleComboWS() {
		return strUnitSaleComboWS;
	}

	/**
	 * Sets the str unit sale combo ws.
	 * 
	 * @param strUnitSaleComboWS the strUnitSaleComboWS to set
	 */
	public void setStrUnitSaleComboWS(WebRowSet strUnitSaleComboWS) {
		this.strUnitSaleComboWS = strUnitSaleComboWS;
	}

	/**
	 * Gets the str in hand quantity unit name.
	 * 
	 * @return the strInHandQuantityUnitName
	 */
	public String getStrInHandQuantityUnitName() {
		return strInHandQuantityUnitName;
	}

	/**
	 * Sets the str in hand quantity unit name.
	 * 
	 * @param strInHandQuantityUnitName the strInHandQuantityUnitName to set
	 */
	public void setStrInHandQuantityUnitName(String strInHandQuantityUnitName) {
		this.strInHandQuantityUnitName = strInHandQuantityUnitName;
	}

	/**
	 * Gets the str modify value.
	 * 
	 * @return the str modify value
	 */
	public String getStrModifyValue() {
		return strModifyValue;
	}

	/**
	 * Sets the str modify value.
	 * 
	 * @param strModifyValue the new str modify value
	 */
	public void setStrModifyValue(String strModifyValue) {
		this.strModifyValue = strModifyValue;
	}

	/**
	 * Gets the str bill no.
	 * 
	 * @return the strBillNo
	 */
	public String getStrBillNo() {
		return strBillNo;
	}

	/**
	 * Sets the str bill no.
	 * 
	 * @param strBillNo the strBillNo to set
	 */
	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}

	/**
	 * Gets the str bill date.
	 * 
	 * @return the strBillDate
	 */
	public String getStrBillDate() {
		return strBillDate;
	}

	/**
	 * Sets the str bill date.
	 * 
	 * @param strBillDate the strBillDate to set
	 */
	public void setStrBillDate(String strBillDate) {
		this.strBillDate = strBillDate;
	}

	/**
	 * Gets the str reg flag.
	 * 
	 * @return the str reg flag
	 */
	public String getStrRegFlag() {
		return strRegFlag;
	}

	/**
	 * Sets the str reg flag.
	 * 
	 * @param strRegFlag the new str reg flag
	 */
	public void setStrRegFlag(String strRegFlag) {
		this.strRegFlag = strRegFlag;
	}

	/**
	 * Gets the str existing batch combo ws.
	 * 
	 * @return the str existing batch combo ws
	 */
	public WebRowSet getStrExistingBatchComboWS() {
		return strExistingBatchComboWS;
	}

	/**
	 * Sets the str existing batch combo ws.
	 * 
	 * @param strExistingBatchComboWS the new str existing batch combo ws
	 */
	public void setStrExistingBatchComboWS(WebRowSet strExistingBatchComboWS) {
		this.strExistingBatchComboWS = strExistingBatchComboWS;
	}

	/**
	 * Gets the str group name combo.
	 * 
	 * @return the str group name combo
	 */
	public String getStrGroupNameCombo() {
		return strGroupNameCombo;
	}

	/**
	 * Sets the str group name combo.
	 * 
	 * @param strGroupNameCombo the new str group name combo
	 */
	public void setStrGroupNameCombo(String strGroupNameCombo) {
		this.strGroupNameCombo = strGroupNameCombo;
	}

	/**
	 * Gets the str batch exist in stock flg.
	 * 
	 * @return the str batch exist in stock flg
	 */
	public String getStrBatchExistInStockFlg() {
		return strBatchExistInStockFlg;
	}

	/**
	 * Sets the str batch exist in stock flg.
	 * 
	 * @param strBatchExistInStockFlg the new str batch exist in stock flg
	 */
	public void setStrBatchExistInStockFlg(String strBatchExistInStockFlg) {
		this.strBatchExistInStockFlg = strBatchExistInStockFlg;
	}

	/**
	 * Gets the str active qty.
	 * 
	 * @return the str active qty
	 */
	public String getStrActiveQty() {
		return strActiveQty;
	}

	/**
	 * Sets the str active qty.
	 * 
	 * @param strActiveQty the new str active qty
	 */
	public void setStrActiveQty(String strActiveQty) {
		this.strActiveQty = strActiveQty;
	}

	/**
	 * Gets the str in active qty.
	 * 
	 * @return the str in active qty
	 */
	public String getStrInActiveQty() {
		return strInActiveQty;
	}

	/**
	 * Sets the str in active qty.
	 * 
	 * @param strInActiveQty the new str in active qty
	 */
	public void setStrInActiveQty(String strInActiveQty) {
		this.strInActiveQty = strInActiveQty;
	}

	/**
	 * Gets the str quarantine qty.
	 * 
	 * @return the str quarantine qty
	 */
	public String getStrQuarantineQty() {
		return strQuarantineQty;
	}

	/**
	 * Sets the str quarantine qty.
	 * 
	 * @param strQuarantineQty the new str quarantine qty
	 */
	public void setStrQuarantineQty(String strQuarantineQty) {
		this.strQuarantineQty = strQuarantineQty;
	}

	/**
	 * Gets the str approved by ws.
	 * 
	 * @return the str approved by ws
	 */
	public WebRowSet getStrApprovedByWs() {
		return strApprovedByWs;
	}

	/**
	 * Sets the str approved by ws.
	 * 
	 * @param strApprovedByWs the new str approved by ws
	 */
	public void setStrApprovedByWs(WebRowSet strApprovedByWs) {
		this.strApprovedByWs = strApprovedByWs;
	}

	/**
	 * Gets the approved by combo ws.
	 * 
	 * @return the approved by combo ws
	 */
	public WebRowSet getApprovedByComboWS() {
		return approvedByComboWS;
	}

	/**
	 * Sets the approved by combo ws.
	 * 
	 * @param approvedByComboWS the new approved by combo ws
	 */
	public void setApprovedByComboWS(WebRowSet approvedByComboWS) {
		this.approvedByComboWS = approvedByComboWS;
	}

	/**
	 * Gets the str approved by combo.
	 * 
	 * @return the str approved by combo
	 */
	public String getStrApprovedByCombo() {
		return strApprovedByCombo;
	}

	/**
	 * Sets the str approved by combo.
	 * 
	 * @param strApprovedByCombo the new str approved by combo
	 */
	public void setStrApprovedByCombo(String strApprovedByCombo) {
		this.strApprovedByCombo = strApprovedByCombo;
	}

	/**
	 * Gets the str demanded qty.
	 * 
	 * @return the str demanded qty
	 */
	public String getStrDemandedQty() {
		return strDemandedQty;
	}

	/**
	 * Sets the str demanded qty.
	 * 
	 * @param strDemandedQty the new str demanded qty
	 */
	public void setStrDemandedQty(String strDemandedQty) {
		this.strDemandedQty = strDemandedQty;
	}

	/**
	 * Gets the str approved by id.
	 * 
	 * @return the str approved by id
	 */
	public String getStrApprovedById() {
		return strApprovedById;
	}

	/**
	 * Sets the str approved by id.
	 * 
	 * @param strApprovedById the new str approved by id
	 */
	public void setStrApprovedById(String strApprovedById) {
		this.strApprovedById = strApprovedById;
	}

	/**
	 * Gets the str approved by.
	 * 
	 * @return the str approved by
	 */
	public String getStrApprovedBy() {
		return strApprovedBy;
	}

	/**
	 * Sets the str approved by.
	 * 
	 * @param strApprovedBy the new str approved by
	 */
	public void setStrApprovedBy(String strApprovedBy) {
		this.strApprovedBy = strApprovedBy;
	}

	/**
	 * Gets the str approved date.
	 * 
	 * @return the str approved date
	 */
	public String getStrApprovedDate() {
		return strApprovedDate;
	}

	/**
	 * Sets the str approved date.
	 * 
	 * @param strApprovedDate the new str approved date
	 */
	public void setStrApprovedDate(String strApprovedDate) {
		this.strApprovedDate = strApprovedDate;
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
	 * Gets the str req status.
	 * 
	 * @return the str req status
	 */
	public String getStrReqStatus() {
		return strReqStatus;
	}

	/**
	 * Sets the str req status.
	 * 
	 * @param strReqStatus the new str req status
	 */
	public void setStrReqStatus(String strReqStatus) {
		this.strReqStatus = strReqStatus;
	}

	/**
	 * Gets the str request no.
	 * 
	 * @return the str request no
	 */
	public String getStrRequestNo() {
		return strRequestNo;
	}

	/**
	 * Sets the str request no.
	 * 
	 * @param strRequestNo the new str request no
	 */
	public void setStrRequestNo(String strRequestNo) {
		this.strRequestNo = strRequestNo;
	}

	/**
	 * Gets the str modify dtl ws.
	 * 
	 * @return the str modify dtl ws
	 */
	public WebRowSet getStrModifyDtlWS() {
		return strModifyDtlWS;
	}

	/**
	 * Sets the str modify dtl ws.
	 * 
	 * @param strModifyDtlWS the new str modify dtl ws
	 */
	public void setStrModifyDtlWS(WebRowSet strModifyDtlWS) {
		this.strModifyDtlWS = strModifyDtlWS;
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
	 * Gets the wb transfer order detail.
	 * 
	 * @return the wb transfer order detail
	 */
	public WebRowSet getWbTransferOrderDetail() {
		return WbTransferOrderDetail;
	}

	/**
	 * Sets the wb transfer order detail.
	 * 
	 * @param wbTransferOrderDetail the new wb transfer order detail
	 */
	public void setWbTransferOrderDetail(WebRowSet wbTransferOrderDetail) {
		WbTransferOrderDetail = wbTransferOrderDetail;
	}

	/**
	 * Gets the str order number.
	 * 
	 * @return the str order number
	 */
	public String getStrOrderNumber() {
		return strOrderNumber;
	}

	/**
	 * Sets the str order number.
	 * 
	 * @param strOrderNumber the new str order number
	 */
	public void setStrOrderNumber(String strOrderNumber) {
		this.strOrderNumber = strOrderNumber;
	}

	/**
	 * Gets the str hid item value.
	 * 
	 * @return the strHiddenValue
	 */
	public String[] getStrHiddenValue() {
		return strHiddenValue;
	}

	/**
	 * Sets the str hid item value.
	 * 
	 * @param strHiddenValue the strHiddenValue to set
	 */
	public void setStrHiddenValue(String[] strHiddenValue) {
		this.strHiddenValue = strHiddenValue;
	}

	/**
	 * Gets the str serial no.
	 * 
	 * @return the strSerialNo
	 */
	public String getStrSerialNo() {
		return strSerialNo;
	}

	/**
	 * Sets the str serial no.
	 * 
	 * @param strSerialNo the strSerialNo to set
	 */
	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
	}

	/**
	 * Gets the str online app status.
	 * 
	 * @return the strOnlineAppStatus
	 */
	public String getStrOnlineAppStatus() {
		return strOnlineAppStatus;
	}

	/**
	 * Sets the str online app status.
	 * 
	 * @param strOnlineAppStatus the strOnlineAppStatus to set
	 */
	public void setStrOnlineAppStatus(String strOnlineAppStatus) {
		this.strOnlineAppStatus = strOnlineAppStatus;
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

}
