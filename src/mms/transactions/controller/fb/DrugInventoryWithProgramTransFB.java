/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         DrugInventoryWithProgramTransFB.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.fb;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionutil.GenericFormBean;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugInventoryWithProgramTransFB.
 */
public class DrugInventoryWithProgramTransFB extends GenericFormBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str err. */
	private String strErr = "";

	/** The str msg. */
	private String strMsg = "";

	/** The str warning. */
	private String strWarning = "";

	/** The str ct date. */
	private String strCtDate = "";

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

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str store id. */
	private String strStoreId = "";

	/** The str store name. */
	private String strStoreName = "";

	/** The str group id. */
	private String strGroupId = "";

	/** The str programme id. */
	private String strProgrammeId = "";

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
	
	/** The str batch no. */
	private String strSelBatch;	

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

	/** The str programme combo. */
	private String strProgrammeCombo = "";
	
	/** The str programme Name. */
	private String strProgrammeName = "";

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

	/** The str chk. */
	private String strChk = "";

	/** The str unit combo sale. */
	private String strUnitComboSale = "";

	/** The str sub group id. */
	private String strSubGroupId = "";

	/** The str in hand quantity unit name. */
	private String strInHandQuantityUnitName = "";

	/** The str item specification. */
	private String strItemSpecification;

	/** The str reg flag. */
	private String strRegFlag = "";
	
	/** The str strStoreTypeFlag flag. */
	private String strStoreTypeFlag = "";

	/** The str config issue rate. */
	private String strConfigIssueRate;

	/** The str item other dtls. */
	private String[] strItemOtherDtls = null;

	/** The str free item flag. */
	private String strFreeItemFlag;

	/** The str free item quantity. */
	private String strFreeItemQuantity = "0";

	/** The str free item quantity unit id. */
	private String strFreeItemQuantityUnitID = "0";

	/** The str rack number. */
	private String strRackNumber;

	/** The str existing batch id. */
	private String strExistingBatchId;

	/** The str existing batch combo. */
	private String strExistingBatchCombo;

	/** The str existing batch flg. */
	private String strExistingBatchFlg;

	/** The str existing batch details. */
	private String strExistingBatchDetails;

	/** The str group name combo. */
	private String strGroupNameCombo;

	/** The str group cmb id. */
	private String strGroupCmbId;

	/** The str batch exist in stock flg. */
	private String strBatchExistInStockFlg;

	/** The str batch exist supp batch in stock flg. */
	private String strBatchExistSuppBatchInStockFlg;

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

	/** The str multi row item id. */
	private String[] strMultiRowItemId = null;

	/** The str multi row existing batch id. */
	private String[] strMultiRowExistingBatchId = null;

	/** The str multi row final batch no. */
	private String[] strMultiRowFinalBatchNo = null;

	/** The str multi row active qty. */
	private String[] strMultiRowActiveQty = null;

	/** The str multi row quarn qty. */
	private String[] strMultiRowQuarnQty = null;

	/** The str multi row in active qty. */
	private String[] strMultiRowInActiveQty = null;

	/** The str multi row rate. */
	private String[] strMultiRowRate = null;
	
	/** The str multi row purchase rate. */
	private String[] strMultiRowPurRate = null;

	/** The str multi row rate unit id. */
	private String[] strMultiRowRateUnitId = null;

	/** The str multi row expiry date. */
	private String[] strMultiRowExpiryDate = null;

	/** The str multi row mfg date. */
	private String[] strMultiRowMfgDate = null;

	/** The str multi row supplier id. */
	private String[] strMultiRowSupplierId = null;

	/** The str multi row mfg id. */
	private String[] strMultiRowMfgId = null;

	/** The str multi row po no. */
	private String[] strMultiRowPONo = null;

	/** The str multi row tender no. */
	private String[] strMultiRowTenderNo = null;

	/** The str multi row mfg name. */
	private String[] strMultiRowMfgName = null;
	
	/** The str data saved flag. */
	private String strIsDataSaveFlg = "0";
	
	private String strSavedDrugName;
	
	private String strSavedBatchName;
	
	private String strSelDrugName;
	
	private String strPath;

	private String[] strMultiRowInvoiceNo = null;
	
	private String[] strMultiRowInvoiceDate = null;
	private String[] strMultiRowHandlingCharges = null;
	private String[] strMultiRowCosttoPat = null;
	private String[] strMultiRowTax=null;
	private String[] strMultiRowHandlingChargesFinal=null;
	private String[] strMultiRowPackSizeId=null;
	private String[] strMultiRowPackets=null;
	private String[] strMultiRowFlag=null;
	
	//Added By Ranjit
		private WebRowSet wsItemDetails = null;
		private String printFlag;
		private String voucherString;
		private String totalBatchNumber;
		private String userName;
		private String strStoreIdValue="0";
	
	public String getStrStoreIdValue() {
			return strStoreIdValue;
		}

		public void setStrStoreIdValue(String strStoreIdValue) {
			this.strStoreIdValue = strStoreIdValue;
		}

	public String[] getStrMultiRowFlag() {
		return strMultiRowFlag;
	}

	public void setStrMultiRowFlag(String[] strMultiRowFlag) {
		this.strMultiRowFlag = strMultiRowFlag;
	}

	public String[] getStrMultiRowPackSizeId() {
		return strMultiRowPackSizeId;
	}

	public void setStrMultiRowPackSizeId(String[] strMultiRowPackSizeId) {
		this.strMultiRowPackSizeId = strMultiRowPackSizeId;
	}

	public String[] getStrMultiRowPackets() {
		return strMultiRowPackets;
	}

	public void setStrMultiRowPackets(String[] strMultiRowPackets) {
		this.strMultiRowPackets = strMultiRowPackets;
	}

	public String[] getStrMultiRowHandlingChargesFinal() {
		return strMultiRowHandlingChargesFinal;
	}

	public void setStrMultiRowHandlingChargesFinal(
			String[] strMultiRowHandlingChargesFinal) {
		this.strMultiRowHandlingChargesFinal = strMultiRowHandlingChargesFinal;
	}

	public String[] getStrMultiRowTax() {
		return strMultiRowTax;
	}

	public void setStrMultiRowTax(String[] strMultiRowTax) {
		this.strMultiRowTax = strMultiRowTax;
	}

	public String[] getStrMultiRowHandlingCharges() {
		return strMultiRowHandlingCharges;
	}

	public void setStrMultiRowHandlingCharges(String[] strMultiRowHandlingCharges) {
		this.strMultiRowHandlingCharges = strMultiRowHandlingCharges;
	}

	public String[] getStrMultiRowCosttoPat() {
		return strMultiRowCosttoPat;
	}

	public void setStrMultiRowCosttoPat(String[] strMultiRowCosttoPat) {
		this.strMultiRowCosttoPat = strMultiRowCosttoPat;
	}

	public String[] getStrMultiRowInvoiceNo() {
		return strMultiRowInvoiceNo;
	}

	public void setStrMultiRowInvoiceNo(String[] strMultiRowInvoiceNo) {
		this.strMultiRowInvoiceNo = strMultiRowInvoiceNo;
	}

	public String[] getStrMultiRowInvoiceDate() {
		return strMultiRowInvoiceDate;
	}

	public void setStrMultiRowInvoiceDate(String[] strMultiRowInvoiceDate) {
		this.strMultiRowInvoiceDate = strMultiRowInvoiceDate;
	}

	/**
	 * Gets the str multi row mfg name.
	 * 
	 * @return the str multi row mfg name
	 */
	public String[] getStrMultiRowMfgName() {
		return strMultiRowMfgName;
	}

	/**
	 * Sets the str multi row mfg name.
	 * 
	 * @param strMultiRowMfgName
	 *            the new str multi row mfg name
	 */
	public void setStrMultiRowMfgName(String[] strMultiRowMfgName) {
		this.strMultiRowMfgName = strMultiRowMfgName;
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
	 * @param strItemBrandIdValue
	 *            the new str item brand id value
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
	 * @param strDrugTotCost
	 *            the new str drug tot cost
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
	 * @param strQcTypeFlg
	 *            the new str qc type flg
	 */
	public void setStrQcTypeFlg(String strQcTypeFlg) {
		this.strQcTypeFlg = strQcTypeFlg;
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
	 * @param strBatchExistInStockFlg
	 *            the new str batch exist in stock flg
	 */
	public void setStrBatchExistInStockFlg(String strBatchExistInStockFlg) {
		this.strBatchExistInStockFlg = strBatchExistInStockFlg;
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
	 * @param strGroupCmbId
	 *            the new str group cmb id
	 */
	public void setStrGroupCmbId(String strGroupCmbId) {
		this.strGroupCmbId = strGroupCmbId;
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
	 * @param strGroupNameCombo
	 *            the new str group name combo
	 */
	public void setStrGroupNameCombo(String strGroupNameCombo) {
		this.strGroupNameCombo = strGroupNameCombo;
	}

	/**
	 * Gets the str existing batch details.
	 * 
	 * @return the str existing batch details
	 */
	public String getStrExistingBatchDetails() {
		return strExistingBatchDetails;
	}

	/**
	 * Sets the str existing batch details.
	 * 
	 * @param strExistingBatchDetails
	 *            the new str existing batch details
	 */
	public void setStrExistingBatchDetails(String strExistingBatchDetails) {
		this.strExistingBatchDetails = strExistingBatchDetails;
	}

	/**
	 * Gets the str existing batch flg.
	 * 
	 * @return the str existing batch flg
	 */
	public String getStrExistingBatchFlg() {
		return strExistingBatchFlg;
	}

	/**
	 * Sets the str existing batch flg.
	 * 
	 * @param strExistingBatchFlg
	 *            the new str existing batch flg
	 */
	public void setStrExistingBatchFlg(String strExistingBatchFlg) {
		this.strExistingBatchFlg = strExistingBatchFlg;
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
	 * @param strRackNumber
	 *            the new str rack number
	 */
	public void setStrRackNumber(String strRackNumber) {
		this.strRackNumber = strRackNumber;
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
	 * @param strFreeItemQuantity
	 *            the new str free item quantity
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
	 * @param strFreeItemQuantityUnitID
	 *            the new str free item quantity unit id
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
	 * @param strFreeItemFlag
	 *            the new str free item flag
	 */
	public void setStrFreeItemFlag(String strFreeItemFlag) {
		this.strFreeItemFlag = strFreeItemFlag;
	}

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
	 * @param strItemOtherDtls
	 *            the new str item other dtls
	 */
	public void setStrItemOtherDtls(String[] strItemOtherDtls) {
		this.strItemOtherDtls = strItemOtherDtls;
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
	 * @param strOldStockStatus
	 *            the new str old stock status
	 */
	public void setStrOldStockStatus(String strOldStockStatus) {
		this.strOldStockStatus = strOldStockStatus;
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
	 * @param strInHandQuantityUnitValues
	 *            the new str in hand quantity unit values
	 */
	public void setStrInHandQuantityUnitValues(
			String strInHandQuantityUnitValues) {
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
	 * @param strRateUnitValues
	 *            the new str rate unit values
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
	 * @param strSalesRateUnitValues
	 *            the new str sales rate unit values
	 */
	public void setStrSalesRateUnitValues(String strSalesRateUnitValues) {
		this.strSalesRateUnitValues = strSalesRateUnitValues;
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
	 * @param strDefaultCurrencyCode
	 *            the new str default currency code
	 */
	public void setStrDefaultCurrencyCode(String strDefaultCurrencyCode) {
		this.strDefaultCurrencyCode = strDefaultCurrencyCode;
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
	 * @param strCurrencyCode
	 *            the new str currency code
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
	 * @param strCurrencyCodeValues
	 *            the new str currency code values
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
	 * @param strCurrencyValue
	 *            the new str currency value
	 */
	public void setStrCurrencyValue(String strCurrencyValue) {
		this.strCurrencyValue = strCurrencyValue;
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
	 * @param strPoDate
	 *            the new str po date
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
	 * @param strReceivedDate
	 *            the new str received date
	 */
	public void setStrReceivedDate(String strReceivedDate) {
		this.strReceivedDate = strReceivedDate;
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
	 * @param strStockStatusValues
	 *            the new str stock status values
	 */
	public void setStrStockStatusValues(String strStockStatusValues) {
		this.strStockStatusValues = strStockStatusValues;
	}

	// private String strItemNameCombo = "";

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
	 * @param strStockStatus
	 *            the new str stock status
	 */
	public void setStrStockStatus(String strStockStatus) {
		this.strStockStatus = strStockStatus;
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
	 * @param strSuppliedBy
	 *            the new str supplied by
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
	 * @param strSuppliedByValues
	 *            the new str supplied by values
	 */
	public void setStrSuppliedByValues(String strSuppliedByValues) {
		this.strSuppliedByValues = strSuppliedByValues;
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
	 * @param strSubGroupId
	 *            the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
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
	 * @param strCtDate
	 *            the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
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
	 * @param strEffectiveFrom
	 *            the strEffectiveFrom to set
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
	 * @param strHospitalCode
	 *            the strHospitalCode to set
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
	 * @param strSeatId
	 *            the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
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
	 * @param strErr
	 *            the strErr to set
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
	 * @param strMsg
	 *            the strMsg to set
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
	 * @param strWarning
	 *            the strWarning to set
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
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
	 * @param strStoreId
	 *            the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
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
	 * @param strStoreName
	 *            the strStoreName to set
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
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
	 * @param strSubGroupCombo
	 *            the strSubGroupCombo to set
	 */
	public void setStrSubGroupCombo(String strSubGroupCombo) {
		this.strSubGroupCombo = strSubGroupCombo;
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
	 * @param strSubGroupCode
	 *            the strSubGroupCode to set
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
	 * @param strGroupId
	 *            the strGroupId to set
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
	 * @param strGroupName
	 *            the strGroupName to set
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
	 * @param strItemNameCombo
	 *            the new str item name combo
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
	 * @param strItemName
	 *            the new str item name
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
	 * @param strItemId
	 *            the new str item id
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
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
	 * @param strItemBrandCombo
	 *            the new str item brand combo
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
	 * @param strItemBrandName
	 *            the new str item brand name
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
	 * @param strItemBrandId
	 *            the new str item brand id
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
	 * @param strManufactureDate
	 *            the new str manufacture date
	 */
	public void setStrManufactureDate(String strManufactureDate) {
		this.strManufactureDate = strManufactureDate;
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
	 * @param strSalePrice
	 *            the strSalePrice to set
	 */
	public void setStrSalePrice(String strSalePrice) {
		this.strSalePrice = strSalePrice;
	}

	/**
	 * Sets the str po no.
	 * 
	 * @param strPoNo
	 *            the new str po no
	 */
	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
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
	 * @param strUnitCombo
	 *            the new str unit combo
	 */
	public void setStrUnitCombo(String strUnitCombo) {
		this.strUnitCombo = strUnitCombo;
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
	 * @param strManufactureId
	 *            the new str manufacture id
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
	 * @param strManufactureName
	 *            the new str manufacture name
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
	 * @param strManufactureCombo
	 *            the new str manufacture combo
	 */
	public void setStrManufactureCombo(String strManufactureCombo) {
		this.strManufactureCombo = strManufactureCombo;
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
	 * @param strUnitNameCombo
	 *            the new str unit name combo
	 */
	public void setStrUnitNameCombo(String strUnitNameCombo) {
		this.strUnitNameCombo = strUnitNameCombo;
	}

	/**
	 * Gets the str unit id.
	 * 
	 * @return the strUnitId
	 */
	public String getStrUnitId() {
		return strUnitId;
	}

	/**
	 * Sets the str unit id.
	 * 
	 * @param strUnitId
	 *            the strUnitId to set
	 */
	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
	}

	/**
	 * Gets the str unit name.
	 * 
	 * @return the strUnitName
	 */
	public String getStrUnitName() {
		return strUnitName;
	}

	/**
	 * Sets the str unit name.
	 * 
	 * @param strUnitName
	 *            the strUnitName to set
	 */
	public void setStrUnitName(String strUnitName) {
		this.strUnitName = strUnitName;
	}

	/**
	 * Gets the str module id.
	 * 
	 * @return the strModuleId
	 */
	public String getStrModuleId() {
		return strModuleId;
	}

	/**
	 * Sets the str module id.
	 * 
	 * @param strModuleId
	 *            the strModuleId to set
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
	 * @param strInHandQuantity
	 *            the strInHandQuantity to set
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
	 * @param strInHandQuantityUnitID
	 *            the strInHandQuantityUnitID to set
	 */
	public void setStrInHandQuantityUnitID(String strInHandQuantityUnitID) {
		this.strInHandQuantityUnitID = strInHandQuantityUnitID;
	}

	/**
	 * Gets the str unit id sale.
	 * 
	 * @return the strSlno
	 */

	/**
	 * @return the strUnitIdSale
	 */
	public String getStrUnitIdSale() {
		return strUnitIdSale;
	}

	/**
	 * Sets the str unit id sale.
	 * 
	 * @param strUnitIdSale
	 *            the strUnitIdSale to set
	 */
	public void setStrUnitIdSale(String strUnitIdSale) {
		this.strUnitIdSale = strUnitIdSale;
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
	 * @param strUnitNameSale
	 *            the strUnitNameSale to set
	 */
	public void setStrUnitNameSale(String strUnitNameSale) {
		this.strUnitNameSale = strUnitNameSale;
	}

	/**
	 * Gets the str unit name combo sale.
	 * 
	 * @return the strUnitNameComboSale
	 */
	public String getStrUnitNameComboSale() {
		return strUnitNameComboSale;
	}

	/**
	 * Sets the str unit name combo sale.
	 * 
	 * @param strUnitNameComboSale
	 *            the strUnitNameComboSale to set
	 */
	public void setStrUnitNameComboSale(String strUnitNameComboSale) {
		this.strUnitNameComboSale = strUnitNameComboSale;
	}

	/**
	 * Gets the str unit combo sale.
	 * 
	 * @return the strUnitComboSale
	 */
	public String getStrUnitComboSale() {
		return strUnitComboSale;
	}

	/**
	 * Sets the str unit combo sale.
	 * 
	 * @param strUnitComboSale
	 *            the strUnitComboSale to set
	 */
	public void setStrUnitComboSale(String strUnitComboSale) {
		this.strUnitComboSale = strUnitComboSale;
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
	 * @param strSubGroupName
	 *            the strSubGroupName to set
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
	 * @param strUnitRateID
	 *            the strUnitRateID to set
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
	 * @param strUnitRateName
	 *            the strUnitRateName to set
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
	 * @param strUnitRateCombo
	 *            the strUnitRateCombo to set
	 */
	public void setStrUnitRateCombo(String strUnitRateCombo) {
		this.strUnitRateCombo = strUnitRateCombo;
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
	 * @param strUnitSaleID
	 *            the strUnitSaleID to set
	 */
	public void setStrUnitSaleID(String strUnitSaleID) {
		this.strUnitSaleID = strUnitSaleID;
	}

	/**
	 * Gets the str unit sale name.
	 * 
	 * @return the strUnitSaleName
	 */
	public String getStrUnitSaleName() {
		return strUnitSaleName;
	}

	/**
	 * Sets the str unit sale name.
	 * 
	 * @param strUnitSaleName
	 *            the strUnitSaleName to set
	 */
	public void setStrUnitSaleName(String strUnitSaleName) {
		this.strUnitSaleName = strUnitSaleName;
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
	 * @param strUnitSaleCombo
	 *            the strUnitSaleCombo to set
	 */
	public void setStrUnitSaleCombo(String strUnitSaleCombo) {
		this.strUnitSaleCombo = strUnitSaleCombo;
	}

	/**
	 * Gets the str chk.
	 * 
	 * @return the strChk
	 */
	public String getStrChk() {
		return strChk;
	}

	/**
	 * Sets the str chk.
	 * 
	 * @param strChk
	 *            the strChk to set
	 */
	public void setStrChk(String strChk) {
		this.strChk = strChk;
	}

	/**
	 * Gets the str item category no.
	 * 
	 * @return the strItemCategoryNo
	 */
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}

	/**
	 * Sets the str item category no.
	 * 
	 * @param strItemCategoryNo
	 *            the strItemCategoryNo to set
	 */
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
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
	 * @param strRate
	 *            the strRate to set
	 */
	public void setStrRate(String strRate) {
		this.strRate = strRate;
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
	 * @param strInHandQuantityUnitName
	 *            the strInHandQuantityUnitName to set
	 */
	public void setStrInHandQuantityUnitName(String strInHandQuantityUnitName) {
		this.strInHandQuantityUnitName = strInHandQuantityUnitName;
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
	 * @param strBillNo
	 *            the strBillNo to set
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
	 * @param strBillDate
	 *            the strBillDate to set
	 */
	public void setStrBillDate(String strBillDate) {
		this.strBillDate = strBillDate;
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
	 * @param strItemSpecification
	 *            the new str item specification
	 */
	public void setStrItemSpecification(String strItemSpecification) {
		this.strItemSpecification = strItemSpecification;
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
	 * @param strRegFlag
	 *            the new str reg flag
	 */
	public void setStrRegFlag(String strRegFlag) {
		this.strRegFlag = strRegFlag;
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
	 * @param strConfigIssueRate
	 *            the new str config issue rate
	 */
	public void setStrConfigIssueRate(String strConfigIssueRate) {
		this.strConfigIssueRate = strConfigIssueRate;
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
	 * @param strIssueRateConfigFlg
	 *            the new str issue rate config flg
	 */
	public void setStrIssueRateConfigFlg(String strIssueRateConfigFlg) {
		this.strIssueRateConfigFlg = strIssueRateConfigFlg;
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
	 * @param strExistingBatchId
	 *            the new str existing batch id
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
	 * @param strExistingBatchCombo
	 *            the new str existing batch combo
	 */
	public void setStrExistingBatchCombo(String strExistingBatchCombo) {
		this.strExistingBatchCombo = strExistingBatchCombo;
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
	 * @param strActiveQty
	 *            the new str active qty
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
	 * @param strInActiveQty
	 *            the new str in active qty
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
	 * @param strQuarantineQty
	 *            the new str quarantine qty
	 */
	public void setStrQuarantineQty(String strQuarantineQty) {
		this.strQuarantineQty = strQuarantineQty;
	}

	/**
	 * Gets the str batch exist supp batch in stock flg.
	 * 
	 * @return the str batch exist supp batch in stock flg
	 */
	public String getStrBatchExistSuppBatchInStockFlg() {
		return strBatchExistSuppBatchInStockFlg;
	}

	/**
	 * Sets the str batch exist supp batch in stock flg.
	 * 
	 * @param strBatchExistSuppBatchInStockFlg
	 *            the new str batch exist supp batch in stock flg
	 */
	public void setStrBatchExistSuppBatchInStockFlg(
			String strBatchExistSuppBatchInStockFlg) {
		this.strBatchExistSuppBatchInStockFlg = strBatchExistSuppBatchInStockFlg;
	}

	/**
	 * Gets the str multi row item id.
	 * 
	 * @return the str multi row item id
	 */
	public String[] getStrMultiRowItemId() {
		return strMultiRowItemId;
	}

	/**
	 * Sets the str multi row item id.
	 * 
	 * @param strMultiRowItemId
	 *            the new str multi row item id
	 */
	public void setStrMultiRowItemId(String[] strMultiRowItemId) {
		this.strMultiRowItemId = strMultiRowItemId;
	}

	/**
	 * Gets the str multi row existing batch id.
	 * 
	 * @return the str multi row existing batch id
	 */
	public String[] getStrMultiRowExistingBatchId() {
		return strMultiRowExistingBatchId;
	}

	/**
	 * Sets the str multi row existing batch id.
	 * 
	 * @param strMultiRowExistingBatchId
	 *            the new str multi row existing batch id
	 */
	public void setStrMultiRowExistingBatchId(
			String[] strMultiRowExistingBatchId) {
		this.strMultiRowExistingBatchId = strMultiRowExistingBatchId;
	}

	/**
	 * Gets the str multi row final batch no.
	 * 
	 * @return the str multi row final batch no
	 */
	public String[] getStrMultiRowFinalBatchNo() {
		return strMultiRowFinalBatchNo;
	}

	/**
	 * Sets the str multi row final batch no.
	 * 
	 * @param strMultiRowFinalBatchNo
	 *            the new str multi row final batch no
	 */
	public void setStrMultiRowFinalBatchNo(String[] strMultiRowFinalBatchNo) {
		this.strMultiRowFinalBatchNo = strMultiRowFinalBatchNo;
	}

	/**
	 * Gets the str multi row active qty.
	 * 
	 * @return the str multi row active qty
	 */
	public String[] getStrMultiRowActiveQty() {
		return strMultiRowActiveQty;
	}

	/**
	 * Sets the str multi row active qty.
	 * 
	 * @param strMultiRowActiveQty
	 *            the new str multi row active qty
	 */
	public void setStrMultiRowActiveQty(String[] strMultiRowActiveQty) {
		this.strMultiRowActiveQty = strMultiRowActiveQty;
	}

	/**
	 * Gets the str multi row quarn qty.
	 * 
	 * @return the str multi row quarn qty
	 */
	public String[] getStrMultiRowQuarnQty() {
		return strMultiRowQuarnQty;
	}

	/**
	 * Sets the str multi row quarn qty.
	 * 
	 * @param strMultiRowQuarnQty
	 *            the new str multi row quarn qty
	 */
	public void setStrMultiRowQuarnQty(String[] strMultiRowQuarnQty) {
		this.strMultiRowQuarnQty = strMultiRowQuarnQty;
	}

	/**
	 * Gets the str multi row in active qty.
	 * 
	 * @return the str multi row in active qty
	 */
	public String[] getStrMultiRowInActiveQty() {
		return strMultiRowInActiveQty;
	}

	/**
	 * Sets the str multi row in active qty.
	 * 
	 * @param strMultiRowInActiveQty
	 *            the new str multi row in active qty
	 */
	public void setStrMultiRowInActiveQty(String[] strMultiRowInActiveQty) {
		this.strMultiRowInActiveQty = strMultiRowInActiveQty;
	}

	/**
	 * Gets the str multi row rate.
	 * 
	 * @return the str multi row rate
	 */
	public String[] getStrMultiRowRate() {
		return strMultiRowRate;
	}

	/**
	 * Sets the str multi row rate.
	 * 
	 * @param strMultiRowRate
	 *            the new str multi row rate
	 */
	public void setStrMultiRowRate(String[] strMultiRowRate) {
		this.strMultiRowRate = strMultiRowRate;
	}

	/**
	 * Gets the str multi row rate unit id.
	 * 
	 * @return the str multi row rate unit id
	 */
	public String[] getStrMultiRowRateUnitId() {
		return strMultiRowRateUnitId;
	}

	/**
	 * Sets the str multi row rate unit id.
	 * 
	 * @param strMultiRowRateUnitId
	 *            the new str multi row rate unit id
	 */
	public void setStrMultiRowRateUnitId(String[] strMultiRowRateUnitId) {
		this.strMultiRowRateUnitId = strMultiRowRateUnitId;
	}

	/**
	 * Gets the str multi row expiry date.
	 * 
	 * @return the str multi row expiry date
	 */
	public String[] getStrMultiRowExpiryDate() {
		return strMultiRowExpiryDate;
	}

	/**
	 * Sets the str multi row expiry date.
	 * 
	 * @param strMultiRowExpiryDate
	 *            the new str multi row expiry date
	 */
	public void setStrMultiRowExpiryDate(String[] strMultiRowExpiryDate) {
		this.strMultiRowExpiryDate = strMultiRowExpiryDate;
	}

	/**
	 * Gets the str multi row mfg date.
	 * 
	 * @return the str multi row mfg date
	 */
	public String[] getStrMultiRowMfgDate() {
		return strMultiRowMfgDate;
	}

	/**
	 * Sets the str multi row mfg date.
	 * 
	 * @param strMultiRowMfgDate
	 *            the new str multi row mfg date
	 */
	public void setStrMultiRowMfgDate(String[] strMultiRowMfgDate) {
		this.strMultiRowMfgDate = strMultiRowMfgDate;
	}

	/**
	 * Gets the str multi row supplier id.
	 * 
	 * @return the str multi row supplier id
	 */
	public String[] getStrMultiRowSupplierId() {
		return strMultiRowSupplierId;
	}

	/**
	 * Sets the str multi row supplier id.
	 * 
	 * @param strMultiRowSupplierId
	 *            the new str multi row supplier id
	 */
	public void setStrMultiRowSupplierId(String[] strMultiRowSupplierId) {
		this.strMultiRowSupplierId = strMultiRowSupplierId;
	}

	/**
	 * Gets the str multi row mfg id.
	 * 
	 * @return the str multi row mfg id
	 */
	public String[] getStrMultiRowMfgId() {
		return strMultiRowMfgId;
	}

	/**
	 * Sets the str multi row mfg id.
	 * 
	 * @param strMultiRowMfgId
	 *            the new str multi row mfg id
	 */
	public void setStrMultiRowMfgId(String[] strMultiRowMfgId) {
		this.strMultiRowMfgId = strMultiRowMfgId;
	}

	/**
	 * Gets the str multi row po no.
	 * 
	 * @return the str multi row po no
	 */
	public String[] getStrMultiRowPONo() {
		return strMultiRowPONo;
	}

	/**
	 * Sets the str multi row po no.
	 * 
	 * @param strMultiRowPONo
	 *            the new str multi row po no
	 */
	public void setStrMultiRowPONo(String[] strMultiRowPONo) {
		this.strMultiRowPONo = strMultiRowPONo;
	}

	/**
	 * Gets the str multi row tender no.
	 * 
	 * @return the str multi row tender no
	 */
	public String[] getStrMultiRowTenderNo() {
		return strMultiRowTenderNo;
	}

	/**
	 * Sets the str multi row tender no.
	 * 
	 * @param strMultiRowTenderNo
	 *            the new str multi row tender no
	 */
	public void setStrMultiRowTenderNo(String[] strMultiRowTenderNo) {
		this.strMultiRowTenderNo = strMultiRowTenderNo;
	}

	/**
	 * Gets the str programme combo.
	 * 
	 * @return the str programme combo
	 */
	public String getStrProgrammeCombo() {
		return strProgrammeCombo;
	}

	/**
	 * Sets the str programme combo.
	 * 
	 * @param strProgrammeCombo
	 *            the new str programme combo
	 */
	public void setStrProgrammeCombo(String strProgrammeCombo) {
		this.strProgrammeCombo = strProgrammeCombo;
	}

	/**
	 * Gets the str programme id.
	 * 
	 * @return the str programme id
	 */
	public String getStrProgrammeId() {
		return strProgrammeId;
	}

	/**
	 * Sets the str programme id.
	 * 
	 * @param strProgrammeId
	 *            the new str programme id
	 */
	public void setStrProgrammeId(String strProgrammeId) {
		this.strProgrammeId = strProgrammeId;
	}

	public String getStrIsDataSaveFlg() {
		return strIsDataSaveFlg;
	}

	public void setStrIsDataSaveFlg(String strIsDataSaveFlg) {
		this.strIsDataSaveFlg = strIsDataSaveFlg;
	}

	public String getStrSavedDrugName() {
		return strSavedDrugName;
	}

	public void setStrSavedDrugName(String strSavedDrugName) {
		this.strSavedDrugName = strSavedDrugName;
	}

	public String getStrSavedBatchName() {
		return strSavedBatchName;
	}

	public void setStrSavedBatchName(String strSavedBatchName) {
		this.strSavedBatchName = strSavedBatchName;
	}

	public String getStrSelDrugName() {
		return strSelDrugName;
	}

	public void setStrSelDrugName(String strSelDrugName) {
		this.strSelDrugName = strSelDrugName;
	}

	public String getStrProgrammeName() {
		return strProgrammeName;
	}

	public void setStrProgrammeName(String strProgrammeName) {
		this.strProgrammeName = strProgrammeName;
	}

	public String getStrSelBatch() {
		return strSelBatch;
	}

	public void setStrSelBatch(String strSelBatch) {
		this.strSelBatch = strSelBatch;
	}

	public String getStrPath() {
		return strPath;
	}

	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}

	public String getStrStoreTypeFlag() {
		return strStoreTypeFlag;
	}

	public void setStrStoreTypeFlag(String strStoreTypeFlag) {
		this.strStoreTypeFlag = strStoreTypeFlag;
	}

	public String[] getStrMultiRowPurRate() {
		return strMultiRowPurRate;
	}

	public void setStrMultiRowPurRate(String[] strMultiRowPurRate) {
		this.strMultiRowPurRate = strMultiRowPurRate;
	}

	public WebRowSet getWsItemDetails() {
		return wsItemDetails;
	}

	public void setWsItemDetails(WebRowSet wsItemDetails) {
		this.wsItemDetails = wsItemDetails;
	}

	public String getPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(String printFlag) {
		this.printFlag = printFlag;
	}

	public String getVoucherString() {
		return voucherString;
	}

	public void setVoucherString(String voucherString) {
		this.voucherString = voucherString;
	}

	public String getTotalBatchNumber() {
		return totalBatchNumber;
	}

	public void setTotalBatchNumber(String totalBatchNumber) {
		this.totalBatchNumber = totalBatchNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
       	

}
