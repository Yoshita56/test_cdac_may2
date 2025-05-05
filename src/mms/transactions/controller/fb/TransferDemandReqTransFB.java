/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferDemandReqTransFB.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.fb;

import hisglobal.transactionutil.GenericFormBean;

import javax.sql.rowset.WebRowSet;

/**
 * The Class TransferDemandReqTransFB.
 */
public class TransferDemandReqTransFB extends GenericFormBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	// private String chk = "";

	/** The str err msg. */
	private String strErrMsg = "";

	/** The str warning msg. */
	private String strWarningMsg = "";

	/** The str normal msg. */
	private String strNormalMsg = "";

	/** The str combo val. */
	private String strComboVal = "";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	private String strSerialNo = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str req date. */
	private String strReqDate = "";

	/** The str remarks. */
	private String strRemarks = "";

	/** The str path. */
	private String strPath = "";

	/** The str group name combo. */
	private String strGroupNameCombo = "";

	/** The str demanded qty. */
	private String strDemandedQty = "";

	/** The str approved by id. */
	private String strApprovedById = "";

	/** The str approved by. */
	private String strApprovedBy = "";

	/** The str req status. */
	private String strReqStatus = "";
	private String strOrderView="0";
	private String strSetApprovedDetails="";

	/** The str chk. */
	private String strChk = "";

	/** The str modify chk. */
	private String strModifyChk = "";

	/** The str acknowledge details. */
	private String strAcknowledgeDetails = "";

	/** The str item details. */
	private String strItemDetails = "";

	/** The str ack dtls. */
	private String strAckDtls = "";

	/** The str ack status. */
	private String strAckStatus = "0";

	/** The str trans no. */
	private String strTransNo = "0";

	/** The str store id. */
	private String strStoreId = "";

	/** The cnt_page. */
	private String cnt_page = "";

	/** The str ct date. */
	private String strCtDate = "";

	/** The str request no. */
	private String strRequestNo = "";

	/** The str tmp store id. */
	private String strTmpStoreId = "";

	/** The str effective from. */
	private String strEffectiveFrom = "";

	/** The str manufacture id. */
	private String strManufactureId = "";

	/** The str manufacture name. */
	private String strManufactureName = "";

	/** The str manufacture combo. */
	private String strManufactureCombo = "";

	/** The str bill no. */
	private String strBillNo = "";

	/** The str bill date. */
	private String strBillDate = "";

	/** The str supplied by. */
	private String strSuppliedBy = "0";

	/** The str supplied by values. */
	private String strSuppliedByValues = "";

	/** The str approved by combo. */
	private String strApprovedByCombo = "";

	/** The str approved date. */
	private String strApprovedDate = "";

	/** The str unit rate id. */
	private String strUnitRateID = "";

	/** The str unit rate name. */
	private String strUnitRateName = "";

	/** The str unit rate combo. */
	private String strUnitRateCombo = "";

	/** The str unit sale id. */
	private String strUnitSaleID = "";

	/** The str unit sale name. */
	private String strUnitSaleName = "";

	/** The str unit sale combo. */
	private String strUnitSaleCombo = "";

	/** The str store name. */
	private String strStoreName = "";

	/** The str group id. */
	private String strGroupId = "";

	/** The str group name. */
	private String strGroupName = "";

	/** The str item name combo. */
	private String strItemNameCombo = "";

	/** The str item name. */
	private String strItemName = "";

	/** The str item id. */
	private String strItemId = "";

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

	/** The str po no. */
	private String strPoNo = "";

	/** The str po date. */
	private String strPoDate = "";

	/** The str received date. */
	private String strReceivedDate = "";

	/** The str currency code. */
	private String strCurrencyCode = "0";

	/** The str currency code values. */
	private String strCurrencyCodeValues = "";

	/** The str currency value. */
	private String strCurrencyValue = "1";

	/** The str default currency code. */
	private String strDefaultCurrencyCode = "0";

	/** The str issue rate config flg. */
	private String strIssueRateConfigFlg;

	/** The str in hand quantity unit values. */
	private String strInHandQuantityUnitValues = "";

	/** The str rate unit values. */
	private String strRateUnitValues = "";

	/** The str sales rate unit values. */
	private String strSalesRateUnitValues = "";

	/** The str stock status. */
	private String strStockStatus = "";

	/** The str old stock status. */
	private String strOldStockStatus = "";

	/** The str stock status values. */
	private String strStockStatusValues = "";

	/** The str unit id. */
	private String strUnitId = "0";

	/** The str unit name. */
	private String strUnitName = "";

	/** The str module id. */
	private String strModuleId = "0";

	/** The str unit name combo. */
	private String strUnitNameCombo = "";

	/** The str unit combo. */
	private String strUnitCombo = "";

	/** The str in hand quantity. */
	private String strInHandQuantity = "";

	/** The str in hand quantity unit id. */
	private String strInHandQuantityUnitID = "";

	/** The str item brand combo. */
	private String strItemBrandCombo = "";

	/** The str item brand name. */
	private String strItemBrandName = "";

	/** The str item brand id. */
	private String strItemBrandId = "";

	/** The str item category no. */
	private String strItemCategoryNo = "";

	/** The str sub group combo. */
	private String strSubGroupCombo = "";

	/** The str sub group code. */
	private String strSubGroupCode = "";

	/** The str sub group name. */
	private String strSubGroupName = "";

	/** The str unit id sale. */
	private String strUnitIdSale = "0";

	/** The str unit name sale. */
	private String strUnitNameSale = "";

	/** The str unit name combo sale. */
	private String strUnitNameComboSale = "";

	/** The Wb transfer order detail. */
	private WebRowSet WbTransferOrderDetail = null;

	/*
	 * View Option
	 */
	/** The str request no view. */
	private String strRequestNoView = "";

	/** The str request date view. */
	private String strRequestDateView = "";

	/** The str item name view. */
	private String strItemNameView = "";

	/** The str group name view. */
	private String strGroupNameView = "";

	/** The str sub group name view. */
	private String strSubGroupNameView = "";

	/** The str store name view. */
	private String strStoreNameView = "";

	/** The str unit name view. */
	private String strUnitNameView = "";

	/** The str req qty view. */
	private String strReqQtyView = "";

	/** The str approved by view. */
	private String strApprovedByView = "";

	/** The str approved date view. */
	private String strApprovedDateView = "";

	/** The str approved status view. */
	private String strApprovedStatusView = "";

	/** The str req qty with unit view. */
	private String strReqQtyWithUnitView = "";

	/** The str approved qty with unit view. */
	private String strApprovedQtyWithUnitView = "";

	/** The str ack qty with unit view. */
	private String strAckQtyWithUnitView = "";

	/** The str raising avl qty with unit view. */
	private String strRaisingAvlQtyWithUnitView = "";

	/** The str ack avl qty with unit view. */
	private String strAckAvlQtyWithUnitView = "";

	/** The str raising remarks view. */
	private String strRaisingRemarksView = "";

	/** The str order by seat id view. */
	private String strOrderBySeatIdView = "";

	/** The str order by date view. */
	private String strOrderByDateView = "";

	/** The str order remarks view. */
	private String strOrderRemarksView = "";

	/** The str status view. */
	private String strStatusView = "";

	/** The str batch no view. */
	private String strBatchNoView = "";

	/** The str exp date view. */
	private String strExpDateView = "";

	/** The str mfg date view. */
	private String strMfgDateView = "";

	/** The str transfer order details. */
	private String strTransferOrderDetails = "";

	/** The str approval remarks view. */
	private String strApprovalRemarksView;

	/** The str time period. */
	private String strTimePeriod = "";

	/** The str time period combo. */
	private String strTimePeriodCombo = "";

	// Hidden Fields

	/** The str hidden value. */
	private String[] strHiddenValue = null;

	/** The str hid val. */
	private String strHidVal = "";

	/** The str online app status. */
	private String strOnlineAppStatus = "";

	/**
	 * Gets the str hid val.
	 * 
	 * @return the str hid val
	 */
	public String getStrHidVal() {
		return strHidVal;
	}

	/**
	 * Sets the str hid val.
	 * 
	 * @param strHidVal the new str hid val
	 */
	public void setStrHidVal(String strHidVal) {
		this.strHidVal = strHidVal;
	}

	/**
	 * Gets the str acknowledge details.
	 * 
	 * @return the str acknowledge details
	 */
	public String getStrAcknowledgeDetails() {
		return strAcknowledgeDetails;
	}

	/**
	 * Sets the str acknowledge details.
	 * 
	 * @param strAcknowledgeDetails the new str acknowledge details
	 */
	public void setStrAcknowledgeDetails(String strAcknowledgeDetails) {
		this.strAcknowledgeDetails = strAcknowledgeDetails;
	}

	/**
	 * Gets the str item details.
	 * 
	 * @return the str item details
	 */
	public String getStrItemDetails() {
		return strItemDetails;
	}

	/**
	 * Sets the str item details.
	 * 
	 * @param strItemDetails the new str item details
	 */
	public void setStrItemDetails(String strItemDetails) {
		this.strItemDetails = strItemDetails;
	}

	/**
	 * Gets the str err msg.
	 * 
	 * @return the str err msg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}

	/**
	 * Sets the str err msg.
	 * 
	 * @param strErrMsg the new str err msg
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	/**
	 * Gets the str warning msg.
	 * 
	 * @return the str warning msg
	 */
	public String getStrWarningMsg() {
		return strWarningMsg;
	}

	/**
	 * Sets the str warning msg.
	 * 
	 * @param strWarningMsg the new str warning msg
	 */
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}

	/**
	 * Gets the str normal msg.
	 * 
	 * @return the str normal msg
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}

	/**
	 * Sets the str normal msg.
	 * 
	 * @param strNormalMsg the new str normal msg
	 */
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
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
	 * Gets the str path.
	 * 
	 * @return the str path
	 */
	public String getStrPath() {
		return strPath;
	}

	/**
	 * Sets the str path.
	 * 
	 * @param strPath the new str path
	 */
	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}

	/**
	 * Gets the str ack dtls.
	 * 
	 * @return the str ack dtls
	 */
	public String getStrAckDtls() {
		return strAckDtls;
	}

	/**
	 * Sets the str ack dtls.
	 * 
	 * @param strAckDtls the new str ack dtls
	 */
	public void setStrAckDtls(String strAckDtls) {
		this.strAckDtls = strAckDtls;
	}

	/**
	 * Gets the str hospital code.
	 * 
	 * @return the str hospital code
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
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
	 * Gets the str hidden value.
	 * 
	 * @return the str hidden value
	 */
	public String[] getStrHiddenValue() {
		return strHiddenValue;
	}

	/**
	 * Sets the str hidden value.
	 * 
	 * @param strHiddenValue the new str hidden value
	 */
	public void setStrHiddenValue(String[] strHiddenValue) {
		this.strHiddenValue = strHiddenValue;
	}

	/**
	 * Gets the str combo val.
	 * 
	 * @return the str combo val
	 */
	public String getStrComboVal() {
		return strComboVal;
	}

	/**
	 * Sets the str combo val.
	 * 
	 * @param strComboVal the new str combo val
	 */
	public void setStrComboVal(String strComboVal) {
		this.strComboVal = strComboVal;
	}

	/**
	 * Gets the str ack status.
	 * 
	 * @return the strAckStatus
	 */
	public String getStrAckStatus() {
		return strAckStatus;
	}

	/**
	 * Sets the str ack status.
	 * 
	 * @param strAckStatus the strAckStatus to set
	 */
	public void setStrAckStatus(String strAckStatus) {
		this.strAckStatus = strAckStatus;
	}

	/**
	 * Gets the str trans no.
	 * 
	 * @return the strTransNo
	 */
	public String getStrTransNo() {
		return strTransNo;
	}

	/**
	 * Sets the str trans no.
	 * 
	 * @param strTransNo the strTransNo to set
	 */
	public void setStrTransNo(String strTransNo) {
		this.strTransNo = strTransNo;
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
	 * Gets the cnt_page.
	 * 
	 * @return the cnt_page
	 */
	@Override
	public String getCnt_page() {
		return cnt_page;
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
	 * Gets the str bill no.
	 * 
	 * @return the str bill no
	 */
	public String getStrBillNo() {
		return strBillNo;
	}

	/**
	 * Sets the str bill no.
	 * 
	 * @param strBillNo the new str bill no
	 */
	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}

	/**
	 * Gets the str bill date.
	 * 
	 * @return the str bill date
	 */
	public String getStrBillDate() {
		return strBillDate;
	}

	/**
	 * Sets the str bill date.
	 * 
	 * @param strBillDate the new str bill date
	 */
	public void setStrBillDate(String strBillDate) {
		this.strBillDate = strBillDate;
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
	 * Gets the str supplied by values.
	 * 
	 * @return the str supplied by values
	 */
	public String getStrSuppliedByValues() {
		return strSuppliedByValues;
	}

	/**
	 * Sets the str supplied by values.
	 * 
	 * @param strSuppliedByValues the new str supplied by values
	 */
	public void setStrSuppliedByValues(String strSuppliedByValues) {
		this.strSuppliedByValues = strSuppliedByValues;
	}

	/**
	 * Gets the str unit rate id.
	 * 
	 * @return the str unit rate id
	 */
	public String getStrUnitRateID() {
		return strUnitRateID;
	}

	/**
	 * Sets the str unit rate id.
	 * 
	 * @param strUnitRateID the new str unit rate id
	 */
	public void setStrUnitRateID(String strUnitRateID) {
		this.strUnitRateID = strUnitRateID;
	}

	/**
	 * Gets the str unit rate name.
	 * 
	 * @return the str unit rate name
	 */
	public String getStrUnitRateName() {
		return strUnitRateName;
	}

	/**
	 * Sets the str unit rate name.
	 * 
	 * @param strUnitRateName the new str unit rate name
	 */
	public void setStrUnitRateName(String strUnitRateName) {
		this.strUnitRateName = strUnitRateName;
	}

	/**
	 * Gets the str unit rate combo.
	 * 
	 * @return the str unit rate combo
	 */
	public String getStrUnitRateCombo() {
		return strUnitRateCombo;
	}

	/**
	 * Sets the str unit rate combo.
	 * 
	 * @param strUnitRateCombo the new str unit rate combo
	 */
	public void setStrUnitRateCombo(String strUnitRateCombo) {
		this.strUnitRateCombo = strUnitRateCombo;
	}

	/**
	 * Gets the str unit sale id.
	 * 
	 * @return the str unit sale id
	 */
	public String getStrUnitSaleID() {
		return strUnitSaleID;
	}

	/**
	 * Sets the str unit sale id.
	 * 
	 * @param strUnitSaleID the new str unit sale id
	 */
	public void setStrUnitSaleID(String strUnitSaleID) {
		this.strUnitSaleID = strUnitSaleID;
	}

	/**
	 * Gets the str unit sale name.
	 * 
	 * @return the str unit sale name
	 */
	public String getStrUnitSaleName() {
		return strUnitSaleName;
	}

	/**
	 * Sets the str unit sale name.
	 * 
	 * @param strUnitSaleName the new str unit sale name
	 */
	public void setStrUnitSaleName(String strUnitSaleName) {
		this.strUnitSaleName = strUnitSaleName;
	}

	/**
	 * Gets the str unit sale combo.
	 * 
	 * @return the str unit sale combo
	 */
	public String getStrUnitSaleCombo() {
		return strUnitSaleCombo;
	}

	/**
	 * Sets the str unit sale combo.
	 * 
	 * @param strUnitSaleCombo the new str unit sale combo
	 */
	public void setStrUnitSaleCombo(String strUnitSaleCombo) {
		this.strUnitSaleCombo = strUnitSaleCombo;
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
	 * Gets the str group name.
	 * 
	 * @return the str group name
	 */
	public String getStrGroupName() {
		return strGroupName;
	}

	/**
	 * Sets the str group name.
	 * 
	 * @param strGroupName the new str group name
	 */
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
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
	 * @return the str rate
	 */
	public String getStrRate() {
		return strRate;
	}

	/**
	 * Sets the str rate.
	 * 
	 * @param strRate the new str rate
	 */
	public void setStrRate(String strRate) {
		this.strRate = strRate;
	}

	/**
	 * Gets the str sale price.
	 * 
	 * @return the str sale price
	 */
	public String getStrSalePrice() {
		return strSalePrice;
	}

	/**
	 * Sets the str sale price.
	 * 
	 * @param strSalePrice the new str sale price
	 */
	public void setStrSalePrice(String strSalePrice) {
		this.strSalePrice = strSalePrice;
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
	 * Gets the str currency code values.
	 * 
	 * @return the str currency code values
	 */
	public String getStrCurrencyCodeValues() {
		return strCurrencyCodeValues;
	}

	/**
	 * Sets the str currency code values.
	 * 
	 * @param strCurrencyCodeValues the new str currency code values
	 */
	public void setStrCurrencyCodeValues(String strCurrencyCodeValues) {
		this.strCurrencyCodeValues = strCurrencyCodeValues;
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
	 * Gets the str default currency code.
	 * 
	 * @return the str default currency code
	 */
	public String getStrDefaultCurrencyCode() {
		return strDefaultCurrencyCode;
	}

	/**
	 * Sets the str default currency code.
	 * 
	 * @param strDefaultCurrencyCode the new str default currency code
	 */
	public void setStrDefaultCurrencyCode(String strDefaultCurrencyCode) {
		this.strDefaultCurrencyCode = strDefaultCurrencyCode;
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
	 * Gets the str in hand quantity unit values.
	 * 
	 * @return the str in hand quantity unit values
	 */
	public String getStrInHandQuantityUnitValues() {
		return strInHandQuantityUnitValues;
	}

	/**
	 * Sets the str in hand quantity unit values.
	 * 
	 * @param strInHandQuantityUnitValues the new str in hand quantity unit values
	 */
	public void setStrInHandQuantityUnitValues(String strInHandQuantityUnitValues) {
		this.strInHandQuantityUnitValues = strInHandQuantityUnitValues;
	}

	/**
	 * Gets the str rate unit values.
	 * 
	 * @return the str rate unit values
	 */
	public String getStrRateUnitValues() {
		return strRateUnitValues;
	}

	/**
	 * Sets the str rate unit values.
	 * 
	 * @param strRateUnitValues the new str rate unit values
	 */
	public void setStrRateUnitValues(String strRateUnitValues) {
		this.strRateUnitValues = strRateUnitValues;
	}

	/**
	 * Gets the str sales rate unit values.
	 * 
	 * @return the str sales rate unit values
	 */
	public String getStrSalesRateUnitValues() {
		return strSalesRateUnitValues;
	}

	/**
	 * Sets the str sales rate unit values.
	 * 
	 * @param strSalesRateUnitValues the new str sales rate unit values
	 */
	public void setStrSalesRateUnitValues(String strSalesRateUnitValues) {
		this.strSalesRateUnitValues = strSalesRateUnitValues;
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
	 * Gets the str stock status values.
	 * 
	 * @return the str stock status values
	 */
	public String getStrStockStatusValues() {
		return strStockStatusValues;
	}

	/**
	 * Sets the str stock status values.
	 * 
	 * @param strStockStatusValues the new str stock status values
	 */
	public void setStrStockStatusValues(String strStockStatusValues) {
		this.strStockStatusValues = strStockStatusValues;
	}

	/**
	 * Gets the str unit id.
	 * 
	 * @return the str unit id
	 */
	public String getStrUnitId() {
		return strUnitId;
	}

	/**
	 * Sets the str unit id.
	 * 
	 * @param strUnitId the new str unit id
	 */
	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
	}

	/**
	 * Gets the str unit name.
	 * 
	 * @return the str unit name
	 */
	public String getStrUnitName() {
		return strUnitName;
	}

	/**
	 * Sets the str unit name.
	 * 
	 * @param strUnitName the new str unit name
	 */
	public void setStrUnitName(String strUnitName) {
		this.strUnitName = strUnitName;
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
	 * Gets the str unit combo.
	 * 
	 * @return the str unit combo
	 */
	public String getStrUnitCombo() {
		return strUnitCombo;
	}

	/**
	 * Sets the str unit combo.
	 * 
	 * @param strUnitCombo the new str unit combo
	 */
	public void setStrUnitCombo(String strUnitCombo) {
		this.strUnitCombo = strUnitCombo;
	}

	/**
	 * Gets the str in hand quantity.
	 * 
	 * @return the str in hand quantity
	 */
	public String getStrInHandQuantity() {
		return strInHandQuantity;
	}

	/**
	 * Sets the str in hand quantity.
	 * 
	 * @param strInHandQuantity the new str in hand quantity
	 */
	public void setStrInHandQuantity(String strInHandQuantity) {
		this.strInHandQuantity = strInHandQuantity;
	}

	/**
	 * Gets the str in hand quantity unit id.
	 * 
	 * @return the str in hand quantity unit id
	 */
	public String getStrInHandQuantityUnitID() {
		return strInHandQuantityUnitID;
	}

	/**
	 * Sets the str in hand quantity unit id.
	 * 
	 * @param strInHandQuantityUnitID the new str in hand quantity unit id
	 */
	public void setStrInHandQuantityUnitID(String strInHandQuantityUnitID) {
		this.strInHandQuantityUnitID = strInHandQuantityUnitID;
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

	/**
	 * Gets the str sub group combo.
	 * 
	 * @return the str sub group combo
	 */
	public String getStrSubGroupCombo() {
		return strSubGroupCombo;
	}

	/**
	 * Sets the str sub group combo.
	 * 
	 * @param strSubGroupCombo the new str sub group combo
	 */
	public void setStrSubGroupCombo(String strSubGroupCombo) {
		this.strSubGroupCombo = strSubGroupCombo;
	}

	/**
	 * Gets the str sub group code.
	 * 
	 * @return the str sub group code
	 */
	public String getStrSubGroupCode() {
		return strSubGroupCode;
	}

	/**
	 * Sets the str sub group code.
	 * 
	 * @param strSubGroupCode the new str sub group code
	 */
	public void setStrSubGroupCode(String strSubGroupCode) {
		this.strSubGroupCode = strSubGroupCode;
	}

	/**
	 * Gets the str sub group name.
	 * 
	 * @return the str sub group name
	 */
	public String getStrSubGroupName() {
		return strSubGroupName;
	}

	/**
	 * Sets the str sub group name.
	 * 
	 * @param strSubGroupName the new str sub group name
	 */
	public void setStrSubGroupName(String strSubGroupName) {
		this.strSubGroupName = strSubGroupName;
	}

	/**
	 * Gets the str unit id sale.
	 * 
	 * @return the str unit id sale
	 */
	public String getStrUnitIdSale() {
		return strUnitIdSale;
	}

	/**
	 * Sets the str unit id sale.
	 * 
	 * @param strUnitIdSale the new str unit id sale
	 */
	public void setStrUnitIdSale(String strUnitIdSale) {
		this.strUnitIdSale = strUnitIdSale;
	}

	/**
	 * Gets the str unit name sale.
	 * 
	 * @return the str unit name sale
	 */
	public String getStrUnitNameSale() {
		return strUnitNameSale;
	}

	/**
	 * Sets the str unit name sale.
	 * 
	 * @param strUnitNameSale the new str unit name sale
	 */
	public void setStrUnitNameSale(String strUnitNameSale) {
		this.strUnitNameSale = strUnitNameSale;
	}

	/**
	 * Gets the str unit name combo sale.
	 * 
	 * @return the str unit name combo sale
	 */
	public String getStrUnitNameComboSale() {
		return strUnitNameComboSale;
	}

	/**
	 * Sets the str unit name combo sale.
	 * 
	 * @param strUnitNameComboSale the new str unit name combo sale
	 */
	public void setStrUnitNameComboSale(String strUnitNameComboSale) {
		this.strUnitNameComboSale = strUnitNameComboSale;
	}

	/**
	 * Gets the str ct date.
	 * 
	 * @return the str ct date
	 */
	public String getStrCtDate() {
		return strCtDate;
	}

	/**
	 * Sets the str ct date.
	 * 
	 * @param strCtDate the new str ct date
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
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
	 * Gets the str req date.
	 * 
	 * @return the str req date
	 */
	public String getStrReqDate() {
		return strReqDate;
	}

	/**
	 * Sets the str req date.
	 * 
	 * @param strReqDate the new str req date
	 */
	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
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
	 * Gets the str request no view.
	 * 
	 * @return the str request no view
	 */
	public String getStrRequestNoView() {
		return strRequestNoView;
	}

	/**
	 * Sets the str request no view.
	 * 
	 * @param strRequestNoView the new str request no view
	 */
	public void setStrRequestNoView(String strRequestNoView) {
		this.strRequestNoView = strRequestNoView;
	}

	/**
	 * Gets the str request date view.
	 * 
	 * @return the str request date view
	 */
	public String getStrRequestDateView() {
		return strRequestDateView;
	}

	/**
	 * Sets the str request date view.
	 * 
	 * @param strRequestDateView the new str request date view
	 */
	public void setStrRequestDateView(String strRequestDateView) {
		this.strRequestDateView = strRequestDateView;
	}

	/**
	 * Gets the str item name view.
	 * 
	 * @return the str item name view
	 */
	public String getStrItemNameView() {
		return strItemNameView;
	}

	/**
	 * Sets the str item name view.
	 * 
	 * @param strItemNameView the new str item name view
	 */
	public void setStrItemNameView(String strItemNameView) {
		this.strItemNameView = strItemNameView;
	}

	/**
	 * Gets the str group name view.
	 * 
	 * @return the str group name view
	 */
	public String getStrGroupNameView() {
		return strGroupNameView;
	}

	/**
	 * Sets the str group name view.
	 * 
	 * @param strGroupNameView the new str group name view
	 */
	public void setStrGroupNameView(String strGroupNameView) {
		this.strGroupNameView = strGroupNameView;
	}

	/**
	 * Gets the str store name view.
	 * 
	 * @return the str store name view
	 */
	public String getStrStoreNameView() {
		return strStoreNameView;
	}

	/**
	 * Sets the str store name view.
	 * 
	 * @param strStoreNameView the new str store name view
	 */
	public void setStrStoreNameView(String strStoreNameView) {
		this.strStoreNameView = strStoreNameView;
	}

	/**
	 * Gets the str unit name view.
	 * 
	 * @return the str unit name view
	 */
	public String getStrUnitNameView() {
		return strUnitNameView;
	}

	/**
	 * Sets the str unit name view.
	 * 
	 * @param strUnitNameView the new str unit name view
	 */
	public void setStrUnitNameView(String strUnitNameView) {
		this.strUnitNameView = strUnitNameView;
	}

	/**
	 * Gets the str req qty view.
	 * 
	 * @return the str req qty view
	 */
	public String getStrReqQtyView() {
		return strReqQtyView;
	}

	/**
	 * Sets the str req qty view.
	 * 
	 * @param strReqQtyView the new str req qty view
	 */
	public void setStrReqQtyView(String strReqQtyView) {
		this.strReqQtyView = strReqQtyView;
	}

	/**
	 * Gets the str approved by view.
	 * 
	 * @return the str approved by view
	 */
	public String getStrApprovedByView() {
		return strApprovedByView;
	}

	/**
	 * Sets the str approved by view.
	 * 
	 * @param strApprovedByView the new str approved by view
	 */
	public void setStrApprovedByView(String strApprovedByView) {
		this.strApprovedByView = strApprovedByView;
	}

	/**
	 * Gets the str approved date view.
	 * 
	 * @return the str approved date view
	 */
	public String getStrApprovedDateView() {
		return strApprovedDateView;
	}

	/**
	 * Sets the str approved date view.
	 * 
	 * @param strApprovedDateView the new str approved date view
	 */
	public void setStrApprovedDateView(String strApprovedDateView) {
		this.strApprovedDateView = strApprovedDateView;
	}

	/**
	 * Gets the str approved status view.
	 * 
	 * @return the str approved status view
	 */
	public String getStrApprovedStatusView() {
		return strApprovedStatusView;
	}

	/**
	 * Sets the str approved status view.
	 * 
	 * @param strApprovedStatusView the new str approved status view
	 */
	public void setStrApprovedStatusView(String strApprovedStatusView) {
		this.strApprovedStatusView = strApprovedStatusView;
	}

	/**
	 * Gets the str req qty with unit view.
	 * 
	 * @return the str req qty with unit view
	 */
	public String getStrReqQtyWithUnitView() {
		return strReqQtyWithUnitView;
	}

	/**
	 * Sets the str req qty with unit view.
	 * 
	 * @param strReqQtyWithUnitView the new str req qty with unit view
	 */
	public void setStrReqQtyWithUnitView(String strReqQtyWithUnitView) {
		this.strReqQtyWithUnitView = strReqQtyWithUnitView;
	}

	/**
	 * Gets the str approved qty with unit view.
	 * 
	 * @return the str approved qty with unit view
	 */
	public String getStrApprovedQtyWithUnitView() {
		return strApprovedQtyWithUnitView;
	}

	/**
	 * Sets the str approved qty with unit view.
	 * 
	 * @param strApprovedQtyWithUnitView the new str approved qty with unit view
	 */
	public void setStrApprovedQtyWithUnitView(String strApprovedQtyWithUnitView) {
		this.strApprovedQtyWithUnitView = strApprovedQtyWithUnitView;
	}

	/**
	 * Gets the str ack qty with unit view.
	 * 
	 * @return the str ack qty with unit view
	 */
	public String getStrAckQtyWithUnitView() {
		return strAckQtyWithUnitView;
	}

	/**
	 * Sets the str ack qty with unit view.
	 * 
	 * @param strAckQtyWithUnitView the new str ack qty with unit view
	 */
	public void setStrAckQtyWithUnitView(String strAckQtyWithUnitView) {
		this.strAckQtyWithUnitView = strAckQtyWithUnitView;
	}

	/**
	 * Gets the str raising avl qty with unit view.
	 * 
	 * @return the str raising avl qty with unit view
	 */
	public String getStrRaisingAvlQtyWithUnitView() {
		return strRaisingAvlQtyWithUnitView;
	}

	/**
	 * Sets the str raising avl qty with unit view.
	 * 
	 * @param strRaisingAvlQtyWithUnitView the new str raising avl qty with unit view
	 */
	public void setStrRaisingAvlQtyWithUnitView(String strRaisingAvlQtyWithUnitView) {
		this.strRaisingAvlQtyWithUnitView = strRaisingAvlQtyWithUnitView;
	}

	/**
	 * Gets the str ack avl qty with unit view.
	 * 
	 * @return the str ack avl qty with unit view
	 */
	public String getStrAckAvlQtyWithUnitView() {
		return strAckAvlQtyWithUnitView;
	}

	/**
	 * Sets the str ack avl qty with unit view.
	 * 
	 * @param strAckAvlQtyWithUnitView the new str ack avl qty with unit view
	 */
	public void setStrAckAvlQtyWithUnitView(String strAckAvlQtyWithUnitView) {
		this.strAckAvlQtyWithUnitView = strAckAvlQtyWithUnitView;
	}

	/**
	 * Gets the str raising remarks view.
	 * 
	 * @return the str raising remarks view
	 */
	public String getStrRaisingRemarksView() {
		return strRaisingRemarksView;
	}

	/**
	 * Sets the str raising remarks view.
	 * 
	 * @param strRaisingRemarksView the new str raising remarks view
	 */
	public void setStrRaisingRemarksView(String strRaisingRemarksView) {
		this.strRaisingRemarksView = strRaisingRemarksView;
	}

	/**
	 * Gets the str order by seat id view.
	 * 
	 * @return the str order by seat id view
	 */
	public String getStrOrderBySeatIdView() {
		return strOrderBySeatIdView;
	}

	/**
	 * Sets the str order by seat id view.
	 * 
	 * @param strOrderBySeatIdView the new str order by seat id view
	 */
	public void setStrOrderBySeatIdView(String strOrderBySeatIdView) {
		this.strOrderBySeatIdView = strOrderBySeatIdView;
	}

	/**
	 * Gets the str order by date view.
	 * 
	 * @return the str order by date view
	 */
	public String getStrOrderByDateView() {
		return strOrderByDateView;
	}

	/**
	 * Sets the str order by date view.
	 * 
	 * @param strOrderByDateView the new str order by date view
	 */
	public void setStrOrderByDateView(String strOrderByDateView) {
		this.strOrderByDateView = strOrderByDateView;
	}

	/**
	 * Gets the str order remarks view.
	 * 
	 * @return the str order remarks view
	 */
	public String getStrOrderRemarksView() {
		return strOrderRemarksView;
	}

	/**
	 * Sets the str order remarks view.
	 * 
	 * @param strOrderRemarksView the new str order remarks view
	 */
	public void setStrOrderRemarksView(String strOrderRemarksView) {
		this.strOrderRemarksView = strOrderRemarksView;
	}

	/**
	 * Gets the str status view.
	 * 
	 * @return the str status view
	 */
	public String getStrStatusView() {
		return strStatusView;
	}

	/**
	 * Sets the str status view.
	 * 
	 * @param strStatusView the new str status view
	 */
	public void setStrStatusView(String strStatusView) {
		this.strStatusView = strStatusView;
	}

	/**
	 * Gets the str modify chk.
	 * 
	 * @return the str modify chk
	 */
	public String getStrModifyChk() {
		return strModifyChk;
	}

	/**
	 * Sets the str modify chk.
	 * 
	 * @param strModifyChk the new str modify chk
	 */
	public void setStrModifyChk(String strModifyChk) {
		this.strModifyChk = strModifyChk;
	}

	/**
	 * Gets the str tmp store id.
	 * 
	 * @return the str tmp store id
	 */
	public String getStrTmpStoreId() {
		return strTmpStoreId;
	}

	/**
	 * Sets the str tmp store id.
	 * 
	 * @param strTmpStoreId the new str tmp store id
	 */
	public void setStrTmpStoreId(String strTmpStoreId) {
		this.strTmpStoreId = strTmpStoreId;
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
	 * Gets the str transfer order details.
	 * 
	 * @return the str transfer order details
	 */
	public String getStrTransferOrderDetails() {
		return strTransferOrderDetails;
	}

	/**
	 * Sets the str transfer order details.
	 * 
	 * @param strTransferOrderDetails the new str transfer order details
	 */
	public void setStrTransferOrderDetails(String strTransferOrderDetails) {
		this.strTransferOrderDetails = strTransferOrderDetails;
	}

	/**
	 * Gets the str sub group name view.
	 * 
	 * @return the str sub group name view
	 */
	public String getStrSubGroupNameView() {
		return strSubGroupNameView;
	}

	/**
	 * Sets the str sub group name view.
	 * 
	 * @param strSubGroupNameView the new str sub group name view
	 */
	public void setStrSubGroupNameView(String strSubGroupNameView) {
		this.strSubGroupNameView = strSubGroupNameView;
	}

	/**
	 * Gets the str approval remarks view.
	 * 
	 * @return the str approval remarks view
	 */
	public String getStrApprovalRemarksView() {
		return strApprovalRemarksView;
	}

	/**
	 * Sets the str approval remarks view.
	 * 
	 * @param strApprovalRemarksView the new str approval remarks view
	 */
	public void setStrApprovalRemarksView(String strApprovalRemarksView) {
		this.strApprovalRemarksView = strApprovalRemarksView;
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
	 * Gets the str batch no view.
	 * 
	 * @return the str batch no view
	 */
	public String getStrBatchNoView() {
		return strBatchNoView;
	}

	/**
	 * Sets the str batch no view.
	 * 
	 * @param strBatchNoView the new str batch no view
	 */
	public void setStrBatchNoView(String strBatchNoView) {
		this.strBatchNoView = strBatchNoView;
	}

	/**
	 * Gets the str exp date view.
	 * 
	 * @return the str exp date view
	 */
	public String getStrExpDateView() {
		return strExpDateView;
	}

	/**
	 * Sets the str exp date view.
	 * 
	 * @param strExpDateView the new str exp date view
	 */
	public void setStrExpDateView(String strExpDateView) {
		this.strExpDateView = strExpDateView;
	}

	/**
	 * Gets the str mfg date view.
	 * 
	 * @return the str mfg date view
	 */
	public String getStrMfgDateView() {
		return strMfgDateView;
	}

	/**
	 * Sets the str mfg date view.
	 * 
	 * @param strMfgDateView the new str mfg date view
	 */
	public void setStrMfgDateView(String strMfgDateView) {
		this.strMfgDateView = strMfgDateView;
	}

	/**
	 * @return the strOnlineAppStatus
	 */
	public String getStrOnlineAppStatus() {
		return strOnlineAppStatus;
	}

	/**
	 * @param strOnlineAppStatus the strOnlineAppStatus to set
	 */
	public void setStrOnlineAppStatus(String strOnlineAppStatus) {
		this.strOnlineAppStatus = strOnlineAppStatus;
	}

	public String getStrOrderView() {
		return strOrderView;
	}

	public void setStrOrderView(String strOrderView) {
		this.strOrderView = strOrderView;
	}

	public String getStrSerialNo() {
		return strSerialNo;
	}

	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
	}

	public String getStrSetApprovedDetails() {
		return strSetApprovedDetails;
	}

	public void setStrSetApprovedDetails(String strSetApprovedDetails) {
		this.strSetApprovedDetails = strSetApprovedDetails;
	}

}
